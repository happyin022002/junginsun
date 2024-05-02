/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_TES_2009.js
*@FileTitle : Irregular Report Designer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : Kim Yong Jin
*@LastVersion : 1.0
* 2011.03.31 Kim Yong Jin
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_TES_2009 : ESD_TES_2009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_2009() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
//        this.doActionIBSheet        = doActionIBSheet;
//        this.validateForm           = validateForm;
    }
    
   	/* 개발자 작업	*/
   	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	
	/**
	 * IBSheet Object를 배열로 등록
	 * ComSheetObject(id)에서 호출한다
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		//RD
		initRdConfig(rdObjects[0]);
		rdOpen(rdObjects[0], document.form);

		//Sheet
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * 시트가 다수일 경우 시트 수만큼 case 를 추가하여 시트 초기화모듈을 구성한다
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 100;
										
					//전체 너비 설정
					//SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "|||||||||";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "email_addr",        false,          "",    dfNone,    0,     true,       true);
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "fax_num",        false,          "",    dfNone,    0,     true,       true);

					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "sys_cd",        false,          "",    dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "app_cd",        false,          "",    dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "batch_ind",        false,          "",    dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "param",        false,          "",    dfNone,    0,     true,       true);
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "rcv_info",        false,          "",    dfNone,    0,     true,       true);
					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "office",        false,          "",    dfNone,    0,     true,       true);
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "fax_title",        false,          "",    dfNone,    0,     true,       true);
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "email_title",        false,          "",    dfNone,    0,     true,       true);
//					InitDataProperty(0, cnt++, dtData,       100,     daCenter, false,  "email_contents",        false,          "",    dfNone,    0,     true,       true);

					DataInsert();
				}
				break;
		}
	}


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 **/	
	function processButtonClick(){

		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
		 var rdObject = rdObjects[0];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				 case "btn_print":
					rdObjects[0].PrintDialog();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}		
	}
	

	 /**
	  * RD 초기설정값
	  * @param {rd object}		rdObject	rd
	  * @return
	  */
	 function initRdConfig(rdObject){

	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		// Rdviewer.HideToolbar(); // show tool bar ... In 2008-09-12

        // Added Option  ... In 2008-09-12
    	Rdviewer.SetSaveDialogEx("", "", "pdf", "pdf");
    	Rdviewer.DisableToolbar(13);
    	Rdviewer.DisableToolbar(14);
    	Rdviewer.DisableToolbar(16);
    	Rdviewer.DisableToolbar(17);

		Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(2);

		Rdviewer.setbackgroundcolor(255,255,255);
		Rdviewer.SetPageLineColor(255,255,255);
	}

	  /**
	   * Open RD
	   * @param {rd}	rdObject	RD Object
	   * @param {form}	formObj		form object
	   * @return
	   */
	function rdOpen(rdObject,formObject) {
	
	    var Rdviewer = rdObject ;
	    var rdParam = "/rp [" + formObject.irr_no.value + "] /rfonttype60";		//$1   			    
	    Rdviewer.FileOpen( RD_path + "apps/alps/esd/tes/guaranteemanage/irregularmanage/report/ESD_TES_2009.mrd", RDServer + rdParam);
	}

	 
	 