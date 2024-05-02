/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2119_06.js
*@FileTitle : RFA Proposal Inquiry - Affiliate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.19 공백진
* 1.0 Creation
=========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
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
     * @class ESM_PRI_2119_06 : ESM_PRI_2119_06 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2119_06() {
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
 				case "btn_Close":
 					window.returnValue = rData;
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
   		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);        

		
  	  var formObj = document.form; 

	  if (formObj.cond_prop_no.value !="" && formObj.cond_prop_no.value != "null" ){
		  formObj.f_cmd.value = SEARCH02;

			formObj.prop_no.value = formObj.cond_prop_no.value;
			formObj.cond_prop_no.value = "";
			var param = FormQueryString(formObj);
		 	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2019_06GS.do" , param);
			if (ComGetEtcData(sXml,"rfa_no") != undefined){
				formObj.rfaNo.value =  ComGetEtcData(sXml,"rfa_no");
			} 			 	
			if (ComGetEtcData(sXml,"amdt_seq") != undefined){
				formObj.amdt_seq.value =  ComGetEtcData(sXml,"amdt_seq");
			}	
			if (ComGetEtcData(sXml,"ctrt_eff_dt") != undefined){
				formObj.hdr_eff_dt.value =  ComGetEtcData(sXml,"ctrt_eff_dt");
			}
			if (ComGetEtcData(sXml,"ctrt_exp_dt") != undefined){
				formObj.hdr_exp_dt.value =  ComGetEtcData(sXml,"ctrt_exp_dt");
			}	
	  }else{//2019에서 호출
		   if (formObj.hdr_eff_dt.value !="" && formObj.hdr_eff_dt.value != "null"){
			   formObj.hdr_eff_dt.focus();
		   }
		   if (formObj.hdr_exp_dt.value !="" && formObj.hdr_exp_dt.value != "null"){
			   formObj.hdr_exp_dt.focus();
		   }     			 
	  }    	  
	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 		
		
		
	}
      
//      /**
//      * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
//      * <br><b>Example :</b>
//      * <pre>
//      *    
//      * </pre>
//      * @param {ibsheet} sheetObj 필수 IBSheet Object
//      * @return 없음
//      * @author 공백진
//      * @version 2009.04.17
//      */      
//     function sheet1_OnLoadFinish(sheetObj) {   
//    	  var formObj = document.form; 
//    	  if (formObj.cond_prop_no.value !="" && formObj.cond_prop_no.value != "null" ){
//    		  formObj.f_cmd.value = SEARCH02;
//				formObj.prop_no.value = formObj.cond_prop_no.value;
//				formObj.cond_prop_no.value = "";
//				var param = FormQueryString(formObj);
//			 	var sXml = sheetObj.GetSearchXml("ESM_PRI_2019_06GS.do" , param);
//				if (ComGetEtcData(sXml,"rfa_no") != undefined){
//					formObj.rfaNo.value =  ComGetEtcData(sXml,"rfa_no");
//				} 			 	
//				if (ComGetEtcData(sXml,"amdt_seq") != undefined){
//					formObj.amdt_seq.value =  ComGetEtcData(sXml,"amdt_seq");
//				}	
//				if (ComGetEtcData(sXml,"ctrt_eff_dt") != undefined){
//					formObj.hdr_eff_dt.value =  ComGetEtcData(sXml,"ctrt_eff_dt");
//				}
//				if (ComGetEtcData(sXml,"ctrt_exp_dt") != undefined){
//					formObj.hdr_exp_dt.value =  ComGetEtcData(sXml,"ctrt_exp_dt");
//				}	
//    	  }else{
//    		   if (formObj.hdr_eff_dt.value !="" && formObj.hdr_eff_dt.value != "null"){
//    			   formObj.hdr_eff_dt.focus();
//    		   }
//    		   if (formObj.hdr_exp_dt.value !="" && formObj.hdr_exp_dt.value != "null"){
//    			   formObj.hdr_exp_dt.focus();
//    		   }     			 
//    	  }    	  
//    	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
//     }          

      

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
		case "float":
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
			break;
		}
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
	    var srcName = event.srcElement.getAttribute("name");
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
         var sheetID = sheetObj.id;
