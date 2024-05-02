/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7016.js
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
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
     * @class EES_DMT_7016 : EES_DMT_7016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7016() {
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
     		
     		// 팝업창 링크 아이콘 클릭시  비활성화 상태이면 그냥 return
     		if(!ComIsBtnEnable(srcName)) return;

     		switch(srcName) {
	            case "btn_Calendar":
	                if (!window.event.srcElement.disabled) {
	                    var cal = new ComCalendarFromTo();
	                    cal.select(formObj.fm_dt, formObj.to_dt, "yyyy-MM-dd");
	                }
	                break;
        		     
     			case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				
				case "btn_New":
					doInit();
					break;
					
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
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
		  
		  // 화면 초기화
		  doInit();
	}
	  
	  
	// 이벤트 처리 함수 선언
  	function initControl() {
  		axon_event.addListenerForm('blur',	'obj_blur',	document.form); //- 포커스 나갈때
  		axon_event.addListenerFormat('focus', 'obj_focus', document.form);
   		axon_event.addListenerFormat('keypress','obj_keypress', document.form);			//- 키보드 입력할때
   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//   		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');	// DEM/DET Office 라디오버튼 클릭시
//   		axon_event.addListener('click', 'incl_dc_click', 'incl_dc');	// 'Incl. CNTR Column' CheckBox 클릭시
//   		axon_event.addListener('click', 'sch_flg_click', 'sch_flg');
//   		axon_event.addListener('change','sttl_lvl_change', 'sttl_lvl');
  	}
	
  	function obj_keydown() {
  		//if(CHK_LOCK_FLG) return;
  		ComKeyEnter();
  	}
	
  	var CHK_LOCK_FLG = false;
  	
	
	   
	// 화면 초기화 설정
	function doInit() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		ComResetAll();
		sheetObj.RemoveAll();
		
        //=========================================================================================
        // 변경일자 : 2017.10.16 
        // 변경내용 : Period 를 12개월로 변경함.
        // 변경사유 : CSR #2236 [DMT] Current Collection Status by Office 메뉴 내 추가 개발 요청 건
        //==========================================================================================
		formObj.fm_dt.value = ComGetDateAdd(null, "M", -1 * REPORT_INQUIRY_PERIOD, "-");
		formObj.to_dt.value = ComGetNowInfo();

		  // IBMultiCombo초기화 
		for(var k=0;k<comboObjects.length;k++){
			comboObjects[k].RemoveAll();
		}
	    for(var k=0;k<comboObjects.length;k++){
		    initCombo(comboObjects[k],k+1);
		}
		  
//		DmtComEnableManyBtns(false, "btn_DownExcel");
	}
	

	//포커스가 나갈 때
    function obj_blur(){
 		var srcObj = window.event.srcElement;
 		var srcName = srcObj.getAttribute("name");
        //입력Validation 확인하기 + 마스크구분자 넣기
    	var obj = event.srcElement;
        if (srcName == "fm_dt" || srcName == "to_dt") {
        	ComChkObjValid(obj);
        }
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
                     style.height = 370;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);
                     
                     var HeadTitle1 = " |Seq.|Terminal EDI|Terminal EDI|Terminal EDI|Terminal EDI|Terminal EDI|Terminal EDI|Terminal EDI|Terminal EDI|ALPS / DMT|ALPS / DMT|ALPS / DMT|ALPS / DMT|Days|Result|BKG Flag";
                     var HeadTitle2 = " |Seq.|Conatiner No.|T/S|Yard CD|Guarantee Flag|Guarantee Date|LFD Date|Receiving Date|EDI Booking|DMT type|F/T END Date|Booking NBR|VVD|Days|Result|BKG Flag";
                     //var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(18, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,		daCenter,   false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtSeq,    		50,    	daCenter,   true,   "seq",				false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"cntr_no",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		50,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		80,		daCenter,	true,	"yd_cd",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,	true,	"gnte_flg",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,	true,	"gnte_dt",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,	true,	"evnt_dt",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,	"rece_dt",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"bkg_no",			false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"dmdt_trf_cd",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,	"ft_end_dt",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"alps_bkg_no",		false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		120,	daCenter,	true,	"vvd",				false,	"",		dfNone,			0,	false,	true);
                     InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,	true,	"days",				false,	"",		dfNone,			0,	false,	true);                     
                     InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,	true,	"result",			false,	"",		dfNone,			0,	false,	true);                   
                     InitDataProperty(0, cnt++ , dtData,   		50,		daCenter,	true,	"bkg_flg",			false,	"",		dfNone,			0,	false,	true);
                     
                     CountPosition = 2;
                     ToolTipOption="balloon:true;width:400;";
                     Ellipsis = true;
                 }
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
  	    	case "cntr_tpsz_cd":
  	    		with (comboObj) { 
	                MultiSelect = true;
	                DropHeight = 160;
	                // coCtm.js의 code_get호출
	                var rtnValues = code_get("CNTR_TPSZ_CD", "'N' AND CNTR_TPSZ_CD  NOT IN ('Q2', 'Q4')", "DELT_FLG", "MDM_CNTR_TP_SZ");
	                parseMultiCombo(comboObj, "^#^" + rtnValues, "All^#^" + rtnValues);
	                if (formObj.cntr_tpsz_cd.value != "" && formObj.cntr_tpsz_cd.value != undefined ) {
	                    Text = formObj.cntr_tpsz_cd.value;
	                } else {
	                	comboObj.Text = "All";
	                }
  			    }
  		    	break;
  		    	
  		    	s_cntr_tpsz_cd
  		    	
  	    	case "yd_cd":
     	    	with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = false;    
                    SetColAlign("left");
                    SetColWidth("60");
                    DropHeight = 160;
                    ValidChar(2,1);     //영문 대문자, 숫자
                    MaxLength = 2;
                }
                comboObj.InsertItem(0, "", "");
     			break;

            case "result": // CUSTOMER TYPE
                with (comboObj) { 
                    MultiSelect = true; 
                    SetColAlign("left|left");   
                    SetColWidth("60|300");
                    DropHeight = 160;
                }
                comboObj.InsertItem( 0 , "All"  , "A" );
                comboObj.InsertItem( 1 , "Coincidence" , "C" );
                comboObj.InsertItem( 2 , "Descripency" , "D" );
                comboObj.Code2 = "A";
            break;
  	    }
  	}

	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;
		
		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
 		    	// 영문대+숫자+예외문자
          		DmtComKeyOnlyAlphabet('uppernum', ',');
 		        break;
          	case "engup3":
          		//영문입력시에는 대문자로 변환
          		DmtComKeyOnlyAlphabet('upperall')
          		break; 		        
          	case "int":
     	        //숫자 만입력하기
     	        ComKeyOnlyNumber(event.srcElement);
     	        break;
          	default:
 	         	// 숫자만입력하기(정수,날짜,시간)
 	            ComKeyOnlyNumber(event.srcElement);
		}
		//조회옵션으로 DAR 항목을 선택한 후 특정 필드에 데이터를 입력하면, 기타 다른 필드들에 입력된 값은 Clear 시킨다. 
