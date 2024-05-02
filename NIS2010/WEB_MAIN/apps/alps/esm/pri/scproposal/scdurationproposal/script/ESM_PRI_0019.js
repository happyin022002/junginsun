/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0019.js
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
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
     * @class ESM_PRI_0019 : ESM_PRI_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0019() {
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
 //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 var rData ="N";
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
          
//          var sheetObject1 = sheetObjects[0];
//          var sheetObject2 = sheetObjects[1];
          
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
				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
				case "btn_CancelAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
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
  	     //Main sheet에서 호출 할경우 svc_scp_cd로 다시 조회한다(Scope Duration 조회).
 	     var formObj = document.form;
  	     var svcScpCd = formObj.svc_scp.value;

  	     if (svcScpCd != "" && svcScpCd != null &&  svcScpCd !="null" ){//Scope 조회
  		     if (comboObjects[0].GetCount() > 0 ){
    			   //받아온 값으로 초기화
      			 comboObjects[0].Text(svcScpCd);
      			 svc_scp_cd_OnBlur(comboObjects[0])
  		     }
  	     }else{//메인조회
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
                     style.height = 82;

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

                     var HeadTitle = "|sel|propno|amdtseq|Duration|Duration|Effective Date|Expiry Date|Source|Source|Status|Status|||||||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
// 	  				  				  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//  	  				  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
// 	  				  				  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]  
                     InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
 					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "prop_no",  	    true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "amdt_seq", 	    true,  "", dfNone,    0, false, false);                     
                     InitDataProperty(0, cnt++, dtData,    100, daCenter, true,  "ctrt_eff_dt",     false, "", dfDateYmd, 0, false, false);
                     if (amdt_seq == "0"){
                    	 InitDataProperty(0, cnt++, dtData,    100, daCenter, true,  "ctrt_exp_dt", true,  "", dfDateYmd, 0, true, true);
                     }else{
                    	 InitDataProperty(0, cnt++, dtData,    100, daCenter, true,  "ctrt_exp_dt", true,  "", dfDateYmd, 0, false, false);
                     }                     
                     InitDataProperty(0, cnt++, dtData,    110, daCenter, true,  "eff_dt",    		false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtData,    110, daCenter, true,  "exp_dt",   		false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,   80,  daCenter, false, "src_info_cd", 	false, "", dfNone, 	  0, false, false, 100);	
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, true,  "src_info_dtl",    false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,   80,  daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, true,  "prc_prog_sts_dtl",false, "", dfNone, 	  0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_usr_id",     false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_ofc_cd", 	false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_dt", 		false, "", dfDateYmd, 0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "mn_eff_dt", 		false, "", dfDateYmd, 0, false, false);// main eff_Dt
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "mn_exp_dt", 	    false, "", dfDateYmd, 0, false, false);//main exp_dt
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "sp_dur_eff_dt", 	false, "", dfDateYmd, 0, false, false);//duration main eff_dt
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "sp_dur_exp_dt", 	false, "", dfDateYmd, 0, false, false);//duration main exp_Dt
				     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "n1st_cmnc_amdt_seq",false, "", dfNone,  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "dur_dup_flg",     false, "", dfNone, 	  0, false, false);
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
     *     initCombo(comboObj, comboNo);
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
             case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회,콤보setting
 				comboObjects[0].RemoveAll();
 				
 				formObj.f_cmd.value = SEARCH13;
 				var sParam = FormQueryString(formObj) + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;
 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
 				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm"); 						
 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 		        //status
 	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);				

 				break;
 				
             case IBSEARCH:      //조회
             	ComOpenWait(true); //->waiting->start 
             	if (!validateForm(sheetObjects[0],document.form,sAction)) {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}				
 				formObj.f_cmd.value = SEARCH; 				
 				sheetObj.DoSearch("ESM_PRI_0019GS.do", FormQueryString(formObj));
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;

  			 case IBSAVE:        //저장 			
  			 	ComOpenWait(true); //->waiting->start
  			 	var scpName = ComTrim(formObj.svc_scp_nm.value);
  			 	var pRow = getValidRowCount(sheetObj);
  			 	var msgChk = false;// 메세지 표시 여부
  			 	var sParamSheet = sheetObjects[0].GetSaveString();	
  			 	
  			 	if (!sheetObj.IsDataModified && sParamSheet==""){
  			 		ComShowCodeMessage("PRI00301");
  			 		return false;
  			 	}
  			 	if (sParamSheet == ""){
  			 		return false;
  			 	}  			 	 			 	
  			 	var pRow = sheetObj.RowCount;//eff_dt
  			 	if (sheetObj.CellValue(pRow, "ctrt_exp_dt") < sheetObj.CellValue(pRow, "eff_dt") ){
  			 		ComShowCodeMessage("PRI01104");
  			 		return false;
  			 	}  			 	
 	             if ( !ComPriConfirmSave()) {
 	                 return false;
 	             }  			 	

  			 	var sParam = "";
  			 	var sXml = "";
  			 	var scpSave ="";
  			 	//메인일경우에만
  			 	if (scpName == "" ){
  			 		if (formObj.amend_flg.value !="N"){ //amend 일 경우 	 			 		
  			 			var scpCnt = 0;
  			 			scpCnt = checkAllSave();  			 			
  			 			if (scpCnt!= 1){// scope이 여러개 일 경우
  			 				formObj.f_cmd.value = SEARCH01;
  	  	 			 		sParam = FormQueryString(formObj)+"&ctrt_exp_dt="+sheetObj.CellValue(sheetObj.RowCount,"ctrt_exp_dt");
  	  	 					if ( pRow == "2"){//Duration PopUp화면에서 수정은 항상 2줄임
  	  	 	 					sXml = sheetObj.GetSearchXml("ESM_PRI_0019GS.do", sParam);				
  	  	 	 					var arrData = ComPriXml2Array(sXml, "chk_dur");
  	  	 	 					if (arrData != null && arrData.length > 0) {
  	  	 	 						if (arrData.length == 2){
  	  	 	 							//scope duration을 자동으로 자를 경우 사용자가 취소를 하면 모든 저장취소.
  	  	 	 							if (!ComShowCodeConfirm("PRI01109")){
  	  	 	 								ComShowCodeMessage("PRI01026");
  	  	 	 								return ;
  	  	 	 							}else{//scope 같이 저장
  	  	 	 								scpSave ="&scp_save=true";
  	  	 	 							}
  	  	 	 						}else{
  	  	 	 							//scope duration을 자동으로 자를 경우 사용자가 취소를 하면 모든 저장취소.
  	  	 	 							if (arrData[0]=="DECREASE"){
  	  	 	 								if (!ComShowCodeConfirm("PRI01109")){
  	  	 	 	 								ComShowCodeMessage("PRI01026");
  	  	 	 	 								return ;
  	  	 	 								} 								
  	  	 	 								scpSave ="&scp_save=true";
  	  	 	 							}else{
  	  	 	 								if (!ComShowCodeConfirm("PRI01109")){
  	  	 	 									//scope duration을 자동으로 늘릴 경우 사용자가 취소를 하면
  	  	 	 									//Main duration만 늘린다.
  	  	 	 									scpSave ="&scp_save=false";
  	  	 	 									msgChk = true;	
  	  	 	 								}else{ 	 	 								
  	  	 	 									scpSave ="&scp_save=true";
  	  	 	 								}
  	  	 	 							}						
  	  	 	 						}
  	  	 	 					} 	
  	  	 					}
  			 			}else{// scope이 하나일 경우
  			 				if (formObj.save_all.value == "Y"){//Main,Scope같은 값으로 저장된다.
  			 					scpSave ="&scp_save=true";	
  			 				}else{  			 					  			 					
  			  		           //Main exp_dt 변경 값이 scope보다 작은지 check
  			 				   var scpEffDur = "";
  			  		           var scpExpDur = "";
  			  		           formObj.f_cmd.value = SEARCH06;
  			  	               sParam = FormQueryString(formObj);            
  			  	               sXml = sheetObj.GetSearchXml("ESM_PRI_0019GS.do" , sParam);  			  	            
  			  	               arrData = ComPriXml2Array(sXml, "etc1|etc2");
  			  	               if (arrData != null && arrData.length > 0) {
  			  	            	   scpEffDur = arrData[0][0];
  			  	            	   scpExpDur = arrData[0][1];  			   	            	   
  			  				 		if ((sheetObj.CellValue(sheetObj.RowCount,"ctrt_exp_dt") < scpExpDur)){
//  			  	 					ComShowCodeMessage("PRI01003",ComGetMaskedValue(scpEffDur,"ymd","-"),ComGetMaskedValue(scpExpDur,"ymd","-"),"Scope");
  			  				 			ComShowCodeMessage("PRI01026");	
  			  	 						return false;
  			  	 					}            	          	 
  			  	               }else{
  			  	            	   return false;
  			  	               }  			 					
  			 				}  			 				
  			 			}
  			 		}

  			 	}else{//scope저장
  			 		checkAllSave();
  			 		if ((sheetObj.CellValue(pRow,"ctrt_exp_dt") > sheetObj.CellValue(pRow,"sp_dur_exp_dt"))
  			 				&& formObj.save_all.value != "Y" ){
 						ComShowCodeMessage("PRI01003",ComGetMaskedValue(sheetObj.CellValue(pRow,"sp_dur_eff_dt"),"ymd","-"),ComGetMaskedValue(sheetObj.CellValue(pRow,"sp_dur_exp_dt"),"ymd","-"),"S/C");
 						return false;
 					}

  		           var mnEffDur = "";
  		           var mnExpDur = "";
  		           formObj.f_cmd.value = SEARCH05;
  	               sParam = FormQueryString(formObj);            
  	               sXml = sheetObj.GetSearchXml("ESM_PRI_0019GS.do" , sParam);            
  	            
  	               arrData = ComPriXml2Array(sXml, "etc1|etc2");
  	               if (arrData != null && arrData.length > 0) {
  	            	   mnEffDur = arrData[0][0];
  	            	   mnExpDur = arrData[0][1];
   	            	   
  				 		if ((sheetObj.CellValue(sheetObj.RowCount,"ctrt_exp_dt") > mnExpDur)
  				 				&& formObj.save_all.value != "Y" ){
  	 						ComShowCodeMessage("PRI01003",ComGetMaskedValue(mnEffDur,"ymd","-"),ComGetMaskedValue(mnExpDur,"ymd","-"),"S/C");
  	 						return false;
  	 					}            	          	 
  	               } 				
 					scpSave ="&scp_save=expchange";//scope 만 저장시 
  			 	}

				formObj.f_cmd.value = MULTI;
				sParam = FormQueryString(formObj)+ scpSave;
				sParamSheet = sheetObjects[0].GetSaveString();
				 
  				sXml = sheetObj.GetSaveXml("ESM_PRI_0019GS.do", sParam + "&" + sParamSheet); 				
  				if (msgChk == true && scpName ==""){
    				ComShowCodeMessage("PRI01077");
    			}
  				sheetObj.LoadSaveXml(sXml); 	
         		formObj.amend_flg.value ="";	
         		formObj.save_all.value = "";  
 				ComOpenWait(false); //->waiting->End
                  break;
  			 case MODIFY01:        //accept
  			 	ComOpenWait(true); //->waiting->start
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value = MODIFY01;
 				 
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0019GS.do");
 				ComOpenWait(false); //->waiting->End
 				break;		
 				
  			 case MODIFY02:        //accept cancel
  			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            } 			 
 				formObj.f_cmd.value = MODIFY02; 				
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0019GS.do");
 				ComOpenWait(false); //->waiting->End
 				break;  			 
  			 case MODIFY03:        //amend
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1"); 				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						sheetAmendRow(sheetObj,formObj,chkArr[0],"M", "ctrt_exp_dt");						
 					}
 				}else{ 		
 					sheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", "ctrt_exp_dt"); 				
 				}
  			    sheetObj.SelectCell(2,"ctrt_exp_dt");
  			    formObj.amend_flg.value = "Y";//checkAllSave()에서 사용
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
  			case MODIFY05: // Accept All
  				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}	
 				formObj.f_cmd.value = MODIFY05;
 				formObj.sts_cd.value = 'A';
 				var sParam = FormQueryString(formObj);
 				
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0019GS.do", sParam);
 				sheetObj.LoadSaveXml(sXml);			
 				if(ComGetEtcData(sXml,"rValue") > 0){//Accept Data가 있다면 화면상의 데이터를 Accept 로 변경함
 					changeAcceptStatus(sheetObj,"A");
 				}
 				ComOpenWait(false); //->waiting->End
 				break; 			
  			
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}			 			
 				formObj.f_cmd.value = MODIFY06;
 				formObj.sts_cd.value = 'I';
 				var sParam = FormQueryString(formObj); 				 
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0019GS.do", sParam);
 				sheetObj.LoadSaveXml(sXml);			
 				if(ComGetEtcData(sXml,"rValue") > 0){
 					changeAcceptStatus(sheetObj,"I");
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
	  				
	  				if (sheetObj.SelectRow == 2){//메인 amend cancel시 scope에 amend 데이터가 있을 경우 amend cancel못함
		  				document.form.f_cmd.value = SEARCH02;
			  		    var sParam = FormQueryString(document.form);
			  		    var sParamSheet = sheetObjects[0].GetSaveString(true);
			  		    var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0019GS.do", sParam+"&"+sParamSheet);
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
       * 콤보의 SVC Scope명칭을 INPUT BOX에 채우고 조회를 한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *		svc_scp_cd_OnChange(comboObj, code, text);
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
		var maxRow = sheetObj.RowCount;
		
		//main eff_dt,exp_dt를 setting
		if (sheetObj.RowCount > 0){
			formObj.eff_dt.value = sheetObj.CellValue(maxRow,"mn_eff_dt");
			formObj.exp_dt.value = sheetObj.CellValue(maxRow,"mn_exp_dt");
			formObj.pre_exp_dt.value = ComGetDateAdd(sheetObj.CellValue(maxRow,"mn_eff_dt"), "D", -1);
			formObj.dur_dup_flg.value =  sheetObj.CellValue(maxRow,"dur_dup_flg");
		}		
		
        var sCols = "ctrt_exp_dt";
        searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value);
        formObj.amend_flg.value ="";
 		formObj.save_all.value = ""; 
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
//    		 if (sheetObj.EtcData("accept")== "all"){
//    			 if (sheetObj.EtcData("rValue") > 0){
//    				 updateProposalStatusSummaryAcceptAll();
//        			 rData ="Y";
//    			 }
//    		 }else{
//        		 updateProposalStatusSummary();
    			 rData ="Y";
//    		 }
    			 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
      * @author 문동규
      * @version 2009.04.17
      */         
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         if (OldRow != NewRow) {
             changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
   	    		break; 
       	}
 	}        
     
    
