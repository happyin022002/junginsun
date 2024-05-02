/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0226.js
*@FileTitle : e-BKG And S/I Upload Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.20 김기종
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
     * @class ESM_BKG_0226 : ESM_BKG_0226 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0226() {
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
	
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;

	 var sheetObjects = new Array();
	 var sheetCnt = 0;
	 
	 var arrMultiCombo;// 멀티콤보 세팅할 변수

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var sheetObject3 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
	 			case "btn_Retrieve":
	 				setReportType(ComGetObjValue(formObject.report_type));
	 				if (ComGetObjValue(formObject.report_type)=="P"){
	 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	 				}else if (ComGetObjValue(formObject.report_type)=="D"){
	 					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	 				}else if (ComGetObjValue(formObject.report_type)=="T"){	
	 					doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
	 				}
					break;
					
	            case "btn_DownExcel":
	            	if (ComGetObjValue(formObject.report_type)=="P"){
	            		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="D"){
	            		doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="T"){		
	            		doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
	            	}
					break;
	            case "btn_New":
	            	sheetObjects[0].RemoveAll();
	            	sheetObjects[1].RemoveAll();
	            	sheetObjects[2].RemoveAll();
 					ComResetAll();
 					setDuration('D');
 					break;
 						
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
         initControl();
         options.innerHTML = "'OFF' is the abbreviation of Offline. It means 'Manually processed in NIS or ALPS'";
		/*doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);*/

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
     	//** Date 구분자 **/
     	DATE_SEPARATOR = "-";
     	
     	var formObject = document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	
     	//mainTable[0].style.display ="none";
     	mainTable[1].style.display ="none";
     	mainTable[2].style.display ="none";
		
     	sheetTitleTable[1].style.display ="none";
     	sheetTitleTable[2].style.display ="none";
		
     	sheetLineTable[0].style.display ="none";
     	sheetLineTable[1].style.display ="none";
     	
     	combo1 = comboObjects[0];
 		comboCnt = comboObjects.length;

 		// IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }
 	    
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     	setDuration('D');
     	
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
 								style.height = 374;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msPrevColumnMerge + msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|Region|Booking Office|Booking Office|Month|e-Booking|e-Booking|e-Booking|e-Booking|e-Booking|e-Booking|e-S/I|e-S/I|e-S/I|e-S/I|e-S/I|e-S/I";
 								var HeadTitle2 = "|Region|GSO|Office|Month|TTL|Cancel|Upload|Reject|Pending|PFMC(%)|TTL|Cancel|Upload|Reject|Pending|PFMC(%)";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(false, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true); 
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,		60,		daCenter,		true,		"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,				65,		daCenter,		true,		"region_cd",	false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		"gso",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		"bkg_ofc",		false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		"mon",			false,		"",		dfDateYm,				0,		true,		true);
 								
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"b_ttl",		false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"b_x",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"b_f",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"b_r",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,		"b_pp",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvg,			80,		daRight,		false,		"b_pf",			false,		"",		dfNullFloat,			0,		true,		true);

 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"s_ttl",		false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"s_x",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"s_f",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			50,		daRight,		false,		"s_r",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			55,		daRight,		false,		"s_p",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtAutoAvg,			80,		daRight,		false,		"s_pf",			false,		"",		dfNullFloat,			0,		true,		true);
 								
 								FrozenCols = 5;
 								CountPosition = 0;
 		
 						}
 						break;
 						
 					case "sheet2":
 							with (sheetObj) {
 		
 								// 높이 설정
 								style.height = 370;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msPrevColumnMerge + msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|Region|Booking Office|Booking Office|Month|Delay (Hours)|e-Booking|e-Booking|e-Booking|e-S/I|e-S/I|e-S/I";
 								var HeadTitle2 = "|Region|GSO|Office|Month|Delay (Hours)|Total|Process|Pending|Total|Process|Pending";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,		"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"region_cd",		false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"gso",				false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"bkg_ofc",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"mon",				false,		"",		dfDateYm,				0,		true,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					90,		daRight,		true,		"delay",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daRight,		false,		"b_ttl",			false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daRight,		false,		"b_r",				false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daRight,		false,		"b_pf",				false,		"",		dfNone,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					85,		daRight,		false,		"s_ttl",			false,		"",		dfInteger,				0,		true,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					85,		daRight,		false,		"s_r",				false,		"",		dfInteger,				0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					75,		daRight,		false,		"s_pf",				false,		"",		dfNone,				0,		true,		true);
 								
 								FrozenCols = 5;
 								//CountPosition = 0;
 		
 						}
 						break;

 					case "sheet3":
 							with (sheetObj) {
 		
 								// 높이 설정
 								style.height = 370;
 								//전체 너비 설정
 								SheetWidth = mainTable.clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msPrevColumnMerge + msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = false;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|Region|Booking Office|Booking Office|Month||DOC|STS|Request No|Booking No|POR|POL|POD|DEL|Request Date|Process Date|Delay (Hours)";
 								var HeadTitle2 = "|Region|GSO|Office||Month|DOC|STS|Request No|Booking No|POR|POL|POD|DEL|Request Date|Process Date|Delay (Hours)";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(true, true, false, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,			60,		daCenter,		true,		"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,					55,		daCenter,		true,		"region_cd",		false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"gso",				false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"bkg_ofc",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					60,		daCenter,		true,		"mon",				false,		"",		dfDateYm,				0,		true,		true);

 								InitDataProperty(0,		cnt++ , dtHidden,				60,		daCenter,		true,		"blank",				false,		"",		dfDateYm,				0,		true,		true);
 								
 								InitDataProperty(0,		cnt++ , dtData,					35,		daCenter,		true,		"doc_tp_cd",		false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					35,		daCenter,		true,		"bkg_upld_sts_cd",	false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daLeft,			true,		"xter_rqst_no",		false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					90,		daCenter,		true,		"bkg_no",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"por_cd",			false,		"",		dfNone,					0,		true,		true);
 								                                                                
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"pol_cd",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"pod_cd",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					50,		daCenter,		true,		"del_cd",			false,		"",		dfNone,					0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					110,	daCenter,		true,		"ls_from_dt",		false,		"",		dfUserFormat2,			0,		true,		true);
 								InitDataProperty(0,		cnt++ , dtData,					110,	daCenter,		true,		"ls_to_dt",			false,		"",		dfUserFormat2,			0,		true,		true);
                                                                                 
 								InitDataProperty(0,		cnt++ , dtData,					90,		daRight,		true,		"delay",			false,		"",		dfNullFloat,			0,		true,		true);
 								
 								
 								InitUserFormat2(0, "ls_from_dt", "####-##-## ##:##:##", "-|:" );
 								InitUserFormat2(0, "ls_to_dt", "####-##-## ##:##:##", "-|:" );
 								//CountPosition = 0;
 		
 						}
 						break;
 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
    	 
    	 
         switch(sAction) {
         
          case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0226GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				//var sXml = ComGetObjValue(formObject.sXml);
				arrMultiCombo = sXml.split("|$$|");
				
				if (arrXml.length > 1) 
					ComXml2ComboItem(arrXml[1], formObj.region_cd, "val", "val|name");
				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], formObj.report_type, "val", "val|name");
				if (arrXml.length > 2) 
					ComXml2ComboItem(arrMultiCombo[2], formObj.bkg_upld_sts_cd, "val", "val|name");
				
				formObj.bkg_upld_sts_cd.DeleteItem("N");
				formObj.bkg_upld_sts_cd.DeleteItem("U");
				
				//ComXml2ComboItem(arrMultiCombo[1], formObject.bkg_upld_sts_cd, "val", "val|desc");
				//formObj.region_cd.InsertItem(0, '', '');
				formObj.region_cd.index = 0;
				ComSetObjValue(formObj.report_type,"T");
				break;
           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction)){
 	        	  formObj.f_cmd.value = SEARCH;
 	        	 if (ComGetObjValue(formObj.report_type)=="P" ){
	 	          	  sheetObj.DoSearch("ESM_BKG_0226_1GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""));
 	          	 }else{
 	          		 sheetObj.DoSearch("ESM_BKG_0226GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam(""));	
 	          	 }	 
 	          } 
               break;

           case IBDOWNEXCEL:      // 다운로드
	   				sheetObj.SpeedDown2Excel(-1);
	   				break;	
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
          	switch(sAction) {
 		     	case IBSEARCH: // 조회시 확인
 			  		if (!ComChkValid(formObj)) return false;
 		     	
	 		     	if (!ComIsNull(formObj.duration_from_dt) && !ComIsNull(formObj.duration_to_dt) && ComGetDaysBetween(formObj.duration_from_dt.value, formObj.duration_to_dt.value) > 31){
		           		 
	         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
	         			formObj.duration_from_dt.focus();
	         			return false;
	         		}
 		     	
 			  		break;
          	}	
          }		
          return true;
     }


	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			/*
			ShowSubSum("region_cd", "5|6|7|8|9|10|12|13|14|15|16|17", -1, false, false, 0, "Region=Sub Total;gso=(Region)", "11|18");
			ShowSubSum("gso", "5|6|7|8|9|10|12|13|14|15|16|17", -1, false, false, 0, "region_cd=Sub Total;gso=(GSO)", "11|18");
			*/
			for (var col = SaveNameCol("b_ttl") ; col <= LastCol; col ++){
				var colName = ColSaveName(col);
				SumValue(0, colName) = EtcData(colName);
			}
			SumText(0, "region_cd") = "";
			SumText(0, "bkg_ofc") = "Grand Total";
		}
	}
	
	/**
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.DropHeight = 150;
     }
     
     /**
      * Combo 기본 설정 
      * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
      * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
      */ 
     function initCombo(comboObj, comboId) {
         var formObject = document.form
    	 comboObj.DropHeight = 150;
     	 initComboEditable(comboObj, comboId)
     }    

     
   //콤보 멀티 셀렉트 및 수정 여부 초기 설정
     function initComboEditable(combo, comboId){
      	with (combo) {
      		if(comboId == "bkg_upld_sts_cd") {
      			combo.MultiSelect = true;
         	} else {
         		combo.MultiSelect = false;
         	}
      	}
     }
     
	/**
     * from,to 기간 선택 달력 띄우기
     */
  	function callDatePop(val){
  		var cal = new ComCalendarFromTo();
  		if (val == 'BKG_DATE'){
  			cal.select(document.form.duration_from_dt,  document.form.duration_to_dt,  'yyyy-MM-dd');
  		}
  		
  	}	
  	
  	function setReportType(val){
  		if (val == "P"){
	  		mainTable[0].style.display ="";
	     	mainTable[1].style.display ="none";
	     	mainTable[2].style.display ="none";
			
	     	sheetTitleTable[0].style.display ="";
	     	sheetTitleTable[1].style.display ="none";
	     	sheetTitleTable[2].style.display ="none";
			
	     	sheetLineTable[0].style.display ="none";
	     	sheetLineTable[1].style.display ="none";
	     	
	     	sheetObjects[0].RemoveAll();
  		}else if (val == "D"){
  			mainTable[0].style.display ="none";
	     	mainTable[1].style.display ="";
	     	mainTable[2].style.display ="none";
			
	     	sheetTitleTable[0].style.display ="none";
	     	sheetTitleTable[1].style.display ="";
	     	sheetTitleTable[2].style.display ="none";
			
	     	sheetLineTable[0].style.display ="none";
	     	sheetLineTable[1].style.display ="none";
	     	
	     	sheetObjects[1].RemoveAll();
  		}else if (val == "T"){
  			mainTable[0].style.display ="none";
	     	mainTable[1].style.display ="none";
	     	mainTable[2].style.display ="";
			
	     	sheetTitleTable[0].style.display ="none";
	     	sheetTitleTable[1].style.display ="none";
	     	sheetTitleTable[2].style.display ="";
			
	     	sheetLineTable[0].style.display ="none";
	     	sheetLineTable[1].style.display ="none";
	     	
	     	sheetObjects[2].RemoveAll();
  		}
  	}
  	/**
     * report_type 콤보를 클릭할 때 
     * @param comboObj
     * @param index
     * @param code
     * @return
     */
    function report_type_OnChange(comboObj, index, code) {
    	var formObj=document.form;
    	setReportType(index);
    	if (index == "P"){
    		ComSetObjValue(formObj.bkg_upld_sts_cd,"");
    		formObj.bkg_upld_sts_cd.Enable=false;
    	} else {
    		formObj.bkg_upld_sts_cd.Enable=true;
    	}
  	}
    
    /**
     * from,to 기간 자동 세팅
     */
  	function setDuration(val){
  		var formObject = document.form;
  		makeHtmlDuration(val);
  		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
  	}
  	
  	/**
     * duration에 따른 html적용.
     */
  	
  	function makeHtmlDuration(val){
  		var formObject = document.form;
  		var html = "";
  		if (val == "M"){
  			html = "<td width=\"30\">Year&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "	<input type=\"text\" name=\"duration_year\" style=\"width:40;\" class=\"input1\"  dataformat=\"yy\" caption=\"Year\" maxlength=\"4\" required >";
			html += "</td>";
			html += "&nbsp;<td width=\"40\">Month&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "<input type=\"text\" name=\"duration_month\" style=\"width:20;\" class=\"input1\"  dataformat=\"mm\" caption=\"Month\" maxlength=\"2\" required>";
			html += "</td>";
  		}else if (val == "W"){	
	  		html = "<td width=\"30\">Year</td>";
	  		html += "	<input type=\"text\" name=\"duration_year\" style=\"width:40;\" class=\"input1\"  dataformat=\"yy\" caption=\"Year\" maxlength=\"4\"  required>";
			html += "</td>";
			html += "&nbsp;<td width=\"40\">Week&nbsp;</td>";
			html += "<td width=\"60\">";
			html +=	"<input type=\"text\" name=\"duration_from_week\" style=\"width:30;\" class=\"input1\"  dataformat=\"yy\" caption=\"Week\" maxlength=\"2\"  required>";
			html += "&nbsp;~&nbsp;";
			html +=	"<input type=\"text\" name=\"duration_to_week\" style=\"width:30;\" class=\"input1\"  dataformat=\"yy\" caption=\"Week\" maxlength=\"2\" required >";
			html +=	"</td>";
  		}else if (val == "D"){
  			html = "<td width=\"250\">";
  			html += "<input type=\"text\" name=\"duration_from_dt\" style=\"width:75;\" class=\"input1\"  dataformat=\"ymd\" caption=\"Start Date\" maxlength=\"10\"  required cofield=\"duration_to_dt\">";
  			html += "&nbsp;~&nbsp;";
  			html += "<input type=\"text\" name=\"duration_to_dt\" style=\"width:75;\" class=\"input1\"   dataformat=\"ymd\" caption=\"End Date\" maxlength=\"10\"  required cofield=\"duration_from_dt\">&nbsp;";
  			html += "<img class=\"cursor\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"  style=\"cursor:hand\" onClick=\"callDatePop('BKG_DATE')\">";
  			html += "</td>";
  		}
  		
  		
  		durationHtml.innerHTML =html;	
  		if (val == "D"){
  			ComSetObjValue(formObject.duration_from_dt,ComGetNowInfo());
  	     	ComSetObjValue(formObject.duration_to_dt,ComGetNowInfo());
  	     	
  		}else if (val == "M"){
  			ComSetObjValue(formObject.duration_year,ComGetNowInfo().substr(0,4));
  			ComSetObjValue(formObject.duration_month,ComGetNowInfo().substr(5,2));
  		}else if (val == "M" || val == "W"){
  			ComSetObjValue(formObject.duration_year,ComGetNowInfo().substr(0,4));
  		}
  	}
  	
	/* 개발자 작업  끝 */