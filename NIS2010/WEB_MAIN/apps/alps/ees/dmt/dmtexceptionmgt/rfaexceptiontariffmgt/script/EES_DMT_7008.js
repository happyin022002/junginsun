/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7008.js
*@FileTitle : Approval Authority Inquiry 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
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
     * @class EES_DMT_7008 : EES_DMT_7008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_7008() {
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
	var comboCnt = 0;
	
	// combo 조회 코드
	var IBSEARCH_RHQ_CMB = 1001;

	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
 	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

 	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
 	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	 
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
 	 /*******************************************************/
		
		var formObj = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcObj = window.event.srcElement;

			switch(srcName) {
				
	 			case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					break;
					
	 			case "btn_new":
	 				//Form.reset()하고, IBSheet.RemoveAll()처리한다. 
	 				//IBMultiCombo의 경우 id="myCombo"이면 "initComboValue_myCombo()"
	 				ComResetAll();
					
 					break;
					 				
	 			case "btn_downexcel":
	 				//Before Booking
	 				sheetObject1.Down2Excel();
	 				//After Booking
	 				sheetObject2.Down2Excel();
	 				//Inactive 
	 				sheetObject3.Down2Excel();	 				
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
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		 tabObjects[tabCnt++] = tab_obj;
	}
	 
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
	function initTab(tabObj , tabNo) {
    	 switch(tabNo) {
    	 	case 1:
    	 		with (tabObj) {
	                var cnt  = 0 ;
	                InsertTab(cnt++ , "Before Booking", -1);
	                InsertTab(cnt++ , "After Booking",  -1);
	                InsertTab(cnt++ , "Inactivation",   -1);
	            }
	            break;
	    }
	}	 
     
     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
	function tab1_OnChange(tabObj , nItem)
	{

		var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
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
	
	 	for(k=0;k<tabObjects.length;k++){
	 		initTab(tabObjects[k],k+1);
	 	}
 	
        // IBMultiCombo초기화 
	    for (var k=0; k<comboObjects.length; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	    
		//html컨트롤 이벤트초기화
		initControl();
		
	    // 각종 콤보박스의 데이터를 페이지 로딩시 입괄조회 후 한번에 설정 
	    // 조회조건 및 그리드 콤보 데이터 셋팅
	    doActionLoadComboData(IBSEARCH_RHQ_CMB);		
	}
	 
    
	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');  //jsp name 옆에 id 추가 예)name="btn_retrieve" id="btn_Retrieve"
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때
	}

	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	// 영문대+숫자+예외문자
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
	}
	
	function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
         var obj = event.srcElement;
//         ComChkObjValid(obj);
	}
     
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
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

	        	case "t1sheet1":      // t1sheet1 init
	        		with (sheetObj) {
							// 높이 설정
							style.height = 412;
							// 전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							// Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							// 전체Merge 종류 [선택, Default msNone]
							MergeSheet = msNone;

							// 전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo( 1, 1, 2, 100);

							// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(6, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							var HeadTitle = "|Seq.|Approval Office|User Office|ID|Name";

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle, true);

							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
							InitDataProperty(0, cnt++ , dtSeq,    		40,		daCenter,		false,		"seq");
							InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,		false,		"ar_hd_qtr_ofc_cd",		false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,		false,		"ofc_cd",				false,		"",		dfNone,		0,			false,		false);

							InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,		false,		"usr_id",				false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      	170,	daLeft,			false,		"usr_nm",				false,		"",		dfNone,		0,			false,		false);

							CountPosition = 0;		// 건수 정보를 표시하지 않음.
	        		}
	                break;       


	        	case "t2sheet1":      // t2sheet1 init
	        		with (sheetObj) {
	        				// 높이 설정
							style.height = 412;
							// 전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							// Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							// 전체Merge 종류 [선택, Default msNone]
							MergeSheet = msNone;

							// 전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo( 1, 1, 2, 100);

							// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(7, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							var HeadTitle = "|Seq.|Approval Office|APVL.Level|User Office|ID|Name";

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle, true);

							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
							InitDataProperty(0, cnt++ , dtSeq,    			40,		daCenter,		false,		"seq");
							InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		false,		"ar_hd_qtr_ofc_cd",		false,		"",		dfNone,		0,			false,		false);
