/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0048.js
*@FileTitle : Proposal  Affiliates - Inquiry
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
     * @class ESM_PRI_0048 : ESM_PRI_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0048() {
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
          var sheetObject2 = sheetObjects[1];
          
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
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
        
		var formObj = document.form;
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();

        getManualCheck();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
      
      
//      /**
//      * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
//      * <br><b>Example :</b>
//      * <pre>
//      *    
//      * </pre>
//      * @param {ibsheet} sheetObj 필수 IBSheet Object
//      * @return 없음
//      * @author 공백진
//      * @version 2009.04.17
//      */      
//     function sheet1_OnLoadFinish(sheetObj) {   
//         getManualCheck();
//         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
//  		 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//     }          
      
      
      
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
                     style.height = 160;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Mannual\nInput|Type|Customer Name|Address|Location|Effective Date|Effective Date|Source|Status|prc_prog_sts_dtl|acpt_usr_id|acpt_ofc_cd|Accept Staff/Team|Accept Date|cust_cnt_cd_tmp|cust_seq_tmp|n1st_cmnc_amdt_seq";
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

                     InitDataProperty(0, cnt++, dtDataSeq,      35,  daCenter, false, "Seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no",  		  false,  "", dfNone, 	0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  false,  "", dfNone, 	0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "afil_seq", 		  false,  "", dfNone, 	0, false, false);
					 InitDataProperty(0, cnt++, dtData,     	30,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, false,  true,  2);
                     InitDataProperty(0, cnt++, dtData,   	    65,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, false,  true,  6);
                     InitDataProperty(0, cnt++, dtCheckBox,  	70, daCenter, true,  "mnl_inp_flg",      false, "", dfNone,    0, false,  true);		
                     //[CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직
                     InitDataProperty(0, cnt++, dtData,     	80, daCenter,   true,  "rvis_cntr_cust_tp_nm",  false, "", dfNone, 	0, false,  false,  100);
                     InitDataProperty(0, cnt++, dtData,     	120, daLeft,   true,  "cust_nm",      	  false, "", dfNone, 	0, false,  false,  100);
                     InitDataProperty(0, cnt++, dtData,     	130, daLeft,   true,  "cust_addr",        false, "", dfNone, 	0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	60,  daCenter, true,  "cust_loc_cd",      false, "", dfNone, 	0, false, false,  5);                     
 					 InitDataProperty(0, cnt++, dtData,   		65,  daCenter, true,  "eff_dt",	  		false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   		65,  daCenter, true,  "exp_dt",		      false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		60,  daCenter, false, "src_info_cd",	  false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		60,  daCenter, false, "prc_prog_sts_cd",  false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,   	80,  daCenter, false, "prc_prog_sts_dtl", false, "", dfNone, 	0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_usr_id", 	  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_ofc_cd",      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtData, 	    120, daLeft, false, "acpt_usr_nm",      false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtData, 		65, daCenter, false, "acpt_dt", 		  false, "", dfDateYmd, 0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,     	40,  daCenter, true,  "cust_cnt_cd_tmp",  false, "", dfNone,    0, true,  true,  2);
                     InitDataProperty(0, cnt++, dtHidden,   	85,  daCenter, true,  "cust_seq_tmp",     false, "", dfNone,    0, true,  true,  6);                     
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "n1st_cmnc_amdt_seq",  false, "", dfNone, 	0, false, false);
                     
	                 InitDataValid(0,  "cust_cnt_cd",	vtEngUpOnly);	// 영문대문자만 입력
	                 InitDataValid(0,  "cust_seq",		vtNumericOnly);	// 숫자만 입력

	                 InitDataValid(0, "cust_nm", 		vtEngOther,PRI_VALID_CHAR);	
	                 InitDataValid(0, "cust_addr", 		vtEngOther,PRI_VALID_CHAR);
	                 
	                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "cust_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

 					 ShowButtonImage = 2; 
 					 Ellipsis = true;
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
       * @author 공백진
       * @version 2009.04.17
       */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         try{
             switch(sAction) {
 				case IBSEARCH_ASYNC01: // 조회			
	 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
	 				//	status
	 				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
	 				break; 				
	 			case IBSEARCH: // 조회
	 				ComOpenWait(true); //->waiting->start
	 				formObj.f_cmd.value = SEARCH01;
	 				sheetObj.DoSearch("ESM_PRI_0048GS.do" , FormQueryString(formObj));
	 				ComOpenWait(false); //->waiting->End
	 				break;		
             }
         } catch (e) {
           	if (e == "[object Error]") {
                   ComShowMessage(OBJECT_ERROR);
               } else {
                   ComShowMessage(e);
               }
          }finally{
	          if (sAction == IBSEARCH_ASYNC01) {
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
		var sCols = "";
		columnControl();
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
  		
  		}
  	}

 
     
     /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
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

     	switch(colname)
     	{
     		case "cust_nm": 
     		case "cust_addr": 	    		
 	    		ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
 	    		break;
     	}    	 

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
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0048GS.do", FormQueryString(formObj));	
		var arrData = ComPriXml2Array(sXml, "mnl_inp_flg");
		if (arrData != null && arrData.length > 0) {
			formObj.mnl_chk.value = arrData[0][0];
		}
	} 	     
    
  /**
   * 컬럼의 edit 여부를 지정하는  function <br>
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
	   	if (mnChk == 'N' ){
	   		sheetObj.ColHidden("mnl_inp_flg") = false;
	   	}else{
	   		sheetObj.ColHidden("mnl_inp_flg") = true;
	   	}
   }      



	/* 개발자 작업  끝 */