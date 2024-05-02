/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0184.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0184() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	//this.sheet1_OnClick         = sheet1_OnClick;
    	//this.sheet1_OnKeyUp         = sheet1_OnKeyUp;
    }
    
    
    /* 개발자 작업	*/
    

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 					switch(srcName) {

 						case "btn_DownExcel":
 		 					sheetObject1.Down2Excel(-1);
 		 					break;
 						
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
      * IBSheet Object를 배열로 등록
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
	    for(i=0;i<sheetObjects.length;i++){
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	         ComEndConfigSheet(sheetObjects[i]);
	    }
	    // 자체 테스트 시에 사용
	    //document.form.msg_tp_cd.value = 'C' ;
	    //document.form.rcv_snd_div_cd.value = 'S' ;
	    //document.form.anr_decl_no.value = '00' ;
	    //document.form.ref_seq.value = '1' ;
	    
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    
	}


	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {

			case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 500;
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

						var HeadTitle1 = "|Seq.|Message Detail";
						
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
														
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,		true,		"hdnStatus");
						InitDataProperty(0,		cnt++ , dtSeq,					50,		daCenter,		true,		"SEQ",            false,		"",		dfNone,					0,		true,		true);
						InitDataProperty(0,		cnt++ , dtData,					180,	daLeft,			true,		"edi_msg",        false,		"",		dfNone,					0,		true,		true);
						
						WordWrap = true;

				}
				break;


	}
	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
			
					var target;
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0184GS.do", FormQueryString(formObj));
					sheetObj.Redraw = false; 
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true;  
				}
			break;
         }
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	 		case IBSEARCH: // 조회
	 			/*
	 			if (formObj.bl_no.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			*/				
	 			return true;
	 		break;	 			 			
  	}
     }



	/* 개발자 작업  끝 */    