//         var amdt_seq = document.form.amdt_seq.value;
         
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 160;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Sel.|propno|amdtseq|afilseq|n1stCmncAmdtSeq|Customer code|Customer code|Customer Name|Location|Effective Date|Expiration Date|Source|Status|Accept Staff/Team|Accept Date|acpt_usr_id";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX] 
 					 InitDataProperty(0, cnt++, dtHiddenStatus,	30,	 daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++, dtSeq,          35,  daCenter, false, "Seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no",  		  false, "", dfNone, 	0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  false, "", dfNone, 	0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "afil_seq", 		  false, "", dfNone, 	0, false, false);	
					 InitDataProperty(0, cnt++, dtHidden,     	40,  daCenter, true,  "n1st_cmnc_amdt_seq",	false, "", dfNone,  0, false, false);	
					 InitDataProperty(0, cnt++, dtData,     	40,  daCenter, true,  "cust_cnt_cd",      false, "", dfNone,    0, false,  false);
                     InitDataProperty(0, cnt++, dtData,   	    60,  daCenter, true,  "cust_seq",      	  false, "", dfNone,    0, false,  false);					                    
                     InitDataProperty(0, cnt++, dtData,     	210, daLeft,   true,  "cust_nm",      	  false, "", dfNone, 	0, false,  false);
//                     InitDataProperty(0, cnt++, dtData,     	220, daLeft,   true,  "cust_addr",        false, "", dfNone, 	0, false,  false);
                     InitDataProperty(0, cnt++, dtData,     	70,  daCenter, true,  "cust_loc_cd",      false, "", dfNone, 	0, false, false);                     
 					 InitDataProperty(0, cnt++, dtData,   		100, daCenter, true,  "eff_dt",	  	  	  false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   		100, daCenter, true,  "exp_dt",		  	  false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtData, 		70,  daCenter, false, "src_info_dtl",	  false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtData,   		70,  daCenter, false, "prc_prog_sts_dtl", false, "", dfNone, 	0, false, false);                     
                     InitDataProperty(0 ,cnt++, dtData,			120, daLeft  , false, "acpt_usr_nm"      ,false, "", dfNone,    0, false,false);
                     InitDataProperty(0 ,cnt++, dtData,			80,  daCenter, false, "acpt_dt"          ,false, "", dfDateYmd, 0, false,false);
                     InitDataProperty(0 ,cnt++, dtHidden,		120, daCenter, false, "acpt_usr_id"      ,false, "", dfNone,    0, false,false);
                     //ACPT_USR_ID
 					 ShowButtonImage = 2; 
 					 Ellipsis = true;
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
	 			case IBSEARCH: // 조회
	 				ComOpenWait(true); //->waiting->start
	 				if (!validateForm(sheetObj,formObj,sAction)) {
	 					ComShowCodeMessage("PRI01021");
	 					return;
	 				}
	 				formObj.f_cmd.value = SEARCH01;
	 				sheetObj.DoSearch("ESM_PRI_2019_06GS.do" , FormQueryString(formObj));
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
         	ComOpenWait(false); //->waiting->End
         }

     }


      

