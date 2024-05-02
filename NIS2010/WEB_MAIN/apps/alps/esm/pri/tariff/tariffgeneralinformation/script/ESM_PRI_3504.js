/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3504.js
*@FileTitle : Tariff General Information History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastVersion : 1.0
* 2010.11.01 서미진
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
     * @class ESM_PRI_3504 : ESM_PRI_3504 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3504() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initControl            	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
		
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
					
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btns_calendar": //달력버튼	    				    			
	                var cal = new ComCalendar();
	                cal.select(formObject.access_dt, 'yyyy-MM-dd');
	                break;	
	                
				case "btn_print":
					doActionIBSheet(sheetObject2,formObject,SEARCH04);
					break;     
	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
 
	/**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
    * @author 서미진
    * @version 2010.10.13
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}	
	

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre> formObj
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
	function loadPage() {  	
    	
		for (i = 0; i < sheetObjects.length; i++) {

			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    //Axon 이벤트 초기화
	    initControl();
	    
	    //Tariff Code Combo 세팅
	    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );	    
        form.tariff_cd.focus();
        
        var formObj = document.form;
        if (formObj.trf_no.value != "") {//다른 화면에서 호출,Tariff General Information Inquiry에서 조회             
            form.tariff_cd.value = formObj.trf_pfx_cd.value + "-" + formObj.trf_no.value;
            comboObjects[0].Text = form.tariff_cd.value;
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
       } 
	}

    /**
    * 사용하는 Event Listener 를 등록한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl();
    * </pre>
    * @return 없음
    * @author 문동규
    * @version 2009.08.25
    */
   function initControl() {
       //Axon 이벤트 처리1. 이벤트catch(개발자변경)
//       axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//       axon_event.addListener('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
       axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form);
       axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
       axon_event.addListenerForm('beforedeactivate', 'obj_onDeactivate', document.form);
       
       ComClearSeparator (document.form.access_dt,"eng"); //한글 변환 키 막기
   }
    
    /**
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @author 서미진
     * @version 2010.11.09
     */ 
 	function initCombo(comboObj, comboNo) {
    	 
 	    switch(comboObj.id) {
 	        case "tariff_cd":
 	            with(comboObj) {
 	            	DropHeight = 200;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	IMEMode = 0;
 	            	UseAutoComplete = true;
 	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
 	            	MaxLength = 8;
 	            }
 	            break;	        
 	    }
 	}
 	
     /**
      * 시트 초기설정값, 헤더 정의 <br>
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initSheet(sheetObj,1);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 서미진
      * @version 2010.10.13
      */
 	function initSheet(sheetObj,sheetNo) {

 		var cnt = 0;
 		var sheetID = sheetObj.id;
      	switch(sheetID) {
      	case "sheet1":
      		with (sheetObj) {
                  // 높이 설정
                  style.height = 200;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo( 1, 1, 20, 100);

                  var HeadTitle = "Tariff Code|Tariff Name|Tariff Type";

                  var headCount = ComCountHeadTitle(HeadTitle);

                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(5, 0, 0, true);

                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(false, true, true, true, false,false);

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] ///  
                  InitHeadRow(0, HeadTitle, true);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , 	dtData,					100,		daCenter,		false,		"tariff_code",	  false,    "",    dfNone,   0 ,   false,  false);
                  InitDataProperty(0, cnt++ , 	dtData,					500,		daLeft,			false,		"trf_nm",	  false,    "",    dfNone,   0 ,   false,  false);
                  InitDataProperty(0, cnt++ , 	dtData,					200,		daCenter,		false,		"trf_bzc_tp_cd",	  false,    "",    dfNone,   0 ,   false,  false);
                  InitDataProperty(0, cnt++ , 	dtHidden,				80,		daLeft,			false,		"trf_no");
                  InitDataProperty(0, cnt++ , 	dtHidden,				20,		daLeft,			false,		"trf_pfx_cd");
                  
                  WaitImageVisible = false;
      		
      		}
           	break;
           	
      	case "sheet2":
      		with (sheetObj) {
                 // 높이 설정
                 style.height = 160;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 6, 100);

                 var HeadTitle = "Amend\nNo.|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Status|Inland Rates|Request\nOffice|Creation\nStaff|Approval\nOffice";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(27, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] dfNullFloat
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtData,			50,  	daCenter,	false,	"amdt_seq",     			false,    "",    dfNone,   0 ,   false,  false);  
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"cre_dt",     				false,	"",	dfDateYmd, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	true,	"eff_dt",     					false,	"",	dfDateYmd,	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"pub_dt",     				false,	"",	dfDateYmd, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"trf_bzc_sts_cd_nm",     false,	"",	dfNone, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"trf_inlnd_flg",     		false,	"",	dfNone, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,			90,  	daCenter, 	false,	"rqst_ofc_cd",     			false,	"",	dfNone, 		 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,    		90,   	daCenter, 	false,	"cre_usr_id",     			false,	"",	dfNone, 			0,     false,	false);
                 InitDataProperty(0, cnt++ , dtData,    	    50,   	daCenter, 	false,	"apro_ofc_cd",      		false,	"",	dfNone, 			0,     false,	false);
                 
                 InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	false,	"trf_bzc_tp_cd",	  		false,"", dfNone,  0 ,   false,  false);
                 InitDataProperty(0, cnt++ , dtHidden,  	90,   	daCenter, 	true,	"trf_bzc_wgt",      		false,	"",	dfNullFloat, 	3,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,  	90,   	daCenter, 	true,	"trf_bzc_wgt_ut_cd",		false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,  	90,   	daCenter, 	true,	"trf_bzc_vol_qty",      	false,	"",	dfNullFloat, 	3,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,  	90,   	daCenter, 	true,	"trf_bzc_vol_ut_cd",		false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,  	90,   	daCenter, 	true,	"curr_cd",      				false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,		90,   	daCenter, 	true,	"pub_cntc_pson_nm",   false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,		90,   	daCenter, 	true,	"pub_ofc_addr",      		false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_phn_no",      	false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_cty_nm",      	false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_ste_cd",      	false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_zip_cd",      	false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_cnt_nm",      	false,	"",	dfNone, 	0,     false,	false);
                 InitDataProperty(0, cnt++ , dtHidden,   	90,   	daCenter, 	true,	"pub_ofc_fax_no",      	false,	"",	dfNone, 	0,     false,	false);
                 
                 InitDataProperty(0, cnt++ , 	dtHidden,				500,		daLeft,			false,		"trf_nm",	  false,    "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtHidden,				80,		daLeft,			false,		"trf_no",	  false,    "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtHidden,				20,		daLeft,			false,		"trf_pfx_cd",	  false,    "",    dfNone,   0 ,   false,  false);


                 WaitImageVisible = false;
     		}
          	break;
          	
      	case "sheet3":
      		with (sheetObj) {
                  // 높이 설정
                  style.height = 150;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo( 1, 1, 5, 100);

                  var HeadTitle = "|SEQ|Origin|Origin Description";

                  var headCount = ComCountHeadTitle(HeadTitle);

                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle, true);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	false,	"ibflag");
                  InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	false,	"seq");
                  InitDataProperty(0, cnt++ , dtData,			100,  	daCenter,	false,	"trf_bzc_rout_pnt_def_cd",  false,	"",	dfNone,  	0,     false,	false);
                  InitDataProperty(0, cnt++ , dtData,			200,  	daLeft, 		false,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false);
                  
                  WaitImageVisible = false
      		}
           	break;
           	
      	case "sheet4":
      		with (sheetObj) {
                  // 높이 설정
                  style.height = 150;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo( 1, 1, 5, 100);

                  var HeadTitle = "|SEQ|Destination|Destination Description";

                  var headCount = ComCountHeadTitle(HeadTitle);

                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);

                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle, true);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus,30,		daCenter,	false,	"ibflag");
                  InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	false,	"seq");
                  InitDataProperty(0, cnt++ , dtData,		100,  	daCenter,	false,	"trf_bzc_rout_pnt_def_cd",  false,	"",	dfNone,  	0,     false,	false);
                  InitDataProperty(0, cnt++ , dtData,		200,  	daLeft, 	false,	"cnt_nm",     				false,	"",	dfNone,  	0,     false,	false);
                  
                  WaitImageVisible = false
      		}
           	break;
      	}
 	}

  
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 서미진
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {	
	 		
		 		case IBSEARCH: // 조회	
		 	 		if ( sheetObj.id == "sheet1") {
			 			if (!validateForm(sheetObj,document.form,sAction)) {
							return false;
						}
			 			ComOpenWait(true);	 			
			 			formObj.f_cmd.value = SEARCH01;
			 			
			 			if (ComIsEmpty(comboObjects[0].Text)){
	    	   				formObj.trf_pfx_cd.value = "";
	    	   				formObj.trf_no.value = "";
	    	   				formObj.trf_nm.value = "";	  
			 			}
			 			
			 			sheetObjects[1].RemoveAll();
			 			sheetObjects[2].RemoveAll();
			 			sheetObjects[3].RemoveAll();	
				        ComClearManyObjects(formObj.sh_trf_cd, formObj.trf_nm, formObj.rqst_ofc_cd, formObj.cre_usr_id
								,formObj.apro_ofc_cd, formObj.amdt_seq, formObj.eff_dt, formObj.exp_dt, formObj.pub_dt, formObj.cre_dt
								,formObj.trf_bzc_tp_cd, formObj.trf_bzc_wgt, formObj.trf_bzc_wgt_ut_cd,formObj.trf_bzc_vol_qty,formObj.trf_bzc_vol_ut_cd,formObj.curr_cd         								 
								,formObj.pub_cntc_pson_nm,formObj.pub_ofc_addr,formObj.pub_ofc_phn_no,formObj.pub_ofc_cty_nm,formObj.pub_ofc_ste_cd
								,formObj.pub_ofc_zip_cd,formObj.pub_ofc_cnt_nm,formObj.pub_ofc_fax_no);
				        
			 			var sXml = sheetObj.GetSearchXml("ESM_PRI_3504GS.do", FormQueryString(formObj));		 		
			 			sheetObj.LoadSearchXml(sXml);
				        
		 	 		}
		 			
	 		 		break;	
	 		 		
				case SEARCH04: // Print
					if(sheetObj.selectRow == '-1'){
						ComShowCodeMessage('PRI00337','Amend No.');
						return false;
					}
				
				   sParam = "trfPfxCd=" + sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd")
			         		+ "&trfNo="   + sheetObj.cellValue(sheetObj.selectRow, "trf_no")
			         		+ "&amdtSeq=" + sheetObj.cellValue(sheetObj.selectRow, "amdt_seq");

				   ComPriOpenWindowCenter("/hanjin/ESM_PRI_3506.do?"+sParam, "", 1024, 700, true);				
				   break;

	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
	

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 서미진
	 * @version 2010.11.01
	 */
	function tariff_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		var arrText = text.split("|");
		
		if (arrText != null && arrText.length > 1) {
			
			formObj.trf_nm_title.value = comboObj.GetText(code, 1);
			
	   			if (ComIsEmpty(comboObj.Text)) {
	   				formObj.trf_pfx_cd.value = "";
	   				formObj.trf_no.value = "";
	   				formObj.trf_nm_title.value = "";	    	   				
	   			}else{
					var arr = code.split("-");
					formObj.trf_pfx_cd.value = arr[0];
					formObj.trf_no.value = arr[1];
	   			}
		}
	}
    	    	
	   	/**
	   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
	   	 * <br><b>Example :</b>
	   	 * <pre>
	   	 *
	   	 * </pre>
	   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	   	 * @param {int} text 필수 화면에 표시된 글자
	   	 * @return 없음
    	 * @author 서미진
    	 * @version 2010.11.01
	   	 */
	   	function tariff_cd_OnKeyDown(comboObj, KeyCode) {
	   		var formObj = document.form;
	   		if (KeyCode == 13){ 	   						
			 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	   		}
	   	}
 	 	   	 
	   	 
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    tariff_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 서미진
	 * @version 2010.11.01
	 */   	
	function tariff_cd_OnBlur(comboObj) {
		var formObj = document.form;
		var code = comboObj.FindIndex(comboObj.Code, 0);
		if (code != null && code != "") {
	   		var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
			formObj.trf_nm_title.value = comboObj.GetText(code, 1);
		}
	}

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 클릭시 하단 조회 <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
     * @return 없음
	 * @author 서미진
	 * @version 2010.11.02
 	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
 		if(OldRow != NewRow){
	 		sheetObjects[1].RemoveAll();	 	
			var formObj = document.form;
			formObj.f_cmd.value = SEARCH02;

			var param = "f_cmd="           + formObj.f_cmd.value
					  + "&trf_pfx_cd="     + sheetObj.cellValue(NewRow, "trf_pfx_cd")
					  + "&trf_no="         + sheetObj.cellValue(NewRow, "trf_no")
			          + "&access_dt="         + formObj.access_dt.value;

			var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_3504GS.do", param);
			sheetObjects[1].LoadSearchXml(sXml);	
 		}
 	}
	 	 
	    /**
	     * OnSelectCell 이벤트 발생시 호출되는 function <br>
	     * 클릭시 하단 조회 <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * 
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
	     * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
	     * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
	     * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
	     * @return 없음
		 * @author 서미진
		 * @version 2010.11.02
	 	 */
	  	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	   		if (OldRow != NewRow) {
	 		 
				var formObj = document.form;
				if(sheetObj.RowCount>0){
					formObj.sh_trf_cd.value = sheetObj.CellValue(NewRow, "trf_pfx_cd")+"-"+sheetObj.CellValue(NewRow, "trf_no");
			 		formObj.trf_nm.value = sheetObj.CellValue(NewRow, "trf_nm");	 			 		
			 		formObj.rqst_ofc_cd.value = sheetObj.CellValue(NewRow, "rqst_ofc_cd");
			 		formObj.cre_usr_id.value = sheetObj.CellValue(NewRow, "cre_usr_id");
			 		formObj.apro_ofc_cd.value = sheetObj.CellValue(NewRow, "apro_ofc_cd");
			 		formObj.amdt_seq.value = sheetObj.CellValue(NewRow, "amdt_seq");	
			 		
			 		formObj.eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(NewRow, "eff_dt"), "ymd");
			 		formObj.exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(NewRow, "exp_dt"), "ymd");
			 		formObj.pub_dt.value = ComGetMaskedValue(sheetObj.CellValue(NewRow, "pub_dt"), "ymd");
			 		formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(NewRow, "cre_dt"), "ymd");		 		
			 		formObj.trf_bzc_tp_cd.value = sheetObj.CellValue(NewRow, "trf_bzc_tp_cd");
			 		formObj.trf_bzc_wgt.value = sheetObj.CellText(NewRow, "trf_bzc_wgt");		 				 				 		
			 		formObj.trf_bzc_wgt_ut_cd.value = sheetObj.CellValue(NewRow, "trf_bzc_wgt_ut_cd");
			 		formObj.trf_bzc_vol_qty.value = sheetObj.CellText(NewRow, "trf_bzc_vol_qty");
			 		formObj.trf_bzc_vol_ut_cd.value = sheetObj.CellValue(NewRow, "trf_bzc_vol_ut_cd");
			 		formObj.curr_cd.value = sheetObj.CellValue(NewRow, "curr_cd");
			 		
			 		formObj.pub_cntc_pson_nm.value = sheetObj.CellValue(NewRow, "pub_cntc_pson_nm");
			 		formObj.pub_ofc_addr.value = sheetObj.CellValue(NewRow, "pub_ofc_addr");
			 		formObj.pub_ofc_phn_no.value = sheetObj.CellValue(NewRow, "pub_ofc_phn_no");
			 		formObj.pub_ofc_cty_nm.value = sheetObj.CellValue(NewRow, "pub_ofc_cty_nm");
			 		formObj.pub_ofc_ste_cd.value = sheetObj.CellValue(NewRow, "pub_ofc_ste_cd");
			 		formObj.pub_ofc_zip_cd.value = sheetObj.CellValue(NewRow, "pub_ofc_zip_cd");
			 		formObj.pub_ofc_cnt_nm.value = sheetObj.CellValue(NewRow, "pub_ofc_cnt_nm");
			 		formObj.pub_ofc_fax_no.value = sheetObj.CellValue(NewRow, "pub_ofc_fax_no");
				}
		        
		        formObj.f_cmd.value = SEARCH03;
		        
				var param = "f_cmd="           + formObj.f_cmd.value
				  + "&trf_pfx_cd="     + sheetObj.cellValue(NewRow, "trf_pfx_cd")
				  + "&trf_no="         + sheetObj.cellValue(NewRow, "trf_no")
				  + "&amdt_seq="       + sheetObj.cellValue(NewRow, "amdt_seq");
	
				var sXml = sheetObj.GetSearchXml("ESM_PRI_3504GS.do", param);
	
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[2].LoadSearchXml(arrXml[0]);
					if (arrXml.length > 1){
						sheetObjects[3].LoadSearchXml(arrXml[1]);
					}
				}
	   		}

	 	}
	
	 	  	 
	 	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *         로직처리;
      *     }
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {form} formObj 필수 html form object
      * @param {int} sAction 필수 프로세스 플래그 상수
      * @returns bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
	  * @author 서미진
	  * @version 2010.11.02
      */
  	function validateForm(sheetObj, formObj, sAction) {
     	 
        if(!ComChkObjValid(formObj.access_dt)){
        	return false;
        }
  		
     	 switch (sAction) {
 		 
     	 }
  		return true;
  	}
    	
      /**
       * OnKeyDown event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param 없음
       * @return 없음
      	* @author 서미진
      	* @version 2010.10.13
       */  
   	function obj_onKeydown(){
   		// Enter key조회
   	 	var eleName = event.srcElement.name;
   	 
   	 	if (eleName == "access_dt"){
   		 	var keyValue = null;
   			if(event == undefined || event == null) {
   		    	keyValue = 13;
   			}else{
   		    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   		  	}
   		   	if (keyValue == 13){
   		   		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		  	}
   		}
   	}
       
       /**
        * 키보드가 눌릴 때 dataformat으로 세팅
        * @author  서미진
        * @version 2010.11.15
        */
     function obj_KeyPress(){
         var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         var srcName = event.srcElement.getAttribute("name");
         var srcValue = event.srcElement.getAttribute("value");

         switch(event.srcElement.dataformat) {
             case "ymd":
           	  ComKeyOnlyNumber(event.srcElement);
           	  if (srcValue.length == 6) {
           		document.form.elements[srcName].value = srcValue.substring(0,4) + "-" + srcValue.substring(4,6) + "-"
           	  }
              break;
         }
      }   	 
   	 
     /**
      * Onbeforedeactivate  event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_onDeactivate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 서미진
      * @version 2010.10.13
      */   
      function obj_onDeactivate() {
          var eleName = event.srcElement.name;
          switch(eleName){          
              case "access_dt":
                  ComChkObjValid(event.srcElement);   
                  break;
          }
      }     	 
	   	 

	/* 개발자 작업  끝 */