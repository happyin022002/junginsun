/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0006.jsp
*@FileTitle : Canal transit schedule inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.24
*@LastModifier : Park Yeon jin
*@LastVersion : 1.0
* 2011.11.24 Park Yeon jin
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
     * @class EXP_SPP_0006 : EXP_SPP_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EXP_SPP_0006() {
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

    var LANE = "";
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

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
	            case "btn_DownExcel":
	        	    if(sheetObject1.RowCount <= 0){
	        	        ComCodeMsgByNoRelatedData();  // There is no related data!
	        	        return;
	        	    }else{
	        	        if(sheetObject1.RowCount > 0){
	        	        	sheetObject1.Down2Excel(-1,true,true,true,"","",false,false,"Canal transit schedule list");  //hidden 필드내려받지않음.
	        	        }
	        	    } 
	        	    break;            
            	
		        case "btns_calendar":
		        	GlobalRevYr = document.form.tgt_yrmon.value;  //캘린더이미지버튼 클릭 시 GlobalRevYr 에 이전년 값 셋팅을 위해.
		        	var cal = new ComCalendar();
		        	cal.setDisplayType('month');
        	        cal.select(formObject.tgt_yrmon, 'yyyy-MM');
        	        break;

	            case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				
				
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
					
				default : break;
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {

            for(i=0;i<sheetObjects.length;i++){
            	//khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );

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
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBlur 이벤트에 코드 처리        	 
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnFocus 이벤트에 코드 처리
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyUp 이벤트에 코드 처리
			 axon_event.addListenerFormat('keyup',  'obj_keyup',    	form); 	
			 //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
			 axon_event.addListenerFormat('keypress', 'obj_keypress',   form);
			   
             //캘린더 선택시 revyr 오브젝트에 change 이벤트가 발생하지 않는 문제 해결을 위해. GlobalRevYr 전역변수사용.
             //axon_event.addListener('change',   'obj_change',  'revyr');
             //axon_event.addListener('change',   'obj_change',  'revmon');
             
             //Today Setting ..
 	  		 //setToday(document.form.revyr, "y");
 	  		 //setToday(document.form.revmon, "m");
 	  		 setToday(document.form.tgt_yrmon, "ym");
 	  		 //GlobalRevYr = document.form.revyr.value;
             //focusSetting
 	  	     document.form.lane_cd.focus();
	 	  	 
 	  	     if(document.form.vndr_seq.value != "100870" && document.form.vndr_seq.value != "174580" ) {
	 	  	    document.all.div_save.style.display = "none";
	 	  	 }
	         //header 색상 변경
			 //sheetObjects[0].CellBackColor(1, "sheet1_"+"b_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			// sheetObjects[0].CellBackColor(1, "sheet1_"+"c_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
			// sheetObjects[0].CellBackColor(1, "sheet1_"+"a_sts_cd") = sheetObjects[0].CellBackColor(0, 0);
      	 }  
         
         /*
          * OnBlur 이벤트에 코드 처리
          */
         
         function obj_deactivate(){
       	   obj = event.srcElement;
              if(ComChkObjValid(event.srcElement)){
	           	   if(obj.name=="tgt_yrmon"){  //캘린더에서 날짜 선택시 onchange 이벤트 발생되지 않아 수동으로 처리함.
	        		   if(GlobalRevYr != document.form.tgt_yrmon.value){
	        			   //obj_change();
	        			   GlobalRevYr = document.form.tgt_yrmon.value;
	        		   }
	        		   return; 
	        	   }
		          if(obj.name=="lane_cd"){  
		           		if (document.form.lane_cd.value != "" && ComChkLen(document.form.lane_cd.value,3)!=2) {
		           			ComShowCodeMessage('SPP01018',"Lane Code","3");
							document.form.lane_cd.focus();
							return false;
						}
		           		return; 
		          }
		          if(obj.name=="vsl_cd"){  
				  		if (document.form.vsl_cd.value != "" && ComChkLen(document.form.vsl_cd.value,4)!=2) {
				  			ComShowCodeMessage('SPP01018',"Vessel Code","4");
							document.form.vsl_cd.focus();
							return false;
				  	 	}
				  	return; 
	              }
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
    	           case "tgt_yrmon":
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
    	           case "lane_cd":
        	    	   ComKeyEnter('LengthNextFocus');  //maxlength 까지 값이 입력되면 자동으로 다음 object 로 커서 이동.
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
 
    	    	if(formObject.tgt_yrmon.value == "" || formObject.tgt_yrmon.value == undefined){
        	  		ComShowCodeMessage("COM12114", "Year Month");  //Please check {?msg1}
        	  		formObject.tgt_yrmon.focus();
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
      	        	ComKeyOnlyNumber(event.srcElement);  
      	        	break;
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
      	            if(obj.name=="lane_cd") ComKeyOnlyAlphabet('uppernum')
      	            else ComKeyOnlyAlphabet('upper');
      	            break;
      	        case "engdn":
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
    							style.height = 360;
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host 정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							if(document.form.vndr_seq.value != "100870" && document.form.vndr_seq.value != "174580" ) {
	    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    							InitRowInfo(2, 1, 3, onepagerows);  //100 -  페이지처리시 페이지당 레코드수
    							}else{
    								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    							InitRowInfo(3, 1, 3, onepagerows);  //100 -  페이지처리시 페이지당 레코드수
    							}

    							var HeadTitle1 = "|BOUND|VVD|Vessel Name|Lane|Coastal Schedule|Coastal Schedule|Coastal Schedule|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Panama Transit Booking|Next Port|Next Port|Hidden1";
    							var HeadTitle2 = "|BOUND|VVD|Vessel Name|Lane|ETA|ETB|ETD|Del|BKG Period|Bidding\nPrice(USD)|BKG Status|BKG\nTransit Date|JIT Service Approval|JIT Service Approval|Port|ETA|Hidden1";	  
    							var HeadTitle3 = "|BOUND|VVD|Vessel Name|Lane|ETA|ETB|ETD||BKG Period|Bidding\nPrice(USD)|BKG Status|BKG\nTransit Date|Y/N|Arrival Date|Port|ETA|Hidden1";	  
    							
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다. [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
    							InitHeadMode(true, true, true, true, false, false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
    							InitHeadRow(1, HeadTitle2, true);
    							InitHeadRow(2, HeadTitle3, true);

    							var prefix = "sheet1_";
    							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	prefix+"bound",						false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vvd",						false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			180,	daCenter,	true,	prefix+"vsl_eng_nm",				false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"vsl_slan_cd",				false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vps_eta_dt",				false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vps_etb_dt",				false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"vps_etd_dt",				false,	"",	dfNone,		0,	false,	false, 10);
    							
    							InitDataProperty(0, cnt++ , dtCheckBox,     30,     daCenter,   true,   prefix+"del_flag");
    							InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"cnl_tz_bkg_prd_cd",			false,	"",	dfNone,		0,	true,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	prefix+"cnl_bkg_amt",				false,	"",	dfNullFloat,2,	true,	true, 8);
    							InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	prefix+"cnl_tz_bkg_proc_sts_cd",	false,	"",	dfNone,		0,	true,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"cnl_bkg_tz_dt",				false,	"",	dfDateYmd,	0,	true,	true, 10);
    							InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"cnl_ot_svc_apro_flg",		false,	"",	dfNone,		0,	true,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"cnl_ot_svc_arr_dt",			false,	"",	dfUserFormat2,	0,	true,	true, 10);
    							//InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"cnl_ot_svc_arr_dt2",		false,	"",	dfTimeHm,	0,	true,	true, 10);
    							
    							InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	prefix+"nxt_port_cd",				false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"nxt_port_eta",				false,	"",	dfNone,		0,	false,	false, 10);
    							InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	prefix+"tgt_vvd_exist_flg");

    							InitUserFormat2(0, prefix + "cnl_ot_svc_arr_dt", "####-##-## ##:##", "-|:");
    							
    							CountFormat = "[SELECTDATAROW / TOTALROWS]";  //페이지처리시 전체 데이터수를 표시.
    																	      //default 설정은 CoObject.js => "[SELECTDATAROW / ROWCOUNT]"
    							if(document.form.vndr_seq.value != "100870" && document.form.vndr_seq.value != "174580" ) {
    								ColHidden(prefix+"del_flag") 				= true;
    								ColHidden(prefix+"cnl_tz_bkg_prd_cd") 		= true;
    								ColHidden(prefix+"cnl_tz_bkg_proc_sts_cd") 	= true;
    								ColHidden(prefix+"cnl_bkg_tz_dt") 			= true;
    								ColHidden(prefix+"cnl_ot_svc_apro_flg") 	= true;
    								ColHidden(prefix+"cnl_bkg_amt") 			= true;
    								ColHidden(prefix+"cnl_ot_svc_arr_dt") 		= true;
    								//ColHidden(prefix+"cnl_ot_svc_arr_dt2") 		= true;
    							}else{
    								InitDataCombo (0, prefix+"cnl_tz_bkg_prd_cd"		, "1st Period|2nd Period|3rd Period|Auction","F|S|T|A");
        							InitDataCombo (0, prefix+"cnl_tz_bkg_proc_sts_cd"	, "Ready|Processing|Booked|Fail"			,"R|P|B|F");
        							InitDataCombo (0, prefix+"cnl_ot_svc_apro_flg"		, "Yes|No"									,"Y|N");
    							}
    							
    						}
    						break;
    						
            }
        }

        /*
         * Sheet관련 프로세스 처리 
         */
        function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:      //조회
              	if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id == "sheet1"){
						var prefix = "sheet1_";
						formObj.f_cmd.value = SEARCH;
						ComClearFormSeparator(formObj);  //마스크  제거
						var CondParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
						var PageParam = "i_page=1";
						
						sheetObj.DoSearch4Post("EXP_SPP_0006GS.do", CondParam, PageParam);
						ComSetFormSeparator(formObj);  //마스크 다시 셋팅
						
    					//조회된 건수가 없으면 break
    					if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수

					}
              	}
    		    break;
    		    
              case IBSEARCHAPPEND:  //페이지처리
                if(validateForm(sheetObj,formObj,IBSEARCH)){            	  
	           		if(sheetObj.id == "sheet1"){
	           			var prefix = "sheet1_";
	  	            	formObj.f_cmd.value = SEARCH;
	  	            	ComClearFormSeparator(formObj);  //마스크  제거
	  	            	var PageParam = "i_page=" + PageNo;
	  	                sheetObj.DoSearch4Post("EXP_SPP_0006GS.do", CondParam, PageParam, true);  //true - 조회된 내용을 이어서(append) 쓸지 여부
	  	                ComSetFormSeparator(formObj);  //마스크 다시 셋팅
	  	                
	  	                //조회된 건수가 없으면 break
	  	                if(sheetObj.TotalRows==0) break;  //TotalRows : R 상태의 데이터 수	  	

	           		}
                }
                  break;
                  
              case IBSAVE:        //저장
                  if(validateForm(sheetObj,formObj,sAction)){
  	           		if(sheetObj.id == "sheet1"){
  	           			var prefix = "sheet1_";
  	           			
  	  	    		  	//transaction 발생한 건이 없을 경우 return
  	  					if (!sheetObj.IsDataModified) {				
  	  						ComCodeMsgByNoContentsSave();
  	  						return; 
  	  					}
  	           			
  	  	            	formObj.f_cmd.value = MULTI;
  	  	            	
  	  	    		    ComClearFormSeparator(formObj);  //마스크  제거 
  	  					var sParam = FormQueryStringOrg(formObj);
  	  					ComSetFormSeparator(formObj);  //마스크 다시 셋팅
  	  					
  	  					var sParam1 = sheetObj.GetSaveString();
  	  					
  	  					if (sParam1 == "") {
  	  						ComCodeMsgByNoContentsSave();
  	  						return; 
  	  					}
  	  					
  	  	    		  	// 저장하시겠습니까?
  	  	    			if(!ComCodeMsgBySave()) return;   
  	  	    		  	
  	  					sParam = sParam + "&" + sParam1;
  	  					
  	  	    		  	//저장. 저장 후 OnSaveEnd 이벤트 발생
  	  					//sheetObj.ShowDebugMsg = true;
  	  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0006GS.do", sParam);
  	  	    			//sheetObj.ShowDebugMsg = false;
  	  	    			sheetObj.LoadSaveXml(sXml);  //저장된 내용 sheet 에 반영 후 OnSaveEnd 이벤트 발생
  	  	    										 //저장 후 새로 조회하지 않아도 됨.
  	  	    			
  	  	    			//OnSaveEnd 후에 실행된다.
  	                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
  	                		//저장 성공 후 work
  	                		
  	                	}	  					
  	           		}
                  }
                  break;

            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
             switch(sAction){
		       	 case IBSEARCH:	//조회
			  	 	if(ComIsEmpty(formObj.tgt_yrmon.value)){
			  	 		ComCodeMsgByEmptyData("tgt_yrmon");
			  	 		return false;
			  	 	} 
			  	 	if (formObj.lane_cd.value != "" && ComChkLen(formObj.lane_cd.value,3)!=2) {
	           			ComShowCodeMessage('SPP01018',"Lane Code","3");
	           			formObj.lane_cd.focus();
						return false;
					}
			  	 	if (formObj.vsl_cd.value != "" && ComChkLen(formObj.vsl_cd.value,4)!=2) {
	           			ComShowCodeMessage('SPP01018',"Vessel Code","4");
	           			formObj.vsl_cd.focus();
						return false;
					}
			  	 	break;
			  	 	
	             default:
		            break;			  	 	
             }
             return true;
        }
         
        /**
     	 * sheet1_OnScrollNext 페이지처리
     	 */
     	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
     		//OnePageRows - InitRowInfo 에서 설정한 한페이지당 row count. document.form.pagerows.value 와 동일.
     		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
     	}
     	
     	/**
     	* sheet1_OnMouseMove 이벤트 처리. 
     	* tooltip 처리
     	*/
     	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {	
      		var prefix = "sheet1_";
      		var Row = sheetObj.MouseRow;
      		var Col = sheetObj.MouseCol;
      		var colId = sheetObj.ColSaveName(Col);
     		if (Row>=sheetObj.TopRow && colId==prefix+"vsl_eng_nm"){
     			sheetObj.MouseToolTipText = sheetObj.CellText(Row, Col);		   
     		} else {
     			sheetObj.MouseToolTipText = "";
     		}      
     	}     	 
     	 
     	/**
     	* sheet1_OnMouseMove 이벤트 처리. 
     	* tooltip 처리
     	*/
     	function sheet1_OnSearchEnd(sheetObj, ErrMsg) { 
			if(sheetObj.RowCount==0) return;
     		var prefix = sheetObj.id + "_";
			for(var Row=sheetObj.HeaderRows; Row<sheetObj.HeaderRows+sheetObj.RowCount; Row++){
				if("Y" != sheetObj.CellValue(Row, prefix+"tgt_vvd_exist_flg")){
					sheetObj.RowFontColor(Row) =  sheetObj.RgbColor(255, 0, 0);		// 빨강
				}
				if("A" != sheetObj.CellValue(Row, prefix+"cnl_tz_bkg_prd_cd")){
     				sheetObj.CellEditable(Row, prefix+"cnl_bkg_amt") = false;
     			}
				if("Y" != sheetObj.CellValue(Row, prefix+"cnl_ot_svc_apro_flg")){
     				sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt") = false;
     				//sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt2") = false;
     			}
				
			}	
     	}
     	
     	/**
      	 * sheet1_OnChange 이벤트 처리. 
      	 * sheet1 의 데이터가 있는 행에 대해서만.
      	 * 데이터행의 체크박스 처리를 위해서 이 이벤트를 활용했음.
      	 */
      	function sheet1_OnChange(sheetObj, Row, Col, Value) {
      	    //[체크된값]이 아니면 실행하지 않는다.
      		//if(Value==0) return;
      		
      		var prefix = "sheet1_";
      		var colId = sheetObj.ColSaveName(Col);
      		
  			switch(colId){
				case prefix+"cnl_tz_bkg_prd_cd":
					if(Value == "A"){
						sheetObj.CellEditable(Row, prefix+"cnl_bkg_amt") = true;
					}else{
						sheetObj.CellEditable(Row, prefix+"cnl_bkg_amt") = false;
						sheetObj.CellValue2(Row, prefix+"cnl_bkg_amt") = "";
					}
					break;
				case prefix+"cnl_tz_bkg_proc_sts_cd":
					if(Value == "F"){
						sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_apro_flg") = "N";
						sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_arr_dt") = "";
						//sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_arr_dt2") = "";
						sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt") = false;
						//sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt2") = false;
					}else{
						sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_apro_flg") = "";
						sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt") = false;
						//sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt2") = false;
					}
					break;
				case prefix+"cnl_ot_svc_apro_flg":
					if(Value == "Y"){
						sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt") = true;
						//sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt2") = true;
					}else{
						sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_arr_dt") = "";
						//sheetObj.CellValue2(Row, prefix+"cnl_ot_svc_arr_dt2") = "";
						sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt") = false;
						//sheetObj.CellEditable(Row, prefix+"cnl_ot_svc_arr_dt2") = false;
					}
					
				break;	
				default:
					break;
			}      		
      	}
	/* 개발자 작업  끝 */