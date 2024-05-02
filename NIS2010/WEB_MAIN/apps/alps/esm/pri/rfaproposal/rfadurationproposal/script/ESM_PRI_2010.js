/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2010.js
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2011.01.14 최성민 [CHM-201108327-01] 현재 RFA Duration 연장이 최대 1년으로 되어 있는 Logic 을 삭제하여, 1년 이상 연장 가능하도록 logic 변경 
* 2013.03.14 전윤주 Add on Project 이후 예외로 적용되어야 할 scope 찾는 로직에 버그가 있어 수정해서 태깅함
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2015.05.06 전지예 [CHM-201535708] Duration 화면의 문구 변경
* 2016.07.18 이민경 [CHM-201642492] Contract RFA 수정 Logic 변경 요청의 건
* 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청 (Requested By Kim Bo-Young)
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
     * @class ESM_PRI_2010 : ESM_PRI_2010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.setComboObject 		= setComboObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var comboObjects = new Array();
 var comboCnt = 0;

 var rData ="N";
 var tempAddOnEndExpDt =  "20130119";
 
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
 				case "btn_Amend":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY03);
 					break;
 				case "btn_AmendCancel":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY04);
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;
 				case "btn_Accept":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
 					break;
 				case "btn_AcceptCancel":
 					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
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
     * IBCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수 IBCombo Object
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
 	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10); 	   

  	     //sheet에서 호출 할경우 svc_scp_cd로 다시 조회한다.
 	     var formObj = document.form;
  	     var svcScpCd = formObj.svc_scp.value;

  	     if (svcScpCd != "" && svcScpCd != null &&  svcScpCd !="null" ){
  		     if (comboObjects[0].GetCount() > 0 ){
    			   //받아온 값으로 초기화
      			 comboObjects[0].Text(svcScpCd);
      			 svc_scp_cd_OnBlur(comboObjects[0])  
  		     }
  	     }else{
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
  	     }
     }
     
     
   	/**
   	 * body 태그의 unonLoad 이벤트핸들러 구현 <br>
   	 * 화면을 브라우저에서 닫힐때 처리해야 하는 기능을 추가한다. <br>
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
         var amdt_seq = document.form.amdt_seq.value;
         var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 100;

                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     var HeadTitle1 = "|sel|propno|amdtseq|Duration|Duration|Latest updated|Latest updated|Source|Source|Status|Status|||||||||";
                     var HeadTitle2 = "|sel|propno|amdtseq|Duration|Duration|Effective Date|Expiry Date|Source|Source|Status|Status|||||||||";
                     var headCount = ComCountHeadTitle(HeadTitle1);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);
                     
                     InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
 					 InitDataProperty(0, cnt++, dtHidden,  		90,  daLeft,   false, "prop_no",  	 true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  		90,  daLeft,   false, "amdt_seq", 	 true,  "", dfNone,    0, false, false);                     
                     InitDataProperty(0, cnt++, dtData,    		100, daCenter, true,  "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                     if (amdt_seq == "0"){
                    	 InitDataProperty(0, cnt++, dtData,    100, daCenter, true,  "ctrt_exp_dt",  true,  "", dfDateYmd, 0, true, true);
                     } else {
                    	 InitDataProperty(0, cnt++, dtData,    100, daCenter, true,  "ctrt_exp_dt",  true,  "", dfDateYmd, 0, false, false);
                     }                     
                     InitDataProperty(0, cnt++, dtData,    110, daCenter, true,  "eff_dt",    	     false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtData,    110, daCenter, true,  "exp_dt",   		 false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,   80,  daCenter, true, "src_info_cd", 	 false, "", dfNone,    0, false, false, 100);	
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, true,  "src_info_dtl",     false, "", dfNone,    0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,   80,  daCenter, true, "prc_prog_sts_cd",  false, "", dfNone,    0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, true,  "prc_prog_sts_dtl", false, "", dfNone,    0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_usr_id",      false, "", dfNone,    0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_ofc_cd", 	 false, "", dfNone,    0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_dt", 		 false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "mn_eff_dt", 		 false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "mn_exp_dt", 	     false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "sp_dur_eff_dt", 	 false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "sp_dur_exp_dt", 	 false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "n1st_cmnc_amdt_seq",false, "",dfNone,    0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "dur_dup_flg",      false, "", dfNone,    0, false, false);
				     
				     sheetObj.SetMergeCell(0, 4, 2, 2);
                     ColHidden("chk") = true;
                     WaitImageVisible = false;
                }
                 break;

         }
     }
     /**
     * 콤보 초기설정값 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj, 1);
     * </pre>
     * @param {ibcombo} sheetObj 필수 IBSheet Object
     * @param {int} ComboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
  	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	                UseAutoComplete = true;
	            	IMEMode = 0;
	            	ValidChar(2, 0);
	            	MaxLength = 3;
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
    	  try{
              switch(sAction) {
              case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
  				comboObjects[0].RemoveAll();
  				
  				formObj.f_cmd.value = COMMAND37;
  				var sParam = FormQueryString(formObj) + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;
  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
  				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
  				
 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 				//	status
 				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue); 				
  				break;
  				
              case IBSEARCH:      //조회
              	ComOpenWait(true); //->waiting->start
  				if (!validateForm(sheetObjects[0],document.form,sAction)) {
  					ComShowCodeMessage('PRI08001');
  					return false;
  				}				
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch("ESM_PRI_2010GS.do", FormQueryString(formObj));
  				ComOpenWait(false); //->waiting->End
  				buttonControl();
  				break;

   			 case IBSAVE:        //저장 	 	
   			 	ComOpenWait(true); //->waiting->start
  	             if ( !ComPriConfirmSave()) {
  	                 return false;
  	             } 
   			 	var scpName = ComTrim(formObj.svc_scp_nm.value);
   			 	var pRow = getValidRowCount(sheetObj);
   			 	if(formObj.amdt_seq.value == "0" || pRow < 2) { //2016.07.21 Amend Canel 시 Header 참조 막기 위해 변경
   			 		pRow++;
   			 	}
   			 	
   		 		var msgChk = false;
   			 	var sParamSheet = sheetObjects[0].GetSaveString();	
   			 	if (!sheetObj.IsDataModified && sParamSheet==""){
   			 		ComShowCodeMessage("PRI00301");   			 		
   			 		return false;
   			 	}
   			 	if (sParamSheet == ""){
   			 		return false;
   			 	}
   			 
				var sctrtEffDt = sheetObj.CellValue(pRow, "ctrt_eff_dt");
  			 	var sctrtExpDt = sheetObj.CellValue(pRow, "ctrt_exp_dt");
  			 	var effDt = sheetObj.CellValue(pRow, "eff_dt");
  			 	
  			 	
  			 	if (sctrtExpDt < effDt ){
  		 			ComShowCodeMessage("PRI01104");
  			 		return false;
  			 	}
  			 	var expScpCnt = 0; //Exception Scope-Count.
		 		var comboCnt = comboObjects[0].GetCount();
		 		var expFlag = false;
				for(var c=0; c < comboCnt; c++) {
					var s = comboObjects[0].GetIndexText(c, 0);
					if(s != '' && ComCheckGuideExcepSvcScpCd(s)) {
						expScpCnt++;
					}
	 			}
	 			
//	 			var toDate = searchSystemToDate(sheetObjects[0]);
//	 			if(expScpCnt != comboCnt - 1) {
//	 				 if(toDate >= tempAddOnEndExpDt) {
//		 				if((sctrtEffDt < addOnEndExpDt && sctrtExpDt >= addOnEndExpDt) || (sctrtEffDt >= addOnEndExpDt && sctrtExpDt < addOnEndExpDt)) {
//	  	  			 		ComShowCodeMessage('PRI07040'); 		
//	  	            		return false;
//	  	  			 	} 
//	 				 }
//	 			}
	 			if(expScpCnt != comboCnt - 1) {
	 				if((sctrtEffDt < tempAddOnEndExpDt && sctrtExpDt >= tempAddOnEndExpDt && sctrtEffDt < addOnEndExpDt) || (sctrtEffDt >= tempAddOnEndExpDt && sctrtExpDt < tempAddOnEndExpDt && sctrtEffDt < addOnEndExpDt)) {
  	  			 		ComShowCodeMessage('PRI07044'); 		
  	            		return false;
  	  			 	} 
	 			}
	 				
  			 	/**
  			 	 * Svc_scp_cd를 선택하지 않은 경우
  			 	 * -- 멀티 Scope에 예외 Scope가 존재할 경우 Duration 체크 로직 제외
  			 	 */
  			 	if(formObj.svc_scp_cd.Code != '') {
//	  			 	var svcScpCd = sheetObj.CellValue(pRow, "svc_scp_cd"); 버그 아래와 같이 수정 - 2013.03.14
  			 		var svcScpCd = formObj.svc_scp_cd.Code;  			 		
	 			 	if(!ComCheckGuideExcepSvcScpCd(svcScpCd)) {
//	 			 		if(toDate >= tempAddOnEndExpDt) {
//			  			 	if((sctrtEffDt <= endExpDt && (sctrtExpDt > endExpDt || sctrtExpDt < addOnEndExpDt)) || ((sctrtEffDt > endExpDt || sctrtEffDt < addOnEndExpDt) && sctrtExpDt <= endExpDt)) {
//			  			 		if(comboObjects[0].FindIndex('AEW', 0) != -1 || comboObjects[0].FindIndex('AEE', 0) != -1) {
//				            		ComShowCodeMessage('PRI07012'); 		
//				            		return false;
//				            	}
//			  			 	} else {
//			  			 		if((sctrtEffDt < addOnEndExpDt && sctrtExpDt >= addOnEndExpDt) || (sctrtEffDt >= addOnEndExpDt && sctrtExpDt < addOnEndExpDt)) {
//			  	  			 		ComShowCodeMessage('PRI07040'); 		
//			  	            		return false;
//			  	  			 	} 
//			  			 	}
//	 			 		} else {
//	 			 			if((sctrtEffDt <= endExpDt && sctrtExpDt > endExpDt) || (sctrtEffDt > endExpDt && sctrtExpDt <= endExpDt)) {
//			  			 		if(comboObjects[0].FindIndex('AEW', 0) != -1 || comboObjects[0].FindIndex('AEE', 0) != -1) {
//				            		ComShowCodeMessage('PRI07012'); 		
//				            		return false;
//				            	}
//			  			 	} 
//	 			 		}
						if(sctrtEffDt < tempAddOnEndExpDt && sctrtExpDt >= tempAddOnEndExpDt && sctrtEffDt < addOnEndExpDt) {
							ComShowCodeMessage('PRI07044'); 		
	  	            		return false;
						} else {
							if(sctrtEffDt < addOnEndExpDt) {
								if((sctrtEffDt <= endExpDt && (sctrtExpD > endExpDt || sctrtExpDt < addOnEndExpDt)) || ((sctrtEffDt > endExpDt || sctrtEffDt < addOnEndExpDt) && sctrtExpDt <= endExpDt)) {
									if(comboObjects[0].FindIndex('AEW', 0) != -1 || comboObjects[0].FindIndex('AEE', 0) != -1) {
					            		ComShowCodeMessage('PRI07012'); 		
					            		return false;
					            	}
								}
							}
						}
	 			 	}
  			 	}
   			 	
   			 	var sParam = "";
   			 	var sXml = "";
   			 	var scpSave ="";
   			 	//메인일경우에만

   			 	if (scpName == ""){
   			 		if (formObj.amend_flg.value !="N"){
   	  			 		formObj.f_cmd.value = SEARCH01;
   	  			 		sParam = FormQueryString(formObj)+"&ctrt_exp_dt="+sheetObj.CellValue(sheetObj.RowCount+1,"ctrt_exp_dt");
   	  			 		if ( pRow == "2"){
   	  	 					//메인 DURATION과 EXPIRE DATE가 같은 SCOPE을 조회한다.
   	  			 			sXml = sheetObj.GetSearchXml("ESM_PRI_2010GS.do", sParam);				
   	  	 					var arrData = ComPriXml2Array(sXml, "chk_dur");
   	  	 					if (arrData != null && arrData.length > 0) {
   	  	 						if (arrData.length == 2){
   	  	 							//scope duration을 자동으로 자를 경우 사용자가 취소를 하면 모든 저장취소.
   	  	 							if (!ComShowCodeConfirm("PRI01109")){
   	  	 								ComShowCodeMessage("PRI01026");
   	  	 								return ;
   	  	 							}else{
   	  	 								//메인과 SCOPE을 같이 저장
   	  	 								scpSave ="&scp_save=true"
   	  	 							}
   	  	 						}else{
   	  	 							//scope duration을 자동으로 자를 경우 사용자가 취소를 하면 모든 저장취소.
   	  	 							if (arrData[0]=="DECREASE"){
   	  	 								if (!ComShowCodeConfirm("PRI01109")){
   	  	 	 								ComShowCodeMessage("PRI01026");
   	  	 	 								return ;
   	  	 								} 								
   	  	 								scpSave ="&scp_save=true"
   	  	 							}else{
   	  	 								if (!ComShowCodeConfirm("PRI01109")){
   	  	 									//scope duration을 자동으로 늘릴 경우 사용자가 취소를 하면
   	  	 									//proposal duration만 늘린다.
   	  	 									scpSave ="&scp_save=false"
   	  	 									msgChk = true;	
   	  	 								}else{  	  	 								
   	  	 									scpSave ="&scp_save=true"
   	  	 								}
   	  	 							}						
   	  	 						}
   	  	 					} 	
   	  					}
   			 		}
   			 	} else {
  					if (sheetObj.CellValue(pRow,"ctrt_exp_dt") > sheetObj.CellValue(pRow,"sp_dur_exp_dt")){
  						ComShowCodeMessage("PRI01003",ComGetMaskedValue(sheetObj.CellValue(pRow,"sp_dur_eff_dt"),"ymd","-"),ComGetMaskedValue(sheetObj.CellValue(pRow,"sp_dur_exp_dt"),"ymd","-"),"RFA");
  						return false;
  					}
  					scpSave ="&scp_save=expchange"
   			 	}

     			formObj.f_cmd.value = MULTI;
     			sParam = FormQueryString(formObj)+ scpSave;
     			sParamSheet = sheetObjects[0].GetSaveString();
   				sXml = sheetObj.GetSaveXml("ESM_PRI_2010GS.do", sParam + "&" + sParamSheet);
     			
   				if (msgChk == true && scpName ==""){
     				ComShowCodeMessage("PRI01077");
     			}
   				sheetObj.LoadSaveXml(sXml); 
   				ComOpenWait(false); //->waiting->End
                 break;
   			 case MODIFY01:        //accept
			 	 ComOpenWait(true); //->waiting->start   			 
   			 	var scpName = ComTrim(formObj.svc_scp_nm.value);
   			 	if (!ComShowCodeConfirm("PRI00008")) {
  	            	return false;
  	            }  		
   			 	/////////////////////////////////////////////////////////////////
   			 	if (!acceptValidation(sheetObj,formObj)) {
   			 		return false;
   			 	}
   			 	////////////////////////////////////////////////////////////////
   	  			if (scpName == ""){
   	  			    //Main 과  Expire Date가 같은 Scope을 조회한다.
   	  				aData = checkAutoChangeAcceptData();
 	   		       if (aData != null && aData.length > 0) {
 	  	  				if (ComShowCodeConfirm("PRI01112")) {	  	  			 	
 	  	  				    formObj.scp_accept.value = "Y"; 	  				    
 	  	 	            }	   		    	   
 	   		       }  	
   			 	}
  				formObj.f_cmd.value = MODIFY01;
  				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2010GS.do");
  				if (rVal){
  					if (formObj.scp_accept.value == "Y"){
   	  				    formObj.scp_accept.value = "";
  					} 					
  				} 				
  				ComOpenWait(false); //->waiting->End
  				break;		
  				
   			 case MODIFY02:        //accept cancel
			 	 ComOpenWait(true); //->waiting->start
  	            if (!ComShowCodeConfirm("PRI00009")) {
  	            	return false;
  	            } 			 
  				formObj.f_cmd.value = MODIFY02;
  				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2010GS.do");
  				ComOpenWait(false); //->waiting->End
  				break;		
   			 
   			 case MODIFY03:        //amend
  				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

  				if(chkArr.length > 0){
  					if(chkArr.length > 1){					
  						ComShowCodeMessage("PRI00310");
  					}else{						
  						sheetAmendRow(sheetObj,formObj,chkArr[0],"M", "ctrt_exp_dt");						
  					}
  				}else{ 					
  					sheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", "ctrt_exp_dt");					
  				}
   			    sheetObj.SelectCell(3,"ctrt_exp_dt");
   			    formObj.amend_flg.value = "Y";
  				break;	 	

   			 case MODIFY04:        //amend cancel
  				if (!validateForm(sheetObjects[0],document.form,sAction)) { 					
  					
  					return false;
  				}	
   			 	var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
  				
  				if(chkArr.length > 0){
  					if(chkArr.length > 1){					
  						ComShowCodeMessage("PRI00310");
  					}else{
  						sheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "ctrt_exp_dt");		
  					}
  				}else{ 
  					sheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "ctrt_exp_dt"); 					
  				}	
   			 	formObj.amend_flg.value = "N";
  				break;
               
             }    		  
          } catch (e) {
           	if (e == "[object Error]") {
                   ComShowMessage(OBJECT_ERROR);
               } else {
                   ComShowMessage(e);
               }
           }finally{
	           	if (sAction == IBSEARCH_ASYNC10 || sAction == MODIFY03 || sAction == MODIFY04) {
	           		return;
	           	}
	           	ComOpenWait(false); //->waiting->End
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
      function validateForm(sheetObj,formObj,sAction){
   			switch (sAction) {
	  			case IBSEARCH: // 조회
	  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
	  					return false;
	  				}
	  				break;
	  			case MODIFY04: // AMEND CANCEL
	  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
	  					return false;
	  				}	  				
	  				var formObj = document.form;
	  				var scpName = ComTrim(formObj.svc_scp_nm.value);
	  				if (scpName !=""){
	  					return true;
	  				}
	  				if (sheetObj.SelectRow == 3){
		  				document.form.f_cmd.value = SEARCH02;
			  		    var sParam = FormQueryString(document.form);
			  		    var sParamSheet = sheetObjects[0].GetSaveString(true);
			  		    var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2010GS.do", sParam+"&"+sParamSheet);
			  		    var arrData = ComPriXml2Array(sXml, "svc_scp_cd");
			  		    if (arrData != null && arrData.length > 0) {
			  		    	ComShowCodeMessage("PRI01075", arrData[0][0]);
			  		    	return false;
			  		    }
	  				}	  			
	  				break;	  				
	  			case IBSAVE: // 저장
	  				if (formObj.amdt_seq.value == "" || formObj.prop_no.value == "") {
	  					return false;
	  				}
	  				if (sheetObj.IsDataModified != true){
	  					return false;
	  				}	  				
	  				break;	  				
   			}
   		return true;
    }
      

  /**
   * OnChange 이벤트 발생시 호출되는 function <br>
   * 콤보의 SVC Scope명칭을 INPUT BOX에 채운고 조회를 한다.. <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   * @param {int} text 필수 화면에 표시된 글자
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */  	
 	function svc_scp_cd_OnChange(comboObj, code, text) {
  		var formObj = document.form;

  		var arrText = text.split("|");
  		if (arrText != null && arrText.length > 1) {
  			formObj.svc_scp_nm.value = arrText[1];
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  		}
  		
  	}           
       
   /**
    * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
    * Combo의 text값을 Html Object에 표시하고 변경된 Scope으로 데이터를 조회 한다. <br>
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
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		}
	}          
 	

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * Sheet의 값을 Html Object에 Setting하고 Font Style을 지정한다.
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
		var amdt_seq = document.form.amdt_seq.value;
		var formObj = document.form;
		var maxRow = sheetObj.RowCount+1;
		
		//main eff_dt,exp_dt를 setting
		if (sheetObj.RowCount > 0){
			formObj.eff_dt.value = sheetObj.CellValue(maxRow,"mn_eff_dt");
			formObj.exp_dt.value = sheetObj.CellValue(maxRow,"mn_exp_dt");
			formObj.pre_exp_dt.value = ComGetDateAdd(sheetObj.CellValue(maxRow,"mn_eff_dt"), "D", -1);
		}
		
        var sCols = "ctrt_exp_dt";
		searchEndFont(sheetObj, sCols, sheetObj.HeaderRows);
	}

    /**
     * sheet 조회 후 font 설정을 변경한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     searchEndFontChange(sheetObj, "ctrt_exp_dt", 2);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colName 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {int} HeaderRows 선택, HeaderRows의 Row값. 없는경우 1
     * @return 없음
     * @author 공백진
     * @version 2009.06.12
     */
    function searchEndFont(sheetObj, sCols, dataRow){
        var arrCols  = sCols.split("|");
        var amdt_seq = document.form.amdt_seq.value;
        
        if(amdt_seq==0){
            return;
        }

        for(i = (dataRow == '')?1:dataRow ; i < sheetObj.Rows; i++){
            if(sheetObj.CellValue(i, "amdt_seq") != amdt_seq){
                sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = true;
                for (j = 0; j < arrCols.length; j++){
                    sheetObj.CellEditable(i,arrCols[j]) = false;
                }
            }
            else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
                sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
                if (sheetObj.CellValue(i, "src_info_cd") != "AD"){
                    for (j = 0; j < arrCols.length; j++){
                        sheetObj.CellEditable(i,arrCols[j]) = true;
                    }
                }
            }
        }
    }
    
     /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 데이터 수정 flag를 Y로 Setting한다. <br>
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
			 rData ="Y";
		}
	}        
     
     
     /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Sheet의 "ctrt_exp_dt" 컬럼에 대한 Validation을 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       
  	function sheet1_OnChange(sheetObj, Row, Col)
 	{
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
		  
       	switch(colName)
       	{
   	    	case "ctrt_exp_dt":
   	    		if (sheetObj.CellValue(Row, "ctrt_eff_dt") >= sheetObj.CellValue(Row, "ctrt_exp_dt") ){
   	    			ComShowCodeMessage("PRI01024");
   	    			sheetObj.CellValue2(Row,"ctrt_exp_dt") = "";
   	    			sheetObj.SelectCell(Row,"ctrt_exp_dt");   
   	    			break;
   	    		}else{
   	    			sheetObj.CellValue2(Row,"exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
   	    		}
   			 	if (sheetObj.CellValue(Row, "ctrt_exp_dt") < sheetObj.CellValue(Row, "eff_dt") ){
			 		ComShowCodeMessage("PRI01104");			 		
			 		sheetObj.SelectCell(Row,"ctrt_exp_dt"); 
   			 	}
   			 	/**2016.07.13 C.RFA Logic 변경 요청 by. 이종욱
  			  	 * 수정 가능 범위 Validation - 현재 날짜 ~ 기존 Exp + 3개월
  			  	 * */
  			     if(formObj.rfa_ctrt_tp_cd.value == "C"){
  			    	 var expDay = sheetObj.CellValue(Row,"ctrt_exp_dt");
  			    	 //기존 Exp +3개월
  			    	 var orgExpDt = sheetObj.CellValue(Row-1,"ctrt_exp_dt");
  			    	 var expDayAft3M = getMonthAdd(orgExpDt, 3, "");
  				     //Current Date
  				     var gCurrDate = ComGetNowInfo('ymd')
  				     var today = gCurrDate.replace(/-/g,'');
  					     if(parseInt(expDay,10) < parseInt(today,10)){
  					    	 ComShowCodeMessage("PRI07063");//Amend Eff date must be same or later than requested date.
  					    	 sheetObj.SelectCell(Row,"ctrt_exp_dt");
  					    	 ComBtnDisable("btn_Save");
  					    	 break;	    	 
  					     }
  					     if(parseInt(expDay,10) > parseInt(expDayAft3M,10)){
  					    	 ComShowCodeMessage("PRI07064");//Amend Eff date can’t be over 3months from current expiration date.
  					    	 sheetObj.SelectCell(Row,"ctrt_exp_dt");   
  					    	 ComBtnDisable("btn_Save");
  					    	 break;
  					     }
  			     }
  			   ComBtnEnable("btn_Save");
  			     /** End */
  			     
				/**
				 * Basic의 경우 exp date가 Master RFA의 Duration을 초과할 수 없다. (CHM-201642287) 
				 */
				if(formObj.rfa_ctrt_tp_cd.value == "B") {
					formObj.f_cmd.value = SEARCH25;
					var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", FormQueryString(formObj));
					var check_org_exp_dt = ComGetEtcData(sXml, "org_exp_dt");
					
					//앞자리 달력에서 입력한 값이 더 크면 경고.
					//ret = ComGetDaysBetween("2008-10-11", "2008-10-01") //결과 : -10
					if (ComGetDaysBetween(  sheetObj.CellValue(Row, "ctrt_exp_dt") , check_org_exp_dt ) < 0) {
						ComShowCodeMessage('PRI01165'); //msgs['PRI01165'] = 'Duration cannot exceed the original duration for Basic RFA.';
						sheetObj.CellValue2(Row,"ctrt_exp_dt") = check_org_exp_dt;
						sheetObj.CellValue2(Row,"exp_dt") = check_org_exp_dt;
						break;
					}
				}
				
   	    		break; 
       	   }
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
     * 버튼 권한 컨트롤 function <br>
     * 버튼을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl()
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
			var rfa_ctrt_tp_cd = formObj.rfa_ctrt_tp_cd.value;
				
			//2016-07-19 추가 sheet1_OnChange에서 막은 Disable을 Retrieve 시 해제
			ComBtnEnable("btn_Save");
				
			if (apro_usr_flg == "false" && req_usr_flg == "false"){
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Amend");
				ComBtnDisable("btn_AmendCancel");
				ComBtnDisable("btn_Accept");
				ComBtnDisable("btn_AcceptCancel");
				for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
					sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
				}	
				
				return;
			}
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
			} else {
				/**2016.07.13 C.RFA Logic 변경 요청 by. 이종욱
	         	 * Contract RFA Amend 시 EXP 변경 가능하도록 수정
	         	 * */
				if(rfa_ctrt_tp_cd == "B"){
				/** End */
					hiddenButton("btn_Amend");
					hiddenButton("btn_AmendCancel");
					/** Basic은 Amd 0일때만 Duration 변경 가능 (CHM-201642287) Requested By Kim Bo-Young */
					ComBtnDisable("btn_Save");
					
				}else{
					showButton("btn_Amend");
					showButton("btn_AmendCancel");
				}
			}		

			try{
				switch(sts) { 				
					case 'I':   // Initial								
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						break;
					case 'A': // Approved 모두금지, 조회,downexcel은 가능
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}
						break;
						
					case 'Q':// Requested   save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.
						
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
						}else{
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");							
						}
						
						for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}						
			
						break;
				
					case 'R':  // Returned
						ComBtnDisable("btn_Save");

						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");						
						
						if(req_usr_flg == "true"){
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
						}
						
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
						}

						for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}

						break;
					case 'F': // Filed
						ComBtnDisable("btn_Save");

						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}

						break;
					case 'C': //  // Cancled
						ComBtnDisable("btn_Save");						
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 2; i <= sheetObjects[0].RowCount+1 ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}
						break;
					default:
	    				showButton("btn_Amend");
	    				showButton("btn_AmendCancel");
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

