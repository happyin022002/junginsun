/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2041.js
*@FileTitle : RFA  Amendment History 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.21 공백진
* 1.0 Creation
=========================================================
* History
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정                                                               
* 2012.02.08 이석준[CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정   
* 2012.06.27 서미진[CHM-201217633] 구주 Hinterland Operation 개선 Project : Rate (For AEE/AEW), Arbitrary (For AEE/AEW) 탭 화면 추가   
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
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
     * @class ESM_PRI_2041 : ESM_PRI_2041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2041() {
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
 var beforetab = 0;
  
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0; 
 //이전 rfa_no 
 var preRfaNo = "";

 var sUrl = "";

 //wait image적용 후 각 tab 별로 tab enable 여부를 가지고 있는 변수
 var tabEnableFlg = new Array();
 
 //tab을 활성,비활성 상태로 보이게 하기위하여 지정하는 tab color
 var TAB_SELECT_COLOR = "131,133,217"; 
 var TAB_TRUE_COLOR = "206,220,246";
 var TAB_FALSE_COLOR = "192,192,192";
 
 // 구주 Hinterland T/F 전환을 위한 기준 EXP_DT
var tabDivCount = 12;
 
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
     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
             switch(srcName) {
             case "btn_retrieve":
     			if (formObj.rfa_no.value ==""){
    				ComShowCodeMessage("PRI02015");
    				formObj.rfa_no.focus();
    				return;
    			}

            	 sheetObj.RemoveAll();
                 doActionIBSheet(sheetObj,formObj,IBSEARCH);

                 break;
             case "btn_new":
            	 formObj.rfa_no.value = "";
            	 clearAllForms();
            	 sheetObj.RemoveAll();
            	 comboObjects[0].RemoveAll();
            	 clearAllTabPages();
            	 formObj.rfa_no.focus();
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
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
         
         //ESM_PRI_2043 에서 메인 pop => 김대호 2009-10-06 : jsp 에도  파라미터 받고 박아주는것 추가합니다.
    	 var form = document.form;
         if("null" != form.rfa_no_2043.value && null != form.rfa_no_2043.value && "" != form.rfa_no_2043.value) {
         	form.rfa_no.value = form.rfa_no_2043.value;
         	form.rfa_no.focus();
         	form.amdt_seq.focus();
         }
         form.rfa_no.focus();
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
    	  axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    	  axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
    	  axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               

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
                 if (event.srcElement.name == "rfa_no" ) {
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
             case "rfa_no":
            	 if (formObj.rfa_no.value !="" ){
            		 if (preRfaNo != formObj.rfa_no.value){
            			 preRfaNo = formObj.rfa_no.value;
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);	
            			 doActionIBSheet(sheetObj,formObj,IBSEARCH);            			 
            		 }            		 
            	 }else{
            		 formObj.prop_no.value = "";
            		 formObj.amdt_seq.value = "";
            		 formObj.ctrt_pty_nm.value = "";
            		 formObj.ctrt_eff_dt.value = "";
            		 formObj.ctrt_exp_dt.value = "";
            		 formObj.rfa_ctrt_tp_cd.value = "";
            	 }
            	 
                 break;                       
             default:            	
            	 ComChkObjValid(event.srcElement);       
         }
         preRfaNo = formObj.rfa_no.value;
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
	  				var param = FormQueryString(formObj);
	  			 	var sXml = sheetObj.GetSearchXml("ESM_PRI_2041GS.do" , param);
	  			 	clearAllForms();
	  			 	comboObjects[0].RemoveAll();
	  				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm"); 				
	  				comboObjects[0].InsertItem(0, "||", "X");
	  				comboObjects[0].Code = "X";
	  				
	 				if (ComGetEtcData(sXml,"prop_no") != undefined){
	 					formObj.prop_no.value =  ComGetEtcData(sXml,"prop_no");
	 				}else{
	 			 		formObj.rfa_no.value = "";
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
	 				if (ComGetEtcData(sXml,"rfa_ctrt_tp_cd") != undefined){
	 					formObj.rfa_ctrt_tp_cd.value =  ComGetEtcData(sXml,"rfa_ctrt_tp_cd");
	 				}
	 				ComOpenWait(false); //->waiting->End
	                break;
	                
	  			case IBSEARCH:      //조회
	  				ComOpenWait(true); //->waiting->start
	 				formObj.f_cmd.value = SEARCH02;
	  				clearAllTabPages();
	 				var param = FormQueryString(formObj);
	 			 	var sXml = sheetObj.GetSearchXml("ESM_PRI_2041GS.do" , param);
	 			 	sheetObj.LoadSearchXml(sXml);	
	 			 	ComOpenWait(false); //->waiting->End
	 			 	setTabText();
					tab1_OnChange(tabObjects[0], beforetab);
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

 					var HeadTitle1 = "|Seq.|AMD No.|SVC Scope|Effective Date|Expiry Date|Creation Date|Approve Date";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                    
                     InitDataProperty(0, cnt++, dtHiddenStatus, 40,  daCenter, true,  "ibflag");
                     InitDataProperty(0, cnt++, dtDataSeq,		70,  daCenter, true,  "seq");
                     InitDataProperty(0, cnt++, dtData,		    120, daCenter, true,  "amdt_seq",   false, "", dfNone,	  0, false, false,	3);
                     InitDataProperty(0, cnt++, dtData,		    140, daCenter, false, "svc_scp_cd", false, "", dfDateYmd, 0, false, false,	3);
 					 InitDataProperty(0, cnt++, dtData,		    150, daCenter, false, "eff_dt",	    false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    150, daCenter, false, "exp_dt",	    false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    150, daCenter, false, "cre_dt",	    false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,		    150, daCenter, false, "apro_dt",	false, "", dfDateYmd, 0, false, false);
 					 CountPosition = 0;		// Total 없음.
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
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Duration", -1);
				InsertTab(cnt++, "Affiliate", -1);
				InsertTab(cnt++, "Dem/Det", -1);
				InsertTab(cnt++, "Rate", -1);
				InsertTab(cnt++, "Location Group", -1);
				InsertTab(cnt++, "Commodity Group", -1);
				InsertTab(cnt++, "Arbitrary", -1);
				InsertTab(cnt++, "Special Note", -1);
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
		if (beforetab != tabIndex || tabIndex == 0) {
			var toIndex = getFrameTabId(tabIndex);
			for ( var i = 1; i <= tabDivCount; i++) {
				document.getElementById("tabLayer" + i).style.display = 'none';
			}
			document.getElementById(toIndex.divIndex).style.display = 'inline';
		}
		beforetab = tabIndex;
		loadTabPage(tabIndex);		
	}
	
	/**
	 * 2012.09.20일 추가 Tab에 따른 Tab Lay 밑 URL 설정
	 * 
	 * @param tabIndex
	 */
	function getFrameTabId(tabIndex) {
		var frameId = "";
		var sUrl = "";
		var divIndex = "";
		switch (tabIndex) {
			case 0: {
				frameId = "t1frame";
				sUrl = "ESM_PRI_2041_01.do";
				divIndex = "tabLayer1";
				break;
			}
			case 1: {
				frameId = "t2frame";
				sUrl = "ESM_PRI_2041_07.do";
				divIndex = "tabLayer2";
				break;
			}
			case 2: {
				frameId = "t3frame";
				sUrl = "ESM_PRI_2041_09.do";
				divIndex = "tabLayer3";
				break;
			}
			case 3: {
				var index = checkArbiRate();
				if (index == 0) {
					frameId = "t4frame";
					sUrl = "ESM_PRI_2041_05.do";
					divIndex = "tabLayer4";
				} else if (index == 1) {
					frameId = "t5frame";
					sUrl = "ESM_PRI_2041_10.do";
					divIndex = "tabLayer5";
				} else if (index == 2) {
					frameId = "t11frame";
					sUrl = "ESM_PRI_2041_13.do";
					divIndex = "tabLayer11";
				}
				break;
			}
			case 4: {
				frameId = "t6frame";
				sUrl = "ESM_PRI_2041_04.do";
				divIndex = "tabLayer6";
				break;
			}
			case 5: {
				frameId = "t7frame";
				sUrl = "ESM_PRI_2041_03.do";
				divIndex = "tabLayer7";
				break;
			}
			case 6: {
				var index = checkArbiRate();
				if (index == 0) {
					frameId = "t8frame";
					sUrl = "ESM_PRI_2041_06.do";
					divIndex = "tabLayer8";
				} else if (index == 1) {
					frameId = "t9frame";
					sUrl = "ESM_PRI_2041_11.do";
					divIndex = "tabLayer9";
				} else if (index == 2) {
					frameId = "t12frame";
					sUrl = "ESM_PRI_2041_12.do";
					divIndex = "tabLayer12";
				}
				break;
			}
			case 7: {
				frameId = "t10frame";
				sUrl = "ESM_PRI_2019_01.do";
				divIndex = "tabLayer10";
				break;
			}
		}
		var obj = new Object({
			'frame' : frameId,
			'url' : sUrl,
			'divIndex' : divIndex
		});
		return obj;
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
	function tab1_OnClick(tabObj, tabIndex) {
		if (!tabEnableFlg[tabIndex]) {
			tabObj.SelectedIndex = beforetab;
		}
	}
	
	/**
	 * Tab변경시 화면을 Frame에 로드한다. <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * loadTabPage(tabIndex)
	 * </pre>
	 * 
	 * @param {tabIndex} tabIndex 필수 tab의 일련번호
	 * @return 없음
	 * @author 공백진
	 * @version 2009.04.17
	 */
	function loadTabPage(tabIndex) {
		if (tabIndex == null || tabIndex == "") {
			tabIndex = tabObjects[0].SelectedIndex;
		}
		var obj = getFrameTabId(tabIndex);
		var objTabWindow = document.getElementById(obj.frame).contentWindow;
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			objTabWindow.location.href = obj.url;
			return true;
		}
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var sRow = sheetObj.SelectRow;
		var sPropNo = formObj.prop_no.value;
		var sAmdtSeq = sheetObj.CellValue(sRow, "amdt_seq");
		var sSvcScpCd = sheetObj.CellValue(sRow, "svc_scp_cd");
		// AMDT_SEQ 가 0일 경우는 데이터를 조회하지 않는다.
		if (sAmdtSeq == "0") {
			sAmdtSeq = -1;
		}
	
		if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null) {
			for ( var i = 0; i < 500; i++) {
				var sts = document.getElementById(obj.frame).contentWindow.loadFinishCheck();
				if (sts == true)
					break;
			}
			if (sts) {
				document.getElementById(obj.frame).contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);
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
		for ( var i = 1; i <= tabDivCount; i++) {
			if (document.getElementById("t" + i + "frame").contentWindow.tabClearSheet) {
				document.getElementById("t" + i + "frame").contentWindow.tabClearSheet();
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
          preRfaNo = "";
          formObj.rfa_ctrt_tp_cd.value = "";
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
    	var tabIdx = 0;   	
    	try{
    		ComOpenWait(true); //->waiting->start
    		tabObjects[0].SelectBackColor = TAB_SELECT_COLOR;
    		if(OldRow != NewRow  ){
        		tabIdx = comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow,"svc_scp_cd"),sheetObj.CellValue(NewRow,"amdt_seq")) 
        		if (comboObjects[1].Text !=""){
        			tabIdx = getTermTypeToTabIndex(comboObjects[1].Code)
        		}   	
        		tabObjects[0].SelectedIndex = tabIdx;
        		setTabText();
        		tab1_OnChange(tabObjects[0], tabIdx);	
            }    	
    		ComOpenWait(false); //->waiting->End
        } catch (e) {
           	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
         	ComOpenWait(false); //->waiting->End
         	//setAllTabEnable();
        }
    }	
    
    /**
    * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 해당 Tab의 아이콘을 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
    * </pre>
    * @param   {string} svcScpCd 선택   Scope 코드
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 
	function comApplyStyleProposalStatusSummary(svcScpCd, amdtSeq) {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH04;
		var sParam = "prop_no=" + formObj.prop_no.value + "&amdt_seq=" + amdtSeq + "&svc_scp_cd=" + svcScpCd + "&f_cmd=" + SEARCH04 + "&term_type_cd=" + formObj.term_type_cd.Code;
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2041GS.do", sParam);
		var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|amdt_flg|dat_flg");
		var tabIdx = 0;
		var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
		var rValue = 0;
		var enableIdx = new Array();
		var j = 0;
		for ( var i = 0; arrText != null && i < arrText.length; i++) {
			switch (arrText[i][0]) {
				case '01': // Duration
					tabIdx = 0;
					break;
				case '05': // Affiliate
					tabIdx = 1;
					if (svcScpCd != "")
						arrText[i][1] = "0";
					break;
				case '08': // Dem/Det
					tabIdx = 2;
					if (svcScpCd != "")
						arrText[i][1] = "0";
					break;
				case '71': // Rate of Port (CY) only
					tabIdx = 3;
					if (svcScpCd == "")
						arrText[i][1] = "0";
					break;
				case '13': // Group Location
					tabIdx = 4;
					if (svcScpCd == "")
						arrText[i][1] = "0";
					break;
				case '14': // Group Commodity
					tabIdx = 5;
					if (svcScpCd == "")
						arrText[i][1] = "0";
					break;
				case '51': // Origin Arbitrary Destination Arbitrary
					tabIdx = 6;
					if (svcScpCd == "")
						arrText[i][1] = "0";
					break;
				case '32': // Special Note
					tabIdx = 7;
					if (svcScpCd == "")
						arrText[i][1] = "0";
					break;
			}
			if (amdtSeq == "0") {
				arrText[i][1] = "0";
			}
			if (arrText[i][1] == "1") {
				enableIdx[j++] = tabIdx;
				tabEnableFlg[tabIdx] = true;
			} else {
				tabEnableFlg[tabIdx] = false;
			}
		}
		if (enableIdx != null && enableIdx.length > 0) {
			rValue = enableIdx[0];
		}
		for ( var i = 0; i < enableIdx.length; i++) {
			if (rValue >= enableIdx[i]) {
				rValue = enableIdx[i];
			}
		}
		return rValue;
	}
     
     
    /**
     * Tab을 활성 비활성화 한다.<br>
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
    	 tabEnableFlg[idx] = sw;			
     }     

     /**
      * 조회가 모두 끝난 후 Tab의 색상을 활성 비활성화 색으로 변경한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *    setAllTabEnable();
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */      
	function setAllTabEnable(){
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
      
    
/**
 * Term Type Combo의 코드로 해당 Term의 Tab Index 를 찾아 반환한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * getTermTypeToTabIndex(code);
 * </pre>
 * 
 * @param {string} code 필수 Term Type 코드
 * @return string tabIdx Term Type의 Tab Index
 * @author 공백진
 * @version 2009.04.17
 */
function getTermTypeToTabIndex(code) {
	var tabIdx = 0;
	switch (code) {
	case '01': // Duration,Scope Duration
		tabIdx = 0;
		break;
	case '05': // Affiliate
		tabIdx = 1;
		break;
	case '07': // dem/det
		tabIdx = 2;
		break;
	case '15': // rate
		tabIdx = 3;
		break;
	case '12': // Group Location
		tabIdx = 4;
		break;
	case '13': // Group Commodity
		tabIdx = 5;
		break;
	case '14': // Arbitrary
		tabIdx = 6;
		break;
	case '16': // Special Note
		tabIdx = 7;
		break;
	}
	return tabIdx;
}
    
	
	/**
	 * Hinterland 관련<BR>
	 * Scope에 따라 적절한 Arbitrary, Rate Tab을 활성화한다.<BR>
	 * <br><b>Example :</b>
	 * <pre>
	 * 	getTabIndex(tabInfo, tabName)
	 * </pre>
	 * @param {String} tabInfo Tab Information
	 * @param {String} tabName Tab header name want to find.
	 * @return Number tab index.
	 * @author Hyuk Ryu
	 * @version 2012.05.08
	 */
	function getTabIndex(tabInfo, tabName){
		var index = -1;
		var tabs = tabInfo.split("|");
		for(var i=0; i<tabs.length; i++){
			if(tabName == tabs[i].split(",")[1]){
				index = i;
				break;
			}
		}
		return index;
	}
      
	/**
	 * Tab Text변경
	 */
	function setTabText() {
		var index = checkArbiRate();
		if (index == 0 || index == 2) {
			tabObjects[0].TabText(3) = "Rate";
			tabObjects[0].TabText(6) = "Arbitrary";
		} else if (index == 1) {
			tabObjects[0].TabText(3) = "Rate For AEE/AEW";
			tabObjects[0].TabText(6) = "Arbitrary For AEE/AEW";
		}
	}
	
	 /**
	 * Hinterland Project에 따른 Arbitrary/Rate 구분
	 */
	function checkArbiRate() {
		var formObj = document.form;
		var rsltIndex = 0;
		var svcScpCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd");
		var expDt = ComGetUnMaskedValue(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eff_dt"), "ymd");
		if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
			rsltIndex = 0;
		} else {		
		 	if (addOnEndExpDt > expDt  && expDt > endExpDt && ("AEW" == svcScpCd || "AEE" == svcScpCd)) {
				rsltIndex = 1;
			} else if(addOnEndExpDt <= expDt) {
				rsltIndex = 2;
			} else {
				rsltIndex = 0;
			}
		}
		return rsltIndex;
	}
    /* 개발자 작업  끝 */