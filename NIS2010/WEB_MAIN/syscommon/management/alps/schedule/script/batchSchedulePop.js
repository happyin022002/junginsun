/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : schedulePop.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008.12.23
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2008.12.26 정인선
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview schedulePop program no 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     * @author 한진해운
     */

    /**
     * @extends schedulePop
     * @class schedulePop : schedulePop 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
  	function schedulePop() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject     	= setSheetObject;
        this.loadPage     			= loadPage;
        this.initSheet     			= initSheet;
        this.doActionIBSheet     	= doActionIBSheet;
        this.setTabObject    		= setTabObject;
        this.setData				= setData;
        this.validateForm     		= validateForm;
    }
  	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	/* 공통전역변수 */
	var curTab = 1;
	var beforetab = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sheet_height = 20;


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var sheetObject = sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			/***********************************************************************************************************
				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.		
			 **********************************************************************************************************/
			/*
				이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
				메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
				(순서상도 form[1]이 되겠죠?) 
				그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
				document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
			*/
			switch(srcName) {
	    	    case "btn_retrieve":
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
	    	        break;
	    	   
	    	    case "btn_ok":
	    	    	comPopupOK();
	    	        break;
	    	    case "btn_close":
	    	    	self.close();
	    	        break;
			} // end switch
		}catch(e) {			
			/*
				자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
				물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
			*/
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}	

	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

	/**
	 * 페이지에 생성된 IBSheet Object를 sheetObjects배열에 등록한다. <br>
	 * sheetObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComSheetObject} 함수에 의해서 IBSheet Object가 생성되면서 자동 호출된다. <br>
	 * @param {ibsheet} sheet_obj    IBSheet Object
	 **/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	 /**
     * body.onload 이벤트에서 호출되는 함수로 페이지 로드완료 후 선처리해야할 기능을 추가한다. <br>
     * HTML컨트롤의 각종 이벤트와 IBSheet, IBTab 등을 초기화 한다. <br>
     **/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
	
	 /**
     * 페이지에 있는 IBSheet Object를 초기화 한다. <br>
     * IBSheet가 여러개일 경우 개수만큼 case를 추가하여 IBSheet 초기화 모듈을 구성한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
	function initSheet(sheetObj,sheetNo) {

		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					style.height = 250;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);
					var formObj = document.form;
					var allcheck = false;
					if (formObj.s_pgm_no.value == "" && formObj.s_pgm_nm.value == "") allcheck = false;
					else allcheck = true;
						InitHeadMode(false, true, allcheck, true, false,false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, "||Program no|Program name|", false);
		
					//데이터속성	[ROW,	  COL,	 DATATYPE, 		WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, 	dtRadioCheck,	30,    	daCenter,  	false,    	"radio",   		false,      "",     dfNone,	    	0,     		true,       true);
                    InitDataProperty(0, cnt++, 	dtCheckBox,  	30,    	daCenter,  	false,    	"checkbox",   		false,      "",     dfNone,   		0,     		true,       true);
					InitDataProperty(0,	cnt++,	dtData,			100,		daLeft,		false,	 	"pgm_no",	   	false,		"",	 	dfNone,			0,			false,       false);
					InitDataProperty(0,	cnt++,	dtData,			0,	daLeft,		false,	 	"pgm_nm",		false,		"",	 	dfNone,			0,			false,       false);
					InitDataProperty(0,	cnt++,  dtHidden,		0,		daLeft,		false,	 	"pgm_desc",		false,		"",	 	dfNone,			0,			false,       false);
					
					CountPosition = 0;
					
				}
				break;

		}
	}

	
	/**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				loadPage();
				sheetObj.DoSearch4Post("ProgramManagementGS.do", FormQueryString(formObj));
				break;
		}
	}
	
	 /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
		case IBSEARCH:
    		break;
	    }
	    return true;
	}
	
