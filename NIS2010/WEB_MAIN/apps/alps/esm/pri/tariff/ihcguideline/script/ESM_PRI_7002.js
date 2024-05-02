/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7002.js
*@FileTitle : IHC Tariff Creation & Amendment - Amend
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation 
=========================================================
* History                                                                      
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
     * @class ESM_PRI_7002 : ESM_PRI_7002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7002() {
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
	
	var formObject = document.form;

    var returnData = false;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;	
	
    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 서미진
     * @version 2011.09.23
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        document.form.tobe_amdt_seq.value = parseInt(document.form.amdt_seq.value)+1;
        document.form.amdt_eff.focus();
    }    

    /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2011.09.30
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
		   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	       axon_event.addListenerFormat('keypress', 'obj_KeyPress', document.form);
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
	      * @version 2012.04.17
	      */        
	    function obj_deactivate() {
	        var formObj = document.form;
	        var sheetObj = sheetObjects[0]; 
	        var eleName = event.srcElement.name;

	        switch(eleName){
			      case "amdt_eff":
				      ComChkObjValid(event.srcElement);   
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
     * @version 2011.09.23
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
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
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 30, 50);

                 var HeadTitle = "|Seq.|Customer\nCode|Customer\nCode|Customer Name|Customer Type||Customer Class|Location|Office|Sales Rep.|Sales Rep.\nName|Main Real\nCustomer|||";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// dtHiddenStatus
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 	40, daCenter, false, "ibflag");            
                 InitDataProperty(0, cnt++, dtSeq,    			30,   daCenter, false,  "seq");
                 InitDataProperty(0, cnt++, dtData, 				30, daLeft, false, "cust_cnt_cd", false, "", dfNone, 0, true, true, 2);
                 InitDataProperty(0, cnt++, dtPopupEdit, 		60, daLeft, false, "cust_seq", false, "", dfNone, 0, true, true, 6);
                 InitDataProperty(0, cnt++, dtData, 				250, daLeft, false, "real_cust_nm", false, "", dfNone, 0, false, false);              
                 InitDataProperty(0, cnt++, dtCombo, 			100, daCenter, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 			10, daLeft, false, "cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,				100, daCenter, false, "real_cust_val_sgm", false, "", dfNone, 0, false, false);      
                 InitDataProperty(0, cnt++, dtPopupEdit, 		110, daCenter, false, "cust_loc_cd", false, "", dfEngUpKey, 0, true, true, 5, true);
                 InitDataProperty(0, cnt++, dtData, 				80, daCenter, false, "cust_sls_ofc_cd", false, "", dfNone, 0, false, false);              
                 InitDataProperty(0, cnt++, dtCombo, 			80, daCenter, false, "cust_srep_cd", false, "", dfNone, 0, true, true);             
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "real_cust_srep_nm", false, "", dfNone, 0, false, false);                    
                 InitDataProperty(0, cnt++, dtRadioCheck,   	90, daCenter, false, "rep_cust_flg", false, "", dfNone, 0, true, true);    		      
                 
                 InitDataProperty(0, cnt++, dtHidden, 				30, daLeft, false, "amdt_seq", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 				90, daLeft, false, "prop_no", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 				30, daLeft, false, "real_cust_seq", false, "", dfNone, 0, true, true);        
                 
                 WaitImageVisible = false;   		            
     		}
          	break;
     	}
	}
 
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2011.09.30
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];       
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_ok": //Close 
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					if(!returnData){
						return;
					}
 					window.returnValue = returnData;
 					window.close();
					break;
				
				case "btn_close": //Close 
					window.returnValue = returnData;
					window.close();
					break;
					
	            case "btn_calendar": 
	            	if(!document.getElementById(srcName).disabled){
		                var cal = new ComCalendar();                
		                cal.select(document.form.amdt_eff, 'yyyy-MM-dd');
	            	}
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
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>			 
   * 
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 서미진
   * @version 2011.09.30
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		switch (sAction) {																		 				
	            case IBSAVE: // ok	            	     
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		            if (!ComShowCodeConfirm("PRI00001")) {
		            	return false;
		            }
		 			ComOpenWait(true); //->waiting->start        
	                formObj.f_cmd.value = MULTI;

			 		var sParam = FormQueryString(formObj); 	 	
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_7002GS.do", sParam);         
			 		var okl_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			     	if(okl_result != "F" ){
			     		returnData = true;
			     	} 
	        		ComOpenWait(false); //->waiting->End
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
     * @version 2010.11.01
     */
 	function validateForm(sheetObj, formObj, sAction) {    	 
    	 switch (sAction) {
	    	 case IBSAVE: // 저장	    		 
		             if (formObj.amdt_eff.value == "") {
		             	ComShowCodeMessage('PRI00308',"input","AMD Effective"); 
		             	formObj.amdt_eff.focus();
		                 return false;
		             }
	             
	            	if(formObj.eff_dt.value>=formObj.amdt_eff.value){
	            		ComShowCodeMessage('PRI05006', "Effective Date");
	            		formObj.amdt_eff.focus();
	            		return false;
	            	}
	            	
	            	if(formObj.exp_dt.value != "" && formObj.amdt_eff.value>formObj.exp_dt.value){	
	            		ComShowCodeMessage('PRI01088', "["+formObj.eff_dt.value+"] ~ ["+formObj.exp_dt.value+"]");	          
	            		formObj.amdt_eff.focus();
	            		return false;
	            	}         	

	            	// confirm date와 amnd eff. date를 비교 amnd eff date가 크도록
	            	if(ComGetNowInfo()>formObj.amdt_eff.value){
	            		ComShowCodeMessage('PRI07043', ComGetNowInfo());
	            		formObj.amdt_eff.focus();
	            		return false;
	            	}
	            	break;	      	 
 
    	 }
 		return true;
 	}