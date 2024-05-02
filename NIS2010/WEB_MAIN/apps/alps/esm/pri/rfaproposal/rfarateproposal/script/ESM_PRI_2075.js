/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2075.js
*@FileTitle : RFA Proposal Inquiry – Rate – Specification
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.20 김재연
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
     * @class ESM_PRI_2075 : ESM_PRI_2075 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2075() {
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
    var LEN_OVER = false;
    var WDT_OVER = false;
    var HGT_OVER = false;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_search":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
	
				case "btn_close":
					window.close();
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
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
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
     	var sheetId = sheetObj.id;

        switch(sheetId) {
        
	        case "sheet1":      //hidden 
		        with (sheetObj) {
		
		            // 높이 설정
		            style.height = 80;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msNone;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false)
		
		            var HeadTitle = "stat|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|rt_seq|rat_ut_cd|cntr_len|cntr_wdt|cntr_hgt|cntr_wgt|act_cgo_len|act_cgo_wdt|act_cgo_hgt|act_cgo_wgt|cgo_spec_rmk";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 3, 100);
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		            
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);

		            
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  
		            //KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, 
		            //TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
		            
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "prop_no"		);
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "amdt_seq"		);
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "svc_scp_cd"	);
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "cmdt_hdr_seq"	);
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "rout_seq"		);
		            InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "rt_seq"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,	false,  "rat_ut_cd"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,   false,  "cntr_len"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,   false,  "cntr_wdt"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,   false,  "cntr_hgt"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,   false,  "cntr_wgt"		);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,  	false,  "act_cgo_len"	);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,  	false,  "act_cgo_wdt"	);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,  	false,  "act_cgo_hgt"	);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,  	false,  "act_cgo_wgt"	);
					InitDataProperty(0, cnt++, dtData,	70,	daCenter,  	false,  "cgo_spec_rmk"	);
					
					AutoRowHeight = false;
					WaitImageVisible = false;
		        }
		        break;
        }
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.10.20
	 */
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "/";
 		
 		axon_event.addListenerForm('focus', 'obj_focus', form);
 		axon_event.addListenerForm('blur', 'obj_blur', form);
 		axon_event.addListenerForm('keyup', 'obj_keyup', form);
 		axon_event.addListenerForm('activate', 'obj_activate', form);
 		axon_event.addListenerForm('click', 'obj_click', form);
 	}
 	
 	/**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
 	function obj_blur(){
 		srcName = event.srcElement.name;
 		srcValue = event.srcElement.value;
 		
 		switch(srcName) {
 		
 			case "act_cgo_len":
 				calcLength();
 				calcAddDeadSlot();
 				event.srcElement.value = ComAddComma2(event.srcElement, "#,###.00");
 				break;
 			
 			case "act_cgo_wdt":
 				calcWidth();
 				calcAddDeadSlot();
 				event.srcElement.value = ComAddComma2(event.srcElement, "#,###.00");
 				break;
 				
 			case "act_cgo_hgt":
 				calcHeight();
 				calcAddDeadSlot();
 				event.srcElement.value = ComAddComma2(event.srcElement, "#,###.00");
 				break;	
 			
 			case "act_cgo_wgt":
 				calcWeight();
 				calcAddDeadSlot();
 				event.srcElement.value = ComAddComma2(event.srcElement, "#,###.00");
 				break;		
 		} 
 	}
 	
 	/**
     * OnKeyUp 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
  	function obj_keyup() {

  		 switch(event.srcElement.name) {
 		
 			case "act_cgo_len":
 				checkPointCount(event.srcElement);
 				break;
 			
 			case "act_cgo_wdt":
 				checkPointCount(event.srcElement);
 				break;
 				
 			case "act_cgo_hgt":
 				checkPointCount(event.srcElement);
 				break;	
 			
 			case "act_cgo_wgt":
 				checkPointCount(event.srcElement);
 				break;		
 		} 
  	}
  	
  	/**
     * OnFocus 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
   	function obj_focus() {
   		srcName = event.srcElement.name;
  		srcValue = event.srcElement.value;
  		
  		switch(srcName) {
  		
  			case "act_cgo_len":
  				event.srcElement.select();
  				break;
  			
  			case "act_cgo_wdt":
  				event.srcElement.select();
  				break;
  				
  			case "act_cgo_hgt":
  				event.srcElement.select();
  				break;	
  			
  			case "act_cgo_wgt":
  				event.srcElement.select();
  				break;		
  		} 
   	}
   	
   	/**
     * OnActivate 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
   	function obj_activate() {
   		srcName = event.srcElement.name;
  		srcValue = event.srcElement.value;
  		
  		switch(srcName) {
  		
  		case "act_cgo_len":
  				ComClearSeparator(event.srcElement);
				break;
			
			case "act_cgo_wdt":
				ComClearSeparator(event.srcElement);
				break;
				
			case "act_cgo_hgt":
				ComClearSeparator(event.srcElement);
				break;	
			
			case "act_cgo_wgt":
				ComClearSeparator(event.srcElement);
				break;		
		} 
    }
   	
   	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
	function obj_click() {
		srcName = event.srcElement.name;
		srcValue = event.srcElement.value;
	
		switch(srcName) {
		
			case "measuring_unit":
				changeFormValue();
				break;
		} 
	}
    
	/**
     * 소숫점 위치 validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkPointCount(event.srcElement);
     * </pre>
     * @param {object} obj 필수 Form object
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
   	function checkPointCount(obj) {
   		var sVal = obj.value;
   		
   		if(sVal.indexOf(".") < 0) {
			return;
		}
   		
   		var iPointNum = "";
		var iNum = sVal;
	
       	iNum = sVal.split(".")[0];		//소숫점 윗자리값
        iPointNum = sVal.split(".")[1];	//소숫점 아랫자리값
    	
        if(iNum.length == 0) {
        	iNum = "0";
        }
        
        if(iPointNum.length > 2) {
			iPointNum = iPointNum.substring(0,2);
			obj.value = iNum+"."+iPointNum;
		}
   	}
   	
   	/**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
     	
     	switch(sAction) {
     	
	     	case IBSEARCH:
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	      		}
	    		formObj.f_cmd.value = SEARCH;
	    		var sXml = sheetObj.GetSearchXml("ESM_PRI_2075GS.do" , FormQueryString(formObj));
	    		var arrDesc = ComPriXml2Array(sXml, "rat_ut_cd|cntr_len|cntr_wdt|cntr_hgt|cntr_wgt|act_cgo_len|act_cgo_wdt|act_cgo_hgt|act_cgo_wgt|cgo_spec_rmk");
	    		sheetObj.LoadSearchXml(sXml);
	    		
				if(arrDesc != null && arrDesc.length > 0) {
					formObj.type_unit.value = arrDesc[0][0];
					formObj.type_void.value = arrDesc[0][0];
					formObj.cntr_len.value = arrDesc[0][1];
					formObj.cntr_wdt.value = arrDesc[0][2]; 
					formObj.cntr_hgt.value = arrDesc[0][3];
					formObj.cntr_wgt.value = arrDesc[0][4];
					formObj.act_cgo_len.value = arrDesc[0][5];
					formObj.act_cgo_wdt.value = arrDesc[0][6];
					formObj.act_cgo_hgt.value = arrDesc[0][7];
					formObj.act_cgo_wgt.value = arrDesc[0][8];
					formObj.cgo_spec_rmk.value = arrDesc[0][9];
				}
				calcLength();
	  			calcWidth();
	  			calcHeight();
	  			calcWeight();
	  			calcAddDeadSlot();
	  			ComOpenWait(false);
	    		break;

     	}
    }
    
    /**
     * length 계산하는 function <br>
     * Length의 over 여부와 over 한 길이를 계산한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcLength();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function calcLength() {
    	var formObj = document.form;
    	var cntrLen = formObj.cntr_len.value;
    	var actCgoLen = ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var overLen = actCgoLen - cntrLen;
    	
    	if(overLen <= 0) {
    		LEN_OVER = false;
    		return;
    	}
    	LEN_OVER = true;
		formObj.front_len.value = ComAddComma2(ComRound(overLen/2, 2).toString(), "#,###.00");
		formObj.rear_len.value = ComAddComma2(ComRound(overLen/2, 2).toString(), "#,###.00");
    }
    
    /**
     * width 계산하는 function <br>
     * Width의 over 여부와 over 한 넓이를 계산한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcWidth();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function calcWidth() {
    	var formObj = document.form;
    	var cntrWdt = formObj.cntr_wdt.value;
    	var actCgoWdt = ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var overWdt = actCgoWdt - cntrWdt;

    	if(overWdt <= 0) {
    		WDT_OVER = false;
    		return;
    	}
    	
   		formObj.left_wdt.value = ComAddComma2(ComRound(overWdt/2, 2).toString(), "#,###.00");
   		formObj.right_wdt.value = ComAddComma2(ComRound(overWdt/2, 2).toString(), "#,###.00");
   		WDT_OVER = true;
    }
    
    /**
     * height 계산하는 function <br>
     * Height의 over 여부와 over 한 높이를 계산한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcHeight();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function calcHeight() {
    	var formObj = document.form;
    	var cntrHgt = formObj.cntr_hgt.value;
    	var actCgoHgt = ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var overHgt = actCgoHgt - cntrHgt;
    	
    	if(overHgt <= 0) {
    		HGT_OVER = false;
    		return;
    	}

   		formObj.hgt.value = ComAddComma2(ComRound(overHgt, 2).toString(), "#,###.00");
   		HGT_OVER = true;
    }
    
    /**
     * weight 계산하는 function <br>
     * Weight의 over 여부와 over 한 무게를 계산한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcHeight();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function calcWeight() {
    	var formObj = document.form;
    	var cntrWgt = formObj.cntr_wgt.value;
    	var actCgoWgt = ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	var overWgt = actCgoWgt - cntrWgt;

    	if(overWgt <= 0) {
    		formObj.wgt.value = ".00";
    	} else {
    		formObj.wgt.value = ComAddComma2(ComRound(overWgt, 2).toString(), "#,###.00");
    	}
    }
    
    /**
     * dead slot의 갯수를 계산하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    calcAddDeadSlot();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function calcAddDeadSlot() {
    	var formObj = document.form;
    	var typeUnit = formObj.type_unit.value;
    	
    	if(HGT_OVER == true ) {
    		if(LEN_OVER == true) {
    			if(WDT_OVER == true) {
    				front_title.innerText = "Front (2)";
    				rear_title.innerText = "Rear (2)";
    				left_title.innerText = "Left (2)";
    				right_title.innerText = "Right (2)";
    				height_title.innerText = "Height (1)";

    				formObj.add_dead_slot.value = 8;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 17;
    				} else {
    					formObj.total_dead_slot2.value = 17;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText = "Front (1)";
    				rear_title.innerText = "Rear (1)";
    				left_title.innerText = "Left";
    				right_title.innerText = "Right";
    				height_title.innerText = "Height (1)";
    				
    				formObj.left_wdt.value = ".00";
    	    		formObj.right_wdt.value = ".00";
    				
    				formObj.add_dead_slot.value = 2;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 5;
    				} else {
    					formObj.total_dead_slot2.value = 5;
    				}
    			}
    		} else if(LEN_OVER == false) {
    			if(WDT_OVER == true) {
    				front_title.innerText = "Front";
    				rear_title.innerText = "Rear";
    				left_title.innerText = "Left (1)";
    				right_title.innerText = "Right (1)";
    				height_title.innerText = "Height (1)";
    				
    				formObj.front_len.value = ".00";
    	    		formObj.rear_len.value = ".00";
    	    		
    				formObj.add_dead_slot.value = 2;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 5;
    				} else {
    					formObj.total_dead_slot2.value = 5;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText = "Front";
    				rear_title.innerText = "Rear";
    				left_title.innerText = "Left";
    				right_title.innerText = "Right";
    				height_title.innerText = "Height (1)";
    				
    				formObj.front_len.value = ".00";
    	    		formObj.rear_len.value = ".00";
    	    		formObj.left_wdt.value = ".00";
    	    		formObj.right_wdt.value = ".00";
    				
    				formObj.add_dead_slot.value = 0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 1;
    				} else {
    					formObj.total_dead_slot2.value = 1;
    				}
    			}
    		}
    	} else if(HGT_OVER == false) {
    		if(LEN_OVER == true) {
    			if(WDT_OVER == true) {
    				front_title.innerText = "Front (1)";
    				rear_title.innerText = "Rear (1)";
    				left_title.innerText = "Left (1)";
    				right_title.innerText = "Right (1)";
    				height_title.innerText = "Height";
    				
    				formObj.hgt.value = ".00";
    				
    				formObj.add_dead_slot.value = 4;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 8;
    				} else {
    					formObj.total_dead_slot2.value = 8;
    				}
    				
    			} else if(WDT_OVER == false) {
    				front_title.innerText = "Front (1)";
    				rear_title.innerText = "Rear (1)";
    				left_title.innerText = "Left";
    				right_title.innerText = "Right";
    				height_title.innerText = "Height";
    				
    				formObj.left_wdt.value = ".00";
    	    		formObj.right_wdt.value = ".00";
    				formObj.hgt.value = ".00";
    				
    				formObj.add_dead_slot.value = 0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 2;
    				} else {
    					formObj.total_dead_slot2.value = 2;
    				}
    			}
    		} else if(LEN_OVER == false) {
    			if(WDT_OVER == true) {
    				front_title.innerText = "Front";
    				rear_title.innerText = "Rear";
    				left_title.innerText = "Left (1)";
    				right_title.innerText = "Right (1)";
    				height_title.innerText = "Height";
    				
    				formObj.front_len.value = ".00";
    	    		formObj.rear_len.value = ".00";
    	    		formObj.hgt.value = ".00";
    	    		
    				formObj.add_dead_slot.value = 0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 2;
    				} else {
    					formObj.total_dead_slot2.value = 2;
    				}
    			} else if(WDT_OVER == false) {
    				front_title.innerText = "Front";
    				rear_title.innerText = "Rear";
    				left_title.innerText = "Left";
    				right_title.innerText = "Right";
    				height_title.innerText = "Height";
    				
    				formObj.front_len.value = ".00";
    	    		formObj.rear_len.value = ".00";
    	    		formObj.left_wdt.value = ".00";
    	    		formObj.right_wdt.value = ".00";
    	    		formObj.hgt.value = ".00";
    	    		
    				formObj.add_dead_slot.value = 0;
    				if(typeUnit.charAt(1) == "2") {
    					formObj.total_dead_slot1.value = 0;
    				} else {
    					formObj.total_dead_slot2.value = 0;
    				}
    			}
    		}
    	}
    }
    
    /**
     * form에서 sheet로 mapping하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    mappingFormToSheet(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function mappingFormToSheet(sheetObj) {
    	var formObj = document.form;
    	var actCgoLen = ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var actCgoWdt = ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var actCgoHgt = ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var actCgoWgt = ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	var cgoSpecRmk = formObj.cgo_spec_rmk.value;
    	
    	if(ComGetObjValue(formObj.measuring_unit) == "M") {
    		sheetObj.CellValue2(1, "act_cgo_len"	) = actCgoLen;
    		sheetObj.CellValue2(1, "act_cgo_wdt"	) = actCgoWdt;
    		sheetObj.CellValue2(1, "act_cgo_hgt"	) = actCgoHgt;
        	sheetObj.CellValue2(1, "act_cgo_wgt"	) = actCgoWgt;
        	sheetObj.CellValue2(1, "cgo_spec_rmk"	) = cgoSpecRmk;
    	} else if(ComGetObjValue(formObj.measuring_unit) == "I") {
    		sheetObj.CellValue2(1, "act_cgo_len"	) = ComAddComma2(ComRound(actCgoLen/3.28, 2).toString(), "#,###.00");
    		sheetObj.CellValue2(1, "act_cgo_wdt"	) = ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00");
    		sheetObj.CellValue2(1, "act_cgo_hgt"	) = ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00");
        	sheetObj.CellValue2(1, "act_cgo_wgt"	) = ComAddComma2(ComRound(actCgoWgt/2.2, 2).toString(), "#,###.00");
        	sheetObj.CellValue2(1, "cgo_spec_rmk"	) = cgoSpecRmk;
    	}
    }
    
    /**
     * form의 값들을 변경하는 function <br>
     * 선택한 기준에 따라 가중치를 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    changeFormValue();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function changeFormValue() {
    	var formObj = document.form;
    	var cntrLen = formObj.cntr_len.value;
    	var cntrWdt = formObj.cntr_wdt.value;
    	var cntrHgt = formObj.cntr_hgt.value;
    	var cntrWgt = formObj.cntr_wgt.value;
    	var actCgoLen = ComGetUnMaskedValue(formObj.act_cgo_len.value, "float");
    	var actCgoWdt = ComGetUnMaskedValue(formObj.act_cgo_wdt.value, "float");
    	var actCgoHgt = ComGetUnMaskedValue(formObj.act_cgo_hgt.value, "float");
    	var actCgoWgt = ComGetUnMaskedValue(formObj.act_cgo_wgt.value, "float");
    	
    	if(ComGetObjValue(formObj.measuring_unit) == "M") {
    		len_title.innerText = "Length(mm)";
    		wdt_title.innerText = "Width(mm)";
    		hgt_title.innerText = "Height(mm)";
    		wgt_title.innerText = "Weight(kg)";
    		
    		formObj.cntr_len.value = ComRound(cntrLen/3.28, 2);
    		formObj.cntr_wdt.value = ComRound(cntrWdt/3.28, 2);
    		formObj.cntr_hgt.value = ComRound(cntrHgt/3.28, 2);
    		formObj.cntr_wgt.value = ComRound(cntrWgt/2.2, 2);
    		
    		if(ComIsMoneyNumber(actCgoLen), true, true) {
    			formObj.act_cgo_len.value = ComAddComma2(ComRound(actCgoLen/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWdt), true, true) {
    			formObj.act_cgo_wdt.value = ComAddComma2(ComRound(actCgoWdt/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoHgt), true, true) {
    			formObj.act_cgo_hgt.value = ComAddComma2(ComRound(actCgoHgt/3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWgt), true, true) {
    			formObj.act_cgo_wgt.value = ComAddComma2(ComRound(actCgoWgt/2.2, 2).toString(), "#,###.00");
    		}
    	} else if(ComGetObjValue(formObj.measuring_unit) == "I") {
    		len_title.innerText = "Length(foot)";
    		wdt_title.innerText = "Width(foot)";
    		hgt_title.innerText = "Height(foot)";
    		wgt_title.innerText = "Weight(lbs)";
    		
    		formObj.cntr_len.value = ComRound(cntrLen*3.28, 2);
    		formObj.cntr_wdt.value = ComRound(cntrWdt*3.28, 2);
    		formObj.cntr_hgt.value = ComRound(cntrHgt*3.28, 2);
    		formObj.cntr_wgt.value = ComRound(cntrWgt*2.2, 2);
    		
    		if(ComIsMoneyNumber(actCgoLen), true, true) {
    			formObj.act_cgo_len.value = ComAddComma2(ComRound(actCgoLen*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWdt), true, true) {
    			formObj.act_cgo_wdt.value = ComAddComma2(ComRound(actCgoWdt*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoHgt), true, true) { 
    			formObj.act_cgo_hgt.value = ComAddComma2(ComRound(actCgoHgt*3.28, 2).toString(), "#,###.00");
    		}
    		if(ComIsMoneyNumber(actCgoWgt), true, true) {
    			formObj.act_cgo_wgt.value = ComAddComma2(ComRound(actCgoWgt*2.2, 2).toString(), "#,###.00");
    		}
    	}
    	calcLength();
		calcWidth();
		calcHeight();
		calcWeight();
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.10.20
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	    	case IBSEARCH:			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" || formObj.cmdt_hdr_seq.value == "" || formObj.rout_seq.value == "" || formObj.rt_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
				return true;
				break;

    	}	
		return true;
    }
	/* 개발자 작업  끝 */