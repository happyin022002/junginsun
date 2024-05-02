/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0010.js
*@FileTitle : Invoice Inquiry by B/L No (History Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.11 박정진
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
     * @class fns_inv_0010 : fns_inv_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0010() {
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

	//공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
    
	var sheetObjects = new Array();
	var sheetCnt = 0;

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

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_sysclear":
					doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
				break; 

				case "btn_close":
					window.close();
				break; 
			} // end switch
		}
		catch(e) {
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
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var sXml1 = IBS_GetDataSearchXml(opener.sheet_history);
		sheetObjects[0].LoadSearchXml(sXml1, true);
		
		var sXml2 = IBS_GetDataSearchXml(opener.sheet_total);
		sheetObjects[1].LoadSearchXml(sXml2, true);
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
		var cnt = 0;
		var dpPrcsKnt = opener.document.form.dp_prcs_knt.value;
		var dpPrcsKntLocal = opener.document.form.dp_prcs_knt_local.value;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 395;
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
					InitColumnInfo(15, 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
	
					var HeadTitle = "Seq.|I/F No.|Loacal VVD|Act Cust|Type|I/F Date|Good Date|Invoice No.|Cur|Amount|Ex. Rate|Local Amount|inv clr flg|arIfNo|invSplitCd";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//colHidden(10) = true;
	
					//데이터속성          [ROW, COL,    DATATYPE,   WIDTH, DATAALIGN, COLMERGE,  SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,  cnt++ , dtSeq,    	 35,    daCenter,  	false,    "Seq");
					InitDataProperty(0,  cnt++ , dtData,  	 85,    daCenter,   false,    "ar_if_no_inv_split_cd",   	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     70,    daCenter,  	false,    "vvd",   			false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     65,    daCenter,  	false,    "cust_cd",   		false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     40,    daCenter,  	false,    "rev_type",   	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     70,    daCenter,  	false,    "bl_inv_if_dt",   false,        "",      dfDateYmd);
					InitDataProperty(0,  cnt++ , dtData,  	 70,    daCenter,   false,    "bl_inv_cfm_dt", 	false,        "",      dfDateYmd);
	
					InitDataProperty(0,  cnt++ , dtData,     75,    daCenter,  	false,    "inv_no",   		false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtData,     45,    daCenter,  	false,    "curr_cd",   		false,        "",      dfNone);
					if (dpPrcsKnt > 0) {
						InitDataProperty(0,  cnt++ , dtData, 85,   daRight,  	false,    "chg_amt",   		false,        "",      dfNullFloat, 	dpPrcsKnt);
					}
					else {
						InitDataProperty(0,  cnt++ , dtData, 85,   daRight,  	false,    "chg_amt",   		false,        "",      dfInteger);
					}
					InitDataProperty(0,  cnt++ , dtData,     80,    daRight,  	false,    "inv_xch_rt",   	false,        "",      dfNullFloat,     6);
					if (dpPrcsKntLocal > 0) {
						InitDataProperty(0,  cnt++ , dtData, 85,   daRight,    false,    "local_total",  	false,        "",      dfNullFloat, 	dpPrcsKntLocal);
					}
					else {
						InitDataProperty(0,  cnt++ , dtData, 85,   daRight,    false,    "local_total",  	false,        "",      dfInteger);
					}
	
					InitDataProperty(0,  cnt++ , dtHidden, 	 80 ,   daCenter,   false,    "inv_clr_flg",  	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtHidden, 	 90,    daCenter,   false,    "ar_if_no",   	false,        "",      dfNone);
					InitDataProperty(0,  cnt++ , dtHidden, 	 90,    daCenter,   false,    "inv_split_cd",  	false,        "",      dfNone);
				}
			break;
			case 2:      //sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = 100;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle = "|Curr|Amount|Ex.Rate|Local Total";
	
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
					if (dpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData, 	85,		daRight,	false,   "chg_amt",		false,    "",    dfNullFloat, 	dpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData, 	85,		daRight,	false,   "chg_amt",		false,    "",    dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,    		80,		daRight,	false,   "inv_xch_rt",	false,    "",    dfNullFloat, 	6);
					if (dpPrcsKntLocal > 0) {
						InitDataProperty(0, cnt++ , dtData,		85,		daRight,	false,   "local_total",	false,    "",    dfNullFloat, 	dpPrcsKntLocal);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,		85,		daRight,	false,   "local_total",	false,    "",    dfInteger);
					}
					
					CountPosition = 0; 
				}
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
	 * @version 2009.06.08
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBROWSEARCH:   //SYS CLEAR
				for ( var i = 1; i <= sheetObj.RowCount; i++) {
					if (sheetObj.CellValue(i, 12) == "Y") {
						if(sheetObj.RowHidden(i)) {
							sheetObj.RowHidden(i) = false;
						}
						else {
							sheetObj.RowHidden(i) = true;
						}
					}
				}
			break;
		}
	}

	/**
	 * 셀을 클릭했을때 발생하는 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.06.08
	 **/
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	   	var formObj = document.form;
   		var arIfNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_if_no"), " ", "");
   		var invSplitCd = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "ar_if_no"), " ", "");
		var arOfcCd = formObj.ar_ofc_cd.value;
		
		var classId = "FNS_INV_0011";
   		var param = '?pgmNo=FNS_INV_0011-01&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId+'&inv_split_cd='+invSplitCd;
   		
		ComOpenWindow('/hanjin/FNS_INV_0011.do' + param, 'FNS_INV_0022', 'width=1100,height=635');
	}

	/* 개발자 작업  끝 */