//		clearNoSelectConditionFields();
	}
	
      
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
			
				sheetObj.WaitImageVisible=false;
	        	ComOpenWait(true);
	        	
	        	if( formObj.chk_latest.checked == true){
	        		formObj.latest.value = "Y";
	        	} else {
	        		formObj.latest.value = "N";
	        	}
	        	
				formObj.f_cmd.value = SEARCH;
	       		sheetObj.DoSearch("EES_DMT_7016GS.do", FormQueryString(formObj));
//	       		ComOpenWait(false);
				break;

            //Yard 입력완료시 Yard List 조회
            case SEARCH14:
            	
            	ComSetObjValue(formObj.f_cmd, SEARCH14);

                //2.조회조건으로 조회실행                 
                var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                
                comboObjects[1].RemoveAll();                      
                //Country 콤보 조회된 데이터로 선택
                comboDatas = ComGetEtcData(sXml, "YD");

                if (comboDatas == undefined ||comboDatas == "") {
                    //ComShowCodeMessage("DMT06001");
                    //ComSetObjValue(formObj.cvrg_location, "");
                    //ComSetObjValue(formObj.yd_cd1, "");
                    
                }else{
                    
                    comboItems = comboDatas.split("|");
                    addComboItem1(comboObjects[1],comboItems);    
                    setComboItem(comboObjects[1],comboItems);
                    
                }
                
                break;
         }
	}

    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */ 
    function setComboItem(comboObj,comboItems) {
        var checkedItem = comboItems[0].split("=");
        comboObj.Text = checkedItem[0];
    }   
    /**
     * 콤보필드에 데이터를 추가해준다.
     */ 
    function addComboItem1(comboObj, comboItems) {
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split("=");
            comboObj.InsertItem(i, comboItem[1], comboItem[0]);     
        }           
    }


	/**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
	function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
        	 	case IBSEARCH:        	 		
  					if(!ComIsDate(fm_dt)) {
         				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_dt)) {
         				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}        	 		
	                
  					var startDt = ComGetUnMaskedValue(fm_dt, 'ymd');
         			var endDt = ComGetUnMaskedValue(to_dt, 'ymd');
         			/*
         			ComChkPeriod(fromDate, toDate)
         			0 : fromDate > toDate
         			1 : fromDate < toDate
         			2 : fromDate = toDate
         			*/
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
         			
        	 		break;
        	 		
        	 } // switch - end
         } // with - end

         return true;
	}
	
	