//     /**
//     * Main Duration  exp_dt가 Scope의 exp_dt보다 작은지 검사한다.  <br>
//     * Return 값이 Y일 경우 저장할 수 없다.
//     * <br><b>Example :</b>
//     * <pre>
//     *         checkScopeDuration
//     * </pre>
//     * @param 없음
//     * @return {string} <br>
//     *                   Y : Main Duration  exp_dt가 Scope의 exp_dt보다 작다
//     *                   N : Main Duration  exp_dt가 Scope의 exp_dt보다 크다
//     * @author 공백진
//     * @version 2009.04.17
//     */     
//    function checkScopeDuration(){
//       document.form.f_cmd.value = SEARCH03;
//       var rMsg = "";
//       var rValue = "Y"; //저장금지
//       var sParam = FormQueryString(document.form);
//       var sParamSheet = sheetObjects[0].GetSaveString();
//       
//       var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2010GS.do",  sParam+"&"+sParamSheet);
//       var arrData = ComPriXml2Array(sXml, "cnt");
//       
//       if (arrData != null && arrData.length > 0) {
//           if (arrData[0][0] == "0"){
//               rValue = "N";
//           } 
//       }
//       if (rValue =="Y"){
//           ComShowCodeMessage("PRI01083");
//       }
//       return rValue;
//    }    
    
    /**
    * 대상 ROW 를 Amend 처리한다. <br>
    * sheetObj    : 처리 대상 sheet object
    * formObj     : 처리 대상 form object
    * sRow        : 처리 대상 Row
    * sAction     : M : Update Amend, D : Delete Amend
    * sCols       : n1st_cmnc_dt, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
    *          ex) comSheetAmendRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
    * @return {string}
    * @author 변영주
    * @version 2009.05.29
    */
   function sheetAmendRow(sheetObj,formObj,sRow,sAction, sCols){

       var prop_no      = formObj.prop_no.value;
       var amdt_seq     = formObj.amdt_seq.value;
       var pre_amdt_seq = formObj.pre_amdt_seq.value;
       var eff_dt       = formObj.eff_dt.value;
       var exp_dt       = formObj.exp_dt.value;
       var pre_exp_dt   = formObj.pre_exp_dt.value;
       var arrCols      = sCols.split("|");
       var dur_dup_flg  = formObj.dur_dup_flg.value;
       // chebox 를 이용할 경우 해당 chk 를 제거
       sheetObj.CellValue(sRow,"chk")=0;

       // delete / modify Amend 중 이미 amend 된 과거 row 는 제외
       if(sheetObj.CellValue(sRow,"amdt_seq")!= amdt_seq || sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")== amdt_seq){
           ComShowCodeMessage("PRI00313");
           return false;
       }

       // DataCopy/ Insert 기준 row 를 잡기 위해 sRow 설정
       sheetObj.SelectRow=sRow;

       var idx = sheetObj.DataCopy();     // 신규 row
       var idx2 = idx-1;                  // 기존 row

       // A/M/D 공통 신규 row 생성
       sheetObj.CellValue2(idx,"eff_dt")= eff_dt;
       sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
       sheetObj.CellValue2(idx,"prc_prog_sts_cd")= "I";
       sheetObj.CellValue2(idx,"src_info_cd")= "AM";
//       sheetObj.CellValue2(idx,"ibflag")="U";
       sheetObj.RowStatus(idx)="U";
       for(x=0;x<arrCols.length;x++){
           sheetObj.CellEditable(idx,arrCols[x]) = true;
       }
       sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
       sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
       if(dur_dup_flg=="Y"){
           sheetObj.CellValue2(idx2,"exp_dt")=pre_exp_dt;        	
       }
       sheetObj.CellValue2(idx2,"amdt_seq")=pre_amdt_seq;
       sheetObj.RowEditable(idx2) = false;

       // D, A 일 경우  신규 Row 를 update
       if(sAction=="D"){
           sheetObj.CellValue2(idx,"src_info_cd")= "AD";
           for(z=0;z<arrCols.length;z++){
               sheetObj.CellEditable(idx,arrCols[z]) = false;
           }
       }
       sheetObj.RowStatus(idx2) = "R"; // 기존 Row 의 상태를 R로 변경해서 저장되지 않도록 함
       changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
       return true;
   }

  /**
   * 대상 ROW 를 Amend Cancel 처리한다.
   * sheetObj    : 처리 대상 sheet object
   * formObj     : 처리 대상 form object
   * sRow        : 처리 대상 Row
   * sAction     : A : Insert Amend, M : Update Amend, D : Delete Amend
   * sCols       : n1st_cmnc_dt, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
   *           ex) sheetAmendCancelRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
   * @return {string}
   * @author 변영주
   * @version 2009.05.29
   */
   function sheetAmendCancelRow(sheetObj,formObj,sRow,sAction, sCols){
	   var amdt_seq     = formObj.amdt_seq.value;
       var eff_dt       = formObj.eff_dt.value;
       var exp_dt       = formObj.exp_dt.value;
       var arrCols      = sCols.split("|");
       var pre_amdt_seq = formObj.pre_amdt_seq.value;
       var dur_dup_flg  = formObj.dur_dup_flg.value;
       
       sheetObj.CellValue(sRow,"chk")=0;

       //  A/M/D 동일하게 n1st_cmnc_amdt_seq == eff_Dt 일 경우에만 처리해줌
       if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
           ComShowCodeMessage("PRI00313");
           return false;
       }

       var idx  = sRow-1;
       var idx2 = sRow;

       if(sAction=="A"&&(sheetObj.CellValue(sRow,"src_info_cd")=="NW"||sheetObj.CellValue(sRow,"src_info_cd")=="GM"||sheetObj.CellValue(sRow,"src_info_cd")=="GC")){
//           sheetObj.CellValue(sRow,"ibflag")="D";
           sheetObj.RowStatus(sRow)="D";
           sheetObj.RowEditable(sRow)=false;
           sheetObj.RowHidden(sRow) = true;
           return false;
       }else{
           if(sheetObj.CellValue(sRow,"src_info_cd")!="AD"&&sheetObj.CellValue(sRow,"src_info_cd")!="AM"){
               ComShowCodeMessage("PRI01002");
               return false;
           }
           sheetObj.CellValue2(idx,"exp_dt") = sheetObj.CellValue(idx,"ctrt_exp_dt");           
           sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol)=false;
           sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol)=false;
           sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
           sheetObj.CellValue2(idx2,"amdt_seq")= pre_amdt_seq;
           sheetObj.RowEditable(idx) = true;
           sheetObj.SelectCell(idx,"chk");
