/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0127.js
*@FileTitle : Invoice Issue Inquiry by Invoice No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진
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
	 * @class fns_inv_0127 : fns_inv_0127 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0128() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
//		this.setTabObject 			= setTabObject;
//		this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	var sheetObjects = new Array();
	var sheetCnt = 0;
	

	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
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
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
								
				case "btn_close":
					window.close();
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
	 */
	function loadPage() {
		 
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		
		
//		//IBMultiCombo초기화
//		for(var k=0; k<comboObjects.length; k++){
//			initCombo(comboObjects[k],k+1);
//		}
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
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 322;
					//전체 너비 설정
					SheetWidth = clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					var HeadTitle = "|Update Date|Kind of Control|Reason for Control|Update Office|User ID|User Name";
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		100,    	daCenter,  false,   "sls_delt_eff_dt",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		220,    	daLeft,  false,   "bad_cust_knd_cd",		false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		180,    	daLeft,  false,   "bad_cust_rsn",			false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		120,    	daCenter,  false,   "upd_ofc",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		120,    	daCenter,  false,   "upd_usr_id",					false,    "",    dfNone    ,0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		120,    	daLeft,  false,   "upd_usr_nm",					false,    "",    dfNone    ,0,	false,		false);
					CountPosition = 2;
					
					WaitImageVisible=false;
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
	 * @version 2009.10.19
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
//		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
//		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
//		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
//		axon_event.addListenerForm ('focus', 'obj_activate', form);
//		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
//		axon_event.addListenerForm ('blur', 'obj_deactivate', form);
		
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
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
					
					formObj.f_cmd.value = SEARCH;

	     			ComOpenWait(true);

	     			sheetObj.DoSearch("FNS_INV_0128GS.do",FormQueryString(formObj));
	     			
	     			ComOpenWait(false);	     			
 												
 			break;
         }
     }

	

//	/** 
//	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
//	 * - curr_cd별 amount 합계를 계산하기 위한 함수
//	 * <br><b>Example :</b>
//	 * <pre>
//	 * 
//	 * </pre>
//	 * @param {ibsheet} sheetObj 필수 IBSheet Object
//	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
//	 * @return 없음
//	 * @see #
//	 * @author 박정진
//	 * @version 2009.05.04
//	 */ 	  	
//	function sheet1_OnSearchEnd(sheetObj, errMsg){
//		
////		var formObject = document.form;
////
////		var curs = "";
////		var sums = 0;
////	
////		if(sheetObj.RowCount > 0) {
////			for(i = 1 ; i < sheetObj.Rows; i++){
////				if (curs.indexOf(sheetObj.CellValue(i, "curr_cd")) == -1) {
////					curs = curs + sheetObj.CellValue(i, "curr_cd") +"|";
////					sums = Number(sums) + Number(sheetObj.CellValue(i, "grid_total"));
////				}
////			}
////		}
////		
////		sheetObj.SumValue(0,"local_total") = sums;
//	} 
	/* 개발자 작업  끝 */