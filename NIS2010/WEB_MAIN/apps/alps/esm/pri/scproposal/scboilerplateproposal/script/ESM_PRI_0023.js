/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0023.js
*@FileTitle : Boiler Plate Creation
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
     * @class ESM_PRI_0023 : ESM_PRI_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0023() {
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
//조회 후 데이터가 없을 경우 guideling에서 copy 한 후 true로 변경하여 재 조회시 copy메세지가 다시 보이는것을 방지한다.
 var GUIDELINE_COPY = false;
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
          
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var sheetObject3 = sheetObjects[2];
          /*******************************************************/
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
 				case "btn_RowDelete":
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
 				case "btn_RowAdd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
 				case "btn_RowDelete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;
 				case "btn_Amend2":
 					doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
 					break;
 				case "btn_AmendCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
 					break;
 				case "btn_Accept2":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
					break;				
 				case "btn_AcceptCancel2":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
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
 				case "btn_AcceptAllCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break;
 				case "btn_glinecopy":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY07);
					break;					
 				case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
 					break;
 				case "btn_LoadExcel":
 					//데이타시트1,2수정여부채크
 					if(sheetObjects[0].isDataModified == false && sheetObjects[1].isDataModified == false){
 						
 						var formObj = document.form;				
 						if (formObj.prop_no.value =="" && formObj.amdt_seq.value ==""){
 							ComShowCodeMessage('PRI01055');
 							return;
 						}
		
 		   	    		var sPropNo = formObj.prop_no.value;
 						var sAmdtSeq = formObj.amdt_seq.value;
 						var sEffDt = formObj.eff_dt.value;
 						
 						var mBlplSeq = 0;
 						var mDpSeq = 0;
 						// blpl seq ,dp_seq의 max값을 구한다.
 						if (sheetObjects[0].RowCount > 0) {
	 						for(i = 1; i<=sheetObjects[0].RowCount;i++){
 								if(mBlplSeq < parseInt(sheetObjects[0].CellValue(i,"blpl_seq"), 10)) {
 									mBlplSeq = parseInt(sheetObjects[0].CellValue(i,"blpl_seq"), 10);
 								}
 								if(mDpSeq < parseInt(sheetObjects[0].CellValue(i,"dp_seq"), 10)) {
 									mDpSeq = parseInt(sheetObjects[0].CellValue(i,"dp_seq"), 10);
 								}
	 						}
 						}

 						var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&mBlplSeq="+mBlplSeq+"&mDpSeq="+mDpSeq;				
 		   	    		var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0074.do?"+sParam, "", 1000, 570, true);
 		   	    		rData = "Y";
 					} else {
 						ComShowCodeMessage('PRI01057');
 						return;
 					}
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

  		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);         
		
		var formObj = document.form;
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     var HeadTitle = "|Sel.|Seq.|propno|amdtseq|blplseq|Title|Effective Date|Effective Date|Source|Source|Status|Status|dpseq|acpt_usr_id|acpt_ofc_cd|acpt_dt|n1st_cmnc_amdt_seq|maxdpseq|maxdpseqctnt";
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
 					 InitDataProperty(0, cnt++, dtDummyCheck,   40, daCenter, false, "chk");
                     InitDataProperty(0, cnt++, dtDataSeq,      30, daCenter, false, "seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	    true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	    true,  "", dfNone,    0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "blpl_seq",  	    true,  "", dfNone,    0, false, false);
					 if (amdt_seq == "0"){
						 InitDataProperty(0, cnt++, dtData,   430, daLeft,	 false,	"blpl_tit_nm",	    true,  "", dfNone,	  0, true, true, 100);
					 }else{
						 InitDataProperty(0, cnt++, dtData,   430, daLeft,	 false,	"blpl_tit_nm",	    true,  "", dfNone,	  0, false, true, 100);
					 } 					 
					 InitDataProperty(0, cnt++, dtData,   100, daCenter, true,	"eff_dt",	          false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   100, daCenter, true,	"exp_dt",		      false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"src_info_cd",	      false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "src_info_dtl",       false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"prc_prog_sts_cd",    false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "prc_prog_sts_dtl",   false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "dp_seq", 			  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 	      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd",        false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_dt", 		      false, "", dfDateYmd, 0, false, false);  
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "max_dp_seq", 		  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "max_dp_seq_ctnt", 	  false, "", dfNone, 	0, false, false);
                     //이전 amdt_seq 의 detail max dp_seq
                     WaitImageVisible = false;
                     CountPosition = 0;
                     AutoRowHeight = false;
                }
                 break;

             case "sheet2":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 122;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

 										// 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);
                     var HeadTitle = "|Sel.|Seq.|propno|amdtseq|blplseq|blplctntseq|Content|Effective Date|Effective Date|Source|Source|Status|Status|usr_id|ofc_cd|acpt_dt|dp_seq|n1st_amdt_seq";
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
 					 InitDataProperty(0, cnt++, dtDummyCheck,   40, daCenter, false, "chk");
                     InitDataProperty(0, cnt++, dtDataSeq,      30, daCenter, false, "seq");                     
 					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	    true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	    true,  "", dfNone,    0, false, false); 
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "blpl_seq",  	    true,  "", dfNone,    0, false, false); 					
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "blpl_ctnt_seq",    true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtData,   430, daLeftTop,false,	"blpl_ctnt",	      true,  "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtData,   100, daCenter, true,	"eff_dt",	          false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtData,   100, daCenter, true,	"exp_dt",		      false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"src_info_cd",	      false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "src_info_dtl",       false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"prc_prog_sts_cd",    false, "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "prc_prog_sts_dtl",   false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 	      false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd",        false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_dt", 		      false, "", dfDateYmd, 0, false, false);                       
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, false, "dp_seq", 			  false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 	0, false, false);
					 WordWrap = true;
					 CountPosition = 0; 	
					 AutoRowHeight = false;
					 WaitImageVisible = false;
 			   	}			
                 break;
             case "sheet3":// down excel에서 사용한다.
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 150;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

 										// 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);
                     var HeadTitle = "|Title|Effective Date|Effective Date|Source|Status|Content";
