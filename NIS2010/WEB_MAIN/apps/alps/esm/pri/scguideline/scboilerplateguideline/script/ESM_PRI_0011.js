/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0011.js
*@FileTitle : Boiler Plate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.01 공백진
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
     * @class Standard Note Creation : ESM_PRI_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0011() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var preYear = "";
 var preSeq = "";
 
 //현재 이벤트를 저장
 var eventStatus = "";
 var arrValue = new Array();
 
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
          var sheetObject3 = sheetObjects[2];
           
          /*******************************************************/
          var formObject = document.form;

          try {
       		var srcName = window.event.srcElement.getAttribute("name");

               switch(srcName) {
   				case "btn_retrive":
   					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
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
    	 
         //IBMultiCombo초기화
         for(var k = 0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         } 
         initControl();         
         
         
     }
      
      /**
      * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
      * <br><b>Example :</b>
      * <pre>
      *    
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */      
     function sheet2_OnLoadFinish(sheetObj) {   
    	 doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
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
  		 axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
  		 axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
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

         switch(sheetObj.id) { 
	         case "sheet0":      //hidden 
	             with (sheetObj) {
	            	// Host정보 설정[필수][HostIp, Port, PagePath]
	 				if (location.hostname != "")
	 					InitHostInfo(location.hostname, location.port, page_path);
											
	             }
	             break; 
         
	         case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 280;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(8, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Del Check|Seq.|Title|blpl_hdr_seq|blpl_seq|dp_seq";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck, 		 40, 	daCenter,  false, 		"chk");
                     InitDataProperty(0, cnt++,  dtDelCheck, 		 40, 	daCenter,  false, 		"del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,    			 50,    daCenter,  false,    	"Seq");
                     InitDataProperty(0, cnt++ , dtData,      		 300,	daLeft,	   false,		"blpl_tit_nm",    true,	 "", dfNone, 0,	true,  true);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"blpl_hdr_seq",   false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"blpl_seq", 	  false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"dp_seq", 	      false, "", dfNone, 0, false, false);
                     
                     ColHidden("del_chk") = true;
                     WaitImageVisible = false;
                 }
                 break;
             case "sheet2":      // sheet2 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 160;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

 										// 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(9, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Del Check|Seq.|Contents|blpl_hdr_seq|blpl_seq|blpl_ctnt_seq|dp_seq";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck, 		 40, 	daCenter,  false, 		"chk");
                     InitDataProperty(0, cnt++,  dtDelCheck, 		 40, 	daCenter,  false, 		"del_chk");
                     InitDataProperty(0, cnt++ , dtSeq,    			 50,    daCenter,  false,    	"Seq");
                     InitDataProperty(0, cnt++ , dtData,      		 800,	daLeft,    false,		"blpl_ctnt",      true,	"",	 dfNone, 0,	false, false, 3000);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"blpl_hdr_seq",   false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"blpl_seq", 	  false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"blpl_ctnt_seq",  false, "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"dp_seq", 	      false, "", dfNone, 0, false, false);

                     ColHidden("del_chk") = true;
                     AutoRowHeight = false;
                     WaitImageVisible = false;
 			   	 }
                 break;

         }
     }

     
	
 	
     /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Content를 조회한다. <br>
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
 	 function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {

 		 var formObj = document.form;
 		 
		formObj.blpl_seq.value = sheetObjects[1].CellValue(NewRow, "blpl_seq");
		if(formObj.blpl_seq.value == "undefined" || ComIsEmpty(formObj.blpl_seq.value)) {
			formObj.blpl_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"blpl_seq");
		}

		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
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
	          	case IBSEARCH_ASYNC01:
	          		formObj.f_cmd.value = SEARCH04;
	                 var sParam = FormQueryString(formObj);	      
	                 var sXml = sheetObj.GetSearchXml("ESM_PRI_0011GS.do", sParam);
	                 ComPriXml2ComboItem(sXml, formObj.blpl_ref_yr, "blpl_ref_yr", "blpl_ref_yr");
	          		 break;
	          	case IBSEARCH_ASYNC02:
	          		formObj.f_cmd.value = SEARCH05;
	                 var sParam = FormQueryString(formObj);     
	                 clearControl();
	                 var sXml = sheetObj.GetSearchXml("ESM_PRI_0011GS.do", sParam);
	                 ComPriXml2ComboItem(sXml, formObj.eff_dt, "blpl_hdr_seq", "eff_dt|exp_dt|cfm_flg");                
	     			 arrValue = ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg");
	          		 break;         		
	 	         case IBSEARCH:      //조회
	 	         	ComOpenWait(true); //->waiting->start
	 	         	if ( sheetObj.id == "sheet0") {
	 	        		   if (validateForm(sheetObj,document.form,sAction)) {
	 	        			   removeSearchCondition(formObj);	 	        			   
	 		                    formObj.f_cmd.value = SEARCH01;
	 	            		    var sXml = sheetObj.GetSearchXml("ESM_PRI_0011GS.do", FormQueryString(formObj));	
	 	            		    var arrData = ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
	 		       				if (arrData != null && arrData.length > 0) {
	 		       					formObj.blpl_hdr_seq.value = arrData[0][0];
	 		       					formObj.cfm_flg.value = arrData[0][1];		  
	 		       					formObj.eff_dt.value = arrData[0][2];
	 		       					formObj.exp_dt.value = arrData[0][3];		       					
	 		    				}		            		   
	 					    }	
	 	        	}else if ( sheetObj.id == "sheet1") {
	 	            	   if (validateForm(sheetObj,document.form,sAction)) {	            		   
	 	            		   for (var i = 0; i < sheetObjects.length; i++) {
	 		   					   sheetObjects[i].RemoveAll();
	 		   				   } 
	 						  formObj.f_cmd.value = SEARCH02;
	 						  sheetObj.DoSearch("ESM_PRI_0011GS.do", FormQueryString(formObj));
	        			 	}	  
	 				}else if ( sheetObj.id == "sheet2") {				
	 					   if (validateForm(sheetObj,document.form,sAction)) {			
	 						  formObj.f_cmd.value = SEARCH03;				
	 						  sheetObj.DoSearch("ESM_PRI_0011GS.do", FormQueryString(formObj));				
	 	            	   }
	 				 }	   		 
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
	           	if (sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC02) {
	           		return;
	           	}
	           	ComOpenWait(false); //->waiting->End
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
 	       case "blpl_ref_yr":
	            var i=0;
	            with(comboObj) {
	            	Style = 1;
	            	//BackColor = "cyan";
//	            	UseEdit = false;
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            }
	            break; 	 
 	       case "eff_dt":
	            var i=0;
	            with(comboObj) {
	            	Style = 1;
	            	//BackColor = "cyan";
//	            	UseEdit = false;
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            }
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
      * @return bool <br>
      *          true  : 폼입력값이 유효할 경우<br>
      *          false : 폼입력값이 유효하지 않을 경우
      * @author 공백진
      * @version 2009.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {    	 
	 		case IBSEARCH: // 조회
	 			
 			if (formObj.eff_dt.Code == "") {
 				ComPriInputValueFailed("select","duration",formObj.eff_dt);
	 			return false;
	 		} 

	 		break;
	 	
		}

         return true;
     }


 	
  	/**
      * 조회 조건을 리셋한다.<br>
      * 데이터가 변경된 경우 저장한다.
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {form} formObj 
      * @param {String} gubun    
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */
 	function removeSearchCondition(formObj) {
 		
 		if(eventStatus == "IBCOPY") return;
 	
	 	//년도를 빼고 화면 리셋
 		formObj.eff_dt.value = "";
 		formObj.exp_dt.value = "";

 		formObj.blpl_hdr_seq.value = "";
 		formObj.cfm_flg.value = "";
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
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
	     
     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,903,200);
 	    		
 	    		break;
     	}    	 

    }
     
     /**
      * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
      * Boiler Plate Header Year를 조회합니다.<br>
      * <br><b>Example :</b>
      * <pre>
      *    blpl_ref_yr_OnBlur(comboObj);
      * </pre>
      * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */      
  	function blpl_ref_yr_OnBlur(comboObj) {  		
		var formObj = document.form;

		var code = comboObj.Code;
		if (code != null && code != "" && preYear != formObj.blpl_ref_yr.Code){	
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);				
		}		
		preYear = code;

	}     
  	
  	
	function  blpl_ref_yr_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		if (code == "" || text == "") {
			return;
		}				
		formObj.eff_dt.focus();
	} 
  	
  
    /**
     * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
     * 데이터를 조회합니다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    eff_dt_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 
  	function eff_dt_OnBlur(comboObj) {  		
		var formObj = document.form;
		var code = comboObj.Code;
		if (code != null && code != "" && preSeq != formObj.eff_dt.Code) {			
			formObj.blpl_hdr_seq.value = code							
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);			
		}else{
			formObj.blpl_hdr_seq.value = "";
		}
		preSeq = code;
		if (arrValue != null && arrValue.length > 0){
			for (var i = 0; code !="" && i < arrValue[0].length; i++){
				if (arrValue[i][0] == code){
					formObj.cfm_flg.value = arrValue[i][1];
					break;
				}
			}
		}
		
		formObj.cfm_flg.focus();
	}   	
  	
  	
  	
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    eff_dt_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   	
	function eff_dt_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		if (code == "" || text == "") {
			return;
		}				
		var expText = comboObj.GetText(code, 1);	
		formObj.exp_dt.value = expText;

		formObj.cfm_flg.focus();
	}  	
 	
    /**
    * control의 데이터를 초기화한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    clearContro());
    * </pre>
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   	
	function clearControl(){
		var formObj = document.form;
 		sheetObjects[1].RemoveAll();
 		sheetObjects[2].RemoveAll(); 
		formObj.exp_dt.value = "";
		formObj.cfm_flg.value = "";
	}
    
	/* 개발자 작업  끝 */
 	
 	