//	/**
//    * parent화면에 있는 함수를 호출한다. <br>
//    * 데이터에 수정이 발생한 경우 parent화면의 함수를 호출하여  해당 Terms의 Summary테이블을 수정한다. <br>
//    * <br><b>Example :</b>
//    * <pre>
//    * 		updateProposalStatusSummary()
//    * </pre>
//    * @param 없음
//    * @return 없음
//    * @author 공백진
//    * @version 2009.04.17
//    */ 
//	function updateProposalStatusSummary(){
//		 var scpCd = ComTrim(comboObjects[0].Code);
//		 if (scpCd ==""){
//			 dialogArguments.comUpdateProposalStatusSummary("01", "");
//		 }else{
//			 dialogArguments.comUpdateProposalStatusSummary("11", scpCd);
//		 }
//	}
	
//	/**
//    * parent화면에 있는 함수를 호출한다. <br>
//    * Accept All,Accept Cancel All의 경우 parent화면의 함수를 호출하여  해당 Terms의 Summary테이블을 수정한다. <br>
//    * <br><b>Example :</b>
//    * <pre>
//    * 		updateProposalStatusSummaryAcceptAll()
//    * </pre>
//    * @param 없음
//    * @return 없음
//    * @author 공백진
//    * @version 2009.04.17
//    */ 
//	function updateProposalStatusSummaryAcceptAll(){
//		var combo = comboObjects[0];
//		for (var i = 1; i < combo.GetCount();i++){
//			dialogArguments.comUpdateProposalStatusSummary("11", combo.GetIndexText(i,0));						
//		}	
//		dialogArguments.comUpdateProposalStatusSummary("01", "");
//	}      
 
    
  	
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
	
			if (apro_usr_flg == "false" && req_usr_flg == "false"){
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Amend");
				ComBtnDisable("btn_AmendCancel");
				ComBtnDisable("btn_Accept");
				ComBtnDisable("btn_AcceptCancel");
				ComBtnDisable("btn_AcceptAll");
				ComBtnDisable("btn_CancelAll"); 
				for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
					sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
				}				
				return;
			}
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
			} else {
				showButton("btn_Amend");
				showButton("btn_AmendCancel");	
			}

			try{
				switch(sts) { 				
					case 'I':   // Initial	
						ComBtnDisable("btn_AcceptAll");					
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd") == "I"){
								sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = true;	
							}else{
								sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
							}
						}
						
						break;
					case 'A': // Approved 모두금지, 조회,downexcel은 가능
						ComBtnDisable("btn_Save");

						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}
						break;
						
					case 'Q':// Requested   save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.
						
						ComBtnDisable("btn_Save");
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
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}						
			
						break;
				
					case 'R':  // Returned
						ComBtnDisable("btn_Save");

						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");	
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");						
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_CancelAll");						
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
						}

						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}

						break;
					case 'F': // Filed
						ComBtnDisable("btn_Save");

						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}

						break;
					case 'C': //  // Cancled
						ComBtnDisable("btn_Save");
						
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"ctrt_exp_dt") = false;
						}
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
     * Main Duration  exp_dt가 Scope의 exp_dt보다 작은지 검사한다.  <br>
     * Return 값이 Y일 경우 저장할 수 없다.
     * <br><b>Example :</b>
     * <pre>
     *         checkScopeDuration
     * </pre>
     * @param 없음
     * @return {string} <br>
     *                   Y : Main Duration  exp_dt가 Scope의 exp_dt보다 작다
     *                   N : Main Duration  exp_dt가 Scope의 exp_dt보다 크다
     * @author 공백진
     * @version 2009.04.17
     */    
    function checkScopeDuration(){
       document.form.f_cmd.value = SEARCH03;
       var rMsg = "";
       var rValue = "Y"; //저장금지
       var sParam = FormQueryString(document.form);
       var sParamSheet = sheetObjects[0].GetSaveString();
       
       var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0019GS.do",  sParam+"&"+sParamSheet);
       var arrData = ComPriXml2Array(sXml, "cnt");
       
       if (arrData != null && arrData.length > 0) {
           if (arrData[0][0] == "0"){
               rValue = "N";
           } 
       }
       if (rValue =="Y"){
           ComShowCodeMessage("PRI01083");
       }
       return rValue;
    }     
     
     
     /**
      * 대상 ROW 를 Amend 처리한다. <br>
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object
      * sRow        : 처리 대상 Row
      * sAction     : M : Update Amend, D : Delete Amend
      * sCols       : eff_dt, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
      *          ex) sheetAmendRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
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
         //backcolor change
         changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         return true;
     }

    /**
     * 대상 ROW 를 Amend Cancel 처리한다.
     * sheetObj    : 처리 대상 sheet object
     * formObj     : 처리 대상 form object
     * sRow        : 처리 대상 Row
     * sAction     : A : Insert Amend, M : Update Amend, D : Delete Amend
     * sCols       : eff_dt, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
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

         //  A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
         if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq || sheetObj.CellValue(sRow,"prc_prog_sts_cd")!= "I"){
             ComShowCodeMessage("PRI00313");
             return false;
         }         

         var idx  = sRow-1;
         var idx2 = sRow;
     
         if(sAction=="A"&&(sheetObj.CellValue(sRow,"src_info_cd")=="NW"||sheetObj.CellValue(sRow,"src_info_cd")=="GM"||sheetObj.CellValue(sRow,"src_info_cd")=="GC")){
        	 sheetObj.RowStatus(sRow)="D";
             sheetObj.RowEditable(sRow)=false;
             sheetObj.RowHidden(sRow) = true;        
             return false;
         }else{
             if(sheetObj.CellValue(sRow,"src_info_cd")!="AD"&&sheetObj.CellValue(sRow,"src_info_cd")!="AM"){
                 ComShowCodeMessage("PRI00313");
                 return false;
             }
   
             sheetObj.CellValue2(idx,"exp_dt")=sheetObj.CellValue(idx,"ctrt_exp_dt");
             sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol)=false;
             sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol)=false;
             sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
             sheetObj.CellValue2(idx2,"amdt_seq")= pre_amdt_seq;
             sheetObj.RowEditable(idx) = true;
             sheetObj.SelectCell(idx,"chk");
             sheetObj.RowStatus(idx) = "U";
             sheetObj.RowDelete(idx2, false);
         }

         return true;
     }     
         
         
     /**
      * 대상 ROW 를 Accept or Initial 처리한다. <br>
      * Accept, Accept Cancel 하여 DB 가 변경된 후 sheet의 데이터를 변경한다. <br>
      * sheetObj    : 처리 대상 sheet object
      * type   		: A : Accept , I : Initial
      *           ex) changeAcceptStatus(sheetObjects[1],"A");
      * @author 공백진
      * @version 2009.05.29
      */         
     function changeAcceptStatus(sheetObj,type){
    	 var formObj = document.form;
    	 var amdtSeq = formObj.amdt_seq.value;
    	 var stsCd = "";
    	 var stsDtl = "";
    	 if (type == "A"){
    		 stsCd = "A";
    		 stsDtl = "Accepted"
    	 }else{
    		 stsCd = "I";
    		 stsDtl = "Initial"
    	 }
    	 for (var i = 1; i <=2; i++){
    		 if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.CellValue(i, "prc_prog_sts_cd") != stsCd ){
    			 sheetObj.CellValue(i, "prc_prog_sts_cd") = stsCd;
    			 sheetObj.CellValue(i, "prc_prog_sts_dtl") = stsDtl;
    		 }
    	 }
     }
      
      /**
       * 저장시 Scope 의 갯 수를 조회한다.<br>
       * Scope이 한 개 일 경우 Scope 저장 시 사용자에게 Main을 같이 저장할 지 확인한다.<br> 
       * <br><b>Example :</b>
       * <pre>
       *		checkAllSave();
       * </pre>
       * @param  없음
       * @author 공백진
       * @version 2009.05.07
       */  
      function checkAllSave(){
          var formObj = document.form;
          var sheetObj = sheetObjects[0];
          
          if (formObj.amend_flg.value == "N"){//AMEND CANCEL 시 체크 안함
        	  return;
          }
          formObj.f_cmd.value = SEARCH04;
          
          try{
              var sParam = FormQueryString(formObj);            
              var sXml = sheetObj.GetSearchXml("ESM_PRI_0019GS.do" , sParam);            
           
              var arrData = ComPriXml2Array(sXml, "etc1");
              if (arrData != null && arrData.length > 0) {
                  var cnt = 0;
                  cnt = ComParseInt(arrData[0][0]); 
                  formObj.save_all.value = "N"; 
             	  if (cnt == 1 ){
             		 if (ComShowCodeConfirm("PRI01025")){
 						formObj.save_all.value = "Y"; 						
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
          		return cnt;
          }       
                  
      }        
           
     
      
      

	/* 개발자 작업  끝 */