//                     var HeadTitle = "|Title|Effective Date|Effective Date|Source|Status|Content|Effective Date|Effective Date|Status|Source|";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//			  			  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 					
                     InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter, false, "ibflag");                     
                     InitDataProperty(0, cnt++, dtData,     420, daLeft,   false, "blpl_tit_nm",	  true,  "", dfNone,	0, true,  true, 100);
 					 InitDataProperty(0, cnt++, dtHidden,   100, daCenter, false, "eff_dt",	          false, "", dfDateYmd, 0, false, false);
 					 InitDataProperty(0, cnt++, dtHidden,   100, daCenter, false, "exp_dt",		      false, "", dfDateYmd, 0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,   80,  daCenter, true,  "src_info_dtl",     false, "", dfNone, 	0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden,   80,  daCenter, true,  "prc_prog_sts_dtl", false, "", dfNone, 	0, false, false);
                     InitDataProperty(0, cnt++, dtData,     450, daLeftTop,false,	"blpl_ctnt",	   true, "", dfNone,	0, true,  true);                            
					 WordWrap = true;
					 CountPosition = 0; 	
					 WaitImageVisible = false;
 			   	}			
                 break;
         }
     }

      
      
     /**
      * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
      * Check Box 클릭 시  ComPriCheckWithPnS function을 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 해당 셀의 Row Index
      * @param {int} Col 필수 해당 셀의의 Column Index
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     	
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
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
     	var amdt_seq = formObj.amdt_seq.value;
 		var eff_dt = formObj.eff_dt.value;
 		var sts = formObj.prop_sts_cd.value;
 		var req_usr_flg = formObj.req_usr_flg.value;
 		var apro_usr_flg = formObj.apro_usr_flg.value;

         if (errMsg == "") {
        	 if (sts == "I" && sheetObjects[0].RowCount <= 0 && GUIDELINE_COPY == false && (req_usr_flg == "true" || apro_usr_flg == "true") ){	        	
             	if (ComShowCodeConfirm("PRI01006")) {
             		GUIDELINE_COPY = true;
             		document.form.f_cmd.value = MULTI10;             	
                     var sXml = sheetObj.GetSaveXml("ESM_PRI_0023GS.do", FormQueryString(document.form));                      
                     var saveOk = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);                     
                     formObj.blpl_hdr_seq.value =  ComGetEtcData(sXml,"blpl_hdr_seq");                     
                     
                     if (saveOk == "S"){
                    	 //메인 함수 호출
                    	 dialogArguments.comUpdateProposalStatusSummary("06", "");
                    	 doActionIBSheet(sheetObj, document.form, IBSEARCH);
                         if (sheetObjects[0].RowCount > 0){
                        	 ComShowCodeMessage("PRI01017");    
                          	 rData = "Y";
                          }else{
                          	 ComShowCodeMessage("PRI01019");
                          } 
                     }
             	} 	            
         	}        	 
         	setHeader();
         }
         var cols = "blpl_tit_nm";
         searchEndFontChange(sheetObj, cols,document.form.lgcy_if_flg.value);        
 		
 	}  	     
	
     
     /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 Sheet의 Font Style을 지정하고 데이터 수정 flag를 Y로 Setting한다. <br>
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
 		var formObj = document.form;
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			var cols = "blpl_tit_nm";
	        searchEndFontChange(sheetObj, cols)	
         	if (sheetObj.RowCount <= 0){
         		formObj.blpl_hdr_seq.value = "";         		
         	}
         	rData ="Y";
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
 	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
 		if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			rData ="Y";
		}
	}  	
     
    
     /**
      * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
      * Check Box 클릭 시  ComPriCheckWithPnS function을 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 해당 셀의 Row Index
      * @param {int} Col 필수 해당 셀의의 Column Index
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     	
  	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
  		}
  	}
  	
  	
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * 조회 후 Sheet의 Font Style을 지정하고 Button을 제어한다.
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
	function sheet2_OnSearchEnd(sheetObj, errMsg){
    	 
    	 searchEndFontChange(sheetObj, "",document.form.lgcy_if_flg.value);
         buttonControl();
	
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
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	    var colname = sheetObj.ColSaveName(Col);  	 
	    var amdtSeq = document.form.amdt_seq.value;
	    var eff_dt = document.form.eff_dt.value;
	    var sts = document.form.prop_sts_cd.value;
	    var readOnly = false;
	    var stsCd = sheetObj.CellValue(Row, "prc_prog_sts_cd");

     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		if (amdtSeq == 0){
 	    			if (sts =="R" || sts =="Q"){
 	    				readOnly = true;   
 	    			}else{
						if (stsCd == "A"){
							readOnly = true;
						}else{
							readOnly = false;	
						}
 	    			} 	    			   			
 	    		}
 				else if(sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
 					if (sheetObj.CellValue(Row , "src_info_cd") != "AD"){
 						if (sts =="R" || sts =="Q"){
 							readOnly = true;   
 						}else{
 							if (stsCd == "A"){
 								readOnly = true;
 							}else{
 								readOnly = false;	
 							} 							
 						} 		
  					}else{
 						readOnly = true; 						
 					}
 				}else{
 					readOnly = true; 					
 				} 	    		
 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 430, 110);
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
  	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         if (OldRow != NewRow) {
             changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         }
  	}         
     
     /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
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
  		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
  		
  	}      
      
      
  	var isFiredNested = false;
	var supressConfirm = false;	
	
	/**
	 * Sheet에서 Row변경되었을 때 이벤트를 처리할 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */	
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested = true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (sheetD.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.blpl_seq.value = sheetM.CellValue(adjNewRow, "blpl_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
				
			}
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
 			case IBSEARCH_ASYNC01: // 콤보셋팅
 				sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 				sheetObjects[1].InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 	        	//status
  				sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
  				sheetObjects[1].InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
  			
 				break;	              
 			case IBSEARCH: // Master조회
 				ComOpenWait(true); //->waiting->start 
 				for (var i = 0; i < sheetObjects.length; i++) {
 					sheetObjects[i].RemoveAll();
 				}				
 				formObj.blpl_nm.value = "";
 				formObj.blpl_ref_yr.value = "";
 				
 				formObj.f_cmd.value = SEARCH01; 				
 				var sXml = sheetObj.GetSearchXml("ESM_PRI_0023GS.do" , FormQueryString(formObj)); 				
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
 			case IBSEARCHAPPEND: // detail 조회
 				ComOpenWait(true); //->waiting->start 
 				formObj.f_cmd.value = SEARCH02;
 				sheetObj.DoSearch("ESM_PRI_0023GS.do" , FormQueryString(formObj));
 				ComOpenWait(false); //->waiting->End
 				break;
 			
 			case IBSAVE: // 저장
 				ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}

 	        	for (var a = 0; a <= 1; a++) {
 	        		for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
 	            		// Proposal단계이고 src_info_cd가 GC(Guideline Copy)인 경우, 수정되면 GM(Guideline Modification)으로 바꿔준다.
 	            		if (sheetObjects[a].RowStatus(i) == "U"
 	            			    && sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
 	            				&& sheetObjects[a].CellValue(i, "src_info_cd") == "GC") {
 	            			sheetObjects[a].CellValue(i, "src_info_cd") = "GM";
 	            		}
 	            		
 	            		// Proposal단계이고 src_info_cd가 PC(Previous Contract)인 경우, 수정되면 PM(Previous Contract Modification)으로 바꿔준다.
 	            		if (sheetObjects[a].RowStatus(i) == "U"
 	            			&& sheetObjects[a].CellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
 		        				&& sheetObjects[a].CellValue(i, "src_info_cd") == "PC") {
 	            			sheetObjects[a].CellValue(i, "src_info_cd") = "PM";
 	            		}
 	            		  
 	        		}
 	        	}			

 			    changeDpSeq (sheetObjects[0]);
 			    changeDpSeq (sheetObjects[1]);
 			    
 				formObj.f_cmd.value = MULTI01;
 				var sParam = FormQueryString(formObj); 				
 				var sParamSheet1 = sheetObjects[0].GetSaveString(); 				
 				if (sParamSheet1 != "") {
 					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
 				}
 				var sParamSheet2 = sheetObjects[1].GetSaveString();
 				if (sParamSheet2 != "") {
 					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
 				}
 				if (!supressConfirm && !ComPriConfirmSave()) {
 					return false;
 				}
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0023GS.do", sParam);	
 				
 				sheetObjects[1].LoadSaveXml(sXml);		
 				sXml = ComDeleteMsg(sXml);
 				sheetObjects[0].LoadSaveXml(sXml);
 				ComOpenWait(false); //->waiting->End
 				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
 					return false;
 				} else {
 					rData ="Y";
 					dialogArguments.comUpdateProposalStatusSummary("06", "");
 			     	setHeader();
 			     	buttonControl(); 					
 					return true;
 				}
 				break;

 			case IBINSERT: // Row Add 			
 				var eff_dt 		 = formObj.eff_dt.value;
 				var exp_dt 		 = formObj.exp_dt.value;
 				
 				if (validateForm(sheetObj,document.form,sAction)) {
 					if (sheetObj.id == "sheet1") {
 						var amdt_seq = formObj.amdt_seq.value;
 						if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);
 						if (idx < 0) {
 							return false;
 						}
 						
 						sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
 						sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value; 						
 						sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
 						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
 						sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
 						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
 						sheetObj.CellValue2(idx, "src_info_cd") = "NW";	
 						
 						if (idx == 1){
 							sheetObj.CellValue2(idx, "max_dp_seq") = 0; 							
 						}else{
 							sheetObj.CellValue2(idx, "max_dp_seq") = sheetObj.CellValue(idx - 1, "max_dp_seq")
 						}
 						
 						sheetObjects[1].RemoveAll();
 						sheetObj.CellValue2(idx, "blpl_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1;
 						sheetObj.SelectCell(idx, "blpl_tit_nm");
 						
 					}
 					if (sheetObj.id == "sheet2") {
 						if(sheetObjects[0].Rows==1){
 							ComShowCodeMessage("PRI01004");
 							return;							
 						}
 						var amdt_seq = formObj.amdt_seq.value;
 						if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						var idx = sheetObj.DataInsert();
 						
 						sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
 						sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
 						sheetObj.CellValue2(idx, "eff_dt") = formObj.eff_dt.value;
 						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
 						sheetObj.CellValue2(idx, "exp_dt") = formObj.exp_dt.value;						
 						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
 						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
 						
 						var blpl_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "blpl_seq");
 						sheetObj.CellValue2(idx, "blpl_seq") = blpl_seq;
 						sheetObj.CellValue2(idx, "blpl_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1;
 					
 						sheetObj.CellValue2(idx, "max_dp_seq_ctnt") = 0;//조회값이므로 입력시는 의미 없음
 						
 						if(amdt_seq!=0){
 							sheetObj.CellFont("FontColor", idx, "chk", idx, "prc_prog_sts_dtl")= sheetObj.RgbColor(255,0,0);
 						}

 						sheetObj.CellBackColor(idx, "blpl_ctnt") = sheetObj.RgbColor(255,255,255);
 						sheetObj.SelectCell(idx, "blpl_ctnt");

 					}
 			         //backcolor change
 			         changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
 				}
 				break;
 				
 			case IBDELETE: // Delete
 				var amdt_seq = formObj.amdt_seq.value;		
 				var eff_dt = formObj.eff_dt.value; 		
 				

 				
 				if(amdt_seq=="0"){	
 					if (validateForm(sheetObj,document.form,sAction)) {
 						if (sheetObj.CheckedRows("chk") <= 0) {
 			        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
 			        	} 				
 						//--------------------------------
 		 				if (checkDelete(sheetObj) != "Y"){
 		 					ComShowCodeMessage('PRI01132');
 		 					return;
 		 				}
 						//-------------------------------
 						if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
 						    sheetObjects[1].RemoveAll();
 						}
 						var delCnt = deleteRowCheck(sheetObj, "chk");
 						if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
 						    sheetObjects[1].RemoveAll();
 						}
 						if(sheetObj.id !="sheet1" && getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00017')){				
 							if(sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)!= "I"){						
 								sheetObjects[0].RowHidden(sheetObjects[0].SelectRow) = true;							
 							}		
 							sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) = "D";
 							if (getSearchRow(sheetObjects[0]) > 0){
 								formObj.blpl_seq.value = sheetObjects[0].CellValue(getSearchRow(sheetObjects[0]), "blpl_seq");
 								doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
 							}														 
 						}	 						
 						break;		
 					}
 				}else{	 					

 					var eff_dt = formObj.eff_dt.value;
 					if (sheetObj.CheckedRows("chk") <= 0) {
 		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
 		        	}
 					
 					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 					if(chkArr.length > 0){	
 						for(var i=0;i < chkArr.length;i++){
							
 							if(sheetObj.CellValue(chkArr[i],"amdt_seq") != amdt_seq
 									|| ((sheetObj.CellValue(chkArr[i],"src_info_cd")!="NW" 
 									     &&  sheetObj.CellValue(chkArr[i],"src_info_cd")!="GC"
 									     &&  sheetObj.CellValue(chkArr[i],"src_info_cd")!="GM"									   
 									     ||  sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") != "I" )
 									     &&  sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq)){
 								ComShowCodeMessage("PRI01002");
 								return;
 							}
 						}

						//--------------------------------
		 				if (checkDelete(sheetObj) != "Y"){
		 					ComShowCodeMessage('PRI01132');
		 					return;
		 				}
						//-------------------------------
 						
 						var editColumn = "";
 						if (sheetObj.id == "sheet1"){
 							editColumn = "blpl_tit_nm";
 						}else{
 							editColumn = "blpl_ctnt";
 						}
 						var sRow = 0;
 						for(var j=0;j < chkArr.length;j++){							
 							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){	
 								isFiredNested = true;
 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow, "D", editColumn);
 								if (sheetObj.id == "sheet1" && sRow == 0){
 									for (var i = sheetObjects[1].RowCount ; i > 0 ; i--){										
 										// delete / modify Amend 중 이미 amend 된 과거 row 는 제외									
 										if(sheetObjects[1].CellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq && sheetObjects[1].CellValue(i,"src_info_cd")=="NW"){
 											sheetObjects[1].CellValue(i,"chk") = 1;
 										}else if(sheetObjects[1].CellValue(i,"amdt_seq")!= amdt_seq  ){	
// 											sheetObjects[1].CellValue(i,"chk") = 1;
 										}else if (sheetObjects[1].CellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq && sheetObjects[1].CellValue(i,"ibflag")!="I"){
 											comSheetAmendCancelRow(sheetObjects[1],formObj,i,"M", "blpl_ctnt");
 										}else{	
 											comSheetAmendRow(sheetObjects[1],formObj,i,"D","blpl_ctnt");
 										}										
 									}
 									deleteRowCheck(sheetObjects[1], "chk");
 								}
 								sRow++;
 							}
 						} 						

 						deleteRowCheck(sheetObj, "chk");
 						isFiredNested = false;
 					}else{ 				
 						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq 
 								|| ( sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")==amdt_seq 
 										&& (sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd")!="NW"
 										|| sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd")!="I")	)){
 							ComShowCodeMessage("PRI01002"); 	
 							
 							return;
 						}
 						
 						//--------------------------------
 						sheetObj.CellValue(sheetObj.SelectRow, "chk") = 1;
 		 				if (checkDelete(sheetObj) != "Y"){
 		 					sheetObj.CellValue(sheetObj.SelectRow, "chk") = 0;
 		 					ComShowCodeMessage('PRI01132');
 		 					return;
 		 				}
 		 				sheetObj.CellValue(sheetObj.SelectRow, "chk") = 0;
 						//-------------------------------
 						
 						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")!=amdt_seq){				
 							comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"D","");
 							if (sheetObj.id == "sheet1"){		
 								for (var i = sheetObjects[1].RowCount; i > 0 ; i--){									
 									// delete / modify Amend 중 이미 amend 된 과거 row 는 제외
 									if(sheetObjects[1].CellValue(i,"amdt_seq")!= amdt_seq || sheetObjects[1].CellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq){		
 										sheetObjects[1].CellValue(i,"chk") = 1;
 									}else{	
 										comSheetAmendRow(sheetObjects[1],formObj,i,"D","blpl_ctnt");
 									}
 								}			
 								deleteRowCheck(sheetObjects[1], "chk");
 							}
 						}else{
 							sheetObj.CellValue(sheetObj.SelectRow,"chk")=1;
 							deleteRowCheck(sheetObj, "chk");
 							if (sheetObj.id == "sheet1"){
 								for (var i = 1 ; i <= sheetObjects[1].RowCount ; i++){
 									sheetObjects[1].CellValue(i,"chk") = 1;
 								}
 								deleteRowCheck(sheetObjects[1], "chk");
 							}
 						}	
 					}					
 				}
 				if(sheetObj.id !="sheet1" &&  getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00017')){
 					if(sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)!="I"){		
 						sheetObjects[0].RowHidden(sheetObjects[0].SelectRow) = true;							
 					}			
 					sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) = "D";
 					if (getSearchRow(sheetObjects[0]) > 0){
 						formObj.blpl_seq.value = sheetObjects[0].CellValue(getSearchRow(sheetObjects[0]), "blpl_seq");
 						doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
 					}
 				}	
 				break; 						
 			case MODIFY01: // Accept
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value = MODIFY01;
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					dialogArguments.comUpdateProposalStatusSummary("06", "");
  					rData ="Y";
  				}
 				break;				
 		
 			case MODIFY02: // Accept Cancel
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value = MODIFY02;
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					dialogArguments.comUpdateProposalStatusSummary("06", "");
  					rData ="Y";
  				} 
 				break;					
 					
 			case MODIFY03: // Detail Accept
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value = MODIFY03;
 				var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					dialogArguments.comUpdateProposalStatusSummary("06", "");
  					rData ="Y";
  				}
 				break;				
 		
 			case MODIFY04: // Detail Accept Cancel
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }			
 				formObj.f_cmd.value = MODIFY04;
 				var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					dialogArguments.comUpdateProposalStatusSummary("06", "");
  					rData ="Y";
  				} 
 				break; 				
 			case MODIFY05: // Accept All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}			
 				formObj.f_cmd.value = MODIFY05;
 				formObj.sts_cd.value = 'A';
 				var sParam = FormQueryString(formObj) +"&amdt_seq_accept="+formObj.amdt_seq.value;
 				sheetObj.DoAllSave("ESM_PRI_0023GS.do", sParam);
 				sheetAcceptCheckedRows();
 				ComOpenWait(false); //->waiting->End
 				dialogArguments.comUpdateProposalStatusSummary("06", "");				
 				rData ="Y";
 				break;			
 		
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}					
 				formObj.f_cmd.value = MODIFY06;
 				formObj.sts_cd.value = 'I';
 				var sParam = FormQueryString(formObj) +"&amdt_seq_accept="+formObj.amdt_seq.value;
 				sheetObj.DoAllSave("ESM_PRI_0023GS.do", sParam);				
 				sheetAcceptCancelCheckedRows();
 				ComOpenWait(false); //->waiting->End
 				dialogArguments.comUpdateProposalStatusSummary("06", "");
 				rData ="Y";
 				break;		
 			case MODIFY07: // Guideline copy
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01009")){
 					return false;
 				}	
         		document.form.f_cmd.value = MULTI10;        	
                 var sXml = sheetObj.GetSaveXml("ESM_PRI_0023GS.do", FormQueryString(document.form));   
                 
                 var saveOk = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);

                 if (saveOk == "S"){
                     dialogArguments.comUpdateProposalStatusSummary("06", "");
                     doActionIBSheet(sheetObj, document.form, IBSEARCH);
      				 ComOpenWait(false); //->waiting->End
                     if (sheetObjects[0].RowCount <= 0){                     
                     	ComShowCodeMessage("PRI01019");
                     }else{
                    	 sheetObj.LoadSaveXml(sXml);
                     }
                 }
                 
 				break;				

 			case COMMAND01: // Amend			
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var editColumn = "";
 				if (sheetObj.id == "sheet1"){
 					editColumn = "blpl_tit_nm";
 				}
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", editColumn);						
 					}
 				}else{ 					
 					comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", editColumn);					
 				}
 				
 				break;			
 					
 			case COMMAND02: // Amend Cancel		
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var editColumn = "";
 				if (sheetObj.id == "sheet1"){
 					editColumn = "blpl_tit_nm";
 				}				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){
 						ComShowCodeMessage("PRI00310");
 					}else{
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", editColumn);						
 					}
 				}else{					
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", editColumn);					
 				}
 	
 				break;			
 				
 			case IBDOWNEXCEL:      //excel		
 				var xmlFile = "apps/alps/esm/pri/scproposal/scboilerplateproposal/script/ESM_PRI_0023.xml";
 				ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 				formObj.f_cmd.value = SEARCH03;
 				sheetObjects[2].DoSearch("ESM_PRI_0023GS.do", FormQueryString(formObj)); 			
 				sheetObjects[2].Down2Excel(-1, false,false,false,"",xmlFile);
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
         	if (sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBINSERT
         			|| sAction == IBSEARCH_ASYNC01 || sAction == IBDELETE) {
         		return;
         	}
         	ComOpenWait(false); //->waiting->End
         }

     }

    /**
    * Open시 해당년도 Boiler Plate 을 S/C Guideline으로 부터 자동 Update하는  function(현재사용안함) <br>
    * <br><b>Example :</b>
    * <pre>
    *		getHeader();
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
 	function getHeader (){
		var formObj = document.form;		
		var blplRefYr = formObj.hdr_eff_dt.value;			
		formObj.f_cmd.value = SEARCH;
		formObj.blpl_ref_yr.value = blplRefYr.substring(0,4);
		
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0023GS.do", FormQueryString(formObj));		
		var arrData = ComPriXml2Array(sXml, "eff_dt|exp_dt|blpl_nm|blpl_hdr_seq|blpl_ref_yr");		
		if (arrData != null && arrData.length > 0) {
			formObj.blpl_nm.value = arrData[0][2];
			formObj.blpl_hdr_seq.value = arrData[0][3];
			formObj.blpl_ref_yr.value = arrData[0][4]; 	
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
			var sheetObj = sheetObjects[1];
			
			ComBtnDisable("btn_glinecopy");
			
			if (apro_usr_flg == "false" && req_usr_flg == "false"){
 				ComBtnDisable("btn_Save");
 				ComBtnDisable("btn_RowDelete");
 				ComBtnDisable("btn_RowAdd");
 				ComBtnDisable("btn_Amend");
 				ComBtnDisable("btn_AmendCancel");
 				ComBtnDisable("btn_Accept");
 				ComBtnDisable("btn_AcceptCancel"); 				
				ComBtnDisable("btn_RowAdd2");
				ComBtnDisable("btn_RowDelete2");
				ComBtnDisable("btn_Amend2");
				ComBtnDisable("btn_AmendCancel2"); 				
				ComBtnDisable("btn_AcceptAll");
				ComBtnDisable("btn_AcceptAllCancel"); 	
				ComBtnDisable("btn_Accept2");
				ComBtnDisable("btn_AcceptCancel2");	
				ComBtnDisable("btn_LoadExcel");	
				
				for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
					sheetObjects[0].CellEditable(i,"blpl_tit_nm") = false;
				}		
 				return;
 			}			
			
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
				hiddenButton("btn_Amend2");
				hiddenButton("btn_AmendCancel2");
			} else {
				showButton("btn_Amend");
				showButton("btn_AmendCancel");	
				showButton("btn_Amend2");
				showButton("btn_AmendCancel2");	
			}	
						
			try{
				switch(sts) { 				
					case 'I':   // Initial	
									
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");	
						
						if (apro_usr_flg == "true" || req_usr_flg == "true" ){
							if (sheetObjects[0].RowCount <= 0 ){				
								ComBtnEnable("btn_glinecopy");
							}
						}						
						for (var i = 1; i <=sheetObj.RowCount; i++){
							if (sheetObj.CellValue(i, "amdt_seq") == sheetObj.CellValue(i, "n1st_cmnc_amdt_seq")){
								if (sheetObj.CellValue(i, "prc_prog_sts_cd") =="A"){
									sheetObj.CellBackColor(i,"blpl_ctnt") = sheetObj.UnEditableColor;
								}else{
									sheetObj.CellBackColor(i, "blpl_ctnt") = sheetObj.RgbColor(255,255,255);
								}								
							}							
						}
						for (var i = 1; i <=sheetObjects[0].RowCount; i++){
							if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd") == "I"){
								sheetObjects[0].CellEditable(i,"blpl_tit_nm") = true;
							}else{
								sheetObjects[0].CellEditable(i,"blpl_tit_nm") = false;
							}
						}
						
						break;
					case 'A': // Approved					
						ComBtnDisable("btn_Save");						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");
						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_AcceptCancel2");
			
						
						ComBtnDisable("btn_LoadExcel");	
						sheetObj.ColBackColor("blpl_ctnt") = sheetObj.UnEditableColor;
						break;
						
					case 'Q':// Requested    save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.

						ComBtnDisable("btn_Save");						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_AcceptAllCancel");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");
						}else{
							
							ComBtnDisable("btn_AcceptAll");
							ComBtnDisable("btn_AcceptAllCancel");
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
							ComBtnDisable("btn_Accept2");
							ComBtnDisable("btn_AcceptCancel2");		
						}						
						
						ComBtnDisable("btn_LoadExcel");	
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"blpl_tit_nm") = false;
						}				
						sheetObj.ColBackColor("blpl_ctnt") = sheetObj.UnEditableColor;
						break;
				
					case 'R':  // Returned
						ComBtnDisable("btn_Save");
						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");	
						
						ComBtnDisable("btn_LoadExcel");	
						
						if(req_usr_flg == "true"){
							ComBtnDisable("btn_AcceptAll");
							ComBtnDisable("btn_AcceptAllCancel");
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
							ComBtnDisable("btn_Accept2");
							ComBtnDisable("btn_AcceptCancel2");	
						}
						
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_AcceptAllCancel");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");	
						}

						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"blpl_tit_nm") = false;
						}
						sheetObj.ColBackColor("blpl_ctnt") = sheetObj.UnEditableColor;
						break;
					case 'F': // Filed
						ComBtnDisable("btn_Save");
						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");							
						
						ComBtnDisable("btn_LoadExcel");	
						
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"blpl_tit_nm") = false;
						}
						sheetObj.ColBackColor("blpl_ctnt") = sheetObj.UnEditableColor;
						break;
					case 'C': //  // Cancled
						ComBtnDisable("btn_Save");
						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");							
						
						ComBtnDisable("btn_LoadExcel");	
						break;
					default:

	    				showButton("btn_Amend");
	    				showButton("btn_AmendCancel");
	    				showButton("btn_Amend2");
	    				showButton("btn_AmendCancel2");
	    				ComBtnEnable("btn_AcceptAll");
	    				ComBtnEnable("btn_AcceptAllCancel");
	    				ComBtnEnable("btn_Accept");
	    				ComBtnEnable("btn_AcceptCancel");
	    				ComBtnEnable("btn_Accept2");
	    				ComBtnEnable("btn_AcceptCancel2");
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
     
   
    
   
     
//    /**
//    * DETAIL의 SOURCE CODE에 따라 색상 변경하는 function <br>
//    * 
//    * <br><b>Example :</b>
//    * <pre>
//    * manageMasterColor(sheetM, sheetD);
//    * </pre>
//    * @param {object} IBSheet  
//    * @param {object} IBSheet
//    * @return 없음
//    * @author 최성민
//    * @version 2009.06.10
//    */ 	
//    function manageMasterColor(sheetM, sheetD) {
//    	//SHEET ROW COUNT
//		var row_count = sheetD.RowCount;
//    	var formObj = document.form;
//    	var amdt_seq = formObj.amdt_seq.value;
//    	var eff_dt = formObj.eff_dt.value;
//		
//		//AMEND 지정
//		var amend_check = false;
//		//ALL AMEND DELETE
//		var amend_delete_check = false;
//		
//		try {
//  			if(row_count > 0){  				
//  				amend_delete_check = true;  				
//	  			for(var i=1 ; i <= row_count; i++){	  				
//  					if(sheetD.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
//  						if(sheetD.CellValue(i,"src_info_cd") !="AD") {
//  							amend_delete_check = false;
//	  	  				}
//  						
//  						if(sheetD.CellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
//	  	  					amend_check = true;
//	  	  				}
//  					}
//	  			}
//	  			
//	  			if(amdt_seq == "0"){
//	  				amend_delete_check = false;
//	  			}
//	  			
//	  			if(amend_delete_check) {
////	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
////	  				sheetM.CellFont("FontItalic", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
////	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);  
//	  			} else if(amend_check){
//	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
//	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);
//	  			} else {
//	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
//	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(0,0,0);
//	  			}
//  			}
//		}catch(e) {}
//	}  	
 	
    

 	
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
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCH_ASYNC01: // 조회
			break;
		
		case IBSAVE: // 저장
			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}			
			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				ComShowCodeMessage("PRI00007");
				return false;
			}			
			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}			
			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			break;			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
			break;

		case IBDOWNEXCEL:			
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
        	if (sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true){
        		ComShowCodeMessage('PRI00309','Boiler Plate');
        		return false;
        	}			
			break;			
		}
		return true;
	}
    /**
    * Cancel All 처리시 sheet 에 보여지는 데이터를 Accept Cancel 처리한다.  
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.29
    */	
	function sheetAcceptCancelCheckedRows(){
		var eff_dt 		 = document.form.eff_dt.value;
		var amdtSeq  = document.form.amdt_seq.value;
		for ( var j = 0 ; j <= 1; j++){
			comChangeValue(sheetObjects[j], "chk", "0");
			comChangeValue(sheetObjects[j], "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|A");
			comChangeValue(sheetObjects[j], "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "I|Initial|R", "chk", "1");
			comChangeValue(sheetObjects[j], "chk|ibflag", "0|R", "chk", "1");	
		}		
	}    	
    /**
    * Accept All 처리시 sheet 에 보여지는 데이터를 Accept 처리한다.  
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.29
    */	
	function sheetAcceptCheckedRows(){
		var eff_dt 		 = document.form.eff_dt.value;
		var amdtSeq  = document.form.amdt_seq.value;
		
		for ( var j = 0 ; j <= 1; j++){
			comChangeValue(sheetObjects[j], "chk", "0");
			comChangeValue(sheetObjects[j], "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|I");
			comChangeValue(sheetObjects[j], "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|R", "chk", "1");
			comChangeValue(sheetObjects[j], "chk|ibflag", "0|R", "chk", "1");
		}		
	}    

	
    /**
    * 화면의 Seq No.를 이용하여 Max Seq No. + 1 값을 구한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     getAmendMaxDpSeq(sheetObj, sCol);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} sCol 필수 구하고자 하는 Seq No. 컬럼명칭
    * @returns int Max Seq No. 에 1을 더한 값
    * @author 공백진
    * @version 2009.04.17
    */	
    
//    function getAmendMaxDpSeq(sheetObj, sCol){
//        var max = 0;
//        var formObj = document.form;
//        var effDt = formObj.eff_dt.value;
//        var amdtSeq  = document.form.amdt_seq.value;
//
//        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
//        	if (sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && parseInt(sheetObj.CellValue(i, sCol)) > max) {
//                max = sheetObj.CellValue(i, sCol);               
//            }
//        }    
//        alert("max=="+max)
//        return max;    	
//    }    
    
    
    function getAmendMaxDpSeq(sheetObj, sCol){
        var max = 0;
        var formObj = document.form;
        var effDt = formObj.eff_dt.value;
        var amdtSeq  = document.form.amdt_seq.value;

        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
        	if (sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && ComParseInt(sheetObj.CellValue(i, sCol)) > max) {
                max = sheetObj.CellValue(i, sCol);      
                if (sheetObj.id == "sheet1"){
                	if (max < ComParseInt(sheetObj.CellValue(i, "max_dp_seq"))){
                		max = sheetObj.CellValue(i, "max_dp_seq");
                	}
                }else{
                	if (max < ComParseInt(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "max_dp_seq_ctnt"))){
                		max = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "max_dp_seq_ctnt");
                	}
                }                
            }
        }
        
        return max;    	
    }
    
    /**
    * 정렬 순서 컬럼인 dp_seq의 순서를 지정한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		changeDpSeq (sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
 	function changeDpSeq (sheetObj){
		var formObj = document.form;		
		var dpSeq = ComParseInt(getAmendMaxDpSeq(sheetObj, "dp_seq")) + 1;	
		var effDt = formObj.eff_dt.value;
		var amdtSeq  = document.form.amdt_seq.value;
		for (var i = 1; i <= sheetObj.RowCount; i++){
			if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.CellValue(i, "src_info_cd") != "AM"
				&& sheetObj.CellValue(i, "ibflag") !="D" && sheetObj.CellValue(i, "src_info_cd") != "AD" ){
				sheetObj.CellValue(i, "dp_seq") = dpSeq++ ;
			}			
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
         		//formObj.blpl_ref_yr.value = formObj.hdr_eff_dt.value.substr(0,4);
         	}
         	if (formObj.blpl_nm.value == ""){
         		//formObj.blpl_nm.value = formObj.hdr_eff_dt.value.substr(0,4)+ " Boiler Plate";
         	}
     	}else{
     		formObj.blpl_ref_yr.value = "";
     		formObj.blpl_nm.value = "";
     		formObj.blpl_hdr_seq.value = "";
     	}
    }
    
    
    /**
    * 삭제된 Row를 찾아서 Row +1 or Row -1 하여 Row를 Return한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		getSearchRow(sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @return rValue 삭제된 Row가 마지막Row라면 마지막 Row -1 아니면 삭제된 Row + 1
    * @author 공백진
    * @version 2009.04.17
    */    
	function getSearchRow(sheetObj){
		var mRow = 1;
		var rValue = 1;
		
		for (var i = 1;i <= sheetObj.RowCount;i++){
			if (sheetObj.CellValue(i, "ibflag") =="D" ){
				mRow = i;
				break;
			}		
		}
	
		if (mRow == sheetObj.RowCount){
			rValue = mRow - 1;
		}else{
			rValue = mRow + 1;
		}
	
		return rValue;
	}
 	    
    
    /**
     * Master Delete시 Detail  데이터에 Accept된 항목이 있는지 조회한다.<br>
     * Accept데이터가 있다면 삭제할 수 없다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkDelete(sheetObj);
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Delete 가능<br>
     *          N : Delete 불가능.<br>
     * @author 공백진
     * @version 2009.05.07
     */ 
    function checkDelete(sheetObj){
    	 var sheetID = sheetObj.id;
    	 if (sheetID != "sheet1"){
    		 return "Y";
    	 }
    	var formObj = document.form;        
        var rValue = "Y";        
        formObj.f_cmd.value = SEARCH04;
        var sParam = FormQueryString(formObj);
        var sParamSheet = sheetObjects[0].GetSaveString(false, false, "chk");
                
        var sXml = sheetObj.GetSearchXml("ESM_PRI_0023GS.do" , sParamSheet +"&"+sParam);
        var arrData = ComPriXml2Array(sXml, "cd");         
        if (arrData !=null && arrData.length > 0){
        	if (arrData[0][0] > 0){
	       		rValue ="N";
	        }
        }
        return rValue;  
     
    }      

	/* 개발자 작업  끝 */