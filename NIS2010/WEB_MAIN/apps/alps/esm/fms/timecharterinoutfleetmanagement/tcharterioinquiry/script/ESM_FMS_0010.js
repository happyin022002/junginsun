/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0010.js
*@FileTitle : Statement of Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.11 최우석
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
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
     * @class esm_fms_0010 : esm_fms_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setVslCd				= setVslCd;
    	this.setContractNo			= setContractNo;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.controlScrollBar		= controlScrollBar;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    	this.speedDown2Excel		= speedDown2Excel;
    	this.sheet1_OnScroll		= sheet1_OnScroll;
    	this.sheet2_OnScroll		= sheet2_OnScroll;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //2017.05.15 contract type 콤보로 변경
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var sheetObject2 = sheetObjects[2];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
     			case "btn_retrieve":
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
     				break;

     			case "btn_new":
    		 		ComResetAll();
    		 		sheetObjects[1].style.height = 0;
  	  				controlScrollBar();
     				break;

     			case "btn_savetofile":
     				//sheetObject.SpeedDown2Excel(-1);
     				speedDown2Excel();
     				break;

     			case "btn_print":
     				rdOpen(rdObjects[0], document.form);
     				break;

     			case "btn_vslCd":
     				ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0022");
     				break;
     			
     			case "btn_fletCtrtNo":
     				if(formObject.vslCd.value == "") {
     					ComAlertFocus(formObject.vslCd, ComGetMsg('FMS01231'));
     					return;
     				}
     				ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vslCd.value, 520, 405, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0023");
     				break;
     			
     			case "btn_vslCdClr":
     				form.vslCd.value = "";
     				form.vslEngNm.value = "";
     				form.fletCtrtNo.value = "";
     				//form.fletCtrtTpCd.value = "";		//2017.05.15 contract type 콤보로 변경
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

    //2017.05.15 contract type 콤보로 변경
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
    		//khlee-시작 환경 설정 함수 이름변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    		
    		sheetObjects[i].ExtendLastCol = false;
    	}
    	
    	initControl();
    	
    	//RD
		initRdConfig(rdObjects[0]);
		
		//2017.05.15 contract type 콤보로 변경
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "ComCd");
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
 					style.height = 398;
 					//전체 너비 설정
                 	SheetWidth = mainTable.clientWidth;

                 	//Host정보 설정[필수][HostIp, Port, PagePath]
                 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 	//전체Merge 종류 [선택, Default msNone]
                 	//MergeSheet = msPrevColumnMerge;
                 	MergeSheet = msAll;

                 	//전체Edit 허용 여부 [선택, Default false]
                 	Editable = true;

                 	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 	InitRowInfo( 1, 1, 3, 100);

                 	// 해더에서 처리할 수 있는 각종 기능을 설정한다
                 	InitHeadMode(true, true, false, true, false,false)

                 	var HeadTitle = "Item Name|Hire No.|Period|Description|Curr|DR Amount|Curr|CR Amount";
                 	var headCount = ComCountHeadTitle(HeadTitle);
                 	
                 	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 	InitColumnInfo(headCount, 0, 0, true);

                 	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 	InitHeadRow(0, HeadTitle, true);

                 	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 	InitDataProperty(0, cnt++ , dtData,      190,   daLeft,  	false,  "itm_nm",     	false,	"",	dfNone,   		0,	false,	true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daRight,  	false,  "hire_no",		false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      200,   daCenter,  	false,  "acct_dt",	 	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      250,   daLeft,  	false,  "acct_desc",  	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	false,  "curr_cd1",     false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      87,    daRight,   	false,	"dr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	false,  "curr_cd2",    	false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      87,    daRight,   	false,  "cr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	
                 	SetSortDialog(false);
 					CountPosition = 0;
 					FocusAfterProcess = false;
 					SelectHighLight = false;
					SelectFontBold = false;
 					
 					DataRowMerge(0) = true;
 					
 					//ScrollBar = 2;
 				}
 				break;
 				
 			case "sheet2":
 				with (sheetObj) {

 					// 높이 설정
 					style.height = 0;
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msPrevColumnMerge;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 1, 1, 3, 100);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(false, true, false, true, false,false)

 					var HeadTitle = "Item Name|Hire No.|Period|Description|Currency|DR Amount|Currency|CR Amount";
 					var headCount = ComCountHeadTitle(HeadTitle);
 					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtData,      190,   daLeft,  	false,  "itm_nm",     	false,	"",	dfNone,   		0,	false,	true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daRight,  	false,  "hire_no",		false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      200,   daCenter,  	false,  "acct_dt",	 	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      250,   daLeft,  	false,  "acct_desc",  	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	false,  "curr_cd1",     false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      87,    daRight,   	false,	"dr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  	false,  "curr_cd2",    	false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      87,    daRight,   	false,  "cr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	
                 	SetSortDialog(false);
 					CountPosition = 0;
 					FocusAfterProcess = false;
 					SelectHighLight = false;
 				}
 				break;
 				
 			case "sheet3":
 				with (sheetObj) {

 					// 높이 설정
 					style.height = 0;
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;

 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msPrevColumnMerge;

 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;

 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 1, 1, 3, 100);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(false, true, false, true, false,false)

 					var HeadTitle = "Item Name|Hire No.|Period|Description|Currency|DR Amount|Currency|CR Amount";
 					var headCount = ComCountHeadTitle(HeadTitle);
 					
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(headCount, 0, 0, true);

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle, true, true);

 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtData,      190,   daLeft,  	false,  "itm_nm",     	false,	"",	dfNone,   		0,	false,	true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      50,    daRight,  	false,  "hire_no",		false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      200,   daCenter,  	false,  "acct_dt",	 	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      250,   daLeft,  	false,  "acct_desc",  	false,  "", dfNone,      	0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  	false,  "curr_cd1",     false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      77,    daRight,   	false,	"dr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  	false,  "curr_cd2",    	false,  "", dfNone, 		0,  false,  true, -1, false, false);
                 	InitDataProperty(0, cnt++ , dtData,      77,    daRight,   	false,  "cr_amt",     	false,  "", dfNullFloat, 	2,  false,  true, -1, false, false);
                 	
                 	SetSortDialog(false);
 					CountPosition = 0;
 					FocusAfterProcess = false;
 					SelectHighLight = false;
 				}
 				break;
    	}
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

 			case IBSEARCH:      //조회
 				//2017.05.15 contract type 콤보로 변경
 				/*
 				if(objNm == "fletCtrtTpCd") {
		 			formObj.f_cmd.value = SEARCH04;
		 			var param = FormQueryString(formObj) + "&flet_ctrt_no=" + formObj.fletCtrtNo.value;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , param);
		   			var ctrtType = ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.fletCtrtTpCd.value = ctrtType;
					}
 				} else 
 				*/
 				
 				if(objNm == "vslCd") {
        			formObj.f_cmd.value = SEARCH01;

        			var param = FormQueryString(formObj) + "&vsl_cd=" + formObj.vslCd.value;
    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
    	   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");

    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vslEngNm.value = vslEngNm;
    	   				form.fletCtrtNo.value = "";
         				//form.fletCtrtTpCd.value = "";		//2017.05.15 contract type 콤보로 변경
    	   				//form.btn_vslCdClr.checked = true;
         				initDefaultContractNo();  //선박 대 계약 자동 매치
    				} else {
    					//form.btn_vslCdClr.checked = false;
    					formObj.vslCd.value = "";
    					form.fletCtrtNo.value = "";
         				//form.fletCtrtTpCd.value = "";		//2017.05.15 contract type 콤보로 변경
    					// 존재하지 않는 Vessel Code입니다
    					ComAlertFocus(formObj.vslCd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
 				} else if(objNm == "ComCd") {		//2017.05.15 contract type 콤보로 변경
 					
 					sheetObj.WaitImageVisible = false;
 					
 					formObj.f_cmd.value = SEARCH04;
 					
 		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
 		   			
 		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
 		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
 		   			
 		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
 	    				var comboCode = fletCtrtTpCd;
 	    				var comboText = fletCtrtTpNm;

 	    				setDataCombo(comboObjects[0], comboText, comboCode);
 	    			}
 		   			
 		   			sheetObj.WaitImageVisible = true;
 		   				
 				} else {
	 				if(validateForm(sheetObj,formObj,sAction)) {
	 					formObj.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0010GS.do", FormQueryString(formObj));
	       	   	  		var arrXml = sXml.split("|$$|");
	       	   	  		
	       	   	  		if (arrXml.length > 0) {
	     	   	  			sheetObjects[0].LoadSearchXml(arrXml[0]);
	     	   	  			sheetObjects[1].RemoveAll();
	     	   	  			sheetObjects[1].LoadSearchXml(arrXml[1]);
	     	   	  			var total = ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
	     	   	  			if(total > 0) {
	     	   	  				sheetObjects[1].style.height = 40 + (total * 20);
	     	   	  			} else {
	     	   	  				sheetObjects[1].style.height = 0;
	     	   	  			}
	     	   	  			controlScrollBar();
	     	   	  		} else {
	     	   	  			sheetObjects[1].style.height = 0;
	     	   	  		}
	 				}
 				}
	 			break;

 			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치			
				if(formObj.vslCd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vslCd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll;  

				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);
	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");		//2017.05.15 contract type 콤보로 변경
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.fletCtrtNo.value = varFletCtrtNo;
					formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;		//2017.05.15 contract type 콤보로 변경
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
	   		    //2017.05.15 contract type 콤보로 변경
				/*
	   			if(formObj.fletCtrtNo.value != ""){
					contract_no_change();
				}
				*/
				break;		
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) {
    		return false;
     	}
    	
    	return true;
    }
     
    /**
 	 * Vessel Code 팝업창에서 선택한 Vessel Code와 Name을 Form항목에 설정한다.<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setVslCd(aryPopupData) {
 		form.vslCd.value = aryPopupData[0][2];
 		form.vslEngNm.value = aryPopupData[0][3];
 		
 		initDefaultContractNo(); //선박 대 계약 자동 매치
 	}
 	
 	/**
	 * Contract Code 팝업창에서 선택한 Contract No.을 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.fletCtrtNo.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];		//2017.05.15 contract type 콤보로 변경
		
		//2017.05.15 contract type 콤보로 변경
		//contract_no_change(); //선박 대 계약 자동 매치
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"fletCtrtTpCd"); //선박 대 계약 자동 매치
	}
	
	//선박 대 계약 자동 매치
	//2017.05.15 contract type 콤보로 변경
	/*
	function contract_no_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"fletCtrtTpCd");
    }
    */
	
	/**
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 	 **/
 	function initControl() {
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
 		//2010.11.24 이상민 [CHM-201007233-01] : vslCd 는 eng_keypress-> engnum_keypress로 변경
 		axon_event.addListenerForm  ('keypress', 'engnum_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
 		axon_event.addListenerForm  ('change',   'obj_change',   form); 			//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
 	}

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     * @return {없음}
     **/
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     * @return {없음}
     **/
    function eng_keypress() {
    	if((event.srcElement.name == "vslCd")) { 
    		//영대문자 자동변환
    		ComKeyOnlyAlphabet('upper');
    	}
    }
     
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
    	 if((event.srcElement.name == "vslCd")) { 
     		//영대문자 자동변환
     		ComKeyOnlyAlphabet('uppernum');
     	}
     } 
    
    /**
     * HTML Control의 onchange이벤트에서 Vessel Name을 가져온다.<br>
     * @return {없음}
     */
	function obj_change() {
		if((event.srcElement.name == "vslCd")) {
	    	form.vslEngNm.value = "";
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vslCd");
		}
	}
     
    /**
     * 데이타 조회시 스크롤바를  자동으로 컨트롤한다.<br>
     **/
 	function controlScrollBar() {
 		try{
 			top.syncHeight();
 		} catch(err){ComFuncErrMsg(err.message);}
 	}
    
    /**
     * sheet1의 OnSearchEnd 이벤트 발생시 각 타이틀의 Font를 Bold로 설정한다.<br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {string}  errMsg      Error Message
     * @return {없음}
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var row=1; row<=sheetObj.LastRow; row++) {
    		if(sheetObj.CellValue(row,"itm_nm").substring(0,2) == "1." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "2." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "3." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "4." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "5." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "6." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "7." ||
    		   sheetObj.CellValue(row,"itm_nm").substring(0,2) == "8.") {
	    		sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,243,164);
	    		sheetObj.CellFont("FontBold", row, "itm_nm") = true;
    		} else {
    			sheetObj.ToolTipText(row,"acct_desc") = sheetObj.CellValue(row,"acct_desc");
    		}
    	}
    }
    
    /**
     * sheet2의 OnSearchEnd 이벤트 발생시 조회된 데이터의 폰트를 Bold로 변경한다.<br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {string}  errMsg      Error Message
     * @return {없음}
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	for(var row=1; row<=sheetObj.LastRow; row++) {
    		if(row == 1) {
    			sheetObj.CellValue2(row, "itm_nm") = "Total Amount";
    		} else {
    			sheetObj.CellValue2(row, "itm_nm") = "";
    		}
    		sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,230,251); 
    		sheetObj.CellFont("FontBold", row, "itm_nm") = true;
    		sheetObj.CellFont("FontBold", row, "curr_cd1") = true;
    		sheetObj.CellFont("FontBold", row, "dr_amt") = true;
    		sheetObj.CellFont("FontBold", row, "curr_cd2") = true;
    		sheetObj.CellFont("FontBold", row, "cr_amt") = true;
    	}
    }
    
    /**
     * sheet가 분리되어 있는 데이타부분과 합계부분을 같이 출력하기 위해 임시 sheet에 데이타를 옮기후 엑셀로 출력한다.<br>
     */
    function speedDown2Excel() {
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
 		
    	var targetSheetObj = sheetObjects[2];
    	
    	for(var row=1; row<=sheetObjects[0].LastRow; row++) {
    		var currRow = targetSheetObj.DataInsert();

    		targetSheetObj.CellValue2(currRow,"itm_nm") = sheetObjects[0].CellValue(row,"itm_nm");
    		
    		if(sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "1." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "2." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "3." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "4." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "5." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "6." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "7." ||
			   sheetObjects[0].CellValue(row,"itm_nm").substring(0,2) == "8.") {
    			targetSheetObj.CellValue2(currRow,"hire_no") = "";
        		targetSheetObj.CellValue2(currRow,"acct_dt") = "";
        		targetSheetObj.CellValue2(currRow,"acct_desc") = "";
    		} else {
    			targetSheetObj.CellValue2(currRow,"hire_no") = sheetObjects[0].CellValue(row,"hire_no");
        		targetSheetObj.CellValue2(currRow,"acct_dt") = sheetObjects[0].CellValue(row,"acct_dt");
        		targetSheetObj.CellValue2(currRow,"acct_desc") = sheetObjects[0].CellValue(row,"acct_desc");
    		}
    		
    		targetSheetObj.CellValue2(currRow,"curr_cd1") = sheetObjects[0].CellValue(row,"curr_cd1");
    		targetSheetObj.CellValue2(currRow,"dr_amt") = sheetObjects[0].CellValue(row,"dr_amt");
    		targetSheetObj.CellValue2(currRow,"curr_cd2") = sheetObjects[0].CellValue(row,"curr_cd2");
    		targetSheetObj.CellValue2(currRow,"cr_amt") = sheetObjects[0].CellValue(row,"cr_amt");
    	}

    	for(var row=1; row<=sheetObjects[1].LastRow; row++) {
    		var currRow = targetSheetObj.DataInsert();
    		
    		if(row == 1) {
    			targetSheetObj.CellValue2(currRow,"itm_nm") = "Total Amount";
    		}
    		targetSheetObj.CellValue2(currRow,"hire_no") = sheetObjects[1].CellValue(row,"hire_no");
    		targetSheetObj.CellValue2(currRow,"acct_dt") = sheetObjects[1].CellValue(row,"acct_dt");
    		targetSheetObj.CellValue2(currRow,"acct_desc") = sheetObjects[1].CellValue(row,"acct_desc");
    		targetSheetObj.CellValue2(currRow,"curr_cd1") = sheetObjects[1].CellValue(row,"curr_cd1");
    		targetSheetObj.CellValue2(currRow,"dr_amt") = sheetObjects[1].CellValue(row,"dr_amt");
    		targetSheetObj.CellValue2(currRow,"curr_cd2") = sheetObjects[1].CellValue(row,"curr_cd2");
    		targetSheetObj.CellValue2(currRow,"cr_amt") = sheetObjects[1].CellValue(row,"cr_amt");
    	}
    	
    	targetSheetObj.Down2Excel(-1);
    	
    	targetSheetObj.RemoveAll();
    }
    
    /**
 	 * 페이지에 있는 RD Object를 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
 	 * @param {rdObject} rdObject    RD Object
 	 * @return {없음}
 	 **/
 	function initRdConfig(rdObject){
 	    var Rdviewer = rdObject ;
 	    Rdviewer.style.height = 0;
 	    Rdviewer.style.width = 0;
 	    
 	    Rdviewer.AutoAdjust = true;
 	    Rdviewer.ViewShowMode(0);

 		Rdviewer.setbackgroundcolor(128,128,128);
 		Rdviewer.SetPageLineColor(128,128,128);
 	}
    
 	/**
     * RD 출력하기 <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     * @return {없음}
     **/
    function rdOpen(rdObject, formObject){
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
 		
		var Rdviewer = rdObject ;
	
		rdParam = RD_FormQueryString(formObject,1);
		var rdParam = '/rv '+ rdParam;
		var rdFile = 'ESM_FMS_011.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/'+rdFile, RDServer+rdParam);
		Rdviewer.CMPrint (); //인쇄 시작
	}
    
    /**
     * sheet1의 OnScroll 이벤트 발생시 sheet2의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet1_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[1].LeftCol = newLeftCol;
    }
    
    /**
     * sheet2의 OnScroll 이벤트 발생시 sheet1의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet2_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[0].LeftCol = newLeftCol;
    }
    
    //선박 대 계약 자동 매치
    function initDefaultContractNo(){
    	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);  
      } 
    
    //2017.05.15 contract type 콤보로 변경
    function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
        } 
    }

    //2017.05.15 contract type 콤보로 변경
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		
		if(form.vslCd.value == "") return;	
	
		var f_query = "";					
		f_query += "f_cmd=" + SEARCH01; 
		f_query += "&vsl_cd="+form.vslCd.value;	 			
		f_query += "&type_flag="+text;  
	
		var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
		var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
			
		if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
			form.fletCtrtNo.value = varFletCtrtNo;
		}else{
			ComShowCodeMessage("FMS20001","Agreement");
			clearAll();
			return;
		}
			
	}
	/* 개발자 작업  끝 */