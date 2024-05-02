/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1116.js
*@FileTitle : e-B/L Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.15 최도순
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
     * @class ESM_BKG_1116 : ESM_BKG_1116 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1116() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
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
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
	
					case "btn_New":
						sheetObject1.RemoveAll();
						formObject.reset();
					break;
						
					case "btn_Auth":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");	
							var srStsCd = sheetObject1.CellValue(iCheckRow,"sr_sts_cd");
							var authCfm = sheetObject1.CellValue(iCheckRow,"auth_cfm");
							var param = 'sr_sts_cd=I&bkg_no='+bkgNo;
							if(srStsCd == 'N'){
								doActionIBSheet(sheetObject1,formObject,IBSAVE);
								ComOpenWindow("/hanjin/ESM_BKG_1118.do?" + param, "PopupEsmBkg1118", "width=916, height=750, scrollbars=no", false);
							}
							
							if(srStsCd!='N'){
								ComShowCodeMessage("BKG08003");
								return;
							}							 
						}else{
							ComShowCodeMessage("BKG00249");
						}
					break;
					
					case "btn_ReAuth":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");	
							var srStsCd = sheetObject1.CellValue(iCheckRow,"sr_sts_cd");
							if(srStsCd=='N'){
								ComShowCodeMessage("BKG00478");
								return;
							}
							var param = 'sr_sts_cd=U&bkg_no='+bkgNo; 
							ComOpenWindow("/hanjin/ESM_BKG_1118.do?" + param, "PopupEsmBkg1118", "width=916, height=750, scrollbars=no", false);
						}else{
							ComShowCodeMessage("BKG00249");
						}
					break;
					case "btn_Delivery":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");	
							var srStsCd = sheetObject1.CellValue(iCheckRow,"sr_sts_cd");
							
//							if(srStsCd =='N'){
//								ComShowCodeMessgae("BKG00249")
//							}
							doActionIBSheet(sheetObject1,formObject,COMMAND01);
						}else{
							ComShowCodeMessage("BKG00249");
						}
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
					case "btn_Confirm":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");	
							var srStsCd = sheetObject1.CellValue(iCheckRow,"sr_sts_cd");

