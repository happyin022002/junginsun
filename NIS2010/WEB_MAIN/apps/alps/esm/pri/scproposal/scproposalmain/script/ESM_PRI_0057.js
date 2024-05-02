/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057.js
*@FileTitle : Amendment History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.01 공백진
* 1.0 Creation
*=========================================================
* History :
* 2011.04.01 이관샨 [CHM-201109657-01] Amend history 에서 과거 Amendment Print 기능 추가, 변경된 내용만 출력되는 Print 버튼 기능 추가
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청 
* 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
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
     * @class ESM_PRI_0057 : ESM_PRI_0057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0057() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage; 
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
     
    
    /* 개발자 작업   */

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1; 
 var beforeChk = 0; 
 var sheetObjects = new Array();
 var sheetCnt = 0; 
 var comboObjects = new Array();
 var comboCnt = 0; 
 //이전 sc_no 
 var preScNo = "";
 var sUrl = "";
 var tabDataExist = new Array();
 tabDataExist[0] = 0;//rate
 tabDataExist[1] = 0;//note
 //wait image적용 후 각 tab 별로 tab enable 여부를 가지고 있는 변수
 var tabEnableFlg = new Array();
 
 //tab을 활성,비활성 상태로 보이게 하기위하여 지정하는 tab color
 var TAB_SELECT_COLOR = "131,133,217"; 
 var TAB_TRUE_COLOR = "206,220,246";
 var TAB_FALSE_COLOR = "192,192,192";
 
 var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
 var ICON_URL_AMEND = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon4.gif";
 
 /*
  *  숨겨진 기능인 super user 권한을 가졌는지 여부 
  */
 
