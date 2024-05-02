/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0819.js
*@FileTitle : MI Transmit History  for IE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.13 김도완
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
     * @class esm_bkg_0819 : esm_bkg_0819 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0819() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
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
    					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
    					break;
    					
    				case "btn_DownExcel":
    					doActionIBSheet(sheetObject1,document.form,IBDOWNEXCEL);
    					break;
    					
    				case "btn_Select":
    					doActionIBSheet(sheetObject1,document.form,IBROWSEARCH);
    					break;
    				
    				case "btn_Close":
    					window.close();
    					break;	

    				case "btn_calendar":
    	                if(formObject.fromd.disabled) return;
    					var cal = new ComCalendarFromTo();
    	                cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
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
			//화면에서 필요한 이벤트
	    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	    	axon_event.addListenerForm("click","obj_click", document.form);
	    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

			doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
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
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					
					var HeadTitle1 = "|MSG|SENT DATE|OFFICE|USER ID|VVD|POL|POD|TTL B/L|IE(63)|P/MIB";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
											
					var prefix = "sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	 false,		prefix +"ibflag");
					InitDataProperty(0, cnt++ , dtData,     	60,     daCenter,    false,     prefix +"trsm_msg_tp_id",  	false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	195,    daCenter,    false,     prefix +"snd_dt",      		false,    "",      dfUserFormat2,	0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	145,    daCenter,    false,     prefix +"snd_usr_ofc_cd",   false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	145,    daCenter,    false,     prefix +"snd_usr_id",   	false,    "",      dfNone, 			0,     true,		true);
					                                                                                                    	
					InitDataProperty(0, cnt++ , dtData,      	145,    daCenter,    false,     prefix +"vvd",      		false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	130,    daCenter,    false,     prefix +"pol_cd",     		false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	85,     daCenter,    false,     prefix +"pod_cd",   		false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	85,     daCenter,    false,     prefix +"tot_bl", 			false,    "",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtData,      	80,     daCenter,    false,     prefix +"ie_bl",      		false,    "",      dfNone, 			0,     true,		true);
					
					InitDataProperty(0, cnt++ , dtData,      	110,    daCenter,    false,     prefix +"mib_bl",      		false,    "",      dfNone, 			0,     true,		true);    				                
					InitUserFormat2(0, prefix +"snd_dt", "####-##-## ##:##:##", "-|:" );
					
					//MassOfSearch=1
					//카운트를 표시할 포지션 /0의 경우 비표시 
					CountPosition = 2; 
					//토탈카운트표시 
					CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
				}
				break;
    		}
    	}

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	//sheetObj.ShowDebugMsg = false;
        	sheetObj.WaitImageVisible = false;
        	
            switch(sAction) {

	        	case IBCREATE:      //init
					if (sheetObj.id == "sheet1") {
						formObj.reset();
						formObj.fromd.value	=ComGetDateAdd(null, 'd', -7, '-');
						formObj.tod.value	=ComGetNowInfo('ymd','-');
						alterRequiredChk("1");
					}
					break;
					
	        	case IBSEARCH:      //조회
		        	if(!validateForm(sheetObj,formObj,sAction)) return;
					ComOpenWait(true);
	 				formObj.f_cmd.value = SEARCH;
	 				if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0819GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	 				ComOpenWait(false);
	 				break;
	 				
	        	case IBROWSEARCH:   //팝업
	        		var opener_obj = opener;
	    			var form1 = opener_obj.document.form;
	    			form1.vvd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vvd");
	        		form1.pod.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_pod_cd");
	        		window.close();
 					break;
 					
	        	case IBDOWNEXCEL:
					ComOpenWait(true);
					sheetObj.SpeedDown2Excel(-1);
					ComOpenWait(false);
 					break;
            }
        }



        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 switch(sAction) {
  				case IBSEARCH:
  					if(!ComChkRequired(formObj)) return false;
  					break;
        	 	}
        	 return true;
        }

            
        /**
         * 조회조건 입력할 때 처리
         */
        function obj_KeyUp() {
        	var val = "";
        }

        /**
         * 조회조건 클릭할 때 처리
         */
        function obj_click(){
        	var formObject = document.form;
        	var srcObj = window.event.srcElement;
        	var srcName = srcObj.getAttribute("name");
        	var srcVal =  srcObj.value;
        	
        	if(srcName == "gubun"){
        		alterRequiredChk(srcVal);
        	}
        }

        /**
         * 조회조건 클릭 시 처리
         */
        function alterRequiredChk(gubunVal){
        	var formObject = document.form;
        	if(gubunVal == "1"){
    			formObject.fromd.disabled = false;
    			formObject.fromt.disabled = false;
    			formObject.tod.disabled   = false;
    			formObject.tot.disabled   = false;
    			formObject.vvd.disabled = true;
    		}else{
    			formObject.fromd.disabled = true;
    			formObject.fromt.disabled = true;
    			formObject.tod.disabled   = true;
    			formObject.tot.disabled   = true;
    			formObject.vvd.disabled = false;
    			formObject.vvd.focus();
    		}        	
        }

        /**
         * 시트 더블클릭 시 처리
         */
        function sheet1_OnDblClick(Row, Col, CellX, CellY, CellW, CellH) {
        	var sheetObject1 = sheetObjects[0];
        	doActionIBSheet(sheetObject1,document.form,SEARCH02);
        }

        /**
         * 조회 후 처리
         */
        function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    	{
    		with(sheetObj)
    		{
    			for (var i = 1; i <= LastRow; i ++)
    			{
    				if (CellValue(i, "sheet1_mib_bl") != CellValue(i, "sheet1_ie_bl")){
    					CellFontColor(i, "sheet1_tot_bl") = RgbColor(255, 0, 0);		// 글자는 붉은색
    					CellFontColor(i, "sheet1_ie_bl") = RgbColor(255, 0, 0);
    					CellFontColor(i, "sheet1_mib_bl") = RgbColor(255, 0, 0);
    				}
    			}
    		}
    	}
	/* 개발자 작업  끝 */