//           sheetObj.CellValue(idx,"ibflag")="U";
           sheetObj.RowStatus(idx)="U";
           sheetObj.RowDelete(idx2, false);
//           sheetObj.CellValue2(idx,"exp_dt") = sheetObj.CellValue(idx,"ctrt_exp_dt");           
//           sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol)=false;
//           sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol)=false;
//           sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
//           sheetObj.CellValue2(idx2,"amdt_seq")= pre_amdt_seq;
//           sheetObj.RowEditable(idx) = true;
//           sheetObj.CellValue(idx2,"ibflag")="D";
//           sheetObj.RowEditable(idx2)=false;
//           sheetObj.RowHidden(idx2) = true;
//           sheetObj.SelectCell(idx,"chk");
//           sheetObj.CellValue(idx,"ibflag")="U";

       }

       return true;
   }      

     /**
     * Main Duration  Accept시 Expire date가 같은 Scope을 찾는다. <br>
     * Expire Date 가 같은 Scope이 있다면 사용자의 선택에 따라 Accept한다.(summary update방식 변경 이후 사용안함)
     * <br><b>Example :</b>
     * <pre>
     *         checkAutoChangeAcceptData();
     * </pre>
     * @param 없음
     * @return string  Main 과 Expire date가 같은 Scope 코드배열
     * @author 공백진
     * @version 2009.04.17
     */     
   function checkAutoChangeAcceptData(){
       var formObj = document.form;
       var sheetObj = sheetObjects[0]
       var rValue = "N";            

       formObj.f_cmd.value = SEARCH04;
       var sXml = sheetObj.GetSearchXml("ESM_PRI_2010GS.do" , FormQueryString(formObj));        
       var arrData = ComPriXml2Array(sXml, "cd");
       
       return arrData;      
   }      
   
   
   /**
    * Accept Validation을  처리한다.
    * Accept All Validation처리를 하기 위하여 
    * comSheetAcceptCheckedRows의 Validation처리 전에 실행한다.
    * sheetObj    : 처리 대상 sheet object
    * formObj     : 처리 대상 form object
    *           ex) acceptValidation(sheetObjects[1],document.form);
    * @return {string}
    * @author 변영주
    * @version 2009.05.29
    */
    function acceptValidation(sheetObj,formObj){
    	var amdt_seq  	= formObj.amdt_seq.value;
        var prop_sts_cd = formObj.prop_sts_cd.value;

        if(prop_sts_cd == "R") {
            var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
            if(chkArr.length == 0){
                sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
                chkArr[0] = sheetObj.SelectRow;
            }
            for(i=0;i<chkArr.length;i++){
                if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                    sheetObj.CellValue2(chkArr[i],"chk") = "0";
                    ComShowCodeMessage("PRI00313");
                    return false;
                }
            }
        } else {
	        var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")	
	        if(chkArr.length == 0){
	            sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
	            chkArr[0] = sheetObj.SelectRow;
	        }
	        for(i=0;i<chkArr.length;i++){
	        	if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
	                sheetObj.CellValue2(chkArr[i],"chk") = "0";
	                ComShowCodeMessage("PRI01037");
	                return false;
	            }
	        	
	        	if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
	                sheetObj.CellValue2(chkArr[i],"chk") = "0";
	                ComShowCodeMessage("PRI00313");
	                return false;
	            }
	        }
	    }
	    return true;

    }   
    
    /**
	 * 2016.07.18 추가 <br>
	 * ComGetDateAdd function에 월별 말일 구분처리 추가<br>
	 * sDate : 선택,기준 날짜 문자열; null이면 PC의 현재날짜 기준으로 계산된다. default=null(PC의 현재날짜) YYYY-MM-DD
	 * iVal : 필수,연산할 값
	 * sDelim : 선택,결과에 사용할 날짜구분자, default="-"<br>
	 */
    function getMonthAdd(sDate, iVal, sDelim){
        try {
            if (sDelim==null || sDelim==undefined) sDelim = "-";

            if (sDate==null || sDate==undefined) {
                sDate = new Date();
            } else {
                //문자열 또는 HTML태그(Object)인 경우 처리
                sDate = getArgValue(sDate);

                sDate = getDateObj(sDate);
                if(isNaN(sDate.getYear())) return "";
            }

            var yy = sDate.getFullYear();
            var mm1 = sDate.getMonth();
            var dd = sDate.getDate();
            iVal = ComParseInt(iVal);	//인자가 문자열로 들어온 경우 에러 발생함

            var mm2 = mm1+ iVal; 
            
        	if(dd> ComGetLastDay(yy,mm2%12+1) || dd == ComGetLastDay(yy,mm1+1)){
        		dd = ComGetLastDay(yy,mm2%12+1);        		
        	}
            date = new Date(yy,mm2,dd);
            
            yy = date.getFullYear();
            mm2 = date.getMonth() + 1;
            dd = date.getDate();

            return yy + sDelim + ComLpad(mm2,2,"0") + sDelim + ComLpad(dd,2,"0");
        } catch(err) { ComFuncErrMsg(err.message); }
    }
   
	/* 개발자 작업  끝 */