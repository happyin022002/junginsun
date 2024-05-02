/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2011.js
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.11 최성환
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
     * @class EES_DMT_2011 : EES_DMT_2011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2011() {
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
	
    var COMMON_TARIFF_CD = "common_tariff_cd"; 
    var ROWMARK = "|";
    var FIELDMARK = "=";
    var set_day = 21;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;
         var srcObj = window.event.srcElement;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
				switch(srcName) {
					case "btns_calendar": //달력 버튼
			         	if(srcObj.style.cursor == "hand") {
				            var cal = new ComCalendarFromTo();
				            cal.select(formObject.fm_dt,  formObject.to_dt,  'yyyy-MM-dd');
			         	}
						break;	
				
					case "btn_Retrieve":	
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;

					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						var formObject = document.form; 
					    //var data = getDefaultDate(set_day).split("|");
						//formObject.fm_dt.value = data[1];
						//formObject.to_dt.value = data[0];
						var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject); 
						//조회한 날짜를 화면의 필드에 매핑 시킨다.
						ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -21)); //21일 이전 날짜.
						ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
						
						sheetObject1.RemoveAll();
						break;

					case "btn_Detail":
						alert(srcName);
						break;


					case "btn_DownExcel":
						sheetObject1.Down2Excel(true);
						break;
						
					case "btn_Print":
						alert(srcName);
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
		
		// 초기 날짜 값 셋팅
		var formObject = document.form; 
	    //var data = getDefaultDate(set_day).split("|");
		//formObject.fm_dt.value = data[1];
		//formObject.to_dt.value = data[0];
		var ofcCurrDate = DmtComOfficeCurrDate(sheetObjects[0], formObject); 
		//조회한 날짜를 화면의 필드에 매핑 시킨다.
		ComSetObjValue(formObject.fm_dt, 	ComGetDateAdd(ofcCurrDate, "D", -21)); //21일 이전 날짜.
		ComSetObjValue(formObject.to_dt,   	ofcCurrDate);  //오늘 날짜.
		
		ComSetFocus(formObject.r_date[0]);
    }

 	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate','obj_deactivate',  form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('beforeactivate',	'obj_activate',    form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- 키보드 입력할때
		axon_event.addListener('click', 'obj_click', 'cond_type'); 
	}
    function obj_click() {
    	 doEnableCondObj(event.srcElement.value);
    } 
     	

    //포커스가 나갈 때
    function obj_deactivate(){
        //입력Validation 확인하기 + 마스크구분자 넣기
        ComChkObjValid(event.srcElement);
    }
    
    /**
     * HTML Control Foucs in
     */
    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
	   	 switch(event.srcElement.dataformat){
	        	case "engup":
			    	// 영문대+숫자 
	        		ComKeyOnlyAlphabet('uppernum');
			        break;
	        	default:
		         	// 숫자만입력하기(정수,날짜,시간)
		            ComKeyOnlyNumber(event.srcElement);
	   	 }
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
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObject = document.form
  		
  	    switch(comboNo) {  
  	    		
  	          case 1: 
  	        	with (comboObj) { 
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left"); 
					SetColWidth("60|300");
					DropHeight = 160;
  		    	}
  				//doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
  				break; 
  				
  	          case 2: 
  	           with (comboObj) { 
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left");   
					SetColWidth("50|300");
					DropHeight = 160;
  		    	}
  				//doActionIBCombo(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
  				break; 
  	     } 
  	}

     //쉬트 로드 후에 콤보리스트 콜. 깜빡임 방지 방안
	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		sheetObjects[0].WaitImageVisible = false;   

  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
  		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC02);

        sheetObjects[0].WaitImageVisible = true;   
        	
  	}  
    	
  	function doActionIBCombo(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
        switch(sAction) {

		        case IBSEARCH_ASYNC01:  
			 		//1. Tariff type comboList
			 		var sComboObj = comboObjects[1];
			 		//1. Tariff type comboList
					formObj.f_cmd.value = SEARCH09;
					//2.조회조건으로 조회실행
					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					//3.조회후 결과처리
					var result;
					var comboItem;
					var comboItems;
	
					//3-1.해당 콤보필드에 조회된 결과 처리
					var comboItems = ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
					addComboItem(sComboObj,comboItems);
					
				break;
				
		        case IBSEARCH_ASYNC02:  
					//2. Office comboList
					formObj.f_cmd.value = SEARCHLIST01;
		    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
			    	    var ofc_nms = ComGetEtcData(sXml, "OFC_NM");

			    	    var comboCodeArr = ofc_cds.split("|");			    	    
			    	    var comboTextArr = ofc_nms.split("|");
			    	    var comboObj = comboObjects[0];
			    	    
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
		    	    }
		    	   
				break;
				
		        case IBSEARCH_ASYNC03:     	
					//3. Sub Office comboList
					formObj.f_cmd.value = COMMAND01;
		    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		    	    if (sXml != undefined && sXml != '') {
			    	    var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
			    	    var comboObj = comboObjects[0];
		    	    	if(ofc_cds != '') 
		    	    		comboObj.Code = ofc_cds;
		    	    }
		    	   
				break;
        }
		sheetObj.WaitImageVisible = true;
    }
	
    /**
	 * 콤보필드에 데이터를 추가해준다.
	 */
	function addComboItem(comboObj, comboItems) {
		for ( var i = 0; i < comboItems.length; i++) {
			var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
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
                    style.height = 414;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Seq.|Status|Clock Stop No.|Office|Tariff|From|To|Stop Days|Remark(s)|Creation/Cancellation|Creation/Cancellation|Creation/Cancellation";
					var HeadTitle2 = "|Seq.|Status|Clock Stop No.|Office|Tariff|From|To|Stop Days|Remark(s)|Office|Name|Date";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount+2, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,			30,		daCenter,		true,		"hdnStatus");
                    InitDataProperty(0,	cnt++ ,	dtSeq,					35,		daCenter,		true,		"",							false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,					65,		daCenter,		true,		"cxl_flg",					false,		"",		dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,					110,	daCenter,		true,		"clk_stop_no",				false,		"",		dfNone,			0,	false);
                    //clock time no로 팝업 호출시에 아래 내용을 사용.
                    //InitDataProperty(0,	cnt++ ,	dtPopup,					110,	daCenter,		true,		"clk_stop_no",		false,		"",		dfNone,			0,	true, true);
                    InitDataProperty(0,	cnt++ ,	dtData,					60,		daCenter,		true,		"clk_stop_ofc_cd",			false,		"",		dfNone,			0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"dmdt_trf_cd",				false,		"",		dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,					75,		daCenter,		true,		"clk_stop_fm_dt",			false,		"",		dfDateYmd,	 	0,	false);
                    InitDataProperty(0, cnt++ , dtData,					75,		daCenter,		true,		"clk_stop_to_dt",			false,		"",		dfDateYmd,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daCenter,		true,		"stop_days",				false,		"",		dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,					195,	daLeft,			true,		"clk_stop_rmk",				false,		"",		dfNone,			0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		true,		"upd_ofc_cd",				false,		"",		dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,					80,		daLeft,			true,		"upd_usr_id",				false,		"",		dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		"upd_dt",					false,		"",		dfDateYmd,		0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,				0,  	daLeft,			true,		"clk_stop_yd_cd",			false,		"",		dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,				0,	    daLeft,		    true,		"dmdt_bkg_term_ctnt",		false,		"",		dfNone,		    0,	false);


//                    ImageList(0) = "/hanjin/img/enis/button/btns_search.gif";
//                    PopupButtonImage(0, "clk_stop_no") = 0;
                    ToolTipOption="balloon:true;width:50;";
 					CountPosition = 0;
 					//2010.04.04
 					Ellipsis = true;

				}
                break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
	
		case IBSEARCH: //조회
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				if (!validateDate(formObj)) {
					return false
				}
				if (formObj.r_date[0].checked) {
					formObj.date_period.value = "creation";
				} else if (formObj.r_date[1].checked) {
					formObj.date_period.value = "stop_date";
				}
				//office code :comboObjects[0]
				if (comboObjects[0].Text == '') {
					formObj.office.value = "";
				} else {
					
					formObj.office.value = "stop_office";
					//요청으로 office radio 버튼 삭제 
//					if (formObj.r_office[0].checked) {
//						formObj.office.value = "creation";
//					} else if (formObj.r_office[1].checked) {
//						formObj.office.value = "stop_office";
//					}
				}
				//office code :comboObjects[0]
				formObj.clk_stop_ofc_cd.value = comboObjects[0].Text;
				//tariff code : comboObjects[1]
				formObj.dmdt_trf_cd.value = comboObjects[1].Text;
				
				//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
		        
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("EES_DMT_2011GS.do",	FormQueryString(formObj));
				
				//ComOpenWait End
				ComOpenWait(false);
			
			break;
	
		case IBCLEAR:       //초기화 
			initSearchControls();
			//buttonMode("IBCLEAR");
			break;
	
		case IBINSERT: // 입력
			break;
		}
	}



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
    
    /**
   	  * INIT SETTING
   	  */
   	function initSearchControls() {
   		var formObj = document.form;
   		comboObjects[0].Text = "";
   		ComClearObject(formObj.clk_stop_ofc_cd);   		
   		comboObjects[1].Text = "";
   		ComClearObject(formObj.dmdt_trf_cd);
   		ComClearObject(formObj.fm_dt);
   		ComClearObject(formObj.to_dt);
   		ComClearObject(formObj.cxl_flg);	
   		formObj.r_date[0].checked = true;
   		formObj.chk_sub_ofc.checked = false;
   	}
        
    
    /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	function validateForm(sheetObj,formObj,sAction){
		if(IBSEARCH == sAction ){
			if(formObj.fm_dt.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Period");
				ComSetFocus(formObj.fm_dt);
				return false;
			} else if(formObj.to_dt.value.trimAll().lengthByte() <= 0){
				ComShowCodeMessage('DMT02002', "Period");
				ComSetFocus(formObj.to_dt);
				return false;
			} 
		}
		return true;
	}

	/**
	  * 날짜값의 유효성검증 프로세스 처리
	  */
	function validateDate(formObj){
		// 기간 검색제약 조건  삭제 
//		if(ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) > 0){
//			if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 21){
//				ComShowCodeMessage('DMT00103');
//				return false;
//			}
//		} else 
		if (ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) <= 0){
			ComShowCodeMessage('DMT01020');
			return false;
		} 
		return true;
	}
	
	/**
	  * Clock Stop no를 클릭시에 EES_DMT_2010화면을 팝업으로 호출
	  *	parm: Clock Stop no , parm2: popup flag(Y 일경우만 2010화면에서 호출 됨.)
	  */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var parm = sheetObj.CellValue(Row, Col);
		ComOpenPopup('/hanjin/EES_DMT_2010.do?parm='+parm+'&parm2=Y', 800, 500, '', '0,1', false, false, Row, Col, 0);
	}
	
	/**
	  * Remark 말풍선 
	  */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
			Row = MouseRow;
			Col = MouseCol;
			if (Row > 0 && Col == 9) {
				MouseToolTipText = CellText(Row, Col);
			} else if (Row > 0 && Col == 4) {
				MouseToolTipText = CellText(Row,"clk_stop_yd_cd");
			} else if (Row > 0 && Col == 5) {
				MouseToolTipText = CellText(Row,"dmdt_bkg_term_ctnt");
			} else {
				MouseToolTipText = "";
			}
		}
	}
	  

	  
	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
	
		  var formObj = document.form;
	
		  if (formObj.chk_sub_ofc.checked) { // Sub Office 포함
			  if (ComIsEmpty(comboObjects[0].Code)) {
				  ComShowCodeMessage('COM12113', "DEM/DET Office");
				  formObj.chk_sub_ofc.checked = false;
				  return;
			  }

			  formObj.ofc_cd.value = ComGetObjValue(comboObjects[0]);
			  formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[0]);	// 2010.03.18 추가(hkhwang) - JSP tmp_ofc_cd 추가
			  doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
		  } else {
			  ComSetObjValue(comboObjects[0], formObj.tmp_ofc_cd.value);	// 2010.03.18 tmp_ofc_cd 수정(hkhwang)
		  }
	}
	
	//멀티콤보 클릭 이벤트
	function combo1_OnCheckClick(comboObj, index, code) {
		if(index==0) {
	    	//checked
	    	var bChk = comboObj.CheckIndex(index);
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = bChk;
	    	}
	    } else {
			comboObj.CheckIndex(0) = false;
	    }
	}	
	
 	function combo2_OnCheckClick(comboObj, index, code) {
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
 	function combo2_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
    
	function keyPress() {
		var eventKey = window.event.keyCode ;
			if( eventKey == 13 ) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		}
	document.onkeypress = keyPress ;
	/* 개발자 작업  끝 */