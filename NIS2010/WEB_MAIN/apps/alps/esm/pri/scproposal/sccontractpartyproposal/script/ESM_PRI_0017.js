/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0017.js
*@FileTitle : Customer Type Amend Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.21 공백진
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
     * @class ESM_PRI_0017 : ESM_PRI_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0017() {
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
 //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 var rData = "";
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
          var sheetObject = sheetObjects[0];

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

         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         buttonControl(); 
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
         var sheetID = sheetObj.id; 
         var amdt_seq = document.form.amdt_seq.value;
         
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 80;
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
                     var HeadTitle = "|sel|propno|amdtseq|ptytpcd|Customer Type|EFF Date|EXP Date|Source|Source|Status|Status||||";
                     
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//		  				  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  			  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//		  				  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]  
				    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				    InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	          true,  "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	          true,  "", dfNone,    0, false, false);  
					InitDataProperty(0, cnt++, dtHidden, 70,  daCenter, false, "prc_ctrt_pty_tp_cd",  true,  "", dfNone,    0, false, false);
					if (amdt_seq == "0"){
						InitDataProperty(0, cnt++, dtCombo, 140, daCenter, false, "prc_ctrt_cust_tp_cd", true, "", dfNone, 0, true, true);
					}else{
						InitDataProperty(0, cnt++, dtCombo, 140, daCenter, false, "prc_ctrt_cust_tp_cd", true, "", dfNone, 0, false, false);
					}
				    InitDataProperty(0, cnt++, dtData,   95,  daCenter, true,  "eff_dt",        	  false, "", dfDateYmd, 0, false, false);
				    InitDataProperty(0, cnt++, dtData,   95,  daCenter, true,  "exp_dt",   		      false, "", dfDateYmd, 0, false, false);
				    InitDataProperty(0, cnt++, dtCombo,  100, daCenter, false, "src_info_cd", 		  false, "", dfNone, 	0, false, false);	
				    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true,  "src_info_dtl",     	  false, "", dfNone, 	0, false, false);
				    InitDataProperty(0, cnt++, dtCombo,  100, daCenter, false, "prc_prog_sts_cd", 	  false, "", dfNone, 	0, false, false);
				    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, true,  "prc_prog_sts_dtl", 	  false, "", dfNone, 	0, false, false);				    
				    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 		  false, "", dfNone, 	0, false, false);
				    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd", 		  false, "", dfNone, 	0, false, false);
				    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_dt", 			  false, "", dfDateYmd, 0, false, false);
                    InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq",  false, "", dfNone, 	0, false, false);
				    ColHidden("chk") = true;
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
 	 		 case IBSEARCH_ASYNC10://콤보 setting
 	 			
 		        //srcInfocd		        
 	 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 		        //status
 	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
 		        //cust type cd		        
 	 			sheetObj.InitDataCombo(0,"prc_ctrt_cust_tp_cd", custTpCdText, custTpCdValue);
 				break;
 	 		case IBSEARCH:      //조회	 		
 	 			ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}				
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_PRI_0017GS.do", FormQueryString(formObj));
 				ComOpenWait(false); //->waiting->End
 				break;

 			 case IBSAVE:        //저장
 			 	ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					return false;
 				}
 	             if (!sheetObjects[0].IsDataModified) {
 	                 ComShowCodeMessage("PRI00301");
 	                 return false;
 	             }
 	             if (!ComPriConfirmSave()) {
 	                 return false;
 	             }

 				formObj.f_cmd.value = MULTI;
 				
  				var sParam = FormQueryString(formObj);
  				var sParamSheet = sheetObj.GetSaveString(); 				 				
  				if (!sheetObj.IsDataModified && sParamSheet == "") {
  					ComShowCodeMessage("PRI00301");
  					return;
  				}	 			 	
  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0017GS.do", sParam+"&"+sParamSheet);
  				sheetObj.LoadSaveXml(sXml); 		
 				ComOpenWait(false); //->waiting->End
 				break;
 			 case MODIFY01:        //accept
 			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }			 
 			 	formObj.f_cmd.value = MODIFY01;
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0017GS.do");
 				ComOpenWait(false); //->waiting->End
 				break;				
 			 case MODIFY02:        //accept cancel
 			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }			 
 			 	formObj.f_cmd.value = MODIFY02;
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0017GS.do");

 				ComOpenWait(false); //->waiting->End
 				break;		 

 			 case MODIFY03:        //amend
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", "prc_ctrt_cust_tp_cd");						
 					}
 				}else{ 					
 					comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", "prc_ctrt_cust_tp_cd");					
 				}
 			 	sheetObj.SelectCell(2, "prc_ctrt_cust_tp_cd");
 				break;				 
 			 	
 			 case MODIFY04:        //amend cancel
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "prc_ctrt_cust_tp_cd");		
 					}
 				}else{ 
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "prc_ctrt_cust_tp_cd");
 					
 				}	
 				break;		
          }//end switch
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

    	var sCols = "prc_ctrt_cust_tp_cd";
    	searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 
		buttonControl();
	}	
     
     /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Customer Type이 변경되었다면 메세지를 보여준다. <br>
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
         var parentSheet= window.dialogArguments.sheetObjects[0];
         
         switch(colName)
         {
             case "prc_ctrt_cust_tp_cd":
  				if (!getValidRowCount(sheetObj) < 2){
  		        	if (parentSheet.CellValue(1, "ori_real_cust_cd") !="" 
  		        		&& parentSheet.CellValue(1, "ori_real_cust_seq") != "" 
  		        			&& window.dialogArguments.document.form.prop_no.value != "" ){
  		        		ComShowCodeMessage("PRI01079");
  		        		sheetObj.CellValue2(Row,Col) = "N";
  		        		return;
  		        	}  					
  					
  					if (checkCustomerType() == 'Y'){
  						ComShowCodeMessage('PRI01111');
	  	            }
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
     * @author 공백진
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			dialogArguments.comUpdateProposalStatusSummary("07", "");
//			rData = sheetObjects[0].CellValue(sheetObjects[0].RowCount,"prc_ctrt_cust_tp_cd");
			rData ="Y";
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
   			var reqUsrFlg = formObj.req_usr_flg.value;
   			var aproUsrFlg = formObj.apro_usr_flg.value;
   			var amdt_seq =  formObj.amdt_seq.value;
   			var sts = formObj.prop_sts_cd.value;
   			
			if(amdt_seq == 0) {
   				hiddenButton("btn_Amend");
   				hiddenButton("btn_AmendCancel");
   			} else {
   				showButton("btn_Amend");
   				showButton("btn_AmendCancel");	
   			}	
   			if (aproUsrFlg == "false" && reqUsrFlg == "false"){
   				ComBtnDisable("btn_Save");
   				ComBtnDisable("btn_Amend");
   				ComBtnDisable("btn_AmendCancel");
   				ComBtnDisable("btn_Accept");
   				ComBtnDisable("btn_AcceptCancel");
				for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
					sheetObjects[0].CellEditable(i,"prc_ctrt_cust_tp_cd") = false;
				}	
   				return;
   			}
   			
   			try{
   				switch(sts) { 				
   					case 'I':   // Initial										
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");
   						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
   							if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd")=="I"){
   								sheetObjects[0].CellEditable(i,"prc_ctrt_cust_tp_cd") = true;	
   							}else{
   								sheetObjects[0].CellEditable(i,"prc_ctrt_cust_tp_cd") = false;
   							}
   						}	
   						break;
   					case 'A': // Approved 모두금지, 조회,downexcel은 가능
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");   					
   						break;   						
   					case 'Q':// Requested   save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.   						
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");
   						if (aproUsrFlg == "true"){
   							ComBtnEnable("btn_Accept");
   							ComBtnEnable("btn_AcceptCancel");
   						}else{
   							ComBtnDisable("btn_Accept");
   							ComBtnDisable("btn_AcceptCancel");							
   						}
   						
   						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
   							sheetObjects[0].CellEditable(i,"prc_ctrt_cust_tp_cd") = false;
   						}						
   			
   						break;
   				
   					case 'R':  // Returned
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						if(reqUsrFlg == "true"){
   							ComBtnDisable("btn_Accept");
   							ComBtnDisable("btn_AcceptCancel");
   						}   						
   						if (aproUsrFlg == "true"){
   							ComBtnEnable("btn_Accept");
   							ComBtnEnable("btn_AcceptCancel");
   						}
   						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
   							sheetObjects[0].CellEditable(i,"prc_ctrt_cust_tp_cd") = false;
   						}

   						break;
   					case 'F': // Filed
   						ComBtnDisable("btn_Save");
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");

   						break;
   					case 'C': //  // Cancled
   						ComBtnDisable("btn_Save");   						
   						ComBtnDisable("btn_Amend");
   						ComBtnDisable("btn_AmendCancel");   						
   						ComBtnDisable("btn_Accept");
   						ComBtnDisable("btn_AcceptCancel");
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
 * Customer Type이 변경되었는지 확인한다. <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *     checkCustomerType();
 * </pre>
 * @returns string <br>
 *          Y  : Customer Type이 변경됨<br>
 *          N  : Customer Type이 변경 되지 않았음
 * @author 공백진
 * @version 2009.04.17
 */    
 function checkCustomerType(){
     var formObj = document.form;
     var sheetObj = sheetObjects[0];
     var rValue = "N";
     
     var custTpOri = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");
     if (custTpOri != sheetObj.CellValue(2, "prc_ctrt_cust_tp_cd")){        	
     	rValue ="Y"
     }
     return rValue;     
 }           
 
 

	/* 개발자 작업  끝 */