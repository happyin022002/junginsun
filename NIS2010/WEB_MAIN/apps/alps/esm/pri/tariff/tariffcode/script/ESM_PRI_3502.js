/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3502.js
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
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
     * @class ESM_PRI_3502 : ESM_PRI_3502 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3502() {
    	this.processButtonClick				= tprocessButtonClick;
    	this.setSheetObject 					= setSheetObject;
    	this.loadPage 							= loadPage;
    	this.initSheet 							= initSheet;
    	this.initControl           			 	= initControl;
    	this.doActionIBSheet 				= doActionIBSheet;
    	this.validateForm 					= validateForm;
    	this.searchTariffCodeName     	= searchTariffCodeName;
        this.sheet1_OnChange 				= sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var origin_nm = "";
	
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
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_save": //저장
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
				case "btn_retrieve": //조회
					doActionIBSheet(sheetObject1, formObject, SEARCH02);
					break;
					
				case "btn_new": //clear
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
		 			ComOpenWait(false);
		 			comboObjects[0].Enable =  false;
		 			comboObjects[1].Enable =  false; //add
					ComBtnDisable("btn_delete");			
		   			ComSetFocus(document.form.trf_no);
					break;
					
				case "btn_delete": //tariff code 삭제
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					ComSetFocus(document.form.trf_no);
					break;
					
				case "btn_rowadd": //row 추가 
	                doActionIBSheet(sheetObject1, formObject,IBINSERT);
					break;
					
				case "btn_rowdelete": //row 삭제
					doActionIBSheet(sheetObject1, formObject, MODIFY02);					
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
        //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);            
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);

        ComClearSeparator (document.form.trf_no,"eng"); //한글 변환 키 막기 
        ComClearSeparator (document.form.trf_nm,"eng"); //한글 변환 키 막기 
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
    * @version 2010.10.13
    */ 
	function initCombo(comboObj, comboNo) {
   	 
	    switch(comboObj.id) {
	        case "inland_rates":
	            var i = 0;
	            with (comboObj) {
	                DropHeight = 100;
	                UseAutoComplete = true;
	                Enable = false;
//	                ValidChar(2, 0);    // 영문대문자만 입력
	                InsertItem(i++, "", "");
	                InsertItem(i++, "Yes", "Y");
	                InsertItem(i++, "No", "N");
	                Code = "";
	            }
	            break;     
	        //add    
	        case "web_dp":	
	            var i = 0;
	            with (comboObj) {
	                DropHeight = 100;
	                UseAutoComplete = true;
	                Enable = false;
	                InsertItem(i++, "", "");
	                InsertItem(i++, "Yes", "Y");
	                InsertItem(i++, "No", "N");
	                Code = "";
	            }
	            break; 	            
	    }
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
      * @version 2010.11.03
      */
     function obj_keydown(){
         //enter key조회
         var eleName = event.srcElement.name;
         if (eleName == "trf_cd"|| eleName == "trf_nm"){
             if (event.keyCode == 13){
                 doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
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
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
	function loadPage() {
    	initControl();
		for (i = 0; i < sheetObjects.length; i++) {

			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
			ComSetFocus(document.form.trf_no);
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			ComBtnDisable("btn_delete");
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
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

                 var HeadTitle = "ibflag|Seq|Service Scope|Description";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(6, 4, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// 
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus, 		30, 		daCenter, 	false, 	"ibflag"); 
                 InitDataProperty(0, cnt++, 	dtSeq,          			40,    	daCenter,  	false,     "Seq");           
                 InitDataProperty(0, cnt++, 	dtCombo, 				100, 		daCenter, 	false, 	"svc_scp_cd", 	  true,  	"", 	dfNone,   0, 	false, 	true, 3);                                
                 InitDataProperty(0, cnt++ , 	dtData,					200,		daLeft,		false,		"svc_scp_nm",	  false,    "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtHidden,				80,		daLeft,		false,		"trf_pfx_cd");
                 InitDataProperty(0, cnt++ , 	dtHidden,				20,		daLeft,		false,		"trf_no");
     		               
                 InitDataCombo(0, "svc_scp_cd", scopeCdText, scopeCdValue);  //service scope combo
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
   * @author 서미진
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {																		
		 		
	 			case IBSEARCH: // 조회
		 		break;
		 		
		 		case SEARCH01: // tariff no.조회
	 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);	 			
		 			formObj.f_cmd.value = SEARCH01;
		 			
		 			var sXml = sheetObj.GetSearchXml("ESM_PRI_3502GS.do", FormQueryString(formObj));
		 			
		 			//tariff name이 NULL인지 확인
	 		 		if (ComGetEtcData(sXml,"trf_nm")  != undefined){  
	 		 			origin_nm = ComGetEtcData(sXml,"trf_nm");
	 		 			formObj.trf_nm.value = origin_nm;
	 		 		}else { 
	 		 			formObj.trf_nm.value = "";
	 		 		}
	 		 		
	 		 		//새로운 tariff no. 인지 확인
	 		 		if (ComGetEtcData(sXml,"cre_flg")  != undefined){ 
	 		 			formObj.cre_flg.value = ComGetEtcData(sXml,"cre_flg");
	 		 			ComBtnEnable("btn_delete");
	 		 			formObj.trf_nm.readOnly =  true;
	 		 			formObj.trf_nm.setAttribute("className","input2");
	 		 		}else { 
	 		 			//새로운 tariff no. 이다.
	 		 			formObj.cre_flg.value = "";
	 		 			ComBtnDisable("btn_delete");
	 		 			formObj.trf_nm.readOnly =  false;
	 		 			formObj.trf_nm.setAttribute("className","input1");
	 		 		}
	 		 		
	 		 		//inland flag 받기 & readonly처리
	 		 		if (ComGetEtcData(sXml,"trf_inlnd_flg")  != undefined){
		 		 		if (ComGetEtcData(sXml,"trf_inlnd_flg")  == "Y"){
		 		 			ComSetObjValue(formObj.inland_rates, ComGetEtcData(sXml,"trf_inlnd_flg"));
		 		 		}else{
		 		 			ComSetObjValue(formObj.inland_rates, ComGetEtcData(sXml,"trf_inlnd_flg"));
		 		 		}
	 		 		}else{ 
	 		 			ComSetObjValue(formObj.inland_rates, "");
	 		 		}
	 		 		
	 		 		//add web_dp_flg 받기 & readonly처리
	 		 		if (ComGetEtcData(sXml,"web_dp_flg")  != undefined){
	 		 			ComSetObjValue(formObj.web_dp, ComGetEtcData(sXml,"web_dp_flg"));
	 		 		}else{ 
	 		 			ComSetObjValue(formObj.web_dp, "");
	 		 		}
	                sheetObj.RemoveAll();
	 		 		break;	
		 		
		 		case SEARCH02: // service scope 조회
	 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);
				 			
		 			formObj.f_cmd.value = SEARCH02;
		 			var sXml = sheetObj.DoSearch4Post("ESM_PRI_3502GS.do", FormQueryString(formObj));
		 			sheetObj.LoadSearchXml(sXml);		
					
		 			//inland flag combo 활성화
		 			ComOpenWait(false);
		 			if (formObj.trf_nm.value == ""){
		 				comboObjects[0].Enable =  true;
		 				comboObjects[1].Enable =  true; //add 
		 			}	else {
		 				comboObjects[1].Enable = true; //add 
		 			}	 			
 		 			break;		 				 		
		 				 		
		 		case IBCLEAR:      // 초기화 
		 			ComOpenWait(true);		 		
		 			formObj.reset();
		 			sheetObj.RemoveAll();
		 			
		   			ComBtnDisable("btn_rowadd");
		   			ComBtnDisable("btn_rowdelete");
		   			
 		 			formObj.trf_nm.readOnly =  true;
 		 			formObj.trf_nm.setAttribute("className","input2");
		 			ComSetObjValue(formObj.inland_rates, "");
		 			ComSetObjValue(formObj.web_dp, ""); //add
		 			break;
		 		
		 		case IBINSERT: // Row Add		 		
		 			addRow();
		 			break; 
	
		 		case IBDELETE:      // Tariff Code 삭제	 				
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}

		 			//정말 삭제 할껀지 물어봄
					if (!ComShowCodeConfirm("PRI00002")) {
						return false;
					}
		 			ComOpenWait(true);	
					
		 			formObj.f_cmd.value = MODIFY01;
		 			var sXml = sheetObj.GetSaveXml("ESM_PRI_3502GS.do", FormQueryString(formObj));		
		
		 			var del = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

		     	   if(del != "F" ){
		      			doActionIBSheet(sheetObj,document.form,IBCLEAR);
			   			ComSetFocus(document.form.trf_no);
			   			formObj.trf_nm.readOnly =  true;
			 			ComOpenWait(false);
			 			comboObjects[0].Enable =  false;
			 			comboObjects[1].Enable =  false; //add
		       	   }
		 			sheetObj.LoadSaveXml(sXml);		 			
	 		 		break;			
		 			
		 		case IBSAVE: // 저장
		 		
		 			if (!validateForm(sheetObj,document.form,sAction)) {		 	
						return false;
					} 					
		 			
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					
					if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
					    return;
					}

		 			formObj.f_cmd.value = MULTI01;		
		 			
		 			var inland = formObj.inland_rates.Code;

	                if(inland == "Y"){
	                    formObj.trf_inlnd_flg.value = "Y";
	                }else if(inland == "N"){
	                    formObj.trf_inlnd_flg.value = "N";
	                }	
	                
	                //add
	                var webDpCd = formObj.web_dp.Code;
	                if(webDpCd == "Y"){
	                    formObj.web_dp_flg.value = "Y";
	                } else {
	                    formObj.web_dp_flg.value = "N";
	                }
			 		var sParam = sheetObj.GetSaveString(false, true);
			 		sParam += "&" + FormQueryString(formObj); 
		 			var sXml = sheetObj.GetSaveXml("ESM_PRI_3502GS.do", sParam);	
		 			
		 			var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			     	   if(sav != "F" ){
							doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
							doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
							comboObjects[0].Enable =  false;
							//comboObjects[1].Enable =  false; //add
			       	   }
		 			sheetObj.LoadSaveXml(sXml);
		 			break;	
		 			
		 		case MODIFY02: // Row Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}		 		
 	        	  with (sheetObjects[0]) { 
		                 CellValue(SelectRow, "trf_pfx_cd") = document.form.trf_pfx_cd.value;
		                 CellValue(SelectRow, "trf_no") = document.form.trf_no.value; 	                 
 	        	  }
 	        	  var sts = sheetObj.RowStatus(sheetObj.SelectRow);
 	        	 sheetObj.RowStatus(sheetObj.SelectRow)= "D";
	 	        	  if( sts != "I"){
	 	        		sheetObj.RowHidden(sheetObj.SelectRow)= true;
	 	        	  }	
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
    * Tariff No. OnKeyPress 시 호출된다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     searchTariffName
    * </pre>
    * @param {sheetObj} sheetObj
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
   function searchTariffCodeName(obj) {   
    	comboObjects[0].Enable =  false;
    	comboObjects[1].Enable =  false; //add
    	if(obj.value.length == 3) {  
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
				doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
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
			
	    	 case SEARCH02: // 조회
		    	 if(formObj.trf_no.value.length != 3) {
						ComShowCodeMessage('PRI00308',"input","Tariff Code"); // Tariff Code is null
						ComSetFocus(document.form.trf_no);					
						return false;
					}
	    	 	break;
    	 
	    	 case IBSAVE: // 저장
	    	 	
	    	    //Tariff Code is null
		    	 if(formObj.trf_no.value.length != 3) {
						ComShowCodeMessage('PRI00316',"Tariff Code");  
						ComSetFocus(document.form.trf_no);			
						return false;
					}

	          	//inland rates check
	          	if(formObj.inland_rates.Code==""){
	          		ComShowCodeMessage("PRI00316","Inland Rates");
	          		formObj.inland_rates.focus();
	          		return false;
	          	} 	 
	    	 
	           //add web_dp check
	          	if(formObj.web_dp.Code==""){
	          		ComShowCodeMessage("PRI00316","E–service Display");
	          		formObj.web_dp.focus();
	          		return false;
	          	} 	          	
	    	 	 //Tariff Name is null
		    	 if(ComTrim(formObj.trf_nm.value) == "") {
						ComShowCodeMessage('PRI00316',"Tariff Name"); 					
						ComSetFocus(document.form.trf_nm);							
						return false;
					}
		    	 
	             //Tariff Scope 중복 데이터 체크
		        //sheetObj.SpaceDupCheck = false;           
	            var dupRow = sheetObj.ColValueDup("svc_scp_cd");
          
	            if (dupRow>0) {
	            	sheetObj.SelectRow = dupRow;
	                ComShowCodeMessage("PRI00342","Tariff Scope");
	                ComSetFocus(sheetObj.ColValueDupRows("svc_scp_cd"));	
	                return false;
	            }	             
	            
             //저장할 데이터가 있는지 확인
	            //E-Service Display 가 존재하므로 불필요
	            /*
            	if(!sheetObjects[0].IsDataModified  && formObj.cre_flg.value != ""){	            		 
	                 ComShowCodeMessage('PRI00301'); 
	                 return false;
            	 }	    
            	 */        	
		    	 break;	    	 
    	 
	    	 case IBDELETE: // Tariff Code 삭제	
		    	 if(formObj.trf_no.value.length != 3) {
						ComShowCodeMessage('PRI00308',"input","Tariff Code"); // Tariff Code is null
						ComSetFocus(document.form.trf_no);	
						return false;
					} 
    	 		break;
    	 
    	 }
 		return true;
 	}
	    	 
    	   	 
     /**
      * sheet1의 add row 에 대한 처리
      * 새로운 row를 추가한다.
      * @author 서미진
      * @version 2010.11.01
      */
     function addRow() {
    	  with (sheetObjects[0]) {
	 			var nowRow = SelectRow;
	 			maxRow = DataInsert(-1);
                 CellValue(lastRow, "trf_pfx_cd") = document.form.trf_pfx_cd.value;
                 CellValue(lastRow, "trf_no") = document.form.trf_no.value;               
             return true;
             }
         }


     /**
      * OnChange 이벤트 발생시 호출되는 function <br>
      * Amend Seq.가 0일 경우 Main Duration을 변경할 경우 Main의 Effective,Expire Date도 변경한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @return 없음
      * @author 서미진
      * @version 2010.11.01
      */  
      function sheet1_OnChange(sheetObj, Row, Col) {
	          var colName = sheetObj.ColSaveName(Col);
	          var formObj = document.form;
	            
	          switch(colName)
	          {
	              case "svc_scp_cd":
	            	  var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	            	  var sText = sheetObj.GetComboInfo(Row, Col, "Text");
	
	            	  //각각 배열로 구성한다.
	            	  var arrText = sText.split("|");
	
	            	  sheetObj.CellValue2(Row,"svc_scp_nm") = arrText[idx].split("	")[1] ;         
	                  break;                
	          }
      } 

	/* 개발자 작업  끝 */