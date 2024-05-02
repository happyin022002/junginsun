/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0022.js
*@FileTitle : Other Revenue Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.04.27 박정진
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.04.06 최도순 [CHM-201109882-01] ALPS INVOICE 내 Other Revenue Invoice Creation 로직 변경 요청.
 * 2012.05.03 김상현 [CHM-201217632-01] AR INV > OTHER REVENUE INVOICE CREATION 보완 요청.
 * 2014.10.27 최도순 [CHM-201432490] Other Revenue Creation 시, VVD 추가 생성 요청
 * 2016.07.14 김현화 [CHM-201642642] Other Revenue Invoice Creation 411991 추가-PUSMPG 만 사용
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
     * @class fns_inv_0022 : fns_inv_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0022() {
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
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;

	//DATA 구분자 정의
	var ROWMARK = "|";
	var FIELDMARK = "=";
	
	var arrAcctCd = new Array();
	var arrAcctEngNm = new Array();
	var arrAcctKrnNm = new Array();
	var arrRevCd = new Array();
	var arrChgCd = new Array();
	var arrRepChgCd = new Array();

	var arrCurrInfo = new Array();
	var arrDpPrcsKnt = new Array();
    
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
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var rdObject = rdObjects[0];
		/*******************************************************/
		var formObj = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var param = "";
			
			switch(srcName) {
				case "btn_new":
					removeAll(formObj);
				break;
				
				case "btn_print1":
					rdOpen(rdObjects[0], formObj);
				break;
				
				case "btn_print2":
					rdOpen(rdObjects[0], formObj);
				break;
				
				case "btn_close":
					window.close();
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject,formObj,IBSAVE);
				break;
				
				case "btn_create":
					doActionIBSheet(sheetObject,formObj,IBINSERT);
				break;
				
				case "btn_auto":
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC12);
				break;														
				
				case "btn_add":
					if(validateForm(sheetObject,formObj,IBSEARCH_ASYNC13)) {
						var currPoint = formObj.curr_point.value;
						var lclCurrPoint = formObj.lcl_curr_point.value;
						var invVatChgCd = formObj.inv_vat_chg_cd.value;
						var tvaChgCnt = 0;
						var tvaChgRow = 0;
				    	
						// VAT로 생성된 줄이 있는지 확인하여 있다면 그것보다 위에 생기도록 한다.
						for (var i = 1; i < sheetObject.RowCount + 1; i++) {   	 				
							if (sheetObject.CellValue(i, "chg_cd") == invVatChgCd && sheetObject.CellValue(i, "tax_yn") == "T") {
								tvaChgCnt++;	
								tvaChgRow = i;
							}
						}
			    		if (tvaChgCnt == 0) {
			    			sheetObject.DataInsert(-1);  
			    		}
			    		else {	 				 
			    			sheetObject.DataInsert(tvaChgRow - 1);
			    		}
						
			    		//금액부분의 화폐에 따른 자릿수 설정( Row Add 버튼을 클릭하여 줄 추가시는 선택된 curr_cd의 자릿수로 생성한다.)
						if (currPoint == '0') {
							sheetObject.InitCellProperty(sheetObject.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
						}
						else {
							//sheetObject.InitCellProperty(sheetObject.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, lclCurrPoint );
							sheetObject.InitCellProperty(sheetObject.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
						}
			    		
						addCellComboItem(sheetObject,'acct_cd',true);

						sheetObject.CellValue2(sheetObject.SelectRow, "cust_code")  = formObj.cust_cnt_cd.value + formObj.cust_seq.value ;
						sheetObject.CellValue2(sheetObject.SelectRow, "city")       = formObj.pol_cd.value;
						sheetObject.CellValue2(sheetObject.SelectRow, "curr_cd")    = formObj.curr_cd.text;
						sheetObject.CellValue2(sheetObject.SelectRow, "inv_rev_tp_src_cd") = "XXX";
						sheetObject.CellValue2(sheetObject.SelectRow, "chg_cd")     = "TVA";
						sheetObject.CellValue2(sheetObject.SelectRow, "rep_chg_cd") = "SLC";
						sheetObject.CellValue2(sheetObject.SelectRow, "inv_xch_rt") = formObj.inv_xch_rt.value;
						sheetObject.CellValue2(sheetObject.SelectRow, "tax_yn")     = "N";
						sheetObject.CellValue2(sheetObject.SelectRow, "mnl_flg")    = "Y";

						//생성시에는 vat 체크박스를 비활성화한다.
						sheetObject.CellEditable(sheetObject.SelectRow, "tva_flg") = false;
					}
				break;
				
				case "btn_copy":
					if(validateForm(sheetObject,formObj,IBSEARCH_ASYNC13)) {
						if(sheetObject.RowCount > 0) {
							// tax에 의하여 발생한 212111 항목은 복사/삭제되지 않는다.
							if (sheetObject.CellValue(sheetObject.SelectRow, "mnl_flg") == "Y") {
								var currPoint = formObj.curr_point.value;
								var lclCurrPoint = formObj.lcl_curr_point.value;
								var invVatChgCd = formObj.inv_vat_chg_cd.value;
								
								var acctCd    = sheetObject.CellValue(sheetObject.SelectRow, "acct_cd");
								var chgFullNm = sheetObject.CellValue(sheetObject.SelectRow, "chg_full_nm");
								var custCode  = sheetObject.CellValue(sheetObject.SelectRow, "cust_code");
								var city      = sheetObject.CellValue(sheetObject.SelectRow, "city");
								var currCd    = sheetObject.CellValue(sheetObject.SelectRow, "curr_cd");
								var chgAmt    = sheetObject.CellValue(sheetObject.SelectRow, "chg_amt");
								var chgRmk    = sheetObject.CellValue(sheetObject.SelectRow, "chg_rmk");
								var revCd     = sheetObject.CellValue(sheetObject.SelectRow, "inv_rev_tp_src_cd");
								var chgCd     = sheetObject.CellValue(sheetObject.SelectRow, "chg_cd");
								var repChgCd  = sheetObject.CellValue(sheetObject.SelectRow, "rep_chg_cd");
								var invXchRt  = sheetObject.CellValue(sheetObject.SelectRow, "inv_xch_rt");
								var taxYn     = sheetObject.CellValue(sheetObject.SelectRow, "tax_yn");
								var mnlFlg    = sheetObject.CellValue(sheetObject.SelectRow, "mnl_flg");
								
								var tvaChgCnt = 0;
								var tvaChgRow = 0;
						    	
								// VAT로 생성된 줄이 있는지 확인하여 있다면 그것보다 위에 생기도록 한다.
								for (var i = 1; i < sheetObject.RowCount + 1; i++) {   	 				
									if (sheetObject.CellValue(i, "chg_cd") == invVatChgCd && sheetObject.CellValue(i, "tax_yn") == "T") {
										tvaChgCnt++;	
										tvaChgRow = i;
									}
								}
					    		if (tvaChgCnt == 0) {
					    			sheetObject.DataInsert(-1);  
					    		}
					    		else {	 				 
					    			sheetObject.DataInsert(tvaChgRow - 1);
					    		}
					    		
								addCellComboItem(sheetObject,'acct_cd',true);
		
								sheetObject.CellValue2(sheetObject.SelectRow, "acct_cd")     = acctCd;
								sheetObject.CellValue2(sheetObject.SelectRow, "chg_full_nm") = chgFullNm;
								sheetObject.CellValue2(sheetObject.SelectRow, "cust_code")   = custCode;
								sheetObject.CellValue2(sheetObject.SelectRow, "city")        = city;
								sheetObject.CellValue2(sheetObject.SelectRow, "curr_cd")     = currCd;
								sheetObject.CellValue2(sheetObject.SelectRow, "chg_amt")     = chgAmt;
								sheetObject.CellValue2(sheetObject.SelectRow, "chg_rmk")     = chgRmk;
								sheetObject.CellValue2(sheetObject.SelectRow, "inv_rev_tp_src_cd") = revCd;
								sheetObject.CellValue2(sheetObject.SelectRow, "chg_cd")      = chgCd;
								sheetObject.CellValue2(sheetObject.SelectRow, "rep_chg_cd")  = repChgCd;
								sheetObject.CellValue2(sheetObject.SelectRow, "inv_xch_rt")  = invXchRt;
								sheetObject.CellValue2(sheetObject.SelectRow, "tax_yn")      = "N";
								sheetObject.CellValue2(sheetObject.SelectRow, "mnl_flg")      = mnlFlg;
								
								//CR 그리드 세팅
								crGridSet();
								//INV_AR_AMT 그리드 세팅
								amtGridSet();
							}
						}
					}
				break;
				
				case "btn_delete":
					if (gridCopyDeleteOK(sheetObject, sheetObject.SelectRow, formObj)) {
						sheetObject.RowDelete();
						//CR 그리드 세팅
						crGridSet();
						//INV_AR_AMT 그리드 세팅
						amtGridSet();
					}
				break;
				
				case "btns_calendar": //달력버튼
					if (formObj.view_yn.value != "Y") {
						var cal = new ComCalendar();
						cal.setDisplayType('date');
		             	cal.select(formObj.eff_dt, 'yyyy-MM-dd');
					}
	            break;
	            
				case "btns_cust1": //CUST 조회버튼
					var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
					var v_cust_seq = formObj.cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					if (formObj.view_yn.value != "Y") {
						var v_cust_cnt_cd = formObj.cust_cnt_cd.value;
						var v_cust_seq = formObj.cust_seq.value;
						var v_cust_nm = sheetObject.UrlEncoding(formObj.cust_nm.value);
						
						var classId = "FNS_INV_0086";
						var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
				
						ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
					}
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
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
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
	 * @version 2009.04.27
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function loadPage() {
		var formObj = document.form;
		
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
		
		initControl();
		
		//RD
		initRdConfig(rdObjects[0]);
		
		//화면타입을우선 입력화면으로 설정한다. 아래에서 조회화면은 조건을 변경해준다.
		formObj.pagetype.value = "E";
		
		//입력화면일 경우
		if (formObj.view_ar_if_no.value == '' && formObj.view_ar_ofc_cd.value == '') {
			document.title = "Other Revenue Invoice Creation";
			document.getElementById("title").innerHTML = "&nbsp;&nbsp;Other Revenue Invoice Creation";
			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			
			// 조회조건 초기화-입력
			setSearchValueType();
 		    ComShowCodeMessage("INV00178");
		}
		//조회화면일 경우
		else {
			formObj.pagetype.value = "I";
//			//타이틀을 변경해준다.
//			document.title = "Other Revenue Invoice";
//			document.getElementById("title").innerHTML = "&nbsp;&nbsp;Other Revenue Invoice";
			// 화면 초기 코드값 조회
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC14);

			formObj.ar_ofc_cd.text = formObj.view_ar_ofc_cd.value;
			formObj.ofc_cd.value = formObj.view_ar_ofc_cd.value;
			formObj.ar_if_no.value = formObj.view_ar_if_no.value;

			// 조회조건 초기화-조회
			setSearchValueType();
			
			// 입력된 내용 조회
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			
			// cr 그리드 비활성화
			for(var i=sheetObjects[0].rowCount; i>0; i--){
				sheetObjects[0].RowEditable(i) = false;
			}
		}
		var sheetObject = sheetObjects[0];
	    formObj.com_mrdTitle.value = "Other Revenue Invoice  Print";
	    formObj.com_mrdBodyTitle.value = "Other Revenue Invoice  Print";
	    if (formObj.ar_ofc_cd.text !='LEHSC'){
	        sheetObject.ColHidden("ttl_lss_cfm_flg") = true;
	    }
	}
	
	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		var currPoint = formObject.curr_point.value;
		var lclCurrPoint = formObject.lcl_curr_point.value;
		var setCurrPoint = "";
		if (Number(currPoint) > Number(lclCurrPoint)) {
			setCurrPoint = currPoint;
		}
		else {
			setCurrPoint = lclCurrPoint;
		}
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 160;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(17, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false);

					var HeadTitle = "|CR Acct|Account Name|Cust Code|City|Curr|Amount|Remark|TVA|Total Loss|revCd|chgCd|repChgCd|invXchRt|taxYn|chgSeq|mnlFlg";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성                 [ROW, COL,    DATATYPE,      WIDTH,  DATAALIGN, COLMERGE,  SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (setCurrPoint > 0) {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,    "ibflag");
						InitDataProperty(0, cnt++ , dtCombo,     	 80,    daLeft,		false,    "acct_cd",    true,     "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,     	 270,   daLeft,		false,    "chg_full_nm",false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 85,    daCenter,	false,    "cust_code",  false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 65,    daCenter,	false,    "city",       false,    "",      dfNone,	0,	false,	false);
						
						InitDataProperty(0, cnt++ , dtData,     	 60,    daCenter,	false,    "curr_cd",	false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 140,   daRight,	false,    "chg_amt",    true,     "",    dfNullFloat, 2);
						InitDataProperty(0, cnt++ , dtData,     	 235,   daLeft,		false,    "chg_rmk",    false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtCheckBox, 	 40,    daCenter,   false,    "tva_flg",    false,    "",      dfNone,  0,  false,	false);
						InitDataProperty(0, cnt++ , dtCheckBox, 	 40,    daCenter,   false,    "ttl_lss_cfm_flg",    false,    "",      dfNone,  0,  false,	false);
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "inv_rev_tp_src_cd",     false,    "",      dfNone);
	
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "chg_cd",     false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "rep_chg_cd", false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "tax_yn",		false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "chg_seq",	false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "mnl_flg",	false,    "",      dfNone);
					}
					else {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,    "ibflag");
						InitDataProperty(0, cnt++ , dtCombo,     	 80,    daLeft,		false,    "acct_cd",    true,     "",      dfNone);
						InitDataProperty(0, cnt++ , dtData,     	 270,   daLeft,		false,    "chg_full_nm",false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 85,   daCenter,	false,    "cust_code",  false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 65,    daCenter,	false,    "city",       false,    "",      dfNone,	0,	false,	false);
						
						InitDataProperty(0, cnt++ , dtData,     	 60,    daCenter,	false,    "curr_cd",	false,    "",      dfNone,	0,	false,	false);
						InitDataProperty(0, cnt++ , dtData,     	 140,   daRight,	false,    "chg_amt",    true,     "",    dfInteger);
						InitDataProperty(0, cnt++ , dtData,     	 235,   daLeft,		false,    "chg_rmk",    false,    "",      dfNone);                    
						InitDataProperty(0, cnt++ , dtCheckBox, 	 40,    daCenter,   false,    "tva_flg",    false,    "",      dfNone,  0,  false,	false);
						InitDataProperty(0, cnt++ , dtCheckBox, 	 40,    daCenter,   false,    "ttl_lss_cfm_flg",    false,    "",      dfNone,  0,  false,	false);
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "inv_rev_tp_src_cd",     false,    "",      dfNone);
						
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "chg_cd",     false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,     	 50,    daLeft,		false,    "rep_chg_cd", false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "tax_yn",		false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "chg_seq",	false,    "",      dfNone);
						InitDataProperty(0, cnt++ , dtHidden,    	 80,	daRight,	false,    "mnl_flg",	false,    "",      dfNone);
					}
					InitDataCombo(0, "acct_cd", "", "");
					WaitImageVisible=false;
				}
			break;
			case 2:      //sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 80;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle = "|Curr|Local Total";
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "curr_cd",		false,    "",    dfNone);
					if (setCurrPoint > 0) {
						InitDataProperty(0, cnt++ , dtAutoSum,	150,	daRight,	false,   "local_total",	false,    "",    dfNullFloat, setCurrPoint);
					}
					else {
						InitDataProperty(0, cnt++ , dtAutoSum,	150,	daRight,	false,   "local_total",	false,    "",    dfInteger);
					}
					
					CountPosition = 0;
					
					WaitImageVisible=false;
				}
			break;
			case 3:      //sheet3 init
				with (sheetObj) {
					//높이 설정
					style.height = 80;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle3 = "|Curr|Amount|Ex.Rate|Local Total";
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle3), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle3, false, true);
					
					colHidden(4) = true;
			
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "curr_cd",		false,    "",    dfNone);
					if (setCurrPoint > 0) {
						InitDataProperty(0, cnt++ , dtData, 	110,	daRight,	false,   "chg_amt",		false,    "",    dfNullFloat, setCurrPoint);
						InitDataProperty(0, cnt++ , dtHidden,   90,		daRight,	false,   "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
						InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	false,   "local_total",	false,    "|2|*|3|",   dfNullFloat, setCurrPoint);
					}
					else {
						InitDataProperty(0, cnt++ , dtData, 	110,	daRight,	false,   "chg_amt",		false,    "",    dfInteger);
						InitDataProperty(0, cnt++ , dtHidden,   90,		daRight,	false,   "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
						InitDataProperty(0, cnt++ , dtAutoSum,	100,	daRight,	false,   "local_total",	false,    "|2|*|3|",    dfInteger);
					}
					
					CountPosition = 0;
					
					WaitImageVisible=false;
				}
			break;
			case 4:      //sheet4 init (INV_AR_AMT)
				with (sheetObj) {
					//높이 설정
					style.height = 80;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle4 = "|TjSrcNm|Curr|Amount";
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle4), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle4, false, false);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (setCurrPoint > 0) {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,   "ibflag");
						InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "tj_src_nm",	false,    "",    dfNone);
						InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "curr_cd",		false,    "",    dfNone);
						InitDataProperty(0, cnt++ , dtData, 		110,	daRight,	false,   "inv_amt",		false,    "",    dfNullFloat, 	setCurrPoint);
					}
					else {
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,   "ibflag");
						InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "tj_src_nm",	false,    "",    dfNone);
						InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	false,   "curr_cd",		false,    "",    dfNone);
						InitDataProperty(0, cnt++ , dtData, 		110,	daRight,	false,   "inv_amt",		false,    "",    dfInteger);
					}
					
					//CountPosition = 0;
					
					WaitImageVisible=false;
				}
				break;
		}
	}
  	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
			case "curr_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
				}
				break;
			case "ar_tax_ind_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,0);
					MaxLength = 3;
				}
				break;
		}
  	}
  	
	/** 
	 * RD 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {RdObject} rdObject
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function initControl() {
		var formObj = document.form;
		
    	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('change', 'obj_onchange', formObj);
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
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function obj_keypress() {
		var formObj = document.form;
		
		if (formObj.view_yn.value != "Y") {
			switch(event.srcElement.dataformat){
				case "float":
					//숫자+"."입력하기
					ComKeyOnlyNumber(event.srcElement, ".-"); 
				break;
				
				case "int":
					//숫자만 입력하기
					ComKeyOnlyNumber(event.srcElement,"-"); 
				break;
				
				case "engup":
					switch(event.srcElement.name){
						case "bl_src_no":	
							//영문대문자+숫자입력하기
							ComKeyOnlyAlphabet('uppernum'); 
						break;
						
						case "ar_if_no":	
							//영문대문자+숫자입력하기
							ComKeyOnlyAlphabet('uppernum'); 
						break;
	
						case "cust_cnt_cd":	
							//영문대문자만입력하기		    	        
							ComKeyOnlyAlphabet('upper'); 
						break;
	
						case "port":	
							//영문대문자만입력하기		    	        
							ComKeyOnlyAlphabet('upper'); 
						break;
					}
				break;
				
		        case "num":
		        	//숫자만입력하기(정수,날짜,시간)
		            ComKeyOnlyNumber('num');
	            break;
				
				default:
					//숫자만입력하기
					ComKeyOnlyNumber(event.srcElement);
				break;
			}
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function obj_activate() {
		var formObj = document.form;
		
		if (formObj.view_yn.value != "Y") {
			//마스크 구분자 없애기
			ComClearSeparator (event.srcElement);
			event.srcElement.select();
		}
	}
	
	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function obj_keyup() {
		var formObj = document.form;
		
		if (formObj.view_yn.value != "Y") {
			switch (event.srcElement.name) {
				case "eff_dt":
					var glEffDt = ComReplaceStr(event.srcElement.value,"-","");
					
					if (glEffDt.length == 8) {
						formObj.cust_cnt_cd.focus();
					}
		 		break;
				case "cust_cnt_cd":
					var custCntCd = event.srcElement.value;
					
					if (custCntCd.length == 2) {
						formObj.cust_seq.focus();
					}
		 		break;
			}
		}
	}

	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;

		if (formObj.view_yn.value != "Y") {
			switch(event.srcElement.name){
				case "eff_dt":

					var glEffDt = ComReplaceStr(event.srcElement.value,"-","");
					
					if (glEffDt.length == 8) {
						if (ComChkObjValid(event.srcElement)) {
							//Office AR Currency 경리환율 조회
							if(getLoclXchRt()) {
								//Amount 계산
								calLocalAmount();
								//CR Detail 그리드 세팅
								dtlGridSet('amount');
								dtlGridSet('exRate');
								//TVA Amount 계산
								calTVAAmount(sheetObject, formObj);
								//DR 그리드 세팅
								drGridSet();
								//CR 그리드 세팅
								crGridSet();
								//INV_AR_AMT 그리드 세팅
								amtGridSet();
							}
						}
					}
				break;
				
				case "cust_seq":
					//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
					if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
						var valueCustSeq = formObj.cust_seq.value;
						formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
						
						doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);

						var custCd = "";
						if (formObj.cust_nm.value != '') {
							custCd = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
						}
						else {
							custCd = "";
							formObj.cust_seq.focus();
						}
						
						for(i=sheetObject.rowCount; i>0; i--){
							sheetObject.CellValue2(i, "cust_code") = custCd;
						}
					}
					else {
						formObj.cust_nm.value = '';
						
						for(i=sheetObject.rowCount; i>0; i--){
							sheetObject.CellValue2(i, "cust_code") = "";
						}
					}
				break;
				
				case "amount":
					//Amount 계산
					calLocalAmount();
					//CR Detail 그리드 세팅
					dtlGridSet('amount');
					//TVA Amount 계산
					calTVAAmount(sheetObject, formObj);
					//DR 그리드 세팅
					drGridSet();
					//CR 그리드 세팅
					crGridSet();
					//INV_AR_AMT 그리드 세팅
					amtGridSet();
				break;
	
				case "inv_xch_rt":
					if(ComChkObjValid(event.srcElement)) {
						if (!ComIsNull(formObj.usd_locl_xch_rt) && !ComIsNull(formObj.inv_xch_rt)) {
							//경리환율 변경 범위 체크
							if (chkXchRate()) {
								//Amount 계산
								calLocalAmount();
								//CR Detail 그리드 세팅
								dtlGridSet('exRate');
								//TVA Amount 계산
								calTVAAmount(sheetObject, formObj);
								//DR 그리드 세팅
								drGridSet();
								//CR 그리드 세팅
								crGridSet();
								//INV_AR_AMT 그리드 세팅
								amtGridSet();
							}
							else {
								ComShowMessage(ComGetMsg('INV00016'));
								//formObj.inv_xch_rt.value = "";
								formObj.inv_xch_rt.focus();
							}
						}
					}
				break;
				
				default:
					//Validation 전체 체크(길이,format,최대,최소 등등)
					ComChkObjValid(event.srcElement);
				break;
			}
		}
	}

	/** 
	 * 업무 자바스크립트 OnChange 이벤트 처리<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function obj_onchange() {
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
        switch(event.srcElement.name){
            case "bl_src_no":
            	//B/L NO가 변경된 경우 기존에 입력된 CUSTOMER 정보가 있는지 체크하여 표시한다.
            	doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC15);
           	break;
           	
            case "lcl_vvd":
            	//VVD 입력사항 체크
				chkLclVvd();
				
            case "lehbb_vat_rate":
            	//LEHSC VAT 요율 변경에 따른 재 계산
            	lehbb_vat_rate_OnChange();
			break;  
        }	    
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ofc_cd.value = arrStr2[1];
					formObj.ots_smry_cd.value = arrStr2[13];
					
					var sheetObj1 = sheetObjects[0];
					var sheetObj2 = sheetObjects[1];
					var sheetObj3 = sheetObjects[2];
					var sheetObj4 = sheetObjects[3];
					
					//ComOpenWait(true); 
					
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0022GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0) {
						//소수점 자릿수
						var currPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt");
						var lclCurrPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt_lcl");
						
						var list = ComXml2ListMap(arrXml[0]);
						
						//조회조건 저장
						var arIfNo = "";
						var arOfcCd = "";
	
						if (list.length > 0) {
							var expensInfo  = list[0];
							
							if (expensInfo["cust_cnt_cd"] != '') {
								
								formObj.curr_point.value = currPoint;
								formObj.lcl_curr_point.value = lclCurrPoint;
								
								//각 항목별 조회된 값을 표시한다.
								ComMapToForm(formObj,expensInfo);
								
								formObj.curr_cd.text = expensInfo["curr_cd"];
								if (expensInfo["ar_tax_ind_cd"] != 'N') {
									formObj.ar_tax_ind_cd.text = expensInfo["ar_tax_ind_cd"]+"%";
								}
								else {
									formObj.ar_tax_ind_cd.text = expensInfo["ar_tax_ind_cd"];
								}
							}
							else {
								arIfNo = formObj.ar_if_no.value;
								arOfcCd = formObj.ar_ofc_cd.text;
								
								ComResetAll();
								
								formObj.ar_if_no.value = arIfNo;
								formObj.ar_ofc_cd.text = arOfcCd;
							}
						}
					}
					
			    	// sheet 초기화
					sheetObj1.Reset();
					sheetObj2.Reset();
					sheetObj3.Reset();
					sheetObj4.Reset();

					var currCd = formObj.curr_cd.text;
					var lclCurrCd = formObj.lcl_curr.value;
					
					initSheet(sheetObj1,1);
			    	initSheet(sheetObj2,2);
			    	initSheet(sheetObj3,3);
			    	initSheet(sheetObj4,4);
					
			    	if (arrXml.length > 1) {
						addCellComboItem(sheetObj1,'acct_cd',false);
						sheetObj1.LoadSearchXml(arrXml[1]);
						
						var taxInfoCnt = 0;
						
						for(var i=sheetObj1.rowCount; i>0; i--){
							if(sheetObj1.CellValue(i, "ibflag") != "" && sheetObj1.CellValue(i, "mnl_flg") == "N") {
								taxInfoCnt ++;
							}
						}
						
						if (taxInfoCnt > 0) {
							document.getElementById('taxDiv1').style.display = "block";
							document.getElementById('taxDiv2').style.display = "none";
							formObj.ar_tax_ind_cd.Enable = false;
						}
					}
			    	
					//DR 그리드 세팅
					drGridSet();
					//CR 그리드 세팅
					crGridSet();
					//INV_AR_AMT 그리드 세팅
					amtGridSet();
					
					if (formObj.ots_smry_cd.value == 'INV' && formObj.inv_no.value == '') {
						ComBtnEnable("btn_create");
					} else {
						ComBtnDisable("btn_create");
					}
					
					//ComOpenWait(false); 
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction) && chkLclVvd()) {
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ofc_cd.value = arrStr2[1];
					
					formObj.f_cmd.value = MULTI;
					
					var sParam = FormQueryString(formObj); 
					var sParam1 = sheetObjects[0].GetSaveString();
					var sParam2 = sheetObjects[3].GetSaveString();
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam1 = ComSetPrifix(sParam1, "sheet1_");
						sParam2 = ComSetPrifix(sParam2, "sheet4_");
						sParam = sParam + "&" + sParam1 + "&" + sParam2;
					}
					
					formObj.tmp_bl_src_no.value = "";
					
					ComOpenWait(true); 
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0022GS.do", sParam );

					if (sXml.indexOf("ERROR") < 1){
						var arIfNo = ComGetEtcData(sXml,"ar_if_no");
						var slpNo = ComGetEtcData(sXml,"slp_no");
						
						sheetObj.LoadSaveXml(sXml);

						ComOpenWait(false); 
						
						if (arIfNo != undefined) {
							formObj.view_ar_if_no.value = arIfNo;
							formObj.view_ar_ofc_cd.value = arrStr2[1];
							formObj.ar_if_no.value = arIfNo;
						} else {
							formObj.view_ar_if_no.value = "";
							formObj.view_ar_ofc_cd.value = "";
							formObj.ar_if_no.value = "";
						}
						
						if (slpNo != undefined) {
							formObj.slp_no.value = slpNo;
						} else {
							formObj.slp_no.value = "";
						}
						
						if (arIfNo != '' && slpNo != '') {
							formObj.view_yn.value = "Y";
							
							formObj.view_ar_ofc_cd.value = formObj.ar_ofc_cd.text;
							
							loadPage();

//							formObj.pagetype.value = "I";
//							//타이틀을 변경해준다.
//							document.title = "Other Revenue Invoice";
//							document.getElementById("title").innerHTML = "&nbsp;&nbsp;Other Revenue Invoice";
//							
//							formObj.ar_ofc_cd.text = formObj.view_ar_ofc_cd.value;
//							formObj.ofc_cd.value = formObj.view_ar_ofc_cd.value;
//							formObj.ar_if_no.value = formObj.view_ar_if_no.value;
//							
//							// 조회조건 초기화
//							setSearchValueType();
//							
//							// cr 그리드 비활성화
//							for(var i=sheetObj.rowCount; i>0; i--){
//								sheetObj.RowEditable(i) = false;
//							}
						}
						
						if (formObj.ots_smry_cd.value == 'INV' && formObj.inv_no.value == '') {
							ComBtnEnable("btn_create");
						} else {
							ComBtnDisable("btn_create");
						}

						ComShowCodeMessage("INV00051");		// 저장 성공
					}
					else {
						ComOpenWait(false);
						
						ComShowCodeMessage("INV00053");		// 저장 실패
					}
				}
			break;
			
			case IBINSERT:        //inv no creation
				if(validateForm(sheetObj,formObj,sAction)) {
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ofc_cd.value = arrStr2[1];
					
					formObj.f_cmd.value = MULTI02;
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObjects[0].GetSaveString(true);
					var sParam2 = sheetObjects[3].GetSaveString();
					
					if (sParam1 == "") {
						return;
					}
					else {
						sParam1 = ComSetPrifix(sParam1, "sheet1_");
						sParam2 = ComSetPrifix(sParam2, "sheet4_");
						sParam = sParam + "&" + sParam1 + "&" + sParam2;
					}
					
					formObj.tmp_bl_src_no.value = "";
					
					ComOpenWait(true);
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0022GS.do", sParam );
					
					if (sXml.indexOf("ERROR") < 1){
						var invNo = ComGetEtcData(sXml,"inv_no");
						
						if (invNo != undefined) {
							formObj.inv_no.value = invNo;
						} else {
							formObj.inv_no.value = "";
						}
						
						ComBtnDisable("btn_create");
						
						ComOpenWait(false);

						ComShowCodeMessage("INV00051");
					}
					else {
						ComOpenWait(false);
						
						ComShowCodeMessage("INV00053");
					}
				}
			break;

			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
	 			formObj.f_cmd.value = SEARCH05;
	 			var sXml = sheetObj.GetSearchXml("FNS_INV_0022GS.do", FormQueryString(formObj));
			
	 			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	 			var arrStr = sStr.split("|");
	 			//office
	 			MakeComboObject(formObj.ar_ofc_cd, arrStr);
	 			
	 			var arrStr2 = arrStr[1].split("^");
	 			var ar_ofc_cd = arrStr2[3];

	 			// 로그인한 사용자의  office 정보를 가져온다.
	 			var ofcStr;
	 			var ofcStr2;
	 			
	 			for (var i=0; i < arrStr.length; i++) {
	 				var sStr9 = arrStr[i].split("^");
	 				if (sStr9[1] == ar_ofc_cd) {
	 					ofcStr = arrStr[i]
	 				}
	 			}
	 			var ofcStr2 = ofcStr.split("^");
	 			
	 			//tax
				MakeComboObject3(formObj.ar_tax_ind_cd, ofcStr2[6].substring(0,2));
	 			
	            var sStr2 = ComGetEtcData(sXml,"currInfo");
				arrCurrInfo = sStr2.split("|");
				//currency
				MakeComboObject2(formObj.curr_cd, arrCurrInfo);

				var sStr9 = ComGetEtcData(sXml,"dpPrcsKnt");
				arrDpPrcsKnt = sStr9.split("|");
				
				var sStr3 = ComGetEtcData(sXml,"acct_cd");
				var sStr4 = ComGetEtcData(sXml,"acct_eng_nm");
				var sStr5 = ComGetEtcData(sXml,"acct_krn_nm");
				var sStr6 = ComGetEtcData(sXml,"rev_cd");
				var sStr7 = ComGetEtcData(sXml,"chg_cd");
				var sStr8 = ComGetEtcData(sXml,"rep_chg_cd");
				
				// acccount code 값 전역변수에 세팅
				arrAcctCd    = sStr3.split("|");
				arrAcctEngNm = sStr4.split("|");
				arrAcctKrnNm = sStr5.split("|");
				arrRevCd     = sStr6.split("|");
				arrChgCd     = sStr7.split("|");
				arrRepChgCd  = sStr8.split("|");
				
	 			formObj.ar_ofc_cd.text = ofcStr2[3];
	 			formObj.curr_cd.text = ofcStr2[4];

	 			formObj.office_cnt_cd.value = ofcStr2[6].substring(0,2);
	 			formObj.lcl_curr.value = ofcStr2[4];
	 			formObj.tax_curr_cd.value = ofcStr2[4];
	 			formObj.total_curr_cd.value = ofcStr2[4];
	 			formObj.pol_cd.value = ofcStr2[6];
	 			formObj.svr_id.value = ofcStr2[7];
	 			formObj.ots_smry_cd.value = ofcStr2[13];
	 			formObj.inv_vat_chg_cd.value = ofcStr2[16];
	 			formObj.inv_vat_chg_rt.value = ofcStr2[17];
	 			
	 			formObj.inv_xch_rt.value = "1.000000";
	 			
	 	    	var currPoint = getDpPrcsKnt(ofcStr2[4],arrDpPrcsKnt);
	 	    	// local 화폐 자릿수 세팅
	 	    	formObj.lcl_curr_point.value = currPoint;
	 	    	formObj.curr_point.value = currPoint;
	 			
	 			// 한국인 경우 tax 부분을 보여준다. ofcStr2[6] : office의 LOC_CD
	 			if (ofcStr2[6].substring(0,2) == "KR" || ofcStr2[6].substring(0,2) == "HQ") {
	 				document.getElementById('taxDiv1').style.display = "block";
	 				document.getElementById('taxDiv2').style.display = "none";
	 			}
	 			else {
	 				document.getElementById('taxDiv1').style.display = "none";
	 				document.getElementById('taxDiv2').style.display = "block";
	 			}
	 			
	 			// ots_smry_cd가  'INV'인 경우 보여준다.
	 			if (ofcStr2[13] == "INV") {
	 				document.getElementById('invNoDiv').style.display = "block";
	 			}
	 			else {
	 				document.getElementById('invNoDiv').style.display = "none";
	 			}
	 			
			break;
			
			case IBSEARCH_ASYNC11: // 경리환율 조회
				formObj.f_cmd.value = SEARCH06;
				// OFFICE
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	 			formObj.ofc_cd.value = arrStr2[1];
			
				var sXml = sheetObj.GetSearchXml("FNS_INV_0022GS.do", FormQueryString(formObj));	
				
				var usdLoclXchRt = ComGetEtcData(sXml,"usd_locl_xch_rt");
				if (usdLoclXchRt != undefined) {
					// amount의 cuur_cd가 있는 경우에만 값을 세팅한다.
					if (formObj.curr_cd.text != '') {
						formObj.usd_locl_xch_rt.value = usdLoclXchRt;
						formObj.inv_xch_rt.value = usdLoclXchRt;
					}
				}
				else {
					ComShowMessage(ComGetMsg('INV00015'));
					formObj.eff_dt.value = "";
					formObj.eff_dt.focus();
				}
			break;
			
			case IBSEARCH_ASYNC12: // auto BL No 조회
				var tmpBlSrcNo = formObj.tmp_bl_src_no.value;
				var arOfcCd = "";
				var arHdQtrOfcCd = "";
				
				if (tmpBlSrcNo == '') {
					formObj.f_cmd.value = MULTI01;
					// OFFICE Info
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					arHdQtrOfcCd = arrStr2[0];
					arOfcCd = arrStr2[1];
					
		 			formObj.ofc_cd.value = arOfcCd;
		 			
					var sXml = sheetObj.GetSaveXml("FNS_INV_0022GS.do", FormQueryString(formObj));
					
					var blMaxSeq = ComGetEtcData(sXml,"bl_max_seq");
					if (blMaxSeq != undefined) {
						// 단, RHQ가 'SELHO'인 OFC는 OFC 앞 3자리 대신 뒤 3자리로 생성한다(예 : OFC = SELPIO → BL NO = PIO090828001)
						if (arHdQtrOfcCd == 'SELHO') {
							blMaxSeq = arOfcCd.substring(3)+blMaxSeq.substring(3);
						}
						
						formObj.bl_src_no.value = blMaxSeq;
						formObj.tmp_bl_src_no.value = blMaxSeq;
						formObj.eff_dt.focus();
					}
					else {
						ComShowMessage(ComGetMsg('INV00095'));
					}
				}
				else {
					formObj.bl_src_no.value = tmpBlSrcNo;
					formObj.eff_dt.focus();
				}
			break;
			
			case IBSEARCH_ASYNC14: // 화면 로딩시 AR Office 조회
	 			formObj.f_cmd.value = SEARCH05;
				
	 			var sXml = sheetObj.GetSearchXml("FNS_INV_0022GS.do", FormQueryString(formObj));
			
	 			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	 			var arrStr = sStr.split("|");
	 			//office
	 			MakeComboObject(formObj.ar_ofc_cd, arrStr);
	 			
	 			var arrStr2 = arrStr[1].split("^");
	 			
	 			var ar_ofc_cd = formObj.view_ar_ofc_cd.value;

	 			// 로그인한 사용자의  office 정보를 가져온다.
	 			var ofcStr;
	 			var ofcStr2;
	 			
	 			for (var i=0; i < arrStr.length; i++) {
	 				var sStr9 = arrStr[i].split("^");
	 				if (sStr9[1] == ar_ofc_cd) {
	 					ofcStr = arrStr[i]
	 				}
	 			}
	 			
	 			var ofcStr2 = ofcStr.split("^");
	 			
	 			//tax
				MakeComboObject3(formObj.ar_tax_ind_cd, ofcStr2[6].substring(0,2));
	 			
	            var sStr2 = ComGetEtcData(sXml,"currInfo");
				arrCurrInfo = sStr2.split("|");
				//currency
				MakeComboObject2(formObj.curr_cd, arrCurrInfo);

				var sStr9 = ComGetEtcData(sXml,"dpPrcsKnt");
				arrDpPrcsKnt = sStr9.split("|");
				
				var sStr3 = ComGetEtcData(sXml,"acct_cd");
				var sStr4 = ComGetEtcData(sXml,"acct_eng_nm");
				var sStr5 = ComGetEtcData(sXml,"acct_krn_nm");
				var sStr6 = ComGetEtcData(sXml,"rev_cd");
				var sStr7 = ComGetEtcData(sXml,"chg_cd");
				var sStr8 = ComGetEtcData(sXml,"rep_chg_cd");
				
				// acccount code 값 전역변수에 세팅
				arrAcctCd    = sStr3.split("|");
				arrAcctEngNm = sStr4.split("|");
				arrAcctKrnNm = sStr5.split("|");
				arrRevCd     = sStr6.split("|");
				arrChgCd     = sStr7.split("|");
				arrRepChgCd  = sStr8.split("|");
				
	 			formObj.office_cnt_cd.value = ofcStr2[6].substring(0,2);
				
	 			// 한국인 경우 tax 부분을 보여준다.
	 			if (ofcStr2[6].substring(0,2) == "KR" || ofcStr2[6].substring(0,2) == "HQ") {
	 				document.getElementById('taxDiv1').style.display = "block";
	 				document.getElementById('taxDiv2').style.display = "none";
	 			}
	 			else {
	 				document.getElementById('taxDiv1').style.display = "none";
	 				document.getElementById('taxDiv2').style.display = "block";
	 			}
	 			
	 			// ots_smry_cd가  'INV'인 경우 보여준다.
	 			if (ofcStr2[13] == "INV") {
	 				document.getElementById('invNoDiv').style.display = "block";
	 			}
	 			else {
	 				document.getElementById('invNoDiv').style.display = "none";
	 			}
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.cust_cnt_cd, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
			break;
			
			case IBSEARCH_ASYNC15: // B/L No를 이용하여 해당 customer 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH07;
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0022GS.do", FormQueryString(formObj));
				
				var cust_cnt_cd = ComGetEtcData(sXml,"cust_cnt_cd");
				var cust_seq = ComGetEtcData(sXml,"cust_seq");
				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
				var delt_flg = ComGetEtcData(sXml,"delt_flg");
				
				if (cust_nm != undefined && delt_flg != undefined) {
					if (delt_flg != 'Y') {
						formObj.cust_cnt_cd.value = cust_cnt_cd;
						formObj.cust_seq.value = ComLpad(cust_seq, 6, '0');;
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_cnt_cd.value = "";
						formObj.cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				} else {
					formObj.cust_cnt_cd.value = "";
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
			break;
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
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:      //조회
				with(formObj){
					if(ar_if_no.value == "") {
						ComShowCodeMessage("INV00004");
						ar_if_no.focus();
						return false;
					 }
					
					if(ar_ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ar_ofc_cd.focus();
						return false;
					 }
				}
    		break;
    		case IBSEARCH_ASYNC11:      //경리환율 조회
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(eff_dt.text == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						cust_seq.focus();
						return false;
					}
					if(inv_rmk.value == "") {
						ComShowCodeMessage("INV00004");
						inv_rmk.focus();
						return false;
					}
				}
			break;
    		case IBSEARCH_ASYNC13:      //Row Add 버튼 클릭시.
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					
					if(eff_dt.value == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					 }
					
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					 }
					
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					 }
					
					if(cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						cust_seq.focus();
						return false;
					 }
					
					if(amount.value == "") {
						ComShowCodeMessage("INV00004");
						amount.focus();
						return false;
					}

					if(inv_xch_rt.value == "") {
						ComShowCodeMessage("INV00004");
						inv_xch_rt.focus();
						return false;
					}
				}
			break;
    		case IBSAVE:      //저장
    			with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(eff_dt.text == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						cust_seq.focus();
						return false;
					}
					if(inv_rmk.value == "") {
						ComShowCodeMessage("INV00073");
						inv_rmk.focus();
						return false;
					}
					if(lcl_vvd.value == "") {
						ComShowCodeMessage("INV00004");
						lcl_vvd.focus();
						return false;
					}
					
					// 경리환율 존재여부 Check
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC11);
					
					//DR SUM과 CR SUM 비교
    				if(ComReplaceStr(sheetObjects[1].SumValue(0, "local_total"),"-","") != ComReplaceStr(sheetObjects[2].SumValue(0, "chg_amt"),"-","")) {
						ComShowCodeMessage("INV00064");
						return false;
					}
				}
			break;
    		case IBINSERT:      //inv no creation
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
					if(eff_dt.text == "") {
						ComShowCodeMessage("INV00004");
						eff_dt.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						cust_seq.focus();
						return false;
					}
					if(inv_rmk.value == "") {
						ComShowCodeMessage("INV00073");
						inv_rmk.focus();
						return false;
					}
				}
    		break;
    	}
		return true;
	}

	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length; i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			
			if (ar_ofc_cd != '') {
				cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
				
				// (예외사항:  AR Office가 'FXTSC', 'SELAGG' 인 경우는 필드 활성화하고 List에는 'FXTSC'는 'FXTSC', 'LONBC1' 만 
				// 'SELAGG'인 경우는'SELAGG','SELBC1' 만 나오도록 한다.)
				if (ar_ofc_cd == 'FXTSC') {
					var StrLon = "HAMRU^LONBC1^B^"+arrStr2[3]+"^GBP^N^GBLON^EUR^N^2^GB^720";
					
					cmbObj.InsertItem(i, 'LONBC1', StrLon);
				}
				if (ar_ofc_cd == 'SELAGG') {
					var StrLon = "SELHO^SELBC1^B^"+arrStr2[3]+"^KRW^N^KRSEL^KOR^N^0^KR^43366";
					
					cmbObj.InsertItem(i, 'SELBC1', StrLon);
				}
			}
		}
		cmbObj.BackColor = "#CCFFFD";
	}
	
	/** 
	 * currency select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		//cmbObj.InsertItem(0, "|", "");
		for (var i = 1; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
	}

	/** 
	 * 국적에 따른 Tax select box 내용 수정 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function MakeComboObject3(cmbObj, cntCd) {
		var arrStr1 = "";
		var arrStr2 = "";
		
	//	if (cntCd == "KR" || cntCd == "HQ") {
	//		arrStr1 = ",0%,10%,N";
	//		arrStr2 = ",0,10,N";
	//	}
	//	else {
			arrStr1 = ",0%,10%";
			arrStr2 = ",0,10";
	//	}
		
		var arrStrSpl1 = arrStr1.split(",");
		var arrStrSpl2 = arrStr2.split(",");
		
		cmbObj.RemoveAll(); 
		for (var i = 1; i < arrStrSpl1.length;i++ ) {
			cmbObj.InsertItem(i-1, arrStrSpl1[i], arrStrSpl2[i]);
		}
		
		cmbObj.text = "";
		cmbObj.BackColor = "#CCFFFD";
	}
	
	/** 
	 * 그리드내 콤보필드에 데이터를 추가해준다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj  
	 * @param  {object} colName
	 * @param  {IBMultiCombo} isCellCombo
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function addCellComboItem(sheetObj,colName,isCellCombo) {
    	var sRow = sheetObj.SelectRow;
    	var formObj = document.form;
    	var viewYn = formObj.view_yn.value;
    	var officeCd = formObj.ar_ofc_cd.text;
    	var officeCntCd = formObj.office_cnt_cd.value;

		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
	    var comboVal = "";
	    
		for (var i = 0; i < arrAcctCd.length;i++ ) {
			if (arrAcctCd[i] != "") {
				// 조회성화면인 경우 전체 내용을 보여준다.
				if (viewYn == "Y") {
					if (officeCntCd == "KR" || officeCntCd == "HQ") {
						comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i]+"\t"+arrAcctKrnNm[i];
						comboVal += arrAcctCd[i];
						
						if (i < arrAcctCd.length-1) {
							comboTxt += ROWMARK;
							comboVal += ROWMARK;
						}
					}
					else {
						comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i];
						comboVal += arrAcctCd[i];
						
						if (i < arrAcctCd.length-1) {
							comboTxt += ROWMARK;
							comboVal += ROWMARK;
						}
					}
				}
				// 입력성화면인 경우 한국국적인 경우에만 '710111' 계정을 보여준다.
				else {
					if (officeCntCd == "KR" || officeCntCd == "HQ") {
						if (arrAcctCd[i] == "710111") {
							if (officeCd == "SELADG" || officeCd == "SELTBB") {
								comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i]+"\t"+arrAcctKrnNm[i];
								comboVal += arrAcctCd[i];
								
								if (i < arrAcctCd.length-1) {
									comboTxt += ROWMARK;
									comboVal += ROWMARK;
								}
							}
						}else if(arrAcctCd[i] == "411991"){
							if (officeCd == "PUSMPG"){
								
								comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i]+"\t"+arrAcctKrnNm[i];
								comboVal += arrAcctCd[i];
								
								if (i < arrAcctCd.length-1) {
									comboTxt += ROWMARK;
									comboVal += ROWMARK;
								}
							}
						}else {
							comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i]+"\t"+arrAcctKrnNm[i];
							comboVal += arrAcctCd[i];
							
							if (i < arrAcctCd.length-1) {
								comboTxt += ROWMARK;
								comboVal += ROWMARK;
							}
						}
					}
					else {
						if (arrAcctCd[i] != "710111" && arrAcctCd[i] != "411991") {
							comboTxt += arrAcctCd[i]+"\t"+arrAcctEngNm[i];
							comboVal += arrAcctCd[i];
							
							if (i < arrAcctCd.length-1) {
								comboTxt += ROWMARK;
								comboVal += ROWMARK;
							}
						}
					}
				}
			}
			else {
				comboTxt += " \t ";
				comboVal += " ";
				
				if (i < arrAcctCd.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}
			}
		}
		
		//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal, "", "", 0);
		}
	}
    
	/** 
	 * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObj = document.form;
		
		formObj.cust_cnt_cd.value = colArray[8];
		formObj.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value = colArray[4];
	}
	
	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function removeAll(formObj) {
		document.title = "Other Revenue Invoice Creation";
		document.getElementById("title").innerHTML = "&nbsp;&nbspOther Revenue Invoice Creation";

		formObj.reset();
	 	
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		// 조회조건 초기화
		setSearchValueType();
	}
	
    /** 
	 * 조회조건에 따른 입력항목 활성상태 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 입력[E]시와 조회[I]시에 따라 각 입력항목의 활성화 상태와 버튼의 표시여부를 세팅한다.
	 * </pre>
	 * @param   없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function setSearchValueType() {
		var formObj = document.form;

		if (formObj.view_ar_if_no.value == '' && formObj.view_ar_ofc_cd.value == '') {

			ComEnableObject(formObj.bl_src_no,true);
			ComEnableObject(formObj.eff_dt,true);
			ComEnableObject(formObj.cust_cnt_cd,true);
			ComEnableObject(formObj.cust_seq,true);
			ComEnableObject(formObj.amount,true);
			ComEnableObject(formObj.inv_xch_rt,true);
			ComEnableObject(formObj.inv_rmk,true);
			ComEnableObject(formObj.lcl_vvd,true);
			
			formObj.bl_src_no.className = "input1";
			formObj.bl_src_no.tabIndex = "";
			formObj.eff_dt.className = "input1";
			formObj.eff_dt.tabIndex = "";
			formObj.cust_cnt_cd.className = "input1";
			formObj.cust_cnt_cd.tabIndex = "";
			formObj.cust_seq.className = "input1";
			formObj.cust_seq.tabIndex = "";
			formObj.amount.className = "input1";
			formObj.amount.tabIndex = "";
			formObj.inv_xch_rt.className = "input";
			formObj.inv_xch_rt.tabIndex = "";
			formObj.inv_rmk.className = "input1";
			formObj.inv_rmk.tabIndex = "";
			formObj.lcl_vvd.className = "input1";
			formObj.lcl_vvd.tabIndex = "";

			formObj.ar_ofc_cd.Enable = true;
			formObj.curr_cd.Enable = true;
			formObj.ar_tax_ind_cd.Enable = true;
		
			if(formObj.ar_ofc_cd.text == "LEHSC"){
				ComEnableObject(formObj.lehbb_vat_rate,true);
			} 
//			else {
//				ComEnableObject(formObj.lehbb_vat_rate,false);
//			}
			
			ComEnableObject(formObj.ar_if_no,false);
			formObj.ar_if_no.className = "input2";
			formObj.ar_if_no.tabIndex = "-1";
			
			ComBtnEnable("btn_auto");
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_print1");
			ComBtnDisable("btn_print2");
			ComBtnDisable("btn_create");
	
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_copy");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btns_calendar");
			ComBtnEnable("btns_cust2");
			
			formObj.bl_src_no.focus();
			
	    	// Amount의 curr가 local curr와 동일시에는 환율 1로 고정하고 비활성화 한다.
	    	var currCdStr = formObj.curr_cd.text;
	    	var lclCurrStr =  formObj.lcl_curr.value;
	    	if (currCdStr == lclCurrStr) {
	    		ComEnableObject(formObj.inv_xch_rt,false);
	    	}
	    	else {
	    		ComEnableObject(formObj.inv_xch_rt,true);
	    	}
		}
		else {
			ComEnableObject(formObj.bl_src_no,false);
			ComEnableObject(formObj.eff_dt,false);
			ComEnableObject(formObj.cust_cnt_cd,false);
			ComEnableObject(formObj.cust_seq,false);
			ComEnableObject(formObj.amount,false);
			if (formObj.inv_xch_rt.className == 'input') {
				ComEnableObject(formObj.inv_xch_rt,false);
			}
			else {
				formObj.inv_xch_rt.className = "input2";
				formObj.inv_xch_rt.tabIndex = "";
			}
			ComEnableObject(formObj.inv_rmk,false);
			ComEnableObject(formObj.lcl_vvd,false);

			formObj.ar_ofc_cd.Enable = false;
			formObj.curr_cd.Enable = false;
			formObj.ar_tax_ind_cd.Enable = false;
			
			if(formObj.ar_ofc_cd.text == "LEHSC"){
				ComEnableObject(formObj.lehbb_vat_rate,false);
			}
			
			ComBtnDisable("btn_auto");
			ComBtnDisable("btn_save");
			
			ComBtnEnable("btn_print1");
			ComBtnEnable("btn_print2");
			
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_copy");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btns_calendar");
			ComBtnDisable("btns_cust2");
		}
	}
	
	/** 
	 * Office AR Currency 경리환율 조회<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function getLoclXchRt() {
		var sheetObj = sheetObjects[0];
		var rowCnt = sheetObj.RowCount;
		
		var formObj = document.form;
		var officeCd = formObj.ar_ofc_cd.text;
		var rtnValue = false;
		
		//GL_EFF_DT와 LOCL_CURR_CD가 입력된 경우에만 경리환율을 체크한다.
		if (formObj.eff_dt.value != '' && formObj.lcl_curr.value != '') {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC11);
			
			var glEffDt = ComReplaceStr(formObj.eff_dt.value,"-","");
			if (glEffDt != '') {
				var lclVvd = "";
				var acctCnt = 0;
				for(var j = 1; j <= rowCnt; j++){
					if (sheetObj.CellValue(j, "acct_cd") == "411911" || sheetObj.CellValue(j, "acct_cd") == "411915" || sheetObj.CellValue(j, "acct_cd") == "710111") {
						acctCnt++;
					}
				}
				
				if (acctCnt > 0) {
					lclVvd = "CNTC"+glEffDt.substring(2,6)+"M";
				}
				else {
					lclVvd = "COMC"+glEffDt.substring(2,6)+"M";
				}
				
				formObj.lcl_vvd.value = lclVvd;
				rtnValue = true;
			}
			
			if (formObj.inv_xch_rt.value == '') {
				ComShowMessage(ComGetMsg('INV00001'));
				rtnValue = false;
			}
		}

		return rtnValue;
	}
	
	/** 
	 * Amount 계산<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function calLocalAmount() {
		var formObj = document.form;
		var rtnValue = false;
		var currPoint = formObj.curr_point.value;
		var lclCurrPoint = formObj.lcl_curr_point.value;

		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			var amount = ComReplaceStr(formObj.amount.value,",","");
			var xchRate = ComReplaceStr(formObj.inv_xch_rt.value,",","");
			var tax = formObj.ar_tax_ind_cd.Code;
			
			var localAmount;
			var taxAmount;
			
			formObj.amount.value = setCurrPointValue(ComRound(parseFloat(amount),currPoint), currPoint);
			
			//1. Local Amount 계산 (음수계산시 반올림은 양수로 반올림 후 다시 음수로 변경해줘야 정상임)
			localAmount = parseFloat(amount) * parseFloat(xchRate);
			var sign = 1;
			if(localAmount<0){
				sign=-1
			}
			
			localAmount=  localAmount*sign;
			localAmount = ComRound(localAmount,lclCurrPoint);
			localAmount =  localAmount*sign;
			
			formObj.local_amount.value = setCurrPointValue(ComRound(localAmount,lclCurrPoint), lclCurrPoint);
			
			//2. Tax 계산
			if (localAmount != '0' && tax != '') {
				var taxRate = "";
				if (tax == '0') {
					formObj.tax_amount_ori.value = setCurrPointValue(ComRound("0", lclCurrPoint), lclCurrPoint);
					formObj.tax_amount.value = setCurrPointValue(ComRound("0", lclCurrPoint), lclCurrPoint);
				}
				else if (tax == '10' || tax == 'N') {
					taxAmount = parseFloat(localAmount) / 10;
					
					if(taxAmount > 0){
						formObj.tax_amount_ori.value = setCurrPointValue(ComRound(taxAmount, lclCurrPoint), lclCurrPoint);
						formObj.tax_amount.value = setCurrPointValue(ComRound(taxAmount, lclCurrPoint), lclCurrPoint);
					} else {
						formObj.tax_amount_ori.value = setCurrPointValue(ComRound((-1)*(taxAmount), lclCurrPoint)*(-1), lclCurrPoint);
						formObj.tax_amount.value = setCurrPointValue(ComRound((-1)*(taxAmount), lclCurrPoint)*(-1), lclCurrPoint);
					}
				}
			}
			else {
				formObj.tax_amount_ori.value = setCurrPointValue(ComRound("0", lclCurrPoint), lclCurrPoint);
				formObj.tax_amount.value = setCurrPointValue(ComRound("0", lclCurrPoint), lclCurrPoint);
			}
			//3. Local Total 계산
			formObj.total_local_amt.value = setCurrPointValue(ComRound(Number(ComReplaceStr(formObj.local_amount.value,",","")) + Number(ComReplaceStr(formObj.tax_amount.value,",","")), lclCurrPoint), lclCurrPoint);

			rtnValue = true;
		}
		else {
			currPoint = "0";
			
			formObj.local_amount.value = setCurrPointValue("0", lclCurrPoint);
			formObj.tax_amount_ori.value = setCurrPointValue("0", lclCurrPoint);
			formObj.tax_amount.value = setCurrPointValue("0", lclCurrPoint);
			formObj.total_local_amt.value = setCurrPointValue("0", lclCurrPoint);
			
			rtnValue = false;
		}
		
		return rtnValue;
	}
	
	/** 
	 * cr 그리드 변경시 Amount 계산<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function calLocalAmount2() {
		var formObj = document.form;
		var rtnValue = false;
		var currPoint = formObj.curr_point.value;
		var lclCurrPoint = formObj.lcl_curr_point.value;
		
		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			var amount = ComReplaceStr(formObj.amount.value,",","");
			var xchRate = ComReplaceStr(formObj.inv_xch_rt.value,",","");
			var tax = formObj.ar_tax_ind_cd.Code;
			
			formObj.amount.value = setCurrPointValue(ComRound(amount,currPoint), currPoint);
			
			//3. Local Total 계산
			formObj.total_local_amt.value = setCurrPointValue(ComRound(Number(ComReplaceStr(formObj.local_amount.value,",","")) + Number(ComReplaceStr(formObj.tax_amount.value,",","")), lclCurrPoint), lclCurrPoint);
			
			rtnValue = true;
		}
		else {
			currPoint = "0";
			
			formObj.local_amount.value = setCurrPointValue("0", lclCurrPoint);
			formObj.tax_amount.value = setCurrPointValue("0", lclCurrPoint);
			formObj.total_local_amt.value = setCurrPointValue("0", lclCurrPoint);
			
			rtnValue = false;
		}
		
		return rtnValue;
	}
	 
	/** 
	 * cr 그리드 변경시 TVA Amount 계산<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function calTVAAmount(sheetObj, formObj) {
		var rtnValue = false;
		var invVatChgCd = formObj.inv_vat_chg_cd.value;
		var invVatChgRt = formObj.inv_vat_chg_rt.value;
		var currPoint = formObj.curr_point.value;
		var lclCurrPoint = formObj.lcl_curr_point.value;
		var invXchRt = formObj.inv_xch_rt.value;
		var officeCntCd = formObj.office_cnt_cd.value;
		
		var tvaFlgCnt = 0;		// 그리드안에 TVA 체크박스를 선택한 항목의 갯수
		var taxInfoCnt = 0;		// 그리드안에 TVA로 인하여 생성된 212111 항목의 갯수
		var totalChgAmt = 0;
		var taxChgAmt = 0;
		
		// 금액 계산 & 그리드안에 TVA로 생성된 212111 항목이 있는지 확인한다.
		for(var i=sheetObj.rowCount; i>0; i--){
			if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd") == "212111" && sheetObj.CellValue(i, "tax_yn") == "T") {
				taxInfoCnt ++;
			}
			
			if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "tva_flg") == "1") {
				tvaFlgCnt ++;
				
				if (sheetObj.CellValue(i, "chg_amt") != "") {
					totalChgAmt += ComReplaceStr(parseFloat(sheetObj.CellValue(i, "chg_amt")),",","");
				}
			}
		}
	
		taxChgAmt = totalChgAmt * invXchRt * invVatChgRt / 100;
	
		// 그리드에 tva 체크박스를 선택한 정보가 있으면서 212111의 정보가 없는 경우 그리드에 줄 생성
		if (tvaFlgCnt > 0 && taxInfoCnt == 0) {
			document.getElementById('taxDiv1').style.display = "block";
			document.getElementById('taxDiv2').style.display = "none";
			formObj.ar_tax_ind_cd.Enable = false;
			
			sheetObj.DataInsert(-1);
			
			//if (lclCurrPoint == '0') {
			//	sheetObj.InitCellProperty(sheetObj.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
			if (currPoint == '0') {
					sheetObj.InitCellProperty(sheetObj.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
			}
			else {
				sheetObj.InitCellProperty(sheetObj.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
			}
			
			addCellComboItem(sheetObj,'acct_cd',true);
			
			sheetObj.CellValue(sheetObj.SelectRow, "acct_cd")     = "212111";
			sheetObj.CellValue(sheetObj.SelectRow, "chg_full_nm") = "V.A.T. RECEIVED";
			sheetObj.CellValue(sheetObj.SelectRow, "cust_code")   = formObj.cust_cnt_cd.value + formObj.cust_seq.value ;
			sheetObj.CellValue(sheetObj.SelectRow, "city")        = formObj.pol_cd.value;
			sheetObj.CellValue(sheetObj.SelectRow, "curr_cd")     = formObj.lcl_curr.value;
			sheetObj.CellValue2(sheetObj.SelectRow, "chg_amt")    = taxChgAmt;
			sheetObj.CellValue(sheetObj.SelectRow, "chg_rmk")     = "";
			sheetObj.CellValue(sheetObj.SelectRow, "inv_rev_tp_src_cd") = "XXX";
			sheetObj.CellValue(sheetObj.SelectRow, "chg_cd")      = invVatChgCd;
			sheetObj.CellValue(sheetObj.SelectRow, "rep_chg_cd")  = "SLC";
			sheetObj.CellValue(sheetObj.SelectRow, "inv_xch_rt")  = "1";
			sheetObj.CellValue(sheetObj.SelectRow, "tax_yn")      = "T";
			sheetObj.CellValue(sheetObj.SelectRow, "mnl_flg")     = "N";
			
			sheetObj.CellEditable(sheetObj.SelectRow, "acct_cd") = false;
			sheetObj.CellEditable(sheetObj.SelectRow, "chg_amt") = false;
			sheetObj.CellEditable(sheetObj.SelectRow, "chg_rmk") = false;
			sheetObj.CellEditable(sheetObj.SelectRow, "tva_flg") = false;
			
			formObj.tax_amount.value = setCurrPointValue(ComRound(Number(ComReplaceStr(taxChgAmt,",","")), lclCurrPoint), lclCurrPoint);
			formObj.total_local_amt.value = setCurrPointValue(ComRound(Number(ComReplaceStr(formObj.local_amount.value,",","")) + Number(ComReplaceStr(formObj.tax_amount.value,",","")), lclCurrPoint), lclCurrPoint);
		}
		else if (tvaFlgCnt > 0 && taxInfoCnt > 0) {
			for(var i=sheetObj.rowCount; i>0; i--){
				if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")=="212111" && sheetObj.CellValue(i, "tax_yn") == "T") {
					sheetObj.CellValue2(i, "chg_amt") = taxChgAmt;
				}
			}

			formObj.tax_amount.value = setCurrPointValue(ComRound(Number(ComReplaceStr(taxChgAmt,",","")), lclCurrPoint), lclCurrPoint);
			formObj.total_local_amt.value = setCurrPointValue(ComRound(Number(ComReplaceStr(formObj.local_amount.value,",","")) + Number(ComReplaceStr(formObj.tax_amount.value,",","")), lclCurrPoint), lclCurrPoint);
		}
		else {
			if (officeCntCd != "KR" && officeCntCd != "HQ") {
				document.getElementById('taxDiv1').style.display = "none";
				document.getElementById('taxDiv2').style.display = "block";
			}
			
			for(i=sheetObj.rowCount; i>0; i--){
				if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")=="212111" && sheetObj.CellValue(i, "tax_yn")=="T") {
					sheetObj.RowDelete(i, false);
				}
			}
			
			formObj.tva_amount.value = 0;
			formObj.total_local_amt.value = setCurrPointValue(ComRound(Number(ComReplaceStr(formObj.local_amount.value,",","")) + Number(ComReplaceStr(formObj.tax_amount.value,",","")), lclCurrPoint), lclCurrPoint);
		}
	}
	
	/** 
	 * CR Detail 그리드 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} gridType  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function dtlGridSet(gridType) {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		var currPoint = formObj.curr_point.value;
		var lclCurrPoint = formObj.lcl_curr_point.value;
		var officeCntCd = formObj.office_cnt_cd.value;
		
		//dr부분의 금액이 수정될 경우
		if (gridType == 'amount') {
			if (officeCntCd == "KR" || officeCntCd == "HQ") {
				//ar_tax_ind_cd가 '10%','N' 인 경우는 CR그리드에 212111 계정이 있는지 확인하고 없을 경우 만들어준다. 
				if (formObj.ar_tax_ind_cd.Code == "10" || formObj.ar_tax_ind_cd.Code == "N") {
					var taxInfoCnt = 0;
					
					// 그리드안에 212111 항목이 있는지 확인한다.
					for(var i=sheetObj.rowCount; i>0; i--){
						if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")=="212111" && sheetObj.CellValue(i, "tax_yn")=="Y") {
							taxInfoCnt ++;
						}
					}
					
					// tax가 있으면서 amount가 변할 경우 해당 그리드 212111 항목의 amount값을 수정한다.
					if (taxInfoCnt > 0) {
						if(sheetObj.CellValue(1, "ibflag") != "" && sheetObj.CellValue(1, "acct_cd")=="212111" && sheetObj.CellValue(1, "tax_yn")=="Y") {
							sheetObj.CellValue2(1, "chg_amt") = formObj.tax_amount.value;
						}
					}
					// tax가 있으면서 amount가 변하고 212111항목이 없는경우 해당 그리드에 추가한다.
					else {
						sheetObj.DataInsert(0);
						
						sheetObj.InitCellProperty(sheetObj.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
						
						addCellComboItem(sheetObj,'acct_cd',true);
						
						sheetObj.CellValue(sheetObj.SelectRow, "acct_cd")     = "212111";
						sheetObj.CellValue(sheetObj.SelectRow, "chg_full_nm") = "V.A.T. RECEIVED";
						sheetObj.CellValue(sheetObj.SelectRow, "cust_code")   = formObj.cust_cnt_cd.value + formObj.cust_seq.value ;
						sheetObj.CellValue(sheetObj.SelectRow, "city")        = formObj.pol_cd.value;
						sheetObj.CellValue(sheetObj.SelectRow, "curr_cd")     = formObj.tax_curr_cd.value;
						sheetObj.CellValue2(sheetObj.SelectRow, "chg_amt")    = formObj.tax_amount.value;
						sheetObj.CellValue(sheetObj.SelectRow, "chg_rmk")     = "예수부가가치세";
						sheetObj.CellValue(sheetObj.SelectRow, "inv_rev_tp_src_cd") = "XXX";
						sheetObj.CellValue(sheetObj.SelectRow, "chg_cd")      = "TVA";
						sheetObj.CellValue(sheetObj.SelectRow, "rep_chg_cd")  = "SLC";
						sheetObj.CellValue(sheetObj.SelectRow, "inv_xch_rt")  = "1";
						sheetObj.CellValue(sheetObj.SelectRow, "tax_yn")      = "Y";
						sheetObj.CellValue(sheetObj.SelectRow, "mnl_flg")     = "N";
						
						sheetObj.CellEditable(sheetObj.SelectRow, "acct_cd") = false;
					}
				}
				//ar_tax_ind_cd가 '0%'인 경우는 CR그리드의 tax와 관련하여 생성된 212111계정을 삭제한다.
				else {
					for(i=sheetObj.rowCount; i>0; i--){
						if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "tax_yn")=="Y") {
							sheetObj.RowDelete(i, false);
						}
					}
				}
			}
			else {
				for(i=sheetObj.rowCount; i>0; i--){
					if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "tax_yn")=="Y") {
						sheetObj.RowDelete(i, false);
					}
				}
			}
		}
		//DR의 환율이 변경된 경우
		else if (gridType == 'exRate') {
			// 그리드안에 212111 항목이 있는지 확인한다.
			for(var i=sheetObj.rowCount; i>0; i--){
				// tax와 관련하여 생성되 212111계정인 경우 tax_amt를 해당 계정의 amt에 세팅한다.
				if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")=="212111" && sheetObj.CellValue(i, "tax_yn")== "Y") {
					sheetObj.CellValue2(i, "chg_amt") = formObj.tax_amount.value;
				}
				// tva와 관련하여 생성되 212111계정인 경우 환율은 로컬과 같으므로 "1"로 설정한다.
				else if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")=="212111" && sheetObj.CellValue(i, "tax_yn")== "T") {
					sheetObj.CellValue2(i, "inv_xch_rt") = "1";
				}
				// 그외의 경우는 그리드의 환율을 변경하여준다.
				else {
					sheetObj.CellValue2(i, "inv_xch_rt") = formObj.inv_xch_rt.value;
				}
			}
		}
		//DR의 화폐가 변경된 경우
		else if (gridType == 'currency') {
			for(var i=sheetObj.rowCount; i>0; i--){
				// Currency가 변할 경우 변경된 환율로 계산된 금액으로 amount값을 수정한다.
				if (sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd") == "212111" && sheetObj.CellValue(i, "tax_yn") == "Y") {
					//sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger);
					
					sheetObj.CellValue2(i, "chg_amt") = formObj.tax_amount.value;
				}
				// Currency가 변할 경우 변경된 환율로 계산된 금액으로 amount값을 수정한다.
				else if (sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd") == "212111" && sheetObj.CellValue(i, "tax_yn") == "T") {
					//if (lclCurrPoint > 0) {
					//	sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, lclCurrPoint );
					if (currPoint > 0) {
						sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
					}
					else {
						sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger);
					}
					
					sheetObj.CellValue2(i, "chg_amt") = formObj.tax_amount.value;
				}
				// Currency가 변할 경우 '212111'을 제외한 모든 CR의  Curr_Code값을 수정한다.
				else {
					//if (lclCurrPoint > 0) {
					//	sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, lclCurrPoint );
					if (currPoint > 0) {
						sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfNullFloat, currPoint );
					}
					else {
						sheetObj.InitCellProperty(i , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger);
					}
					
					sheetObj.CellValue(i, "curr_cd") = formObj.curr_cd.text;
					sheetObj.CellValue(i, "inv_xch_rt") = formObj.inv_xch_rt.value;
				}
			}
		}
	}
	
	/**
	 * DR 그리드 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function drGridSet() {
		var sheetObj = sheetObjects[1]; 
		var formObj = document.form;
		
		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			sheetObj.RemoveAll();
			
			var curs = "";
			var sums = "";
		
			var currPoint = formObj.curr_point.value;
			var lclCurrPoint = formObj.lcl_curr_point.value;
			
			var currCd = formObj.curr_cd.text;
			var lclCurrCd = formObj.lcl_curr.value;
			
			var amount = ComReplaceStr(formObj.amount.value,",","");
			var taxAmount = ComReplaceStr(formObj.tax_amount.value,",","");
			
			if (Number(amount) != 0) {
				sums = sums + formObj.curr_cd.text+"^"+amount+"|";
				
				if (curs.indexOf(formObj.curr_cd.text) == -1) {
					curs = curs + formObj.curr_cd.text +"|";
				}
			}
			
			if (Number(taxAmount) != 0) {
				sums = sums + formObj.tax_curr_cd.value+"^"+taxAmount+"|";
				
				if (curs.indexOf(formObj.tax_curr_cd.value) == -1) {
					curs = curs + formObj.tax_curr_cd.value +"|";
				}
			}
			
			//"|Curr|Local Total";
			var curs_item = curs.split("|");
			
			// 타이틀 변경
			sheetObj.MessageText("Sum") = "Total : " + formObj.lcl_curr.value;
			
			for (var i = 0; i < curs_item.length - 1; i++) {
				sheetObj.DataInsert(-1);
				sheetObj.CellValue(i+1, 1) = curs_item[i];
			}
			
			var sums_item = sums.split("|");
			var sums_item2 = "";
			
			for (var i = 0; i < sums_item.length - 1; i++) {
				sums_item2 = sums_item[i].split("^");
				var totalAmount = 0;
	
				for (var j = 0; j < sheetObj.RowCount; j ++) {
					if (sheetObj.CellValue(j+1, 1) == sums_item2[0] && sums_item2[1] != "") {
						if (sheetObj.CellValue(j+1, 1) == currCd ) {
							totalAmount = ComRound((sheetObj.CellValue(j+1, 2) == "" ? 0 : Number(ComReplaceStr(sheetObj.CellValue(j+1, 2),",",""))) + Number(ComReplaceStr(sums_item2[1],",","")), currPoint);
							sheetObj.CellValue(j+1, 2) = setCurrPointValue(totalAmount, currPoint);
						}
						else {
							totalAmount = ComRound((sheetObj.CellValue(j+1, 2) == "" ? 0 : Number(ComReplaceStr(sheetObj.CellValue(j+1, 2),",",""))) + Number(ComReplaceStr(sums_item2[1],",","")), lclCurrPoint);
							sheetObj.CellValue(j+1, 2) = setCurrPointValue(totalAmount, lclCurrPoint);
						}
					}
				}
			}

			sheetObj.SumValue(0, "local_total") = formObj.total_local_amt.value;
		}
	}
	
	/** 
	 * CR 그리드 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function crGridSet() {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[2];
		var formObj = document.form;
		
		var currPoint = formObj.curr_point.value;
		var lclCurrPoint = formObj.lcl_curr_point.value;
		var setCurrPoint = "";
		if (Number(currPoint) > Number(lclCurrPoint)) {
			setCurrPoint = currPoint;
		}
		else {
			setCurrPoint = lclCurrPoint;
		}
		
		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			
			var currPoint = formObj.curr_point.value;
			var lclCurrPoint = formObj.lcl_curr_point.value;
			
			var currCd = formObj.curr_cd.text;
			var lclCurrCd = formObj.lcl_curr.value;
			
			sheetObj2.RemoveAll();
			
			var rowCnt1 = sheetObj1.RowCount;
			var rowCnt2 = sheetObj2.RowCount;
			var curCnt = 0;
			var curs = "";
			var sums = "";
			
			for(var j = 1; j <= rowCnt1; j++){
				if (sheetObj1.CellValue(j, "curr_cd") != "KRW") {
					if (sheetObj1.CellValue(j, "inv_xch_rt") != 0) {
						sums = sums + sheetObj1.CellValue(j, "curr_cd")+"^"+sheetObj1.CellValue(j, "chg_amt")+"^"+sheetObj1.CellValue(j, "inv_xch_rt")+"|";
						if (curs.indexOf(sheetObj1.CellValue(j, "curr_cd")) == -1) {
							curs = curs + sheetObj1.CellValue(j, "curr_cd") +"|";
						}
					}
				}
			}
			
			for(var j = 1; j <= rowCnt1; j++){
				if (sheetObj1.CellValue(j, "curr_cd") == "KRW") {
					if (sheetObj1.CellValue(j, "inv_xch_rt") != 0) {
						sums = sums + sheetObj1.CellValue(j, "curr_cd")+"^"+sheetObj1.CellValue(j, "chg_amt")+"^"+sheetObj1.CellValue(j, "inv_xch_rt")+"|";
						if (curs.indexOf(sheetObj1.CellValue(j, "curr_cd")) == -1) {
							curs = curs + sheetObj1.CellValue(j, "curr_cd") +"|";
						}
					}
				}
			}
			
			//"|Curr|Local Total";
			var curs_item = curs.split("|");

			// Sum 타이틀 변경
			sheetObj2.MessageText("Sum") = "Total : " + formObj.lcl_curr.value;

			for (var i = 0; i < curs_item.length - 1; i++) {
				sheetObj2.DataInsert(-1);
				sheetObj2.CellValue(i+1, 1) = curs_item[i];
			}
			
			var sums_item = sums.split("|");
			var sums_item2 = "";
			
			for (var i = 0; i < sums_item.length - 1; i++) {
				sums_item2 = sums_item[i].split("^");
	
				for (var j = 0; j < sheetObj2.RowCount; j ++) {
					if (sheetObj2.CellValue(j+1, 1) == sums_item2[0] && sums_item2[1] != "" && sums_item2[2] != "") {
						if (sheetObj2.CellValue(j+1, 1) == currCd ) {
							var localTotal = ComRound((sheetObj2.CellValue(j+1, 2) == "" ? 0 : Number(ComReplaceStr(sheetObj2.CellValue(j+1, 2),",",""))) + Number(ComReplaceStr(sums_item2[1],",","")), currPoint);
							
							sheetObj2.CellValue(j+1, 2) = setCurrPointValue(localTotal, currPoint);
							sheetObj2.CellValue(j+1, 3) = sums_item2[2];
						}
						else {
							var localTotal = ComRound((sheetObj2.CellValue(j+1, 2) == "" ? 0 : Number(ComReplaceStr(sheetObj2.CellValue(j+1, 2),",",""))) + Number(ComReplaceStr(sums_item2[1],",","")), lclCurrPoint);
							
							sheetObj2.CellValue(j+1, 2) = setCurrPointValue(localTotal, lclCurrPoint);
							sheetObj2.CellValue(j+1, 3) = sums_item2[2];
						}
					}
				}
			}
		}

		if (lclCurrPoint == '0') {
			sheetObj2.SumValue(0, "chg_amt") = setCurrPointValue(ComRound(sheetObj2.SumValue(0, "local_total"), lclCurrPoint), lclCurrPoint);
		}
		else {
			sheetObj2.SumValue(0, "chg_amt") = setCurrPointValue(ComRound(sheetObj2.SumValue(0, "local_total"), setCurrPoint), setCurrPoint);
		}	
	}
	
	/** 
	 * INV_AR_AMT 그리드 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function amtGridSet() {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[3];
		var formObj = document.form;
		
		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			
			var currPoint = formObj.curr_point.value;
			var lclCurrPoint = formObj.lcl_curr_point.value;
			
			var currCd = formObj.curr_cd.text;
			var lclCurrCd = formObj.lcl_curr.value;
			
			sheetObj2.RemoveAll();
			
			var rowCnt1 = sheetObj1.RowCount;
			var curCnt = 0;
			var curs = "";
			var curs2 = "";
			var sums = "";
			var tjSrcNm = "";
			
			for(var j = 1; j <= rowCnt1; j++){
				if (sheetObj1.CellValue(j, "chg_cd") == 'XXX') {
					tjSrcNm = "NONRE";
				}
				//'TVA','GST','AST','VDT','VTT','VRT','VST','VCT'
				else if (sheetObj1.CellValue(j, "chg_cd") == 'TVA' || sheetObj1.CellValue(j, "chg_cd") == 'GST' || sheetObj1.CellValue(j, "chg_cd") == 'AST' || sheetObj1.CellValue(j, "chg_cd") == 'VDT' || sheetObj1.CellValue(j, "chg_cd") == 'VTT' || sheetObj1.CellValue(j, "chg_cd") == 'VRT'|| sheetObj1.CellValue(j, "chg_cd") == 'VST' || sheetObj1.CellValue(j, "chg_cd") == 'VCT'|| sheetObj1.CellValue(j, "chg_cd") == 'ACP'|| sheetObj1.CellValue(j, "chg_cd") == 'IVA') {
					tjSrcNm = "VAT";
				}
				else {
					tjSrcNm = "OTHER";
				}
				
				sums = sums + tjSrcNm+"^"+sheetObj1.CellValue(j, "curr_cd")+"^"+sheetObj1.CellValue(j, "chg_cd")+"^"+sheetObj1.CellValue(j, "chg_amt")+"^"+sheetObj1.CellValue(j, "inv_xch_rt")+"|";
				
				if (curs.indexOf(tjSrcNm+"^"+sheetObj1.CellValue(j, "curr_cd")) == -1) {
					curs = curs + tjSrcNm+"^"+sheetObj1.CellValue(j, "curr_cd")+"|";
				}
			}
			
			var curs_item = curs.split("|");
			for (var i = 0; i < curs_item.length - 1; i++) {
				var curs_item2 = curs_item[i].split("^");
				
				sheetObj2.DataInsert(-1);
				sheetObj2.CellValue(i+1, 1) = curs_item2[0];
				sheetObj2.CellValue(i+1, 2) = curs_item2[1];
			}
			
			var sums_item = sums.split("|");
			var sums_item2 = "";
			for (var i = 0; i < sums_item.length - 1; i++) {
				sums_item2 = sums_item[i].split("^");
	
				for (var j = 0; j < sheetObj2.RowCount; j ++) {
					if (sheetObj2.CellValue(j+1, 1) == sums_item2[0] && sheetObj2.CellValue(j+1, 2) == sums_item2[1] && sums_item2[3] != "") {
						sheetObj2.CellValue(j+1, 3) = (sheetObj2.CellValue(j+1, 3) == "" ? 0 : Number(ComReplaceStr(sheetObj2.CellValue(j+1, 3),",",""))) + Number(ComReplaceStr(sums_item2[3],",",""));
					}
				}
			}
		}
	}
	
	/** 
	 * ar_ofc_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function ar_ofc_cd_OnChange(comboObj, Index_Code, Text){ 
		var formObj = document.form;
		
		//조회시에는 아래 내용을 처리하지 않고 리턴한다.
		var viewYn = formObj.view_yn.value;
		if (viewYn == "Y") {
			return;
		}
		
		// OFFICE
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		
		formObj.reset();
	 	
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		
		// 조회조건 초기화
		setSearchValueType();
		
		if (arrStr2!='') {
			formObj.curr_cd.text = arrStr2[4];
	
			formObj.office_cnt_cd.value = arrStr2[6].substring(0,2);
			formObj.lcl_curr.value = arrStr2[4];
			formObj.tax_curr_cd.value = arrStr2[4];
			formObj.total_curr_cd.value = arrStr2[4];
			formObj.pol_cd.value = arrStr2[6];
			formObj.svr_id.value = arrStr2[7];
			formObj.ots_smry_cd.value = arrStr2[13];
 			formObj.inv_vat_chg_cd.value = arrStr2[16];
 			formObj.inv_vat_chg_rt.value = arrStr2[17];
			
			formObj.inv_xch_rt.value = "1.000000";
			
 	    	var currPoint = getDpPrcsKnt(arrStr2[4],arrDpPrcsKnt);
 	    	// local 화폐 자릿수 세팅
 	    	formObj.lcl_curr_point.value = currPoint;
 	    	formObj.curr_point.value = currPoint;
			
 			// 한국인 경우 tax 부분을 보여준다.
 			if (arrStr2[6].substr(0,2) == "KR" || arrStr2[6].substr(0,2) == "HQ") {
 				document.getElementById('taxDiv1').style.display = "block";
 				document.getElementById('taxDiv2').style.display = "none";
 			}
 			else {
 				document.getElementById('taxDiv1').style.display = "none";
 				document.getElementById('taxDiv2').style.display = "block";
 				
 				formObj.ar_tax_ind_cd.text = "";
 			}
 			
 			// ots_smry_cd가  'INV'인 경우 보여준다.
 			if (arrStr2[13] == "INV") {
 				document.getElementById('invNoDiv').style.display = "block";
 			}
 			else {
 				document.getElementById('invNoDiv').style.display = "none";
 			}
 			
 	    	// Amount의 curr가 local curr와 동일시에는 환율 1로 고정
 	    	var currCdStr = formObj.curr_cd.text;
 	    	var lclCurrStr =  formObj.lcl_curr.value;
 	    	if (currCdStr == lclCurrStr) {
 	    		ComEnableObject(formObj.inv_xch_rt,false);
 	    	}
 	    	else {
 	    		ComEnableObject(formObj.inv_xch_rt,true);
 	    	}
		}
		else {
			formObj.curr_cd.text = "";
			
			formObj.office_cnt_cd.value = "";
			formObj.lcl_curr.value = "";
			formObj.tax_curr_cd.value = "";
			formObj.total_curr_cd.value = "";
			formObj.pol_cd.value = "";
			formObj.svr_id.value = "";
			
			formObj.inv_xch_rt.value = "1.000000";
		}
	}
	
	/** 
	 * Amount Currency Cd 변경시<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * Amount Currency Cd 변경시 입력된 CR Detail grid의 내용을 xml형태로 저장해놓았다가 
	 * 변경된 currency 의 소수점 자릿수에 따라 round()된 금액으로 표시한다.
	 * - Amount 계산
	 * - CR Detail 그리드 세팅(currency code)
	 * - DR 그리드 세팅
	 * - CR 그리드 세팅
	 * - INV_AR_AMT 그리드 세팅
	 * </pre>
	 * @param {comboObj} form html 폼
	 * @param {Index_Code} form html 폼
	 * @param {Text} form html 폼
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function curr_cd_OnChange(comboObj, Index_Code, Text) {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
		var sheetObj4 = sheetObjects[3];
    	var formObj = document.form;
    	var sXml = "";
    	
		var viewYn = formObj.view_yn.value;
		if (viewYn == "Y") {
			return;
		}
    	
    	// Amount의 curr가 local curr와 동일시에는 환율 1로 고정하고 비활성화 한다.
    	var currCdStr = formObj.curr_cd.text;
    	var lclCurrStr =  formObj.lcl_curr.value;
    	if (currCdStr == lclCurrStr) {
    		ComEnableObject(formObj.inv_xch_rt,false);
    	}
    	else {
    		ComEnableObject(formObj.inv_xch_rt,true);
    	}
    	
    	var currPoint = getDpPrcsKnt(formObj.curr_cd.text,arrDpPrcsKnt);
    	// 화폐별 자릿수 세팅
    	formObj.curr_point.value = currPoint;
    	
    	// sheet1 내용
    	if (sheetObj1.rowCount > 0) {
    		var chgAmt = 0;
    		for(i=sheetObj1.rowCount; i>0; i--){
    			if (currPoint == 0) {
	    			chgAmt = sheetObj1.CellValue(i, "chg_amt");
	    			
	    			sheetObj1.CellValue2(i, "chg_amt") = parseInt(ComRound(parseFloat(chgAmt),currPoint));
    			}
    		}
    		
    		sXml = ComMakeSearchXml(sheetObj1, true);
    	}

    	// sheet 초기화
		sheetObj1.RemoveAll();
		sheetObj2.RemoveAll();
		sheetObj3.RemoveAll();
		sheetObj4.RemoveAll();
		
		sheetObj1.Reset();
		sheetObj2.Reset();
		sheetObj3.Reset();
		sheetObj4.Reset();
    	
    	initSheet(sheetObj1,1);
		
    	if (sXml != '') {
    		addCellComboItem(sheetObj1,'acct_cd',false);
    		sheetObj1.LoadSearchXml(sXml);
    	}
    	
    	// tax 로 발생한 212111를 비활성화한다.
		for(i=sheetObj1.rowCount; i>0; i--){
			if(sheetObj1.CellValue(i, "ibflag") != "" && (sheetObj1.CellValue(i, "tax_yn")=="Y" || sheetObj1.CellValue(i, "tax_yn")=="T")) {
				sheetObj1.CellEditable(i, "acct_cd") = false;
			}
			
			if(sheetObj1.CellValue(i, "ibflag") != "" && sheetObj1.CellValue(i, "acct_cd") != "212111" && sheetObj1.CellValue(i, "mnl_flg") == "Y") {
				sheetObj1.CellEditable(i, "tva_flg") = true;
			}
		}
    	
    	initSheet(sheetObj2,2);
    	initSheet(sheetObj3,3);
    	initSheet(sheetObj4,4);
    	
    	//Office AR Currency 경리환율 조회
		if(getLoclXchRt()) {
			//Amount 계산
			calLocalAmount();
			//TVA Amount 계산
			calTVAAmount(sheetObj1, formObj);
			//CR Detail 그리드 세팅
			dtlGridSet('currency');
			//DR 그리드 세팅
			drGridSet();
			//CR 그리드 세팅
			crGridSet();
			//INV_AR_AMT 그리드 세팅
			amtGridSet();
		}
	}
	
	/** 
	 * ar_tax_ind_cd 콤보박스의 값이 변경된 경우 화면을 초기화한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} Index_Code
	 * @param {object} Text
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function ar_tax_ind_cd_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		
		var viewYn = formObj.view_yn.value;
		if (viewYn == "Y") {
			return;
		}

		var sheetObj = sheetObjects[0];
		
		if (formObj.eff_dt.value != '' && formObj.amount.value != '' && formObj.inv_xch_rt.value != '') {
			var officeCntCd = formObj.office_cnt_cd.value;
			
			//Amount 계산
			calLocalAmount();

			if (officeCntCd == "KR" || officeCntCd =="HQ") {
				//var lclCurrPoint = formObj.lcl_curr_point.value;
				
				// AR_TAX_IND_CD 가 'N','10%'인 경우는 CR그리드에 '212111'계정을 추가한다.
				if (formObj.ar_tax_ind_cd.Code == "10" || formObj.ar_tax_ind_cd.Code == "N") {
					var chgChkFlg = true;
					
					// cr 그리드에서 tax로 입력된 항목이 있는지 체크한다.
					for(i=sheetObj.rowCount; i>0; i--){
						if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "tax_yn")=="Y") {
							chgChkFlg = false;
							break;
						}
					}
					
					// cr 그리드에서 tax로 입력된 항목이 없다면 추가한다.
					if (chgChkFlg) {
						sheetObj.DataInsert(0);
						
						sheetObj.InitCellProperty(sheetObj.SelectRow , "chg_amt", dtData , daRight , "chg_amt", "", dfInteger );
						
						addCellComboItem(sheetObj,'acct_cd',true);
						
						sheetObj.CellValue(sheetObj.SelectRow, "acct_cd") = "212111";
						sheetObj.CellValue(sheetObj.SelectRow, "chg_full_nm") = "V.A.T. RECEIVED";
						sheetObj.CellValue(sheetObj.SelectRow, "cust_code") = formObj.cust_cnt_cd.value + formObj.cust_seq.value ;
						sheetObj.CellValue(sheetObj.SelectRow, "city") = formObj.pol_cd.value;
						sheetObj.CellValue(sheetObj.SelectRow, "curr_cd") = formObj.tax_curr_cd.value;
						sheetObj.CellValue2(sheetObj.SelectRow, "chg_amt") = formObj.tax_amount.value;
						sheetObj.CellValue(sheetObj.SelectRow, "chg_rmk") = "예수부가가치세";
						sheetObj.CellValue(sheetObj.SelectRow, "inv_rev_tp_src_cd") = "XXX";
						sheetObj.CellValue(sheetObj.SelectRow, "chg_cd") = "TVA";
						sheetObj.CellValue(sheetObj.SelectRow, "rep_chg_cd") = "SLC";
						sheetObj.CellValue(sheetObj.SelectRow, "inv_xch_rt") = "1";
						sheetObj.CellValue(sheetObj.SelectRow, "tax_yn")= "Y";	// <-- 화면에서 add 버튼을 눌러 추가한 계정과 구분하기위한 임의의 값
						sheetObj.CellValue(sheetObj.SelectRow, "mnl_flg")= "N";	// <-- 화면에서 add 버튼을 눌러 추가한 계정과 구분하기위한 임의의 값
						
						sheetObj.CellEditable(sheetObj.SelectRow, "acct_cd") = false;
					}
					// cr 그리드에서 tax로 입력된 항목이 있다면 그 금액을 TAX AMOUNT에 입력된 값으로 변경해준다. 
					else {
						if(sheetObj.CellValue(sheetObj.SelectRow, "ibflag") != "" && sheetObj.CellValue(sheetObj.SelectRow, "tax_yn")=="Y") {
							sheetObj.CellValue2(sheetObj.SelectRow, "chg_amt") = formObj.tax_amount.value;
						}
					}
				}
				// AR_TAX_IND_CD 가 '0%'인 경우는 CR그리드에 있는 관련 '212111'계정을 삭제한다.
				else {
					for(i=sheetObj.rowCount; i>0; i--){
						if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "tax_yn")=="Y") {
							sheetObj.RowDelete(i, false);
						}
					}
				}
			}
			//DR 그리드 세팅
			drGridSet();
			//CR 그리드 세팅
			crGridSet();
			//INV_AR_AMT 그리드 세팅
			amtGridSet();
		}
	}

	/** 
	 * 경리환율 변경 범위 체크<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function chkXchRate() {
		var rtnValue = false;
		var formObj = document.form;
		
		// 조회된 경리환율
		var usdLoclXchRt = formObj.usd_locl_xch_rt.value;
		// 입력한 경리환율
		var invXchRt = formObj.inv_xch_rt.value;
		
		var maxInvXchRt;
		var minInvXchRt;
		
		if (!ComIsNull(formObj.usd_locl_xch_rt) && !ComIsNull(formObj.inv_xch_rt)) {
			maxInvXchRt = Number(ComReplaceStr(usdLoclXchRt,",","")) * 1.5;
			minInvXchRt = Number(ComReplaceStr(usdLoclXchRt,",","")) * 0.5;
			
			if (Number(ComReplaceStr(invXchRt,",","")) <= Number(maxInvXchRt) && Number(ComReplaceStr(invXchRt,",","")) >= Number(minInvXchRt)) {
				rtnValue = true;
				
				formObj.inv_xch_rt.value = ComAddComma(invXchRt);
			}
			else {
				formObj.inv_xch_rt.value = ComAddComma(usdLoclXchRt);
			}
		}
		return rtnValue;
	}
	
    /** 
     * OnChange 이벤트 발생시[CR 그리드 입력항목 변경] 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @param  {rownum} Row        
     * @param  {colnum} Col        
     * @param  {object} Value        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
    	var formObj = document.form;
    	var currPoint = formObj.curr_point.value;
    	var officeCntCd = formObj.office_cnt_cd.value;
    	
    	//ACCT_CD
    	if (Col == 1) {
    		//같이 사용할 수 없는 항목을 체크하여 이상 없는 경우
    		if (chkAccountCondition(sheetObj, sheetObj.SelectRow, Value)) {
    			//CR detail Grid의 Account 변경시 Account Nmae, Remark 동시 변경처리
    			setAccountInfo(sheetObj, sheetObj.SelectRow, Value);
    		}
    		else {
    			ComShowMessage(ComGetMsg('INV00059'));
    		}
			
    		// acct_cd가 변경될 경우 vvd를 변경한다.
			var lclVvd = formObj.lcl_vvd.value;
			var glEffDt = ComReplaceStr(formObj.eff_dt.value,"-","");
			if (lclVvd == '') {
				lclVvd = "COMC"+glEffDt.substring(2,6)+"M";
			}
			
			var chkAcct = false;
			
			for(var i=sheetObj.rowCount; i>0; i--){
				//vvd를 변경할 계정 체크.
				// '411911','411915','710111'일 경우 vvd를 'CNTC'로 변경한다.
				if(sheetObj.CellValue(i, "ibflag") != "" && (sheetObj.CellValue(i, "acct_cd")=="411911" || 
					sheetObj.CellValue(i, "acct_cd")=="411915" || sheetObj.CellValue(i, "acct_cd")=="710111")) {
					chkAcct = true;
				}
			}
			
			if (chkAcct) {
				formObj.lcl_vvd.value = "CNTC"+lclVvd.substring(4,9);
			}
			else {
				formObj.lcl_vvd.value = "COMC"+lclVvd.substring(4,9);
			}
			
			// CR Acct Cd 값에 따라 TVA 항목을 활성화/비활성화 처리한다.
			var invVatChgCd = formObj.inv_vat_chg_cd.value;
			var invVatChgRt = formObj.inv_vat_chg_rt.value;
			if (officeCntCd == "KR" || officeCntCd == "HQ") {
				sheetObj.CellValue(Row, "tva_flg") = 0;
				sheetObj.CellEditable(Row, "tva_flg") = false;
			}
			else {
				if (invVatChgCd != '' && invVatChgRt > 0 && sheetObj.CellValue(Row, "acct_cd") == "212111") {
					sheetObj.CellValue(Row, "tva_flg") = 0;
					sheetObj.CellEditable(Row, "tva_flg") = false;
				}
				else if (invVatChgCd != '' && invVatChgRt > 0 && sheetObj.CellValue(Row, "acct_cd") != "212111") {
					sheetObj.CellEditable(Row, "tva_flg") = true;
				}
				
			}
		
			if (sheetObj.CellValue(Row ,"acct_cd")== "954111" && formObj.ar_ofc_cd.text =='LEHSC'){
				sheetObj.CellEditable(Row, "ttl_lss_cfm_flg") = true;
			}
			//INV_AR_AMT 그리드 세팅
			amtGridSet();
			
    	}
    	//CHG_AMT
    	else if (Col == 6) {
    		// CR 그리드이 첫번째 줄이면서 TAX_IND_CD가 10%,N 인경우 입력 금액의 범위를 확인한다.
    		if (sheetObj.SelectRow == 1 && (formObj.ar_tax_ind_cd.text == '10%' || formObj.ar_tax_ind_cd.text == 'N') && sheetObj.CellValue(sheetObj.SelectRow, "tax_yn") == 'Y') {
    			//입력범위의 정확한 체크를 위해 화면에 표시되는 TAX_AMT와는 별개로 관리한다.
    			var defTaxAmt = Number(ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "chg_amt"),",",""));
    			var minTaxAmt = Number(ComReplaceStr(formObj.tax_amount_ori.value,",","")) - 10;
    			var maxTaxAmt = Number(ComReplaceStr(formObj.tax_amount_ori.value,",","")) + 10;
    			
    			//초기에 계산된 TAX_AMT와 +/-10의 범위인지 확인한다. 
    			if (defTaxAmt >= minTaxAmt && defTaxAmt <= maxTaxAmt) {
    				formObj.tax_amount.value = ComAddComma(sheetObj.CellValue(sheetObj.SelectRow, "chg_amt"));
    			}
    			else {
    				//입력금액 오류 메시지를 표시하고 초기 계산금액으로 세팅한다.
    				ComShowMessage(ComGetMsg('INV00076'));
    				sheetObj.CellValue2(sheetObj.SelectRow, "chg_amt") = formObj.tax_amount_ori.value;
    				formObj.tax_amount.value = formObj.tax_amount_ori.value;
    			}
    		}
    		//cr 그리드 변경시 local Amount 계산
    		calLocalAmount2();
			//TVA Amount 계산
			calTVAAmount(sheetObj, formObj);
    		//DR 그리드 세팅
    		drGridSet();
    		//CR 그리드 세팅
    		crGridSet();
    		//INV_AR_AMT 그리드 세팅
    		amtGridSet();
    	}
    	// TVA
    	else if (Col == 8) {
			//Amount 계산
			calLocalAmount();
    		//TVA Amount 계산
    		calTVAAmount(sheetObj, formObj);
    		//DR 그리드 세팅
    		drGridSet();
    		//CR 그리드 세팅
    		crGridSet();
    		//INV_AR_AMT 그리드 세팅
    		amtGridSet();
    	}
	}
	
    /** 
	 * 그리드를 제외한 입력항목의 화폐의 소수점 자리에 따라 값을 변경해준다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} amtVal        
     * @param {object} currPoint  
     * @return {object} return_value
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function setCurrPointValue(amtVal, currPoint) {
		var amountValue = amtVal+"";
		
		if (currPoint == '0') {
			return ComAddComma(amountValue);
		}
		else if (currPoint == '1') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".0";
            }
            else if (amountSplit.length == 2) {
            	return amountSplit[0]+"."+amountSplit[1];
            }
            else {
            	return "";		
            }
		}
		else if (currPoint == '2') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".00";
            }
            else if (amountSplit.length == 2) {
           		return amountSplit[0]+"."+ComRpad(amountSplit[1], 2, "0");
            }
            else {
            	return "";
            }
		}
		else if (currPoint == '3') {
			var amountSplit = amountValue.split(".");
			
			amountSplit[0] = ComAddComma(amountSplit[0]);
            if (amountSplit.length == 1) {
            	return amountSplit[0]+".000";
            }
            else if (amountSplit.length == 2) {
           		return amountSplit[0]+"."+ComRpad(amountSplit[1], 3, "0");
            }
            else {
            	return "";
            }
		}
	}
	
    /** 
	 * 그리드에 같이 사용할 수 없는 항목을 체크한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 잘못 입력선택했을시 메세지(INV00059)
	 * </pre>
     * @param  {IBSheet} sheetObj        
     * @param {object} Row  
     * @param {object} val
     * @return {object} rtnValue
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function chkAccountCondition(sheetObj, Row, val) {
		var rtnValue = true;
		var curs = "";
		var otherCurs = "";
		val = ComReplaceStr(val," ","");
		if (val != '') {
			//ACCT_CD 중복 입력 체크
			for(var i=sheetObj.rowCount; i>0; i--){
				//다른 계정과 같이 사용할수 없는 계정 체크.
				// - '411911' , '411915' ,'957112', '954111' ,'422011','710111' 는 단독 사용
				if(sheetObj.CellValue(i, "ibflag") != "" && (sheetObj.CellValue(i, "acct_cd")=="411911" || 
					sheetObj.CellValue(i, "acct_cd")=="411915" || sheetObj.CellValue(i, "acct_cd")=="957112" || 
					sheetObj.CellValue(i, "acct_cd")=="954111" || sheetObj.CellValue(i, "acct_cd")=="422011" || 
					sheetObj.CellValue(i, "acct_cd")=="710111")) {
					if (curs.indexOf(sheetObj.CellValue(i, "acct_cd")) == -1) {
						curs = curs + sheetObj.CellValue(i, "acct_cd") +"|";
					}
				}
				else {
					//위의 ACCT_CD이외의 계정을 체크한다. 
					//단 '212111' 와는 같이 사용 가능하기때문에 체크하지 않는다.
					if(sheetObj.CellValue(i, "ibflag") != "" && sheetObj.CellValue(i, "acct_cd")!="212111") {
						if (curs.indexOf(sheetObj.CellValue(i, "acct_cd")) == -1) {
							otherCurs = otherCurs + sheetObj.CellValue(i, "acct_cd") +"|";
						}
					}
				}
			}
		}
		
		var curs_item = curs.split("|");
		//위 조건에 맞는 acct_cd가 1개 있을 경우는 212111를 제외하고 자신만을 허용한다.
		// length를 2로 체크하는 이유는 하나의 계정을 추가할때 분리기준문자가 뒤에 포함되어 length는 2가 된다.
		if (curs_item.length == 2) {
			// 기타 계정이 있는 경우 입력된 줄를 삭제한다.
			if (otherCurs.length >= 2) {
				rtnValue = false;
				
				sheetObj.RowDelete(Row, false);
			}
			else {
				if (sheetObj.CellValue(Row, "acct_cd") != '212111') {
					if (sheetObj.CellValue(Row, "acct_cd") != curs_item[0]) {
						rtnValue = false;
						
						sheetObj.RowDelete(Row, false);
					}
				}
			}
		}
		// 위 조건에 맞는 acct_cd가 2개 있을 경우 오류를 발생하고 입력하던 줄을 삭제한다.
		else if (curs_item.length > 2) {
			rtnValue = false;
			
			sheetObj.RowDelete(Row, false);
		}
		
		return rtnValue;
	}
	
    /**
	 * CR detail Grid의 Account 변경시 Account Nmae, Remark 동시 변경처리<br>
	 * - 한국지역 사용자는 ACCT_KRN_NM을 Remark에 넣어주고 수정가능하도록 함.
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param  {IBSheet} sheetObj        
     * @param {object} Row  
     * @param {object} val
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function setAccountInfo(sheetObj, Row, comboValue) {
		var formObj = document.form;
    	var currPoint = formObj.curr_point.value;
    	var officeCntCd = formObj.office_cnt_cd.value;
    	
		sheetObj.CellValue2(Row, "chg_full_nm") = getCodeName(comboValue, arrAcctEngNm);
		//'KOR'소속 office인 경우 ACCT_KRN_NM을 remark값도 세팅한다.
		if (officeCntCd == 'KR' || officeCntCd == 'HQ') {
			sheetObj.CellValue2(Row, "chg_rmk") = getCodeName(comboValue, arrAcctKrnNm);
		}
		sheetObj.CellValue2(Row, "inv_rev_tp_src_cd") = getCodeName(comboValue, arrRevCd);
		sheetObj.CellValue2(Row, "chg_cd") = getCodeName(comboValue, arrChgCd);
		sheetObj.CellValue2(Row, "rep_chg_cd") = getCodeName(comboValue, arrRepChgCd);
	}
	
    /** 
	 * CR detail Grid 삭제시 조건 체크<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param  {IBSheet} sheetObj        
     * @param {object} Row  
     * @param {object} formObj
     * @return boolean
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function gridCopyDeleteOK(sheetObj, Row, formObj) {
		var rtnValue = true;
		
		// tax에 의하여 발생한 212111 항목은 복사/삭제되지 않는다.
		if (sheetObj.CellValue(Row, "acct_cd") == "212111" && sheetObj.CellValue(Row, "mnl_flg") == "N") {
			ComShowMessage(ComGetMsg('INV00014'));
			rtnValue = false;
		}
		
		return rtnValue;
	}
	
    /** 
	 * Arrary 에서 해당하는 index의 코드값을 리턴한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} searchValue        
     * @param {array} targetArr  
     * @return {object}rtnValue
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function getCodeName(searchValue, targetArr) {
		var rtnValue = ""
		for (var i = 1; i < targetArr.length;i++ ) {
			if (arrAcctCd[i] == searchValue) {
				rtnValue = targetArr[i];
			}
		}
		return rtnValue
	}
	
    /** 
	 * Arrary 에서 화폐에 따른 소수점 자리수 조회한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {object} searchValue        
     * @param {array} targetArr  
     * @return {object}rtnValue
     * @see #
     * @author 박정진
     * @version 2009.04.27
     */
	function getDpPrcsKnt(searchValue, targetArr) {
		var rtnValue = ""
			
		for (var i = 1; i < targetArr.length;i++ ) {
			if (arrCurrInfo[i] == searchValue) {
				rtnValue = targetArr[i];
			}
		}
		return rtnValue
	}
	
	/** 
	 * Rd 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {RdObject} rdObject
	 * @param  {object} formObj    
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject ;	
		var user_nm = formObj.user_nm.value;
		
		//review 창 오픈
		formObj.com_mrdPath.value      = "apps/alps/fns/inv/accountreceivableinvoicecreation/manualarcreation/report/FNS_INV_0502.mrd";
		formObj.com_mrdArguments.value = "/rv " + "frm1_ar_if_no['"+formObj.ar_if_no.value+"']  frm1_login_nm["+user_nm+"]";
		var feature = "resizable=yes,width=1000,height=650"
		ComOpenRDPopup(feature);
	}
	
	/** 
	 * VoList를 array[array[name]]형태로 변환<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function ComXml2ListMap(xmlStr) {
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return rtnArr;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChileNodes = dataNode.childNodes;
			if (dataChileNodes == null) {
				return rtnArr;
			}

			for ( var i = 0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				
				var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

				var subDataArr = new Array();
				
				for ( var j = 0; j < arrData.length; j++) {
					subDataArr[colArr[j]] = arrData[j];
				}
				
				rtnArr[i] = (subDataArr);
			}

		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}

	/** 
	 * Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {form} form html 폼 
	 * @param {map} Array[name] 의 값 
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.04.27
	 */
	function ComMapToForm(form, map) {		
		//사용가능한 컨트롤을 배열로 생성한다.
		var len = form.elements.length;
		var currPoint = form.curr_point.value;
		var lclCurrPoint = form.lcl_curr_point.value;
		
		for (var i = 0; i < len; i++) {
			if (form.elements[i].classid == undefined) {
				var xvalue = map[form.elements[i].name];
				if (xvalue == undefined)
					continue;
				switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					var eRadio = document.all[form.elements[i].name];
					var idx = 0;
					for ( var k = 0; k < eRadio.length; k++) {
						if (eRadio[k].value == xvalue) {
							idx = k;
							break;
						}
					}
					eRadio[idx].checked = true;
					break;
				case "checkbox":
					form.elements[i].checked = xvalue;
					break;
				case "select-one":
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						for ( var k = 0; k < opt_len; k++) {
							if (eOpt[k].value == xvalue) {
								idx = k;
								break;
							}
						}
					}
					form.elements[i].selectedIndex = idx;
					break;
				case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						var tvalue = xvalue.split("|");
						var tval_len = tvalue.length;
						for ( var k = 0; k < opt_len; k++) {
							for ( var m = 0; m < tval_len; m++) {
								if (eOpt[k].value == tvalue[m])
									eOpt[k].selected = true;
							}
						}
					}
					break;
				default:
					switch (form.elements[i].name) {
						case "cgo_meas_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_teu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_feu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "good":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "nogood":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "cust_rgst_no":
							form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
						break;
						case "amount":
							form.elements[i].value = setCurrPointValue(xvalue, currPoint);
						break;
						case "local_amount":
							form.elements[i].value = setCurrPointValue(xvalue, lclCurrPoint);
						break;
						case "total_local_amt":
							form.elements[i].value = setCurrPointValue(xvalue, lclCurrPoint);
						break;
						case "tax_amount":
							form.elements[i].value = setCurrPointValue(xvalue, lclCurrPoint);
						break;
						default:
							form.elements[i].value = xvalue;
						break;
					}
				}
			}
		}
	}
	 function sheet1_OnSearchEnd(sheetObj, errMsg) {
		 var formObj = document.form;
		 if (formObj.ar_ofc_cd.text =='LEHSC'){
				sheetObj.ColHidden("ttl_lss_cfm_flg") = false;
				sheetObj.CellEditable(Row, "ttl_lss_cfm_flg") = false;
			}else{
				sheetObj.ColHidden("ttl_lss_cfm_flg") = true;
			}
		}
	 
	 function ar_ofc_cd_OnChange(value,text){	
		 var formObj = document.form;
		 var sheetObject = sheetObjects[0];
		 if (formObj.ar_ofc_cd.text =='LEHSC'){
			   sheetObject.ColHidden("ttl_lss_cfm_flg") = false;
			 }else{
			   sheetObject.ColHidden("ttl_lss_cfm_flg") = true;
	    	}
		 //PUSMPG 단독 사용 411991 때문에 Reset함.
		 if (formObj.ar_ofc_cd.text =='PUSMPG' || formObj.login_ofc_cd.value =='SELHO'){
			    sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
		   }
		}
	 
	 
		/**
		 * LCL VVD 체크 <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     chkLclVvd();
		 * </pre>
		 * @param 없음
		 * @return Boolean
		 * @author 정휘택
		 * @version 2009.10.20
		 */     
		function chkLclVvd() {
		
			var formObject = document.form;
			var sheetObj = sheetObjects[0];
			var lclVvd = formObject.lcl_vvd.value;
			var officeCd = formObject.ar_ofc_cd.text;
			
			if (lclVvd.length < 9) {
				ComShowCodeMessage("INV00039");
				return false;
			}
			
			if(officeCd != 'NYCRA'){
				if (lclVvd.substring(0,4) != "COMC" && lclVvd.substring(0,4) != "CNTC") {
					ComShowCodeMessage("INV00039");
					return false;
				}
			} else {
				if (lclVvd.substring(0,4) != "COMC" && lclVvd.substring(0,4) != "CNTC" && lclVvd.substring(0,4) != "LW1C" && lclVvd.substring(0,4) != "LW2C"  && lclVvd.substring(0,4) != "WLXC" && lclVvd.substring(0,4) != "WL1C" && lclVvd.substring(0,4) != "WL2C") {
					ComShowCodeMessage("INV00039");
					return false;
				}
			}
		 
			if (!ComIsNumber(lclVvd.substring(4,6))) {
				ComShowCodeMessage("INV00039");
				return false;
			}
		
			if (!ComIsMonth(lclVvd.substring(6,8))) {
				ComShowCodeMessage("INV00039");
				return false;
			}
		
			if (lclVvd.substring(8,9) != "M") {
				ComShowCodeMessage("INV00039");
				return false;
			}
			
			if (sheetObj.rowCount > 0) {
				for(var i=sheetObj.rowCount; i>0; i--){
					//vvd 계정 체크.
					// '411911','411915','710111'일 경우 vvd를 'CNTC'로 한다.
					if (sheetObj.CellValue(i, "ibflag") != "" && (sheetObj.CellValue(i, "acct_cd")=="411911" || 
						sheetObj.CellValue(i, "acct_cd")=="411915" || sheetObj.CellValue(i, "acct_cd")=="710111")) {
						
						if(officeCd != 'NYCRA'){
							if (lclVvd.substring(0,4) != "CNTC") {
								ComShowCodeMessage("INV00039");
								return false;
							}
						} else {
							if(sheetObj.CellValue(i, "acct_cd")=="411915"){
								if (lclVvd.substring(0,4) != "CNTC" && lclVvd.substring(0,4) != "LW1C" && lclVvd.substring(0,4) != "LW2C" && lclVvd.substring(0,4) != "WLXC" && lclVvd.substring(0,4) != "WL1C" && lclVvd.substring(0,4) != "WL2C") {
									ComShowCodeMessage("INV00039");
									return false;
								}
							}else{
								if (lclVvd.substring(0,4) != "CNTC" && lclVvd.substring(0,4) != "LW1C" && lclVvd.substring(0,4) != "LW2C" && lclVvd.substring(0,4) != "WLXC") {
									ComShowCodeMessage("INV00039");
									return false;
								}
							}
//							if (lclVvd.substring(0,4) != "CNTC" && lclVvd.substring(0,4) != "LW1C" && lclVvd.substring(0,4) != "LW2C" && lclVvd.substring(0,4) != "WLXC" && lclVvd.substring(0,4) != "WL1C" && lclVvd.substring(0,4) != "WL2C") {
//								alert("44");
//								ComShowCodeMessage("INV00039");
//								return false;
//							}
						}
					}
					
					if (sheetObj.CellValue(i, "ibflag") != "" && (sheetObj.CellValue(i, "acct_cd") != "411911" &&
						sheetObj.CellValue(i, "acct_cd") != "411915" && sheetObj.CellValue(i, "acct_cd") != "710111" && sheetObj.CellValue(i, "acct_cd") != "212111" )) {
							
						if (lclVvd.substring(0,4) != "COMC") {
							ComShowCodeMessage("INV00039");
							return false;
						}
					}
					
				}
			}
			
			return true;
		
		}   
		
		/** 
		 * LEHSC TVA 요율변경<br>
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  없음  
		 * @return 없음
		 * @see #
		 * @author 박정진
		 * @version 2009.04.27
		 */
		function lehbb_vat_rate_OnChange(){ 
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			lehbbVatRate = formObj.lehbb_vat_rate.value;
			
			formObj.inv_vat_chg_rt.value = lehbbVatRate;		
			formObj.tax_amount.value =  lehbbVatRate;
			
			//Amount 계산
			calLocalAmount();
    		//TVA Amount 계산
    		calTVAAmount(sheetObj, formObj);
    		//DR 그리드 세팅
    		drGridSet();
    		//CR 그리드 세팅
    		crGridSet();
    		//INV_AR_AMT 그리드 세팅
    		amtGridSet();

		}
	 
	/* 개발자 작업  끝 */