//							if(srStsCd!='W'||srStsCd!='R'){
//					 			ComShowCodeMessage("BKG95001", "check","E-BL Status");
//								return;
//							}
							
							doActionIBSheet(sheetObject1,formObject,COMMAND02);
						}else{
							ComShowCodeMessage("BKG00249");
						}
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
					case "btn_Reject":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");	
							var srStsCd = sheetObject1.CellValue(iCheckRow,"sr_sts_cd");
							
							if(srStsCd!='W'){
					 			ComShowCodeMessage("BKG95001", "check","E-BL Status");
								return;
							}
							
							var param = 'bkg_no='+bkgNo; 
							ComOpenWindow("/hanjin/ESM_BKG_1117.do?" + param, "PopupEsmBkg1117", "width=600, height=350, scrollbars=no", false);
						}else{
							ComShowCodeMessage("BKG00249");
						}
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
					case "btn_DownExcel":
						sheetObject1.Down2Excel(-1);
					break;
						
					case "btn_Preview":
						
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");						
							var param = 'bkg_no='+bkgNo; 
							ComOpenWindow("/hanjin/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "width=916, height=750, scrollbars=no", false);
						}else{
							ComShowCodeMessage("BKG00249");
						}
						
						break;
					break;
						
					case "btn_GoToBooking":
						var iCheckRow = sheetObject1.FindCheckedRow("sel").replace("|","");
						if(iCheckRow!==''){
							var bkgNo = sheetObject1.CellValue(iCheckRow,"bkg_no");					
							ComBkgCall0079(bkgNo);
						}else{
							ComShowCodeMessage("BKG00249");
						}
					break;	
					
					case "btn_Calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.elements["sr_rqst_st_dt"], formObject.elements["sr_rqst_end_dt"],'yyyy-MM-dd');
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
		
		// add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
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
						style.height = 420;
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
						
						var HeadTitle1 = "|Chk|Seq.|Request \n Type|ST|Ref. No.|Booking \n No.|Request \n Date|Shipper|Shipper|Shipper|Shipper|Remark|Auth|Auth|Auth|Ack";
						var HeadTitle2 = "|Chk|Seq.|Request \n Type|ST|Ref. No.|Booking \n No.|Request \n Date|Code|Name|E-mail|Phone|Remark|Confirm|BY|Date|Ack";
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, true, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
                        //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0,  cnt++,  dtHiddenStatus, 30,    daCenter,  true,     "ibflag");
                        InitDataProperty(0,  cnt++,  dtRadioCheck,   	 40,    daCenter,  true,     "sel",            false,    "",         dfNone,     0,          true,        true);                        
                        InitDataProperty(0,  cnt++,  dtSeq,          30,    daCenter,  true,     "seq");
                        InitDataProperty(0,  cnt++,  dtData,         55,    daCenter,  true,     "sr_rqst_tp_cd",  false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         30,    daCenter,  true,     "sr_sts_cd",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         100,   daLeft,  true,     "sr_rqst_no",     false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         100,   daCenter,  true,     "bkg_no",    	   false,    "",         dfNone,     0,          false,       false, 0, 0, false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "sr_rqst_dt",     false,    "",         dfNone,     0,          false,       false, 0, 0, false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "cust_cd",        false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         150,   daLeft,    true,     "cust_nm",        false,    "",         dfNone,     0,          false,       false);
                        
						InitDataProperty(0,  cnt++,  dtData,         100,    daLeft,  true,     "cntc_eml",  	   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "phn_no",     	   false,    "",         dfNone,  0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "ebl_rjct_rsn",  false,    "",         dfNone,  0,          false,       false);

                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "auth_cfm",       false,    "",         dfNone,  0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "ebl_cfm_usr_id",     false,    "",         dfNone,  0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "cre_dt", 		   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "ack_rcv_flg",    false,    "",         dfNone,     0,          false,       false);
                        
                        CountPosition = 2;
                        
                        AutoRowHeight  = false;
						EditableColorDiff = false;
					}
				break;


			}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_BKG_1116GS.do", FormQueryString(formObj)); 					
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var rXml = sheetObj.GetSaveXml("ESM_BKG_1116GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"sel"),"sheet1_"));
					
					sheetObj.LoadSaveXml(rXml);
				}
			break;
			case COMMAND01:	   //Delivery Notice 
				if(validateForm(sheetObj,formObj,sAction)) {
					

					formObj.f_cmd.value = COMMAND01;
					
					var rXml = sheetObj.GetSaveXml("ESM_BKG_1116GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"sel"),"sheet1_"));
					
					sheetObj.LoadSaveXml(rXml);
				}
			break;
			
			case COMMAND02:	   //Confirm 
			if(validateForm(sheetObj,formObj,sAction)) {
				formObj.f_cmd.value = COMMAND02;

				var rXml = sheetObj.GetSaveXml("ESM_BKG_1116GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"sel"),"sheet1_"));
				
				sheetObj.LoadSaveXml(rXml);
			}
			break;
			
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

			case IBSEARCH:      //조회
				with(formObj){
					if(vvd.value == ''&&bkg_no.value.length == ''){
						ComShowMessage(ComGetMsg('BKG00445','VVD or BKG NO'));						
						bkg_no.select();
						return false;
					}
				}
			break;
			
			case IBSAVE:        //저장
				with(formObj){
					
				}
			break;

        }
        return true;
    }
	
	/* ----------------------------------------------------------------------------
	 * Event 처리
	 -----------------------------------------------------------------------------*/
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
	
	function form1_blur(){
		//ComChkObjValid(event.srcElement);
	}

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
	

	/* 개발자 작업  끝 */