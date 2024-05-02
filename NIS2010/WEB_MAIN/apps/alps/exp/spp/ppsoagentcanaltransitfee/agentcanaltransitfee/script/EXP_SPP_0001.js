/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0001.js
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.15 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
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
     * @class EXP_SPP_0001 : EXP_SPP_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0001() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_activate 			= obj_activate;
    	this.obj_change 			= obj_change;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_ComboSetting 	= sheet1_ComboSetting;
    	this.getComboTextCode 		= getComboTextCode;
    	this.sheet1_OnClick 		= sheet1_OnClick;
    	this.setVVDStatus 			= setVVDStatus;
    	this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;

    }

   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var LANE = "vendor";
    var VVD = "vvd";
    var VVDETC = "vvd_etc";
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var MC_TAB = "\t";  //Multi Combo 를 위한 tab 키값
    var SearchRecCnt = 0;  //초기 조회된 레코드 수.
    var GlobalRevYr = "";  //캘린더 선택시 revyr 오브젝트에 change 이벤트가 발생하지 않는 문제 해결을 위해. 
    				  	   //focus 위치시 값을 저장해놓고
                           //blur 시 이전값과 비교해서 change 이벤트 임의 발생시킴.
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];
             var comboObject1 = comboObjects[0]; 

             /*******************************************************/
             var formObject = document.form;

        
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	            	  case "btn_Add":
	            	  		doActionIBSheet(sheetObject1,formObject,IBINSERT);
	            	  		break;
	            	  		
	            	  case "btn_Delete":
	            		  	ComRowDelete(sheetObject1,"sheet1_del_chk");
	    					break;
	    					
	            	  case "btn_New":  //검색조건,그리드초기화
			  				// 초기화하시겠습니까?
			  				if(!ComCodeMsgByInitialize()) return;
			  				ComResetAll();	 
	            	  		setToday(document.form.revyr, "y");
	            	  		setToday(document.form.revmon, "m");
	            	  		setToday(document.form.revyrmon, "ym");
	            	  		GlobalRevYr = document.form.revyr.value;
	            	  		break;
	            	  		
	            	  case "btn_Retrieve": 
			        	  	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;
							
			          case "btns_calendar":
			        	  GlobalRevYr = document.form.revyr.value;  //캘린더이미지버튼 클릭 시 GlobalRevYr 에 이전년 값 셋팅을 위해.
			        	  //openCalendar("y", document.form.revyr);
			        	  var cal = new ComCalendar();
	        	          cal.setDisplayType('year');
	        	          cal.select(formObject.revyr, 'yyyy');
	        	     
			        	  break;
	            } // end switch
        	
        }

        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }
         
        /** 
         * IBCombo Object를 배열로 등록
         * param : combo_obj ==> 콤보오브젝트
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
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
            for(i=0;i<sheetObjects.length;i++){

            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i]);
                //sheet초기화
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            initControl();
        }
         
        /**
         * Form데이터포멧 키 프레스 관련 
         */
        function initControl() {
               //- form 전체 컨트롤 중  모든 컨트롤의 OnKeyPress이벤트에 코드 처리        	 
               axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
               //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리               
               axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
               //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
               axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
  			   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyUp 이벤트에 코드 처리
  			   axon_event.addListenerFormat('keyup', 'obj_keyup',    		form);               
               
               //캘린더 선택시 revyr 오브젝트에 change 이벤트가 발생하지 않는 문제 해결을 위해. GlobalRevYr 전역변수사용.
               //axon_event.addListener('change',   'obj_change',  'revyr');
               axon_event.addListener('change',   'obj_change',  'revmon');
               
               //Today Setting ..
   	  		   setToday(document.form.revyr, "y");
   	  		   setToday(document.form.revmon, "m");
   	  		   setToday(document.form.revyrmon, "ym");
   	  		   GlobalRevYr = document.form.revyr.value;
               //focusSetting
   	  		   document.form.revyr.focus();
      	 }
           
          /*
           * OnBlur 이벤트에 코드 처리
           */
          function obj_deactivate(){
        	   obj = event.srcElement;
               if(ComChkObjValid(event.srcElement)){
	           	   if(obj.name=="revyr"){  //캘린더에서 날짜 선택시 onchange 이벤트 발생되지 않아 수동으로 처리함.
	        		   if(GlobalRevYr != document.form.revyr.value){
	        			   obj_change();
	        			   GlobalRevYr = document.form.revyr.value;
	        		   }
	        		   return; 
	        	   }
               }
          }
         
         /*
          * OnKeyUp 이벤트에 코드 처리
          */ 
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "revyr":
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
        		       break;
        		   default:
        			   break;
        	   }
         }          

          /*
           * OnFocus 이벤트에 코드 처리
           */
          function obj_activate(){
        	   obj = event.srcElement;
               ComClearSeparator(event.srcElement);
               ComShowFocusCursor(obj);  //특정 event 로 인해서 사라진 포커스를 보여줌.
          } 
          
          /*
           * OnChange 이벤트에 코드 처리
           */
          function obj_change(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "revyr":
        	       case "revmon":	   
        	    	   sheetObjects[0].RemoveAll();
        	    	   document.form.revyrmon.value = document.form.revyr.value + document.form.revmon.value;
        	    	   document.form.vvdstatus.value = "";
        		       break;
        		   default:
        			   break;
        	   }
          }          

          /*
           * OnKeyPress 이벤트에 코드 처리
           */
          function obj_keypress(){
       	    obj = event.srcElement;
       	    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     	    
       	    if(obj.dataformat == null) return;
     	    
     	    if(keyValue == 13 ){
     	    	//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
     	    	var formObject = document.form;

         	  	if(formObject.revyr.value == "" || formObject.revyr.value == undefined){
         	  		ComShowCodeMessage("COM12114", "Year");  //Please check {?msg1}
         	  		formObject.revyr.focus();
         	  		return;
         	  	}
         	  	if(formObject.revmon.value == "" || formObject.revmon.value == undefined){
         	  		ComShowCodeMessage("COM12113", "Canal Transit  List  working Month");  //Please select {?msg1}  
         	  		formObject.revmon.focus();
         	  		return;
         	  	}        	  	
         	  	
         	  	//IBCOMBO에 설정된 값을 vndr_seq파라미터에 셋팅한다.
         	  	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        	  	
     	    	return true ;
     	    }
     	    
       	    window.defaultStatus = obj.dataformat;
       	
       	    switch(obj.dataformat) {
       	    	case "yyyy":
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
       	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
       	            else ComKeyOnlyAlphabet('upper');
       	            break;
       	        case "engdn":
       	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	            else ComKeyOnlyAlphabet('lower');
       	            break;
       	    }
       	}
          
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 400;

    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Sel.|Pay To|VVD|Vessel|VesselNm|Voyage|Direction|Lane|Transit Date|Payable Due\nDate|Advance Payment\nStatus|ADV Payment\nRev.Month|Invoice\nStatus|Invoice\nRev.Month|MSA|Result|vnderSEq|eSeq|iSeq|ydCd|vndrCntCd|VVD ETC|Port Status";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							/*mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) */
    							InitHeadMode(false, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							var prefix = "sheet1_";
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pay_to",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vvd",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtComboEdit,	160,	daCenter,	true,		prefix+"vsl_cd",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_nm",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"skd_voy_no",	false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"skd_dir_cd",	false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		prefix+"lane",			false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"trns_dt",		false,		"",	dfDateYmd,	0,		false,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"py_due_dt",		false,		"",	dfDateYmd,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		120,	daCenter,	true,		prefix+"adv_py_sts",	false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"adv_py_rev_mon",false,		"",	dfDateYm,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		100,	daCenter,	true,		prefix+"inv_sts",		false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"inv_rev_mon",	false,		"",	dfDateYm,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		100,	daCenter,	true,		prefix+"msa",			false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"rslt",			false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"vndr_seq",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"eseq",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"iseq",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"yd_cd",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"vndr_cnt_cd",	false,		"",	dfNone,		0,		false,	true);
    							
    							//VVD List 조회 시 trns_dt, py_due_dt, adv_py_sts, adv_py_rev_mon 처리를 위한 임의 설정
    							InitDataProperty(0, cnt++ , dtComboEdit,	85,		daCenter,	true,		prefix+"vvd_etc",		false,		"",	dfDateYmd,	0,		false,	true);
    							
    							//VVD Port Skip
    							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"port_skip_sts",	false,		"",	dfNone,		0,		false,	true);
    							
    							//InitDataCombo(0, prefix+"vsl_cd", "| |한화콘도|한국콘도|글로리콘도|삼립하일라|두산콘도","| |101|105|110|115|120");
    							InitComboNoMatchText(true);  //존재하지 않는 콤보 코드의 경우 그대로 표시
    							sheetObj.ColHidden(prefix+"vvd_etc") = true;  //vvd_etc 컬럼의 숨김 처리
    							
    							ImageList(0)   = "img/blank.gif";
    							ImageList(01)  = "img/btng_ready1.gif";			// Ready
    							ImageList(02)  = "img/btng_ready2.gif";			// Ready
    							ImageList(03)  = "img/btng_ready3.gif";			// Ready
    							ImageList(04)  = "img/btng_ready4.gif";			// Ready
    							ImageList(05)  = "img/btng_ready5.gif";			// Ready
    							ImageList(06)  = "img/btng_ready6.gif";			// Ready
    							ImageList(07)  = "img/btng_ready7.gif";			// Ready
    							ImageList(08)  = "img/btng_ready8.gif";			// Ready
    							ImageList(09)  = "img/btng_ready9.gif";			// Ready
    							
    							
    							ImageList(10)  = "img/blank.gif";
    							ImageList(11)  = "img/btng_requested1.gif";		// Requested
    							ImageList(12)  = "img/btng_requested2.gif";		// Requested
    							ImageList(13)  = "img/btng_requested3.gif";		// Requested
    							ImageList(14)  = "img/btng_requested4.gif";		// Requested
    							ImageList(15)  = "img/btng_requested5.gif";		// Requested
    							ImageList(16)  = "img/btng_requested6.gif";		// Requested
    							ImageList(17)  = "img/btng_requested7.gif";		// Requested
    							ImageList(18)  = "img/btng_requested8.gif";		// Requested
    							ImageList(19)  = "img/btng_requested9.gif";		// Requested
    							
    							ImageList(20)  = "img/blank.gif";
    							ImageList(21)  = "img/btng_approved.gif";		// Approved
    							ImageList(22)  = "img/btng_approved2.gif";		// Approved
    							ImageList(23)  = "img/btng_approved3.gif";		// Approved
    							ImageList(24)  = "img/btng_approved4.gif";		// Approved
    							ImageList(25)  = "img/btng_approved5.gif";		// Approved
    							ImageList(26)  = "img/btng_approved6.gif";		// Approved
    							ImageList(27)  = "img/btng_approved7.gif";		// Approved
    							ImageList(28)  = "img/btng_approved8.gif";		// Approved
    							ImageList(29)  = "img/btng_approved9.gif";		// Approved
    							
    							ImageList(30)  = "img/blank.gif";
    							ImageList(31)  = "img/btng_paid.gif";			// Paid
    							ImageList(32)  = "img/btng_ready.gif";			// Disable Ready
    						}
    						break;
    						
            }
        }

        /*
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
    	    var prefix = "sheet1_";
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

              case IBSEARCH:  //조회
              	formObj.f_cmd.value = SEARCH;
              
	      	  	//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
	      	  	if(formObj.revyr.value == "" || formObj.revyr.value == undefined){
	      	  		ComShowCodeMessage("COM12114", "Year");  //Please check {?msg1}
	      	  		formObj.revyr.focus();
	      	  		return;
	      	  	}
	      	  	if(formObj.revmon.value == "" || formObj.revmon.value == undefined){
	      	  		ComShowCodeMessage("COM12113", "Canal Transit  List  working Month");  //Please select {?msg1}  
	      	  		formObj.revmon.focus();
	      	  		return;
	      	  	}
	      	  	
	      	  	formObj.revyrmon.value = formObj.revyr.value + formObj.revmon.value;
	      	  	
       			sheetObj.DoSearch("EXP_SPP_0001GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));

       			//컬럼 값 복사(vsl_nm->vsl_cd). 조회된 건은 저장처리되지 않는다.
				sheetObj.Copy2SheetCol(sheetObj, prefix+"vsl_nm", prefix+"vsl_cd");               	
				SearchRecCnt = sheetObj.RowCount;//조회된 레코드 수 저장

        	  	//VVD Status 설정
        	  	setVVDStatus();       					
    			break;

    		  case IBINSERT:  //Row삽입
    			  
    		    var insertRowNo = 0;
    		    
    		    if(SearchRecCnt > 0){
    		    	
    		    	sheetObj.DataInsert(sheetObj.Rows-2);
    		    	insertRowNo = sheetObj.Rows-2;  //맨 마지막 이전 줄로 삽입됨.
    		    
    		    	sheetObj.CellValue2(insertRowNo, prefix+"rslt") = "ADD Row";
        		    sheetObj.CellValue2(insertRowNo, prefix+"adv_py_sts") = "0";  //이미지 ready
        		    sheetObj.CellValue2(insertRowNo, prefix+"inv_sts") = "0";  //이미지 ready
      		  		sheetObj.CellValue(insertRowNo, prefix+"trns_dt") = ComGetNowInfo();  //오늘날짜 셋팅. CellValue2 는 OnChange 이벤트가 발생하지 않음.
        		  	sheetObj.SelectCell(insertRowNo, prefix+"trns_dt");  //cell 선택
        		  	sheetObj.CellValue(insertRowNo, prefix+"vndr_cnt_cd") = formObj.vndr_cnt_cd.value;

    		    }
    		    
                break;
            }
        }
        
        /*
         * LoadSaveXml 후 OnSaveEnd 이벤트 발생
         */
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        	var formObj = document.form;
            
        }
         
        /*
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 var prefix = "sheet1_";
        	 switch(sAction){
	        	 default:
	             break;
        	 }
        	 return true;
        } 
        
        /**
        * sheet1 의 값이 변경되었을 때의 이벤트 처리
        */
        function sheet1_OnChange(sheetObj, Row, Col, Value){
    	    //alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
    	    var formObject = document.form;
    	    var prefix = "sheet1_";
    	    var strColSaveName = sheetObj.ColSaveName(Col);
			if(Value!==null && Value !== "undefined" && Value !== -1){
	        	switch(strColSaveName){
	        		case prefix+"trns_dt":
	        			checkeVVDMonthAddRow(sheetObj, Row, prefix);
	        			formObject.transymd.value = sheetObj.CellValue(Row, prefix+"trns_dt");
	        			sheet1_ComboSetting(sheetObj, Row, prefix+"vsl_cd");
	        			break;
	        			
	        		case prefix+"vsl_cd":
	        			var strVslCd = sheetObj.CellValue(Row, prefix+"vsl_cd");
	        			
	        			if(strVslCd!=""){
		        			//멀티콤보의 멀티텍스트 값에서 특정 값 추출
		        			var sText = sheetObj.GetComboInfo(Row, prefix+"vsl_cd", "Text");
		        			var arrText = sText.split(ROWMARK);
		        			var idx = sheetObj.GetComboInfo(Row, prefix+"vsl_cd", "SelectedIndex");
		        			var voyDir = arrText[idx].split(MC_TAB);
		        			var arrVvdEtc = sheetObj.GetComboInfo(Row, prefix+"vvd_etc", "Code").split(ROWMARK);
		        			var arrVvdEtcValue = arrVvdEtc[idx].split(FIELDMARK);
		        			var intAdvPySts = 0;
		        			
		        			//validation check. 선택한 값이 기존에 입력된 vvd 값과 같을 경우 
		        			//var tmpTrnsDt = sheetObj.CellValue2(Row, prefix+"trns_dt");
		   	        		var rowCnt = sheetObj.Rows; 
			        		for(idx=1;idx<rowCnt;idx++){
			                	 if(sheetObj.RowStatus(idx)=="I"){  //새로 입력된 데이터만 대상으로 함. 
				        			 if(Row!=idx && strVslCd == sheetObj.CellValue(idx, prefix+"vsl_cd")){  //자기자신 Row 는 대상에서 제외.
				        				 ComShowCodeMessage("SPP01005");  //Please check currency. It is already existed!
				        				 sheetObj.CellValue2(Row, prefix+"vsl_cd") = "";
				        				 sheetObj.SelectCell(idx, prefix+"vsl_cd", false);
				        				 return;
				        			 }
			                	 }
			        		}		        				
			        		
	        				sheetObj.CellValue2(Row, prefix+"vvd") = sheetObj.CellValue(Row, prefix+"vsl_cd");
	        				sheetObj.CellValue2(Row, prefix+"vsl_nm") = voyDir[0];	
		        			sheetObj.CellValue2(Row, prefix+"skd_voy_no") = voyDir[1];
		        			sheetObj.CellValue2(Row, prefix+"skd_dir_cd") = voyDir[2];
		        			sheetObj.CellValue2(Row, prefix+"lane") = voyDir[3];
		        			sheetObj.CellValue2(Row, prefix+"trns_dt") = arrVvdEtcValue[0];
		        			sheetObj.CellValue2(Row, prefix+"py_due_dt") = arrVvdEtcValue[1];
		        			//addrow 의 전도금은 무조건 approved. 전월의 vvd가 approved된 후 reject될시 ready상태로 돌아오기때문에 무조건 approved로 처리해야 inv 처리가능함
		        			/*
		        			if(arrVvdEtcValue[2]=='A'){
		        				intAdvPySts = 21;  //이미지 Approved
		        				sheetObj.CellEditable(Row,prefix+"adv_py_sts") = false;
		        			}if(arrVvdEtcValue[2]=='P'){
		        				intAdvPySts = 31;  //이미지 Approved
		        				sheetObj.CellEditable(Row,prefix+"adv_py_sts") = false;		        				
		        			}
		        			*/
		        			
		        			sheetObj.CellEditable(Row,prefix+"adv_py_sts") = false;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_sts") = 21;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = arrVvdEtcValue[3];
		        			sheetObj.CellValue2(Row, prefix+"inv_sts") = 0+ComParseInt(arrVvdEtcValue[6]-1);  //이미지 ready
		        			sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = "";
		        			sheetObj.CellValue2(Row, prefix+"vndr_seq") = formObject.vndr_seq.value;
		        			sheetObj.CellValue2(Row, prefix+"yd_cd") = arrVvdEtcValue[4];
		        			sheetObj.CellValue2(Row, prefix+"eseq") = arrVvdEtcValue[5];
		        			sheetObj.CellValue2(Row, prefix+"iseq") = arrVvdEtcValue[6];
		        			
		        			checkeVVDMonthAddRow(sheetObj, Row, prefix);
		        			
	        			}else{
	        				sheetObj.CellValue2(Row, prefix+"vvd") = "";
	        				sheetObj.CellValue2(Row, prefix+"vsl_nm") = "";
		        			sheetObj.CellValue2(Row, prefix+"skd_voy_no") = "";
		        			sheetObj.CellValue2(Row, prefix+"skd_dir_cd") = "";
		        			sheetObj.CellValue2(Row, prefix+"lane") = "";
		        			sheetObj.CellValue2(Row, prefix+"trns_dt") = "";
		        			sheetObj.CellValue2(Row, prefix+"py_due_dt") = "";	
		        			sheetObj.CellValue2(Row, prefix+"adv_py_sts") = 00;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = "";	
		        			sheetObj.CellValue2(Row, prefix+"inv_sts") = 00;  //이미지 없음
		        			sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = "";
		        			sheetObj.CellValue2(Row, prefix+"vndr_seq") = formObject.vndr_seq.value;
		        			sheetObj.CellValue2(Row, prefix+"yd_cd") = "";
		        			sheetObj.CellValue2(Row, prefix+"eseq") = "";
		        			sheetObj.CellValue2(Row, prefix+"iseq") = "";
	        			}
	        			break;
	        		/*
	        		case prefix+"skd_voy_no":
	        			checkeVVDMonthAddRow(sheetObj, Row, prefix);
	        			break;
	        			
	        		case prefix+"skd_dir_cd":
	        			checkeVVDMonthAddRow(sheetObj, Row, prefix);
	        			break;
	        		*/	
	        			
	        		default:
	        			break;
	        		
	        		
	        	}//end of switch
			}//end of if
			return;
        }
        
        function checkeVVDMonthAddRow(sheetObj, Row, prefix){
        	var rowCnt = sheetObj.Rows;
          	if(sheetObj.CellValue(Row, prefix+"vvd") != "" && sheetObj.CellValue(Row, prefix+"trns_dt") != ""){
	        	for(idx=1;idx<Row-1;idx++){
	        		if(Row != idx && sheetObj.CellValue(Row, prefix+"vvd") == sheetObj.CellValue(idx, prefix+"vvd") &&
	        					     sheetObj.CellValue(Row, prefix+"trns_dt").substring(0,6) == sheetObj.CellValue(idx, prefix+"trns_dt").substring(0,6)){
	    				ComShowCodeMessage("SPP00028"); //You can not input this invoice due to the same vessel in this month.please input next month.
	    				sheetObj.RowDelete(Row, false); // 행삭제
	    				return;
	    			}
	    		}
	        }
        	
        }
        /**
         * sheet1 의 콤보박스 값 셋팅
         */         
        function sheet1_ComboSetting(sheetObj, Row, strColId){
       	 //alert('Row:='+Row+" Colid:="+strColId);
       	 var prefix = "sheet1_";
       	 var formObj = document.form;

            switch(strColId){
            	case prefix+"vsl_cd":            		
     				formObj.f_cmd.value = COMMAND02;
     				formObj.revyrmon.value = formObj.revyr.value + formObj.revmon.value;
     				
     			    //tmp : CellComboItem 시 OnChange 이벤트 발생으로 trns_dt 값의 변동이 발생할 수 있어 이를 막기 위한처리.
     				var tmp = sheetObj.CellValue(Row, prefix+"trns_dt"); 
     				
     				//콤보필드를 초기화시킨다.
     				sheetObj.CellComboItem(Row, prefix+"vsl_cd", " ", " ", 0);
     				sheetObj.CellComboItem(Row, prefix+"vvd_etc", " ", " ", 0);
     				
     				//vvd list 가져오기
     				sheetObj.WaitImageVisible = false;
     				var sXml = sheetObj.GetSearchXml("EXP_SPP_0001GS.do", FormQueryString(formObj));
     				var comboItems = ComGetEtcData(sXml, VVD).split(ROWMARK);
     				
     				//vvd list 가 존재하지 않을 때
     				if(!comboItems.length || ComIsEmpty(comboItems[0])){
     					sheetObj.CellValue2(Row, prefix+"trns_dt") = tmp;
     					ComCodeMsgByNoRelatedData("VVD ");  //There is no related data!     
     					sheetObj.SelectCell(Row, prefix+"trns_dt");  
     					return;
     				}
     				
     				//vvd list 가 존재할 때
     				var comboVvdEtc = ComGetEtcData(sXml, VVDETC);
     				var comboItem = null;
     				
     				comboItem = getComboTextCode(comboItems, true).split(FIELDMARK);  //"text,code" 형태로 반환, 콤보 첫번째값 공백처리
     				sheetObj.CellComboItem(Row, prefix+"vsl_cd", comboItem[0], comboItem[1]);  //vsl_cd, skd_voy_no, skd_dir_cd 값이 공백없이 연결되어 코드로 셋팅된다.
     																						   //OnChange 이벤트 발생됨.
     				sheetObj.CellValue2(Row, prefix+"trns_dt") = tmp;
   				
     				sheetObj.CellComboItem(Row, prefix+"vvd_etc", " "+ROWMARK+comboVvdEtc, " "+ROWMARK+comboVvdEtc);  //콤보 첫번째값 공백처리
     				
        			sheetObj.SelectCell(Row, prefix+"vsl_cd", false);     				
	      			break;
	      			
	      		default:
	      			break;
            }
        }
        
        /**
         * ComGetEtcData() 를 통해서 얻은 xml 값을 받아
         * "text,code" 형태로 반환하는 함수. 
         * true : 콤보 첫번째값 공백, false : 콤보 첫번째 값 실제값 채우기 
         */         
        function getComboTextCode(comboItems, boolTF){
			var comboItems1= "";  //text
			var comboItems2= "";  //code
	
			if ( !comboItems.length ) {
				var comboItem = comboItems.split(FIELDMARK);
				comboItems1 = comboItem[0];
				comboItems2 = comboItem[1]; 		
			} else {
				for (var i = 0 ; i < comboItems.length ; i++) {
					var comboItem = comboItems[i].split(FIELDMARK);
					if( i == 0 ){
						if(boolTF){
							comboItems1 = "Select!" + ROWMARK + comboItem[0];
							comboItems2 = " " + ROWMARK + comboItem[1]; 							
						}else{
							comboItems1 = comboItem[0];
							comboItems2 = comboItem[1]; 
						}
					} else {
						comboItems1 = comboItems1 + ROWMARK +comboItem[0];  //text
						comboItems2 = comboItems2 + ROWMARK +comboItem[1];  //code
					}	
				}   		
			}

			return comboItems1 + FIELDMARK + comboItems2;
        }        
        
        /**
         * sheet1 클릭 이벤츠 처리
         */
        function sheet1_OnClick(sheetObj, Row, Col, Value){
        	//alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
			var url = "";
       	 	var prefix = "sheet1_";	
			var formObject = document.form;       	 	
       	 	var strColSaveName = sheetObj.ColSaveName(Col);       	 	
			formObject.revyrmon.value = formObject.revyr.value + formObject.revmon.value;

			if(Value!==null && Value !== "undefined" && Value !== -1){

	        	switch(strColSaveName){
		        	case prefix+"adv_py_sts":  //전도금
		        		
		        		if(sheetObj.CellValue(Row, prefix+"adv_py_sts")==32 && sheetObj.CellValue(Row, prefix+"inv_sts")==32){
		        			ComShowCodeMessage("SPP01033"); //Port Status is 'SKIP'.
		        			break;
		        		}
		        		
		        		if(ComIsEmpty(Value+"") || Value==0) break;  //Approve버튼 or Paid버튼 or blank Image
		        		url = "/hanjin/EXP_SPP_0002.do?"
		        			  + "vvd=" + sheetObj.CellValue(Row, prefix+'vvd') 
		        			  + "&vslNm=" + sheetObj.CellValue(Row, prefix+'vsl_nm') 
		        		      + "&ydCd=" + sheetObj.CellValue(Row, prefix+'yd_cd')
		        		      + "&callSeq=" + sheetObj.CellValue(Row, prefix+'eseq')
		        		      + "&vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
		        		      + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "")
		        		      + "&diffRmk=" + sheetObj.CellValue(Row, prefix+'rslt') 
		        		      + "&vndrCntCd=" + sheetObj.CellValue(Row, prefix+'vndr_cnt_cd');; 

		            	//adv_py_sts, adv_py_rev_mon, diff_rmk 값을 받음.
		            	var returnVal = ComOpenPopup(url, 1024, 600, '', '0,0', true, false);  //modal 로 띄움.
		            	
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);
		            	
		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpESeq = ComNullToValue(sheetObj.CellValue(Row, prefix+"eseq"), "1");
		            	
		            	sheetObj.CellValue2(Row, prefix+"adv_py_sts") = ComParseInt(tmpStsCd+tmpESeq);
		            	sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = arrReturnVal[1]; 
		            	sheetObj.CellValue2(Row, prefix+"rslt") = arrReturnVal[2]; 
		            	sheetObj.RowStatus(Row) = "R";  //트랜잭션이 발생되지 않은 상태로 바꿈.
		            	
		        	  	//VVD Status 설정
		        	  	setVVDStatus();		            	
		        		break;
		        		
		        	case prefix+"inv_sts":  //Invoice
		        		
		        		if(sheetObj.CellValue(Row, prefix+"adv_py_sts")==32 && sheetObj.CellValue(Row, prefix+"inv_sts")==32){
		        			ComShowCodeMessage("SPP01033"); //Port Status is 'SKIP'.
		        			break;
		        		}
		        		
		        		if(sheetObj.CellValue(Row, prefix+"adv_py_sts")!=21 && sheetObj.CellValue(Row, prefix+"adv_py_sts")!=31){
		        			ComShowCodeMessage("SPP01014");  //[Advance Payment Status] is not [Approved].
		        			break;  //전도금에 대한 상태가 Approved 가 아닌 경우 break;
		        		}
		        		
		        		if(ComIsEmpty(Value+"") || Value==0){
		        			break;  //Approve버튼 or blank Image
		        		}
		        		
		        		if(sheetObj.CellValue(Row, prefix+'rslt') == "ADD Row"){
		        			var addRowFlag = "Y";
		        		}else{
		        			var addRowFlag = "N"
		        		}
		        		
			        	url = "/hanjin/EXP_SPP_0003.do?"
			        		  + "vvd=" + sheetObj.CellValue(Row, prefix+'vvd') 
		        			  + "&vslNm=" + sheetObj.CellValue(Row, prefix+'vsl_nm')			        		  
			        		  + "&ydCd=" + sheetObj.CellValue(Row, prefix+'yd_cd')
			        		  + "&callSeq=" + sheetObj.CellValue(Row, prefix+'iseq')
			        		  + "&vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
			        		  + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "")
			        		  + "&trnsDt=" + + sheetObj.CellValue(Row, prefix+'trns_dt').replace(/-/gi, "")
			        		  + "&diffRmk=" + sheetObj.CellValue(Row, prefix+'rslt') 
		        		      + "&vndrCntCd=" + sheetObj.CellValue(Row, prefix+'vndr_cnt_cd')
		        		      + "&addRowFlag=" + addRowFlag ;; 
			        		  
			        	//inv_sts, inv_rev_mon, diff_rmk 값을 받음.	  
			        	var returnVal = ComOpenPopup(url, 1024, 620, '', '0,0', true, false);  //modal 로 띄움.
			        		  
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);

		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpISeq = ComParseInt(ComNullToValue(sheetObj.CellValue(Row, prefix+"iseq"), "3")-1);
		            	
		            	sheetObj.CellValue2(Row, prefix+"inv_sts") = ComParseInt(tmpStsCd+tmpISeq);
		            	sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = arrReturnVal[1]; 
		            	sheetObj.CellValue2(Row, prefix+"rslt") = arrReturnVal[2]; 
		            	sheetObj.RowStatus(Row) = "R";  //트랜잭션이 발생되지 않은 상태로 바꿈.	
		            	
		        	  	//VVD Status 설정
		        	  	setVVDStatus();		            	
		        		break;
		        		
		        	case prefix+"msa":  //MSA
		        		
		        		if(ComIsEmpty(Value+"") || Value==0) break;  //Approve버튼 or blank Image
		        		
		        		var rowCnt = sheetObj.Rows;
		        		var invCnt = 0;
		        		var advCnt = 0;
		        		var rdyCnt = 0;
		        		var revMon = formObject.revmon.value;
		        		
		        		for(idx=1;idx<rowCnt-1;idx++){
		        			
		        			var advSts = sheetObj.CellValue(idx, prefix+"adv_py_sts");
		        			var invSts = sheetObj.CellValue(idx, prefix+"inv_sts");
		        			var advMon = sheetObj.CellValue(idx, prefix+"adv_py_rev_mon").substring(4,6);
		        			var invMon = sheetObj.CellValue(idx, prefix+"inv_rev_mon").substring(4,6);
		        			
		        			//adv = approve or paid, inv = ready or request
		                	if(advSts.substring(0,1) == 2 || advSts == 31){
		                		//ready
		                		/*
		                		if(invSts.length == 1){
		                			invCnt++;
		                		}
		                		*/
		                		//inv = request and workingmonth = inv month
		                		if((invSts.length == 2 && invSts.substring(0,1) == 1) && (revMon == invMon)){
		                			invCnt++;
		                		}
		                	}
		                	//adv = request and workingmonth = adv month
		                	if((advSts.length == 2 && advSts.substring(0,1) == 1) && (revMon == advMon)){
		                		advCnt++;
		                	}
		                	
		                	if(advSts.length == 1){
		                		rdyCnt++;
		                	}
		        		}
		        		
		        		if(invCnt >0 ){
		        			ComShowCodeMessage("SPP01016");  //
		        			break;  //invoice 상태가 Approved 가 아닌 경우 break;
		        		}
		        		if(advCnt >0){
		        			ComShowCodeMessage("SPP01014");  //
		        			break;  //adv 상태가 Approved 가 아닌 경우 break;
		        		}
		        		if(rdyCnt == rowCnt-2){
		        			ComShowCodeMessage("SPP01014");  //
		        			break;  //adv 상태가 Approved 가 아닌 경우 break;
		        		}
		        		
		        		
		        		//if(ComTrimAll(formObj.vvdstatus.value).toLowerCase().indexOf('complete')==-1) break;  //VVD status 가 complete 된 상태가 아니라면 break; 
		        		
			        	url = "/hanjin/EXP_SPP_0004.do?"
			        		  + "vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
			        		  + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "");;
			        		  
			        	//msa 값을 받음.		        		  
			            var returnVal = ComOpenPopup(url, 1024, 540, '', '0,0', true, false);  //modal 로 띄움.
			            
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);

		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpSeq = "1";
		            	
		            	sheetObj.CellValue2(Row, prefix+"msa") = ComParseInt(tmpStsCd+tmpSeq);
		            	sheetObj.RowStatus(Row) = "R";  //트랜잭션이 발생되지 않은 상태로 바꿈.				            
			            
		        		break;
		        		
		        	default : 
		        		break;
		        	
	        	}//end of switch
			}//end of if
        	return;
        }
        
        /**
         * VVD Status 설정
         */  
        function setVVDStatus(){
        	var prefix = "sheet1_";	
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
	   		var rowCnt = sheetObj.Rows;
	   		var rdyCnt = 0;
	   		
	   		if(rowCnt<=1 || SearchRecCnt==0){  //header title 제외하고 데이터행이 없거나 조회된 데이터행이 없을 경우.
	   			formObj.vvdstatus.value = "";
	   			return;
			}            	
	   		
	   		var strResult = "";
	   		
	   		strResult = sheetObj.CellValue(rowCnt-1, prefix+"msa");
	   		//msa 가 approved면 complete
	   		if(strResult == "21"){
	   			strResult = "Complete";
	   		}else{
	   			for(idx=1;idx<rowCnt-1;idx++){
        			
        			var advSts = sheetObj.CellValue(idx, prefix+"adv_py_sts");
        			var invSts = sheetObj.CellValue(idx, prefix+"inv_sts");
        			var portSkipSts = sheetObj.CellValue(idx, prefix+"port_skip_sts");
        			
        			//alert(invSts);
        			if(advSts =="1"){
        				rdyCnt++;
        			}
        			
        			if(advSts == "1" || invSts == "1"){
        				if(portSkipSts=="SKIP"){
        					sheetObj.CellValue(idx, prefix+"adv_py_sts")=32;
        					sheetObj.CellValue(idx, prefix+"inv_sts")=32;
        				}
        			}
                }
	   			// adv 가 모두 ready면 ready
	   			if(rdyCnt == rowCnt-2){
	   				strResult = "Ready";
	   			}else{
	   				strResult = "Processing";
	   			}
	   		}
			formObj.vvdstatus.value = strResult;
		}        
        
        /**
         * sheet 에서 팝업버튼을 눌렀을때 발생하는 이벤트 설정
         */        
        function sheet1_OnPopupClick(sheetObj, row, col){
        	var prefix = "sheet1_";
         	var strColSaveName = sheetObj.ColSaveName(col);
         	
         	switch(strColSaveName){
         		case prefix+"trns_dt":
         			var cal = new ComCalendarGrid();
         			document.form.transymd.focus();
         			cal.select2(document.form.transymd, sheetObj, row, col, 'yyyyMMdd');
         			break;
         	}
        }
       
   	/* 개발자 작업  끝 */