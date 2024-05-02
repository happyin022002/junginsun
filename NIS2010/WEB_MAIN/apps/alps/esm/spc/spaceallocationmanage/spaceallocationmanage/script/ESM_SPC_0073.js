/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_SPC_0073.js
*@FileTitle :  Customer/Commodity Info
*Open Issues : ESM_BKG_0190 copy하여 생성 
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 신자영
* 2014.12.09 신자영
* 1.0 Creation
* 2014.12.08 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
* 2015.05.27 SPC-BKG 연동 - ESM_SPC_0115에서 호출시 로직 추가
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
     * @extends 
     * @class esm_spc_0073  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_spc_0073() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var prefix = "sheet1_";//IBSheet 구분자
 
 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
 /*********************** EDTITABLE MULIT COMBO END ********************/
 	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(var i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
		 }	
	 	    
		 initControl();	
		 //ESM_SPC_0115에서 사용하기위해 추가
		 var fObj = document.form;
		 var sheetObj = sheetObjects[0];
		 if(fObj.pgmNo.value = 'ESM_SPC_0115') {
			 doActionIBSheet(sheetObj,fObj,IBSEARCH);
			 checkedActAcctCmdt(sheetObj, fObj);
		 } 
		    
     }
	
	 	
	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
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
	      case "engdnnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('lowernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "app_dt":
	    		ComAddSeparator(event.srcElement);
					break;
				default:
					break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
			var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "app_dt":
	    		ComClearSeparator(event.srcElement);
					break;
				default:
					break;
	    }
	}  

/*********************** KEY EVENT END ********************/
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var comboObject1 = comboObjects[0]; 
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_Select":
					comPopupOK();
					break;
				case "btn_Close":
					self.close();
					break;
				case "btn_app_dt":
					var cal = new ComCalendar();
					cal.select(formObject.app_dt, 'yyyy-MM-dd');
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
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH;
				var param = SpcFormString(formObj,"f_cmd,sc_no,rfa_no,app_dt,cust_lgl_eng_nm,type");
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0073GS.do", param + "&" + ComGetPrefixParam(prefix));

				sheetObjects[0].Redraw = false;    
				sheetObjects[0].WaitImageVisible = false;	
				sheetObjects[0].LoadSearchXml(sXml); 
				sheetObjects[0].Redraw = true; 
//							duration 정보 사용하지 않으므로 숨김	
//							if(isNullEtcData(sXml)){
//								break;
//							}
//							formObj.from_dt.value			= ComGetEtcData(sXml, "from_dt") == undefined ? "": ComGetEtcData(sXml, "from_dt") ;
//							formObj.to_dt.value				= ComGetEtcData(sXml, "to_dt") == undefined ? "": ComGetEtcData(sXml, "to_dt") ;
				break;
		}
	}

/**
* 조회후  이벤트 처리 >>> 폰트 칼라변경
*/ 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	}
     
	function setCelColor(flag, obj,idx,celName,color){
    	 if(flag =="N")
    		 obj.CellFontColor(idx,celName) = color;
	}
   
/*
*  Search Option or Item Option Modify
* */
	function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
		sheetObj.CellValue(rowIdx, "radio") = 1;
	}	      
	 	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.sc_no) && ComIsNull(formObj.rfa_no)) {
	    			ComShowMessage(getMsg("SPC90114", "SC/RFA"));
	    			formObj.sc_no.focus();
	     			return false;
			  	}
//	    		if (ComIsNull(formObj.app_dt)) {
//	    			ComShowMessage(getMsg("SPC90114", "Applicable Date"));
//	    			formObj.app_dt.focus();
//	     					return false;
//			  	}
	    		
//			  	
//	    		if (ComIsNull(formObj.svc_scp_cd)) {
//	    			alert("input check");
//	     					return false;
//			  	}
			  		
//					if(ComIsNull(formObj.bkg_no)){
//						alert("input check");
//						return false;	  		
//					}
					
//					if(ComIsNull(formObj.app_dt)){
//						alert("input check");
//						formObj.app_dt.focus();
//						return false;	  		
//					}
								  		
	  			break;
    	 }
         return true;
     }
     
     /**
      * 화면 yyyyMMd 날짜 체크
      */
	function dateCheck(dateobj){
		if(dateobj.value =="") return true;//null이면 체크 안함
		return ComIsDate(dateobj.value);
	}	


    
	function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    

 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id){
			case "sheet1":
				with (sheetObj){
					// 높이 설정
					style.height = 162;
                 
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 11, 100);

					var HeadTitle1 = " | |Seq.|Code|SC|RFA|Code Description ";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,    	daCenter,  		false,    	"radio",   					false,          "",	dfNone,		0,		true,       true);
					InitDataProperty(0, cnt++ , dtCheckBox,  	30,    	daCenter,  		false,    	"checkbox",   				false,          "",	dfNone,   	0,		true,       true);
					InitDataProperty(0, cnt++ , dtSeq,		    50,		daCenter,		false,		prefix + "seq");
					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,		false,		prefix + "code",			false,			"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,			false,		prefix + "sc_no",	false,			"",	dfNone,		0,		false,		false);                    
					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,			false,		prefix + "rfa_no",	false,			"",	dfNone,		0,		false,		false);                    
					InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,			false,		prefix + "cust_lgl_eng_nm",	false,			"",	dfNone,		0,		false,		false);                    
         			
					CountPosition = 0;//[1/3] 페이지 위치 
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 			}
 				
			break;
		}
	}
	/*
	 * ESM_SPC_0115에서 사용, 부모창에 있는 Code들을 조회 후 check 처리
	 */
	function checkedActAcctCmdt(sheetObj, fObj){
		var arrData = fObj.actAcctCmdt.value.split(",");
		for(var k=0; k<arrData.length; k++) {
			var rnum = sheetObj.FindText(prefix+"code", arrData[k], 0);
			if(rnum>-1) {
				sheetObj.CellValue(rnum, "checkbox") = 1;
			}
		}
	}

	/* 개발자 작업  끝 */    
		