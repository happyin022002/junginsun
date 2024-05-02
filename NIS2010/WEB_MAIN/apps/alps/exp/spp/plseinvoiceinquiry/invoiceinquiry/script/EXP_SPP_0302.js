/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0302.js
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
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
     * @class EXP_SPP_0302 : EXP_SPP_0302 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0302() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initCombo 				= initCombo;
    	this.initControl			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.obj_keyup 				= obj_keyup;
    	this.lstm_cd_mousemove		= lstm_cd_mousemove;
    	this.lstm_cd_mouseout		= lstm_cd_mouseout;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.doActionIBCombo 		= doActionIBCombo;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnChange 		= combo1_OnChange;
    	this.obj_blur				= obj_blur;
    	this.obj_change				= obj_change;
    	this.clearForm 				= clearForm;

    }

   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
     
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var LESSORNAME = "lessor_name";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
        	
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject1 = sheetObjects[0];
             var comboObject1 = comboObjects[0]; 
             /**************************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	            	  case "btn_New":  //검색조건,그리드초기화
			  				// 초기화하시겠습니까?
			  				if(!ComCodeMsgByInitialize()) return;
			  				ComResetAll();
			   	            setToday(document.form.str_dt, "ymd"); 
				            document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);			  				
			  				comboObject1.Code = "";
	            	  		break;

			          case "btn_Retrieve": 
			        	  	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
							break;
							
			          case "btns_Calendar":
			            	var cal = new ComCalendarFromTo();
			            	cal.select(formObject.str_dt, formObject.end_dt, 'yyyy-MM-dd');
			            	break;	
			          case "btn_search2": 
			        	  if(document.form.admCheck.value == "1"){
			    				openPopup("2");
			        	  }  
		        	  default: 
		        		    break;
		        	  
	            } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
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
        	//sheet 셋팅
            for(i=0;i<sheetObjects.length;i++){
            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i]);
                //sheet 초기화
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }  
            
            //combo 셋팅
            for(var k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],k+1);
            }
            
            //Lease Term 콤보데이터 조회
           doActionIBCombo(sheetObjects[0], comboObjects[0], document.form, IBSEARCH_ASYNC03); 

            initControl();

            if(document.form.admCheck.value == "0"){
            	ComEnableObject(document.form.vndr_seq,false);
            }
        }
         
        /**
         * Combo 기본 설정 
         * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
         * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
         */ 
        function initCombo(comboObj, comboNo){
            var formObj = document.form;
            switch(comboNo) {  
                  case 1: 
                  with (comboObj) { 
        				MultiSelect = true; 
        				UseAutoComplete = true;	
        				//MultiSeparator = ROWMARK;  //Separator 를 명시적으로 지정. default 는 콤마(,)
        				//SetColAlign("left|left");        
        				//SetColWidth("30|150");
        				//BackColor = "#CCFFFD";
        				//FontColor = "#FB1901";
        				//ColBackColor(0) = "#CCFFFD";
        				//ColFontColor(0) = "#FB1901";
        				//ColBackColor(1) = "#CCFFFD";
        				//ColFontColor(1) = "#FB1901";					
        				DropHeight = 160;
        				ItemHeight = 20;
        				MaxSelect = 20;
         		  }

         		  break; 
         	}         
        }
         
        /**
         * Form데이터포멧 키 프레스 관련 
         */
        function initControl() {
               //- form 전체 컨트롤 중  모든 컨트롤의 OnKeyPress이벤트에 코드 처리        	 
               axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
               //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리               
               axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form, 'vndr_seq'); 
               //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
               axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
  			   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyUp 이벤트에 코드 처리
  			   axon_event.addListenerFormat('keyup',    'obj_keyup',    	form);
  			   
  			   //- form 전체 컨트롤 중 lstm_cd 컨트롤의 OnMouseMove 이벤트에 코드 처리
               axon_event.addListener('mousemove', 'lstm_cd_mousemove', 'lstm_cd');
               //- form 전체 컨트롤 중 lstm_cd 컨트롤의 OnMouseOut 이벤트에 코드 처리
               axon_event.addListener('mouseout', 'lstm_cd_mouseout', 'lstm_cd');
               
         		axon_event.addListenerFormat('beforedeactivate',		'obj_blur',		form); //- 포커스 나갈때
        		//axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
        		axon_event.addListenerFormat('change',		'obj_change',	form); //- 변경될때.

  	           setToday(document.form.str_dt, "ymd"); 
	           document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);

      	 }
           
         // 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;
	    switch(obj.name){
	        case "vndr_seq":
	            break;

	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	           ComChkObjValid(obj);
	        	break;
	    }
	}

 	
  	
	 
          /*
           * OnBlur 이벤트에 코드 처리
           */
          function obj_deactivate(){
       	     obj = event.srcElement;
             //if(!ComChkObjValid(event.srcElement)) return;

             var formObj = document.form;
             var srcName = obj.getAttribute("name");
             switch(srcName){
                 case "str_dt":
                 case "end_dt":
                	 if(formObj.str_dt.value=="" || formObj.end_dt.value=="") break;
                	 //from date 와 to date 에 입력한 날짜의 유효성 체크. from 값이 to 값보다 항상 작게 입력.
                	 checkFromTo(formObj.str_dt, formObj.end_dt);
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
           * OnKeyUp 이벤트에 코드 처리
           */ 
          function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "str_dt":
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
        		       break;
    	           case "vndr_seq":
    	 				if ( ComTrim(obj.value) == "" ) {
    	 					clearForm(obj.name);
    	 				} else {
    	 					ComKeyEnter('LengthNextFocus');
    	 				}
    	 				break;
        		   default:
        			   break;
        	   }
          } 
           
          /*
           * lstm_cd Object 의 OnMouseMove 이벤트에 코드 처리
           */            
          function lstm_cd_mousemove(){
        	  obj = event.srcElement;
        	  if(obj.value.trim()=="") return;
        	  var divName = 'divtooltip';
        	  if(!initToolTipDiv(divName)) return;
        	  document.all[divName].style.visibility = 'visible';
        	  document.all[divName].innerHTML = obj.value;
        	  document.all[divName].style.posLeft = event.x;
        	  document.all[divName].style.posTop = event.y;
          }
          
          /*
          * lstm_cd Object 의 OnMouseOut 이벤트에 코드 처리
          */           
          function lstm_cd_mouseout(){
        	  obj = event.srcElement;
        	  var divName = 'divtooltip';
        	  if(!initToolTipDiv(divName)) return;
        	  document.all[divName].style.visibility = 'hidden';
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

         	  	if(formObject.vndr_seq.value == "" || formObject.vndr_seq.value == undefined){
         	  		ComShowCodeMessage("COM12114", "Lessor I/D");  //Please check {?msg1}
         	  		formObject.vndr_seq.focus();
         	  		return;
         	  	}       	  	
         	  	
         	  	//조회
         	  	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        	  	
     	    	return true ;
     	    }
     	    
       	    window.defaultStatus = obj.dataformat;

       	    //한글 입력 불가능 처리는 ime-mode:disabled; 를 사용했음.
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
       	            ComKeyOnlyAlphabet(); 
       	            break;
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

    							var HeadTitle1 = "|Seq.|Lessor I/D|Lessor|Term|Invoice No|Currency|Invoice Amount|Invoice Status|Payable AMT|Payment Date";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							/*mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) */
    							InitHeadMode(true, true, false, true, false,false);
    								
    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							var prefix = "sheet1_";

    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,      50,     daCenter,   true,    "Seq",     false,          "",      dfNone);
    							if(document.form.admCheck.value != "1"){
    								InitDataProperty(0, cnt++ , dtHidden,			120,		daCenter,	true,	prefix+"vndr_seq",			false,	"",	dfNone,		0,	false,	false);
    								InitDataProperty(0, cnt++ , dtHidden,			120,		daLeft,	true,	prefix+"vndr_nm",			false,	"",	dfNone,		0,	false,	false);
    							}else{
    								InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,	prefix+"vndr_seq",			false,	"",	dfNone,		0,	false,	false);
    								InitDataProperty(0, cnt++ , dtData,			180,		daLeft,	true,	prefix+"vndr_nm",			false,	"",	dfNone,		0,	false,	false);
    							}
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"lstm_cd",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"inv_no",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix+"curr_cd",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	prefix+"ttl_cost_amt",		false,	"",	dfNullFloat,2,	false,	false, 13);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"lse_inv_apsts_cd",	false,"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	prefix+"pay_rntl_cost_amt",	false,	"",	dfNullFloat,2,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"ap_pay_dt",			false,	"",	dfDateYmd,	0,	false,	false);

    						}
    						break;
    						
            }
        }

        /*
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj, formObj, sAction) {
    	    var prefix = "sheet1_";
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

              case IBSEARCH:  //조회
            	if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id == "sheet1"){
						var prefix = "sheet1_";
						formObj.f_cmd.value = SEARCH;
					//	ComClearFormSeparator(formObj);  //마스크  제거
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0302GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSearchXml(sXml);
					//	ComSetFormSeparator(formObj);  //마스크 다시 셋팅
	    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수

					}
              	}
				break;
              case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.vndr_seq);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}

    		    break;  		    

            }
        }
         
        /*
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
             switch(sAction){
	       	 case IBSEARCH:	//조회
		  	 	       	 	
		  	 	break;	  	 	
		  	 	
             default:
	            break;			  	 	
             }
             
             return true;
        }         
         
        /*
         * 콤보 관련 프로세스 처리
         */     
        function doActionIBCombo(sheetObj, comboObj, formObj, sAction) {

             sheetObj.ShowDebugMsg = false;
             switch(sAction) {
            		
            	case IBSEARCH_ASYNC03:  // 조회조건필드인 Lease Term 콤보 데이터 조회		
            		sheetObj.WaitImageVisible = false;
            		/* Lease Term Form Combo Item Setting */
            		formObj.f_cmd.value = SEARCH01;
            		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

            		if ( sXml != "" ) {
            			comboObj.InsertItem(0 , 'ALL','ALL'); 
            			SppComXml2ComboItem(sXml, comboObj, "lease_term_nm", "lease_term_cd", ROWMARK);
            			vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
            		}
            		break;	            		
            		
             }
        } 
         
        /**
         * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
         * ALL 체크시 다른 체크를 해제하기 위한 처리.
         * @return
         */
        function combo1_OnCheckClick(comboObj, index, code) {
         	if(index==0) { 	    	
         		var bChk = comboObj.CheckIndex(index);
         		if(bChk){
         			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
         				comboObj.CheckIndex(i) = false;
         			}
         		}
         	} else {
         		comboObj.CheckIndex(0) = false;
         	}
        }          
        
         /**
     	 * OnChange Event 처리
     	 */
     	function obj_change(){
     		var obj      = event.srcElement;
     		var formObj  = document.form;
     		var sheetObj = sheetObjects[0];

     		if ( ComTrim(obj.value) != "" ) {
     			switch(obj.name) {
     	    		case "vndr_seq":
     	    			if( formObj.vndr_seq != "")
     	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
     				   	break;
     			}
     	    }
     	}
     	
        /**
         * combo1 item change 부분<br>
         * @param comboObj
         * @param UseCode=false 인 경우 code 값
         * @param 화면에 표시된 글자
         */	 	

        function combo1_OnChange(comboObj, value, text){ 		
        	if(  0 <= value.indexOf("ALL") ){ 			
        		document.form.lstm_cd.value = "";
        	}else{
        		var strLstmCd =  value.replaceStr(ROWMARK, FIELDMARK).split(FIELDMARK);
        		document.form.lstm_cd.value = strLstmCd;
        	}
        }  
         /**
          * Pop-up Open 부분<br>
          * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
          * @param object 대상 Object
          * @param Row 대상Object가 IBSheet일 경우 해당 Row index
          */
          function openPopup(type, Row, Col) {	
          	var formObj = document.form;
          	if ( type == "2") {	
          		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);

          	} else if ( type == "3") {
          		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);

          	}	
          }
          /**
           * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
           * @param {arry} returnedValues Pop-up 화면의 Return value array
           * @param Row 대상Object가 IBSheet일 경우 해당 Row index
           * @param Col 대상Object가 IBSheet일 경우 해당 Col index
           * @param 대상IBSheet의 Sheet Array index
           */
           function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
           	var sheetObj = sheetObjects[SheetIdx];
           	var formObj  = document.form;

           	if ( aryPopupData.length > 0 ) {
           		formObj.vndr_seq.value = aryPopupData[0][2];
           		formObj.vndr_nm.value  = aryPopupData[0][4];

           	}
           }
           
           /**
       	 * Form Element Clear 처리부분.<br>
       	 * @param fieldName
       	 */
       	function clearForm(fieldName) {
       		var formObj = document.form;
       		switch(fieldName) {
       			case "vndr_seq":
       				ComSetObjValue(formObj.vndr_seq, "");
       				ComSetObjValue(formObj.vndr_nm,  "");
       				break;
       		}
       	}
   	/* 개발자 작업  끝 */