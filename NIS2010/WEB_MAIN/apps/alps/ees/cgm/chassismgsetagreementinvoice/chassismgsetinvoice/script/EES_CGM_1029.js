/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1029.js
*@FileTitle : Leased Chassis Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.20 김창식 
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
     * @class ees_cgm_1029 : ees_cgm_1029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_cgm_1029() {
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


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.20
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
	        			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	        		}
					break;

				case "btn_New":
					initControl();
					break;
						
				case "btn_ChargeCreation":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
						
				case "btn_InvoiceImportAudit":
					
					var iCheckRow = sheetObject1.CheckedRows("del_chk");
					var sChgSeq = formObject.chg_cre_seq.value;
					
					// 체크박스를 선택했는지 확인
					if(iCheckRow > 0){
						
						// Charge Creation 된 대상건인지 확인
						if(sChgSeq != ''){
							var param = "?cost_yrmon=" + formObject.cost_yrmon.value;
							param = param + "&vndr_seq=" + formObject.vndr_seq.value;
							param = param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							param = param + "&agmt_ofc_cty_cd=" + formObject.agmt_ofc_cty_cd.value;
							param = param + "&agmt_seq="        + formObject.agmt_seq.value;
							param = param + "&cost_yrmon_seq="  + formObject.cost_yrmon_seq.value;
							
							// Modal 형태로 Popup 호출.
							var sWinName = "Invoice Import & Audit";
							ComOpenWindowCenter('/hanjin/EES_CGM_1030.do' + param, sWinName, 980, 550, true);
							
							// Retrieve 실행
							//var obj = document.getElementById("btn_Retrieve");
					    	//obj.fireEvent("onclick");
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
							
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
		    			ComShowCodeMessage('CGM10008');
					}
					
					break;

				case "btn_AuditResultCreation":
					
					var iCheckRow = sheetObject1.CheckedRows("del_chk");
					var sChgSeq = formObject.chg_cre_seq.value;
					
					// 체크박스를 선택했는지 확인
					if(iCheckRow > 0){
						
						// Charge Creation 된 대상건인지 확인
						if(sChgSeq != ''){
							var param = "?cost_yrmon=" + formObject.cost_yrmon.value;
							param = param + "&vndr_seq=" + formObject.vndr_seq.value;
							param = param + "&chg_cre_seq=" + formObject.chg_cre_seq.value;
							param = param + "&lse_chg_sts_cd=" + formObject.lse_chg_sts_cd.value;
							param = param + "&agmt_ofc_cty_cd=" + formObject.agmt_ofc_cty_cd.value;
							param = param + "&agmt_seq="        + formObject.agmt_seq.value;
							param = param + "&cost_yrmon_seq="  + formObject.cost_yrmon_seq.value;
							
							// Modal 형태로 Popup 호출.
							var sWinName = "Payable Charge Audit Result & Payable Amount Confirm";
							ComOpenWindowCenter('/hanjin/EES_CGM_1031.do' + param, sWinName, 980, 600, true);
							//ComOpenPopup('/hanjin/EES_CGM_1031.do' + param, 980, 600, 'setCheckBox', '1,0', true, false, 3, 10, 0);
							
							// Retrieve 실행
							//var obj = document.getElementById("btn_Retrieve");
					    	//obj.fireEvent("onclick");
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
					    	
						} else {
							ComShowCodeMessage('CGM10008');
						}
					} else {
		    			ComShowCodeMessage('CGM10008');
					}
					break;
						
				case "btn_Delete":
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
					
				case "btns_cost_yrmon":
					var cal = new ComCalendar();
			        cal.setDisplayType('month');
			        cal.select(formObject.cost_yrmon, "yyyy-MM");
					
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
	 * @param  {object} sheetObj	필수
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function setSheetObject(sheet_obj){

	    sheetObjects[sheetCnt++] = sheet_obj;

	}

	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function loadPage() {
		
		// axon event 등록
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListenerFormat('keydown', 'obj_keydown', form);

	    for(i=0;i<sheetObjects.length;i++){

	    	//khlee-시작 환경 설정 함수 이름 변경
	    	ComConfigSheet (sheetObjects[i] );

	    	initSheet(sheetObjects[i],i+1);
	    	//khlee-마지막 환경 설정 함수 추가
	    	ComEndConfigSheet(sheetObjects[i]);
	    	
	    	initControl();

	    }
	}
	 
    function firstDayInPreviousMonth(yourDate) {
	        var d = new Date(yourDate);
	        d.setDate(1);
	        d.setMonth(d.getMonth() - 1);
	        return d;
    }

	 
	function initControl(){
		
		/* 기존 버그 '201000'으로 나옴
		// 현재 날짜 가져오기
		// 현재 날짜 이전 월 호출로 변경 (2010.04.12)
    	var today   = new Date();
    	var year = today.getFullYear();
    	var month = today.getMonth();
    	var costYrmon = ComLpad(year, 4,"0") + "-" + ComLpad(month, 2,"0");
    	*/
		
		// chungpa 20100104 신규 적용
    	var d = firstDayInPreviousMonth(new Date()); //firstDayInPreviousMonth(new Date());
    	var y = d.getYear(); 
    	var m = "";
    	var mtmp = d.getMonth()+1;
		if(mtmp<10)	m = '0'+mtmp; 
		else m = ''+ mtmp;
		var costYrmon = y+m;
    	
		
    	// COST YMO
    	document.form.cost_yrmon.value = costYrmon;
    	
    	// Sheet Object 초기화
    	for(var i=0; i < sheetObjects.length; i++){
    		sheetObjects[i].RemoveAll();
    	}
    	
    	// Import & Audit 버튼 비활성화
    	ComBtnDisable("btn_InvoiceImportAudit");
    	// Audit Result & P.Amt Confirm 비활성화
    	ComBtnDisable("btn_AuditResultCreation");
    	// Delete 버튼 비활성화
    	ComBtnDisable("btn_Delete");
	}

	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 김창식
	 * @version 2009.05.28
	 */
	function initSheet(sheetObj,sheetNo) {

	    var cnt = 0;

	    switch(sheetNo) {
	        case 1:      // sheet1 init
	            with (sheetObj) {
	            	// 높이 설정
	                style.height = 342;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;

	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "||AGMT No.|From|To|Term|Lessor|Lessor Name|Status|||||";
	                var headCount = ComCountHeadTitle(HeadTitle);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,false,	"del_chk");
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,	"agmt_no",			false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,	"agmt_eff_dt",		false, "", dfUserFormat, 0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,	"agmt_exp_dt",		false, "", dfUserFormat, 0, false, true);
											
					InitDataProperty(0, cnt++ , dtData,			50,	daCenter,false,	"agmt_lstm_cd",		false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,false,	"vndr_seq",			false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			310,daLeft,	 false,	"vndr_lgl_eng_nm",	false, "", dfNone,	  0, false, true);
					InitDataProperty(0, cnt++ , dtData,			50,daLeft,	 false,	"lse_chg_sts_desc",	false, "", dfNone,	  0, false, true);
					
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	"lse_chg_sts_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	"chg_cre_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	"agmt_ofc_cty_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	"agmt_seq");
					
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,false,	"cost_yrmon_seq");					

					InitUserFormat(0, "agmt_eff_dt", "####-##-##", "-" );
					InitUserFormat(0, "agmt_exp_dt", "####-##-##", "-" );
					
					EditableColorDiff = false;
					SelectHighLight = false;
				}
	            
	        	break;
	                
					
			case 2:      // sheet2 init
	        	with (sheetObj) {
	            	// 높이 설정
	                style.height = 62;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;

	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;

	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 3, 100);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(11, 0, 0, true);

	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                var HeadTitle = "|STS|SML|Invoice|Payable Amount|Debit Amount|Credit Amount|Tax|Created Office|User ID|Created Date";
	                var HeadTitle2 = "|STS|Amount|Request Total|Payable Amount|Debit Amount|Credit Amount|Tax|Created Office|User ID|Created Date";

	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	 daCenter, false, "hdnStatus");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,	50,	 daCenter, true,  "lse_chg_sts_cd",	  false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	120, daRight,  false, "lse_chg_smry_amt", false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	120, daRight,  false, "inv_smry_amt",	  false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	120, daRight,  true,  "pay_lse_chg_amt",  false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90, daRight,  true,  "debit_amt",	      false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90, daRight,  true,  "cr_smry_amt",	  false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	90, daRight,  true,  "tax_smry_amt",	  false, "", dfFloat,   2, false, true);
					InitDataProperty(0, cnt++ , dtData,	95, daCenter, true,  "cre_ofc_cd",	 	  false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	95, daCenter, true,  "cre_usr_id",		  false, "", dfNone,	0, false, true);
					InitDataProperty(0, cnt++ , dtData,	90, daCenter, true,  "cre_dt", 		  false, "", dfDateYmd, 0, false, true);
						
					CountPosition = 0;
				}
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
     * @version 2009.07.20
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
	    switch(sAction) {

	    	case IBSEARCH:      //조회 (Retrieve 버튼을 클릭했을 때)
		    	formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	     		formObj.chg_cre_seq.value = '';
	     		
		 		sheetObj.WaitImageVisible=false;
		 		ComOpenWait(true);	 	
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1029GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1"),'',true);
	     		sheetObjects[0].LoadSearchXml(sXml);
	     		sheetObjects[1].RemoveAll();
		 		ComOpenWait(false);	 	
	            break;
	            
	    	case IBSEARCH_ASYNC01:      //조회 (팝업창을 닫으면서 Retrieve 할때)
		    	formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	     		
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_1029GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1"),'',true);
	     		sheetObjects[0].LoadSearchXml(sXml);
	     		sheetObjects[1].RemoveAll();
	     		
	     		// sheet1 의 click 이벤트를 발생시킨다.
     			var Col = sheetObjects[0].SaveNameCol("del_chk");
     			var Row;
     			for(var i=1; i <= sheetObjects[0].RowCount; i++){	     				
     				if(sheetObjects[0].cellValue(i,"del_chk") == 1){
     					Row = i;
     					sheetObjects[0].cellValue2(i,"del_chk") = 0;
     					sheet1_OnClick(sheetObjects[0], Row, Col);
     					break;
     				}
     			}
	     		
	            break;

	    	case IBSAVE:        // 저장 (Charge Creation)
	    	
	    		var iCheckRow = sheetObj.CheckedRows("del_chk");
	    		
	    		// Row 가 체크되었는지 확인하여 처리
	    		if(iCheckRow > 0){
	    			var sCheckRows = sheetObj.FindCheckedRow("del_chk");
	    			var arrCheckRows = sCheckRows.split("|");
	    			
	    			// Charge Creation 대상 체크 (null 이거나 'H'상태)
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != '' && lseChgStsCd != 'H'){
	    					ComShowCodeMessage('CGM20015', sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_desc"));
	    					return;
	    				}
	    			}

			 		sheetObj.WaitImageVisible=false;
			 		ComOpenWait(true);	
			 		
		    		formObj.f_cmd.value = MULTI;
	     			formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
	     		 	var sParam = sheetObjects[0].GetSaveString();
		         	sParam = ComSetPrifix(sParam, "sheet1");
		         	sParam = sParam + "&";
		         	sParam = sParam + FormQueryString(formObj);
		         	var prefix = new Array("sheet1", "sheet2");	// sheet1과 sheet2 에 따라 적용되는 ViewAdapter가 다름.
	     			var sXml = sheetObj.GetSaveXml("EES_CGM_1029GS.do", sParam + "&" + ComGetPrefixParam(prefix));
	         		var arrXml = sXml.split("|$$|");
	     			sheetObjects[0].LoadSaveXml(arrXml[0]);
	     			sheetObjects[1].RemoveAll();
	     			
			 		ComOpenWait(false);		     			
	     			//sheetObjects[1].LoadSearchXml(arrXml[1]);
	     			
	     			// sheet1 의 click 이벤트를 발생시킨다.
	     			var Col = sheetObjects[0].SaveNameCol("del_chk");
	     			var Row;
	     			for(var i=1; i <= sheetObjects[0].RowCount; i++){	     				
	     				if(sheetObjects[0].cellValue(i,"del_chk") == 1){
	     					Row = i;
	     					sheetObjects[0].cellValue2(i,"del_chk") = 0;
	     					sheet1_OnClick(sheetObjects[0], Row, Col);
	     					break;
	     				}
	     			}
	     			
	    		} else {
	    			ComShowCodeMessage('CGM10008');
	    		}
         		
	            break;

	    	case IBDELETE:      // 삭제
	    		
	    		var iCheckRow = sheetObj.CheckedRows("del_chk");
	    		var chgCreSeq = document.form.chg_cre_seq.value;
	    		
		    	if(iCheckRow > 0){
		    		if(chgCreSeq != ''){
		    			
		    			var sCheckRows = sheetObj.FindCheckedRow("del_chk");
		    			var arrCheckRows = sCheckRows.split("|");
		    			
		    			// Charge Creation 대상 체크 ('H','A','S' 상태)
		    			for(var i=0; i<arrCheckRows.length-1; i++){
		    				var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
		    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A' && lseChgStsCd != 'S'){
		    					ComShowCodeMessage('CGM20015', sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_desc"));
		    					return;
		    				}
		    			}

				 		sheetObj.WaitImageVisible=false;
				 		ComOpenWait(true);	
				 		
		    			formObj.f_cmd.value = REMOVE;
			    		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
			     		var sParam = sheetObjects[0].GetSaveString();
			         	sParam = ComSetPrifix(sParam, "sheet1");
			         	sParam = sParam + "&";
			         	sParam = sParam + FormQueryString(formObj);
			         	var sXml = sheetObjects[1].GetSaveXml("EES_CGM_1029GS.do", sParam + "&" + ComGetPrefixParam("sheet1"));
			     		sheetObjects[1].RemoveAll();
			     		sheetObjects[0].LoadSaveXml(sXml);
				 		
				 		ComOpenWait(false);	
				 		
			     		// Import & Audit 버튼 비활성화
			        	ComBtnDisable("btn_InvoiceImportAudit");
			        	// Audit Result & P.Amt Confirm 비활성화
			        	ComBtnDisable("btn_AuditResultCreation");
			        	// Audit Result & P.Amt Confirm 비활성화
			        	ComBtnDisable("btn_Delete");
			     		
		    		}
			     		
		    	} else {
		    		ComShowCodeMessage('CGM10008');
	    		}
	    		
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
     * @version 2009.07.20
     */  
	function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
	    	switch(sAction){
	    		case IBSEARCH:
	    			if(cost_yrmon.value == ''){
	    				ComShowCodeMessage('CGM10004','Cost Month');
	    				cost_yrmon.focus();
        	 			return false;
	    			} else {
	    				return true;
	    			}
	    			break;
	    	}
	    }

	    return true;
	}
     
    /** 
     * Object 의 Keydown 이벤트에 대한 처리  <br>
     * 객체가 agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.21
     */ 
    function obj_keydown(){
    	ComKeyEnter();
    }
	    
	/** 
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */ 
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	     	 	
	    window.defaultStatus = obj.dataformat;
	     	 
	    switch(obj.dataformat) {
	     	case "ym": case "ymd":
	     		ComKeyOnlyNumber(obj);
	     		break;
	     	case "int":
	        	ComKeyOnlyNumber(obj);
	            break;
	     	case "float":
		        ComKeyOnlyNumber(obj, "-.");
		        break;    
	        case "eng":
	            ComKeyOnlyAlphabet(); 
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	    }
	}
	
	/** 
	 * Object 의 activate 이벤트에 대한 처리  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.07.20
	 */
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	
	/** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.07.20
     */
    function obj_deactivate(){
    	ComChkObjValid(event.srcElement);
    }

	/**
	 * Sheet1 의 OnSaveEnd 이벤트처리 (Charge Creation)<br>
	 * @param  {object} sheetObj	필수	 Sheet Object
	 * @param  {string} ErrMsg		필수 String
	 * @return 없음
	 * @version 2009.07.20
	 */ 
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg =='') {   
			ComShowCodeMessage('CGM00003');
		}
	}
	 
	/**
	 * Sheet1 의 Click 할 경우 선택한 Cell의 값과 동일한 Row를 반전 처리 <br>
	 * @author 김창식
	 * @version 2009.08.18
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){

		var formObj = document.form;
		var chgCreSeq = sheetObj.cellValue(Row,"chg_cre_seq"); 
		var lseChgStsCd = sheetObj.cellValue(Row, "lse_chg_sts_cd");
		var vndrSeq = sheetObj.cellValue(Row,"vndr_seq"); 
		
		var agmtOfcCtyCd = sheetObj.cellValue(Row,"agmt_ofc_cty_cd"); 
		var agmtSeq      = sheetObj.cellValue(Row,"agmt_seq"); 
		var costYrmonSeq = sheetObj.cellValue(Row,"cost_yrmon_seq"); 		

		// 체크처리
		if(sheetObj.ColSaveName(Col)=='del_chk'){
			sheetObj.cellValue2(Row,"del_chk") = sheetObj.cellValue(Row,"del_chk") == 0?1:0;
		}
		
		formObj.vndr_seq.value = vndrSeq;
		
		// sheet2 데이터 삭제
		sheetObjects[1].RemoveAll();
		
		// Charge Creation 대상
		if(chgCreSeq == ""){
			
			// Xtra 와 FLEXI-VAN 은 동일 벤더로 간주하도록  선택된 Lessor 값을 설정
			if(vndrSeq == '132466' || vndrSeq == '105026'){
				vndrSeq = "105621";
			}
			
			// Row의 색상 반전 처리와 체크박스 처리
			for(var i=1; i <= sheetObj.RowCount; i++){
				
				var cellVndrSeq = sheetObj.cellValue(i,"vndr_seq");
				
				// Xtra 와 FLEXI-VAN 은 동일 벤더로 간주하도록 각 Cell의 Lessor 값을 설정
				if(cellVndrSeq == '132466' || cellVndrSeq == '105026'){
					cellVndrSeq = "105621";
				}
				
				if(vndrSeq == cellVndrSeq &&
						sheetObj.cellValue(i,"chg_cre_seq") == ''){
					
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(231,250,248); 
				} else {
					sheetObj.cellValue2(i,"del_chk") = 0;
					sheetObj.cellValue2(i,"ibflag") = "";
					
					if(sheetObj.cellValue(i,"lse_chg_sts_cd") == ""){
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(192,192,192); 
					} else {
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255); 
					}
				}
			}
			
			ComBtnDisable("btn_InvoiceImportAudit");
			ComBtnDisable("btn_AuditResultCreation");
			ComBtnDisable("btn_Delete");
			
			formObj.chg_cre_seq.value = "";
			
		// Charge Creation 완료	
		} else {

			// Row의 색상 반전 처리와 체크박스 처리
			for(var i=1; i <= sheetObj.RowCount; i++){
				if(chgCreSeq == sheetObj.cellValue(i,"chg_cre_seq")){
					if(sheetObj.ColSaveName(Col)=='del_chk'){
						//sheetObj.cellValue2(i,"del_chk") = 1;
						
						sheetObj.cellValue2(i,"del_chk") = sheetObj.cellValue(Row,"del_chk");
						if(sheetObj.cellValue(Row,"del_chk")==0){
							sheetObj.cellValue2(i,"ibflag") = "";
						} else {
							sheetObj.cellValue2(i,"ibflag") = "U";
						}
					}
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(231,250,248); 
				} else {
					sheetObj.cellValue2(i,"del_chk") = 0;
					sheetObj.cellValue2(i,"ibflag") = "";

					if(sheetObj.cellValue(i,"lse_chg_sts_cd") == ""){
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(192,192,192); 
					} else {
						sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,255); 
					}
				}
			}
			
			// Invoice Import & Audit Button 비활성화 처리
			if(sheetObj.ColSaveName(Col)=='del_chk'){
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				var sCheckRows = sheetObj.FindCheckedRow("del_chk");
    			var arrCheckRows = sCheckRows.split("|");
    			
    			// Invoice Import & Audit 대상 ('H' 또는 'A' 상태가 아니면 비활성 처리)
    			if(iCheckRow > 0){
    				var auditImportBtn = true;
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A'){
	    					auditImportBtn = false;
	    					break;
	    				}
	    			}
	    				
	    			var deleteBtn = true;
	    			for(var i=0; i<arrCheckRows.length-1; i++){
	    				var lseChgStsCd = sheetObj.cellValue(arrCheckRows[i],"lse_chg_sts_cd");
	    				if(lseChgStsCd != 'H' && lseChgStsCd != 'A'){
	    					deleteBtn = false;
	    					break;
	    				}
	    			}
	    			
	    			if(auditImportBtn){
	    				ComBtnEnable("btn_InvoiceImportAudit");
	    			} else {
	    				ComBtnDisable("btn_InvoiceImportAudit");
	    			}
	    			
	    			if(deleteBtn){
	    				ComBtnEnable("btn_Delete");
	    			} else {
	    				ComBtnDisable("btn_Delete");
	    			}
	    			
	    			// Audit Result & P.Amt Confirm Button 활성화
	    			ComBtnEnable("btn_AuditResultCreation");
    				
    			} else {
    				// 체크된 것이 없으면 비활성화.
    				ComBtnDisable("btn_InvoiceImportAudit");
    				ComBtnDisable("btn_AuditResultCreation");
    				ComBtnDisable("btn_Delete");
    			}
			}
			
			// Charge Creation 결과 목록 조회
			formObj.f_cmd.value = SEARCH01;
     		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
     		formObj.chg_cre_seq.value = chgCreSeq;
     		formObj.lse_chg_sts_cd.value = lseChgStsCd;
     		
     		formObj.agmt_ofc_cty_cd.value = agmtOfcCtyCd;
     		formObj.agmt_seq.value        = agmtSeq;
     		formObj.cost_yrmon_seq.value  = costYrmonSeq;     		
     		
     		var sXml = sheetObj.GetSearchXml("EES_CGM_1029GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2"), '', true );     	
     		sheetObjects[1].LoadSearchXml(sXml);
			
		}

	} 
	 
	/* 개발자 작업  끝 */