// var FILE_CANCEL_ID  = "0010244";
// var FILE_CANCEL_ID2 = "0010593";
// var FILE_CANCEL_ID3 = "0660082";
// var FILE_CANCEL_ID4 = "0810022";
// var FILE_CANCEL_ID5 = "0810071";
// var FILE_CANCEL_ID6 = "0810273";
// var FILE_CANCEL_ID7 = "Clairelee";
// var FILE_CANCEL_ID8 = "0260062"; // CHM-201431827 - Filed Cancel 권한 부여 요청 추가
// var FILE_CANCEL_ID9 = "1110071"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
// var FILE_CANCEL_ID10 = "1110093"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
// var FILE_CANCEL_ID11 = "0310064"; // CHM-201537788 Filed Cancel 권한 부여 요청 추가
 
 //terms가 load 되었는지 확인
 var termLoad = false;
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

	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var sRow = sheetObj.SelectRow;
	
  	try {
  		var srcName = window.event.srcElement.getAttribute("name");
          switch(srcName) {
          case "btn_retrieve":  
			if (formObj.sc_no.value ==""){
				ComShowCodeMessage("PRI01061");
				formObj.sc_no.focus();
				return;
			}
         	 searchInitSheet(true);          
         	 sheetObj.RemoveAll();     
         	 doActionIBSheet(sheetObj,formObj,IBSEARCH);  
             break;
              
          case "btn_new":
        	 formObj.sc_no.value = "";
         	 clearAllForms();
         	 sheetObj.RemoveAll();
         	 comboObjects[0].RemoveAll();
         	 clearAllTabPages();
         	 tabObjects[0].SelectedIndex = 0;
         	 formObj.sc_no.focus();
         	 ComBtnDisable("btn_print");
         	 break;
          case "btn_print":       	    
            var sPropNo = sheetObj.CellValue(sRow,"prop_no");
            var sScNo = formObj.sc_no.value ;
            var sAmdtSeq = sheetObj.CellValue(sRow, "amdt_seq");
            var sParam = "";    
            var rtnVal = "";          
            
            //현재 화면에서 RD 호출 하는 화면으로 화면ID 전달 
            var sSpScrnEvntPgmCd = "ESM_PRI_0057"; 

	    	sParam = sPropNo + ":" + sScNo + ":" + sAmdtSeq + ";"
	    	
	    	//TODO:CHOI
	    	//[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
			// ESM_PRI_0003.js. buttonControl와 동일한 권한 참고
			var returnValue = checkPrintOpenAuthInfo(sParam);
			if(returnValue == "Y" ){
				// print Popup open
				rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+sParam  +"&sp_scrn_evnt_pgm_cd=" + sSpScrnEvntPgmCd  , "", 1024, 768, true);
			} else { 
				//경고 : 권한이 없음.(경고 메세지 요청)
				ComShowCodeMessage('PRI01163'); //("You are not the authorized user");
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
  * @author 공백진
  * @version 2009.04.17
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
   *     setTabObject(tab_obj);
   * </pre>
   * @param {ibtab} tab_obj 필수 IBTab Object
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */ 
  function setTabObject(tab_obj) {
      tabObjects[tabCnt++] = tab_obj;
  }
      
   /**
    * IBMulti Combo Object를 배열로 등록 <br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
    * 배열은 소스 상단에 정의 <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */    
  function setComboObject(combo_obj){
      comboObjects[comboCnt++] = combo_obj;
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
         for(var i=0;i<sheetObjects.length;i++){
         		//khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         		//khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(var k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
         
         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         
         initControl();
         initIBComboItem();  // IBCombo에 Item setting
         
         //ESM_PRI_0062 에서 메인 pop => 김대호 2009-10-06 : jsp 에도  파라미터 받고 박아주는것 추가합니다.
    	 var form = document.form;
         if("null" != form.sc_no_0062.value && null != form.sc_no_0062.value && "" != form.sc_no_0062.value) {
        	var scNo = form.sc_no_0062.value;
        	form.sc_no.value = scNo ;
         	form.sc_no.focus();
         	form.amdt_seq.focus();
         }
         form.sc_no.focus();
         ComBtnDisable("btn_print");
     }
          
     /**
      * IBMulti Combo 값을 Setting 한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     initIBComboItem();
      * </pre>
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     
      function initIBComboItem() {
          var formObj = document.form;
          ComPriTextCode2ComboItem(termTypeComboValue,termTypeComboText , getComboObject(comboObjects, 'term_type_cd') ,"|","\t" );

      }
      
      /**
       * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *     initControl()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */        
     function initControl() {
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)          
    	  axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    	  axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
    	  axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
    	  axon_event.addListener ('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
    	  axon_event.addListenerForm  ('click', 'obj_OnClick', form);
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
             case "engup":
                 if (event.srcElement.name == "sc_no" ) {
                     ComKeyOnlyAlphabet('uppernum');
                 } else {
                     ComKeyOnlyAlphabet('upper');
                 }    
                 break;
             case "int":
                 ComKeyOnlyNumber(event.srcElement);
                 break;
             case "float":
                 ComKeyOnlyNumber(event.srcElement, ".");
                 break;
             default:
         }
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
         var formObj = document.form;
         var sheetObj = sheetObjects[0]; 
         var eleName = event.srcElement.name;

         switch(eleName){
             case "sc_no":
            	 if (formObj.sc_no.value !=""){
            		 if (preScNo != formObj.sc_no.value){
            			 preScNo = formObj.sc_no.value ;
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);	
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH);            			 
            		 }            		 
            	 }            	 
                 break;                       
             default:            	
            	 ComChkObjValid(event.srcElement);       
         }
         preScNo = formObj.sc_no.value ;
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
         var formObj = document.form;
         var srcName = event.srcElement.getAttribute("name");
         ComClearSeparator (event.srcElement);
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
	  			case IBSEARCH_ASYNC01:      //조회
	  				ComOpenWait(true); //->waiting->start
	  				formObj.f_cmd.value = SEARCH01;
	  				var param = FormQueryString(formObj)+"&sc_no="+formObj.sc_no.value ;
	  			 	var sXml = sheetObj.GetSearchXml("ESM_PRI_0057GS.do" , param);
	  			 	clearAllForms();
	  			 	comboObjects[0].RemoveAll();
	  				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm"); 				
	  				comboObjects[0].InsertItem(0, "||", "X");
	  				comboObjects[0].Code = "X";
	  				
	 				if (ComGetEtcData(sXml,"prop_no") != undefined){
	 					formObj.prop_no.value =  ComGetEtcData(sXml,"prop_no");
	 				}else{
	 			 		formObj.sc_no.value = "";
	 				}
	 				if (ComGetEtcData(sXml,"amdt_seq") != undefined){
	 					formObj.amdt_seq.value =  ComGetEtcData(sXml,"amdt_seq");
	 				}				
	 				if (ComGetEtcData(sXml,"ctrt_pty_nm") != undefined){
	 					formObj.ctrt_pty_nm.value =  ComGetEtcData(sXml,"ctrt_pty_nm");
	 				}
	 				if (ComGetEtcData(sXml,"ctrt_eff_dt") != undefined){
	 					formObj.ctrt_eff_dt.value =  ComGetEtcData(sXml,"ctrt_eff_dt");
	 				}
	 				if (ComGetEtcData(sXml,"ctrt_exp_dt") != undefined){
	 					formObj.ctrt_exp_dt.value =  ComGetEtcData(sXml,"ctrt_exp_dt");
	 				}
	 				if (ComGetEtcData(sXml,"lgcy_if_flg") != undefined){
	 					formObj.lgcy_if_flg.value =  ComGetEtcData(sXml,"lgcy_if_flg");
	 				}
                    if (ComGetEtcData(sXml,"OFC_AUTH_YN") != undefined){
                        formObj.ofc_auth_yn.value =  ComGetEtcData(sXml,"OFC_AUTH_YN");
                    }	 	
                    if (ComGetEtcData(sXml,"REQ_USR_FLG") != undefined){
                        formObj.req_usr_flg.value =  ComGetEtcData(sXml,"REQ_USR_FLG");
                    }   
	                 break;
	  			case IBSEARCH:      //조회
	  				ComOpenWait(true); //->waiting->start
	  				formObj.f_cmd.value = SEARCH02; 				
	  				
	  				clearAllTabPages();
	 				var param = FormQueryString(formObj)+"&conv_flg="+getConversionValue();
	 			 	var sXml = sheetObj.GetSearchXml("ESM_PRI_0057GS.do" , param);
	 			 	sheetObj.LoadSearchXml(sXml);	
	 			 	break;
	
	          }        	 
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
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
       * @author 공백진
       * @version 2009.04.17
       */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
 		 var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 162;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 7, 100);

 					var HeadTitle1 = "|Seq.|AMD No.|SVC Scope|Filed Date|Effective Date|Expiry Date|Creation Date|Conversion Update|prop_no|pre_conv_cfm_flg|lgcy_if_flg";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                     // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                     // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                     // SAVESTATUS, FORMATFIX]                        
                     InitDataProperty(0, cnt++, dtHiddenStatus, 40,  daCenter, true,  "ibflag");
                     InitDataProperty(0, cnt++, dtDataSeq,		70,  daCenter, true,  "seq");
                     InitDataProperty(0, cnt++, dtData,		    100, daCenter, true,  "amdt_seq",     	  false, "", dfNone,     0, false, false,	3);
                     InitDataProperty(0, cnt++, dtData,		    110, daCenter, false, "svc_scp_cd",   	  false, "", dfDateYmd,  0, false, false,	3);
                     InitDataProperty(0, cnt++, dtData,		    140, daCenter, false, "file_dt",	  	  false, "", dfDateYmd,  0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    140, daCenter, false, "eff_dt",	      	  false, "", dfDateYmd,  0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    140, daCenter, false, "exp_dt",	      	  false, "", dfDateYmd,  0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    140, daCenter, false, "cre_dt",	      	  false, "", dfDateYmd,  0, false, false);
 					 InitDataProperty(0, cnt++, dtImage,		115, daCenter, false, "conv_cfm_flg", 	  false, "", dfNone,     0, true,  true);
 					 InitDataProperty(0, cnt++, dtHidden,		120, daCenter, false, "prop_no",          false, "", dfNone,     0, false, false);
 					 InitDataProperty(0, cnt++, dtHidden,		115, daCenter, false, "pre_conv_cfm_flg", false, "", dfNone,     0, false, false);
 					 InitDataProperty(0, cnt++, dtHidden,		120, daCenter, false, "lgcy_if_flg",  	  false, "", dfNone,     0, false, false);

 					 CountPosition = 0;		// Total 없음.
 					 
 	                 ImageList(2) = "img/blank.gif";
 	                 ImageList(0) = "img/tab_icon1.gif";
 	                 ImageList(1) = "img/tab_icon2.gif";
 	                 ColHidden("conv_cfm_flg") = true;
 	                 WaitImageVisible = false;

 				}
 	            break;

         }
     }


     /**
      * Tab 기본 설정 탭의 항목을 설정한다.  <br>
      * Tab이 다수일 경우 Tab 수만큼 case를 추가하여 Tab의 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initTab(tabObj,1);
      * </pre>
      * @param {tabObj} tabObj 필수 IBTab Object
      * @param {int} tabNo 필수 IBTab Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */   
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Duration",-1 );
                     InsertTab( cnt++ , "MQC"  ,-1);
                     InsertTab( cnt++ , "Cust. Type" ,-1 );
                     InsertTab( cnt++ , "Contract Party" ,-1 );
                     InsertTab( cnt++ , "Ori/Dest",-1 );
                     InsertTab( cnt++ , "G.Location",-1);
                     InsertTab( cnt++ , "G.CMDT",-1 );
                     InsertTab( cnt++ , "Arbitrary",-1 );
                     InsertTab( cnt++ , "Rate" ,-1);
                     InsertTab( cnt++ , "Special Note" ,-1 );
                     InsertTab( cnt++ , "Affiliate",-1  );
                     InsertTab( cnt++ , "L/Agent",-1 );
                     InsertTab( cnt++ , "IHC" ,-1);
                     InsertTab( cnt++ , "GOH" ,-1 );
                     InsertTab( cnt++ , "Boiler Plate" ,-1);                     
                 }
              break;

          }
     }

     /**
      * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
      * <br><b>Example :</b>
      * <pre>
      *     initCombo(comboObj,1);
      * </pre>
      * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
      * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */        
      function initCombo(comboObj, comboNo) {
          switch(comboObj.id) {
              case "svc_scp_cd":
                  var i=0;
                  with(comboObj) {
                      DropHeight = 200;
                      MultiSelect = false;
                      MaxSelect = 1;
  	                  UseAutoComplete = true;
	            	  IMEMode = 0;
	            	  ValidChar(2, 0);
	            	  MaxLength = 3;
                  }
                  break;    
              case "term_type_cd":
                  var i=0;
                  with(comboObj) {
                      DropHeight = 200;
                      MultiSelect = false;
                      MaxSelect = 1;
	                  UseAutoComplete = true;
	            	  IMEMode = 0;
	            	  ValidChar(2, 2);
                  }
                  break;                    
          }
      }      
      
      var preTab = 0;
      
      /**
       * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     tab1_OnChange(tabObj, tabIndex)
       * </pre>
       * @param {tabObj} tabObj 필수 IBTab Object
       * @param {int} tabIndex 필수 프로세스 플래그 상수
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */ 
	function tab1_OnChange(tabObj, tabIndex) {	   

		if (tabEnableFlg[tabIndex] !=undefined 
				&& !tabEnableFlg[beforetab] && !tabEnableFlg[tabIndex]){
			//이전 tab과 현재 tab이 모두   비활성화인경우 첫번째 tab으로 이동한다.
			tabObj.SelectBackColor = TAB_FALSE_COLOR;	

			if (termLoad == true){
				document.getElementById("t1frame").contentWindow.tabClearSheet();
			}
			var objs = document.all.item("tabLayer");
			objs[beforetab].style.display = "none"; 
			objs[0].style.display = "inline";

			if (beforetab != 0){
				loadTabPage(0);
			}

			beforetab = 0;
			return;
		}

		if (tabEnableFlg[tabIndex] !=undefined 
				&& tabEnableFlg[beforetab] && !tabEnableFlg[tabIndex]){
			tabObj.SelectedIndex = beforetab;
			return;
		}	

		if (beforetab != tabIndex) {
			var objs = document.all.item("tabLayer");
			objs[tabIndex].style.display = "inline";
			objs[beforetab].style.display = "none";              
		}    

		beforetab = tabIndex;
		loadTabPage(tabIndex);

	
	}

       /**
        * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
        * <br><b>Example :</b>
        * <pre>
        *     tab1_OnClick(tabObj, tabIndex)
        * </pre>
        * @param {tabObj} tabObj 필수 IBTab Object
        * @param {int} tabIndex 필수 프로세스 플래그 상수
        * @return 없음
        * @author 공백진
        * @version 2009.04.17
        */           
      function tab1_OnClick(tabObj,  tabIndex) {
        	if (!tabEnableFlg[tabIndex]){
  			  tabObj.SelectedIndex = beforetab;  

  		  }
      }         
       
      /**
       * Tab변경시 화면을 Frame에 로드한다.  <br>
       * <br><b>Example :</b>
       * <pre>
       *     loadTabPage(tabIndex)
       * </pre>
       * @param {tabIndex} tabIndex 필수 tab의 일련번호
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */            
      function loadTabPage(tabIndex) {    	  
          if (tabIndex == null || tabIndex == "") {
              tabIndex = tabObjects[0].SelectedIndex;
          }

          var objTabWindow = document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow;
          if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
              
              switch (tabIndex) {
              case 0://DURATIOIN
              		sUrl = "ESM_PRI_0057_01.do"; 
                  break;
              case 1://MQC
                  sUrl = "ESM_PRI_0057_02.do"; 
                  break;
              case 2://CUST TYPE
                  sUrl ="ESM_PRI_0057_17.do"; 
                  break;
              case 3:// CONTRACT PARTY
                  sUrl = "ESM_PRI_0057_18.do"; 
                  break;
              case 4://ORG/DEST
                  sUrl = "ESM_PRI_0057_04.do"; 
              		break;
              case 5://G LOCATION
                  sUrl = "ESM_PRI_0057_14.do"; 
                  break;
              case 6://G CDMT
                  sUrl = "ESM_PRI_0057_05.do"; 
                  break;
              case 7: //ARB
              	sUrl = "ESM_PRI_0057_07.do"; 
                  break;
              case 8://RATE
                  sUrl = "ESM_PRI_0057_06.do"; 
                  break;
              case 9://SPECIAL NOTE
                  sUrl = "ESM_PRI_0057_12.do"; 
                  break;
              case 10://AFFIL
                  sUrl ="ESM_PRI_0057_09.do"; 
                  break;
              case 11://L AGENT
                  sUrl = "ESM_PRI_0057_10.do"; 
                  break;
              case 12://IHC
              	sUrl = "ESM_PRI_0057_15.do"; 
                  break;
              case 13://GOH
              	sUrl = "ESM_PRI_0057_08.do";                
                  break;
              case 14://BOILER
                  sUrl = "ESM_PRI_0057_13.do";                   
                  break;
              }   
              objTabWindow.location.href = sUrl;
              return true;
          }
          var sheetObj = sheetObjects[0];
          var formObj = document.form;          
          var sRow = sheetObj.SelectRow;
          var sPropNo = formObj.prop_no.value;
          var sAmdtSeq = sheetObj.CellValue(sRow, "amdt_seq");          
          var sSvcScpCd = sheetObj.CellValue(sRow, "svc_scp_cd");
          var sConChk	= "0";
          var sLgcyIfFlg = sheetObj.CellValue(sRow, "lgcy_if_flg");
          if (formObj.con_flg.checked == true){
        	  sConChk = "1";
          }
          if (sAmdtSeq =="0") {
        	  if (tabIndex != 8 && tabIndex != 9){
        		  sAmdtSeq = -1;
        	  }
          }
  
		if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null ) {		
			for (var i = 0; i < 500;i++){
				var sts = document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.loadFinishCheck();
				if (sts == true) break;
			}       	  	
			if (sts){
				document.getElementById("t" + (ComParseInt(tabIndex) + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg);	
				if (tabIndex == 0){
					termLoad = true;
				}
			}				
		}        

      }
      
      /**
       * Tab에 로드된 모든 Sheet의 데이터를 Clear한다.  <br>
       * <br><b>Example :</b>
       * <pre>
       *     clearAllTabPages()
       * </pre>
       * @param  없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */          
      function clearAllTabPages() {
    	  for (var i = 0; i < tabObjects[0].GetCount(); i++) {
    		  if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                  document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
              }
          }
      }
      
      /**
       * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     clearAllForms()
       * </pre>
       * @param  없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */            
      function clearAllForms(){          
          var formObj = document.form;
          
          formObj.prop_no.value = "";
          formObj.amdt_seq.value = "";
          formObj.ctrt_eff_dt.value = "";
          formObj.ctrt_exp_dt.value = "";
          comboObjects[0].Index = -1;
          formObj.ctrt_pty_nm.value = "";
          comboObjects[1].Index = -1;   
          formObj.con_flg.checked = false;
          formObj.lgcy_if_flg.value = "";
      }      
      
      /**
      * 조회시 모든 Tab을 활성/ 비활성화 한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     searchInitSheet(true)
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */       
      function searchInitSheet(sw){
    	  if (!sw) tabObjects[0].SelectedIndex = 0 ;
    	  for (var i = 0; i < tabObjects[0].GetCount(); i++){
    		  setTabEnable(i, sw)
    	  }
      }
      
      
      /**
       * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
       * 콤보의 text로 Scope Name을 표시한다.<br> 
       * <br><b>Example :</b>
       * <pre>
       *    ssvc_scp_cd_OnChange(comboObj, code, text);
       * </pre>
       * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
       * @param   {string} code 필수 코드
       * @param   {string} text 필수 화면에 표시된 문자 
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */       
  	function svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
			selectedGlineSeq = null;
		}
	}
	
    /**
    * IBMulti Combo에서 KeyBoard를 눌렀을 때 발생하는 이벤트이다.<br>
    * 지정된 길이가 넘어가면 focus()를 다음 Object로 넘긴다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */    	
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt = comboObj.Text;

		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
	
    /**
    * IBMulti Combo에서 모든 Item이 삭제 되었을 경우 발생하는 이벤트이다.<br>
    * Scope 의 Name 의 값을 Clear한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnClear(comboObj);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index = -1;
	}
	
    /**
    * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
    * Combo의 text값을 Html Object에 표시한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    ssvc_scp_cd_OnBlur(comboObj);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form;		
		var code = comboObj.FindIndex(comboObj.Code, 0);		
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
			}
		}
		if (code == -1){
			formObj.svc_scp_nm.value = "";
		}
	}
	
	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * 선택한 Scope에 해당하는 Terms의 데이터를 Frame에 Load 하고 Tab의 아이콘을 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
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
    	 try{
    		 ComOpenWait(true); //->waiting->start
    		 setAllTabEnable(true);    		 
	         	 
         	if(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")!= "0" && sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")!= ""){
            	ComBtnEnable("btn_print");
         	}else{
         		ComBtnDisable("btn_print");
         	}
         	
    		 tabObjects[0].SelectBackColor = TAB_SELECT_COLOR;
    		 var tabIdx = 0;
        	 var colName = sheetObj.ColSaveName(NewCol);

        	 if(OldRow != NewRow || beforeChk != getConversionValue() ){
        		var svcScpCd = ""
        		if (sheetObj.CellValue(NewRow,"svc_scp_cd") !=""){
        			svcScpCd =sheetObj.CellValue(NewRow,"svc_scp_cd");
        		}   

        		tabIdx = comApplyStyleProposalStatusSummary(svcScpCd,sheetObj.CellValue(NewRow,"amdt_seq"))
        	
        		if (comboObjects[1].Text !=""){
        			tabIdx = getTermTypeToTabIndex(comboObjects[1].Code)
        		}

        		tabObjects[0].SelectedIndex = tabIdx;

        		tab1_OnChange(tabObjects[0], tabIdx);	

             }

        	 beforeChk = getConversionValue();    

         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
         	setAllTabEnable(false);

         }
         
    }	
    
     
     /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
      * Conversion Update를 수행한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *		
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int}     Button   필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
      * @param {int}     Shift    필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
      * @param {int}     X        필수 X 좌표
      * @param {int}     Y        필수 Y 좌표
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */   	
     function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y)  {   
     	var tabIdx = 0;
        var Row = sheetObj.MouseRow;
        var Col = sheetObj.MouseCol;
     	var colName = sheetObj.ColSaveName(Col);
     	var formObj = document.form;
        var conAuth = false;
        var ofcAuthYn = formObj.ofc_auth_yn.value;
        var reqUsrFlg = formObj.req_usr_flg.value;
        //conversion 권한
        //if (   formObj.in_usr_ofc_cd.value == "PKGSA" || formObj.in_usr_ofc_cd.value == "SELCMQ" ){
//        if (   formObj.in_usr_ofc_cd.value == "PHXSA"|| formObj.in_usr_ofc_cd.value == "NYCRA" || formObj.in_usr_ofc_cd.value == "SELCMA" ){
//        	conAuth = true;
//        }
        if(    ofcAuthYn == "Y" || reqUsrFlg == "Y"  ){ //작성자 )
            conAuth = true;
        }
      	if (colName == "conv_cfm_flg" 
      				&& ( sheetObj.CellValue(Row, "pre_conv_cfm_flg")=="Y" || sheetObj.CellValue(Row, "amdt_seq")=="0" )
      				&& sheetObj.CellValue(Row,Col)=="0" 
      				&& sheetObj.CellValue(Row, "svc_scp_cd") ==""
      				&& conAuth	){
             if (!ComShowCodeConfirm("PRI01118")){
             	return false;
             }        
             var propNo = sheetObj.CellValue(Row, "prop_no");
             var amdtSeq = sheetObj.CellValue(Row, "amdt_seq");
//             sheetObj.CellValue(Row, "ibflag") = "U";
             sheetObj.RowStatus(Row) = "U";
             doConversionUpdate(propNo,amdtSeq,Row,Col);             
     	} 
     }	     
      
    


    /**
    * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 해당 Tab의 아이콘을 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
    * </pre>
    * @param   {string} svcScpCd 선택   Scope 코드
    * @return {int} 데이터가 있는 tab index 중 첫번째
    * @author 공백진
    * @version 2009.04.17
    */    
    function comApplyStyleProposalStatusSummary(svcScpCd,amdtSeq){

       	var formObj = document.form;
        formObj.f_cmd.value = SEARCH04;
        var lgcyIfFlg = sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "lgcy_if_flg");
        var sParam = "prop_no="+formObj.prop_no.value+"&amdt_seq="+amdtSeq
        			+"&svc_scp_cd="+svcScpCd+"&f_cmd="+SEARCH04
        			+"&term_type_cd="+formObj.term_type_cd.Code
        			+"&lgcy_if_flg="+lgcyIfFlg+"&conv_flg="+getConversionValue();
