/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0905.js
*@FileTitle : TRO-Actual Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
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
     * @class esm_bkg_0905 : esm_bkg_0905 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0905() {
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
	
	var bInitfalg = true;  //페이지 최초 로딩상태 
 
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
 
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3]; 
        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_RowAdd": 
 					doActionIBSheet(sheetObject2, formObject, IBINSERT);  
 					break; 					
 				case "btn_t2RowAdd1": 
 					doActionIBSheet(sheetObject3, formObject, IBINSERT);
 					break; 					
 				case "btn_t2RowAdd2": 
 					doActionIBSheet(sheetObject4, formObject, IBINSERT);  
 					break;  					
 				case "btn_RowDelete":
 					setRowDelStatus (sheetObject2, sheetObject2.SelectRow);
 					ComRowHideDelete(sheetObject2, "del_chk"); 
 					break;
 				case "btn_t2RowDelete1":
 					setRowDelStatus (sheetObject3, sheetObject3.SelectRow);
 					ComRowHideDelete(sheetObject3, "del_chk"); 
 					break;
 				case "btn_t2RowDelete2":
 					setRowDelStatus (sheetObject4, sheetObject4.SelectRow);
 					ComRowHideDelete(sheetObject4, "del_chk"); 
 					break;  					 					
				case "btn_Retrieve":
					if (tabObjects[0].selectedIndex == 1) {
						doActionIBSheet(sheetObject3, formObject, IBSEARCH);
					} else {
						doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					}
					break; 
				case "btn_Save":
					if (tabObjects[0].selectedIndex == 1) {
						doActionIBSheet(sheetObject3, formObject, IBSAVE); 	
					} else {
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					}
					break;					
 				case "btn_Select":
 					if (tabObjects[0].selectedIndex == 1) {	
 						var sRow = sheetObject4.FindCheckedRow("del_chk");
 						if(sheetObject4.RowCount < 1){
	 			        	ComShowCodeMessage("BKG00333");
 						} else {
	 	 			        var arrRow = sRow.split("|");
	 	 			        if (arrRow.length != 2) {
	 	 			        	ComShowCodeMessage("BKG08040");
	 	 			        } else {
	 	 			        	pre_comPopupOK(sheetObject4, arrRow[0]);	
	 	 			        }
 						}
					} else {
						var sRow = sheetObject2.FindCheckedRow("del_chk");
 						if(sheetObject2.RowCount < 1){
	 			        	ComShowCodeMessage("BKG00333");
 						} else {
		 			        var arrRow = sRow.split("|");
		 			        if (arrRow.length != 2) {
		 			        	ComShowCodeMessage("BKG08040");
		 			        } else {
		 			        	pre_comPopupOK(sheetObject2, arrRow[0]);	
		 			        }
 						}
					}
 					break;
 				case "btn_Close":
 					self.close();
 					break;

             } // end switch
     	}catch(e) {
     		ComShowMessage(e);
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
    function loadPage() {    	 
    	initParam();  //jsp에서 처리함   
    	  
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
         
        //axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');  //tab 검색버튼 2개시, 사용불가 
        axon_event.addListenerFormat('keypress', 'obj_keypress_loc', form);            //- 키보드 입력할때  
        axon_event.addListener      ('keypress', 'engnum_keypress',   'cust_cnt_cd');
        axon_event.addListener      ('keypress', 'uppernum_keypress', 'cust_lgl_eng_nm', 'tro_act_rep_nm');  
   	    axon_event.addListenerForm  ('beforeactivate',   'obj_activate',   form);  //- 포커스 나갈때
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);  //- 포커스 들어갈때
	    axon_event.addListenerForm  ('keyup',   'obj_keyup',   form);  //- obj_keyup
	    
        //tab별 초기조회 변경처리 여부확인할 것!!!
	    setDefaultTab();
	     
	    bInitfalg = false;
	     
	    doActionIBSheet(sheetObjects[4], document.form, IBCREATE); 

		var formObj = document.form;
		//if (nullToBlank(formObj.cnt_cd.value) == "M") {  
		if (nullToBlank(formObj.conti_cd.value) == "M") {  
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
		} else {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		} 
	}
    
    /**
      * parent화면에서 넘겨받은 parameter 초기화 
      */
	function initParam(){
		var formObj = document.form;

		var tro_act_cust_knd_cd = ""; 
		//var conti_cd = opener.document.form.conti_cd.value;            //hidden : 대륙코드  
		//var cnt_cd   = opener.document.form.por_cd.value.substr(0,2);  //국가코드  
		var conti_cd        = nullToBlank(formObj.conti_cd.value);
		var cnt_cd          = nullToBlank(formObj.cnt_cd.value);
		var bkg_no          = nullToBlank(formObj.bkg_no.value);
		//var bkg_no_split    = nullToBlank(formObj.bkg_no_split.value);
		var dor_loc_cd      = nullToBlank(formObj.dor_loc_cd.value);
		var act_shpr_cnt_cd = nullToBlank(formObj.act_shpr_cnt_cd.value);
		var act_shpr_seq    = nullToBlank(formObj.act_shpr_seq.value);
		var act_shpr_nm     = nullToBlank(formObj.act_shpr_nm.value);
		  
		if ("M" == conti_cd) {
		    tro_act_cust_knd_cd = "E"; 
		} else {
		    tro_act_cust_knd_cd = "C"; 
		}
		formObj.tro_act_cust_knd_cd.value = tro_act_cust_knd_cd; 
		//formObj.cust_cnt_cd.value         = cnt_cd;
		
		//------------------------------------------->
		//opener 입력값 체크하여, 
		//1) exist    -> Default값 setting
		//2) not-exit -> DB조회 후, Default값 setting
		if (act_shpr_cnt_cd != "" && act_shpr_seq != "") {
			formObj.cust_cnt_cd.value = act_shpr_cnt_cd; 
			formObj.cust_seq.value    = act_shpr_seq; 
		}
		if (act_shpr_nm != "") {
			formObj.tro_act_rep_nm.value = act_shpr_nm; 
		}
		//<-------------------------------------------		
	}
      
    /**
      * parent화면에서 넘겨받은 parameter로, tab초기화면 설정 
      */
 	function setDefaultTab(){
 		var formObject = document.form;
 		if ("E" == formObject.tro_act_cust_knd_cd.value) {
 			tabObjects[0].selectedIndex = 1;  //EQ-tab 
 		} else {
 			tabObjects[0].selectedIndex = 0;  //Cust
 		}
 	}      
      
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress_loc() {
     	switch(event.srcElement.dataformat){
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
	        case "int":
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	            break;
	        case "intchar":
	            ComKeyOnlyNumber(event.srcElement, "");
	            break;
     	}

    	switch(event.srcElement.name){
	        case "cntc_phn_no":	
	        case "cntc_mphn_no":
    	        // 숫자+"-"입력하기
    	        ComKeyOnlyNumber(event.srcElement, "-"); 
    	        break;
	        case "vndr_seq":
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	            break;
    	}
    }
     
    function engnum_keypress() { 	    
    	ComKeyOnlyAlphabet('upper');  //영대문자 자동변환
    }     
     
    function uppernum_keypress() { 
    	if(event.keyCode != 32) {
  	        ComKeyOnlyAlphabet('uppernum');  //영대문자 자동변환
    	}
	}       
     
     /**
      * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
      **/  
    function obj_activate() {
   	    //마스크 구분자 없애기
   	    ComClearSeparator (event.srcElement);
   	}   	
   	
   	function obj_deactivate() {
   	    switch(event.srcElement.name){
	        case "cust_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(event.srcElement, true, false, false);  //ComChkObjValid(obj, bMsg, bTrim, bMasked)
	            break;	            
	        case "vndr_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(event.srcElement, true, false, false);  //ComChkObjValid(obj, bMsg, bTrim, bMasked)
	            break;
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(event.srcElement);
	            break;
   	    }
   	}     
   	
   	function obj_keyup() {
   		var formObj = document.form;
   		with (formObj) {
   			if ( window.event.keyCode == 13 ) {   				 
				if (tro_act_cust_knd_cd.value == "C"){
					 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				} else if (tro_act_cust_knd_cd.value == "E"){
					doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				}
			}
   		}
   	}
     
    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
   	function initSheet(sheetObj,sheetNo) {
   		var cnt = 0;        
                
		switch(sheetObj.id) {
			case "t1sheet1":      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 82;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
					
					var HeadTitle = " |Seq.|Customer Code|Customer Code||Name|S/OFC";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//InitHeadMode(false, true, false, true, false, false)		
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	0, 		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,	    30, 	daCenter,	false,	"displayno");  //dtRadioCheck
					//InitDataProperty(0,	cnt++,	dtData,			100, 	daLeft,		false,	"cust_cd",         false,	"",	dfNone,		0,		false);  //cust_cd
					InitDataProperty(0,	cnt++,	dtData,		    30, 	daCenter,	false,	"cust_cnt_cd",       false,	"",	dfNone,		0,		false);
					InitDataProperty(0,	cnt++,	dtData,	     	70,     daLeft,		false,	"nvocc_hjs_scac_cd", false,	"",	dfNone,		0,		false);
					InitDataProperty(0,	cnt++,	dtHidden,	    70,     daLeft,		false,	"cust_seq",          false,	"",	dfNone,		0,		false);									
					//InitDataProperty(0,	cnt++,	dtHidden,		0,      daLeft,		false,	"cust_seq",        false,	"",	dfNone,		0,		false);					
					InitDataProperty(0,	cnt++,	dtData,			230, 	daLeft,		false,	"cust_lgl_eng_nm",   false,	"",	dfNone,		0,		false);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"ofc_cd",            false,	"",	dfNone,		0,		false);
					
					CountPosition = 0;
				}
				break; 		
 		
 			case "t1sheet2":      //t1sheet2 init
 				with (sheetObj) {
 					// 높이 설정
 					//style.height = 101;
 					style.height = 190;
 					
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;
 					
 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 					
 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msNone;
 					
 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 					
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo(1, 1, 5, 100);
 					
 					var HeadTitle = "Sel.||Location|Zone|Factory Name (Actual Customer)|Contact Person|Tel.|Mobile|Address|Zip| | | | | ";
 					var headCount = ComCountHeadTitle(HeadTitle);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);
 					
 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, false, true, false,false);
 					
 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true);
 					 					
 					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					//InitDataProperty(0,	cnt++,	dtRadioCheck,	21 , 	daCenter,	false,	"radio",            false,          "",       dfNone,	    0,     true,       true);
 					InitDataProperty(0,	cnt++,	dtDummyCheck,	40, 	daCenter,	false,	"del_chk");   //del, dtDelCheck
 					InitDataProperty(0,	cnt++,	dtHiddenStatus,	0, 		daCenter,	false,	"ibflag"); 					
 					InitDataProperty(0,	cnt++,	dtPopupEdit,	81 , 	daCenter,	false,	"loc_cd",          false,	"",	dfNone,		0,		true, true, 5, true);
 					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"zn_cd",           false,	"",	dfNone,		0,		true, true, 2, true);  
 					InitDataProperty(0,	cnt++,	dtData,			200, 	daLeft,		false,	"act_shpr_nm",     false,	"",	dfNone,		0,		true, true, 50);
 					
 					InitDataProperty(0,	cnt++,	dtData,			110, 	daLeft,  	false,	"cntc_pson_nm",     false,	"",	dfNone,		0,		true, true, 50);
 					InitDataProperty(0,	cnt++,	dtData,			110, 	daCenter,   false,	"cntc_phn_no",      false,	"",	dfNone,		0,		true, true, 50);
 					InitDataProperty(0,	cnt++,	dtData,			130, 	daCenter,  	false,	"cntc_mphn_no",     false,	"",	dfNone,		0,		true, true, 20);
 					InitDataProperty(0,	cnt++,	dtData,			190, 	daLeft,		false,	"act_shpr_addr",    false,	"",	dfNone,		0,		true, true, 90);
 					InitDataProperty(0,	cnt++,	dtData,			40, 	daLeft,		false,	"dor_zip_id",       false,	"",	dfEngUpKey,		0,		true, true, 10);
 					
 					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_act_cust_knd_cd",  false,	"",	dfNone,		0,		false);  //dtHidden
 					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_vndr_seq",         false,	"",	dfNone,		0,		false);  //dtHidden 			
 					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"cnt_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
 					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"cust_seq",             false,	"",	dfNone,		0,		false);  //dtHidden
 					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"ofc_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
 					
 					InitDataValid(0, "cntc_phn_no",  vtNumericOther, "-");
 					InitDataValid(0, "cntc_mphn_no", vtNumericOther, "-");
 					InitDataValid(0, "loc_cd",       vtEngUpOther, "1234567890");
 					PopupImage = "img/btns_search.gif";
 					ShowButtonImage = 2;
 				}
 				break;

			case "t2sheet1":      //t2sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 82;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
					
					var HeadTitle = " |Del|E/Q Office|Representative Name| | ";  //hidden show					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
															
					
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	0, 		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDummyCheck,	27, 	daCenter,	false,	"del_chk");  //radio -> radio처리 추가
					InitDataProperty(0,	cnt++,	dtData,		    90,    daCenter,	false,	"ofc_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtData,			81 , 	daLeft,		false,	"tro_act_rep_nm",     false,	"",	dfNone,		0,		true, true, 50);					
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_act_cust_knd_cd",  false,	"",	dfNone,		0,		false);  //dtHidden, dtData					
					InitDataProperty(0,	cnt++,	dtHidden,		0,      daLeft,		false,	"tro_act_rep_seq",      false,	"",	dfNone,		0,		false);	 //dtHidden

					CountPosition = 0;
				}
				break;

			case "t2sheet2":      //t2sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 121;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 5, 100);
					
					var HeadTitle = " ||Location|Factory Name (Actual Customer)|VENDOR|VENDOR|VENDOR|Contact Person|Tel.|Fax|E-mail|Address|Zip| | | | ";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtDummyCheck,	27, 	daCenter,	false,	"del_chk",         false,	"",	dfNone,		0,		false);
					//InitDataProperty(0,	cnt++,	dtRadioCheck,	21 , 	daCenter,	false,	"radio",            false,          "",       dfNone,	    0,     true,       true);
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	30, 	daCenter,	false,	"ibflag");   //dtHiddenStatus							
					InitDataProperty(0,	cnt++,	dtPopupEdit,	80 , 	daCenter,	false,	"loc_cd",          false,	"",	dfNone,		0,		true, true, 5);
					InitDataProperty(0,	cnt++,	dtData,			200, 	daLeft,		false,	"act_shpr_nm",     false,	"",	dfNone,		0,		true, true, 50);
					InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	"cnt_cd",          false,	"",	dfEngUpKey,	0,		true, true, 2, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daCenter,	false,	"vndr_seq",        false,	"",	dfNone,   	0,	    true, true, 6);  //dfNullInteger
					InitDataProperty(0,	cnt++,	dtData,			120, 	daLeft,		false,	"vndr_lgl_eng_nm", false,	"",	dfNone,		0,		true, true, 50);
					InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	"cntc_pson_nm",    false,	"",	dfNone,		0,		true, true, 20);
					InitDataProperty(0,	cnt++,	dtData,			90 , 	daCenter,	false,	"cntc_phn_no",     false,	"",	dfNone,		0,		true, true, 50);
					InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	"cntc_fax_no",     false,	"",	dfNone,		0,		true, true, 20);
					InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	"cntc_eml",        false,	"",	dfNone,		0,		true, true, 100);
					InitDataProperty(0,	cnt++,	dtData,			150, 	daLeft,		false,	"act_shpr_addr",   false,	"",	dfNone,		0,		true, true, 90);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"dor_zip_id",      false,	"",	dfEngUpKey,		0,		true, true, 10);
					
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_act_cust_knd_cd",  false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_vndr_seq",         false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"ofc_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0,      daLeft,		false,	"tro_act_rep_seq",      false,	"",	dfNone,		0,		false);	 //dtHidden

					InitDataValid(0, "cnt_cd",       vtEngUpOnly);
					InitDataValid(0, "vndr_seq",     vtNumericOnly);
 					InitDataValid(0, "cntc_phn_no",  vtNumericOther, "-");	
 					InitDataValid(0, "cntc_fax_no",  vtNumericOther, "-");
 					InitDataValid(0, "loc_cd",       vtEngUpOther, "1234567890");
 					PopupImage = "img/btns_search.gif";
 					ShowButtonImage = 2;
				}
				break;
				
			case "h1sheet1":      //hidden sheet1
				with (sheetObj) {
					// 높이 설정
					//style.height = 50;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "||";
					var headCount = ComCountHeadTitle(HeadTitle);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0,	cnt++,	dtData,		    30, 	daCenter,	false,	"p_eq_ctrl_ofc_cd",  false,	"",	dfNone,		0,		false);
					InitDataProperty(0,	cnt++,	dtData,	     	70,     daLeft,		false,	"p_cust_seq",        false,	"",	dfNone,		0,		false);									
					InitDataProperty(0,	cnt++,	dtData,			70, 	daLeft,		false,	"p_cust_cnt_cd",     false,	"",	dfNone,		0,		false);
				}
				break; 			
			
			case "h1sheet2":      //hidden sheet2
				with (sheetObj) {
					// 높이 설정
					//style.height = 100;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 20, 100);
					
					var HeadTitle = "|||||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtRadioCheck,	21 , 	daCenter,	false,	"radio",                false,  "", dfNone,	    0,      true, true);
					InitDataProperty(0,	cnt++,	dtData,			61 , 	daCenter,	false,	"loc_cd",               false,	"",	dfNone,		0,		true, true, 5, true);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"zn_cd",                false,	"",	dfNone,		0,		true, true, 2, true);  
					InitDataProperty(0,	cnt++,	dtData,			200, 	daLeft,		false,	"act_shpr_nm",          false,	"",	dfNone,		0,		true, true, 50);
					
					InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	"cnt_cd",               false,	"",	dfEngUpKey,	0,		true, true, 2, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daCenter,	false,	"vndr_seq",             false,	"",	dfNone,   	0,	    true, true, 6);  //dfNullInteger
					InitDataProperty(0,	cnt++,	dtData,			120, 	daLeft,		false,	"vndr_lgl_eng_nm",      false,	"",	dfNone,		0,		true, true, 50);
					
					InitDataProperty(0,	cnt++,	dtData,			110, 	daCenter,	false,	"cntc_pson_nm",         false,	"",	dfNone,		0,		true, true, 50);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daCenter,	false,	"cntc_phn_no",          false,	"",	dfNone,		0,		true, true, 20);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daCenter,	false,	"cntc_mphn_no",         false,	"",	dfNone,		0,		true, true, 20);
					InitDataProperty(0,	cnt++,	dtData,			190, 	daLeft,		false,	"act_shpr_addr",        false,	"",	dfNone,		0,		true, true, 50);
					InitDataProperty(0,	cnt++,	dtData,			40, 	daLeft,		false,	"dor_zip_id",           false,	"",	dfNone,		0,		true, true, 10);
					InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	"cntc_fax_no",          false,	"",	dfNone,		0,		true, true, 20);
					InitDataProperty(0,	cnt++,	dtData,			100, 	daCenter,	false,	"cntc_eml",             false,	"",	dfNone,		0,		true, true, 100);

					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_act_cust_knd_cd",  false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"tro_vndr_seq",         false,	"",	dfNone,		0,		false);  //dtHidden 			
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"cnt_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"cust_seq",             false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0 , 	daLeft,		false,	"ofc_cd",               false,	"",	dfNone,		0,		false);  //dtHidden
					InitDataProperty(0,	cnt++,	dtHidden,		0,      daLeft,		false,	"tro_act_rep_seq",      false,	"",	dfNone,		0,		false);	 //dtHidden
				}
		        break; 
 		}
 	}
     
    function pre_comPopupOK(sheetObj_org, nSRow) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[5];
    	//var sheetObj_org = null;
    	
        sheetObj.RemoveAll();                //grid 초기화         
        var nRow = sheetObj.DataInsert(-1);  //신규행 추가  
 		if (tabObjects[0].selectedIndex == 1) { 		
 			//--------------------------
 	    	//dor_loc_cd 동일여부 체크
 	    	var dorLocCd     = nullToBlank(formObj.dor_loc_cd.value); 
 	        var dorLocCd_sel = nullToBlank(sheetObj_org.CellValue(nSRow, "loc_cd"));
 	        if (dorLocCd != "" && dorLocCd != dorLocCd_sel) {
 	        	ComShowCodeMessage("BKG02028");
 	        	return;
 	        } 
 	        
			if(sheetObj_org.CellValue(nSRow, "cntc_eml") != ""){
				emlArr = sheetObj_org.CellValue(nSRow, "cntc_eml").split(";");
			 	for(var i = 0; i < emlArr.length; i++){
			 		if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
			 			ComShowCodeMessage("BKG40021" , emlArr[i]);
			 			return false;
			 		}
			 	}
			}
			
 			//1) EQ-tab  			
 			//sheetObj_org = sheetObjects[3];
 	 		sheetObj.CellValue2(nRow, "loc_cd")              = sheetObj_org.CellValue(nSRow, "loc_cd");
 	 		sheetObj.CellValue2(nRow, "act_shpr_nm")         = sheetObj_org.CellValue(nSRow, "act_shpr_nm");
 	 		sheetObj.CellValue2(nRow, "cnt_cd")              = sheetObj_org.CellValue(nSRow, "cnt_cd");
 	 		sheetObj.CellValue2(nRow, "vndr_seq")            = sheetObj_org.CellValue(nSRow, "vndr_seq");
 	 		sheetObj.CellValue2(nRow, "vndr_lgl_eng_nm")     = sheetObj_org.CellValue(nSRow, "vndr_lgl_eng_nm");
 	 		sheetObj.CellValue2(nRow, "cntc_pson_nm")        = sheetObj_org.CellValue(nSRow, "cntc_pson_nm");
 	 		sheetObj.CellValue2(nRow, "cntc_phn_no")         = sheetObj_org.CellValue(nSRow, "cntc_phn_no");
 	 		sheetObj.CellValue2(nRow, "cntc_fax_no")         = sheetObj_org.CellValue(nSRow, "cntc_fax_no");
 	 		sheetObj.CellValue2(nRow, "cntc_eml")            = sheetObj_org.CellValue(nSRow, "cntc_eml");
 	 		sheetObj.CellValue2(nRow, "act_shpr_addr")       = sheetObj_org.CellValue(nSRow, "act_shpr_addr");
 	 		sheetObj.CellValue2(nRow, "dor_zip_id")          = sheetObj_org.CellValue(nSRow, "dor_zip_id");
 	 		sheetObj.CellValue2(nRow, "tro_act_cust_knd_cd") = sheetObj_org.CellValue(nSRow, "tro_act_cust_knd_cd");
 	 		sheetObj.CellValue2(nRow, "tro_vndr_seq")        = sheetObj_org.CellValue(nSRow, "tro_vndr_seq");
 	 		sheetObj.CellValue2(nRow, "ofc_cd")              = sheetObj_org.CellValue(nSRow, "ofc_cd");
 	 		sheetObj.CellValue2(nRow, "tro_act_rep_seq")     = sheetObj_org.CellValue(nSRow, "tro_act_rep_seq");
 		} else {
 			//2) Cust
 			//sheetObj_org = sheetObjects[1];
 	 		sheetObj.CellValue2(nRow, "loc_cd")              = sheetObj_org.CellValue(nSRow, "loc_cd");
 	 		sheetObj.CellValue2(nRow, "zn_cd")               = sheetObj_org.CellValue(nSRow, "zn_cd");
 	 		sheetObj.CellValue2(nRow, "act_shpr_nm")         = sheetObj_org.CellValue(nSRow, "act_shpr_nm");
 	 		sheetObj.CellValue2(nRow, "cntc_pson_nm")        = sheetObj_org.CellValue(nSRow, "cntc_pson_nm");
 	 		sheetObj.CellValue2(nRow, "cntc_phn_no")         = sheetObj_org.CellValue(nSRow, "cntc_phn_no");
 	 		sheetObj.CellValue2(nRow, "cntc_mphn_no")        = sheetObj_org.CellValue(nSRow, "cntc_mphn_no");
 	 		sheetObj.CellValue2(nRow, "act_shpr_addr")       = sheetObj_org.CellValue(nSRow, "act_shpr_addr");
 	 		sheetObj.CellValue2(nRow, "dor_zip_id")          = sheetObj_org.CellValue(nSRow, "dor_zip_id");
 	 		sheetObj.CellValue2(nRow, "tro_act_cust_knd_cd") = sheetObj_org.CellValue(nSRow, "tro_act_cust_knd_cd");
 	 		sheetObj.CellValue2(nRow, "tro_vndr_seq")        = sheetObj_org.CellValue(nSRow, "tro_vndr_seq");
 	 		sheetObj.CellValue2(nRow, "cnt_cd")              = sheetObj_org.CellValue(nSRow, "cnt_cd");
 	 		sheetObj.CellValue2(nRow, "cust_seq")            = sheetObj_org.CellValue(nSRow, "cust_seq");
 	 		sheetObj.CellValue2(nRow, "ofc_cd")              = sheetObj_org.CellValue(nSRow, "ofc_cd"); 	 		
 		}
 		sheetObj.CellValue2(nRow, "radio") = "Y";

    	comPopupOK();
    }
      
     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
    function initTab(tabObj, tabNo) {
    	switch(tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt  = 0 ;
    				InsertTab( cnt++ , "By Customer Code" , -1 );
    				InsertTab( cnt++ , "By E/Q Office(USA Region)" , -1 );
    			}
    			break;
      	}
 	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
         
        switch(sAction) {
	        case IBCREATE:      //조회	
	        	formObj.f_cmd.value = SEARCH05;
	        	sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj));	 
	            break;
	         
            case IBSEARCH:      //조회	
 	          	if(!validateForm(sheetObj,formObj,sAction)) return;
 	     
 	          	if (sheetObj.id=="t1sheet1"){
 	          		formObj.f_cmd.value = SEARCH;
 	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj));
 	          	} 
 	          	else if (sheetObj.id=="t2sheet1"){ 
 	          		formObj.f_cmd.value = SEARCH02;
 	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj));
 	          	} 	          	
                break;

 	 		case IBSAVE:        //저장
 	          	if(!validateForm(sheetObj,formObj,sAction)){
 	          		return false;
 	          	}
     	
 	          	if (sheetObj.id=="t1sheet2"){ 
 	          	    formObj.f_cmd.value = MULTI; 
 	          		sheetObj.DoSave("ESM_BKG_0905GS.do", FormQueryString(formObj));
 	          	} else if (sheetObj.id=="t2sheet1"){ 
 	          		//(containerVO):all존재시만------------------------------>
 	          	    formObj.f_cmd.value = MULTI01; 
 	          		var sParam = ComGetSaveString(sheetObjects);
  	                if (sParam == "") return;
  	                sParam += "&" + FormQueryString(formObj);
 	          		sParam += "&" + ComSetPrifix(sheetObjects[2].GetSaveString(), "t2sheet1_"); 
 	          	    sParam += "&" + ComSetPrifix(sheetObjects[3].GetSaveString(), "t2sheet2_"); 
 	          		
 	          		var sXml = sheetObj.GetSaveXml("ESM_BKG_0905GS.do", sParam); 
 	          		/*
 	          		sheetObjects[2].LoadSaveXml(sXml);
 	          		sheetObjects[3].LoadSaveXml(sXml);
 	          		*/ 
 	          		sheetObjects[3].LoadSaveXml(sXml);
 	          		sXml = ComDeleteMsg(sXml);  
 	          		sheetObjects[2].LoadSaveXml(sXml);  
 	          		//<------------------------------------------(containerVO)
 	          	}  	          	
                break;

 			case IBINSERT:      // 입력
 		    	var mstSheetObj    = sheetObjects[0];
 		    	var mstSheetObj_t2 = sheetObjects[2];
 		    	 
 		    	//마스터가 Insert상태이면 detail입력불가 처리함 
 		    	if (sheetObj.id == "t2sheet2") {
 		    		var ibflag = mstSheetObj_t2.CellValue(mstSheetObj_t2.SelectRow, "ibflag");  
 					if (ibflag == "I") {
 						ComShowCodeMessage("COM12242", "Detail Data, After Master Saving"); 
 						return false;
 					}
 		    	}

 		    	//신규행 추가
 		    	sheetObj.DataInsert(-1); 
				setDefaultInsertRow(sheetObj, sheetObj.SelectRow); 
                break;
    	}
	}

    // Sheet관련 프로세스 처리_detail조회 
    //function doActionIBSheet2(sheetObj,formObj,sAction) {
    function doActionIBSheet2(sheetObj, sFormQueryString, sAction) { 
    	sheetObj.ShowDebugMsg = false;
    	var formObj = document.form;
         
    	switch(sAction) {
           	case IBSEARCH:      //조회	
 	          	//if(!validateForm(sheetObj,formObj,sAction)) return;           		     		
 	          	if (sheetObj.id=="t1sheet2"){   
 	          		formObj.f_cmd.value = SEARCH01;     		
 	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj)+"&"+sFormQueryString);
 	          	} else if (sheetObj.id=="t2sheet2"){   
 	          		formObj.f_cmd.value = SEARCH03;   
 	          		sheetObj.DoSearch("ESM_BKG_0905GS.do", FormQueryString(formObj)+"&"+sFormQueryString);
 	          	}
                break;
    	}
	}
    
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
    	//1.기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크 
    	if (!ComChkValid(formObj)) return false;
    	 
    	//2.업무체크-업무에서 필요한 Validation 체크 
    	with(formObj) {
	        switch (sAction) {
	            case IBSEARCH: // 조회
	            	if (tro_act_cust_knd_cd.value == "C"){
						if (cust_cnt_cd.value == "") {
							ComBkgNessMessage(cust_cnt_cd);  //ComShowCodeMessage('BKG00104');
							return false;
						}
	            	} else if (tro_act_cust_knd_cd.value == "E") {
						if (ofc_cd.value == "") {
							ComBkgNessMessage(ofc_cd);
							return false;
						} 
						if (tro_act_rep_nm.value == "") {
							ComBkgNessMessage(tro_act_rep_nm);
							return false;
						}
	            	}
	                break;
	                 
	            case IBSAVE: // 저장	 
	            	if (tro_act_cust_knd_cd.value == "C"){
	            		var sheetObj = sheetObjects[1]; 
			    		var emlArr = null;
	            		for (var i=1; i<=sheetObj.RowCount; i++) {
							if (sheetObj.CellValue(i, "act_shpr_nm") == "") {
								ComShowCodeMessage("COM12200", i+" row: Factory Name(Actual Customer)");
								sheetObj.SelectCell(i, "act_shpr_nm");
								return false;
							}							 
							if (sheetObj.CellValue(i, "zn_cd") != "" && sheetObj.CellValue(i, "loc_cd") == "") { 
								ComShowCodeMessage("COM12200", i+" row: Location");
								sheetObj.SelectCell(i, "loc_cd");
								return false;
						 	}
	            		}
	            	} else if (tro_act_cust_knd_cd.value == "E") {
            		 	var sheetObj = sheetObjects[2]; 
	            		for (var i=1; i<=sheetObj.RowCount; i++) {
	            			if (sheetObj.CellValue(i, "tro_act_rep_nm") == "") {
	            				ComShowCodeMessage("COM12200", i+" row: Representative Name");
	            				sheetObj.SelectCell(i, "tro_act_rep_nm");
	            				return false;
	            			}
	            		}
	            		 
	            		var sheetObj = sheetObjects[3]; 
	            		for (var i=1; i<=sheetObj.RowCount; i++) {
	            			if (sheetObj.CellValue(i, "act_shpr_nm") == "") {
	            				ComShowCodeMessage("COM12200", i+" row: (Factory Name(Actual Customer)");
	            				sheetObj.SelectCell(i, "act_shpr_nm");
	            				return false;
	            			}
							if(sheetObj.CellValue(i, "cntc_eml") != ""){
								emlArr = sheetObj.CellValue(i, "cntc_eml").split(";");
			    			 	for(var i = 0; i < emlArr.length; i++){
			    			 		if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
			    			 			ComShowCodeMessage("BKG40021" , emlArr[i]);
			    			 			return false;
			    			 		}
			    			 	}
							}
	            		}	            		 
	            	}
	            	break;
	        }
    	}
    	return true;
    }
      
    function searchDetail(sheetObj, Row){ 	
    	//현재 포커스된 데이터 행의 값 가져와서 조회하기
    	var param = "";

    	if (sheetObj.id=="t1sheet1") {   
    		//조회된 데이터가 없는 경우 처리
    		if (sheetObj.RowCount == 0) {
    			sheetObjects[1].RemoveAll();   //t1 detail 초기화  
    		}        	 
    		param += "f_cnt_cd="   +sheetObj.CellValue(Row, "cust_cnt_cd");
    		param += "&f_cust_seq="+sheetObj.CellValue(Row, "cust_seq");
    		param += "&f_ofc_cd="  +sheetObj.CellValue(Row, "ofc_cd");
	         
    		doActionIBSheet2(sheetObjects[1], param, IBSEARCH);
    	} else if (sheetObj.id=="t2sheet1") {   
    		//마스터그리드의 selectedRow의 ibflag="I"이면, detail그리드는 removeAll만하고, 마스터입력대기상태로 유지
        	var mstIbFlag = sheetObj.CellValue(Row, "ibflag"); 
        	if ("I" == mstIbFlag){
        		sheetObjects[3].RemoveAll();   //t2 detail 초기화   
        		sheetObj.SelectCell(Row, "tro_act_rep_nm");
        	} else {
	         	//조회된 데이터가 없는 경우 처리
	            if (sheetObj.RowCount == 0) {
	            	sheetObjects[3].RemoveAll();   //t2 detail 초기화   
	            }      
		        param += "f_ofc_cd="        +sheetObj.CellValue(Row, "ofc_cd");  //tro_act_cust_knd_cd -> formobj 
		        param += "&tro_act_rep_seq="+sheetObj.CellValue(Row, "tro_act_rep_seq"); 
	
		        doActionIBSheet2(sheetObjects[3], param, IBSEARCH);
        	}
    	}
    }     
     
     /**     
      * selectedIndex 값에 따라, tro_act_cust_knd_cd hidden값을 설정한다.
      */
    function setHiddenValTabIdx(nTabIdx){
    	if (bInitfalg == false)  //페이지 최초로딩시, true 
    	{
    		if (nTabIdx == 0) {
    			document.form.tro_act_cust_knd_cd.value = "C";
    		} else if (nTabIdx == 1) {
    			document.form.tro_act_cust_knd_cd.value = "E";
    		}   
 		}
    }
     
     /**     
      * AddRow한 행에, 특정항목의 default값을 설정한다.
      */
    function setDefaultInsertRow(sheetObj, nRow) {
    	var mstSheetObj    = sheetObjects[0];
    	var mstSheetObj_t2 = sheetObjects[2];
    	 
    	//신규행 초기값 setting 
    	if (sheetObj.id=="t1sheet2") {   
    		sheetObj.CellValue2(nRow, "tro_act_cust_knd_cd") = document.form.tro_act_cust_knd_cd.value;
    		sheetObj.CellValue2(nRow, "cnt_cd")   = mstSheetObj.CellValue(mstSheetObj.SelectRow, "cust_cnt_cd");
    		sheetObj.CellValue2(nRow, "cust_seq") = mstSheetObj.CellValue(mstSheetObj.SelectRow, "cust_seq");
    		sheetObj.CellValue2(nRow, "ofc_cd")   = mstSheetObj.CellValue(mstSheetObj.SelectRow, "ofc_cd");
    	} else if (sheetObj.id=="t2sheet1") {   
    		sheetObj.CellValue2(nRow, "tro_act_cust_knd_cd") = document.form.tro_act_cust_knd_cd.value;
    		sheetObj.CellValue2(nRow, "ofc_cd")              = document.form.ofc_cd.value;  
    		sheetObjects[3].RemoveAll();  //t2 detail 초기화 
    	} else if (sheetObj.id=="t2sheet2") {   
    		sheetObj.CellValue2(nRow, "tro_act_cust_knd_cd") = document.form.tro_act_cust_knd_cd.value;
    		sheetObj.CellValue2(nRow, "ofc_cd")              = mstSheetObj_t2.CellValue(mstSheetObj_t2.SelectRow, "ofc_cd");
    		sheetObj.CellValue2(nRow, "tro_act_rep_seq")     = mstSheetObj_t2.CellValue(mstSheetObj_t2.SelectRow, "tro_act_rep_seq");
    	}
    }
     
     /**  
      * DeleteRow할 행에, status값을 설정한다.
      */ 
    function setRowDelStatus(sheetObj, nRow) {
    	sheetObj.CellValue2(nRow, "ibflag") = "D";
    }     
      
     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */   
    function tab1_OnChange(tabObj , nItem) {
        var objs = document.all.item("tabLayer");
     	objs[nItem].style.display     = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 ----------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab = nItem;
     	
     	setHiddenValTabIdx(nItem);  //hidden값 설정 
    }     
     
    function h1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	 
    	if (formObj.act_shpr_cnt_cd.value != "" && formObj.act_shpr_seq.value != "") {
	        formObj.cust_cnt_cd.value = formObj.act_shpr_cnt_cd.value;
	        formObj.cust_seq.value    = formObj.act_shpr_seq.value;
    	} else {
    		formObj.cust_cnt_cd.value = sheetObj.EtcData("p_cust_cnt_cd");
	        formObj.cust_seq.value    = sheetObj.EtcData("p_cust_seq");	
    	}
    	formObj.ofc_cd.value      = sheetObj.EtcData("p_eq_ctrl_ofc_cd");	 
    }
     
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {	 
     	if (sheetObj.RowCount>0) {
     		sheetObj.CellBackColor(1,"factory") = sheetObj.WebColor("CCFFFD");
     	}	
        searchDetail(sheetObj, sheetObj.SelectRow); //Detail grid 조회  
        sheetObj.SelectRow = 1; 
    }
    
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {         
         searchDetail(sheetObj, sheetObj.SelectRow); //Detail grid 조회 
         sheetObj.SelectRow = 1;         
    }
     
    function t1sheet2_OnSaveEnd(sheetObj, ErrMsg) {	 
    	if (ErrMsg == "") {
  	 		ComBkgSaveCompleted();  //서버메세지 처리
  	 		searchDetail(sheetObjects[0], sheetObjects[0].SelectRow);   //detail grid 조회
    	} 	 	
    }
    
  	function t2sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
  		if (ErrMsg == "") {
 	 		ComBkgSaveCompleted();  //서버메세지 처리
 	 		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);  //master+detail재조회 
  		} 	 	
 	} 
     
    function t1sheet1_OnClick(sheetObj, Row, Col, Value) { 
    	searchDetail(sheetObj, Row);  //detail grid 조회
    }
    
    function t2sheet1_OnClick(sheetObj, Row, Col, Value) {	
    	searchDetail(sheetObj, Row);  //detail grid 조회
    }
     
    function t2sheet2_OnChange(sheetObj, Row, Col, Val) {
        var colId   = sheetObj.ColSaveName(Col);
        var formObj = document.form; 
        
        with(formObj) {
            switch(colId) {
	            case "cnt_cd":
	            case "vndr_seq":
	                //Code 2개 모두존재시, CodeNm 조회 
	                if (sheetObj.CellValue(Row,"cnt_cd")!="" && sheetObj.CellValue(Row,"vndr_seq")!="") {
	                	f_cmd.value = SEARCH04;	
	                	var param = "";
	                	param += "cnt_cd="   +sheetObj.CellValue(Row, "cnt_cd");
	       	            param += "&vndr_seq="+sheetObj.CellValue(Row, "vndr_seq");
	       	         
	        			var sXml = sheetObj.GetSearchXml("ESM_BKG_0905GS.do", FormQueryString(formObj)+"&"+param);
	        			var vndr_lgl_eng_nm = ComGetEtcData(sXml, "vndr_lgl_eng_nm");
	        			
	        			if(vndr_lgl_eng_nm == "") {
	        				sheetObj.CellValue2(Row, Col) = "";			
	        				sheetObj.CellValue2(Row, "vndr_lgl_eng_nm") = "";	
	        				//ComAlertFocus(vndr_seq, "Vendor Code가 존재하지 않습니다.");  //ComGetMsg("")
	        				ComShowCodeMessage("BKG00095");	
	        				sheetObj.SelectCell(Row, Col);
	        				return;	        				
	        			} else {
	        				sheetObj.CellValue2(Row, "vndr_lgl_eng_nm") = vndr_lgl_eng_nm;
	        			}
	            	}
	            	break;
	         }
        }       
	}
    
    /**
    *  LOC 팝업
    */
    function t1sheet2_OnPopupClick(sheetObj, row, col){
    	if (sheetObj.ColSaveName(col) == "loc_cd") {
    		var locCd = sheetObj.CellValue(row, "loc_cd");
    		//var ydCd  = sheetObj.CellValue(row, "zn_cd");
    		comBkgCallPop0083('callBack0083_sheet','', locCd, "", "", row, col, 1);
        }
    }   
    
    /**
    *  LOC 팝업
    */
    function t2sheet2_OnPopupClick(sheetObj, row, col){
    	if (sheetObj.ColSaveName(col) == "loc_cd") {
    		var locCd = sheetObj.CellValue(row, "loc_cd");
    		//var ydCd  = sheetObj.CellValue(row, "zn_cd");
    		comBkgCallPop0083('callBack0083_sheet','', locCd, "", "", row, col, 3);
        }
    }   
    
    /**
    * Node Search 팝업 호출. <br>
    * <br><b>Example :</b>
    * <pre>
    *     comBkgCallPop0083(callback_func, bkgCustTpCd, custCntCd, custSeq, rdTerm);
    * </pre>
    * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
    */
    function comBkgCallPop0083(callback_func, locTp, locCd, ydCd, rdTerm, nRow, nCol, sheetIdx){    	
    	ComOpenPopup("ESM_BKG_0083.do?pgmNo=ESM_BKG_0083&loc_tp="+locTp+"&loc_cd="+locCd+"&yd_cd="+ydCd+"&rd_term="+rdTerm, 990, 450, callback_func,"1,0,1,1,1", true, false, nRow, nCol, sheetIdx);    	
    }      
    
    /**
     * Node Search 팝업에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0083(bkgCustTpCd, custCntCd, custSeq, custNm);
     * </pre>
     * @param Popup에서 전달받은 값
     */
	function callBack0083_sheet(locTp, tab, rArray, row, col, sheetIdx){      
    	var formObj = document.form;
     	if(rArray != null){
     		if(tab == 1){
     			sheetObjects[sheetIdx].CellValue2(row, col) = rArray[0][2];	  
     		}	
     	}
    }     
    
	/* 개발자 작업  끝 */