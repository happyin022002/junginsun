/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0067.js
*@FileTitle : Invoice Detail Inquiry by Date & Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.07.16 한동훈
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
     * @class FNS_INV_0067 : FNS_INV_0067 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0067() {
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
	 //IBMultiCombo
	 var comboObjects = new Array();
	 var combo1 = null;
	 var comboCnt = 0;

	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.10.19
	 */
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
                	 ComResetAll();
                	 formObject.rev_src_cd.RemoveAll();              		
                	 //formObject.rev_src_cd.InsertItem(0, "ALL", "ALL");
                	 //formObject.rev_src_cd.CheckCode("") = true;
                	 for(var k=0; k<comboObjects.length; k++){
              			initCombo(comboObjects[k],k+1);
              		}
                	//날짜 세팅
      				//dateSet();
      				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
      				ComSetFocus(document.form.date_option);
                     break;

                 case "btn_DownExcel":
                	 //sheetObjects[0].Down2Excel(1);
                	 sheetObjects[0].SpeedDown2Excel(1);
                     break;

                 case "btn_Print":
 					//alert(srcName);
                     break;
                 
                 case "btns_calendar1": //달력버튼
						var cal = new ComCalendar();
						cal.setDisplayType('date');
		             	cal.select(formObject.from_date, 'yyyy-MM-dd');
 	                break;
 	                
                 case "btns_calendar2": //달력버튼
						var cal = new ComCalendar();
						cal.setDisplayType('date');
		             	cal.select(formObject.to_date, 'yyyy-MM-dd');
  	                break;
 	                                
                case "btns_cust1": //CUST 조회버튼
 					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
 					var v_act_cust_seq = formObject.act_cust_seq.value;
 					var classId = "FNS_INV_0013";
 					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
 			
 					ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 650, 'getFNS_INV_0013', '1,0,1,1,1', true);
 				break;
 				
 				case "btns_cust2": //CUST 조회버튼
 					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
 					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
 					
 					var classId = "FNS_INV_0086";
 					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
 			
 					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
 				break;
 				
                case "btns_port": //port 조회버튼
 					var loc_cd_val = formObject.port.value;
 					var sys_code = "ENIS";
 	            
 					var loc_port_ind_val = "1";
 	            
 					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
 					var classId = "COM_ENS_051";
 					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
 	 			  
 					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 450, 'getCOM_ENS_051_1', dispaly);
 				break;
 				
 				case "btns_SCP": //SCP 조회버튼
 					var v_svc_scp_cd = formObject.scope.value;
 					var classId = "COM_ENS_0L1";
 					var param = '?svc_scp_cd='+v_svc_scp_cd+'&classId='+classId;
 			
 					ComOpenPopup('/hanjin/COM_ENS_0L1.do' + param, 500, 450, 'getCOM_ENS_0L1_1', '1,0,1,1,1', true);
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
      * IBSheet Object를 sheetObjects 배열로 등록 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj IBSheet Object
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /** 
 	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 	 * 배열은 소스 상단에 정의
 	 * </pre>
 	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
 	 * @return 없음
 	 * @see #
 	 * @author 박정진
 	 * @version 2009.05.04
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	}

     /** 
      * body 태그의 onLoad 이벤트핸들러 구현 <br>
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function loadPage() {
    	 
    	// combo
 		combo1 = comboObjects[1];
 		comboCnt = comboObjects.length;
    	 
        var formObj = document.form;
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
 		
 		for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }        
         
       //IBMultiCombo초기화
 		for(var k=0; k<comboObjects.length; k++){
 			initCombo(comboObjects[k],k+1);
 		}
     }

     /** 
      * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
 	function initControl2() {
 		var formObj = document.form;
 		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
 		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
 		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
 		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
 		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
 		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
 	}
     
 	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
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
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}
 	
 	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "rev_src_cd":
				with (comboObj) {
					InsertItem(0, "ALL",    "");

		    		MultiSelect = true;
		    		UseCode = true;

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;		    		
		            CheckCode("") = true;
				}
			break;
			
		}
  	}
 	
 	/** 
     * onLoad시 날짜세팅 구현 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
     function dateSet(){
    	//날짜 세팅
		var ret = ComGetNowInfo("ymd" )
		document.form.from_date.value = ComGetDateAdd(ComGetDateAdd(ret, "M", "-3", "-"), "D", "1", "-");
		document.form.to_date.value = ret;
     }
     
     /** 
      * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function obj_activate() {
    	 //마스크 구분자 없애기
    	 ComClearSeparator (event.srcElement);
     }

     /** 
      * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br> 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "from_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":	        	
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					var valueCustSeq = formObject.act_cust_seq.value;
					formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
				else {
					formObject.act_cust_cnt_cd.value = '';
					formObject.act_cust_seq.value = '';
					formObject.cust_nm.value = '';
				}
	        break;
			case "vvd":
				
			break;	
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
     * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "to_date":
				//조회기간 입력값 체크(3달)
				var nextDate = ComGetDateAdd(formObject.from_date.value, "M", 3);
				
				if (ComReplaceStr(formObject.to_date.value,"-","") >= ComReplaceStr(nextDate,"-","")) {	
					ComShowCodeMessage("INV00043");
					formObject.to_date.focus();
					return false;
				}		
			break;
			/*
			case "act_cust_seq":
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
			break;
			*/
	    }
	}

	/** 
     * 업무 자바스크립트 KeyUp 이벤트 처리 <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;			
			case "act_cust_cnt_cd":
				var actCustCntCd = ComReplaceStr(event.srcElement.value,"-","");
				
				if (actCustCntCd.length == 2) {
					formObject.act_cust_seq.focus();
				}
	 		break;
	 	}
	}
     
	/** 
     * Sheet 기본 설정 및 초기화 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {IBSheet} sheetObj : 시트오브젝트
     * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
     function initSheet(sheetObj,sheetNo, dp_prcs_knt) {

         var cnt = 0;
 				var sheetID = sheetObj.id;
         switch(sheetID) {

              case "sheet1":
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
                     
                     //헤더명 변경
                     var dateOption = document.form.date_option.options[document.form.date_option.selectedIndex].text; 
                    
                     if(document.form.office2.text == "CMBSC"){
                    	 if (document.form.rev_tp_cd.value == "M"){
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Invoice Type|Description|VAT No.|SVAT No.|Charge Remark(s)|User ID|User Name";
                    	 } else {
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Invoice Type|Description|VAT No.|SVAT No.";	 
                    	 }
                     } else if(document.form.office2.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
                    	 if (document.form.rev_tp_cd.value == "M"){
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Proforma Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Description|GSTN No|State Code|State Name|PAN No|SEZ(Y/N)|SAC Code|CGST|SGST|UGST|IGST|Charge Remark(s)|User ID|User Name";
                    	 } else {
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Proforma Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Description|GSTN No|State Code|State Name|PAN No|SEZ(Y/N)|SAC Code|CGST|SGST|UGST|IGST";	 
                    	 }  
                     } else {
                    	 if (document.form.rev_tp_cd.value == "M"){
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Description|Charge Remark(s)|User ID|User Name";
                    	 } else {
                    		 var HeadTitle1 = "|Seq|Office|"+dateOption+"|Bound|VVD|B/L No|Invoice No.|Auto|Cust Code|Cust Name|I/F No|Type|CHG|Cur|TAXABLE|Amount|Ex. Rate|LCL Amount|Description";	 
                    	 }                   	 
                     }
                     
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var rowCnt = 0;

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,		00,		daCenter,		false,		"hdnStatus");
                     InitDataProperty(rowCnt, 	cnt++ , dtDataSeq,    		40,    	daCenter,   	true,    	"SEQ",     				false,    	"",    dfNone,				0,	   false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		true,		"ar_ofc_cd",			false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		true,		"good_date",			false,		"",		dfDateYmd,			0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	50,		daCenter,		false,		"io_bnd_cd",			false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		false,		"vvd",					false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		false,		"bl_src_no",			false,		"",		dfNone,				0,		false,		false);
                   	 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	120,		daCenter,		false,		"inv_no",				false,		"",		dfNone,				0,		false,		false);
                   	 
                   	 if(document.form.office2.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
                   		 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	125,		daCenter,		false,		"pro_inv_no",				false,		"",		dfNone,				0,		false,		false);
                   	 }
                   	
                   	 InitDataProperty(rowCnt, 	cnt++, 	dtData,    			65,		daCenter,  		false,	    "auto_inv_iss_flg",  	false,    	"",	   	dfNone,     		0,     	false,      false);
                   	 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		false,		"act_cust_seq",			false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daLeft,			false,		"cust_nm",				false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		false,		"ar_if_no",				false,		"",		dfNone,				0,		false,		false);                     
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		false,		"rev_tp_cd",			false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		false,		"chg_cd",				false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		false,		"curr_cd",				false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		false,		"tva_flg",				false,		"",		dfNone,				0,		false,		false);
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daRight,		false,		"chg_amt",				false,		"",		dfNullFloat,		2,		false,		false);                     
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daRight,		false,		"inv_xch_rt",			false,		"",		dfNullFloat,		6,		false,		false);
              
                     if(dp_prcs_knt != undefined){
	                     if(dp_prcs_knt == "0"){
	                    	 InitDataProperty(rowCnt,	cnt++,	dtAutoSum,    		90,		daRight,		false,		"inv_locl_amt",			false,		"",		dfNullInteger,				0,		false,		false);
	                     }else{
	                    	 InitDataProperty(rowCnt,	cnt++,	dtAutoSum, 		 	90,		daRight,		false,		"inv_locl_amt",			false,		"",		dfNullFloat,		dp_prcs_knt,		false,		false);
	                     }
                     }
                     
                     if(document.form.office2.text == "CMBSC"){
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	70,		daCenter,		false,		"inv_type",				false,		"",		dfNone,				0,		false,		false);
                     }   
                	 InitDataProperty(rowCnt,	cnt++,	dtData,    		   200,		daLeft,			false,		   "inv_rmk",					false,	"",	dfNone,				0,		false,		false);
                     
                	 if(document.form.office2.text == "CMBSC"){
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	130,		daCenter,		false,		"cust_rgst_no",				false,		"",		dfNone,				0,		false,		false);
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	130,		daCenter,		false,		"spnd_vat_rgst_no",				false,		"",		dfNone,				0,		false,		false);
                     } 
                	 
                	 //2017.08.01 인도 GST 세법 변경 관련 보완
                	 if(document.form.office2.text == "BOMSC"){
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    		   120,		daCenter,  		false,	    "ida_gst_rgst_no",  		false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    			80,		daCenter,  		false,	    "ida_ste_cd",  				false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    		   100,		daLeft,  		false,	    "ida_ste_nm",  				false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    			90,		daCenter,  		false,	    "ida_pan_no",  				false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    			65,		daCenter,  		false,	    "ida_spcl_ecn_zn_ut_flg",  	false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++, 	dtData,    			65,		daCenter,  		false,	    "ida_sac_cd",  				false,    	"",	   	dfNone,     		0,     	false,      false);
                		 InitDataProperty(rowCnt, 	cnt++ , dtData,    			80,    	daRight,   		false,   	"ida_cgst_amt",	  			false,    	"",    	dfNullFloat, 		2,     	false,      false);
 						 InitDataProperty(rowCnt, 	cnt++ , dtData,    			80,    	daRight,   		false,   	"ida_sgst_amt",	  			false,    	"",    	dfNullFloat, 		2,     	false,      false);
 						 InitDataProperty(rowCnt, 	cnt++ , dtData,    			80,    	daRight,   		false,   	"ida_ugst_amt",	  			false,    	"",    	dfNullFloat, 		2,     	false,      false);
 						 InitDataProperty(rowCnt, 	cnt++ , dtData,    			80,    	daRight,   		false,   	"ida_igst_amt",	  			false,    	"",    	dfNullFloat, 		2,     	false,      false);
                	 }
                	 
                     if (document.form.rev_tp_cd.value == "M"){
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		   200,		daLeft,			false,		"chg_rmk",					false,		"",		dfNone,				0,		false,		false);
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		   60,		daCenter,		false,		"cre_usr_id",				false,		"",		dfNone,				0,		false,		false);
                    	 InitDataProperty(rowCnt,	cnt++,	dtData,    		   100,		daLeft,			false,		"usr_nm",					false,		"",		dfNone,				0,		false,		false);
                     }              

 				}
                 break;

              case "sheet2":
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
                     InitRowInfo(1, 1, 3, 100);

                     var HeadTitle1 = "|Total|Currency|Amount|LCL Currency|LCL Amount";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     var rowCnt = 0;

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,		00,		daCenter,		false,		"hdnStatus");
                     InitDataProperty(rowCnt,	cnt++,	dtData,    		 	200,	daCenter,		false,		"Total",				false,		"",		dfNone,					0,		false,		false);
 					 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	170,	daCenter,		false,		"curr_cd",				false,		"",		dfNone,					0,		false,		false);
 					 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	170,	daRight,		false,		"chg_amt",			false,		"",		dfNullFloat,		2,		false,		false);
 					 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	170,	daCenter,		false,		"locl_curr_cd",		false,		"",		dfNone,					0,		false,		false);

 					 InitDataProperty(rowCnt,	cnt++,	dtData,    		 	100,	daRight,		false,		"chg_locl_amt",		false,		"",		dfNullFloat,		dp_prcs_knt,		false,		false);
 										
 										
 										//CountPosition = 0;
 								}
                 break;
         }
     }

     /** 
      * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트  
      * @param  {object} formObj : 폼 오브젝트
      * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
      * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
      * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
      * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH_ASYNC10: //SalesCustomer Office 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0067GS.do", FormQueryString(formObj));
				
				//loc_chg_offce 세팅
				var sStrLocOfc = ComGetEtcData(sXml,"locl_chg_ofc");
				formObj.locl_chg_ofc.value = sStrLocOfc;
				
				//office 코드 세팅
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				MakeComboObject_OfcCd(formObj.office2, arrStr, "Y");
				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
				
				formObj.login_rhq_cd.value = arrStr2[0];
				formObj.office2.text = ar_ofc_cd;
				formObj.office2.DropHeight = 190;
		        
		        //chg code 세팅
				var sStrChg = ComGetEtcData(sXml,"chg_cd");
				var arrStrChg = sStrChg.split("|");	
				MakeComboObject2(formObj.chg_cd, arrStrChg);
				formObj.chg_cd.DropHeight = 200;
				//formObj.chg_cd.InsertItem(0, "ALL", "");
				//formObj.chg_cd.text = "ALL"							
		        
				break;
           case IBSEARCH:      //조회
        	   	if(validateForm(sheetObj,formObj,sAction) == false) return false;  			
				if (sheetObj.id == "sheet1") {			
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.office.value = formObj.office2.Text;
					formObj.f_cmd.value = SEARCH;					
					//sheetObj.DoSearch("FNS_INV_0067GS.do", FormQueryString(formObj));
					var sXml = sheetObj.GetSearchXml("FNS_INV_0067GS.do" , FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");

					// 소수점 자리수 설정
					var dp_prcs_knt = ComGetEtcData(arrXml[0],"dp_prcs_knt");

					initSheet(sheetObjects[0],1,dp_prcs_knt);
					//initSheet(sheetObjects[1],1,dp_prcs_knt, locl_curr_cd);
					
					//sheetObjects[0].MessageText("SubSum") = "Cur Total";
					//sheetObjects[0].MessageText("Sum") = "Grand Total";
					
					sheetObjects[0].LoadSearchXml(arrXml[0], false);
					sheetObjects[1].LoadSearchXml(arrXml[1], false);	

					sheetObjects[0].CellValue(sheetObjects[0].LastRow,1) = "Grand Total";
					sheetObjects[0].CellValue(sheetObjects[0].LastRow,2) = "Grand Total";
					sheetObjects[0].SetMergeCell (sheetObjects[0].LastRow, 1, 1, 2);
					/*
					for (var i=1; i<=sheetObj.RowCount; i++) {
						if(sheetObj.CellValue(i,"curr_cd") == "KRW"){
							sheetObjects[0].InitCellProperty(i,"chg_amt",dtData, daRight, "chg_amt", "", dfNullInteger);
							sheetObjects[0].InitCellProperty(i,"inv_locl_amt",dtData, daRight, "inv_locl_amt", "", dfNullInteger);
						}else{
							sheetObjects[0].InitCellProperty(i,"inv_locl_amt",dtData, daRight, "inv_locl_amt", "", dfNullFloat, dp_prcs_knt);
						}
					}
					*/
				}
                 break;
           case IBSEARCH_ASYNC20: // customer name 조회
				
				formObj.f_cmd.value = SEARCH03;

				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.act_cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.act_cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.act_cust_seq, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.act_cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
			break;
           case IBSAVE:        //저장
           		if(validateForm(sheetObj,formObj,sAction))

                   alert (" Save .. ");

                 break;

           case IBINSERT:      // 입력

                 break;
         }
     }
     	  	
     /** 
      * OnLoadFinish 이벤트 발생시 호출되는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {IBSheet} sheetObj : 시트오브젝트        
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
 	function sheet1_OnLoadFinish(sheetObj){
 		var formObj = document.form;
 		
// 		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
 		ComSetFocus(document.form.date_option);
 		initControl2();
 	}
 	
 	/** 
     * 업무 자바스크립트 OnChange 이벤트 처리 <br>
     * date_option 선택에 따라  header  변경
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} comboObj : 폼 오브젝트
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
  	function dateChange(comboObj){
  		var dateName = comboObj.options[comboObj.selectedIndex].text;
  		initSheet(sheetObjects[0],1);	
 		
		var formObj = document.form;
		if (dateName == "POR ETD Date") {
			formObj.chg_cd.Text = "GCF";
			formObj.chg_cd.Enable = false;
		}
		else {
			formObj.chg_cd.Text = "ALL";
			formObj.chg_cd.Enable = true;
		}
  		
  	}
 	
 	/** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {object} formObj : 폼 오브젝트
     * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
     * @return true, false
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
			case IBSEARCH: //조회
				if (ComIsNull(formObj.from_date) && ComIsNull(formObj.vvd)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.from_date);
					return false;
				}else if (ComIsNull(formObj.to_date) && ComIsNull(formObj.vvd)){
					ComShowCodeMessage('INV00004');
					ComSetFocus(form.to_date);
					return false;
				}				
				if (formObj.office2.text == "") {
	         		ComShowCodeMessage('INV00004');
    				ComSetFocus(form.office2);
	 				return false;
	 			}
				if(ComIsNull(formObj.vvd)){
					var nextDate = ComGetDateAdd(formObj.from_date.value, "M", 3);				
					 if (formObj.to_date.value >= nextDate) {
						 ComShowCodeMessage("INV00043");
						 formObj.to_date.focus();
						 return false;
					 }
				}
				if(formObj.office2.text == "ALL"){
					if(formObj.chg_cd.text == "ALL" && ComIsNull(formObj.vvd) && ComIsNull(formObj.port) && ComIsNull(formObj.scope) && ComIsNull(formObj.act_cust_cnt_cd) && ComIsNull(formObj.act_cust_seq) && formObj.rev_tp_cd.value == "" ){ 
						ComShowCodeMessage("INV00173");
						return false;
					}					
				}

			break;
    	 }
         return true;
     }
     
     /** 
      * Rev Type 변경에 따라 Rev Source 값 세팅 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} thisObj : Rev Type 폼 오브젝트
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doChange(thisObj){
 		var val = thisObj.options[thisObj.selectedIndex].value;
 		var targetE = document.form.rev_src_cd;
 		targetE.RemoveAll();

 		targetE.InsertItem(0, "ALL",    	"");
 		if(val == 'B'){
 			targetE.InsertItem(1, "BBL",    "BL");
 			targetE.InsertItem(2, "BCS",    "CS");
 			targetE.InsertItem(3, "BCC",    "CC"); 		
 		}else if(val == 'C'){
 			targetE.InsertItem(1, "CCA",    "CA");
 			targetE.InsertItem(2, "CCC",    "CC");
 		}else if(val == 'M'){
 			targetE.InsertItem(1, "MIV",    "IV");
 			targetE.InsertItem(2, "MIC",    "IC");
 			targetE.InsertItem(3, "MCT",    "CT");
 			targetE.InsertItem(4, "MOC",    "OC");
 			targetE.InsertItem(5, "MEQ",    "EQ");
 			targetE.InsertItem(6, "MTS",    "TS");
 			targetE.InsertItem(7, "MDM",    "DM");
 			targetE.InsertItem(8, "MDT",    "DT");
 			targetE.InsertItem(9, "MRD",    "RD");
 			targetE.InsertItem(10, "MTH",    "TH");
 			targetE.InsertItem(11, "MTP",    "TP");
 			targetE.InsertItem(12, "MTM",    "TM");
 			targetE.InsertItem(13, "MTN",    "TN");
 			targetE.InsertItem(14, "MWC",    "WC");
 			targetE.InsertItem(15, "MLS",    "LS");
 			targetE.InsertItem(16, "MDO",    "DO");
 			targetE.InsertItem(17, "MCD",    "CD");
 			targetE.InsertItem(18, "MDF",    "DF");
 			
 		}
 		targetE.text = "ALL";
 	}
     
     /** 
      * Rev Type 변경에 따라 Rev Source 값 세팅 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} thisObj : Rev Type 폼 오브젝트
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function doChange2(thisObj){
 		var val = thisObj.options[thisObj.selectedIndex].value;
 		var targetE = document.form.rev_src_cd;

 		removeCombo(targetE);
 		
 	    if(val == 'B'){
 	        addOption('BBL','BL', targetE);
 	        addOption('BCS','CS', targetE);
 	        addOption('BCC','CC', targetE);
 	    }
 	    else if(val == 'C'){
 	        addOption('CCA', 'CA', targetE);
 	        addOption('CCC', 'CC', targetE);
 	    }
 	    else if(val == 'M'){
 	    	addOption('MIV', 'IV', targetE);
 	        addOption('MIC', 'IC', targetE);
 	        addOption('MCT', 'CT', targetE);
 	        addOption('MOC', 'OC', targetE);
 	        addOption('MEQ', 'EQ', targetE);
 	        addOption('MTS', 'TS', targetE);
 	       	addOption('MDM', 'DM', targetE);
 	      	addOption('MDT', 'DT', targetE);
 	      	addOption('MRD', 'RD', targetE);
 	      	addOption('MTH', 'TH', targetE);
 	      	addOption('MTP', 'TP', targetE);
 	      	addOption('MTM', 'TM', targetE);
 	      	addOption('MTN', 'TN', targetE);
 	      	addOption('MWC', 'WC', targetE);
 	      	addOption('MLS', 'LS', targetE);
 	      	addOption('MDO', 'DO', targetE);
 	      	addOption('MDF', 'DF', targetE);
 	    }
 	}
     
     /** 
      * 해당 콤보박스에 값을 세팅함. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {String} text : 콤보박스의 text 값
      * @param  {String} value : 콤보박스의 value 값
      * @param  {object} e : 콤보박스의 오브젝트 값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function addOption(text,value, e){
 	    var o = new Option(text,value);
 	    try{
 	        e.add(o);
 	    }catch(ee){
 	        e.add(o, null);
 	    }
 	}
     
     /** 
      * 해당 콤보박스에 값을 모두 삭제함. <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {object} e : 콤보박스의 오브젝트 값
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function removeCombo(e){
 	    for(var i = 0, limit = e.options.length; i < limit - 1; ++i){
 	        e.remove(1);
 	    }
 	}
     
     /** 
      * 팝업창(COM_ENS_051)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
     function getCOM_ENS_051_1(rowArray) {
 		var colArray = rowArray[0];
 		document.all.port.value = colArray[3];
     }

 	
     /** 
      * 팝업창(COM_ENS_0L1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
      * @return 없음
      * @see #
      * @author 한동훈
      * @version 2009.10.19
      */
 	function getCOM_ENS_0L1_1(rowArray) {
 		var colArray = rowArray[0];	
 		document.all.scope.value = colArray[3];
 	}     
 	
 	/** 
     * 팝업창(FNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function getFNS_INV_0013() {
		
	}
 	
 	/** 
     * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
 	
 	/** 
	 * currency code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.29
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		cmbObj.InsertItem(0, "ALL", "ALL");
		for (var i = 2; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
		}
		cmbObj.Index = 0;
		//cmbObj.BackColor = "#CCFFFD";
	}
	
	/** 
	 * rev_src_cd 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} s_index
	 * @param {object} s_code
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.12.01
	 */
	function rev_src_cd_OnCheckClick(comboObj, s_index, s_code) {
		//alert(comboObj+":"+s_index+":"+s_code);
		if(s_code == ""){
			if(comboObj.CheckCode("") == true){
				comboObj.CheckCode("BL") = false;
		        comboObj.CheckCode("CS") = false;
		        comboObj.CheckCode("CC") = false;
		        comboObj.CheckCode("CA") = false;
		        comboObj.CheckCode("CC") = false;
		        comboObj.CheckCode("IV") = false;
		        comboObj.CheckCode("IC") = false;
		        comboObj.CheckCode("CT") = false;
		        comboObj.CheckCode("OC") = false;
		        comboObj.CheckCode("EQ") = false;
		        comboObj.CheckCode("TS") = false;
		        comboObj.CheckCode("DM") = false;
		        comboObj.CheckCode("DT") = false;
		        comboObj.CheckCode("RD") = false;
		        comboObj.CheckCode("TH") = false;
		        comboObj.CheckCode("TP") = false;
		        comboObj.CheckCode("TM") = false;
		        comboObj.CheckCode("TN") = false;
		        comboObj.CheckCode("WC") = false;
		        comboObj.CheckCode("LS") = false;
		        comboObj.CheckCode("DO") = false;
		        
			}
		}else{
			comboObj.CheckCode("") = false;
		}
	}
	
	/** 
     * 업무 자바스크립트 OnChange 이벤트 처리 <br>
     * office2 변경시 VLCBB 일 경우, LCL CHARGE 비활성화
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {object} comboObj : 폼 오브젝트
     * @param  {int} Index_Code : 선택한 항목에 대한 value값
     * @param  {String} Text : 선택한 항목에 대한 text값
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */ 
    function office2_OnChange(comboObj,Index_Code, Text){
    	var formObj = document.form;
    	var sStr = formObj.locl_chg_ofc.value;
    	var arrStr = sStr.split("|");
    	var chg_yn = "N";
    	for (var i = 1; i < arrStr.length;i++ ) {
    		if(Text == arrStr[i]){
    			chg_yn = "Y";
    		}
    	}
    	if(chg_yn == "Y"){
    		formObj.lcl_chg.disabled = false;    		
    	}else{
    		formObj.lcl_chg.checked = false;
    		formObj.lcl_chg.disabled = true;
    		formObj.chg_cd.Enable = true;
    	}
   } 
	
	/** 
	 * lcl charge 체크박스의 값이 변경된 경우 chg code 활성화/비활성화 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
	 * @version 2009.12.01
	 */
	function chkLclChg(){
		var formObj = document.form;
		formObj.chg_cd.Text = "ALL";
		if(formObj.lcl_chg.checked == true){
			formObj.chg_cd.Enable = false;
		}else{
			formObj.chg_cd.Enable = true;
		}
	}
	
	/* 개발자 작업  끝 */