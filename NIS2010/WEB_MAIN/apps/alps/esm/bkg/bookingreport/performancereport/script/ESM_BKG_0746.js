/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0746.js
*@FileTitle : Vessel Utilization Status vs. BSA by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.26 강동윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.09.01 김경섭 [000 ] [ESM-BKG] Vessel Utilization Status vs BSA by Lane 집계 쿼리 수정 및 RAW DATA SHEET 추가
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
     * @class ESM_BKG_0746 : ESM_BKG_0746 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0746() {
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

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;

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
         
         //MultiCombo초기화 
	 	 for(var k=0;k<comboObjects.length;k++){
	 		 initCombo(comboObjects[k],comboObjects[k].id);
	 	 }
	 	 
	 	 initControl();
	 	 
	 	 doActionIBSheet(sheetObjects[0],document.form,INIT);
	 	 
	 	 document.form.etd_from_dt.value = getCalculatedDate(0,-1,0,"-");
		 document.form.etd_to_dt.value   = getCalculatedDate(0,0,0,"-"); 
		 
//		 document.form.slan_cd.value 	 = "KJS";
		 
     }
      
      /**
       * 콤보 초기설정값
       * @param {IBMultiCombo} comboObj  comboObj
       */
       function initCombo(comboObj, comboId) {
     	  comboObj.MultiSelect = false;
     	  comboObj.UseCode = false;
     	  comboObj.UseEdit = false;
     	  //comboObj.LineColor = "#ffffff";
     	  //comboObj.SetColAlign("left|left");
     	  comboObj.MultiSeparator = ",";
     	  comboObj.DropHeight = 150;      
     	  
     	  //UseAutoComplete = true; // 편집시 자동 코드 검색
       }    
       /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
	     var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
          /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * 
       * @param {ibsheet}
       *            sheetObj IBSheet Object
       * @param {int}
       *            sheetNo sheetObjects 배열에서 순번
       */
      function initControl() {
      	var formObject = document.form;
      	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
          axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
          axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject); //- 키보드 입력할때
          
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
          axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
      }
      
     /**
	 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
	 **/
     function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engupnum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
      var headCount = 0
      var headCount2 = 0
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
 								//MergeSheet = msPrevColumnMerge + msHeaderOnly;
 								MergeSheet = msAll;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "Lane|VVD|BSA|BSA|Utilization|Utilization|Lifting Total|Lifting Total";
 								var HeadTitle2 = "Lane|VVD|E|W|E|W|E|W";
 								
 								for (var i = 0 ; i < 40 ; i++){
									
									HeadTitle1 += "|DIS|Load|ROB";
									HeadTitle2 += "|DIS|Load|ROB";
								}
 								
 								headCount = ComCountHeadTitle(HeadTitle1);
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(false, false, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								//InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"Lane",						false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"VVD",						false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"BSA_E",					false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"BSA_W",					false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"Util_E",					false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"Util_W",					false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"Lift_E",					false,		"",		dfNone,					0,		false);
 								InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"Lift_W",					false,		"",		dfNone,					0,		false);
 								
 								for (var i = 0 ; i < 40 ; i++){
	 									InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"DIS" + i,						false,		"",		dfNone,					0,		false);
 										InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"Load" + i,					false,		"",		dfNone,					0,		false);
 										InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"ROB" + i,					false,		"",		dfNone,					0,		false);
 								}
 								
 								//InitDataProperty(0,		cnt++ , dtHidden,			30,		daCenter,		false,		"maxSize");
 								//InitDataProperty(0,		cnt++ , dtHidden,			30,		daCenter,		false,		"merge_tp");
 								
 								//DataRowMerge(0) = true;
 								//SetSortDialog(false);
 								CountPosition = 0;
 								
 								for (var i = 0 ; i < 120 ; i++){
 									
 									SetMergeCell(0, 8+i, 2, 1);
 								} 									
 						}
 						break;
 					case "sheet2":
 						with (sheetObj) {
 							
 							// 높이 설정
 							style.height = 390;
 							//전체 너비 설정
 							SheetWidth = mainTable.clientWidth;
 							
 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 							
 							//전체Merge 종류 [선택, Default msNone]
 							//MergeSheet = msPrevColumnMerge + msHeaderOnly;
 							MergeSheet = msNone;
 							
 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;
 							
 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(1, 1, 3, 100);
 							
 							var HeadTitle1 = "vps_lane_cd|vvd|BSA_east|BSA_west|LIFTING_ttl_e|LIFTING_ttl_w|ttl_local_e|ttl_local_w|ttl_ts_e|ttl_ts_w|ttl_ipc_e|ttl_ipc_w|ttl_tps_e|ttl_tps_w|ttl_eur_e|ttl_eur_w|ttl_mty_e|ttl_mty_w";
 							
 							for (var i = 0+1 ; i < 40+1 ; i++){
 								
 								HeadTitle1 += "|port"+ i +"|total_loading"+ i +"|total_discharging"+ i +"|eta"+ i +"|etd"+ i;
 								HeadTitle1 += "|l_local"+ i +"|d_local"+ i +"|l_ts"+ i +"|d_ts"+ i +"|l_ipc"+ i +"|d_ipc"+ i +"|l_tps"+ i +"|d_tps"+ i +"|l_eur"+ i +"|d_eur"+ i +"|l_mty"+ i +"|d_mty"+ i +"|last_port_loading"+ i +"|util"+ i+"|util_indi"+i;
 							}
 							
 							headCount2 = ComCountHeadTitle(HeadTitle1);
 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount2, 0, 0, true);
 							
 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(false, false, false, true, false,false);
 							
 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);
 							InitHeadRow(1, HeadTitle2, true);
 							
 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 							//InitDataProperty(0,		cnt++ , dtHiddenStatus,			30,		daCenter,		true,		"ibflag");
 							InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"vps_lane_cd",				false,		"",		dfNone,					0,		false);
 							InitDataProperty(0,		cnt++ , dtData,					80,		daCenter,		true,		"vvd",						false,		"",		dfNone,					0,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"BSA_east",					false,		"",		dfInteger,					0,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"BSA_west",					false,		"",		dfInteger,					0,		false);
 							
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"LIFTING_ttl_e",			false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		true,		"LIFTING_ttl_w",			false,		"",		dfNullFloat,					1,		false);
 							
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_local_e",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_local_w",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_ts_e",					false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_ts_w",					false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_ipc_e",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_ipc_w",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_tps_e",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_tps_w",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_eur_e",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_eur_w",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_mty_e",				false,		"",		dfNullFloat,					1,		false);
 							InitDataProperty(0,		cnt++ , dtData,					70,		daRight,		false,		"ttl_mty_w",				false,		"",		dfNullFloat,					1,		false);
 							
 	
 							
 							
 							for (var i = 0+1 ; i < 40 +1; i++){
 								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"port" + i,				   false,	"",		dfNone,					        0,		false);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"total_loading" + i,	   false,	"",		dfNullFloat,					1,		false);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"total_discharging" + i,   false,	"",		dfNullFloat,					1,		false);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"eta" + i,				   false,	"",		dfNone,					        0,		false);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"etd" + i,				   false,	"",		dfNone,					        0,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_local" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_local" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_ts" + i,					false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_ts" + i,					false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_ipc" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_ipc" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_tps" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_tps" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_eur" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_eur" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"l_mty" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"d_mty" + i,				false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"last_port_loading" + i,	false,	"",		dfNone ,					1,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"util" + i,					false,	"",		dfNone,					        0,		false);
								InitDataProperty(0,		cnt++ , dtData,				100,		daRight,		false,		"util_indi" + i,			false,	"",		dfNullInteger,					0,		false);
 							}
 							
 							CountPosition = 0;
 						}
 						break;


 			}//end switch
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

  				case "btn_Retrieve":  					
  					doActionIBSheet(sheetObjects[0],document.form,SEARCH);
  					break;

  				case "btn_New":
  					ComResetAll();
  					break;
  					
  				case "btn_DownExcel":
  					//sheetObject1.SpeedDown2Excel(-1);
  					sheetObject1.Down2Excel(-1);
  					break;
  				case "btn_Rawdata":
  					sheetObjects[1].SpeedDown2Excel(-1);
  					//sheetObjects[1].Down2Excel(-1);
  					break;
  									
  				case "btn_Print":
  					//goPrint();
  					sheetObject1.Down2Excel(-1);
  					break;	
  					
  				case "btn_calendar":
 					var cal = new ComCalendarFromTo();
 	                cal.select(formObject.etd_from_dt, formObject.etd_to_dt, 'yyyy-MM-dd');
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
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

           case INIT:      //TRADE CODE SEARCH	          
           
           		formObj.f_cmd.value = INIT;   
           		
           		var searchXml = sheetObj.GetSearchXml("ESM_BKG_0746GS.do", FormQueryString(formObj));
           		
           		//Trade code
				ComBkgXml2ComboItem(searchXml, formObj.trd_cd, "trd_cd", "trd_cd");
				
				comboObjects[0].InsertItem(0, "All", "");
				
				comboObjects[0].index2 = 0;
				
				comboObjects[1].InsertItem(0, "All", "");
				
				comboObjects[1].index2 = 0;
				
				comboObjects[2].InsertItem(0, "All", "");
				
				comboObjects[2].index2 = 0;
           		
           break;

           case COMMAND01:     //SUB TRADE CODE SEARCH
           		
           		formObj.f_cmd.value = SEARCH01;   
      		
           		var searchXml = sheetObj.GetSearchXml("ESM_BKG_0746GS.do", FormQueryString(formObj));
           		comboObjects[1].RemoveAll(); 
           		comboObjects[2].RemoveAll();
           		//Trade code
				ComBkgXml2ComboItem(searchXml, formObj.sub_trd_cd, "sub_trd_cd", "sub_trd_cd");							
				
				comboObjects[1].InsertItem(0, "All", "");
				
				comboObjects[1].index2 = 0;
				
				comboObjects[2].InsertItem(0, "All", "");
				
				comboObjects[2].index2 = 0;
           break;
           
           case COMMAND02:     //SUB TRADE CODE SEARCH
      		
	      		formObj.f_cmd.value = SEARCH02;   
	 		
	      		var searchXml = sheetObj.GetSearchXml("ESM_BKG_0746GS.do", FormQueryString(formObj));
	      		
	      		comboObjects[2].RemoveAll();
	      		//Trade code
				ComBkgXml2ComboItem(searchXml, formObj.vsl_slan_dir_cd, "vsl_slan_dir_cd", "vsl_slan_dir_cd");							
				
				comboObjects[2].InsertItem(0, "All", "");
				
				comboObjects[2].index2 = 0;
				
		   break;
				
           case SEARCH:     //Main Search >>> BSA by Lane
     		
           		if(!validateForm(sheetObj,formObj,sAction)) return;
	     		
	     		sheetObj.WaitImageVisible = false;
 				ComOpenWait(true);
 				
           		formObj.f_cmd.value = SEARCH;   				
  //         	sheetObj.DoSearch("ESM_BKG_0746GS.do", FormQueryString(formObj));

				var sXml= sheetObj.GetSearchXml("ESM_BKG_0746GS.do", FormQueryString(formObj));
				var arrSXml = sXml.split("|$$|");
				sheetObj.LoadSearchXml(arrSXml[0]);		
				sheetObjects[1].LoadSearchXml(arrSXml[1]);		
				
				
           		if (sheetObj.SearchRows > 0){
           			var maxSize = 8 + eval(ComGetEtcData(arrSXml[0], "max_port_seq"))*3;
           			
           			if(maxSize + 2 < headCount) maxSize  += 2;
           			
           			for (var i = 8 ; i < headCount ; i++){
           				if( maxSize > i)
           					sheetObj.ColHidden(i) 	= false;
           				else
           					sheetObj.ColHidden(i) 	= true;
           			}
           			
           		}
           		if (sheetObjects[1].SearchRows > 0){
           			
           			var maxSize = 18 + eval(ComGetEtcData(arrSXml[0], "max_port_seq"))*20;
           			//if(maxSize + 2 < headCount2) maxSize  += 2;
           			
           			for (var i = 18 ; i < headCount2 ; i++){
           				if( maxSize > i)
           					sheetObjects[1].ColHidden(i) 	= false;
           				else
           					sheetObjects[1].ColHidden(i) 	= true;
           			}
           			
           		}
				
				ComOpenWait(false);
           break;		
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if (formObj.dt_tp[0].checked == true){
    		 
    		 if (formObj.etd_from_dt.value == '' || formObj.etd_to_dt.value == ''){
    			 
    			 ComShowCodeMessage("BKG00499");//Period are mandatory items.
    			 formObj.etd_from_dt.focus();
    			 return false;
    		 }
    		    		 
    		 //@ 해당 월의 일수만큼 제한 일수를 정한다.
//    		 var dateStr = ComTrimAll(formObj.etd_from_dt.value," ", "-");
//    		 var nowDate  = new Date();    		 
//    		 nowDate.setYear(dateStr.substring(0,4));
//    		 nowDate.setMonth(dateStr.substring(4,6) -1 );
//    		 var searchDays = nowDate.getDaysInMonth(nowDate.year,nowDate.month);
    		 if (ComGetDaysBetween(formObj.etd_from_dt.value, formObj.etd_to_dt.value) > 31){
    			 ComShowCodeMessage('COM132001','Port ETD','31 Days')//'{?msg1} exceeds maximum duration {?msg2}.';
    			 formObj.etd_from_dt.focus();
    			 return false;
    		 }
    	 }else{
    		 
    		 if (formObj.cost_year.value == '' || formObj.cost_morth.value == ''){
    			 
    			 ComShowCodeMessage("BKG00499");//Period are mandatory items.
    			 formObj.cost_year.focus();
    			 return false;
    		 }else{
    			 
    			 formObj.cost_yrmon.value = formObj.cost_year.value + formObj.cost_morth.value;
    		 }
    	 }
    	 
    	 //@ 조회 데이타가 많아 범위를 줄여준다. 2014.07.02
    	 if (formObj.slan_cd.value == '' && ComGetObjText(formObj.trd_cd) == "All" ){
    		//msgs['BKG00626'] = "Mandatory field is missing. Please enter {?msg1}."
    		ComShowCodeMessage("BKG00626","Trade or Lane");
			formObj.slan_cd.focus();
			return false;
    	 }

    	 
         return true;
     }

    
     /**
	  * Trade Combo Change Event
      */
	 function trd_cd_OnChange(comboObj,value,text){
		 
		 var formObj  = document.form;
		 
		 if (text == 'All'){
			 
			 comboObjects[1].RemoveAll();
			 comboObjects[2].RemoveAll();
			 
			 comboObjects[1].InsertItem(0, "All", "");
			 comboObjects[2].InsertItem(0, "All", "");
			 
			 comboObjects[1].index2 = 0;
			 comboObjects[2].index2 = 0;
		 }else{
			 
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
		 }
	 }
	  
	  /**
	  * Sub Trade Combo Change Event
      */
	 function sub_trd_cd_OnChange(comboObj,value,text){
		 
		 var formObj  = document.form;
		 
		 if (text == 'All'){
			 
			 comboObjects[2].RemoveAll();
			 comboObjects[2].InsertItem(0, "All", "");
			 comboObjects[2].index2 = 0;
		 }else{
			 
			 doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
		 }
	 }
	  
	  /**
      * Week 날짜 계산
      */  
      function changeWeek(){
    	  
    	  var formObj = document.form;

    	  var week = formObj.cost_wk.value * 7;

    	  formObj.cost_year.value  	= getCalculatedDate(0,0,-week,"").substring(0, 4);
    	  formObj.cost_morth.value 	= getCalculatedDate(0,0,-week,"").substring(4, 6);
    	  
    	  formObj.cost_yrmon.value  = getCalculatedDate(0,0,-week,"").substring(0, 6);
      }
      
      /**
       * 날짜 조회조건 선택
       */  
       function choiceDt(tp){
    	  
    	  var formObj = document.form;
    	   
    	  if (tp == 'ymd'){
     		  
     		  formObj.dt_tp[0].checked = true;
     	  }else{
     	  
     		  formObj.dt_tp[1].checked = true;
     	  }
       }
	  /**
      * 날짜 계산 함수
      */
     function getCalculatedDate(iYear,iMonth,iDay,seperator)
     {
     	//현재 날짜 객체를 얻어옴
     	var gdCurDate = new Date();
     	
     	//현재 날짜에 날짜 계산
     	gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
     	gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
     	gdCurDate.setDate(gdCurDate.getDate() + iDay);
     	
     	//실제 사용할 연,월,일 변수 받기
     	var giYear = gdCurDate.getFullYear();
     	var giMonth = gdCurDate.getMonth()+1;
     	var giDay = gdCurDate.getDate();

     	//월,일의 자릿수를 2자리로 맞춘다.
     	giMonth = "0" + giMonth;
     	giMonth = giMonth.substring(giMonth.length-2,giMonth.length);
     	giDay   = "0" + giDay;
     	giDay   = giDay.substring(giDay.length-2,giDay.length);
     	//alert(giYear + seperator + giMonth + seperator + giDay);
     	//display 형태 맞추기
     	return giYear + seperator + giMonth + seperator + giDay;	
     }

      /**
       * RD(Report Designer) Print
       */
       function goPrint(){	
    	   
    	   var sheetObj= sheetObjects[0];
  	 		
    	   var formObj = document.form;
    	   
    	   var vvds = formObj.vvds.value;
//    	   alert(vvds);
    	   
    	   var tempStr = vvds.split(",");
    	   
//    	   alert(tempStr.length);
    	   for (var i = 0 ; i < tempStr.length ; i++){
    		   
    		   if (i == 0){
    			   
    			   vvds = "'" + tempStr[i] + "'"
    		   }else{
    			   
    			   vvds += ",'" + tempStr[i] + "'"
    		   }
    	   }
		   
    	   var rdPath  = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0818.mrd";
    	   
    	   formObj.com_mrdTitle.value 		= "Vessel Utilization Status BSA by Lane";
  	 	   formObj.com_mrdBodyTitle.value 	= "Vessel Utilization Status BSA by Lane";
  	 	   formObj.com_mrdPath.value 		= rdPath;
  	 	   formObj.com_mrdArguments.value 	= "/ronepgrpt /rremakerpt /rv VVDS[" + vvds + "]";
  	 	   //ComDebug(formObj.com_mrdArguments.value);
  	 	   //alert(formObj.com_mrdArguments.value);
  	 	   ComOpenRDPopup();
       }

	/* 개발자 작업  끝 */   