//        alert(sParam);
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0057GS.do", sParam);
        var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|amdt_flg|dat_flg");

        var tabIdx = "";
        var conValue = getConversionValue();
        
        var rValue = 0;
        var enableIdx = new Array();
        var j = 0;
        for (var i = 0; arrText != null && i < arrText.length; i++){
//        	alert(i+"==>"+arrText[i][0]+"  "+arrText[i][1]+"  "+arrText[i][2]);
           	 switch(arrText[i][0]){
   		     	 case '01':  //Duration,Scope Duration
   		     	 	 tabIdx = 0;
   		             break;
//   		         case '11':  //Scope  DURATION
//   		             tabIdx = 0;
//   		             break;			             
   		         case '02':  //MQC,Scope MQC
   		         	 tabIdx = 1;
   		             break;  
//   		         case '12':  //Scope MQC
//   		             tabIdx = 1;                 
//   		             break;					             
   		         case '07':  //Customer Type
   		         	 tabIdx = 2;
   		         	if (svcScpCd !="") arrText[i][1] = "0";
   		             break;  		             
   		         case '04':  //Contract Party
   		         	 tabIdx = 3;
   		         	 if (svcScpCd !="") arrText[i][1] = "0";
   		             break;      
   		         case '41':  //Origin//Destination
   		             tabIdx = 4;
   		         	if (svcScpCd == "") arrText[i][1] = "0";
   		             break;			             
   		         case '13':  //Group Location
   		             tabIdx = 5;
   		         	if (svcScpCd == "") arrText[i][1] = "0";
   		             break;		             
   		         case '14':  //Group Commodity
   		             tabIdx = 6;          
   		         	if (svcScpCd == "") arrText[i][1] = "0";
   		             break;	
   		         case '51':  //Origin Arbitrary Destination Arbitrary 
   		             tabIdx = 7;
   		         	if (svcScpCd == "") arrText[i][1] = "0";
   		             break;				        	 
   		         case '71':  //General,Special  Rate                  
   		         	tabIdx = 8;
   		         	if (svcScpCd == ""){
   		         		arrText[i][1] = "0";
   		         		tabDataExist[0] = arrText[i][1];
   		         	}else{
   		         		if (conValue == "1") {
   		         			arrText[i][1] = "1";
   		         			tabDataExist[0] = arrText[i][1];
   		         		}else{
   		         			if (amdtSeq =="0") arrText[i][1] = "0";
   		         			tabDataExist[0] = arrText[i][1];
   		         		}
   		         	}	
   		             break;  	
   		         case '32':  //Special Note
   		             tabIdx = 9;
   		         	if (svcScpCd == "") {
   		         		arrText[i][1] = 0;
   		         		tabDataExist[1] = arrText[i][1];
   		         	}else{
   		         		if (conValue == "1") {
   		         			arrText[i][1] = arrText[i][2]
   		         			tabDataExist[1] = arrText[i][1];
   		         		}else{
   		         			if (amdtSeq =="0") arrText[i][1] = "0";
   		         			tabDataExist[1] = arrText[i][1];
   		         		}	   		         	
   		         	}		   
   		             break;
   		         case '05':	//Affiliate
   		        	 tabIdx = 10;
   		         	if (svcScpCd !="") arrText[i][1] = "0";
   		        	 break;   	
   		         case '15':  //Loading Agent
   		             tabIdx = 11;   		      
   		         	if (svcScpCd == "") arrText[i][1] = "0";
   		             break;	
   		         case '61':  //Origin,Destination IHC
   		             tabIdx = 12;
   		         	 if (svcScpCd == "") arrText[i][1] = "0";
   		             break;			             
   		         case '16':  //GOH Charge
   		             tabIdx = 13;
   		         	 if (svcScpCd == "") arrText[i][1] = "0";
   		             break; 
   		     	 case '06':  //Boiler plate
   		     	 	if (svcScpCd !="") arrText[i][1] = "0";
   		     	 	 tabIdx = 14;
   		             break;	 
  		          default : 
   		        	  continue;
           	 	}
           	 
           	 if (amdtSeq =="0" && tabIdx != 9 && tabIdx != 8) {
           		 arrText[i][1] = "0";
           	 }

           	 if (arrText[i][1] =="1"){        
           		 enableIdx[j++] = tabIdx;
           		 tabEnableFlg[tabIdx] = true;
           	 }else{
           		 tabEnableFlg[tabIdx] = false;
           	 }
        }        
        
        if (enableIdx != null && enableIdx.length > 0){
       	 	rValue = enableIdx[0];
        }
        for (var i = 0; i < enableIdx.length;i++){
           	 if (rValue >= enableIdx[i]){
           		 rValue = enableIdx[i];
           	 }
        }
        return rValue;
    }
     
     
    /**
    * Tab의 COLOR를  활성 비활성화 COLOR로 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    setTabEnable(idx, sw);
    * </pre>
    * @param   {int} idx 필수  tab의 index
    * @param   {bool} sw 필수  true : 활성  false : 비활성
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
     function setTabEnable(idx, sw){
    	 if (sw){
			tabObjects[0].TabBackColor(idx) = TAB_TRUE_COLOR;
    	 }else{
			tabObjects[0].TabBackColor(idx) = TAB_FALSE_COLOR;
    	 }
     }

    

    /**
    * 조회가 모두 끝난 후 Tab의 COLOR를  활성 비활성화 COLOR로 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    setAllTabEnable();
    * </pre>
    * @param  {boolean} noData : true - 모든 tab비활성
    *                            false -조건에 따라 tab 활성/비활성 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
//     function setAllTabEnable(){
//    	var firstTabFlg = false;
//    	var selectTab = 0;
//    	for (var i = 0; i < tabObjects[0].GetCount(); i++){
//    		 tabObjects[0].TabEnable(i) = tabEnableFlg[i];
//    		 if (!firstTabFlg && tabEnableFlg[i]){
//    			 selectTab = i;
//    			 firstTabFlg = true;
//    		 }
//    	}
//    	tabObjects[0].SelectedIndex = selectTab;
//     }    
    function setAllTabEnable(noData){
    	if (noData){
          	for (var i = 0; i < tabObjects[0].GetCount(); i++){
          		tabEnableFlg[i] = false;
          		 if (tabEnableFlg[i]){
         			 tabObjects[0].TabBackColor(i) = TAB_TRUE_COLOR;
         		 }else{
         			tabObjects[0].TabBackColor(i) = TAB_FALSE_COLOR;
         		 }
         	}
          	tabObjects[0].SelectedIndex = 0; 
    	}else{
        	var firstTabFlg = false;
          	var selectTab = 0;
          	for (var i = 0; i < tabObjects[0].GetCount(); i++){
          		 if (tabEnableFlg[i]){
          			 tabObjects[0].TabBackColor(i) = TAB_TRUE_COLOR;
          		 }else{
          			tabObjects[0].TabBackColor(i) = TAB_FALSE_COLOR;
          		 }
          		 if (!firstTabFlg && tabEnableFlg[i]){
          			 selectTab = i;
          			 firstTabFlg = true;
          		 }
          	}
          	tabObjects[0].SelectedIndex = selectTab;   
    	}
   	
    }         
    
    
    
      /**
       * Conversion Check Box를 선택하면 Rate,Special Note Tab을 활성화 한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *    obj_OnClick();
       * </pre>
       * @param  없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */        
     function obj_OnClick(){
     	var sheetObj = sheetObjects[0];
     	var formObj = document.form;

     	if (event.srcElement.name == "con_flg" ) {     		
     		if (sheetObj.CellValue(sheetObj.SelectRow,"svc_scp_cd")!=""){
         		if (getConversionValue() == "1"){
					setTabEnable(8, true);	//rate
					setTabEnable(9, true);	//special note					
         		}else{
					if (tabDataExist[0] != 1) setTabEnable(8, false);
					if (tabDataExist[1] != 1) setTabEnable(9, false);
         		}
     		}
     		if (getConversionValue() == "1"){
     			sheetObj.ColHidden("conv_cfm_flg") = false;
     		}else{
     			sheetObj.ColHidden("conv_cfm_flg") = true;
     		}     			
     		comboObjects[1].Index = -1;
     		doActionIBSheet(sheetObj,formObj,IBSEARCH);
     	}
     	
     }     
     
     /**
      * Conversion Check Box의 값을 구한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *    getConversionValue();
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */       
    function getConversionValue(){
    	var formObj = document.form;
    	var rValue = "0";
    	if (formObj.con_flg.checked == true){
    		rValue = "1";
    	}
    	return rValue;
    }

    /**
     * Term Type을 선택하였다면 Conversion Check Box를 선택 해제한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    term_type_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */    
    function term_type_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        if (text !=""){
        	formObj.con_flg.checked = false;
        }

    }     

    /**
     * Term Type Combo의 코드로 해당 Term의 Tab Index 를 찾아 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    getTermTypeToTabIndex(code);
     * </pre>
     * @param   {string} code 필수 Term Type 코드
     * @return   string tabIdx Term Type의 Tab Index 
     * @author 공백진
     * @version 2009.04.17
     */      
    function getTermTypeToTabIndex(code){
	   	var tabIdx = 0; 
    	switch(code){
		 	 case '01':  //Duration,Scope Duration
		 	 	 tabIdx = "0";
		         break;
		     case '02':  //MQC,Scope MQC
		     	 tabIdx = "1";
		         break;  
		     case '03':  //Contract Party
		     	 tabIdx = "3";
		         break;  		    
		     case '04':  //Customer Type
		     	 tabIdx = "2";
		         break;				         
		     case '05':	//Affiliate
		    	 tabIdx = "10";
		    	 break;
		 	 case '06':  //Boiler plate
		 	 	 tabIdx = "14";
		         break;
		     case '11':  //ori/dest
		         tabIdx = "4";
		         break;		             
		     case '12':  //Group Location
		         tabIdx = "5";                 
		         break;				        	 
		     case '13': //Group Commodity
		         tabIdx = "6";
		         break;		             
		     case '14':  //Arbitrary 
		         tabIdx = "7";          
		         break;		
		     case '15':  //rate
		         tabIdx = "8";
		         break;			         
		     case '16':  //Special Note
		         tabIdx = "9";
		         break;           
		     case '17':  //loading agent
		         tabIdx = "11";
		         break;
		     case '18':  //ihc
		         tabIdx = "12";
		         break;	
		     case '19':  //goh
		         tabIdx = "13";
		         break;		             
	   	 }    	

	   	 return tabIdx;
    }
    

