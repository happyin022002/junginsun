/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2035.js
*@FileTitle : Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.09.22 김창식 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class ees_cgm_2035 : ees_cgm_2035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_cgm_2035() {
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

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */ 
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
	  	var sheetObject2 = sheetObjects[1];         
	         
	  	/*******************************************************/
	  	var formObject = document.form;

	    try {
	    	var srcName = window.event.srcElement.getAttribute("name");

	        switch(srcName) {
	        	case "btn_Retrieve":
	        		if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {	
		        		// 조회 Action
	    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	        		}
					break;
								
				case "btn_New":
					initControl();
					break;
								
				case "btn_Save":
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {	
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					}
					break;
								
				case "btn_Cancel":
					doActionIBSheet(sheetObject1, formObject, IBRESET);
					break;	
					
				case "btns_office":	// Office Code 가져오기 팝업
					ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 800, 480, "ofc_cd:cost_ofc_cd", "1,0,1,1,1,1,1,1", true);
					break;
					
				case "btns_cost_yrmon":
	    			var cal = new ComCalendar();
					cal.setDisplayType('month');
				    cal.select(formObject.cost_yrmon, "yyyy-MM");	
    				
    				break;
    				
				case "btns_inv_rcv_dt":
					var cal = new ComCalendar();
		    		cal.select(formObject.inv_rcv_dt, "yyyy-MM-dd");
					break;
					
				case "btns_inv_iss_dt":
					var cal = new ComCalendar();
		    		cal.select(formObject.inv_iss_dt, "yyyy-MM-dd");
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
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
	function loadPage() {

		// axon event 등록
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    	axon_event.addListener('focusout', 'obj_focusout', 'inv_rcv_dt'); 
    	axon_event.addListener('focusout', 'obj_focusout', 'inv_iss_dt'); 
    	axon_event.addListener('focusout', 'obj_focusout', 'cost_yrmon'); 
    	
		for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );

	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	    }
		
		//IBMultiCombo초기화
		comboObjects[comboCnt++] = document.vndr_seq;
		comboObjects[comboCnt++] = document.chss_mgst_inv_sts_cd;
		for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
		
		/*
		// Option 조회
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC03);
		*/
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		
		// Control 초기화
		initControl();
	}

	/**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
    function initControl(){
    	var formObj = document.form;
    	 
		/* 기존 버그 '201000'으로 나옴
		// 현재 날짜 가져오기
    	var today   = new Date();
    	var year = today.getFullYear();
    	var month = today.getMonth();
    	var costYrmon = ComLpad(year, 4,"0") + "-" + ComLpad(month, 2,"0");
    	*/
		
		// chungpa 20100104 신규 적용
    	var d = new Date(); //firstDayInPreviousMonth(new Date());
    	var y = d.getYear(); 
    	var m = "";
    	var mtmp = d.getMonth()+1;
		if(mtmp<10)	m = '0'+mtmp; 
		else m = ''+ mtmp;
		var costYrmon = y+m;
		
     	formObj.cost_yrmon.value = costYrmon;
     	
     	// Multi Combo 초기화		
		comboObjects[0].Text2 = "ALL";
		comboObjects[0].Code2 = "ALL";
		
		comboObjects[1].Text2 = "ALL";
		
		// Sheet Object 초기화
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
    	 
    	// Cost Office Code 조회 (최초 LSE 이기 때문에 DB 에서 검색)
    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC01);
    	
    	// 버튼 비활성 설정
    	doActionBtnEnable('-1','-1');

    	// S.Provider 조회
    	doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
		
        // ALL 초기화
    	comboObjects[1].Text2 = "ALL";
   }
     
     /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * @param  {object} sheetObj	필수	 Sheet Object
      * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 김창식
      * @version 2009.09.22
      */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;
	        
    	switch(sheetID) {

	    	case "sheet1":
	    		with (sheetObj) {
	    			// 높이 설정
	                style.height = 162;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;

	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 10, 100);
	                    
	                var HeadTitle1 = "|Seq.|CHK|Cost Month|Invoice No.|Net Amount|Tax Div.|Tax|CSR No.|Total Amount|Status||||||||||";
	                    
	                var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		30,	daCenter,true,	"seq");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,true,	"del_chk",			false,	"",	dfNone,			0,	true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,	"cost_yrmon",		false,	"",	dfDateYm,		0,	false, false);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,true,	"inv_no",			false,	"",	dfNone,			0,	false, false);
						
					//InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,	"rev_vvd",			false,	"",	dfNone,			0,	true, true);
					InitDataProperty(0, cnt++ , dtData,			90,	daRight, true,	"chg_smry_amt",		false,	"",	dfNullFloat,	2,	false,false);
					InitDataProperty(0, cnt++ , dtCombo,		70,	daCenter,true,	"inv_tax_clt_tp_cd",false,	"",	dfNone,			0,	true, true);
					InitDataProperty(0, cnt++ , dtData,			70,	daRight, true,	"inv_tax_rt",		false,	"",	dfNullFloat,	2,	true, true);
					InitDataProperty(0, cnt++ , dtData,			145,daCenter,true,	"csr_no",			false,	"",	dfNone,			0,	false,false);
						
					InitDataProperty(0, cnt++ , dtData,			90,	daRight, true,	"inv_smry_amt",		false,	"",	dfNullFloat,	2,	false,false);
					InitDataProperty(0, cnt++ , dtData,			60,	daLeft,	 true,	"status",			false,	"",	dfNone,			0,  false,false);
					
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"pay_inv_seq");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"chg_cre_seq");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"agmt_seq");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"agmt_ver_no");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"chss_mgst_inv_knd_cd");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"chss_mgst_inv_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"status_cd");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"vndr_seq");
					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"inv_rgst_no");
					
					InitDataCombo(0, "inv_tax_clt_tp_cd", "V.A.T|W.H.T", "VAT|WHT");
					
					CountPosition = 0;

				}
				break;

	        case "sheet2":
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 202;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;

	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 10, 100);
	                    
	                var HeadTitle1 = "|Agreement No.|EQ No.|Tp/Sz|Charge Type|Cost Code|Account|Currency|Tax|Credit Amount|Amount";
	                    
	                var headCount = ComCountHeadTitle(HeadTitle1);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,true,"ibflag");
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,true,"agmt_no", 	 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			120,daCenter,true,"eq_no",		 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			60,	daCenter,true,"eq_tpsz_cd",	 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,"chg_cd",	 	 false,	"",	dfNone,		0,	true, false);
						
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,"cost_cd",	 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,"acct_cd",	 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,true,"curr_cd",	 false,	"",	dfNone,		0,	true, false);
					InitDataProperty(0, cnt++ , dtData,			80,	daRight, true,"pay_tax_amt", false,	"",	dfNullFloat,2,	true, false);
					InitDataProperty(0, cnt++ , dtData,			120,daRight, true,"pay_cr_amt",	 false,	"",	dfNullFloat,2,	true, false);
						
					InitDataProperty(0, cnt++ , dtData,			90,	daRight, true,"pay_lse_chg_amt", false,	"",	dfNullFloat,2,	true, false);

					CountPosition = 0;

				}
				break;
				
	        case "sheet3":
	        	with (sheetObj) {
        			// 높이 설정
                    style.height = 202;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
                        
                    var HeadTitle1 = "";
                        
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOL	TIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter,	true, "ibflag");
				}
        		break;
	        	break;

	    }
	}

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
      
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {

			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_2035GS.do" , FormQueryString(formObj), '', true); 
				sheetObj.LoadSearchXml(sXml);
				
				sheetObjects[1].RemoveAll();

				ComOpenWait(false);	
				
				break;
				
			case IBSEARCH_ASYNC04:	// 상세조회
				formObj.f_cmd.value = SEARCH01;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				var sXml = sheetObj.GetSearchXml("EES_CGM_2035GS.do" , FormQueryString(formObj), '', true); 
				sheetObj.LoadSearchXml(sXml);

				ComOpenWait(false);	
					
				break;
						
			case IBSAVE:        // Invoice Confirm
				
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				
				// Row 가 체크되었는지 확인하여 처리
	    		if(iCheckRow > 0){

					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);	
			
					formObj.f_cmd.value = MULTI01;
		     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
		     		
		     		var sParam = sheetObjects[0].GetSaveString(false);
		     		sParam = ComSetPrifix(sParam, "sheet1");
		         	sParam = sParam + "&";
		         	sParam = sParam + FormQueryString(formObj);
		         	
		     		var sXml = sheetObj.GetSaveXml("EES_CGM_2035GS.do", sParam);
		     		
		     		sheetObj.LoadSearchXml(sXml);

					ComOpenWait(false);	

	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
			
				break;
				
			case IBRESET:
				
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				
				// Row 가 체크되었는지 확인하여 처리
	    		if(iCheckRow > 0){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);

					formObj.f_cmd.value = MULTI02;
		     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
		     		
		     		var sParam = sheetObjects[0].GetSaveString(false);
		     		sParam = ComSetPrifix(sParam, "sheet1");
		         	sParam = sParam + "&";
		         	sParam = sParam + FormQueryString(formObj);
		         	
		     		var sXml = sheetObj.GetSaveXml("EES_CGM_2035GS.do", sParam);
		     		sheetObj.LoadSaveXml(sXml);
		     		
		     		sheetObjects[1].RemoveAll();

		     		ComOpenWait(false);		     		

	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
			
				break;
				
			
			case IBSEARCH_ASYNC01:	// Cost Office Code 조회
				
				formObj.f_cmd.value = SEARCH18;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				
				var sOfcCd = ComGetEtcData(sXml,"ofc_cd");
				document.form.cost_ofc_cd.value = sOfcCd;
				
				break;
				
			case IBSEARCH_ASYNC02:	// S.Provider 조회
				formObj.f_cmd.value = SEARCH19;
				formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);

				formObj.vndr_seq.RemoveAll();
	     	  	if(ComGetTotalRows(sXml) > 0 ){
	     	  		var cols = ComCgmXml2ComboString(sXml, "code1", "desc1");
	     	  		ComCgmMakeMultiCombo(formObj.vndr_seq, cols[0], cols[1], 1);
	     	  	}
				break;
				
			case IBSEARCH_ASYNC03:	// Option 조회 
				formObj.f_cmd.value = SEARCH;
				formObj.intg_cd_id.value = COM_CD_TYPE_CD02355;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				
				var sStr = ComGetEtcData(sXml,"comboList");    			
	    		var arrStr = sStr.split("@");
	    			
	    		// combo control, 결과 문자열, Text Index, Code Index
	   			MakeComboObject(formObj.chss_mgst_inv_sts_cd, arrStr, 1, 0);
	   			
	   			break;
	   			
			case IBSEARCH_ASYNC05:	// Local Time 조회
			
				formObj.f_cmd.value = SEARCH20;
				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
				
				var sLocalDate = ComGetEtcData(sXml,"local_date");
				
				document.form.local_date.value = sLocalDate;
				
				break;
				
			case  IBSEARCH_ASYNC06:	// Pay Term 정보를 조회
				
				formObj.f_cmd.value = SEARCH07;
        		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
        		var genPayTermCd = ComGetEtcData(sXml,"gen_pay_term_cd");
        		
        		document.form.gen_pay_term_cd.value = genPayTermCd;
        		
        		break;
        		
        	case IBCLEAR:
        		var idx = 0
        		var sXml2 = document.form2.sXml.value;
        		var arrXml = sXml2.split("|$$|");

        		//Option
        		if ( arrXml[idx] == null ) {return;}
        		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
        	    var arrStr1 = new Array();
        		for ( var i = 0; i < vArrayListData.length; i++) {
        		    vListData = vArrayListData[i];
        		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
        		}
        		MakeComboObject(formObj.chss_mgst_inv_sts_cd, arrStr1, 1, 0);      
        		idx++;        		

		  		break;           	
	    }
	    
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.09.22
     */  
	function validateForm(sheetObj,formObj,sAction){

    	var formObj = document.form;
    	
    	switch(sAction) {
    		case IBSEARCH:
    			if(formObj.cost_ofc_cd.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Office');
    				formObj.cost_ofc_cd.focus();
    				return false;
    			} else if(document.vndr_seq.Text == ''){
    				ComShowCodeMessage('CGM10004','S.Provider');
    				return false;
    			} else if(formObj.cost_yrmon.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Month');
    				formObj.cost_yrmon.focus();
    				return false;
    			}
    			
    			break;
    			
    		case IBSAVE:
    			if(formObj.cost_ofc_cd.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Office');
    				formObj.cost_ofc_cd.focus();
    				return false;
    			} else if(document.vndr_seq.Text == ''){
    				ComShowCodeMessage('CGM10004','S.Provider');
    				return false;
    			} else if(formObj.cost_yrmon.value == ''){
    				ComShowCodeMessage('CGM10004','Cost Month');
    				formObj.cost_yrmon.focus();
    				return false;
    			} else if(formObj.inv_rcv_dt.value == ''){
    				ComShowCodeMessage('CGM10004','RCV Date');
    				formObj.inv_rcv_dt.focus();
    				return false;
    			} else if(formObj.inv_iss_dt.value == ''){
    				ComShowCodeMessage('CGM10004','Issue Date');
    				formObj.inv_iss_dt.focus();
    				return false;
    			}
    			
    			break;
    	}
    			
		return true;
	}
     
    /**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  invStatus String
     * @param  statusCd String
     * @return 없음
     * @author 김창식
     * @version 2009.10.12
     */	
    function doActionBtnEnable (invStatus,  statusCd){
     	 
     	// Invoice Confirm 버튼 활성/비활성
     	if(invStatus == 'S'){
     		ComBtnEnable("btn_Save");
     	} else {
     		ComBtnDisable("btn_Save");
     	}
     	
     	// Cancel 버튼 활성/비활성
     	switch(statusCd){
     		case "C":
     		case "R":
     		case "J":
     		case "E":
     		case "X":
     			ComBtnEnable("btn_Cancel");
     			break;
     			
     		default:
     			ComBtnDisable("btn_Cancel");
     			break;
     	}
    }     
	
	/** 
     * MultiCombo 의 초기화  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.id) {
	        case "vndr_seq":
	            var cnt=0;
	            with(comboObj) {
	            	Code = "";
	            	Text = "";
	            	BackColor = "#CCFFFD";
	            	DropHeight = 100;
	            	MultiSelect = false;
	            	MaxSelect = 1;	    
	            	UseCode = true;
	            	Enable = true;
	            }
	            break;
	            
	        case "chss_mgst_inv_sts_cd":
	            var cnt=0;
	            with(comboObj) {
	            	Code = "";
	            	Text = "";
	            	BackColor = "#FFFFFF";
	            	DropHeight = 100;
	            	MultiSelect = false;
	            	MaxSelect = 1;	    
	            	UseCode = true;
	            	Enable = true;
	            }
	            break;
	    }
	}
    
    /** 
     * Object 의 keypress 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
    function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "ym":
	        case "ymd":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "engup":
	        	if(obj.name=="cost_ofc_cd") ComKeyOnlyAlphabet('uppernum');
	        	else ComKeyOnlyAlphabet('upper');
	        	break;
	    }
	}
    
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */
    function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
    
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */ 
    function obj_deactivate(){
    	var formObj = document.form;
    	
    	obj = event.srcElement;
    	switch(obj.name) {
	    	case "cost_yrmon":	
	    	case "inv_rcv_dt":
	    	case "inv_iss_dt":
	    		ComChkObjValid(event.srcElement);
	    		break;
    	}
	}
     
    /** 
     * Object 의 focusout 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.09.24
     */  
    function obj_focusout(){

    	var formObj = document.form;
	    var invRcvDt = ComReplaceStr(formObj.inv_rcv_dt.value,"-","");
	    var invIssDt = ComReplaceStr(formObj.inv_iss_dt.value,"-","");
	    	
    	obj = event.srcElement;
    	 
    	switch(obj.name) {
    	 	case "inv_rcv_dt":
    	 		
    	 		// Effective Date 와 비교
    	 		if(invIssDt != ''){
	    	     	if(invRcvDt != '' && invRcvDt<invIssDt){
	    	 	    	ComShowCodeMessage('CGM10050');
	    	 	    	formObj.inv_rcv_dt.value = "";
	    	 	    	formObj.inv_eff_dt.value = "";
	    	 	    	formObj.inv_rcv_dt.focus();
	    	 	    	break;
	    	 	    }
    	 		}
    	 		
    	 		// Effective Date 계산
    	 		formObj.inv_eff_dt.value = "";
    	 		if(invRcvDt != ''){
    	     		
    	         	// Local Time 설정
    	         	//doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC05);
    	         	
    	         	var sysMonth = "";
    	         	//if(formObj.local_date.value != ''){
    	         		var sysDate   = new Date();
    	            	var year = sysDate.getFullYear();
    	            	var month = sysDate.getMonth()+1;
    	            	var date = sysDate.getDate();

    	         		//if(formObj.local_date.value == 'undefined'){
    	         		//	sysMonth = ComLpad(year, 4, "0") + ComLpad(month, 2, "0") + '01';
    	         		//} else {
    	         		//	sysMonth = ComTrim(formObj.local_date.value).substring(0,6) + '01';
    	         		//}
    	         		
    	            	sysMonth = ComLpad(year, 4, "0") + ComLpad(month, 2, "0") + '01';
    	            	
    	         		if(invRcvDt < sysMonth){
        	     			formObj.inv_eff_dt.value = sysMonth.substring(0,4) + "-" + sysMonth.substring(4,6) + "-" + "01";
        	     		} else {
        	     			formObj.inv_eff_dt.value = invRcvDt.substring(0,4) + "-" + invRcvDt.substring(4,6) + "-" + invRcvDt.substring(6,8);
        	     		}
    	         	//}
    	     	}
    	     	
    	     	
    	 		break;
    	 		
    	 	case "inv_iss_dt":
    	 		if(invRcvDt != ''){
	    	  	    if(invIssDt != '' && invRcvDt<invIssDt){
	    	  	    	ComShowCodeMessage('CGM10050');
	    	  	    	formObj.inv_iss_dt.value = "";
	    	  	    	formObj.inv_iss_dt.focus();
	    	  	    }
    	 		}
    	 		break;
    	 		
    	 	case "cost_yrmon":
    	 		// S.Provider 조회
    			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);
    	 		break;
    	}
    } 
    
    /**
 	 * Sheet1 의 Change Event 가 발생할 경우 inv_smry_amt 값 설정 <br>
 	 * @author 김창식
 	 * @version 2009.09.28
 	 */ 
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	
    	if(sheetObj.ColSaveName(Col) == 'inv_tax_clt_tp_cd' || sheetObj.ColSaveName(Col) == 'inv_tax_rt'){
    		var iChgSmryAmt = Number(sheetObj.cellValue(Row, "chg_smry_amt"));
    		var iInvTaxRt = Number(sheetObj.cellValue(Row, "inv_tax_rt"));
    		
    		if(sheetObj.cellValue(Row, "inv_tax_clt_tp_cd") == 'VAT'){
    			//chungpa 20100413 VAT 선택시 TAX는 양수만. start
        		var tmpInvTaxRt = Number(sheetObj.cellValue(Row, "inv_tax_rt")); 	 
        		iInvTaxRt = Math.abs(tmpInvTaxRt);							
        		sheetObj.cellValue2(Row,"inv_tax_rt") = iInvTaxRt;					
        		//chungpa 20100413 VAT 선택시 TAX는 양수만. end
        		
    			sheetObj.cellValue2(Row, "inv_smry_amt") = iChgSmryAmt + (iChgSmryAmt * iInvTaxRt / 100);
    		} else if(sheetObj.cellValue(Row, "inv_tax_clt_tp_cd") == 'WHT'){
    			sheetObj.cellValue2(Row, "inv_smry_amt") = iChgSmryAmt + iInvTaxRt;
    		}
    		
    	}
    	
    }
    
    /**
	 * Sheet1 의 CheckBox 를 클릭할 경우 chg_cre_seq 가 동일한 Row 의 체크박스 설정 <br>
	 * @author 김창식
	 * @version 2009.09.28
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
		
		// 체크박스를 click 했을 경우
		if(sheetObj.ColSaveName(Col) == 'del_chk'){
			
			var vndrSeq = sheetObj.cellValue(Row,"vndr_seq"); 
			if(vndrSeq == '132466' || vndrSeq == '105026'){
				vndrSeq = "105621";
			}
			
			// 선택한 행의 chg_cre_seq 와 비교
			for(var i=1; i <= sheetObj.RowCount; i++){
				
				// Xtra 와 FLEXI-VAN 은 동일 벤더로 간주하도록 각 Cell의 Lessor 값을 설정
				var cellVndrSeq = sheetObj.cellValue(i,"vndr_seq");
				if(cellVndrSeq == '132466' || cellVndrSeq == '105026'){
					cellVndrSeq = "105621";
				}
				
				if(vndrSeq == cellVndrSeq){
					if(Row != i){
						sheetObj.cellValue2(i,"del_chk") = sheetObj.cellValue(Row,"del_chk")==0?1:0;
					}
				} else {
					sheetObj.cellValue2(i,"del_chk") = 0;
				}
			}	
			
			// 버튼 활성/비활성
			var invStatus = sheetObj.cellValue(Row,"chss_mgst_inv_sts_cd");
			var statusCd = sheetObj.cellValue(Row,"status_cd");
			doActionBtnEnable(invStatus, statusCd);
		}
	}
    
	/**
	 * Sheet1 의 Double Click 할 경우 상세 정보 조회 <br>
	 * @author 김창식
	 * @version 2009.09.28
	 */ 
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	
    	if(sheetObj.ColSaveName(Col) != 'del_chk'){
	    	document.form.pay_inv_seq.value = sheetObj.cellValue(Row, "pay_inv_seq");
	    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
    	}
    }
	 
	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.28
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
		}
	} 
	 
	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.09.28
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			for(var row = 1; row <= sheetObj.RowCount; row++){
				if(sheetObj.cellValue(row, "chss_mgst_inv_sts_cd") == 'S'){
					sheetObj.CellEditable(row, "rev_vvd") = true; 
					sheetObj.CellEditable(row, "inv_tax_clt_tp_cd") = true; 
					sheetObj.CellEditable(row, "inv_tax_rt") = true; 
				} else {
					sheetObj.CellEditable(row, "rev_vvd") = false; 
					sheetObj.CellEditable(row, "inv_tax_clt_tp_cd") = false; 
					sheetObj.CellEditable(row, "inv_tax_rt") = false; 
				}
			}
		}
	}	 
    
    /**
	 * S.Provier MultiCombo 의  OnChange 이벤트처리 <br>
	 * vndr_seq 따라 Pay Term 을 조회한다.
	 * @param  {object} comboObj	필수	 Sheet Object
	 * @param  {string} Index_Code	필수 String
	 * @param  {string} Text		필수 String
	 * @return 없음
	 * @version 2009.09.28
	 */
    function vndr_seq_OnChange(comboObj, Index_Code, Text){
    	if(comboObj.Text != ''){
    		// Pay Term 조회
    		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC06);
    	}
    }
    
    /** 
     * Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
     * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @return 없음
     * @author 김창식
     * @version 2009.09.22
     */ 
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
     	cmbObj.RemoveAll();
     	cmbObj.InsertItem(0,"ALL","ALL");
     	for (var i = 0; i < arrStr.length;i++ ) {
     		var arrCode = arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
     	}
     	//cmbObj.Index2 = "" ;
    }

	/* 개발자 작업  끝 */