//							InitDataProperty(0, cnt++ , dtData,      		70,		daCenter,		false,		"usr_role_cd",			false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		120,	daCenter,		false,		"apvl_path_cd",			false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		false,		"ofc_cd",				false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		70,		daCenter,		false,		"usr_id",				false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		170,	daLeft	,		false,		"usr_nm",				false,		"",		dfNone,		0,			false,		false);

							CountPosition = 0;		// 건수 정보를 표시하지 않음.
	        		}
	                break;          
	                
	        	case "t3sheet1":      // t3sheet1 init
	        		with (sheetObj) {
	        				// 높이 설정
							style.height = 412;
							// 전체 너비 설정
							SheetWidth = mainTable.clientWidth;

							// Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

							// 전체Merge 종류 [선택, Default msNone]
							MergeSheet = msNone;

							// 전체Edit 허용 여부 [선택, Default false]
							Editable = true;

							// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo( 1, 1, 2, 100);

							// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(7, 0, 0, true);

							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(true, true, false, true, false,false);

							var HeadTitle = "|Seq.|Approval Office|APVL.Level|User Office|ID|Name";

							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle, true);

							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
							InitDataProperty(0, cnt++ , dtSeq,    			40,		daCenter,		false,		"seq");
							InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		false,		"ar_hd_qtr_ofc_cd",		false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		false,		"apvl_path_cd",			false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		false,		"ofc_cd",				false,		"",		dfNone,		0,			false,		false);

							InitDataProperty(0, cnt++ , dtData,      		70,		daCenter,		false,		"usr_id",				false,		"",		dfNone,		0,			false,		false);
							InitDataProperty(0, cnt++ , dtData,      		170,	daLeft	,		false,		"usr_nm",				false,		"",		dfNone,		0,			false,		false);

							CountPosition = 0;		// 건수 정보를 표시하지 않음.
	        		}
	                break;  	                
	    	}
	}

    
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	 		case IBSEARCH:      //조회
	 		
	 			//ComOpenWait Start
	 			sheetObj.WaitImageVisible=false;
	 			ComOpenWait(true);
	        
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DataAutoTrim = false;
 				
 				var hdQtrOfcCd = comboObjects[0].Code;
 				if (hdQtrOfcCd == "ALL") {
 					hdQtrOfcCd = ""; 
 				}
 				
 				ComSetObjValue(formObj.ar_hd_qtr_ofc_cd, hdQtrOfcCd);
 				
 				var sXml =  sheetObj.GetSearchXml("EES_DMT_7008-1GS.do", FormQueryString(formObj));
 				var arrXml = sXml.split("|$$|");
 				
 				sheetObjects[0].LoadSearchXml(arrXml[0]);
 				sheetObjects[1].LoadSearchXml(arrXml[1]);
 				sheetObjects[2].LoadSearchXml(arrXml[2]);
 				
 				//ComOpenWait End
				ComOpenWait(false);
 				
 			break;
 			
			//######################################## 콤보 데이터 조회 영역 [S] ####################################################
        	case IBSEARCH_RHQ_CMB:
				//1. [RHQ] 조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, COMMAND06); // DMTCommonSC.searchRHQOfficeList
	
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
            	//1.RHQ Combo - setting
				var rhqList = handleNullString(ComGetEtcData(sXml, "common_cd"));
				
				var rhqList = "ALL"   + FIELDMARK + ""      + ROWMARK   + rhqList;	// 전체추가
				var rhqList = rhqList + ROWMARK   + "SELHO" + FIELDMARK + "SELHO";	// SELHO 항목추가
            	initComboItem(comboObjects[0], rhqList.split(ROWMARK));
            	
            	comboObjects[0].Index = 0;	//기본선택
        	break;
        	//######################################## 콤보 데이터 조회 영역 [E] #################################################### 			
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
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'usr_nm':		// user name Inquiry Popup
					ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
					break;
				
	  			case 'ofc_cd':
	  				ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		
  		if(sUrl.indexOf('.do') != -1) {
  			var sWinName = ComReplaceStr(sUrl, '.do', '');
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} else if(sUrl != '') {
	  		ComOpenWindow('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/' + sUrl,'p'
						,'scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=' + sWidth + ',height=' + sHeight + ',left=0,top=0');
  		}
  	}	
  	
  	/*
 	 * Issue Name 공통팝업에서 선택한 Issue Name, Issue Code값을 해당 필드에 설정 
 	 */
	function setUsrNm(aryPopupData){
		document.form.usr_nm.value = aryPopupData[0][5];
// 		document.form.usr_id.value = aryPopupData[0][4];
 	}  	
    /*
   	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
   	 */
    function getCtrtOfcCd(aryPopupData) {
    	document.form.ofc_cd.value = aryPopupData[0][3];
    }	 
    
    /**
     * 콤보코드데이터를 조회해서 초기화한다.
     */
    function doActionLoadComboData(sActionName) {
    	
    	doActionIBSheet(sheetObjects[0], document.form, sActionName);
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
   	    var formObj = document.form

   	    switch(comboNo) {		
 				
		    //RHQ Combo
		   	case 1:
		   		with(comboObj) {
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("70");
					ColBackColor(0) = "#CCFFFD";
					ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
		   		}
		   	break;	
		   	
			//Office Combo
		   	case 2:
		   		with(comboObj) {
					MultiSelect = true; 
					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|360");					
					//ColBackColor(0) = "#CCFFFD";
					//ColBackColor(1) = "#CCFFFD";
					DropHeight = 160;
		   		}
		   	break; 
   	    }
	}  	
	
 	/**
     * 멀티콤보필드에 데이터를 추가해준다.
     */	
	function initComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
    	}
	} 	
	
    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
    	
         if (typeof(sVal) == "undefined" || sVal == "null" || sVal.length == 0) return "";

         return ComTrim(sVal);
    } 	
	/* 개발자 작업  끝 */