/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0008.js
*@FileTitle : Budget Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.29 김진일
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
     * @class vop_pso_0008 : vop_pso_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0008() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
	var comboObjects = new Array();
	var comboCnt = 0;
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
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		document.form.scn_cd.Code = "BP";
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
		
					var HeadTitle1 = "|Seq|Scenario|Target VVD|Rev Lane|Rev Month|CAPA|Budget\nCreation ID|Budget\nCreation Date";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "sheet1_";
		
					//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		prefix+"seq" );
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"scnr_no",		false,		"",			dfDateYm,		0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		prefix+"vvd",			false,		"",			dfNone,			0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"rlane_cd",		false,		"",			dfNone,			0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"mon",			false,		"",			dfDateYm,		0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,		prefix+"capa",			false,		"",			dfNullInteger,	0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"cre_usr_id",	false,		"",			dfNone,			0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"cre_dt",		false,		"",			dfNone,			0,		true,  		true);
		
					CountPosition = 2;
					ShowButtonImage = 1;
					HeadRowHeight = gHeadRowHeight;
					
					//InitDataValid(0, prefix+"formula_no", vtNumericOnly);	//숫자만 입력
				}
				break;
				
		  	case "sheet2":
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
		
					var HeadTitle1 = "|Seq|Scenario|Currency|USD Rate";
					var headCount = ComCountHeadTitle(HeadTitle1);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);
		
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					var prefix = "sheet2_";
		
					//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
					InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		prefix+"seq" );
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		prefix+"scnr_no",			false,		"",			dfDateYm,			0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		prefix+"locl_curr_cd",		false,		"",			dfNone,			0,		true,  		true);
					InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,		prefix+"usd_xch_rt",		false,		"",			dfNullFloat,			3,		true,  		true);
		
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
    	 axon_event.addListener ('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
     	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
     	axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
     	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    	//budget year필드를 올해로 설정
    	//alert(setToday("y"));
    	setToday(document.form.year, "y");//올해 설정
    	document.form.txtsDate.value = document.form.year.value +"-01"; 
    	document.form.txteDate.value = document.form.year.value +"-12"; 
    }
     function obj_keydown(){
       	isShift = event.shiftKey ? true : false;
//       	ComKeyEnter();
       }
     /**
      * onBlur처리 
      * @return
      */
     function obj_blur(){
    	  var formObj = document.form;
    	   	 obj = event.srcElement;      	
    	   	 
    	   	 with(formObj){
    	   		 if(obj.name=="txtsDate" || obj.name=="txteDate"){
    	   			 var creDtFr = ComReplaceStr(txtsDate.value,"-","");
    	   			 var creDtTo = ComReplaceStr(txteDate.value,"-","");
    		        	
    	   			 switch(obj.name) {
    		    	    	case "txtsDate":	// Agreement From Date
    		    	    		if(creDtFr != '' && creDtTo != ''){
    		    	    			if(creDtFr > creDtTo){
    		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    		    	    				txtsDate.value='';
    		    	    				document.form.txtsDate.focus();
    		    	    				return false;
    		    	    			}
    		    	    		}
    		    	    			
    		    	            break;
    		    	            
    		    	    	case "txteDate":	// Agreement To Date
    		    	    		if(creDtFr != '' && creDtTo != ''){
    		    	    			if(creDtFr > creDtTo){
    		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
    		    	    				txteDate.value='';
    		    	    				txteDate.focus();
    		    	    				return false;
    		    	    			}
    		    	    		}
    		    	           	break;	
    		        	}
    		        
    	   			ComChkObjValid(event.srcElement);
    	   		 }
    	       }
    	       return true;	
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
  	        case "y":
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
  	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
  	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
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
		
		if(event.keyCode === 9 || isShift ){
//			alert(event.keyCode);
			return true;
		}
		
		switch (eleObj.name) {
		case "ofc_cd":
			if (eleObj.value.length == 6) {
				formObj.vndr_cnt_cd.focus();
			}
			break;
		case "vndr_cnt_cd":
			if (eleObj.value.length == 2) {
				formObj.vndr_lgl_eng_nm.focus();
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
             var sheetObject2 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
	                case "btns_calendar_s":
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	    	            cal.select(form.txtsDate, "yyyy-MM");
	                	break;
	                case "btns_calendar_e":
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.select(form.txteDate, "yyyy-MM");
	                	break;
					case "btns_calendarsn":
						var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.select(form.scn_dt, 'yyyy');
						break;	                	
                	case "btn_creation":
    					if(!ComShowCodeConfirm("PSO00041", "create")){
    						return;
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
		            case "btn_down_excel":
						 if(sheetObjects[0].RowCount == 0 && sheetObjects[1].RowCount == 0){
							 return;
						 }

						 var paramObj = new Object();
						 paramObj.title  = "Budget Creation"
						 	 			 + "\\n(Month : " + formObject.txtsDate.value + " ~ " + formObject.txteDate.value + ")";
						 //paramObj.cols = "6";
						 var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);  
						 
						 if(sheetObjects[0].RowCount == 0){
							 showCol4ExcelDown("sheet1_");
							 sheetObjects[2].SpeedDown2Excel(-1, false, false, "", url);
						 } else{
							 sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url);
						 }
						 
						 if(sheetObjects[1].RowCount == 0){
							 showCol4ExcelDown("sheet2_");
							 sheetObjects[2].SpeedDown2Excel(-1, true);
						 } else{
							 sheetObjects[1].SpeedDown2Excel(-1, true);
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
         *  Sheet관련 프로세스 처리
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg = false;
             sheetObj.WaitImageVisible=false;
             switch(sAction) {
             	case IBCREATE://Creation Button Click 시 처리
             		if ( sheetObj.id == "sheet1"){
             			ComOpenWait(true);
						//formObj.f_cmd.value = COMMAND01;	//[2010.05.12:jmh]
						formObj.f_cmd.value = ADD;		//[2010.05.12:jmh]
						var sXml = sheetObj.GetSearchXml("VOP_PSO_0008GS.do", FormQueryString(formObj));
						sheetObjects[0].LoadSearchXml(sXml);
						ComOpenWait(false);
						var statusCode = ComGetEtcData(sXml, "BatchStatus" );
						switch(statusCode){
//							case "0": //일단 H/C
							case "4"://작업실행완료
								ComShowCodeMessage("COM12116", "Budget Creation  Excution");
								break;
							case "5"://
								ComShowCodeMessage("COM12151", "Budget Creation  Excution");
								break;
							case "6"://해당 작업이 진행 중 
								formObj.status.value = "Processing";
								ComShowCodeMessage("PSO00038", "Budget Creation");
								break;
							default: break;							
						}
             		}
             		break;
             		
             	case IBSEARCH:      //조회
 					if(validateForm(sheetObj,formObj,sAction)){
 						if ( sheetObj.id == "sheet1"){
 							var aryPrefix = new Array("sheet1_", "sheet2_");
 							formObj.f_cmd.value = SEARCH;
 			                
 			                sheetObjects[0].WaitImageVisible = false;
 			                var sXml = sheetObj.GetSearchXml("VOP_PSO_0008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
 			                var arrXml = sXml.split("|$$|");
 			                var isRunning = ComGetEtcData(arrXml[0], "IS_RUNNING");
 			                formObj.status.value = isRunning == "true" ? "Processing" : "";
 			                sheetObjects[0].LoadSearchXml(arrXml[0]);
 			                sheetObjects[1].LoadSearchXml(arrXml[1]);
 						}
 					}
 					break;
 					
             	case IBSEARCH_ASYNC01:      //OPEN (Check Running Batch)
         			var aryPrefix = new Array("sheet1_");
         			formObj.f_cmd.value = COMMAND02;
         			
         			sheetObjects[0].WaitImageVisible = false;
         			var sXml = sheetObj.GetSearchXml("VOP_PSO_0008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
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
			var scn_dt = formObj.scn_dt;
			var scn_cd = formObj.scn_cd;
			var fm_dt = formObj.txtsDate;
			var to_dt = formObj.txteDate;
			
			
			with (formObj) {
				if (ComIsNull(scn_dt) || ComChkLen(scn_dt, 4) == 1  || ComIsNull(scn_cd.Code) || ComIsNull(fm_dt) || ComIsNull(to_dt)) {
					return false;
				}
			}
            return true;
        }

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}
        
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
    switch(comboObj.id) {
    	case "scn_cd":
    		with (comboObj) { 
				MultiSelect = false;
				DropHeight = 320;
				InsertItem(0, 'BP','BP');
				InsertItem(1, 'PR','PR');
				InsertItem(2, 'Q1','Q1');
				InsertItem(3, 'Q2','Q2');
				InsertItem(4, 'Q3','Q3');
				InsertItem(5, 'Q4','Q4');
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 2;
			}
			break;
     }
}

        /**
         * 
         * <pre>
         *    Excel Title 
         * </pre>
         *
         * @param   sheetObj
         * @param   paramObj
         *          - Attribute : title         : 제목명          (default : 화면제목명);
         *                      : align         : Title 가로 정렬 {"center", "left", "right"}, (default:center)
         *                      : cols          : 타이틀 칼럼수   (default : Sheet Cols수(단, hidden Type 제외 )
         *                      : orientation   : 용지방향        {Landscape,Portrait}(default : Landscape )
         *                      : columnwidth   : 특정 Col Width  (default : 자동) ex)지정필요시, 3 col 30, 4 col 50 일때, 3:30|4:50 
         *                      : datarowheight : 특정 Row Height (default : 20) ex)지정필요시, 3 Row 30, 4 Row 50 일때, 3:30|4:50
         *                                        양식 타이틀이 아닌, 그리드 타이틀부터 1, ex2)그리드 타이틀 row Height을 50으로 변경시
         *                                        paramObj.datarowheight="1:50"
         * @author jang kang cheol
         */
         function ComJooGetPgmTitle(sheetObj, paramObj){
            var doc   = document.all;
            var pageUrl = "FNS_JOO_EXCEL.do?";
            
            /*************************** 제목처리 **********************************/
            var sTitle = "";
            /*************************** 정렬처리 **********************************/
            var sTalign = "center,left,right";
            var sAlign = "";
            /*************************** Col수 처리 **********************************/
            var sCols  = "";
            var iCols = 0;
            /*************************** 용지방향 처리 **********************************/        
            var sOrientation = "";

            /*************************** 특정지정 컬럼들 width 처리 **********************************/        
            var sColumnwidth = "";

            /*************************** 특정지정 Row 들 Height 처리 **********************************/        
            var sDatarowheight = "";
            
            
            if(paramObj.title == undefined ){
                sTitle     = doc.title.innerHTML.replace("&nbsp;","");
                sTitle     = sTitle.replace("&amp;"," ");
            }else{
                sTitle     = paramObj.title;
            }
            if(paramObj.align == undefined ){
                sAlign="center"; 
            }else if(sTalign.indexOf(paramObj.align) == -1 ){
                sAlign = "left";
            }else{
                sAlign = paramObj.align;
            }
            if(paramObj.cols == undefined ){
                for(var i=0; i<= sheetObj.LastCol; i++){
                    if ( sheetObj.ReadDataProperty(0, i, dpDataType) != dtHidden 
                         && 
                         sheetObj.ReadDataProperty(0, i, dpDataType) != dtHiddenStatus
                       ){
                        iCols++;
                    }
                }
            }else{
                iCols = eval(paramObj.cols);
            }

            if(paramObj.orientation == undefined ){
                sOrientation = "Landscape";
            }else{
                sOrientation = paramObj.orientation;
            }
            
            if(paramObj.columnwidth == undefined ){
                sColumnwidth = "";
            }else{
                sColumnwidth = paramObj.columnwidth;
            }
            
            if(paramObj.datarowheight == undefined ){
                sDatarowheight = "";
            }else{
                sDatarowheight = paramObj.datarowheight;
            }        

            var sUrl = pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
            return sUrl;
         }      
	/* 개발자 작업  끝 */