/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2003_06.js
*@FileTitle : RFA Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.17 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
	 * @class ESM_PRI_2003_06 : ESM_PRI_2003_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
 	var rData ="N";
 
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * processButtonClick();
	 * </pre>
	 * 
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.17
	 */
    function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	  
	    var sheetObject1 = sheetObjects[0];
	    var sheetObject2 = sheetObjects[1];
	  
	    /** **************************************************** */
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
					
				case "btn_Close":
//					window.returnValue = rData;
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
	 * @author 김재연
	 * @version 2009.08.17
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.17
	 */
	 function loadPage() {

	     for(i=0;i<sheetObjects.length;i++){
	    	 //khlee-시작 환경 설정 함수 이름 변경
	         ComConfigSheet (sheetObjects[i] );
	
	         initSheet(sheetObjects[i],i+1);
	         // khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
	    }
	    
	    pageOnLoadFinish(); 
	}

	/**
	 * OnKeyPress event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress()
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.17
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
	 * OnBeforeActivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.17
	 */    
	function obj_activate() {
	    var srcName = event.srcElement.getAttribute("name");

	    ComClearSeparator (event.srcElement);
	}
	
    /**
	 * Onbeforedeactivate  event를 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     
	 * </pre>
	 * @return 없음
	 * @author 김재연
	 * @version 2009.08.17
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
     * @author 김재연
     * @version 2009.08.17
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
        var amdt_seq = document.form.amdt_seq.value;
         
        switch(sheetID) {
        
             case "sheet1":
            	 
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 160;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Sel.|Seq.|propno|amdtseq|afilseq|n1stCmncAmdtSeq|Customer code|Customer code|Customer Name|Location|Effective Date|Expiration Date|Source|Status||||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     // 데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
 					 InitDataProperty(0, cnt++, dtHiddenStatus,	30,	 daCenter, false, "ibflag");
 					 InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
                     InitDataProperty(0, cnt++, dtDataSeq,      35,  daCenter, false, "Seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no",  		  	true,  "", dfNone, 	0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  	true,  "", dfNone, 	0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "afil_seq", 		  	true,  "", dfNone, 	0, false, false);	
					 InitDataProperty(0, cnt++, dtHidden,     	40,  daCenter, true,  "n1st_cmnc_amdt_seq",	true,  "", dfNone,  0, false, false);
					 if (amdt_seq == "0"){
						 InitDataProperty(0, cnt++, dtData,     	40,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, true,  true,  2);
	                     InitDataProperty(0, cnt++, dtPopupEdit,   	85,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, true,  true,  6);
					 }else{
						 InitDataProperty(0, cnt++, dtData,     	40,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, false,  true,  2);
	                     InitDataProperty(0, cnt++, dtPopupEdit,   	85,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, false,  true,  6);
					 }                     
                     InitDataProperty(0, cnt++, dtData,     	290, daLeft,   true,  "cust_nm",      	  false, "", dfNone, 	0, false,  false,  100);
                     InitDataProperty(0, cnt++, dtData,     	70,  daCenter, true,  "cust_loc_cd",      false, "", dfNone, 	0, false, false,  5);                     
 					 InitDataProperty(0, cnt++, dtData,   		100,  daCenter, true,  "eff_dt",	  false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   		100,  daCenter, true,  "exp_dt",		      false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		90,  daCenter, false, "src_info_cd",	  false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo, 		90,  daCenter, false, "prc_prog_sts_cd",  false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,   	100,  daCenter, false, "prc_prog_sts_dtl", false, "", dfNone, 	0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_usr_id", 	  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_ofc_cd",      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_dt", 		  false, "", dfDateYmd, 0, false, false);    

					 InitDataProperty(0, cnt++, dtHidden,     	40,  daCenter, true,  "cust_cnt_cd_tmp",      false, "", dfNone,    0, true,  true,  2);
                     InitDataProperty(0, cnt++, dtHidden,   	85,  daCenter, true,  "cust_seq_tmp",      	  false, "", dfNone,    0, true,  true,  6);
                     
	                 InitDataValid(0,  "cust_cnt_cd",	vtEngUpOnly);	// 영문대문자만입력
	                 InitDataValid(0,  "cust_seq",		vtNumericOnly);	// 숫자만입력
	                 InitDataValid(0, "cust_nm", 		vtEngOther,PRI_VALID_CHAR);
	                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "cust_loc_cd",    vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
	 					
 					 ShowButtonImage = 2; 
 					 Ellipsis = true;
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
      * @version 2009.08.17
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH_ASYNC01: // 조회
				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
				break;
				
			case IBINSERT: // Row Add			
				var eff_dt 		 = formObj.eff_dt.value;
				var exp_dt 		 = formObj.exp_dt.value;
				var amdt_seq 	 = formObj.amdt_seq.value;
				
				if (validateForm(sheetObj,document.form,sAction)) {	
				
	 				var idx = sheetObj.DataInsert();
					sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
					sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;		
					sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
					sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
					sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
				
					sheetObj.CellValue2(idx, "afil_seq") = parseInt(ComPriGetMax(sheetObj, "afil_seq")) + 1;
					if(amdt_seq!=0){
						sheetObj.CellEditable(idx, "cust_nm") = true;
						sheetObj.RangeBackColor(idx,10,idx,10) =  sheetObj.RgbColor(255,255,255);
						sheetObj.CellFont("FontColor", idx, "chk", idx, "prc_prog_sts_cd")= sheetObj.RgbColor(255,0,0);
						changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
					}	
					sheetObj.SelectCell(idx, "cust_cnt_cd");
				}
				break;    
					
			case IBDELETE: // Delete
			
				var amdt_seq = formObj.amdt_seq.value;
			
				if(amdt_seq=="0"){	
					if (validateForm(sheetObj,document.form,sAction)) {
						deleteRowCheck(sheetObj, "chk", true);
					}
				}else{
					var eff_dt = formObj.eff_dt.value;
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0){			
						for(i=0;i < chkArr.length;i++){
							if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.CellValue(chkArr[i],"src_info_cd")!="NW"&&sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq)){
								ComShowCodeMessage("PRI01002");
								return;
							}
						}
						var sRow = 0;
						for(j=0;j < chkArr.length;j++){
							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){	
								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","");
								sRow++;
							}
						}
						deleteRowCheck(sheetObj, "chk", true);
					}else{ 
						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq || ( sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")==amdt_seq && sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd")!="NW")){
							ComShowCodeMessage("PRI01002");
							return;
						}
						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
							comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"D","");
						}else{
							sheetObj.CellValue(sheetObj.SelectRow,"chk")=1;
							deleteRowCheck(sheetObj, "chk", true);
						}	
					}					
				}
				break;					
				
			case COMMAND01: // Amend			
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				var columns = "";
				
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						columns = "cust_seq|cust_cnt_cd";
						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", columns);						
					}
				}else{ 			
					columns = "cust_seq|cust_cnt_cd";
					comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", columns);					
				}
				break;	
		
			case COMMAND02: // Amend Cancel
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
				var columns = "";
			
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					}else{
						columns = "cust_seq|cust_cnt_cd";
						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", columns);		
					}
				}else{ 
					columns = "cust_seq|cust_cnt_cd";
					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", columns);
					
				}	
				break;				
			case MODIFY01: // Accept
				if (!ComShowCodeConfirm("PRI00008")) {
					return false;
	            }
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY01;
				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do");
				dialogArguments.comUpdateProposalStatusSummary("05", "");
				rData ="Y";
				ComOpenWait(false);
				break;				
	
			case MODIFY02: // Accept Cancel
				if (!ComShowCodeConfirm("PRI00009")) {
					return false;
	            }
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY02;
				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do");
				dialogArguments.comUpdateProposalStatusSummary("05", "");
				rData ="Y";
				ComOpenWait(false);
				break;						
				
			case IBSEARCH: // 조회
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_2003_06GS.do" , FormQueryString(formObj));
				ComOpenWait(false);
				break;				
			
			case IBSAVE: // 저장
				ComOpenWait(true);
				if (!validateForm(sheetObj,document.form,sAction)) {
					ComOpenWait(false);
					return false;
				}
	            if (!ComPriConfirmSave()) {
	            	ComOpenWait(false);
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
		 		comChangeValue(sheetObj, "ibflag", "R", "amdt_seq", formObj.pre_amdt_seq.value);

 				var sParam = FormQueryString(formObj);
 				var sParamSheet = sheetObj.GetSaveString(); 				 				
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_06GS.do", sParam+"&"+sParamSheet);
 				sheetObj.LoadSaveXml(sXml); 		 		
 				rData ="Y";
 				ComOpenWait(false);
		 		break;
		 		
			case MODIFY05: // Accept All
				if (!ComShowCodeConfirm("PRI01015")){
					return false;
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY03;
				formObj.sts_cd.value = 'A';
				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do", true);
				dialogArguments.comUpdateProposalStatusSummary("05", "");
				rData ="Y";
				ComOpenWait(false);
				break;			
		
			case MODIFY06: // Cancel All
				if (!ComShowCodeConfirm("PRI01010")){
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value = MODIFY04;
				formObj.sts_cd.value = 'I';
				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_06GS.do", true);
				dialogArguments.comUpdateProposalStatusSummary("05", "");
				rData ="Y";
				ComOpenWait(false);
				break;
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
     * @author 김재연
     * @version 2009.05.20
     */ 	   
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var sCols = "";
		searchEndFontChange(sheetObj, sCols);
        columnControl();		
		buttonControl()
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
 	 * @version 2009.08.17
 	 */
  	function validateForm(sheetObj, formObj, sAction) {
  		switch (sAction) {
  		case IBSEARCH: // 조회
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
  				return false;
  			}
			return true;
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
  				if(sheetObj.CellValue(i, "cust_cnt_cd") == "" || sheetObj.CellValue(i, "cust_seq") == ""){
						ComShowCodeMessage("PRI01014", i);
						sheetObj.SelectCell(i,"cust_cnt_cd");
						return false;
				}
  			}
  			
  			//중복처리 - mnl_inp_flg 가 1인 Row는 제외한다.
  			var preIbflag = "";
  			for (var i = 1; i<= sheetObj.RowCount; i++){
  				preIbflag = sheetObj.RowStatus(i);
  				sheetObj.CellValue2(i, "cust_cnt_cd_tmp") = ComTrim(sheetObj.CellValue(i, "cust_cnt_cd"));
	  			sheetObj.CellValue2(i, "cust_seq_tmp") = ComTrim(sheetObj.CellValue(i, "cust_seq"));
	  			
//  				sheetObj.CellValue2(i, "ibflag") = preIbflag;
  				sheetObj.RowStatus(i) = preIbflag;
  			}
  			
			 var rowM = priAmendDupCheck(sheetObj, "cust_cnt_cd_tmp|cust_seq_tmp", formObj.amdt_seq.value)
			 if (rowM >= 0) {
				 ComShowCodeMessage("PRI00303", "Sheet", rowM);
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
  			}
  			return true;
  			break;
  		}
  	}

	/**
     * 버튼 권한 컨트롤 function <br>
     * 버튼을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.08.17
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
				sheetObjects[0].CellEditable(i,"cust_nm") = false;
				sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
			}					
			return;
		}
		
		try{
			switch(sts) { 				
				case 'I':   // Initial	 accept - enabled = false accept all,cancel load excel은 init 일 경우에만 enabled
									
					ComBtnDisable("btn_AcceptAll");
					
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
	
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
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
					}					
					break;
					
				case 'Q':// Requested    save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.

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
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
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
						sheetObjects[0].CellEditable(i,"cust_nm") = false;
						sheetObjects[0].CellEditable(i,"cust_loc_cd") = false;
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
					break;
				case 'C': //  // Cancled approved 와 동일
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
     * 컬럼의 edit 여부를 지정하는  function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *		columnControl
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.08.17
     */       	
    function columnControl(){
    	var mnChk = document.form.mnl_chk.value;
    	var sheetObj = sheetObjects[0];
    	var amdt_seq = document.form.amdt_seq.value;
    	var eff_dt = document.form.eff_dt.value;

		if(amdt_seq == 0){

        	for(i=1 ; i < sheetObj.Rows; i++){
				sheetObj.CellEditable(i,"cust_cnt_cd") = true;
				sheetObj.CellEditable(i,"cust_seq") = true;
				sheetObj.CellEditable(i, "cust_nm") = false;
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
        			sheetObj.CellEditable(i, "cust_cnt_cd") = true;
        			sheetObj.CellEditable(i, "cust_seq") = true;
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
     * @author 김재연
     * @version 2009.08.17
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
     * @author 김재연
     * @version 2009.08.17
     */      
    function mnuInput(sw,Row){ 	
    	
    	var sheetObj = sheetObjects[0];
    	var amdt_seq = document.form.amdt_seq.value;
    	if (amdt_seq == 0 ){
    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
    		sheetObj.CellEditable(Row,"cust_seq") = sw;
    		sheetObj.CellEditable(Row,"cust_nm") = !sw;
    		
    		if (sw==true){
    			sheetObj.RangeBackColor(Row,10,Row,10) = sheetObj.UnEditableColor;
    		}else{
    			sheetObj.RangeBackColor(Row,10,Row,10) = sheetObj.RgbColor(255,255,255);
    		}
    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
    	} else {
    		sheetObj.CellEditable(Row,"cust_cnt_cd") = sw;
    		sheetObj.CellEditable(Row,"cust_seq") = sw;
    		sheetObj.CellEditable(Row,"cust_nm") = true;
    		sheetObj.RangeBackColor(Row,10,Row,10) = sheetObj.RgbColor(255,255,255);
    		sheetObj.CellEditable(Row, "cust_loc_cd") = !sw;
    	}
    }    
    
    /**
 	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.08.17
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
     * @author 김재연
     * @version 2009.08.17
     */  	
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colname = sheetObj.ColSaveName(Col);  
     	var formObj = document.form;
     	
     	switch(colname)
     	{
 	    	case "cust_cnt_cd":
 	    		if (Value.length > 0 && sheetObj.CellValue(Row, "cust_seq") != ""){
 	    			formObj.f_cmd.value = SEARCH01;  
 	    			var param = FormQueryString(formObj)+"&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 					if (arrData != null){
 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2]; 	
 					}else{
 						locationCellClear(sheetObj,Row);
 					}
 	    		}
 	    		break;
 	    		
 	    	case "cust_seq":
 	    		if (Value.length > 0 && sheetObj.CellValue(Row, "cust_cnt_cd") != "" && sheetObj.CellValue(Row, "cust_cnt_cd").length == 2){
 	    			formObj.f_cmd.value = SEARCH01;  
 	    			var param = FormQueryString(formObj)+"&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
 					if (arrData != null){
 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2]; 						
 						// CUST_SEQ 앞에 '0'문자로 채움
         	    		if (Value.length < 6 && Value.length != 0){	 	    		
        	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComTrim(ComLpad(Value, 6, "0"));
        	 	    	}         	    		
 					}else{
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
     * @author 김재연
     * @version 2009.08.17
     */  	      	 
 	function sheet1_OnPopupClick(sheetObj, Row, Col) {
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
       	switch(colName)
       	{
   	    	case "cust_seq":		
 	  	  		var sUrl = "/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+sheetObj.CellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.CellValue(Row, "cust_seq");
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 630, 460, true);
 	  			
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, "cust_cnt_cd") = rtnVal.custCntCd;
 	  				sheetObj.CellValue2(Row, "cust_seq") = rtnVal.custSeq;
 	  				
						// CUST_SEQ 앞에 '0'문자로 채움
     	    		if (rtnVal.custSeq.length < 6 && rtnVal.custSeq.length != 0){	 	    		
    	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComLpad(rtnVal.custSeq, 6, "0");
    	 	    	} 
 	  				
 	  				sheetObj.CellValue2(Row, "cust_nm") = rtnVal.custNm;
 	  				sheetObj.CellValue2(Row, "cust_loc_cd") = rtnVal.LocCd;
 	  			}
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
     * @author 김재연
     * @version 2009.08.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			//ComPriSaveCompleted();
			dialogArguments.comUpdateProposalStatusSummary("05", "");
			changeSheetMemoColor();
		}
	}      
    
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
 		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);  
 	    
 		var formObj = document.form;
 		formObj.hdr_eff_dt.focus();
 		formObj.hdr_exp_dt.focus();
 		
 	    // getManualCheck();
 	    buttonControl();
 	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
     * @author 김재연
     * @version 2009.08.17
     */  	    
  	function locationCellClear(sheetObj,Row){
    	 
    	sheetObj.CellValue2(Row, "cust_seq")= ""; 		
  		sheetObj.CellValue2(Row, "cust_cnt_cd")= "";
  		sheetObj.CellValue2(Row, "cust_nm")= "";
  		sheetObj.CellValue2(Row, "cust_loc_cd")= "";  		
  		sheetObj.SelectCell(Row, "cust_cnt_cd");
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
     * @author 김재연
     * @version 2009.08.17
     */  	    
 	function getManualCheck (){
		var formObj = document.form;		
		formObj.f_cmd.value = SEARCH;		
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003_06GS.do", FormQueryString(formObj));	
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
 	 * @author 김재연
 	 * @version 2009.08.17
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
      
	/* 개발자 작업  끝 */