//    /**
//     * OnChange 이벤트 발생시 호출되는 function <br>
//     *  <br>
//     * <br><b>Example :</b>
//     * <pre>
//     *
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 IBSheet Object
//     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
//     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
//     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
//     * @return 없음
//     * @author 공백진
//     * @version 2009.04.17
//     */    
//     function sheet1_OnChange(sheetObj, Row, Col, Value)
//     {
//     	var colname = sheetObj.ColSaveName(Col);  
//     	var formObj = document.form;
//
//     	switch(colname)
//     	{
//
// 	    	case "cust_cnt_cd":
// 	    		if (Value.length > 0 && sheetObj.CellValue(Row, "cust_seq") != ""){
// 	    			formObj.f_cmd.value = SEARCH01;  
// 	    			var param = FormQueryString(formObj)+"&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
// 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
//   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
// 					if (arrData != null){
// 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
// 						sheetObj.CellValue2(Row,"cust_addr") = arrData[0][1];
// 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2]; 	
// 					}else{
// 						//ComShowCodeMessage("PRI00315");
//// 						locationCellClear(sheetObj,Row);
// 					}
// 	    		}
// 	    		break;
// 	    		
// 	    	case "cust_seq":
// 	    		if (Value.length > 0 && sheetObj.CellValue(Row, "cust_cnt_cd") != "" && sheetObj.CellValue(Row, "cust_cnt_cd").length == 2){
// 	    			formObj.f_cmd.value = SEARCH01;  
// 	    			var param = FormQueryString(formObj)+"&cust_cnt_cd="+sheetObj.Cellvalue(Row,"cust_cnt_cd")+"&cust_seq="+sheetObj.Cellvalue(Row,"cust_seq");
// 	    			var sXml = sheetObj.GetSearchXml("ESM_PRI_4014GS.do", param);
//   	  				var arrData = ComPriXml2Array(sXml, "cust_lgl_eng_nm|bzet_addr|loc_cd");   	  	
// 					if (arrData != null){
// 						sheetObj.CellValue2(Row,"cust_nm") = arrData[0][0];
// 						sheetObj.CellValue2(Row,"cust_addr") = arrData[0][1];
// 						sheetObj.CellValue2(Row,"cust_loc_cd") = arrData[0][2]; 						
// 						//CUST_SEQ 앞에 '0'문자로 채움
//         	    		if (Value.length < 6 && Value.length != 0){	 	    		
//        	 	    		sheetObj.CellValue2(Row,"cust_seq") = ComTrim(ComLpad(Value, 6, "0"));
//        	 	    	}         	    		
// 					}else{
// 						//ComShowCodeMessage("PRI00315");
//// 						locationCellClear(sheetObj,Row);
// 					}	  				
// 	    		}   
// 	    		break;
// 	    		
// 	    	case "cust_loc_cd":
//
// 	    			if (Value.length == 5) {		
// 	    				formObj.f_cmd.value = SEARCH05;
// 	    				formObj.cd.value = Value;
// 						var sParam = FormQueryString(formObj);
// 						var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
// 						var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
// 						if (arrDesc != null && arrDesc.length > 0) {
//
// 						} else {
// 	 						sheetObj.CellValue2(Row, "cust_loc_cd") = "";
// 	 						sheetObj.SelectCell(Row, "cust_loc_cd");
// 						}
// 					}else{
// 						sheetObj.CellValue2(Row, "cust_loc_cd") = "";
// 						sheetObj.SelectCell(Row, "cust_loc_cd");
// 					}
//
// 	    		break;
//     	}
//     }    
     
     /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시,User Info PopUp을 호출한다. <br>
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
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 

     	switch(colname)
     	{
// 	    	case "cust_addr":
// 	    		ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
// 	    		break;
 	    	case "acpt_usr_nm":
 	    		if (sheetObj.CellValue(Row,"acpt_usr_id")!=""){
 	    			ComUserPopup(sheetObj.CellValue(Row,"acpt_usr_id"));	
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
  	 * @returns bool <br>
  	 *          true  : 폼입력값이 유효할 경우<br>
  	 *          false : 폼입력값이 유효하지 않을 경우
  	 * @author 김재연
  	 * @version 2009.08.17
  	 */
   	function validateForm(sheetObj, formObj, sAction) {
   		switch (sAction) {
   		case IBSEARCH: // 조회
   			if (formObj.prop_no.value == "" || formObj.prop_no.value == "null" ) {
   				return false;
   			}
   			break;
   		}
   		return true;
   	}     

     
	/* 개발자 작업  끝 */