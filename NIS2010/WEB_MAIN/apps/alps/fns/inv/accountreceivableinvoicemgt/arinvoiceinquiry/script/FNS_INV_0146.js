/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0146.js
*@FileTitle : Revenue & Expense Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.20
*@LastModifier : 박성용
*@LastVersion : 1.0
* 2018.06.20 박성용
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
	 * @class fns_inv_0146 : fns_inv_0146 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0146() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setTabObject			= setTabObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

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
	 * @author 박성용
	 * @version 2018.06.20
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
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);			
				break;

				case "btn_new":
					if(tabObjects[0].SelectedIndex == 0) {
						sheetObject1.RemoveAll();
						ComClearObject(formObject.rev_pol_cd);
						ComSetFocus(formObject.rev_pol_cd);
					} else {
						sheetObject2.RemoveAll();
						ComClearObject(formObject.exp_pol_cd);
						ComSetFocus(formObject.exp_pol_cd);
					}
				break;

				case "btn_save":
					if(tabObjects[0].SelectedIndex == 0) doActionIBSheet(sheetObject1,formObject,IBSAVE);
					else doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;
				
				case "btn_downexcel":
					if(tabObjects[0].SelectedIndex == 0) sheetObject1.SpeedDown2Excel(-1);
					else sheetObject2.SpeedDown2Excel(-1);
				break;
				
				case "btn_add1":
					if(validateForm(sheetObject1,formObject,"")) {
						
						ComSetObjValue(formObject.loc_cd, ComGetObjValue(formObject.rev_pol_cd));
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC10);
						
						if(!ComIsEmpty(formObject.rev_pol_cd)) {
							sheetObject1.DataInsert(-1);					
							sheetObject1.CellValue(sheetObject1.SelectRow, "port_cd") = ComGetObjValue(formObject.rev_pol_cd);
							sheetObject1.CellValue2(sheetObject1.SelectRow, "re_divr_cd") = "R";
							sheetObject1.CellValue2(sheetObject1.SelectRow, "curr_cd") = "CNY";
						}
					}
				break;
				
				case "btn_del1":
					var sRow = sheetObject1.FindCheckedRow("DelChk");
					if (sRow == "") return;
					
					//가져온 행을 배열로 반든다.
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"
					for (var idx=arrRow.length-2; idx>=0; idx--){
						var row = arrRow[idx];
						
						sheetObject1.RowHidden(row) = true;
						sheetObject1.RowStatus(row) = "D";
					}
				break;
				
				case "btn_add2":
					if(validateForm(sheetObject2,formObject,"")) {
						
						ComSetObjValue(formObject.loc_cd, ComGetObjValue(formObject.exp_pol_cd));
						doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC10);
						
						if(!ComIsEmpty(formObject.exp_pol_cd)) {
							sheetObject2.DataInsert(-1);					
							sheetObject2.CellValue(sheetObject2.SelectRow, "port_cd") = ComGetObjValue(formObject.exp_pol_cd);
							sheetObject2.CellValue2(sheetObject2.SelectRow, "re_divr_cd") = "E";
							sheetObject2.CellValue2(sheetObject2.SelectRow, "curr_cd") = "CNY";
						}
					}
				break;
				
				case "btn_del2":
					var sRow = sheetObject2.FindCheckedRow("DelChk");
					if (sRow == "") return;
					
					//가져온 행을 배열로 반든다.
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"
					for (var idx=arrRow.length-2; idx>=0; idx--){
						var row = arrRow[idx];
						
						sheetObject2.RowHidden(row) = true;
						sheetObject2.RowStatus(row) = "D";
					}
				break;
				
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBTab Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setTabObject(tab_obj)
	 * </pre>
	 * @param {ibtab} tab_obj 필수 IBTab Object
	 * @return 없음
	 * @author 박성용
	 * @version 2018.06.20
	 */      
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	/**
	 * Tab 기본 설정 <br> 
	 * 탭의 항목을 설정한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initTab(tabObj, tabNo)
	 * </pre>
	 * @param {ibtab} tabObj 필수 IBTab Object
	 * @param {int} tabNo 탭오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 박성용
	 * @version 2018.06.20
	 */       
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt  = 0 ;
				InsertTab( cnt++ , "Revenue" , -1 );
				InsertTab( cnt++ , "Expense" , -1 );
	
			}
			break;
	
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련 <br>
	 * 선택한 탭의 요소가 활성화 된다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     tab1_OnChange(tabObj, nItem);
	 * </pre>
	 * @param {ibtab} tabObj 필수 IBTab Object
	 * @param {int} nItem ibtab 해당 index
	 * @return 없음
	 * @author 박성용
	 * @version 2018.06.20
	 */        
	function tab1_OnChange(tabObj, nItem)
	{
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function loadPage() {
		
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
		
		var formObj = document.form;
		
		initControl();
		
		ComSetFocus(formObj.rev_pol_cd);
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 380;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					var HeadTitle = "|Sel|POL|re_divr_cd|re_port_seq|Curr|D2|T2|AWK2|D4/5|T4/5|AWK4/5|D7|DG7|Eff. From date|Eff. To date|Update Date|Update User";

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	25,    	daCenter,  false,  	"DelChk");
					InitDataProperty(0, cnt++ , dtData,    		55,   	daCenter,  false,	"port_cd",		true,     "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,     daCenter,  false,	"re_divr_cd",	false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,     daCenter,  false,	"re_port_seq",	false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,    		40,  	daCenter,  false,	"curr_cd",     	false,    "",	dfNone,		 0,	false,	false);				
					InitDataProperty(0, cnt++ , dtData,    		70,     daRight,   false,	"pcf_ut_amt1",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt2",	false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt3",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt4",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,  	daRight,   false,	"pcf_ut_amt5",  false,    "",	dfNullFloat, 2,	true,	true);					
					InitDataProperty(0, cnt++ , dtData,    		70,  	daRight,   false,	"pcf_ut_amt6",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt7",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt8",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		100,	daCenter,  false,	"fm_eff_dt",	true,     "",	dfDateYmd,	 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		100,	daCenter,  false,	"to_eff_dt",	true,     "",	dfDateYmd,	 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		120,	daCenter,  false,	"upd_dt",		false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,  false,	"upd_usr_id",	false,    "",	dfNone,		 0,	false,	false);
					
					InitDataValid(0, "port_cd", vtEngUpOther, "0123456789");
					
					WaitImageVisible=false;
				}
			break;
			
			case 2:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 380;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					var HeadTitle = "|Sel|POL|re_divr_cd|re_port_seq|Curr|D2|T2|AWK2|D4/5|T4/5|AWK4/5|D7|DG7|Eff. From date|Eff. To date|Update Date|Update User";

					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	25,    	daCenter,  false,  	"DelChk");
					InitDataProperty(0, cnt++ , dtData,    		55,   	daCenter,  false,	"port_cd",		true,     "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,     daCenter,  false,	"re_divr_cd",	false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		30,     daCenter,  false,	"re_port_seq",	false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,    		40,  	daCenter,  false,	"curr_cd",     	false,    "",	dfNone,		 0,	false,	false);				
					InitDataProperty(0, cnt++ , dtData,    		70,     daRight,   false,	"pcf_ut_amt1",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt2",	false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt3",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt4",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,  	daRight,   false,	"pcf_ut_amt5",  false,    "",	dfNullFloat, 2,	true,	true);					
					InitDataProperty(0, cnt++ , dtData,    		70,  	daRight,   false,	"pcf_ut_amt6",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt7",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		70,		daRight,   false,	"pcf_ut_amt8",  false,    "",	dfNullFloat, 2,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		100,	daCenter,  false,	"fm_eff_dt",	true,     "",	dfDateYmd,	 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		100,	daCenter,  false,	"to_eff_dt",	true,     "",	dfDateYmd,	 0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,    		120,	daCenter,  false,	"upd_dt",		false,    "",	dfNone,		 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,  false,	"upd_usr_id",	false,    "",	dfNone,		 0,	false,	false);
					
					InitDataValid(0, "port_cd", vtEngUpOther, "0123456789");
					
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function initControl() {
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
	 * @author 박성용
	 * @version 2018.06.20
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
					case "rev_pol_cd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "exp_pol_cd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
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

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function obj_activate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			default:
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function obj_focusout(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
	     			
					var sheetNo = 0;
					
					if(tabObjects[0].SelectedIndex == 0) {
						sheetObj = sheetObjects[0];
						sheetNo = 1;
						ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.rev_pol_cd));
						ComSetObjValue(formObj.re_ex_cd, "R");
					} else {
						sheetObj = sheetObjects[1];
						sheetNo = 2;
						ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.exp_pol_cd));
						ComSetObjValue(formObj.re_ex_cd, "E");
					}
					
	     			sheetObj.RemoveAll();
		 			ComOpenWait(true);
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0146GS.do", FormQueryString(formObj));
	 				
					sheetObj.Reset();
		 			initSheet(sheetObj, sheetNo);
		 			
	       			sheetObj.LoadSearchXml(sXml);
	     			
	     			ComOpenWait(false); 

				}

			break;
			
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
        			formObj.f_cmd.value = MULTI;
        			
        			var sFlg = sheetObj.DoSave("FNS_INV_0146GS.do", FormQueryString(formObj));
        			
        			if(sFlg) doActionIBSheet(sheetObj,formObj,IBSEARCH);		
        		}
 			break;
 			
			case IBSEARCH_ASYNC10: 
				formObj.f_cmd.value = SEARCH01;
 				var sXml = sheetObj.GetSearchXml("FNS_INV_0146GS.do", FormQueryString(formObj));
 				
 				if(CoInvShowXmlMessage(sXml) != "") {
 					if(tabObjects[0].SelectedIndex == 0) {
 						ComClearObject(formObj.rev_pol_cd);
 						ComAlertFocus(formObj.rev_pol_cd, CoInvShowXmlMessage(sXml));
 					} else {
 						ComClearObject(formObj.exp_pol_cd);
 						ComAlertFocus(formObj.exp_pol_cd, CoInvShowXmlMessage(sXml));
 					}
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		 if(tabObjects[0].SelectedIndex == 0) {
			 if(ComIsEmpty(formObj.rev_pol_cd)) {          		 
				 ComShowCodeMessage("INV00004");
				 ComSetFocus(formObj.rev_pol_cd);
				 return false;
			 }
		 } else {
			 if(ComIsEmpty(formObj.exp_pol_cd)) {          		 
				 ComShowCodeMessage("INV00004");
				 ComSetFocus(formObj.exp_pol_cd);
				 return false;
			 }
		 }
		
		 return true;
	}
	
	/* 개발자 작업  끝 */