/**
 * duration의 exp_dt를 리턴한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param 없음
 * @return {string} 
 * @author 최성민
 * @version 2009.05.01
 */
function getCtrtExpDate() {
	var formObj = document.form;
	var ctrtExpDt = formObj.ctrt_exp_dt.value;
	ctrtExpDt = ctrtExpDt.replace(/-/gi, "");
	return ctrtExpDt;
}
 
 /**
  * Conversion을 Update한다. <br>
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param 없음
  * @return {string} 
  * @author 공백진
  * @version 2009.05.01
  */
 function doConversionUpdate(propNo, amdtSeq, Row, Col) {
	  try{
		  ComOpenWait(true); //->waiting->start
		  var sheetObj = sheetObjects[0];	  
		  var sParam = "f_cmd="+MULTI+"&prop_no="+propNo+"&amdt_seq="+amdtSeq;

		  var sXml = sheetObj.GetSaveXml("ESM_PRI_0057GS.do", sParam);
		  sheetObj.LoadSaveXml(sXml);
		  var saveOk = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

	  	  if(saveOk == "S") {	  		
	  		 sheetObj.CellValue(Row, "conv_cfm_flg") = "1"; 
//	  		 sheetObj.CellValue(Row, "ibflag") = "R";	
	  		sheetObj.RowStatus(Row) = "R";
	  		 for (var i = Row ; i >= 1; i--){
	  			 if (sheetObj.CellValue(i, "amdt_seq") == ComParseInt(amdtSeq) + 1 && sheetObj.CellValue(i, "svc_scp_cd")=="" ){
	  				 sheetObj.CellValue(i, "pre_conv_cfm_flg") = "Y";
	  				 break;
	  			 }
	  		 }
		 }		  
      } catch (e) {
        	if (e == "[object Error]") {
              ComShowMessage(OBJECT_ERROR);
          } else {
              ComShowMessage(e);
          }
      }finally{
      	ComOpenWait(false); //->waiting->End
      }

 } 
 
 /**
  * TODO::[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
  * S/C Proposal & Amendment Creation 화면의 PRINT 버튼 사용시 기준으로 동일하게 아래 대상으로 권한 적용(ESM_PRI_0003.js. buttonContro 참고)<br>
  * @param  txt
  * @return {string} <br>
  * @author 최성환
  * @version 2015.06.15
  */ 
	function checkPrintOpenAuthInfo(txt){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var rValue = "N";
	   
		var arrPropNo = txt.split(";");
		var scNo 		= "";
		var propNo 	= "";
		var amdtSeq 	= "";
		for(var i=0 ; i < arrPropNo.length -1 ; i++)
		{
			var arrItem = arrPropNo[i].split(":");
			propNo = arrItem[0];
			scNo = arrItem[1];
			amdtSeq = arrItem[2];

	   
			formObj.f_cmd.value = SEARCH05;
			var sParam 	= "sc_no=" + scNo + "&prop_no=" + propNo + "&amdt_seq="+amdtSeq;
				  sParam   += "&" + FormQueryString(formObj);
			
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0057GS.do", sParam);
			var stsCd 			= ComGetEtcData(sXml, "stsCd");
			var reqUsrFlg 		= ComGetEtcData(sXml, "reqUsrFlg");
			var aproUsrFlg 	= ComGetEtcData(sXml, "aproUsrFlg");
			var allUsrFlg 		= ComGetEtcData(sXml, "allUsrFlg");
	 		var maxPropUsrId = ComGetEtcData(sXml, "maxPropUsrId");
	 		
	 		//요건
	 		//※ 현재 Amd 회차 별 R.OFC 의 S.Rep 코드가 부여된 ID 유저에 해당 Amd 회차에 대해 활성화되고
	 		//   있으나, 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저는 전(全) 회차에 대해 다운로드 할 수 있도록    보완 필요.
	 		//if (로그인 사용자가 = 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저 일 경우) - 전회차 다운로드가능함 
//			alert(stsCd + "||" + formObj.in_usr_id.value + "||"+maxPropUsrId);
			if(formObj.in_usr_id.value == maxPropUsrId){
				rValue = "Y";
				return rValue;
			}
		
			var fileCancelAuth = checkFileCancelUser();
		
//			if (!(stsCd =="F" && ( formObj.in_usr_id.value == FILE_CANCEL_ID  	 || formObj.in_usr_id.value == FILE_CANCEL_ID2 || formObj.in_usr_id.value == FILE_CANCEL_ID3
//							           	 ||formObj.in_usr_id.value == FILE_CANCEL_ID4 || formObj.in_usr_id.value == FILE_CANCEL_ID5 || formObj.in_usr_id.value == FILE_CANCEL_ID6 
//							             ||formObj.in_usr_id.value == FILE_CANCEL_ID7 || formObj.in_usr_id.value == FILE_CANCEL_ID8 || formObj.in_usr_id.value == FILE_CANCEL_ID9
//							             ||formObj.in_usr_id.value == FILE_CANCEL_ID10 ||formObj.in_usr_id.value == FILE_CANCEL_ID11) ))
			if (!(stsCd == "F" && (fileCancelAuth =="Y")))
			{ //Filed이고 허가된 유저이면 로직 적용 안함. 위 로직 변형
		    	  if(reqUsrFlg !="Y" && aproUsrFlg !="Y")
		    	  {
//		    			rValue = "N";   
		    			rValue = "[Proposal No. : "+propNo + "][Amend No. : " + amdtSeq + "]" ;
		    			return rValue;  //권한 없을시 바로 리턴함.
		    	  }
		    }
      
	    	switch(stsCd) {
		      	case 'I':   // Initial              
		      		if(reqUsrFlg=="Y"||aproUsrFlg=="Y"){
		              	rValue = "Y";
		            }
		            break;
		              
		        case 'Q':   // Requested
		          	rValue = "Y";           
		            break;
		              
		        case 'R':   // Returned
		            if (amdt_seq =="0"){
//		    			rValue = "N";   
		    			rValue = "[Proposal No. : "+propNo + "][Amend No. : " + amdtSeq + "]" ;
	                	return rValue;  //권한 없을시 바로 리턴함.
		            }else{ 
		              	rValue = "Y";
		            }
		            break;
		              
		        case 'A':   // Approved
		        	rValue = "Y";           
		        	break;
		              
		        case 'F':   // Filed
		          	rValue = "Y";
		            break;                    
	    	}
			//loop 속에서 한건이라도 권한이 없을 경우 바로 리턴 처리함.
			if(rValue != "Y" ){
				return rValue;  //한건이라도 권한 없을시 바로 리턴함.
			}
		}	
		return rValue;  
	}    
	
	function checkFileCancelUser(){
		   var formObj = document.form;
		   var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH33;                                                                                                                                                                                                                                                                                                                                                                                                        
			sXml = sheetObj.GetSearchXml("PRICommonGS.do",                                                                                                                                                                                                                                                                                                                                                                                   
					FormQueryString(formObj));                                                                                                                                                                                                                                                                                                                                                                        
			var fileCancelAuth = ComGetEtcData(sXml, "fileCancelAuth");      
			return fileCancelAuth;
	   }
    /* 개발자 작업  끝 */

