/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0147.js
*@FileTitle : PCF Status Report
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
	 * @class fns_inv_0147 : fns_inv_0147 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0147() {
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
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);			
				break;

				case "btn_new":
					formObject.reset();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					initSheet(sheetObject3,3);
		    		setVVD(sheetObject3, 2);
					ComSetFocus(formObject.input_vvd);
				break;
				
				case "btn_downexcel":
					if(tabObjects[0].SelectedIndex == 0) sheetObject1.SpeedDown2Excel(-1);
					else sheetObject2.SpeedDown2Excel(-1);
				break;
				
				case "btn_input_vvd":					
					if (document.getElementById("vvd_input").style.display == "block") {
						setVVD(sheetObject3, 1);
					} else {
						setVVD(sheetObject3, 2);
					}
				break;
				
				case "btns_calendar1": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.fm_atd_dt, 'yyyy-MM-dd');
	            break;
	            
				case "btns_calendar2": //달력버튼
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.to_atd_dt, 'yyyy-MM-dd');
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
		
		if (sheet_obj.id =="sheet1"){
			sheetCnt = 0;
	  	} else if(sheet_obj.id =="sheet2") {
	  		sheetCnt = 1;
	  	} else {
	  		sheetCnt = 2;
	  	}
		
	    sheetObjects[sheetCnt] = sheet_obj;
     
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
		
		setVVD(sheetObjects[2], 1);
		setVVD(sheetObjects[2], 2);
		
		ComSetFocus(formObj.input_vvd);
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
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					var HeadTitle0 = "|Agent|VVD|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount" +
									 "|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|No. of CNTR by type and PCF REV. amount|TTL";

					var HeadTitle1 = "|Agent|VVD|D2|AMT|T2|AMT|AWK2|AMT|D4/5|AMT|T4/5|AMT|AWK45|AMT|D7|AMT|DG7|AMT|TTL";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, false);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,  		80,    	daCenter,  true,  	"chn_agn_cd");
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  true,	"vvd_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,  	40,     daRight,   false,	"cnt1",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,  	70,     daRight,   false,	"amt1",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,  	daRight,   false,	"cnt2", 	false,    "",	dfInteger);				
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,     daRight,   false,	"amt2", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt3",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt3", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt4", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,  	daRight,   false,	"amt4", 	false,    "",	dfNullFloat, 2);					
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,  	daRight,   false,	"cnt5", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt5", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	47,		daRight,   false,	"cnt6", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt6",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt7",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt7",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt8",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt8",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	80,		daRight,   true,	"tot_amt",	false,    "",	dfNullFloat, 2);
					
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
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
					
					var HeadTitle0 = "|Terminal|VVD|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount" +
					 				 "|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|No. of CNTR by type and PCF EXP. amount|TTL";

					var HeadTitle1 = "|Terminal|VVD|D2|AMT|T2|AMT|AWK2|AMT|D4/5|AMT|T4/5|AMT|AWK45|AMT|D7|AMT|DG7|AMT|TTL";

					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, false);
					
					//데이터속성          [ROW, COL,  DATATYPE,  		WIDTH,  DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,  true,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,  		80,    	daCenter,  true,  	"tmnl_cd");
					InitDataProperty(0, cnt++ , dtData,    		80,   	daCenter,  true,	"vvd_cd");
					InitDataProperty(0, cnt++ , dtAutoSum,  	40,     daRight,   false,	"cnt1",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,  	70,     daRight,   false,	"amt1",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,  	daRight,   false,	"cnt2", 	false,    "",	dfInteger);				
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,     daRight,   false,	"amt2", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt3",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt3", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt4", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,  	daRight,   false,	"amt4", 	false,    "",	dfNullFloat, 2);					
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,  	daRight,   false,	"cnt5", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt5", 	false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	47,		daRight,   false,	"cnt6", 	false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt6",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt7",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt7",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	40,		daRight,   false,	"cnt8",		false,    "",	dfInteger);
					InitDataProperty(0, cnt++ , dtAutoSum,    	70,		daRight,   false,	"amt8",		false,    "",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtAutoSum,    	80,		daRight,   true,	"tot_amt",	false,    "",	dfNullFloat, 2);
					
					WaitImageVisible=false;
				}
			break;
			
			case 3:      //sheet3 init
	             
	            with (sheetObj) {

	      			// 높이 설정
	      			style.height = 142;
	      			// 전체 너비 설정
	      			SheetWidth = 220;

	      			// Host정보 설정[필수][HostIp, Port, PagePath]
	      			if (location.hostname != "")
	      				InitHostInfo(location.hostname, location.port, page_path);

	      			// 전체Merge 종류 [선택, Default msNone]
	      			MergeSheet = msHeaderOnly;

	      			// 전체Edit 허용 여부 [선택, Default false]
	      			Editable = true;
	      			
	      			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	      			InitRowInfo(1, 1, 2, 100);

	      			var HeadTitle1 = " |vvd_cd|vvd_combo";
	      			var headCount = ComCountHeadTitle(HeadTitle1);

	      			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	      			InitColumnInfo(headCount, 0, 0, true);

	      			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	      			InitHeadMode(true, true, false, true, false, false);

	      			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	      			InitHeadRow(0, HeadTitle1, true);
	      			
	      		    //var prefix3="sheet3_";
	      			
	        		InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true,  "ibflag",    false, "", dfNone,     0, true, true, 12);
	      			InitDataProperty(0, cnt++, dtData,         70, daLeft, true,  "vvd_cd",    false, "", dfEngUpKey, 0, true, true, 9);
	      			InitDataProperty(0, cnt++, dtHidden,       0,  daLeft, true,  "vvd_combo", false, "", dfNone,     0, true, true);

	      			CountPosition = 0;

	      			// row 50개 생성 후
	      			// input_bl_no.value 값을 초기 Row에 설정 후
	      			// 타이틀 제거

	      	    	for ( var i = 1; i <= 50; i++) {
	      	    		DataInsert(-1);
	      			    CellValue(i, "ibflag") = "R";
	      	   	    }

	      		    CellValue2(1,  "vvd_cd") = formObject.input_vvd.value;
	      		    SelectCell(1, "vvd_cd");
	      		    RowHidden(0) = true;
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
					case "input_vvd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "pol_cd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "chn_agn_cd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "tmnl_cd":
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
			case "fm_atd_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
			case "to_atd_dt":
				//마스크 구분자 없애기
				ComClearSeparator (event.srcElement);
			break;
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
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "fm_atd_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_atd_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "fm_atd_dt":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					ComSetFocus(formObject.to_atd_dt);
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
	 * @author 박성용
	 * @version 2018.06.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				
				if(validateForm(sheetObj,formObj,sAction)) {
					
					ComOpenWait(true);
					
					formObj.f_cmd.value = SEARCH;
	     			
					var sheetNo = 0;
					
					if(tabObjects[0].SelectedIndex == 0) {
						sheetObj = sheetObjects[0];
						sheetNo = 1;
						ComSetObjValue(formObj.re_divr_cd, "R");
					} else {
						sheetObj = sheetObjects[1];
						sheetNo = 2;
						ComSetObjValue(formObj.re_divr_cd, "E");
					}
					
					var vvdCd = "";

				    for (var i = 0; i < sheetObjects[2].RowCount; i++) {
				    	if (sheetObjects[2].CellValue(i+1, "vvd_cd") != ""){
				    		vvdCd = vvdCd + sheetObjects[2].CellValue(i+1, "vvd_cd") + ",";
				    	}
				    } 			    
				    
				    if( vvdCd == "" && formObj.input_vvd.value !=""){
				    	vvdCd = formObj.input_vvd.value;
				    }
				  
				    formObj.vvd_cd.value = vvdCd;
				    
	     			sheetObj.RemoveAll();
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0147GS.do", FormQueryString(formObj));
	 				
					sheetObj.Reset();
		 			initSheet(sheetObj, sheetNo);
		 			
	       			sheetObj.LoadSearchXml(sXml);
	     			
	       			sheetObj.ShowSubSum(1, "3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19", -1, false, false, 0, "1=SUB TTL");
	       			
	     			ComOpenWait(false); 

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
		
		 if(ComIsEmpty(formObj.fm_atd_dt)) {          		 
			 ComShowCodeMessage("INV00004");
			 ComSetFocus(formObj.fm_atd_dt);
			 return false;
		 }

		 if(ComIsEmpty(formObj.to_atd_dt)) {          		 
			 ComShowCodeMessage("INV00004");
			 ComSetFocus(formObj.to_atd_dt);
			 return false;
		 }
		 
		 var nextDate = ComGetDateAdd(formObj.fm_atd_dt.value, "M", 1);
	 
		 if (formObj.to_atd_dt.value >= nextDate) {
			 ComShowCodeMessage("INV00043");
			 ComSetFocus(formObj.to_atd_dt);
			 return false;
		 }
		
		 return true;
	}
	
	/**
     * VVD 값 설정
     */
    function setVVD(sheetObj, param) {

    	var formObject = document.form;
    	var rect = document.getElementById("td_vvd").getBoundingClientRect();

    	formObject.rect_top.value = formObject.rect_top.value == "" ? rect.top : formObject.rect_top.value;
    	formObject.rect_left.value = formObject.rect_left.value == "" ? rect.left : formObject.rect_left.value;

    	if (param == 1) {

    		//  sheet 활성화
    		document.getElementById("vvd_input").style.display = "none";
    		document.getElementById("vvd_sheet").style.display = "block";

    		//  sheet 위치설정
    		document.getElementById("vvd_sheet").style.top = formObject.rect_top.value;
    		document.getElementById("vvd_sheet").style.left = formObject.rect_left.value;

    		var vvdSelectRow = !ComIsEmpty(formObject.sheet_vvd_row_chk) ? formObject.sheet_vvd_row_chk.value : "1";

    		if (!ComIsEmpty(formObject.input_vvd)) {
    			sheetObj.CellValue2(vvdSelectRow,  "vvd_cd") = formObject.input_vvd.value;
    		}
    		sheetObj.SelectCell(vvdSelectRow,  "vvd_cd");
    	} else if (param == 2) {
    		// input 활성화
    		document.getElementById("vvd_input").style.display = "block";
    		document.getElementById("vvd_sheet").style.display = "none";
    		
    		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
    			if (!ComIsEmpty(sheetObj.CellValue(i,  "vvd_cd"))) {
    				formObject.sheet_vvd_row_chk.value = i;
    				formObject.input_vvd.value = sheetObj.CellValue(i,  "vvd_cd");
    				
    				break;
    			}
    		}
    	} else if (param == 3) {
    		if (document.getElementById("vvd_sheet").style.display == "block") {
    			setVVD(sheetObj, 2);
    		}
    	}

    } 
    
	/* 개발자 작업  끝 */