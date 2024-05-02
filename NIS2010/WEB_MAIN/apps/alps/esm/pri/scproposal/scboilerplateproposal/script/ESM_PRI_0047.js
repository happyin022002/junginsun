/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0047.js
*@FileTitle : S/C Proposal Boiler Plate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.28 공백진
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
     * @class ESM_PRI_0047 : ESM_PRI_0047 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0047() {
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

// var GUIDELINE_COPY = false;
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
//          var sheetObject3 = sheetObjects[2];
          /*******************************************************/
//          var formObject = document.form;
 
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
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
		
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 
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
		//var formObject = document.form;
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
 		 var amdt_seq = document.form.amdt_seq.value;
         switch(sheetID) {         	
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 82;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Seq.|propno|amdtseq|blplseq|Title|Effective Date|Effective Date|Source|Source|Status|Status|dpseq|acpt_usr_id|acpt_ofc_cd|Accept Staff/Team|Accept Date|";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  				  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					 InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter, false, "ibflag");
 		
                     InitDataProperty(0, cnt++, dtDataSeq,30,  daCenter, false, "seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	      false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	      false, "", dfNone,    0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "blpl_seq",  	      false, "", dfNone,    0, false, false);		
					 InitDataProperty(0, cnt++, dtData,   300, daLeft,	 false,	"blpl_tit_nm",	      false, "", dfNone,	0, false, false, 100);					 					 
					 InitDataProperty(0, cnt++, dtData,   75,  daCenter, false,	"eff_dt",	    	  false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   75,  daCenter, false,	"exp_dt",		      false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  70,  daCenter, false,	"src_info_cd",	      false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "src_info_dtl",       false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  70,  daCenter, false,	"prc_prog_sts_cd",    false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "prc_prog_sts_dtl",   false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "dp_seq", 			  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 	      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd",        false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtData,   120, daLeft, false, "acpt_usr_nm",        false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtData,   75,  daCenter, false, "acpt_dt", 		      false, "", dfDateYmd, 0, false, false);  
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 	0, false, false);
//                     ColHidden("dp_seq") = true;
                     CountPosition = 0;
                     AutoRowHeight = false;
                     WaitImageVisible = false;
                }
                 break;

             case "sheet2":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 132;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

 										// 전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);
                     var HeadTitle = "|Seq.|propno|amdtseq|blplseq|blplctntseq|Content|Effective Date|Effective Date|Source|Source|Status|Status|usr_id|ofc_cd|Accept Staff/Team|Accept Date|dp_seq|n1st_amdt_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//			  			  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					
					 InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter, false, "ibflag"); 		
                     InitDataProperty(0, cnt++, dtDataSeq, 30,  daCenter, false, "seq");                     
 					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "prop_no",  	    	false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "amdt_seq", 	    	false, "", dfNone,    0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "blpl_seq",  	    	false, "", dfNone,    0, false, false); 					
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "blpl_ctnt_seq",    	false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtData,    350, daLeftTop,false, "blpl_ctnt",	    	false, "", dfNone,	  0, false, false);
                     InitDataProperty(0, cnt++, dtData,    65,  daCenter, false, "eff_dt",	    		false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,    65,  daCenter, false, "exp_dt",		    	false, "", dfDateYmd, 0, false, false);                 
 					 InitDataProperty(0, cnt++, dtCombo,   70,  daCenter, false, "src_info_cd",	    	false, "", dfNone,	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, false, "src_info_dtl",     	false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,   70,  daCenter, false, "prc_prog_sts_cd",  	false, "", dfNone,	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, false, "prc_prog_sts_dtl", 	false, "", dfNone, 	  0, false, false);   
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_usr_id", 	    false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "acpt_ofc_cd",      	false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtData,    120, daLeft, false, "acpt_usr_nm",      	false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtData,    65,  daCenter, false, "acpt_dt", 		    false, "", dfDateYmd, 0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,  80,  daCenter, false, "dp_seq", 				false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "n1st_cmnc_amdt_seq",  false, "", dfNone, 	  0, false, false);
					 WordWrap = true;
					 CountPosition = 0; 	
					 AutoRowHeight = false;
					 WaitImageVisible = false;
 			   	}			
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
     * @author 공백진
     * @version 2009.05.20
     */ 
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
         if (errMsg == "") {         	
         	setHeader();
         }
 		
 	}  	     

     
     /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet 의 해당 Sell을 클릭 시 메모장을 화면에 표시한다. <br>
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
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.
	    var colname = sheetObj.ColSaveName(Col);  
     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		ComShowMemoPad(sheetObj, Row, Col, true, 430, 110);
 	    		break;
     	}    	 

    }     
     
     
     /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
  		var formObj = document.form;
  		formObj.blpl_seq.value = sheetObj.CellValue(NewRow, "blpl_seq");
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
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
 			 case IBSEARCH_ASYNC01: // 조회
 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 				sheetObjects[1].InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 				//status
 				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
 				sheetObjects[1].InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
 				break;	              
 			 case IBSEARCH: // 조회
 			 	ComOpenWait(true); //->waiting->start
 				for (var i = 0; i < sheetObjects.length; i++) {
 					sheetObjects[i].RemoveAll();
 				}				
 				formObj.blpl_nm.value = "";
 				formObj.blpl_ref_yr.value = "";
 				
 				formObj.f_cmd.value = SEARCH01;
 				var sXml = sheetObj.GetSearchXml("ESM_PRI_0047GS.do" , FormQueryString(formObj));
 				
 				sheetObjects[0].LoadSearchXml(sXml);
 				if (ComGetEtcData(sXml,"blpl_nm") != undefined){
 					formObj.blpl_nm.value =  ComGetEtcData(sXml,"blpl_nm");
 				}
 				if (ComGetEtcData(sXml,"blpl_ref_yr") != undefined){
 					formObj.blpl_ref_yr.value =  ComGetEtcData(sXml,"blpl_ref_yr");
 				}
 				
 				if (ComGetEtcData(sXml,"blpl_hdr_seq") != undefined){
 					formObj.blpl_hdr_seq.value =  ComGetEtcData(sXml,"blpl_hdr_seq");
 				}
 				ComOpenWait(false); //->waiting->End
 				break;
 			 case IBSEARCHAPPEND: // 조회
 			 	ComOpenWait(true); //->waiting->start
 			 	formObj.f_cmd.value = SEARCH02;
 				sheetObj.DoSearch("ESM_PRI_0047GS.do" , FormQueryString(formObj));
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
          	if (sAction == IBSEARCH_ASYNC01) {
          		return;
          	}
          	ComOpenWait(false); //->waiting->End
         }

     }
 	
   
     
    /**
    * DETAIL의 SOURCE CODE에 따라 색상 변경하는 function <br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return 없음
    * @author 최성민
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
		var row_count = sheetD.RowCount;
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
    	var eff_dt = formObj.eff_dt.value;
		
		//AMEND 지정
		var amend_check = false;
		//ALL AMEND DELETE
		var amend_delete_check = false;
		
		try {
  			if(row_count > 0){  				
  				amend_delete_check = true;  				
	  			for(var i=1 ; i <= row_count; i++){	  				
  					if(sheetD.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
  						if(sheetD.CellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check = false;
	  	  				}  						
  						if(sheetD.CellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check = true;
	  	  				}
  					}
	  			}	  			
	  			if(amdt_seq == "0"){
	  				amend_delete_check = false;
	  			}	  			
	  			if(amend_delete_check) {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);  
	  			} else if(amend_check){
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);
	  			} else {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(0,0,0);
	  			}
  			}
		}catch(e) {}
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
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCH_ASYNC01: // 조회
			return true;
			break;
	
		}
	}
   

    
    /**
    * Boiler Plate의 명칭을 Setting한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		setHeader();
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */    
    function setHeader(){
     	var sheetObj = sheetObjects[0];
     	var formObj = document.form;
     	// GUIDELINE COPY가 아닐때는 타이틀을 보여주지 않는것으로 수정한다. 09.08.27 김재연
    	if (sheetObj.RowCount > 0){
     		if (formObj.blpl_ref_yr.value == ""){
         		formObj.blpl_ref_yr.value = formObj.hdr_eff_dt.value.substr(0,4);
         	}
         	if (formObj.blpl_nm.value == ""){
         		formObj.blpl_nm.value = formObj.hdr_eff_dt.value.substr(0,4)+ " Boiler Plate";
         	}
     	}else{
     		formObj.blpl_ref_yr.value = "";
     		formObj.blpl_nm.value = "";
     		formObj.blpl_hdr_seq.value = "";
     	}
    }
 	    

	/* 개발자 작업  끝 */