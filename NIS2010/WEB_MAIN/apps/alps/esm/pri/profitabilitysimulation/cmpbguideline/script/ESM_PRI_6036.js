/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6036.js
*@FileTitle : CMPB Guideline Copy 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.09 이승준
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_pri_6036() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    var isCopyed = true;
    
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;
	
	 /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_OK":
 					//if(!doActionIBSheet(sheetObjects[0],formObject,IBSAVE)) return;
 					
 					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
 					
 					var cre_ofc_cd = formObject.cre_ofc_cd.value;
 					var eff_dt 	   = formObject.eff_dt.value;
 					var exp_dt	   = formObject.exp_dt.value;

 					dialogArguments.searchCopy(cre_ofc_cd,eff_dt,exp_dt,getPrsCustTpCd(),isCopyed);
 					window.close();
 				break; 

 				case "btn_Close":
 					window.close();
 				break; 
 							
 				case "btns_calendar": //달력버튼
   	    			var cal = new ComCalendarFromTo();
   	                cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
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
      * @author 이승준
      * @version 2009.04.17
      */
     function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

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
      * @author 이승준
      * @version 2009.04.17
      */      
     function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
  	 }
     
     
     /**
      * IBSHEET COMBO를 LOAD하는 함수<br>
      * <br><b>Example :</b>
      * <pre>
      * 		initCombo(comboObj, comboNo)
      * </pre>
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */ 
   	function initCombo(comboObj, comboNo) {
  	    switch(comboObj.id) {

  	    	case "prs_cust_tp_cd":
 	            var i=0;
 	            with(comboObj) {
 	            	DropHeight = 260;
 	            	MultiSelect = false;
// 	            	MaxSelect = 1;
 	            	UseAutoComplete = true;
 	            	ValidChar(2, 0);
 	            }
 	            break;     
  	            
  	    }
  	}
  
   	/**
     * comboObjects[2]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrsCustTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrsCustTpCd() {
   		return comboObjects[0].Code;
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
      * @author 이승준
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
    	 
    	 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 		 axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    	 
 		 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
 		 
    	 var formObj = document.form;
    	 formObj.prs_cust_tp_cd.focus();

     }
     
     /**
      * OnActivate event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_activate()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
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
      * @author 이승준
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
      * @author 이승준
      * @version 2009.04.17
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         var sheetID = sheetObj.id;
	     switch(sheetID) {
	    
	         case "sheet0":      //hidden 
	        	 with (sheetObj) {
                     // 높이 설정
                     style.height = 165;
                     //전체 너비 설정
                     SheetWidth = 200;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|svc_scp_cd|cre_ofc_cd|prc_cust_tp_cd";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   	"ibflag");
                     InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"svc_scp_cd", 		false, "", dfNone, 0, false, false);
 	                 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"cre_ofc_cd", 		false, "", dfNone, 0, false, false);
 	                 InitDataProperty(0, cnt++,  dtHidden, 			 90, 	daLeft,    false, 		"prc_cust_tp_cd", 	false, "", dfNone, 0, false, false);
                     		
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
      * @author 이승준
      * @version 2009.04.17
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         
         	case IBCLEAR: 
	        	
	 			// 화면 로딩시customer type 조회
				formObj.f_cmd.value = SEARCH20;
				formObj.cd.value="CD02085";
				
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, formObj.prs_cust_tp_cd, "cd", "nm");
				//formObj.prc_cust_tp_cd.InsertItem(0,'','|');
				
				//code가 BOTH 인 경우  삭제 후   Text를 ""로 세팅
				var itemindex = formObj.prs_cust_tp_cd.FindIndex("ALL",0);
				
				if(itemindex != "-1") {
					formObj.prs_cust_tp_cd.DeleteItem(itemindex); 
					formObj.prs_cust_tp_cd.InsertItem(0,'','M');
				}
				
				formObj.prs_cust_tp_cd.Code = formObj.prs_cust_tp_cd_before.value;
				
	            break;	
 					
	         case IBSAVE:        //COPY
				 if (validateForm(sheetObj,document.form,sAction)) {
					if (ComShowCodeConfirm('PRI00012')) {
						
						try {
							sheetObjects[0].WaitImageVisible = false;
							ComOpenWait(true);
						
							formObj.f_cmd.value = MULTI01;
							
							var sParam = FormQueryString(formObj);
							
							var sXml = sheetObj.GetSaveXml("ESM_PRI_6036GS.do", sParam);
							sheetObjects[0].LoadSaveXml(sXml);
							
							ComOpenWait(false);
							
						} catch (e) {
						    if (e == "[object Error]") {
						        ComShowMessage(OBJECT_ERROR);
						    } else {
						        ComShowMessage(e);
						    }
						} finally {
						   ComOpenWait(false);
						}	
						
						if(isCopyed) {
							ComPriSaveCompleted();
						}
						
					 }	
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
      * @author 이승준
      * @version 2009.04.17
      */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
    	 
	     	case IBSAVE: 		// COPY
	     		
	     		if (ComIsEmpty(formObj.eff_dt.value)) {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
	 				return false;
				}
	 			if (ComIsEmpty(formObj.exp_dt.value)) {
	 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
	 			
	 			if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
	 			
				return true;
	 			break;	
		 }
	    	
         return true;
     }
	
     
     /**
      * 카피 후 에러에 따라 전역변수에 결과를 세팅함 <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {sheetObj} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg 필수 html form object
      * @return bool <br>
      * @author 없음
      * @version 2009.04.17
      */
     function sheet0_OnSaveEnd(sheetObj,ErrMsg) {
    	 
    	 var formObj = document.form;
    	 
    	 if (ErrMsg != "") {
        	 isCopyed = false;
         } else {
        	 isCopyed = true;
         }
        
     }
  
     
     
	/* 개발자 작업  끝 */