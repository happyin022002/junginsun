/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0009.js
*@FileTitle : Invoice Inquiry by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.08 박정진
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
	 * @class fns_inv_0009 : fns_inv_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0009() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	var sheet_container = null;
	var sheet_history = null;
	var sheet_total = null;

	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
	 * @version 2009.06.08
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_cust": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				case "btns_container":
					ComOpenPopup('/hanjin/FNS_INV_0098.do?pagetype=I', 700, 380, '', '0,0');
				break; 					
			
			/*** Tab Total Amount (S) ***/
				case "btn_Retrieve":
					formObject.office.value = "";
					formObject.inv_dup_flg.value = "";
					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_t1new":
					removeAll(formObject);
				break;
				
			/*** Tab Total Amount (E) ***/					
 					

			/*** Tab History (S) ***/
				case "btn_t2new":
					removeAll(formObject);
				break; 
 					
				case "btn_t2downexcel":
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
				break;

				case "btn_t2history":
					var v_bl_src_no = formObject.bl_src_no.value;
					var v_bkg_no = formObject.bkg_no.value;
					var v_bl_tp_cd = formObject.bl_tp_cd.value;
					var v_bl_tp_cd = formObject.bl_tp_cd.value;
					var v_ar_ofc_cd = formObject.ar_ofc_cd.text;
					if (v_ar_ofc_cd == '') {
						v_ar_ofc_cd = formObject.ar_ofc_cd_text.value;
					}
					
					var classId = "FNS_INV_0010";
					
					var param = '?bl_src_no='+v_bl_src_no+'&bkg_no='+v_bkg_no+'&bl_tp_cd='+v_bl_tp_cd+'&ar_ofc_cd='+v_ar_ofc_cd+'&classId='+classId;
					
					ComOpenWindow('/hanjin/FNS_INV_0010.do' + param, 'FNS_INV_0010', 'width=850,height=700');
				break;
				
				case "btn_t2sysclear":
					doActionIBSheet(sheetObject3,formObject,IBROWSEARCH);
				break; 	
				
				case "btn_close":
					window.close();
				break;
				/*** Tab History (E) ***/
			} // end switch
		} catch(e) {
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
	 * @version 2009.06.08
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
	 * @version 2009.06.08
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
	 * @version 2009.06.08
	 */
	function loadPage() {
		sheet_container = sheetObjects[4];
		sheet_history = sheetObjects[2];
		sheet_total = sheetObjects[3];
		
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
		
		//각 그리드의 높이를 확인하여 전체높이를 변경하여 준다.(기본간격 : +5)
		//alert(sheetObjects[1].GetSheetHeight(13));  

		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
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
	 * @version 2009.06.08
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;
		var dpPrcsKntLocal = formObject.dp_prcs_knt_local.value;
		
		var setDpPrcsKnt = "";
		if (Number(dpPrcsKntLocal) > Number(dpPrcsKnt)) {
			setDpPrcsKnt = dpPrcsKntLocal;
		}
		else {
			setDpPrcsKnt = dpPrcsKnt;
		}
		
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 260;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					var HeadTitle = "|Cur|Amount|Ex. Rate|Local Amount";

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성         [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		79,     daCenter,	false,  "curr_cd",		false,      "",      dfNone,     	0,     true,       true);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,    	100,    daRight,	false,  "chg_amt",  	false,      "",      dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,    	100,    daRight,	false,  "chg_amt",  	false,      "",      dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,    		80,		daRight,	false,  "inv_xch_rt",	false,      "",      dfNullFloat, 	6);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtAutoSum,  100,	daRight,	false,	"local_total",	false,		"",      dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtAutoSum,  100,	daRight,	false,	"local_total",	false,		"",      dfInteger);
					}
					
					WaitImageVisible=false;
				}
			break;
                  
			case 2:      //t1sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 260;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(7, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "CHG|M/N|Cur|Rate|Rated As|Per|Amount";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성            [ROW, COL,    DATATYPE,     WIDTH, 	DATAALIGN, 	COLMERGE,  SAVENAME,  		KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,   cnt++ , dtData,    	70,   	daCenter,  	false,    "chg_cd",   		false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,  		70,   	daCenter,   false,    "mnl_flg",   		false,      "",      	dfNone);
					InitDataProperty(0,   cnt++ , dtData,    	50,   	daCenter,  	false,    "curr_cd",   		false,      "",      	dfNone);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0,   cnt++ , dtData,   100,  	daRight,  	false,    "trf_rt_amt",   	false,      "",      	dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0,   cnt++ , dtData,   100,  	daRight,  	false,    "trf_rt_amt",   	false,      "",      	dfInteger);
					}
					InitDataProperty(0,   cnt++ , dtData,    	90,   	daRight,  	false,    "rat_as_cntr_qty",false,      "",      	dfNullFloat,  	3);
					
					InitDataProperty(0,   cnt++ , dtData,  		50,   	daCenter,   false,    "per_tp_cd",    	false,      "",      	dfNone);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0,   cnt++ , dtData,   100,  	daRight,  	false,    "chg_amt",   		false,      "",      	dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0,   cnt++ , dtData,   100,  	daRight,  	false,    "chg_amt",   		false,      "",      	dfInteger);
					}
					
					WaitImageVisible=false;
				}
			break;                 
			case 3:      //t2sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 190;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 15, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(16, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "Seq.|I/F No.|Local VVD|Act Cust|Type|I/F Date|Good Date|Invoice No.|Auto|Cur|Amount|Ex. Rate|Local Amount|inv clr flg|arIfNo|invSplitCd";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//colHidden(10) = true;

					//데이터속성          [ROW, COL,    DATATYPE,   WIDTH, DATAALIGN, COLMERGE,  SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,  cnt++ , dtSeq,    	 35,    daCenter,  	false,    "Seq");
					InitDataProperty(0,  cnt++ , dtData,  	 95,   daCenter,   false,    "ar_if_no_inv_split_cd",	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     70,    daCenter,  	false,    "vvd",   			false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     65,    daCenter,  	false,    "cust_cd",   			false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     45,    daCenter,  	false,    "rev_type",   	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     70,    daCenter,  	false,    "bl_inv_if_dt",   false,        "",      dfDateYmd);
					InitDataProperty(0,  cnt++ , dtData,  	 70,    daCenter,   false,    "bl_inv_cfm_dt", 	false,        "",      dfDateYmd);

					InitDataProperty(0,  cnt++ , dtData,     100,   daCenter,  	false,    "inv_no",   		false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     65,	daCenter,  false,	  "auto_inv_iss_flg",  	   	false,    "",	dfNone);
					InitDataProperty(0,  cnt++ , dtData,     45,    daCenter,  	false,    "curr_cd",   		false,        "",      dfNone);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0,  cnt++ , dtData, 110,   daRight,  	false,    "chg_amt",   		false,        "",      dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0,  cnt++ , dtData, 110,   daRight,  	false,    "chg_amt",   		false,        "",      dfInteger);
					}
					InitDataProperty(0,  cnt++ , dtData,     100,   daRight,  	false,    "inv_xch_rt",   	false,        "",      dfNullFloat,     6);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0,  cnt++ , dtData, 110,   daRight,    false,    "local_total",  	false,        "",      dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0,  cnt++ , dtData, 110,   daRight,    false,    "local_total",  	false,        "",      dfInteger);
					}

					InitDataProperty(0,  cnt++ , dtHidden, 	 150,   daCenter,   false,    "inv_clr_flg",  	false,        "",      dfNone,      	0,     true,       true);
					InitDataProperty(0,  cnt++ , dtHidden,   110,   daCenter,  	false,    "ar_if_no",   	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtHidden,   110,   daCenter,  	false,    "inv_split_cd",	false,        "",      dfNone);
					
					CountPosition = 0;
					
					WaitImageVisible=false;
				}
			break; 
			
			case 4:      //t2sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 67;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle = "|Cur|Amount|Ex.Rate|Local Total";
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false, true);
					
					//colHidden(4) = true;
			
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		45,     daCenter,	false,   "curr_cd",		false,    "",    dfNone);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData, 	120,	daRight,	false,   "chg_amt",		false,    "",    dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData, 	120,	daRight,	false,   "chg_amt",		false,    "",    dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,    		100,	daRight,	false,   "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,   "local_total",	false,    "",    dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,   "local_total",	false,    "",    dfInteger);
					}
					
					CountPosition = 0;
					
					WaitImageVisible=false;
				}
			break;
			
			case 5:      //Container init
				with (sheetObj) {
					// 높이 설정
					style.height = 100;
	                
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(3, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle1 = " |Cntr_tpsz_cd|Cntr_no";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
	                InitHeadRow(0, HeadTitle1, true);
	                
	                WaitImageVisible = false;
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
	                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_tpsz_cd", 	false,     "",      dfNone,    0,  false,	false);
	                InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_no",   		false,     "",      dfNone,    0,  false,	false);
	                
	                CountPosition = 0;
	                
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
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.06.08
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
		}
  	}

	/** 
	 * Tab 초기설정값<br>
	 * 탭의 항목을 설정한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBTab} tabObjects  tabObjects
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.06.08
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt  = 0 ;
					InsertTab( cnt++ , "Total Amount" , -1 );
					InsertTab( cnt++ , "History" , -1 );
				}
			break;
		}
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
	 * @version 2009.06.08
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('click', 'revType_click', 'chk_rev_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	 * @version 2009.06.08
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "engup":
				switch(event.srcElement.name){
					case "inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "ar_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bkg_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "act_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "inv_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_curr_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_clt_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;

				}
			break;          
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;          
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
	 * @version 2009.06.08
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
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
	 * @version 2009.06.08
	 */
	function obj_deactivate(){
		switch(event.srcElement.name){
			case "date_value":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
			case "port":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
        }
	}

	function revType_click() {
		var obj = event.srcElement;
		doEnableRevType(obj);
	}

	function doEnableRevType(obj) {
		var formObj = document.form;
		
		// All (전체)
		if(obj.value == 'A') {
			if(obj.checked) {
				ComEnableObject(formObj.chk_rev_type[1], false);	//	B/L
				ComEnableObject(formObj.chk_rev_type[2], false);	//	C/A
				ComEnableObject(formObj.chk_rev_type[3], false);	//	DEM/DET
				ComEnableObject(formObj.chk_rev_type[4], false);	//	Mis
				
	 	 		formObj.chk_rev_type[1].checked = false;
	 	 		formObj.chk_rev_type[2].checked = false;
	 	 		formObj.chk_rev_type[3].checked = false;
	 	 		formObj.chk_rev_type[4].checked = false;
	 	 		
	 	 		formObj.rev_type_A.value = "A";
	 	 		
	 	 		formObj.rev_type_B.value = "";
	 	 		formObj.rev_type_C.value = "";
	 	 		formObj.rev_type_D.value = "";
	 	 		formObj.rev_type_M.value = "";
			} else {
				ComEnableObject(formObj.chk_rev_type[1], true);
				ComEnableObject(formObj.chk_rev_type[2], true);
				ComEnableObject(formObj.chk_rev_type[3], true);
				ComEnableObject(formObj.chk_rev_type[4], true);
				
	 	 		formObj.rev_type_A.value = "";
			}
		}
		// B/L:B(REV_TP_CD = 'B')
		else if(obj.value == 'B') {
			if(obj.checked) {
				formObj.rev_type_A.value = "";
				formObj.rev_type_B.value = "B";
			} else {
				formObj.rev_type_B.value = "";
			}
		}
		// C/A:C(REV_TP_CD = 'C')
		else if(obj.value == 'C') {
			if(obj.checked) {
				formObj.rev_type_A.value = "";
				formObj.rev_type_C.value = "C";
			} else {
				formObj.rev_type_C.value = "";
			}
		}
		// DEM:D(REV_TP_CD = 'M' REV_SRC_CD = 'DT')
		else if(obj.value == 'D') {
			if(obj.checked) {
				formObj.rev_type_A.value = "";
				formObj.rev_type_D.value = "D";
			} else {
				formObj.rev_type_D.value = "";
			}
		}
		// DEM:D(REV_TP_CD = 'M' REV_SRC_CD <> 'DT')
		else if(obj.value == 'M') {
			if(obj.checked) {
				formObj.rev_type_A.value = "";
				formObj.rev_type_M.value = "M";
			} else {
				formObj.rev_type_M.value = "";
			}
		}
		
		formObj.rev_type.value = formObj.rev_type_A.value + formObj.rev_type_B.value + formObj.rev_type_C.value + formObj.rev_type_D.value + formObj.rev_type_M.value;
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
	 * @version 2009.06.08
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		var rtnStr = "Delay Time \n"; // <- 테스트후 삭제처리
		try{ // <- 테스트후 삭제처리
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					sheetObjects[0].Reset();
					sheetObjects[1].Reset();
					sheetObjects[2].Reset();
					sheetObjects[3].Reset();
					sheetObjects[4].Reset();
					
	     			
					// 탭위치 초기화
					//tabObjects[0].SelectedIndex = 0;
					
					// OFFICE
					var viewBlSrcNo = formObj.view_bl_src_no.value;
					var viewArOfcCd = formObj.view_ar_ofc_cd.value;
					
					ComOpenWait(true);
                    
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0009GS.do", FormQueryString(formObj));
					
	     			var arrXml = sXml.split("|$$|");
	     			
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     				var blSrcNo = formObj.bl_src_no.value;
	     				var arOfcCd = formObj.ar_ofc_cd.text;
	     				var revType = formObj.rev_type.value;
		     			
	     				removeAll(formObj);
		     			
	     				formObj.bl_src_no.value = blSrcNo;
	     				formObj.ar_ofc_cd.text = arOfcCd;
	     				formObj.rev_type.value = revType;
	     				
						if (revType.length > 0) {
							if (revType == "A") {
								ComEnableObject(formObj.chk_rev_type[1], false);
								ComEnableObject(formObj.chk_rev_type[2], false);
								ComEnableObject(formObj.chk_rev_type[3], false);
								ComEnableObject(formObj.chk_rev_type[4], false);
								
								formObj.chk_rev_type[0].checked = true;
								formObj.chk_rev_type[1].checked = false;
								formObj.chk_rev_type[2].checked = false;
								formObj.chk_rev_type[3].checked = false;
								formObj.chk_rev_type[4].checked = false;
							}
							else {
								ComEnableObject(formObj.chk_rev_type[1], true);
								ComEnableObject(formObj.chk_rev_type[2], true);
								ComEnableObject(formObj.chk_rev_type[3], true);
								ComEnableObject(formObj.chk_rev_type[4], true);
								
								if (revType.indexOf("B") > -1) {
									formObj.chk_rev_type[1].checked = true; 
									formObj.chk_rev_type[0].checked = false;
								}
								if (revType.indexOf("C") > -1) {
									formObj.chk_rev_type[2].checked = true; 
									formObj.chk_rev_type[0].checked = false;
								}
								if (revType.indexOf("D") > -1) {
									formObj.chk_rev_type[3].checked = true; 
									formObj.chk_rev_type[0].checked = false;
								}
								if (revType.indexOf("M") > -1) {
									formObj.chk_rev_type[4].checked = true; 
									formObj.chk_rev_type[0].checked = false;
								}
							}
						}
		     			

		     			ComOpenWait(false); 
		     			
		     			
	     				ComAlertFocus(formObj.bl_src_no, CoInvShowXmlMessage(arrXml[0]));
					} else {
						if (arrXml.length > 0) {
							var ar_ofc_cd = "";
							
							var sStr = ComGetEtcData(arrXml[0],"ar_ofc_cd");
							if (sStr != null) {
								var arrStr = sStr.split("|");
								if (arrStr.length > 2) {
									document.getElementById('arOfcCdDiv1').style.display = "none";
									document.getElementById('arOfcCdDiv2').style.display = "block";
									
									MakeComboObject(formObj.ar_ofc_cd, arrStr);
								}
								else {
									var arrStr2 = arrStr[1].split("^");
									ar_ofc_cd = arrStr2[0];
									
									document.getElementById('arOfcCdDiv1').style.display = "block";
									document.getElementById('arOfcCdDiv2').style.display = "none";
								}
							}
			     			
							var currPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt");
							var lclCurrPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt_local");
							
							var list = ComXml2ListMap(arrXml[0]);
			     			
							//조회조건 저장
							var blSrcNo = "";
							var bkgNo = "";
							var blTpCd = "";
							var arOfcCd = "";
							var revType = "";
							var revTypeA = "";
							var revTypeB = "";
							var revTypeC = "";
							var revTypeD = "";
							var revTypeM = "";
		
							if (list.length > 0) {
								var expensInfo  = list[0];
								
								if (expensInfo["act_cust_cnt_cd"] != '') {
									var vRevTpCd = "";
									var vRevSrcCd = "";
									
									//조회조건 저장
									blTpCd = formObj.bl_tp_cd.value;
									revType = formObj.rev_type.value;
									
									revTypeA = formObj.rev_type_A.value;
									revTypeB = formObj.rev_type_B.value;
									revTypeC = formObj.rev_type_C.value;
									revTypeD = formObj.rev_type_D.value;
									revTypeM = formObj.rev_type_M.value;
									
									ComMapToForm(formObj,expensInfo);
									
									formObj.bl_tp_cd.value = blTpCd;
									formObj.rev_type.value = revType;
									
									formObj.rev_type_A.value = revTypeA;
									formObj.rev_type_B.value = revTypeB;
									formObj.rev_type_C.value = revTypeC;
									formObj.rev_type_D.value = revTypeD;
									formObj.rev_type_M.value = revTypeM;
									
									if (revType.length > 0) {
										if (revType.indexOf("B") > -1) {
											formObj.chk_rev_type[1].checked = true; 
											formObj.chk_rev_type[0].checked = false;
										}
										if (revType.indexOf("C") > -1) {
											formObj.chk_rev_type[2].checked = true; 
											formObj.chk_rev_type[0].checked = false;
										}
										if (revType.indexOf("D") > -1) {
											formObj.chk_rev_type[3].checked = true; 
											formObj.chk_rev_type[0].checked = false;
										}
										if (revType.indexOf("M") > -1) {
											formObj.chk_rev_type[4].checked = true; 
											formObj.chk_rev_type[0].checked = false;
										}
									}
									else {
										formObj.chk_rev_type[0].checked = true;
										
										formObj.chk_rev_type[1].checked = false;
										formObj.chk_rev_type[2].checked = false;
										formObj.chk_rev_type[3].checked = false;
										formObj.chk_rev_type[4].checked = false;
									}
								}
							}
						}
		     			
						formObj.dp_prcs_knt.value = currPoint;
						formObj.dp_prcs_knt_local.value = lclCurrPoint;
						
						if (ar_ofc_cd != '') {
							formObj.ar_ofc_cd_text.value = ar_ofc_cd;
						}
						else {
							formObj.ar_ofc_cd_text.value = expensInfo["ar_ofc_cd"];
						}
		 				
						if (arrXml.length > 1) {
							initSheet(sheetObjects[0],1);
							initSheet(sheetObjects[3],4);
							
							sheetObjects[0].MessageText("Sum") = "TTL LCL";
							sheetObjects[0].LoadSearchXml(arrXml[1]);
							sheetObjects[3].LoadSearchXml(arrXml[1]);
							
							var invXchRt = "";
							var invXchRtZero = "";
							
							// 환율 null 체크
							for (var i = 1; i <= sheetObjects[0].rowCount; i++) {
								if("" == sheetObjects[0].cellValue(i,3)) {
									invXchRtZero = "Y";
								}
							}
							// 환율이 null인 것이 하나도 없을 경우 합계를 보여준다.
							if (invXchRtZero != "") {
								sheetObjects[0].SumValue(0, "local_total") = "";
							}
						}
		     			
						if (arrXml.length > 2) {
							initSheet(sheetObjects[1],2);
							sheetObjects[1].LoadSearchXml(arrXml[2]);
						}
		     			
						if (arrXml.length > 3) {
							initSheet(sheetObjects[2],3);
							sheetObjects[2].LoadSearchXml(arrXml[3]);
						}
		     			
						if (arrXml.length > 4) {
							initSheet(sheetObjects[4],5);
							sheetObjects[4].LoadSearchXml(arrXml[4]);
						}
		     			
		     			ComOpenWait(false);
		     			
		     			
					}
	     			
	     			ComOpenWait(false);
				}
			break;

			case IBROWSEARCH:   //SYS CLEAR
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, 13) == "Y") {
						if(sheetObj.RowHidden(i)) {
							sheetObj.RowHidden(i) = false;
						}
						else {
							sheetObj.RowHidden(i) = true;
						}
					}
				}
			break;
			
			case IBSEARCH_ASYNC11: // popup 조회시 AR Office 조회
				formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0009GS.do", FormQueryString(formObj), "", true);
				if(CoInvShowXmlMessage(sXml) != "") {
					ComAlertFocus(formObj.bl_src_no, CoInvShowXmlMessage(sXml));
				}
				else {
					var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
					var arrStr2 = sStr.split("^");
					var ar_ofc_cd = arrStr2[0];
					
					formObj.ar_ofc_cd.InsertItem(-1, ar_ofc_cd, arrStr2[i]);
	
					formObj.ar_ofc_cd.text = ar_ofc_cd;
					formObj.ar_ofc_cd_text.value = ar_ofc_cd;
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
			break;
			
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.Down2Excel(-1);
			break; 

		}
		 // <- 테스트후 삭제처리 시작
		}catch(e){
			ComOpenWait(false); 
			
			alert(rtnStr);
		}
		 // <- 테스트후 삭제처리 끝
	}
	// <- 테스트후 삭제처리 시작
	function textarea_write(msg){
		document.form.SEARCH_LOG.value = 	document.form.SEARCH_LOG.value+"\n"+msg;
	}
	 // <- 테스트후 삭제처리 끝

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
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
	 * @version 2009.06.08
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			 if("" == bl_src_no.value && "" == bkg_no.value) {
				 ComShowCodeMessage("COM12114", "B/L No, BKG No");
				 bl_src_no.focus();
				 return false;
			 }
			 if(chk_rev_type[0].checked == false && chk_rev_type[1].checked == false && chk_rev_type[2].checked == false && chk_rev_type[3].checked == false && chk_rev_type[4].checked == false) {
				 chk_rev_type[0].checked = true;
				 chk_rev_type[1].checked = false;
				 chk_rev_type[2].checked = false;
				 chk_rev_type[3].checked = false;
				 chk_rev_type[4].checked = false;
				 
				ComEnableObject(chk_rev_type[1], false);
				ComEnableObject(chk_rev_type[2], false);
				ComEnableObject(chk_rev_type[3], false);
				ComEnableObject(chk_rev_type[4], false);
			 }
		}

		return true;
	}

    /** 
     * Tab 클릭시 이벤트 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBTab} tabObj        
     * @param  {object} nItem        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.06.08
     */
	function tab1_OnChange(tabObj , nItem) {
		var objs = document.all.item("tabLayer");
		
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}

    /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.06.08
     */	  	
	function t1sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		initControl();
		
		var viewBlSrcNo = formObj.view_bl_src_no.value;
		var viewArOfcCd = formObj.view_ar_ofc_cd.value;
		
		removeAll(formObj);
		
		ComEnableObject(formObj.bl_src_no,true);
		ComEnableObject(formObj.bkg_no,true);
		
		formObj.bl_src_no.className = "input1";
		formObj.bl_src_no.tabIndex = "";
		formObj.bkg_no.className = "input1";
		formObj.bkg_no.tabIndex = "";

		formObj.ar_ofc_cd.Enable = true;

		ComBtnEnable("btn_t1new");
		ComBtnEnable("btn_t2new");
		ComBtnEnable("btn_Retrieve");
		
		if (viewBlSrcNo != '' && viewArOfcCd != '') {
			ComEnableObject(formObj.bl_src_no,false);
			ComEnableObject(formObj.bkg_no,false);
			
			formObj.bl_src_no.className = "input2";
			formObj.bl_src_no.tabIndex = "-1";
			formObj.bkg_no.className = "input2";
			formObj.bkg_no.tabIndex = "-1";
			
			formObj.ar_ofc_cd.Enable = false;
			
			ComEnableObject(formObj.chk_rev_type[0], false);
			
			ComBtnDisable("btn_t1new");
			ComBtnDisable("btn_t2new");
			ComBtnDisable("btn_Retrieve");

			formObj.bl_src_no.value = viewBlSrcNo;
			formObj.login_ofc_cd.value = viewArOfcCd;
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11);
		}
		else {
			formObj.bl_src_no.focus();
		}
	}

    /** 
	 * 셀을 클릭했을때 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.06.08
     */
	function t2sheet1_OnDblClick(sheetObj, Row, Col) {
	   	var formObj = document.form;
   		var arIfNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_if_no"), " ", "");
   		var invSplitCd = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "inv_split_cd"), " ", "");
		var arOfcCd = "";
		if (formObj.ar_ofc_cd.text != '') {
			arOfcCd = formObj.ar_ofc_cd.text;
		}
		else {
			arOfcCd = formObj.ar_ofc_cd_text.value;
		}
		
		var classId = "FNS_INV_0011";
		var param = '?pgmNo=FNS_INV_0011-01&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId+'&inv_split_cd='+invSplitCd;
   		
		ComOpenWindow('/hanjin/FNS_INV_0011.do' + param, 'FNS_INV_0011', 'width=1000,height=595');
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
		
		var firstView = false;
		if (formObj.office.value == '' && formObj.inv_dup_flg.value == '') {
			firstView = true;
		}
		else {
			firstView = false;
		}
		
		if (formObj.ar_ofc_cd.text != '') {
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
 			formObj.office.value = arrStr2[0];
 			formObj.inv_dup_flg.value = arrStr2[1];

 			// 최초 조회 시에는 onChange 이벤트에 의하여 조회를 진행하지 않는다. (중복조회 오류수정)
 			if (!firstView) { 			
 				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 			}
		}
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
	 * @version 2009.06.08
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		document.getElementById('arOfcCdDiv1').style.display = "block";
		document.getElementById('arOfcCdDiv2').style.display = "none";
		
		// 탭위치 초기화
		tabObjects[0].SelectedIndex = 0;
		
		ComEnableObject(formObj.chk_rev_type[1], false);
		ComEnableObject(formObj.chk_rev_type[2], false);
		ComEnableObject(formObj.chk_rev_type[3], false);
		ComEnableObject(formObj.chk_rev_type[4], false);
	 	
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		
		comboObjects[0].RemoveAll(); 
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
	 * @version 2009.06.08
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[0];
			
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		//cmbObj.BackColor = "#CCFFFD";
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
	 * @version 2009.06.08
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
	 * @version 2009.06.08
	 */
	function ComMapToForm(form, map) {		
		//사용가능한 컨트롤을 배열로 생성한다.
		var len = form.elements.length;
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
							case "cr_amt":
								form.elements[i].value = ComAddCommaRun(xvalue);
							break;
							case "cgo_wgt":
								form.elements[i].value = ComAddCommaRun(xvalue);
							break;
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
								if (xvalue.length == 10) {
									form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
								}
								else {
									form.elements[i].value = xvalue;
								}
							break;
							default:
								form.elements[i].value = xvalue;
							break;
						}
						break;
				}
			}
			
			if(form.elements[i].name == 'ar_ofc_cd') {
				var xvalue = map[form.elements[i].name];
				form.ar_ofc_cd.text = xvalue;
			}
		}
	}

	/** 
	 * 팝업창(getFNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.06.08
	 */
	function getFNS_INV_0013() {
		
	}

	/* 개발자 작업  끝 */