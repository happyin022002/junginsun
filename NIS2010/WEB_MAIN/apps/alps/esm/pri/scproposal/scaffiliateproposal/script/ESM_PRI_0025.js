/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0025.js
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach 기능 개발요청
* 2011.04.22 이행지 [선조치] TPE가 들어있는 SC일 경우만 Attach File 첨부기능 활성화 및 저장 Validation 체크
* 2013.05.31 전윤주 [CHM-201325030] S/C Affliate manual 입력시 error fix 요청 - manual 입력 시 1개 이상 들어가면 무조건 중복 체크 로직에 걸리게 되어 있는 부분 수정
* 2014.05.30 전윤주 [CHM-201430523] S/C 생성/어멘드 시 화주 정보 기능 보완 (수정 불가) 
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직(컬럼 추가만 함. 별도 화면에서 체크 없음)
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
     * @class ESM_PRI_0025 : ESM_PRI_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var uploadObjects = new Array();
 var uploadCnt = 0;
 
 //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 var rData ="N";
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObject1 = sheetObjects[0];          
          var formObject = document.form;          

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		
     		if (srcName != null && srcName !="" && srcName.indexOf("btn") == 0 
     							&& getButtonDisableStatus(srcName)){
     			return;
     		}

             switch(srcName) {
	 			case "btn_RowAdd":				
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;	
				case "btn_Delete":					
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;	
				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;	
				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break;					
				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;					
				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
				case "btn_CancelAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break;
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
    				break;
 				case "btn_Close": 									
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
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
      * @author 공백진
      * @version 2009.04.17
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
   		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);  

        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_0025GS.do");
	        uploadObjects[i].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
		 }

        //각종 확인 메시지의 표시를 표시할지 여부를 설정한다.
        
		var formObj = document.form;
		//일자 포맷 적용
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
        getManualCheck();
        buttonControl();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	    
     }
      
 
      
      
	/**
	 * body 태그의 unonLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 닫힐때 처리해야 하는 기능을 추가한다. <br>
	 * 데이터 변경 여부 return <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     unloadPage();
	 * </pre>
	 * @return 없음
	 * @author 공백진
	 * @version 2009.08.17
	 */      
  	 function unloadPage(){
  		 window.returnValue = rData;
  	 }      
      

  /**
   * OnKeyPress event를 처리한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     obj_keypress()
   * </pre>
   * @param 없음
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */     
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

    /**
     * OnBeforeActivate   event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	
	function obj_activate() {
		//var formObject = document.form;
	    var srcName = event.srcElement.getAttribute("name");

	    ComClearSeparator (event.srcElement);

	}
	
    /**
     * Onbeforedeactivate  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     	
	function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
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
     * @author 공백진
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         var sheetID = sheetObj.id;
         var amdt_seq = document.form.amdt_seq.value;
         
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 360;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Sel.|Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Mannual Input|Type|Customer Name|Affiliate Type|Address|MOC License No|OTI Bond No.|OTI Bond|OTI Bond|OTI Bond|Tariff Title page|Tariff Title page|Tariff Title page|OTI License No.|OTI License|OTI License|OTI License|Affiliate Registration Request Letter|Affiliate Registration Request Letter|Affiliate Registration Request Letter|Location|Effective Date|Effective Date|Source|Status|||||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

					//데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
					//	  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
					//	  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
					//	  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					 InitDataProperty(0, cnt++, dtHiddenStatus,	30,	 daCenter, false, "ibflag");
 					 InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
                     InitDataProperty(0, cnt++, dtDataSeq,      35,  daCenter, false, "seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no",  		  true,  "", dfNone, 	0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  true,  "", dfNone, 	0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "afil_seq", 		  true,  "", dfNone, 	0, false, false);					 
					 if (amdt_seq == "0"){//amend seq 에 따라 edit 여부 결정
						 InitDataProperty(0, cnt++, dtData,     	40,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, true,  true,  2,true);
	                     InitDataProperty(0, cnt++, dtPopupEdit,   	85,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, true,  true,  6);
	                     InitDataProperty(0, cnt++, dtCheckBox,  	100, daCenter, true,  "mnl_inp_flg",      false, "", dfNone,    0, true,  true);
					 }else{
						 InitDataProperty(0, cnt++, dtData,     	40,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, false,  true,  2,true);
	                     InitDataProperty(0, cnt++, dtPopupEdit,   	85,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, false,  true,  6);
	                     InitDataProperty(0, cnt++, dtCheckBox,  	100, daCenter, true,  "mnl_inp_flg",      false, "", dfNone,    0, false,  true);
					 }                
					 //[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
					 InitDataProperty(0, cnt++, dtData,     	80, daCenter,   true,  "rvis_cntr_cust_tp_nm",      	      false, "", dfNone, 	0, false, false,  100); 
					 
                     InitDataProperty(0, cnt++, dtData,     	200, daLeft,   true,  "cust_nm",      	      false, "", dfNone, 	0, false, false,  100);
                     InitDataProperty(0, cnt++, dtCombo, 		150, daCenter, false, "sc_afil_tp_cd",	      false, "", dfNone,	0, false, true);
                     InitDataProperty(0, cnt++, dtData,     	180, daLeft,   true,  "cust_addr",            false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtData,    100, daLeft,   true,  "moc_lic_no",  false, "", dfNone, 	0, true, true,15);

                     InitDataProperty(0, cnt++, dtData,     	80,  daCenter, true,  "nvocc_bd_no",          false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,     	100, daLeft,   true,  "oti_bd_atch_file_id",  false, "", dfNone, 	0, false, false,  32);
                     InitDataProperty(0, cnt++, dtPopupEdit,    100, daLeft,   true,  "oti_bd_atch_file_nm",  false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtImage,        20,  daLeft,   true,  "oti_bd_atch_file_del", false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtHidden,     	100, daLeft,   true,  "trf_tit_atch_file_id", false, "", dfNone, 	0, false, false,  32);
                     InitDataProperty(0, cnt++, dtPopupEdit,    100, daLeft,   true,  "trf_tit_atch_file_nm", false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtImage,        20,  daLeft,   true,  "trf_tit_atch_file_del",false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtData,     	100, daCenter, true,  "nvocc_lic_no",         false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,     	100, daLeft,   true,  "oti_lic_atch_file_id", false, "", dfNone, 	0, false, false,  32);
                     InitDataProperty(0, cnt++, dtPopupEdit,    100, daLeft,   true,  "oti_lic_atch_file_nm", false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtImage,        20,  daLeft,   true,  "oti_lic_atch_file_del",false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtHidden,     	100, daLeft,   true,  "afil_rgst_rqst_ltr_id", false, "", dfNone, 	0, false, false,  32);
                     InitDataProperty(0, cnt++, dtPopupEdit,    200, daLeft,   true,  "afil_rgst_rqst_ltr_nm", false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtImage,        20,  daLeft,   true,  "afil_rgst_rqst_ltr_del",false, "", dfNone, 	0, false, true);
                     InitDataProperty(0, cnt++, dtData,     	70,  daCenter, true,  "cust_loc_cd",          false, "", dfNone, 	0, false, false,  5);                     
 					 InitDataProperty(0, cnt++, dtData,   		80,  daCenter, true,  "eff_dt",	  		      false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   		80,  daCenter, true,  "exp_dt",		          false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		60,  daCenter, false, "src_info_cd",	      false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		60,  daCenter, false, "prc_prog_sts_cd",      false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,   	80,  daCenter, false, "prc_prog_sts_dtl",     false, "", dfNone, 	0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_usr_id", 	      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_ofc_cd",          false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_dt", 		      false, "", dfDateYmd, 0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,     	40,  daCenter, true,  "cust_cnt_cd_tmp",      false, "", dfNone,    0, true,  true,  2);
                     InitDataProperty(0, cnt++, dtHidden,   	85,  daCenter, true,  "cust_seq_tmp",         false, "", dfNone,    0, true,  true,  6);                     
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "n1st_cmnc_amdt_seq",   false,"", dfNone, 	0, false, false);
                     
	                 InitDataValid(0,  "cust_cnt_cd",	vtEngUpOnly);	// 영문대문자만 입력
	                 InitDataValid(0,  "cust_seq",		vtNumericOnly);	// 숫자만 입력

	                 InitDataValid(0, "cust_nm", 		vtEngOther,PRI_VALID_CHAR);	
	                 InitDataValid(0, "cust_addr", 		vtEngOther,PRI_VALID_CHAR);
	                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "cust_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

 					 ShowButtonImage = 2; 
 					 Ellipsis = true;
 					 WaitImageVisible = false;
 					 
		 			 ToolTipOption="balloon:true;width:500;icon:1;";

		 			 ImageList(0)= "/hanjin/img/nolines_minus.gif";
		 			 ImageList(1)= "/hanjin/img/ico_attach.gif";
		 			 PopupButtonImage(0, "oti_bd_atch_file_nm")  = 1;
		 			 PopupButtonImage(0, "trf_tit_atch_file_nm") = 1;
		 			 PopupButtonImage(0, "oti_lic_atch_file_nm") = 1;
		 			 PopupButtonImage(0, "afil_rgst_rqst_ltr_nm") = 1;
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
       * @author 공백진
       * @version 2009.04.17
       */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         try{
            switch(sAction) {
 			case IBSEARCH_ASYNC01: // 콤보데이터 setting 
 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 				//	status
 				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
 				sheetObj.InitDataCombo(0,"sc_afil_tp_cd", " |"+scAfilTypeCdText, " |"+scAfilTypeCdValue);
 				break;	         
 			case IBINSERT: // Row Add			
 				var eff_dt 		 = formObj.eff_dt.value;
 				var exp_dt 		 = formObj.exp_dt.value;
 				var amdt_seq 	 = formObj.amdt_seq.value;
 				
 				if (validateForm(sheetObj,document.form,sAction)) {	
 				
 	 				var idx = sheetObj.DataInsert();
 					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
 					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;				
 					sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
 					sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;		
 					sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
 					sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
 					sheetObj.CellValue2(idx, "src_info_cd") = "NW";		
 					sheetObj.CellValue2(idx, "afil_seq") = parseInt(ComPriGetMax(sheetObj, "afil_seq")) + 1;
 					if(amdt_seq!=0){
// 						sheetObj.RangeBackColor(idx,10,idx,10) =  sheetObj.RgbColor(255,255,255);
 						if (sheetObj.CellValue(idx,"mnl_inp_flg")==1){
 							sheetObj.CellEditable(idx, "cust_loc_cd") = true;
 						}else{
 							sheetObj.CellEditable(idx, "cust_loc_cd") = false;
 						}						
 						sheetObj.CellFont("FontColor", idx, "chk", idx, "prc_prog_sts_cd")= sheetObj.RgbColor(255,0,0);
 					}	
 					sheetObj.SelectCell(idx, "cust_cnt_cd");
 			         //backcolor change
 			         changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
 				}
 				break;    
 					
 			case IBDELETE: // Delete
 				var mnChk = document.form.mnl_chk.value;
 				var amdt_seq = formObj.amdt_seq.value;
         	
 				if(amdt_seq=="0"){	
 					if (validateForm(sheetObj,document.form,sAction)) {
 						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
 						if(chkArr.length == 0) {
 							sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 1;
 							if (sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd")!="I"){
 								sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 0;
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						}else{
 							for(var i=0;i < chkArr.length;i++){							
 								if (sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd")!="I"){
 									ComShowCodeMessage("PRI01002");
 									return;
 								}
 							}
 						}

 						deleteRowCheck(sheetObj, "chk");
 					}
 					
 				}else{
 					var eff_dt = formObj.eff_dt.value;
 					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 					if(chkArr.length > 0){			
 						for(i=0;i < chkArr.length;i++){
 							if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq
 									||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq 
 											&& (sheetObj.CellValue(chkArr[i],"src_info_cd")!="NW"
 												|| sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd")!="I"))){
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						}
 						
 						var sRow = 0; 				
 						for(j=0;j < chkArr.length;j++){
 							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){	
 								//9.30 추가 - AMEND시 TAW/TAE/ASE/ASW이외의 SCOPE이 추가됬을 경우 해당ROW AMEND DELETE불가
 								if(mnChk == "Y" && sheetObj.CellValue(Number(chkArr[j])+sRow, "mnl_inp_flg") == "1") {
 									sheetObj.CellValue2(Number(chkArr[j])+sRow,"chk")=0;
 		 							ComShowCodeMessage("PRI01002");
 		 							return false;
 		 						}
 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","");
 								sRow++;
 							}else{
 								sheetObj.RowStatus(chkArr[j+sRow])="D";
 								sheetObj.RowEditable(chkArr[j]+sRow)=false;
 								sheetObj.RowHidden(chkArr[j]+sRow) = true;	
 							} 							
 						} 						
 						
 					}else{ 
 						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq 
 								|| ( sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")==amdt_seq 
 										&& (sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd")!="NW"
 										|| sheetObj.CellValue(sheetObj.SelectRow,"prc_prog_sts_cd")!="I"))){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")!= amdt_seq){ 							
 							if (mnChk == "Y" && sheetObj.CellValue(sheetObj.SelectRow,"mnl_inp_flg") =="1"){
 								ComShowCodeMessage("PRI01002");
 								return false;
 							} 						
 							comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"D","");
 						}else{
 							sheetObj.CellValue(sheetObj.SelectRow,"chk")=1;
 							deleteRowCheck(sheetObj, "chk", true);
 						}	
 					}					
 				}
 				fileColumnControl(sheetObj);
 				break;					
 				
 			case COMMAND01: // Amend			
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var columns = "";
 				var mnChk = document.form.mnl_chk.value;

 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						if (sheetObj.CellValue(chkArr[0], "mnl_inp_flg") == "1"){
 							columns = "mnl_inp_flg|cust_loc_cd";
 						}else{
 							if(sheetObj.CellValue(chkArr[0], "sc_afil_tp_cd") =='U' ){
 								columns = "cust_seq|cust_cnt_cd|mnl_inp_flg|sc_afil_tp_cd|afil_rgst_rqst_ltr_nm";
 							}else{
 								columns = "cust_seq|cust_cnt_cd|mnl_inp_flg|sc_afil_tp_cd|oti_bd_atch_file_nm|oti_lic_atch_file_nm|trf_tit_atch_file_nm|afil_rgst_rqst_ltr_nm";
 							}
 						}
 						if (mnChk == "Y" && sheetObj.CellValue(sheetObj.SelectRow,"mnl_inp_flg") =="1"){
 							ComShowCodeMessage("PRI01002");
 							return false;
 						}
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", columns);						
 					}
 				}else{ 			
 					if (sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1"){
 						columns = "mnl_inp_flg|cust_loc_cd";
 					}else{
 						if(sheetObj.CellValue(sheetObj.SelectRow, "sc_afil_tp_cd") =='U' ){
 							columns = "cust_seq|cust_cnt_cd|mnl_inp_flg|sc_afil_tp_cd|afil_rgst_rqst_ltr_nm";
 						}else{
 							columns = "cust_seq|cust_cnt_cd|mnl_inp_flg|sc_afil_tp_cd|oti_bd_atch_file_nm|oti_lic_atch_file_nm|trf_tit_atch_file_nm|afil_rgst_rqst_ltr_nm";
 						}
 					}
 					if (mnChk == "Y" && sheetObj.CellValue(sheetObj.SelectRow,"mnl_inp_flg") =="1"){
 						ComShowCodeMessage("PRI01002");
 						return false;
 					}
 					comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", columns);					
 				}
 				fileColumnControl(sheetObj);
 				break;	
 		
 			case COMMAND02: // Amend Cancel
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var columns = "";
 			
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						if (sheetObj.CellValue(chkArr[0], "mnl_inp_flg") == "1"){
 							columns = "mnl_inp_flg|cust_loc_cd";
 						}else{
 							columns = "cust_seq|cust_cnt_cd|mnl_inp_flg";
 						}
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", columns);		
 					}
 				}else{ 
 					if (sheetObj.CellValue(sheetObj.SelectRow, "mnl_inp_flg") == "1"){
 						columns = "mnl_inp_flg|cust_loc_cd";
 					}else{
 						columns = "cust_seq|cust_cnt_cd|mnl_inp_flg";
 					}
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", columns);
 					
 				}	
 				break;				
 			case MODIFY01: // Accept
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            } 			
 				
 				formObj.f_cmd.value = MODIFY01;
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do");
 				ComOpenWait(false); //->waiting->End
 				break; 	
 			case MODIFY02: // Accept Cancel
 				ComOpenWait(true); //->waiting->start
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value = MODIFY02;
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do");
 				ComOpenWait(false); //->waiting->End
 				break; 				
 			case IBSEARCH: // 조회
 				formObj.f_cmd.value = SEARCH01;
 				ComOpenWait(true); //->waiting->start
 				sheetObj.DoSearch("ESM_PRI_0025GS.do" , FormQueryString(formObj));
 				ComOpenWait(false); //->waiting->End
 				break;				
 			
 			case IBSAVE: // 저장
 				ComOpenWait(true); //->waiting->start
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 	            if (!ComPriConfirmSave()) {
 	                return false;
 	            }
 	            
 	        	for (var a = 0; a <= 0; a++) {
 	        		for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
 	            		// Proposal단계이고 src_info_cd가 GC(Guideline Copy)인 경우, 수정되면 GM(Guideline Modification)으로 바꿔준다.
 	            		if (sheetObjects[a].RowStatus(i) == "U"
 	            				&& sheetObjects[a].CellValue(i, "src_info_cd") == "GC") {
 	            			sheetObjects[a].CellValue(i, "src_info_cd") = "GM";
 	            		}
 	            		
 	            		// Proposal단계이고 src_info_cd가 PC(Previous Contract)인 경우, 수정되면 PM(Previous Contract Modification)으로 바꿔준다.
 	            		if (sheetObjects[a].RowStatus(i) == "U"
 		        				&& sheetObjects[a].CellValue(i, "src_info_cd") == "PC") {
 	            			sheetObjects[a].CellValue(i, "src_info_cd") = "PM";
 	            		}
 	        		}
 	        	}				
 			
 		 		formObj.f_cmd.value = MULTI01;		 		
  				var sParam = FormQueryString(formObj);
  				var sParamSheet = sheetObj.GetSaveString(); 	
  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0025GS.do", sParam+"&"+sParamSheet);
  				sheetObj.LoadSaveXml(sXml); 
  				ComOpenWait(false); //->waiting->End
  				buttonControl();
  				columnControl();
  				fileColumnControl(sheetObj);
 		 		break;	
 			case MODIFY05: // Accept All
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}
 				formObj.f_cmd.value = MODIFY03;
 				formObj.sts_cd.value = 'A';
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do", true);
 				ComOpenWait(false); //->waiting->End
 				break;			
 		
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}			
 				formObj.f_cmd.value = MODIFY04;
 				formObj.sts_cd.value = 'I';
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0025GS.do", true);
 				ComOpenWait(false); //->waiting->End
 				break;
 				
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk|seq|src_info_cd|prc_prog_sts_cd");
				break;
 								
          }        	 
         } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e);
              }
          }finally{
          	if (sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBINSERT
          			|| sAction == IBSEARCH_ASYNC01 || sAction == IBDELETE) {
          		return;
          	}
          	ComOpenWait(false); //->waiting->End
          }
         

     }

   
   
     /**
      * OnSearchEnd 이벤트 발생시 호출되는 function <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
      * @return 없음
      * @author 공백진
      * @version 2009.05.20
      */ 	   
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
		searchEndFontChange(sheetObj, "",document.form.lgcy_if_flg.value);
        columnControl();
        buttonControl();
        fileColumnControl(sheetObj);
	}  	 
 	
      /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
      * @author 공백진
      * @version 2009.04.17
      */        	
   	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
          if (OldRow != NewRow) {
              changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
    * @author 공백진
    * @version 2009.04.17
    */
  	function validateForm(sheetObj, formObj, sAction) {
  		switch (sAction) {
  		case IBSEARCH: // 조회
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
  				return false;
  			} else {
  				return true;
  			}
  			break;
  		
  		case IBSAVE: // 저장
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			}
  		
			var sParamSheet = sheetObj.GetSaveString(); 				 				
			if (!sheetObj.IsDataModified && sParamSheet == "") {
				ComShowCodeMessage("PRI00301");
				return false;
			}	 		
			
  			
  			for (i = 1 ; i <= sheetObj.RowCount ; i++){
  				if (sheetObj.CellValue(i,"mnl_inp_flg") == "1"){
  					if (sheetObj.CellValue(i,"cust_nm") == "" || sheetObj.CellValue(i, "cust_addr") =="" ){
  						ComShowCodeMessage("PRI01013", i);
  						sheetObj.SelectCell(i,"cust_nm");
  						return false;
  					}  					
  				}else{ 
  					if (sheetObj.CellValue(i, "cust_cnt_cd") == "" || sheetObj.CellValue(i, "cust_seq") == ""){
  						ComShowCodeMessage("PRI01014", i);
  						sheetObj.SelectCell(i,"cust_cnt_cd");
  						return false;
  					}
  				}
  				
  				var custTpCd = document.form.cust_tp_cd.value;
  				var isTpe = document.form.isTpe.value;
  				//var effdt = ComGetUnMaskedValue(document.form.hdr_eff_dt.value,"ymd");
  				// EFF Date 체크는 추후 삭제가능함 -- 임시적으로 사용
  				
  				if( custTpCd == "N" && sheetObj.CellValue(i, "eff_dt") >= "20110501" && isTpe == "Y"){
	  				if( sheetObj.CellValue(i,"prc_prog_sts_cd") == "I" && (sheetObj.CellValue(i,"ibflag") == "I" || sheetObj.CellValue(i,"ibflag") == "U") && sheetObj.CellEditable(i, "cust_cnt_cd")){
	  					if (sheetObj.CellValue(i, "sc_afil_tp_cd") == ""){
	  						ComShowCodeMessage("PRI00316", "Affiliate Type");
	  						sheetObj.SelectCell(i,"sc_afil_tp_cd");
	  						return false;
	  					}
	  					
	  					if(sheetObj.CellValue(i, "sc_afil_tp_cd") == 'A'){
	  						if (sheetObj.CellValue(i, "oti_bd_atch_file_id") == ""){
	  							ComShowCodeMessage("PRI00316", "OTI Bond");
	  							sheetObj.SelectCell(i, "oti_bd_atch_file_nm");
	  							return false;
	  						}
	  						
	  						if (sheetObj.CellValue(i, "trf_tit_atch_file_id") == ""){
	  							ComShowCodeMessage("PRI00316", "Tariff Title Page");
	  							sheetObj.SelectCell(i, "trf_tit_atch_file_nm");
	  							return false;
	  						}
	  					}
		  				else{
	  						if(sheetObj.CellValue(i, "afil_rgst_rqst_ltr_id") == ""){
	  							ComShowCodeMessage("PRI00316", "Affiliate Registration Request letter");
	  							sheetObj.SelectCell(i, "afil_rgst_rqst_ltr_nm");
	  							return false;
	  						}
		  				}
	  				}
  				}
  			}
  		//중복처리 - mnl_inp_flg 가 1인 Row는 제외한다.
  			var preIbflag = "";
  			for (var i = 1; i<= sheetObj.RowCount; i++){
  				preIbflag = sheetObj.RowStatus(i);	
  				if (sheetObj.CellValue(i, "mnl_inp_flg") == "1"){
 					sheetObj.CellValue2(i, "cust_cnt_cd_tmp") = i;
  	  				sheetObj.CellValue2(i, "cust_seq_tmp") = i;  	  				
  				}else{
  					sheetObj.CellValue2(i, "cust_cnt_cd_tmp") = ComTrim(sheetObj.CellValue(i, "cust_cnt_cd"));
  	  				sheetObj.CellValue2(i, "cust_seq_tmp") = ComTrim(sheetObj.CellValue(i, "cust_seq"));  
  				}
  				sheetObj.RowStatus(i) = preIbflag;
  			}  			
  			
  			//아래 로직 때문에 manual input 시 customer code가 빈자리가 되기 때문에 무조건 걸림 (주석처리함) CHM-201325030
//			 var rowM = priAmendDupCheck(sheetObj, "cust_cnt_cd|cust_seq|cust_nm", formObj.amdt_seq.value)
//			 if (rowM >= 0) {
//				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
//				 sheetObj.SelectCell(rowM, "cust_nm");
//			     return false;
//		     } 
			 rowM = priAmendDupCheck(sheetObj, "cust_cnt_cd_tmp|cust_seq_tmp", formObj.amdt_seq.value)
			 if (rowM >= 0) {				 
				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
				 sheetObj.SelectCell(rowM, "cust_cnt_cd");
			     return false;
		    }

  			return true;
  			break;
  			
  		case IBINSERT: // Row Add
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;

  			}
			if(sheetObj.RowCount > 0 && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != form.amdt_seq.value) { //amend 사이에 add 안되게 막기
				ComShowCodeMessage("PRI01002");		
				return false;
			}
  			return true;
  			break;
  			
  		case IBDELETE: // Delete
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
  				return false;
  			} else {
  				return true;
  			}
  			break;
  		}
  	}


    
    
	/**
     * 버튼 권한을 제어하는 컨트롤 function <br>
     * 화면의 버튼을 상태에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function buttonControl(){
		var formObj = document.form;
		var req_usr_flg = formObj.req_usr_flg.value;
		var apro_usr_flg = formObj.apro_usr_flg.value;
		var amdt_seq =  formObj.amdt_seq.value;
		var sts = formObj.prop_sts_cd.value;

		if(amdt_seq == 0) {
			hiddenButton("btn_Amend");
			hiddenButton("btn_AmendCancel");
		} else {
			showButton("btn_Amend");
			showButton("btn_AmendCancel");	
		}	
		
		if (apro_usr_flg == "false" && req_usr_flg == "false"){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_Amend");
			ComBtnDisable("btn_AmendCancel");
			ComBtnDisable("btn_Accept");
			ComBtnDisable("btn_AcceptCancel");
			ComBtnDisable("btn_AcceptAll");
			ComBtnDisable("btn_CancelAll");
			
			for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
				sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
				sheetObjects[0].CellEditable(i,"cust_seq") = false;
				sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
				sheetObjects[0].CellEditable(i,"cust_nm") = false;				
				sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
				sheetObjects[0].CellEditable(i,"cust_addr") = false;
				sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
				sheetObjects[0].CellEditable(i,"moc_lic_no") = false;

			}					
			return;
		}		
		
		try{
			switch(sts) { 				
				case 'I':   // Initial									
					ComBtnDisable("btn_AcceptAll");					
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");	
					
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd") =="A"){
							sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
							sheetObjects[0].CellEditable(i,"cust_seq") = false;
							sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
							sheetObjects[0].CellEditable(i,"cust_nm") = false;
							sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
							sheetObjects[0].CellEditable(i,"cust_addr") = false;
							sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
							sheetObjects[0].CellEditable(i,"moc_lic_no") = false;

						}

					}	
					
					break;
				case 'A': // Approved  모두금지 조회,downexcel은 가능
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");										
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");					
					
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_seq") = false;
						sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_addr") = false;
						sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
						sheetObjects[0].CellEditable(i,"moc_lic_no") = false;
					}	
					break;
					
				case 'Q':// Requested  

					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");					
			
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}else{						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}						

					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_seq") = false;
						sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_addr") = false;
						sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
						sheetObjects[0].CellEditable(i,"moc_lic_no") = false;

					}						
					break;
			
				case 'R':  // Returned accept만 가능,
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_LoadExcel");	
										
					if(req_usr_flg == "true"){
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
					}
					
					if (apro_usr_flg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
					}

					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_seq") = false;
						sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
						sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
						sheetObjects[0].CellEditable(i,"moc_lic_no") = false;

					}	

					break;
				case 'F': // Filed  approved 와 동일
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");	
					
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cust_cnt_cd") = false;
						sheetObjects[0].CellEditable(i,"cust_seq") = false;
						sheetObjects[0].CellEditable(i,"mnl_inp_flg") = false;
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
						sheetObjects[0].CellEditable(i,"sc_afil_tp_cd") = false;
						sheetObjects[0].CellEditable(i,"moc_lic_no") = false;

					}	
					
					break;
					
				case 'C': //  // Cancled  approved 와 동일
					ComBtnDisable("btn_Save");					
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");					
					break;
					
				default:
    				showButton("btn_Amend");
    				showButton("btn_AmendCancel");
    				ComBtnEnable("btn_AcceptAll");
    				ComBtnEnable("btn_CancelAll");
    				ComBtnEnable("btn_Accept");
    				ComBtnEnable("btn_AcceptCancel");
					break;
					
			} 		
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}          
  	
    /**
    * Sheet 컬럼의 edit 여부를 지정하는  function <br>
    *  <br>
    * <br><b>Example :</b>
    * <pre>
    *		columnControl
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */       	
    function columnControl(){
    	var mnChk = document.form.mnl_chk.value;
    	var sheetObj = sheetObjects[0];
    	var amdt_seq = document.form.amdt_seq.value;
    	var eff_dt = document.form.eff_dt.value;
 	    var sts = document.form.prop_sts_cd.value;		
		var custTpCd = document.form.cust_tp_cd.value;		
		var isTpe = document.form.isTpe.value;
		
		if( custTpCd != "N" || isTpe == "N"){
			sheetObj.ColHidden("nvocc_bd_no")			= true;
	   		sheetObj.ColHidden("oti_bd_atch_file_nm")	= true;
	   		sheetObj.ColHidden("oti_bd_atch_file_del")	= true;
	   		sheetObj.ColHidden("trf_tit_atch_file_nm")	= true;
	   		sheetObj.ColHidden("trf_tit_atch_file_del")	= true;
	   		sheetObj.ColHidden("nvocc_lic_no")			= true;
	   		sheetObj.ColHidden("oti_lic_atch_file_nm")	= true;
	   		sheetObj.ColHidden("oti_lic_atch_file_del")	= true;
	   		sheetObj.ColHidden("poa_atch_file_nm")		= true;
	   		sheetObj.ColHidden("poa_atch_file_del")		= true;
	   		sheetObj.ColHidden("sc_afil_tp_cd")			= true;
//	   		sheetObj.ColHidden("afil_rgst_rqst_ltr_nm")	= true;
//	   		sheetObj.ColHidden("afil_rgst_rqst_ltr_del")= true;
	   	} else {
	   		sheetObj.ColHidden("nvocc_bd_no")			= false;
	   		sheetObj.ColHidden("oti_bd_atch_file_nm")	= false;
	   		sheetObj.ColHidden("oti_bd_atch_file_del")	= false;
	   		sheetObj.ColHidden("trf_tit_atch_file_nm")	= false;
	   		sheetObj.ColHidden("trf_tit_atch_file_del")	= false;
	   		sheetObj.ColHidden("nvocc_lic_no")			= false;
	   		sheetObj.ColHidden("oti_lic_atch_file_nm")	= false;
	   		sheetObj.ColHidden("oti_lic_atch_file_del")	= false;
	   		sheetObj.ColHidden("poa_atch_file_nm")		= false;
	   		sheetObj.ColHidden("poa_atch_file_del")		= false;
	   		sheetObj.ColHidden("afil_rgst_rqst_ltr_nm")	= false;
	   		sheetObj.ColHidden("afil_rgst_rqst_ltr_del")= false;
	   	}
		if( custTpCd != "N"  ){
			sheetObj.ColHidden("moc_lic_no")			= true;
	   	} else {
	   		sheetObj.ColHidden("moc_lic_no")			= false;
	   	}
    		
    	if (mnChk == 'N' ){
    		sheetObj.ColHidden("mnl_inp_flg") = false;
    	}else{
    		sheetObj.ColHidden("mnl_inp_flg") = true;
    	}

		if(amdt_seq == 0){
        	for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i,"mnl_inp_flg") == 1) {
					sheetObj.CellEditable(i,"cust_cnt_cd") = false;
					sheetObj.CellEditable(i,"cust_seq") = false;
					if (mnChk =='Y'){
						sheetObj.CellEditable(i, "cust_nm") = false;
					}
					sheetObj.CellEditable(i,"moc_lic_no") = false;

				}else{
					sheetObj.CellEditable(i,"cust_cnt_cd") = true;
					sheetObj.CellEditable(i,"cust_seq") = true;
					sheetObj.CellEditable(i, "cust_nm") = false;
					sheetObj.CellEditable(i, "sc_afil_tp_cd") = true;
					sheetObj.CellEditable(i,"moc_lic_no") = true;

				}
			}			
        	
			return;
		}	
		//cust_loc_cd
		for(i = 1 ; i < sheetObj.Rows; i++){
			if(sheetObj.CellValue(i, "amdt_seq") != amdt_seq){ 
    			sheetObj.CellEditable(i,"cust_cnt_cd") = false;
    			sheetObj.CellEditable(i,"cust_seq") = false;
			}
			
			else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
				if (sheetObj.CellValue(i, "src_info_cd") != "AD"){	        			
					if (sheetObj.CellValue(i, "mnl_inp_flg") == 1){
        				sheetObj.CellEditable(i, "cust_cnt_cd") = false;
            			sheetObj.CellEditable(i, "cust_seq") = false;  
            			if (mnChk = "Y"){
                			sheetObj.CellEditable(i, "cust_loc_cd") = true;
                			sheetObj.CellEditable(i, "mnl_inp_flg") = true;    
            			}else{
                			sheetObj.CellEditable(i, "cust_loc_cd") = false;
                			sheetObj.CellEditable(i, "mnl_inp_flg") = true;    
            			}
            			sheetObj.CellEditable(i, "cust_nm") = false;
        			}else{
    					sheetObj.CellEditable(i, "cust_cnt_cd") = true;
            			sheetObj.CellEditable(i, "cust_seq") = true;
            			sheetObj.CellEditable(i, "mnl_inp_flg") = true;
            			sheetObj.CellEditable(i, "sc_afil_tp_cd") = true;
            			sheetObj.CellEditable(i, "cust_nm") = false;
            			sheetObj.CellEditable(i, "cust_loc_cd") = false;
            			if(sheetObj.CellValue(i, "sc_afil_tp_cd") == 'U'){
            				sheetObj.CellEditable(i, "oti_bd_atch_file_nm") = false;
            				sheetObj.CellEditable(i, "oti_bd_atch_file_del") = false;
            				sheetObj.CellEditable(i, "trf_tit_atch_file_nm") = false;
            				sheetObj.CellEditable(i, "trf_tit_atch_file_del") = false;
            				sheetObj.CellEditable(i, "nvocc_lic_no") = false;
            				sheetObj.CellEditable(i, "oti_lic_atch_file_nm") = false;
            				sheetObj.CellEditable(i, "oti_lic_atch_file_del") = false;
            				sheetObj.CellEditable(i, "moc_lic_no") = false;
            			}
        			}
				}
			}
		}
		changeSheetMemoColor();
    }
    
    
    /**
    * Sheet의 MemoPad의 색상을 지정하는  function <br>
    *  <br>
    * <br><b>Example :</b>
    * <pre>
    *		columnControl
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 
    function changeSheetMemoColor(){
		var sheetObj = sheetObjects[0];		
    	for (var i = 1; i <= sheetObj.RowCount;i++){
			sheetObj.RangeBackColor(i,10,i,10) = sheetObj.RangeBackColor(i,9,i,9)
		}
    }
    
    /**
    * manual input일 경우 컬럼의 edit 여부를 수정하는 function <br>
    *  <br>
    * <br><b>Example :</b>
    * <pre>
    *		mnuInput(true,1)
    * </pre>
    * @param {boolean} sw 필수 true,false
    * @param {int} Row 필수 적용컬럼
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function mnuInput(sw,Row){ 	

    	var sheetObj = sheetObjects[0];
    	var amdt_seq = document.form.amdt_seq.value;
    	if (amdt_seq == 0 ){
    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
    		sheetObj.CellEditable(Row,"cust_seq") = sw;
    		
    		if (sw==true){
    			sheetObj.RangeBackColor(Row,9,Row,10) = sheetObj.UnEditableColor;
    		}else{
    			sheetObj.RangeBackColor(Row,9,Row,10) = sheetObj.RgbColor(255,255,255);
    		}
    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
    	}else{
    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
    		sheetObj.CellEditable(Row,"cust_seq") = sw;
    		if (sw==true){
    			sheetObj.RangeBackColor(Row,9,Row,10) = sheetObj.UnEditableColor;
    		}else{
    			sheetObj.RangeBackColor(Row,9,Row,10) = sheetObj.RgbColor(255,255,255);
    		}    	
    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
    	}

    }    

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  	
    
     function sheet1_OnChange(sheetObj, Row, Col, Value)
     {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form;
     	
     	switch(colname)
     	{
 	    	case "mnl_inp_flg":
 	    		if (sheetObj.CellValue(Row,Col) == 1 ){
 	    			mnuInput(false,Row);
 	    		}else{
 	    			mnuInput(true,Row);
 	    		}
 	    		locationCellClear(sheetObj,Row)
 	    		break;
 	    	case "cust_cnt_cd":
 	    		if (Value.length > 0){
 	    			if (sheetObj.CellValue(Row, "cust_seq") !=""){
 	 	    			formObj.f_cmd.value = SEARCH01;  
 	 	    			var param = FormQueryString(formObj)+"&nmd_cust_flg=N" +"&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
 	 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
 	 	    			//[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
 	   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd|nvocc_bd_no|nvocc_lic_no|rvis_cntr_cust_tp_nm");   	  	
 	 					if (arrData != null){
 	 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
 	 						sheetObj.CellValue2(Row,"cust_addr") = arrData[0][1];
 	 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2];
 	 						sheetObj.CellValue2(Row,"nvocc_bd_no") = arrData[0][3];
 	 						sheetObj.CellValue2(Row,"nvocc_lic_no") = arrData[0][4];
 	 						sheetObj.CellValue2(Row,"rvis_cntr_cust_tp_nm") = arrData[0][5];
 	 					}else{
 	 						ComShowCodeMessage("PRI00315");
 	 						locationCellClear(sheetObj,Row);
 	 					}
 	    			} 	    			
 	    		}	    		
 	    		
 	    		break;	  	    		
 	    	case "cust_seq": 	    		
 	    		if (Value.length > 0){
 	    			formObj.f_cmd.value = SEARCH01;  
 	    			var param = FormQueryString(formObj)+"&nmd_cust_flg=N" +"&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
 	    			//[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd|nvocc_bd_no|nvocc_lic_no|rvis_cntr_cust_tp_nm");   	  	 	
 					if (arrData != null){
 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
 						sheetObj.CellValue2(Row,"cust_addr") = arrData[0][1];
 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2]; 
 	 					sheetObj.CellValue2(Row,"nvocc_bd_no") = arrData[0][3];
 	 					sheetObj.CellValue2(Row,"nvocc_lic_no") = arrData[0][4];	
 	 					sheetObj.CellValue2(Row,"rvis_cntr_cust_tp_nm") = arrData[0][5];
 						
 						//CUST_SEQ 앞에 '0'문자로 채움
         	    		if (Value.length < 6 && Value.length != 0){	 	    		
        	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComTrim(ComLpad(Value, 6, "0"));
        	 	    	}         	    		
 					}else{
 						ComShowCodeMessage("PRI00315");
 						locationCellClear(sheetObj,Row);
 					}	  				
 	    		}       		
 	    		
 	    		break;	 
 	    	case "cust_loc_cd":
 	    			if (Value.length == 5) {		
 	    				formObj.f_cmd.value = SEARCH05;
 	    				formObj.cd.value = Value;
 						var sParam = FormQueryString(formObj);
 						var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 						var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
 						if (arrDesc != null && arrDesc.length > 0) {

 						} else {
 	 						sheetObj.CellValue2(Row, "cust_loc_cd") = "";
 	 						sheetObj.SelectCell(Row, "cust_loc_cd");
 						}
 					}else{
 						sheetObj.CellValue2(Row, "cust_loc_cd") = "";
 						sheetObj.SelectCell(Row, "cust_loc_cd");
 					}
 	    		break;
 	    		
 	    	case "sc_afil_tp_cd":
 	    		var fileColArray = new Array("oti_bd_atch_file_",
						 "trf_tit_atch_file_",
						 "oti_lic_atch_file_");
 	    		
 	    		if(sheetObj.CellValue(Row,Col) == 'U'){
 	    			for( var j=0; j < fileColArray.length; j++ ){
    					if(sheetObj.CellValue(Row,fileColArray[j]+"id") != ""){
    						sheetObj.CellValue(Row,fileColArray[j]+"id") = "";
    						sheetObj.CellValue(Row,fileColArray[j]+"nm") = "";
    						sheetObj.CellImage(Row,fileColArray[j]+"del") = "";
    						sheetObj.CellEditable(Row, fileColArray[j]+"nm") = false;
    					}
    					else
    						sheetObj.CellEditable(Row, fileColArray[j]+"nm") = false;
    				}
 	    			sheetObj.CellEditable(Row,'nvocc_lic_no') = false;
 	    			sheetObj.CellEditable(Row,'nvocc_bd_no') = false;
 	    	}else{
 	    		for( var j=0; j < fileColArray.length; j++ ){
						sheetObj.CellEditable(Row, fileColArray[j]+"nm") = true;
 	    		}
 	    	}
     	}
     }    
     
     /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet의 해당 Sel을 클릭 시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */  	           
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var colname = sheetObj.ColSaveName(Col);  	 
 	    var amdtSeq = document.form.amdt_seq.value;
 	    var eff_dt = document.form.eff_dt.value;
 	    var readOnly = false;
 	    var sts = document.form.prop_sts_cd.value;
 	    var mnChk = document.form.mnl_chk.value;
 	    var stsCd = sheetObj.CellValue(Row, "prc_prog_sts_cd");

      	switch(colname)
      	{
      		case "cust_nm":
      		case "cust_addr": 	    		
  	    		if (amdtSeq == 0){
  	    			if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1){
  	    				if (mnChk == 'Y'){
  	    					readOnly = true;
  	    				}else{
  	    					if (sts == "I"){
  	    						if (stsCd == "A"){
  	    							readOnly = true;
  	    						}else{
  	    							readOnly = false;
  	    						}
  	    					}else{
  	    						readOnly = true;
  	    					} 	    					
  	    				} 	 	    				
  	    			}else{
  	    				readOnly = true;
  	    			} 	    			
  	    		}else if(sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
  									
  					if (sheetObj.CellValue(Row , "src_info_cd") != "AD"){				
  						if (sheetObj.CellValue(Row, "mnl_inp_flg") == 1){
  							if (sts =="R" || sts =="Q" || sts=="F"){
  								readOnly = true;
  							}else{
  	    						if (stsCd == "A"){
  	    							readOnly = true;
  	    						}else{
  	    							readOnly = false;
  	    						}
  							} 							
  						}else{
  							if (amdtSeq == 0){
  								readOnly = true;
  							}else{	
								if (sheetObj.CellValue(Row , "src_info_cd") =="AM"){
	  	    						if (stsCd == "A"){
	  	    							readOnly = true;
	  	    						}else{
	  	    							readOnly = true; //amend 시 주소, name 수정 불가 [CHM-201430523]
	  	    						}
								}else{
									readOnly = true;
								}
  							} 							
  						} 						
  					}else{// src_info_cd 가 AD이면 수정금지
  						readOnly = true;
  					} 					
  				}else{ 					
  					readOnly = true; 					
  				} 	    		
  	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 450, 80);
  	    		break;
      		case "oti_bd_atch_file_del":
				fileColumnEvent(sheetObj, Row, "OnClick", "oti_bd_atch_file_");
				break;
			case "oti_lic_atch_file_del":
				fileColumnEvent(sheetObj, Row, "OnClick", "oti_lic_atch_file_");
				break;
			case "trf_tit_atch_file_del":
				fileColumnEvent(sheetObj, Row, "OnClick", "trf_tit_atch_file_");
				break;
			case "afil_rgst_rqst_ltr_del":
				fileColumnEvent(sheetObj, Row, "OnClick", "afil_rgst_rqst_ltr_");
				break;
      	}    	 

     }     

     
     
    /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * Location PopUp을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.06.03
     */  	      	 
 	function sheet1_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
       	switch(colName)
       	{
   	    	case "cust_seq":		
 	  	  		var sUrl = "/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.CellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.CellValue(Row, "cust_seq");
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 640, 460, true);
 	  			
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "cust_cnt_cd") = rtnVal.custCntCd;
 	  				sheetObj.CellValue2(Row, "cust_seq") = rtnVal.custSeq;
 	  				
						//CUST_SEQ 앞에 '0'문자로 채움
     	    		if (rtnVal.custSeq.length < 6 && rtnVal.custSeq.length != 0){	 	    		
    	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComLpad(rtnVal.custSeq, 6, "0");
    	 	    	} 
 	  				
 	  				sheetObj.CellValue2(Row, "cust_nm") = rtnVal.custNm;
 	  				sheetObj.CellValue2(Row, "cust_addr") = rtnVal.Addr;
 	  				sheetObj.CellValue2(Row, "cust_loc_cd") = rtnVal.LocCd;
 	  				
 	  		  		//[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
 	  				sheetObj.CellValue2(Row, "rvis_cntr_cust_tp_nm") = rtnVal.rvisCntrCustTpNm;
	  				
 	  			}
   	    		break;

	    	case "oti_bd_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "oti_bd_atch_file_");
	    		break;

	    	case "oti_lic_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "oti_lic_atch_file_");
	    		break;

	    	case "trf_tit_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "trf_tit_atch_file_");
	    		break;
	    	case "afil_rgst_rqst_ltr_nm":
	    		doFileUpload(sheetObj, Row, Col, "afil_rgst_rqst_ltr_");
	    		break;
       	}
 	} 
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 Edit 컬럼을 설정한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {		
			dialogArguments.comUpdateProposalStatusSummary("05", "");			
			rData ="Y";
		}
		changeSheetMemoColor();
	}      

    /**
     * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		locationCellClear(sheetObj,Row)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  	    
  	function locationCellClear(sheetObj,Row){    	
    	sheetObj.CellValue2(Row, "cust_seq")= ""; 		
  		sheetObj.CellValue2(Row, "cust_cnt_cd")= "";
  		sheetObj.CellValue2(Row, "cust_nm")= "";
  		sheetObj.CellValue2(Row, "cust_addr")= "";
  		sheetObj.CellValue2(Row, "cust_loc_cd")= "";  		
  		sheetObj.SelectCell(Row, "cust_cnt_cd");
  		//[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
  		sheetObj.CellValue2(Row, "rvis_cntr_cust_tp_nm")= "";  
  	}   
     
     /**
      * SVC Scope이 TAW/TAE/ASE/ASW 이 아닌 경우가 하나라도 있을 경우 Mannual Input 칼럼을<br>
      * 숨기기위하여 값을 가져오는 함수<br>
      * form load 시 호출한다.
      * <pre>
      * 		getManualCheck()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.06.03
      */  	    
 	function getManualCheck (){
		var formObj = document.form;		
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0025GS.do", FormQueryString(formObj));	
		var arrData = ComPriXml2Array(sXml, "mnl_inp_flg");
		if (arrData != null && arrData.length > 0) {
			formObj.mnl_chk.value = arrData[0][0];
		}
	}     	     
      
      /**
       * IBSheet에서 Amend를 고려한 중복체크를 실행한다.
       * 이전 Amend Sequence를 가진 행이나, Amend Delete(AD)된 행은 제외하고 체크한다.
       * 중복된 행이 없으면 -1을, 중복된 행이 있으면 해당 행의 row Index를 반환한다.(0 이상 값)  <br>
       * <br><b>Example :</b>
       * <pre>
       *     var dupRow = priAmendDupCheck(sheetObj, "prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
       *     if (dupRow >= 0) {
       *         sheetObj.SelectRow = dupRow;
       *         ComShowCodeMessage("PRI00302");
       *         return false;
       *     }
       * </pre>
       * @param {ibsheet} sheetObj    필수,IBSheet Object
       * @param {string}  sCol        필수, 중복검사시 기준이 되는 컬럼의 SaveName. "|"로 연결
       * @param {string}  amdtSeq     필수, 현재 amend sequence.(document.form.amdt_seq.value)
       * @return int <br>
       *         -1   : 중복된 행이 없을 경우
       *         0이상 : 중복된 Row의 Row Index
       * @author 박성수
       * @version 2009.06.10
       */
      function priAmendDupCheck(sheetObj, sCol, amdtSeq) {
          try {
              if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                  return;
              }
              if (sCol == undefined || sCol == null || sCol == "") {
                  return;
              }
              if (sheetObj.RowCount <= 0) {
                  return -1;
              }

              var dupRow = sheetObj.ColValueDupRows(sCol, false, true);

              if (dupRow == null || dupRow == "") {
                  return -1;
              }

              var arrCol = sCol.split("|");
              var arrTemp = dupRow.split("|");

              var arrBaseRow = arrTemp[0].split(",");
              var arrDesRow = arrTemp[1].split(",");

              for (var i = arrDesRow.length - 1; i >= 0; i--) {
                  if (sheetObj.CellValue(arrDesRow[i], "amdt_seq") != amdtSeq
                          || sheetObj.CellValue(arrDesRow[i], "src_info_cd") == "AD") {
                      arrDesRow.splice(i, 1);
                  }
              }

              for (var i = arrBaseRow.length - 1; i >= 0; i--) {
                  if (sheetObj.CellValue(arrBaseRow[i], "amdt_seq") != amdtSeq
                          || sheetObj.CellValue(arrBaseRow[i], "src_info_cd") == "AD") {

                      for (var j = 0; j < arrDesRow.length; j++) {
                           var isSame = true;
                           for (var k = 0; k < arrCol.length; k++) {
                               if (sheetObj.CellValue(arrBaseRow[i], arrCol[k]) != sheetObj.CellValue(arrDesRow[j], arrCol[k])) {
                                   isSame = false;
                                   break;
                               }
                           }

                           if (isSame) {
                               arrDesRow.splice(j, 1);
                               break;
                           }
                      }
                      arrBaseRow.splice(i, 1);
                  }
              }

              if (arrDesRow.length > 0) {
                  return arrDesRow[0];
              } else {
                  return -1;
              }

          } catch(err) { ComFuncErrMsg(err.message); }
      }      

	/**
   	 * IBUpload Object를 배열로 등록 <br>
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
   	 * 배열은 소스 상단에 정의 <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *     setUploadObject(uploadObj);
   	 * </pre>
   	 * @param {ibupload} uploadObj 필수 IBUpload Object
   	 * @return 없음
	 * @author 최성민
	 * @version 2010.10.13
   	 */
   	function setUploadObject(uploadObj) {
   		uploadObjects[uploadCnt++] = uploadObj;
   	}
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function setFileUpload(sheetObj, filePathUrl) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.SelectRow;
		var upObj = uploadObjects[0];
		
		//IBUpload에 파일 추가하기
		var ret = upObj.AddFile(filePathUrl);
		return ret;
	}
     /**
 	 * OnDblClick 이벤트 발생시 호출되는 function <br>
 	 * Sheet의 해당 Sel을 더블클릭 시 메모장을 화면에 표시한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 공백진
      * @version 2009.06.03
      */
 	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
 		//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
   
 		var colname = sheetObj.ColSaveName(Col);

 		switch(colname){
 			case "oti_bd_atch_file_nm":
				fileColumnEvent(sheetObj, Row, "OnDblClick", "oti_bd_atch_file_");
 				break;
 			case "oti_lic_atch_file_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "oti_lic_atch_file_");
 				break;
 			case "trf_tit_atch_file_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "trf_tit_atch_file_");
 				break;
 			case "afil_rgst_rqst_ltr_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "afil_rgst_rqst_ltr_");
 				break;
 		}
 	}
    
    function doFileUpload(sheetObj, Row, Col, colName){
 		if(sheetObj.CellValue(Row, colName+"id") == ""){
	  		//파일선택 다이얼로그 표시하기
	   		var filePathUrl = sheetObj.OpenFileDialog("Open File");
	   		
	   		//선택된 파일명이 있는 경우 처리하기
	   		if(filePathUrl.indexOf("\\") !=-1 ) {	 	   			
	   			//IBUpload에 파일 추가하기
				var uploadObj = uploadObjects[0];
				uploadObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
				
				var comFileMaxCount = 1;    // 업로드 가능한 파일의 최대 개수, 기본 256개
				var maxFileSize = 1024;  // 업로드 가능한 파일의 최대 용량, 기본 100MB, 단위 KB
				uploadObj.SetLimit(comFileMaxCount, maxFileSize, maxFileSize);
				
				ComOpenWait(true); //->waiting->start 
				var ret = setFileUpload(sheetObj, filePathUrl);
				if(ret != ""){
					ComShowCodeMessage("PRI01138");
					ComOpenWait(false); //->waiting->start 
					return;
				}
	  	   		sheetObj.CellEditable(Row, colName+"nm") = false;
				
	   			var formObj = document.form;
	   			
	   			formObj.f_cmd.value = SEARCH02;
				var sParam = FormQueryString(formObj);
				
				//서버에 request전달하고, reponse 받기	
	            if (uploadObj.LocalFiles != "") {
		            //*******파일이 있는 경우 IBUpload 이용하기*******
					uploadObj.ExtendParam = sParam;
					uploadObj.ParamDecoding = true;
		            sXml = uploadObj.DoUpload(true);
		                
		            var keyId = ComGetEtcData(sXml,"keyId");
		            sheetObj.CellValue2(Row, colName+"id") = keyId;
	            }
	            
	            if (sheetObj.CellValue(Row, colName+"id") != ""){
					sheetObj.CellImage(Row, colName+"del") = 0;

					//선택된 파일의 이름만 팝업 셀에 설정하기
		   			var fileName = filePathUrl.substr(filePathUrl.lastIndexOf("\\")+1);
		   			sheetObj.CellValue2(Row, Col)= fileName;
	            }
	            ComOpenWait(false); //->waiting->start 
	   		}
 		}
    }
    
    function fileColumnControl(sheetObj){
    	var sts = document.form.prop_sts_cd.value;
    	var fileColArray = new Array("oti_bd_atch_file_",
    								 "trf_tit_atch_file_",
    								 "oti_lic_atch_file_",
    								 "afil_rgst_rqst_ltr_");
    	
	    for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
    		if( sts == "I" && sheetObj.CellValue(i,"prc_prog_sts_cd") == "I" && sheetObj.CellEditable(i, "cust_cnt_cd")){
    			if(sheetObj.CellValue(i,"sc_afil_tp_cd") == 'U'){
    				for( var j=3; j < fileColArray.length; j++ ){
    					if(sheetObj.CellValue(i,fileColArray[j]+"id") != ""){
    						sheetObj.CellImage(i,fileColArray[j]+"del") = 0;
    					}
    					else
    						sheetObj.CellEditable(i, fileColArray[j]+"nm") = true;
    				}
    			}else{
    				for( var j=0; j < fileColArray.length; j++ ){
    					if(sheetObj.CellValue(i,fileColArray[j]+"id") != ""){
    						sheetObj.CellImage(i,fileColArray[j]+"del") = 0;
    					}
    					else
    						sheetObj.CellEditable(i, fileColArray[j]+"nm") = true;
    				}
    			}
    		}
    	}
    }
    
    function fileColumnEvent(sheetObj, Row, event, colName){
    	var sts = document.form.prop_sts_cd.value;
    	
    	if ( event == "OnClick" ){
		    if( sts == "I" && sheetObj.CellValue(Row, "prc_prog_sts_cd") == "I" && sheetObj.CellEditable(Row, "cust_cnt_cd")){
		    	if( sheetObj.CellValue(Row, colName+"id") != "" ){
		    		sheetObj.CellValue(Row, colName+"id") = "";
		    		sheetObj.CellValue(Row, colName+"nm") = "";
		    		sheetObj.CellEditable(Row,colName+"nm") = true;
		    		sheetObj.CellImage(Row, colName+"del") = "";
				}
		    }
	    } else if ( event == "OnDblClick" ){
	    	if(sheetObj.CellValue(Row, colName+"id") != "")
				location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, colName+"id");
	    }
    }
    
    /** 
     * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {int} x 필수, X 좌표
     * @param {int} y 필수, Y 좌표
     * @return 없음
     */   
	function sheet1_OnMouseMove(sheetObj, shift, x, y){
	      var row = sheetObj.MouseRow;
	      var col = sheetObj.MouseCol;
	      var colName = sheetObj.ColSaveName(col);

	      if( colName == "oti_bd_atch_file_nm" 
	    	  || colName == "oti_lic_atch_file_nm" 
	    	  || colName == "trf_tit_atch_file_nm"
	    	  || colName == "afil_rgst_rqst_ltr_nm")
	      {
	    	  var sText = sheetObj.CellText(row,col);
	    	  sheetObj.ToolTipText(row,col) = sText;
	      }


	}
	/* 개발자 작업  끝 */