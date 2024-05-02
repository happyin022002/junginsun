/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0096.js
*@FileTitle : Owner's Account Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.05.25 민정호
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
     * @class esm_fms_0096 : esm_fms_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0096() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
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

    var vndrEngNm = {};// vendor.vndr_eng_nm
    
	var rdObjects = new Array();
	var rdCnt = 0;	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

    	try {
    		var csrNo = sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
    		var csrOfcCd = sheetObject.CellValue(sheetObject.SelectRow, "office");
    		var csrStatus = sheetObject.CellValue(sheetObject.SelectRow, "csr_status");
    		
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_retrieve":            		            		
					doActionIBSheet(sheetObject,formObject,IBSEARCH);            		
                break;

				case "btn_new":					
					ComResetAll();
                break;

            	case "btn_oa_entry":
//            		alert("O/A Entry");
            		var s_flg = "";
            		if(csrStatus == "Saved") {
            			s_flg = "E";
            		}else{
            			s_flg = "R";
            		}
            		var param = "s_csr_no=" + csrNo + "&s_flg=" + s_flg;
    				ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1", true, true);
                    break;
                    
            	case "btn_cancel_csr":
//            		alert("Cancel CSR");
            		// Status가 Approved만 가능
            		if(csrStatus === "Approved") {
            			if(csrOfcCd != formObject.ofc_cd.value) {
//                			alert(csrOfcCd + " | " + formObject.ofc_cd.value);
            				ComShowCodeMessage("FMS20020");
                			return false;
                		}
            			var csrNo = sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
            			var param = "s_csr_no=" + csrNo + "&s_flg=C";
            			ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1", true, true);
          			
            		}
            		else{
            			ComShowCodeMessage("FMS20020");
            		}
                    break;
                    
            	case "btn_del_resubmit":
//            		alert("Delete & Resubmit");
            		// Status가 Reject or I/F Error만 가능
            		if((csrStatus === "Reject") || (csrStatus === "I/F Error")) {
//            			alert(csrStatus + " | " + csrOfcCd);
            			if(csrOfcCd != formObject.ofc_cd.value) {
//                			alert(csrOfcCd + " | " + formObject.ofc_cd.value);
            				ComShowCodeMessage("FMS20021");
                			return false;
                		}
            			
            			var csrNo = sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
            			var param = "s_csr_no=" + csrNo + "&s_flg=D";
            			ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1", true, true);
            			
            		}
            		else{
            			ComShowCodeMessage("FMS20021");
            		}
                    break;

            	case "btn_preview":
            		var csr_no = sheetObject.CellValue(sheetObject.SelectRow,"csr_no");
            		var vat_csr_no = sheetObject.CellValue(sheetObject.SelectRow,"vat_csr_no");
            		
            		for(var i=1; i<sheetObject.LastRow+1; i++){
            			if(sheetObject.CellValue(i,"chk") == "1"){            			
							//RD Open            		
		            		formObject.slp_no.value = sheetObject.CellValue(i,"csr_no");            			
							rdOpen(rdObjects[0],formObject);
            			}
            		}					
                    break;

            	case "btn_print":
            		var csr_no = sheetObject.CellValue(sheetObject.SelectRow,"csr_no");
            		var vat_csr_no = sheetObject.CellValue(sheetObject.SelectRow,"vat_csr_no");
            		
            		for(var i=1; i<sheetObject.LastRow+1; i++){            			
            			if(sheetObject.CellValue(i,"chk") == "1"){
							//RD Open            		
		            		formObject.slp_no.value = sheetObject.CellValue(i,"csr_no");            			
							rdOpenPrint(rdObjects[0],formObject);
            			}
            		}					
                    break;                    
                                        
            	case "btn_down_excel":
            		sheetObject.SpeedDown2Excel(-1);            		
                    break;
                    
		        case "btns_search"://S/P Code Button 
		        	//ComOpenPopup('/hanjin/VOP_PSO_0205.do', 500, 440, 'setServiceProviderInfo', '0,0', true, true);
		        	ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 450, '2:spcode|4:spname', '1,0,1,1,1', true);
		        	break;                
		        	
    			case "btn_vslPop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440, "setVslCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0022");
					break;
					
    			case "btn_locPop":
    				ComOpenPopup("COM_ENS_051.do", 720, 430, "setLocCd", "1,0,1,1,1", false, false, null, null, null, "com_ens_051");
					break;		        	
                
    			case "btn_vslCdClr":
     				form.vsl_cd.value = "";
     				form.vsl_eng_nm.value = "";
     				break;
     				
     			case "btn_locCdClr":
     				form.loc_cd.value = "";
     				form.loc_nm.value = "";
     				break;					
     				
    			case "btns_calendar_from":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.pre_fr, 'yyyy-MM-dd');
                    break;
                    
    			case "btns_calendar_to":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.pre_to, 'yyyy-MM-dd');
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
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

	    obj = event.srcElement;

	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
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
        
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;        
        //html컨트롤 이벤트초기화
        initControl();
		//RD
		initRdConfig(rdObjects[0]);
    }
    
    
    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     * @param comboObj 
     * @param comboIndex Number
     */
    function initCombo(comboObj, comboNo) {
    	var formObject = document.form

    	switch (comboNo) {
    		case 1: 
    			with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left");        
    				SetColWidth("30");
    				DropHeight = 160;
    				ValidChar(2,0);//영문대문자만 입력가능
    			}
    			if (ComTrim(gOffice) != ""){
    				var comboItems = (" |"+gOffice).split("|");
    				addComboItem(comboObj, comboItems);
    			}
    			break; 
    			
    		case 2: 
    			with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left");        
    				SetColWidth("30");
    				DropHeight = 160;
    				ValidChar(2,0);//영문대문자만 입력가능
    			}

    			comboObj.InsertItem(0, "", "");
    			comboObj.InsertItem(1, "Saved", "SV");
    			comboObj.InsertItem(2, "Submitted", "SB");
    			comboObj.InsertItem(3, "Approved", "AP");
    			comboObj.InsertItem(4, "Reject", "RJ");
    			comboObj.InsertItem(5, "I/F Error", "IE");
    			comboObj.InsertItem(6, "Cancel", "CN");    			    			
    			break;		
    	}
    }    
    	
	/**
     * 페이지에 있는 RD Object를 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
     * @param {rdObject} rdObject    RD Object
     **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.style.height = 0;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, 'spcode');
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); 
    	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);
    	axon_event.addListenerForm  ('change', 'obj_change', form);
    	axon_event.addListener		('keydown', 'obj_keydown', 'form');
    	axon_event.addListenerForm  ('click', 'obj_click', form);
    	axon_event.addListenerForm  ('paste', 'obj_paste', form);
    	axon_event.addListenerForm  ('drop', 'obj_drop', form);
    	axon_event.addListenerForm  ('blur', 'obj_blur', form);
    	
        axon_event.addListener  ('keypress', 'engnum_keypress', 'loc_cd'); //loc_cd는 engnum_press로
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'); // Vessel Code 입력 시 영문 대문자/숫자만 입력하기
    	
    }

    /**
     * EnterKey처리 
     * @return
     */
    function obj_keydown(){
    	if (event.keyCode == 13) {
    		g_isEnterKey = true;
    	}
        ComKeyEnter();
    }
    function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}
    function obj_activate() {
    	ComClearSeparator(event.srcElement);
	}
    
    /**
     * change 이벤트 함수
     * @return
     */
    function obj_change(){
    	
  		var formObject = document.form;
  		try {
  			/*
  			var srcName = window.event.srcElement.getAttribute("name");
  			
  	        switch(srcName) {
  	            case "spcode"://해당 vndr_seq 가 user 의 default Setting 에 있는지 확인
 	  	          	var dspNm = eval("vndrEngNm._"+formObject.spcode.value);
 	  	          	 	  	          	
	  	          	if(typeof dspNm === "undefined"){
	  	          		ComShowMessage("There is no provider code in Default Setting.");
	  	          		formObject.spcode.value = "";
	  	          		formObject.spname.value = "";
	  	          		ComSetFocus(formObject.spcode);
	  	          	} else{		  	          		
	  	          		formObject.spname.value = dspNm;
	  	          		formObject.spdeleted.value = eval("vndrEngNm._"+formObject.spcode.value+"_DEL");
	  	          		checkServiceProvider();	  	          		
	  	          	}
	
  	          	break;  	          	  	           	          	
  	        }*/ // end switch isRmkModFlg
  	        
  	        
  	      	if((event.srcElement.name == "vsl_cd")) {
  	    		sheetObjects[0].RemoveAll();
  	    		
  	    		form.vsl_eng_nm.value = "";
  	    		doActionIBSheet2(sheetObjects[0],document.form,IBSEARCH,"vsl_cd");
  	    	} else if((event.srcElement.name == "loc_cd")) {
  	    		sheetObjects[0].RemoveAll();
  	    		
  	    		form.loc_nm.value = "";
  	    		doActionIBSheet2(sheetObjects[0],document.form,IBSEARCH,"loc_cd");
  	     	} else if((event.srcElement.name == "spcode")) {
  	     		if(formObject.spcode.value.trim() == ""){
  	    			return;
  	    		}
  	    		updateDueDt( formObject.spcode.value );
  	     	}
  	        
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowCodeMessage('VSK00011');
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}  	          	
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
    function engnum_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    }     
    
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 410;
                    
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

					var HeadTitle = "||Seq|Office|CSR No.|Supplier|Currency|Amount|Description|Internal Memo|Creation Date|User ID|User Name|CSR Status|I/F Error Desc|vndr_seq|vat_csr_no|ASA No.";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        			InitDataProperty(0, cnt++ , dtCheckBox    ,   30, 		daCenter, 	true, 	"chk");                    
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");					
                    InitDataProperty(0, cnt++ , dtSeq,      	30,   		daCenter,  	true,   "seq",    				false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	80,   		daCenter,  	true,   "office",    			false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	150,   	daCenter,  	true,   "csr_no",    			false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	180,   		daLeft,  	true,   "supplier",    		false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	80,   		daCenter,  	true,   "currency",    		false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	80,   		daRight,  		true,   "amount",    		false,         "",      dfNullFloat, 	2,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	180,   	daLeft,  		true,   "description",    	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	180,   	daLeft,  		true,   "internal_meno",  	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "creation_dt",    	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	80,   		daCenter,  	true,   "user_id",    			false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	120,   	daCenter,  	true,   "user_name",    	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	80,   		daCenter,  	true,   "csr_status",    	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      	180,   	daLeft,  		true,   "if_err_desc",    	false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,      	80, 	  	daLeft,  		true,   "vndr_seq",    		false,         "",      dfNone, 	0,     false,      false);
                    InitDataProperty(0, cnt++ , dtHidden,      	150,   	daLeft,  		true,   "vat_csr_no",    	false,         "",      dfNone, 	0,     false,      false);         
                    InitDataProperty(0, cnt++ , dtData,      	120,   	daCenter,  	true,   "asa_no",    	false,         "",      dfNone, 	0,     false,      false);
					
               }
                break;
        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
         	case IBSEARCH:      //조회
	    		if(validateForm(sheetObj,formObj,sAction)) {         		
			 		formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_FMS_0096GS.do", FormQueryString(formObj));
	    		}
                break;
        }
    }

    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet2(sheetObj,formObj,sAction,objNm,row) {    
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      // 조회
        		if(objNm == "vsl_cd") {
        			formObj.f_cmd.value = SEARCH01;
    	    		
    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");

    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vsl_eng_nm.value = vslEngNm;
    	   				form.btn_vslCdClr.checked = true;
    				} else {
    					form.btn_vslCdClr.checked = false;
    					formObj.vsl_cd.value = "";
    					// 존재하지 않는 Vessel Code입니다
    					ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
    	   			
        		} else if(objNm == "loc_cd") {
        			formObj.f_cmd.value = SEARCH03;

    	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj));
    	   			var locNm = ComGetEtcData(sXml, "locNm");
    	   			
    	   			if(typeof locNm != "undefined" && locNm != "" ) {
    	   				formObj.loc_nm.value = locNm;
    	   				form.btn_locCdClr.checked = true;
    				} else {
    					form.btn_locCdClr.checked = false;
    					formObj.loc_cd.value = "";
    					// 존재하지 않는 Location Code입니다
    					ComAlertFocus(formObj.loc_cd, ComGetMsg("FMS00006", "KK Code"));
    					return;
    				}    	   			
        		}
        		break;    			
        }
    }

    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;
        return true;
    }
    
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj, comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {			
			comboObj.InsertItem(i, comboItems[i], comboItems[i]);
		}   		
	}	    
	
    /**
     * S/P Code의 Input Text에 Popup에서 설정한 S/P Code 및 S/P Name 를 셋팅한다.
     * @param aryPopupData
     * @param row
     * @param col
     * @param sheetIdx
     * @return
     */
    function setServiceProviderInfo(aryPopupData, row, col, sheetIdx) {
    	
		var formObj = document.form;
		formObj.spcode.value = aryPopupData[0][1];
		formObj.spname.value = aryPopupData[0][2];
		formObj.spdeleted.value = aryPopupData[0][3];
		
		checkServiceProvider();
		
		//Focus를 Inv.NO로 이동 
		ComSetFocus(formObj.inv_no);
     }	
    
    /*
     * S/P 삭제여부 검사
     */
    function checkServiceProvider(){
    	var formObj = document.form;
    	
		// 지워진 S/P인 경우 Invoice 생성 할 수 없다.
		if("Y"==formObj.spdeleted.value){
			// PSO00036 : Please input {?msg1}.
			ComShowCodeMessage("PSO00036", "the correct S/P Code.\n'[" + formObj.spcode.value + "]"+ formObj.spname.value + "' is DELETED");
			return false;
		}
		
		return true; // Add 2010.12.15
    }    
          
    /**
	 * Vessel Code 팝업창에서 선택한 Vessel정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];
		form.btn_vslCdClr.checked = true;
	}
	
    /**
	 * Location Code 팝업창에서 선택한 Location정보를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setLocCd(aryPopupData) {
		form.loc_cd.value = aryPopupData[0][3];
		form.loc_nm.value = aryPopupData[0][4];
		form.btn_locCdClr.checked = true;
	}	
	
    /**
     * RD 출력하기 <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     **/
    function rdOpen(rdObject, formObj){    	        	   	
		if(sheetObjects[0].RowCount == 0) {
			ComShowCodeMessage("FMS00015");
			return;
		}
		
		if(form.slp_no.value == "") {
			ComShowCodeMessage("FMS00015");
			return;
		}
		
		var csr_no = "";		
		var csr_type = "";
				
		csr_no = formObj.slp_no.value;
		
		if(formObj.slp_no.value.substring(0,2) == "07") {
			csr_type = "AP";
		} else {
			csr_type = "AR";
		}        
                
		var rdParam = "/rv frm1_csr_no["+csr_no+"] frm1_csr_type["+csr_type+"]";
     	var strPath   = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_032.mrd";
                           	
        formObj.com_mrdPath.value = strPath;
        formObj.com_mrdArguments.value = rdParam;
        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');    	
               
/*    	
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		if(form.slp_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		formObj.csr_no.value = formObj.slp_no.value;
  		
  		if(formObj.slp_no.value.substring(0,2) == "07") {
  			formObj.csr_type.value = "AP";
  		} else {
  			formObj.csr_type.value = "AR";
  		}
  		  		
 		var Rdviewer = rdObject ;
 	
 		rdParam = RD_FormQueryString(formObj,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_032.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
// 		Rdviewer.CMPrint (); //인쇄 시작 		
*/
 	}	
    
    
    /**
     * RD 출력하기 <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     **/
    function rdOpenPrint(rdObject, formObj){    	        	   	               
    	
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		if(form.slp_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
  		
  		formObj.csr_no.value = formObj.slp_no.value;
  		
  		if(formObj.slp_no.value.substring(0,2) == "07") {
  			formObj.csr_type.value = "AP";
  		} else {
  			formObj.csr_type.value = "AR";
  		}
  		  		
 		var Rdviewer = rdObject ;
 	
 		rdParam = RD_FormQueryString(formObj,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_032.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작 		
 	}	    
    
    
    
	    
	function sheet1_OnDblClick(sheetObj,Row,Col,Value){
		var formObject = document.form;
		
		var csrNo = sheetObj.CellValue(sheetObj.SelectRow, "csr_no");
		var csrOfcCd = sheetObj.CellValue(sheetObj.SelectRow, "office");
		var csrStatus = sheetObj.CellValue(sheetObj.SelectRow, "csr_status");
		
		var s_flg = "";
		if(csrStatus == "Saved") {
			s_flg = "E";
		}else{
			s_flg = "R";
		}
		
		var param = "s_csr_no=" + csrNo + "&s_flg=" + s_flg;
		ComOpenPopup("ESM_FMS_0095.do?popup=yes&" + param, 1024, 590, "", "0,0,1,1,1,1", true, true);
	}
	
	function updateDueDt( vndrSeq ) {
		var param = "f_cmd=" + SEARCH02 + "&s_value=" + vndrSeq;
		
		var sXml = sheetObjects[0].GetSaveXml("FMS_COMGS.do", param);
		var payTerm = ComGetEtcData(sXml, "pay_term");
		
		if(typeof payTerm != "undefined" && payTerm != "") {
			var tmpArr = payTerm.split(":");
			
			document.form.spname.value = tmpArr[1];

		}else{
			document.form.spcode.value = "";
			document.form.spname.value = "";
		}
	}
	/* 개발자 작업  끝 */ 