/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0190.js
*@FileTitle :  Actual Customer
*Open Issues :
* parameter: sc_no또는 rfa_no,svc_scp_cd는 필수 조건.app_dt는 YYYY-MM-DD 형태
* 예( sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10)
*  ComOpenPopupWithTarget('/hanjin/ESM_BKG_0190.do?sc_no=HAM090003&svc_scp_cd=ACE&app_dt=2009-06-10', 800, 310,'sheet1_cust_cnt_cd:cust_cnt_cd|sheet1_cust_seq:cust_seq', '0,1,1,1,1,1,1', true);">
*  sc_no또는 rfa_no,svc_scp_cd는 필수 입니다.
*  콜백 메소드를 사용하려면 ComOpenPopup 공통 팝업 메소드를 사용하면 됩니다. 
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* =======================================================
* History
* 2014.12.09 최도순[CHM-201432911] E-bkg/Upload 스크린에 A/customer 저장 요청
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
     * @class esm_bkg_0190  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0190() {
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
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }	
	 	    
		    initControl();
		    //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
		    //setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
		    if(!ComIsNull(document.form.app_dt)){
		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    }
		    //form.p_vvd.focus();
		 		
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
		 				case "btn_RowAdd":
		 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
		 					break;
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					location.reload(true);
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				case "btn_Select":
		 					comPopupOK();
							//setActualCustomer(sheetObject1);
		 					break;
		 				case "btn_Close":
		 					self.close();
		 					break;
		 				case "btn_Print":
		 					alert('Print - Under Construction~~');
		 					//RdParam(sheetObject1,prefix);
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
	//			 				debug.innerHTML=FormQueryString(formObj);
				 				//alert(FormQueryString(formObj));
				 				//break;
				 				formObj.f_cmd.value = SEARCH;
		
								var sXml = sheetObj.GetSearchXml("ESM_BKG_0190GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
	
								sheetObjects[0].Redraw = false;    
								sheetObjects[0].WaitImageVisible = false;	
								sheetObjects[0].LoadSearchXml(sXml); 
								sheetObjects[0].Redraw = true; 
								
							if(isNullEtcData(sXml)){
								break;
							}
							formObj.from_dt.value				= ComGetEtcData(sXml, "from_dt") == undefined ? "": ComGetEtcData(sXml, "from_dt") ;
							formObj.to_dt.value				= ComGetEtcData(sXml, "to_dt") == undefined ? "": ComGetEtcData(sXml, "to_dt") ;
			 				break;
			 				
			 			case SEARCH01:      //조회
							break;
			
			 		
						case IBINSERT:      // 입력
							sheetObj.DataInsert(-1);
							break;
							
						case IBDOWNEXCEL:   // 엑셀다운로드
							sheetObj.SpeedDown2Excel(1);
							break;
			
			    }
     }
     
		function setActualCustomer(sheet){
							if(sheet.TotalRows == 0) return;
		 				  var sColStr = sheet.GetSelectionRows();
	 				    var arrRows = sColStr.split("|");				    	
//		 				  alert(sheet.CellValue(arrRows[0],prefix + "cust_cnt_cd")+":" +sheet.CellValue(arrRows[0],prefix + "cust_seq"));
							try{
			 				  opener.setActualCustomer(sheet.CellValue(arrRows[0],prefix + "cust_cnt_cd"), sheet.CellValue(arrRows[0],prefix + "cust_seq"));			
							
							}catch(e){
								ComShowCodeMessage("BKG01036","setActualCustomer");
		     				//alert("부모창에 setActualCustomer메소드를 정의해주세요");
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
	     					ComShowCodeMessage('BKG00016');
	     					return false;
			  	}
			  	if(formObj.bkg_upld_flg.value != "N"){
		    		if (ComIsNull(formObj.svc_scp_cd)) {
		     					ComShowCodeMessage('BKG01034');
		     					return false;
				  	}
				  		
					if(ComIsNull(formObj.bkg_no)){
						ComShowCodeMessage('BKG00626','BKG No.');
						return false;	  		
					}
					
					if(ComIsNull(formObj.app_dt)){
						ComShowCodeMessage('BKG00626','Applicable Date');
						formObj.app_dt.focus();
						return false;	  		
					}
			  	}
								  		
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
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
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

								var HeadTitle1 = " | |Sel.|Seq.|Code|Actual Customer Name ";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
               //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0, cnt++ , dtHidden,	    10,		daCenter,		false,		prefix + "cust_cnt_cd");
								InitDataProperty(0, cnt++ , dtHidden,	    40,		daCenter,		false,		prefix + "cust_seq");
								InitDataProperty(0, cnt++ , dtRadioCheck, 40,   daCenter,   false,    "radio");
								InitDataProperty(0, cnt++ , dtSeq,		    50,		daCenter,		false,		prefix + "seq");
								InitDataProperty(0, cnt++ , dtData,		    190,	daLeft,			false,		prefix + "code",					  false,			"",      dfNone,			0,		false,		false);
								InitDataProperty(0, cnt++ , dtData,		    100,	daLeft,			false,		prefix + "cust_lgl_eng_nm",	false,			"",      dfNone,			0,		false,		false);                    
            
			 					CountPosition = 0;//[1/3] 페이지 위치 
 						}
 				
 					break;
         
         }
     }
    

	/* 개발자 작업  끝 */    
										
		