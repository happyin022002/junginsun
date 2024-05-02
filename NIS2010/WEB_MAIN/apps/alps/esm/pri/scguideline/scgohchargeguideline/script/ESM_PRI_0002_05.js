/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0002_005.js
*@FileTitle : S/C GOH Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.05 김재연
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
     * @class S/C GOH Guideline Inquiry : S/C GOH Guideline Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0002_05() {
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
    var enableFlag = true;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
         /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
     		if (srcName != null && srcName !="" && srcName.indexOf("btn") == 0 
						&& getButtonDisableStatus(srcName)){
				return;
			}    		
            switch(srcName) {
				case "btn_Retrieve":
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;						

				case "btn_DownExcel":
					
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}else{
		                ComShowCodeMessage('PRI08001');
		                return false;
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        pageOnLoadFinish();
    }

 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	 doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);            
         toggleButtons("CLEAR");
         parent.loadTabPage();
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
     * @author 김재연
     * @version 2009.10.05
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 380;
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

                    var HeadTitle = "Seq.|dbSeq.|Type|Point|Description|Bar Type|Per|Cur.|Rate|svcscpcd|glineseq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);



//             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]                                                
	                InitDataProperty(0, cnt++ , dtDataSeq,	   40,  daCenter,  false, "seq");
	                InitDataProperty(0, cnt++ , dtHidden,	   40,  daCenter,  false, "goh_chg_seq");
	                InitDataProperty(0, cnt++ , dtCombo,	  100,  daCenter,  false, "rout_pnt_loc_tp_cd",  false,  "",  dfNone,	0);
                    InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  false, "rout_pnt_loc_def_cd", false,  "",  dfNone, 	0);
                    InitDataProperty(0, cnt++ , dtData,       280,  daLeft,	   false, "loc_des",  		     false,  "",  dfNone,	0);
					InitDataProperty(0, cnt++ , dtCombo,      100,  daCenter,  false, "prc_hngr_bar_tp_cd",  false,  "",  dfNone, 	0);
                    InitDataProperty(0, cnt++ , dtCombo,  	  100,  daCenter,  false, "rat_ut_cd",      	 false,  "",  dfNone, 	0);
                    InitDataProperty(0, cnt++ , dtCombo,      100,  daCenter,  false, "curr_cd",             false,  "",  dfNone, 	0);
                    InitDataProperty(0, cnt++ , dtData,       110,  daRight,   false, "frt_rt_amt",       	 false,  "",  dfNullFloat,  2);
	                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,  false, "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,  false, "gline_seq");                        

					ShowButtonImage = 2;
					AutoRowHeight = false;
					WaitImageVisible = false;
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
     * @author 김재연
     * @version 2009.10.05
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
    		case IBCLEAR: // 화면 로딩시 코드 조회
	    		//currency combo
				sheetObj.InitDataCombo(0,"curr_cd", currCdComboText, currCdComboValue,"USD");
				// per combo
				sheetObj.InitDataCombo(0,"rat_ut_cd", perCdComboText, perCdComboValue);
				//공통  bar type
				sheetObj.InitDataCombo(0,"prc_hngr_bar_tp_cd", barCdComboText, barCdComboValue);
				
				//공통 - type				
				sheetObj.InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE1[1], LOCATION_TYPE1[0], " ", " ", 0);
				break;
			case IBSEARCH:      //조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_0002_05GS.do", FormQueryString(formObj));
				ComOpenWait(false);
                break;
			
			case IBDOWNEXCEL:
				sheetObj.Down2Excel(-1);
				break;
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
     * @author 김재연
     * @version 2009.10.05
     */
    function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {
		case IBSEARCH: // 조회		
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			} else {
				return true;
			}
			break;
	
        case IBDOWNEXCEL: // 엑셀조회
	        if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	            return false;
	        }
	        break;				
		}        
        return true;
    }
     
	/**
     * parent 화면의 상태로 edit여부를 판단한다. function <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param 없음
     * @return {Boolean} true(수정가능,메인의 상태는 No) false(수정불가능,메인의상태는 Yes)
     * @author 김재연
     * @version 2009.10.05
     */    
    function getMainStatus(){
    	var mainStatus = parent.document.form.cfm_flg.value;
     	var editStatus = true;
     	if (mainStatus == "Yes"){
     		editStatus = false;
     	}
     	return editStatus;
    }     
    
    /**
     * button의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) 필수 button 설정 mode
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_DownExcel");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			break;
		}
	}     
  	 
    /**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sGlineSeq 필수 gline_seq 값
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 		     	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject = document.form;
		
		if(formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;    			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}						
	    }
    }
     
    /**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 	
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";    		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
 
    /**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 김재연
     * @version 2009.10.05
     */ 		  
    function tabEnableSheet(flag) {
    	 var formObject = document.form;		
    	 sheetObjects[0].Editable = flag;
    	 enableFlag = flag;
    	 if (enableFlag) {
    		 toggleButtons("INIT");
    	 } else {
    		 toggleButtons("READONLY");
    	 }			
    }   	 
      
	/* 개발자 작업  끝 */