//	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
//		if(sheetObj.SearchRows == 0) {
//			DmtComEnableManyBtns(false, "btn_DownExcel");
//			return;
//		}
//		
//		DmtComEnableManyBtns(true, "btn_DownExcel");
//	}	
	

	/**
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴
	 * param : code_value, column_nm, table_nm
	 */
	function code_get(Return, Value, Column, Table) {
	    if (!Value || !Column || !Table) return false;
	    var sheetObj = sheetObjects[0];
	    var coCtmXml = sheetObj.GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH18 + "&return_nm=" + Return + "&code_value=" + Value + "&column_nm=" + Column + "&table_nm=" + Table);
	    var rtnValue = ComGetEtcData(coCtmXml, "rtnValue");
	    if (rtnValue == null) {
	        return "";
	    } else {
	        return rtnValue.trim();
	    }
	}

	/**
	* String으로 받은 Code값과 Text로 IBMultiCombo 생성
	* Param ComboObj    : [ComboObject]
	* Param CodeString    : [Combo의 Code값 (연결문자 : ^#^)]
	* Param TextString    : [Combo의 Code값 (연결문자 : ^#^)]
	*/
	function parseMultiCombo(ComboObj, CodeString, TextString) {
	    var ComboCodeList = CodeString.split("^#^");
	    var ComboTextList = TextString.split("^#^");
	    ComboObj.RemoveAll();
	    for (var w=0; w<ComboCodeList.length-1; w++) {
	        ComboObj.InsertItem(w, ComboTextList[w], ComboCodeList[w]);
	    }

	}
	

  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		var paramVal = '';
  		var sScroll = 'no';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'bkg_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'cntr_no':		// CNTR No. 멀티입력 팝업 호출
	  				// 멀티입력 팝업 타이틀 세부 내용 지정
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle = 'CNTR No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
					
	  		} // switch - end
  		} // with(sheetObj) - end
  		
  		if(sUrl != '') {
  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
  		}
  	}
  	
    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }
    

//    /*
//     * yd_cd1 조회필드에서 LOCATION에 해당하는 YARD 정보를 조회하는 함수
//     */     
//    function checkYard1(obj) {
//        if(isAlphaNum()) {
//            checkYard1_sub2(obj);
//        }
//    }
    
    /*
     * yd_cd1 입력시 yd_cd list를 조회한다.
     */
    function checkYard1_sub2(obj) {
        
        var formObj = document.form;
        var yardCd1 = ComTrim(ComGetObjValue(obj));
        
        if (yardCd1.length == 5) {
        	formObj.yd_cd1.value = yardCd1;
        	doActionIBSheet(sheetObjects[0],formObj,SEARCH14);
        }
    }
    
 	/**
  	 * tpsz 멀티콤보 CheckClick 이벤트 처리
  	 * @param comboObj
  	 * @param index
  	 * @param code
  	 * @return
  	 */
  	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//var codes = comboObj.Code;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All check
					comboObj.Text = "All";
				else // All uncheck
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			}
		}
	}
  	
 	/**
  	 * tpsz 멀티콤보 CheckClick 이벤트 처리
  	 * @param comboObj
  	 * @param index
  	 * @param code
  	 * @return
  	 */
  	function result_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		//var codes = comboObj.Code;
		
		with (formObj) {
			if(index == 0) {
				if(comboObj.CheckIndex(0))	// All check
					comboObj.Code = "A";
				else // All uncheck
					comboObj.Code = '';
			} else if(comboObj.CheckIndex(0)) {
				comboObj.CheckIndex(0) = false;
			}
		}
	}


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            var frmObj = document.form;
            with(sheetObj) {
                frmObj.rtv_total.value = ComAddComma(RowCount);
                frmObj.gnd_total.value = ComAddComma(EtcData("gnd_total"));
            }
        }
        ComOpenWait(false);
        sheetObjects[0].WaitImageVisible = true;
    }

	/* 개발자 작업  끝 */