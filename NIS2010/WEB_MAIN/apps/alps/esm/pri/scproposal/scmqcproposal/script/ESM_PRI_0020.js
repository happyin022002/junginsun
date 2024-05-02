/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0020.js
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.25 공백진
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends 
     * @class ESM_PRI_0020 : ESM_PRI_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0020() {
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
 var rData = "N";
 //var subMqcSwitch = 0;
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
 					if (ComTrim(formObject.svc_scp_cd.value) !=""){ 	
 						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
 					}
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
				case "btn_New2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
				case "btn_Delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;
				case "btn_Save2":
 					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
 					break;
				case "btn_Amend2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
 					break;
				case "btn_AmendCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
 					break;
				case "btn_Accept2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY01);
 					break;
				case "btn_AcceptCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,MODIFY02);
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
    	  var formObj = document.form;
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

      	 //sub MQC를 숨긴다.
    	 window.dialogHeight = "330px";
      	 
     	var formObj = document.form; 
   	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
  	    doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);
  	    //sheet에서 호출 할경우 svc_scp_cd로 다시 조회한다.
  	    var svcScpCd = formObj.svc_scp.value;
  	    if (svcScpCd != "" && svcScpCd != null &&  svcScpCd !="null" ){
  		    if (comboObjects[0].GetCount() > 0 ){   
  			   //받아온 값으로 초기화
  		  	  comboObjects[0].Text(svcScpCd);
  			  svc_scp_cd_OnBlur(comboObjects[0]);
  		    }
  	    }
  	    //Sub Mqc에 데이터가 있으면 표시한다.
  	    if (sheetObjects[1].RowCount > 0){
  	      	document.all.subDivMqc.style.display = "inline";
  	      	window.dialogHeight = "455px"
  	      	formObj.selectMqc.value = 1;
  	    }  	    
  	    initControl();       	 
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
     * OPtion Axon 이벤트  처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @returns 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	 
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch(개발자변경)
	    axon_event.addListener('change', 'select_Onchange', 'selectMqc');

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
                     style.height = 62;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     var HeadTitle = "|sel|prop_no|amdt_seq|Unit|Proposal|C/Offer|Final|EFF Date|EXP Date|Source|Source|Status|Status|acptusrid|acptofccd|acptdt|mneffdt|mnexpdt||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
                     //	  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
                     // 			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
                     //		  		  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
                     InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
 					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	   true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	   true,  "", dfNone,    0, false, false);					 
					 if (amdt_seq == "0"){
						 InitDataProperty(0, cnt++, dtCombo,  60,  daCenter, false,	"cntr_lod_ut_cd",  true,  "", dfNone,	 	 0,	false, false);
	                     InitDataProperty(0, cnt++, dtData,   70,  daRight,  false,	"prop_scp_mqc_qty",true,  "", dfNullInteger, 0,	false, false, 6);
	                     InitDataProperty(0, cnt++, dtData,   70,  daRight,  false,	"coffr_mqc_qty",   false, "", dfNullInteger, 0,	true, false, 6); 
					 }else{
						 InitDataProperty(0, cnt++, dtCombo,  60,  daCenter, false,	"cntr_lod_ut_cd",  true,  "", dfNone,	 	 0,	false, false);
	                     InitDataProperty(0, cnt++, dtData,   70,  daRight,  false,	"prop_scp_mqc_qty",true,  "", dfNullInteger, 0,	false, false, 6);
	                     InitDataProperty(0, cnt++, dtData,   70,  daRight,  false,	"coffr_mqc_qty",   false, "", dfNullInteger, 0,	false, false, 6);
					 }                     
                     InitDataProperty(0, cnt++, dtData,   70,  daRight,  false,	"fnl_mqc_qty",	   false, "", dfInteger, 0,	false, false, 6);
                     InitDataProperty(0, cnt++, dtData,   80,  daCenter, false,	"eff_dt",	   	   false, "", dfDateYmd, 0,	false, false);
                     InitDataProperty(0, cnt++, dtData,   80,  daCenter, false,	"exp_dt",		   false, "", dfDateYmd, 0,	false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"src_info_cd",	   false, "", dfNone,	 0,	false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, true,  "src_info_dtl",    false, "", dfNone, 	 0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"prc_prog_sts_cd", false, "", dfNone,	 0,	false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, true,  "prc_prog_sts_dtl", false, "", dfNone, 	 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 	   false, "", dfNone, 	 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd",     false, "", dfNone, 	 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_dt", 		   false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "mn_eff_dt", 	   false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "mn_exp_dt", 	   false, "", dfDateYmd, 0, false, false);                     
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "du_eff_dt", 	   false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "du_exp_dt", 	   false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
				     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "dur_dup_flg",      false, "", dfNone, 	0, false, false);

                     ColHidden("chk") = true;
                     CountPosition = 0;
                     WaitImageVisible = false;
 				}
                 break;
             case "sheet2"://sub mqc
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;
                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);
                     var HeadTitle = "|sel|prop_no|amdt_seq|Sub.MQC|EFF Date|EXP Date|Source|Source|Status|Status|acptusrid|acptofccd|acptdt|mneffdt|mnexpdt||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  				  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
                     InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                     InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
                     
 					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "prop_no",  	   true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden, 90,  daLeft,   false, "amdt_seq", 	   true,  "", dfNone,    0, false, false);
					 if (amdt_seq == "0"){
						 InitDataProperty(0, cnt++, dtData,   290, daLeft,	 false,	"sub_mqc_ctnt",	   true , "", dfNone,	 0,	true, true);
					 }else{
						 InitDataProperty(0, cnt++, dtData,   290, daLeft,	 false,	"sub_mqc_ctnt",	   true , "", dfNone,	 0,	false, true);
					 }                     
                     InitDataProperty(0, cnt++, dtData,   70,  daCenter, false,	"eff_dt",	   	    false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtData,   70,  daCenter, false,	"exp_dt",		    false, "", dfDateYmd, 0, false, false); 					          
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"src_info_cd",	    false, "", dfNone,	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, true,  "src_info_dtl",     false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtCombo,  80,  daCenter, false,	"prc_prog_sts_cd",  false, "", dfNone,	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 80,  daCenter, true,  "prc_prog_sts_dtl", false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", 	    false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_ofc_cd",      false, "", dfNone, 	  0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_dt", 		    false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "mn_eff_dt", 	    false, "", dfDateYmd, 0, false, false);
                     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "mn_exp_dt", 	    false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone,  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "dur_dup_flg",      false, "", dfNone, 	  0, false, false);
                     
				     WaitImageVisible = false;
                     ColHidden("chk") = true;
                     CountPosition = 0;
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
         sheetObj.ShowDebugMsg = false;
         try{
             switch(sAction) {
 	 		case IBSEARCH_ASYNC10: //combo setting,scope 조회
 		        //srcInfocd		        
 	 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 	 			sheetObjects[1].InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
 		        //status
 	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
 	 			sheetObjects[1].InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);	 			
 	 			sheetObj.InitDataCombo(0,"cntr_lod_ut_cd", lodUtCdText, lodUtCdValue);
 	 			
 	 			// 화면 로딩시 Service Scope 조회
 				comboObjects[0].RemoveAll();				
 				formObj.f_cmd.value = SEARCH13;
 				var sParam = FormQueryString(formObj) + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value;				
 				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);					
 				ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");  				
 				break; 								
             case IBSEARCH:      //조회			
 				ComOpenWait(true);
             	formObj.f_cmd.value = SEARCH01;				
             	sheetObj.DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj));
             	//SUB MQC조회
 				if (ComTrim(formObj.svc_scp_nm.value) ==""){//Main일 경우
 					formObj.f_cmd.value = SEARCH02;		
 					sheetObjects[1].DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj));
 				}				
 				ComOpenWait(false); //->waiting->End
 				buttonControl(); 				
 				break;
             case IBSEARCH_ASYNC01:      //조회				
             	ComOpenWait(true);
             	formObj.f_cmd.value = SEARCH02;				
 				sheetObjects[1].DoSearch("ESM_PRI_0020GS.do", FormQueryString(formObj)); 	
 				ComOpenWait(false); //->waiting->End
 				break;
  			 case IBSAVE:        //저장		
  			 	ComOpenWait(true); //->waiting->start 
  			 	if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 	             if (!ComPriConfirmSave()) {
 	                 return false;
 	             } 		 	            
 	             
  			 	if (sheetObj.id == "sheet1"){
  	  			 	if (sheetObj.id == "sheet1"){
  	  			 		checkAllSave();	
  	  			 	}  			 		 		
  			 		if (ComTrim(formObj.svc_scp_nm.value) != ""){
  			 			var saveChk = mqcCheck(sheetObj,"N");
  			 			if (saveChk == false){
  			 				ComShowCodeMessage('PRI01008');
  			 				return false;
  			 			}
  			 		}else{
  			 			var saveChk = mqcCheck(sheetObj,"Y");
  			 			if (saveChk == false){
  			 				ComShowCodeMessage('PRI01008');
  			 				return false;
  			 			}
  			 		}  			 		
  			 	}
  			 	  			 	
  			 	if (sheetObj.id == "sheet1"){
  			 		formObj.f_cmd.value = MULTI01;
  			 	}else{
  			 		formObj.f_cmd.value = MULTI02;
  			 	}  			 	
  			 	
             	for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
             		// C/Offer 금액이 입력되었을 경우, prc_prog_sts_cd를 Returned로 변경해준다.
             		if (sheetObj.RowStatus(i) == "U"
             				&& getMainStatus() == "Q"
             				&& sheetObj.CellValue(i, "prc_prog_sts_cd") == "I"
             				&& sheetObj.CellValue(i, "coffr_mqc_qty") != null
             				&& sheetObj.CellValue(i, "coffr_mqc_qty") != "") {
             			sheetObj.CellValue(i, "prc_prog_sts_cd") = "R";
             		}             		
             		// C/Offer 금액이 Clear되었을 경우, prc_prog_sts_cd를 Initial로 변경해준다.
             		if (sheetObj.RowStatus(i) == "U"
         				&& getMainStatus() == "Q"
         				&& sheetObj.CellValue(i, "prc_prog_sts_cd") == "R"
         				&& (sheetObj.CellValue(i, "coffr_mqc_qty") == null || sheetObj.CellValue(i, "coffr_mqc_qty") == "0")) {
         			sheetObj.CellValue(i, "prc_prog_sts_cd") = "I";
             		}
         		}
				
  				var sParam = FormQueryString(formObj);
  				var sParamSheet = sheetObj.GetSaveString();  				
  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0020GS.do", sParam+"&"+sParamSheet);
  				sheetObj.LoadSaveXml(sXml);
  				formObj.amendcancel_gbn.value = "";
 				ComOpenWait(false); //->waiting->End
                break;
  			 case MODIFY01:        //accept
  			 	ComOpenWait(true); //->waiting->start 
 	 			var req_usr_flg = formObj.req_usr_flg.value;
 	 			var apro_usr_flg = formObj.apro_usr_flg.value;
 	 			var sts = getMainStatus();
 	 			
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }

 			 	 if (sheetObj.id == "sheet1"){
 	 			 	formObj.f_cmd.value = MODIFY01;
 	 			 	var cQty = sheetObj.CellValue(sheetObj.RowCount,"coffr_mqc_qty");
 	 			 	var pQty = sheetObj.CellValue(sheetObj.RowCount,"prop_scp_mqc_qty");
 	 			 	var fQty = 0;
 	 			 	// request 상태일 경우 accept를 하면 pQty 가 final 로
 	 			 	// returned일 경우 승인권자 Accept시 pQty 가 final로, sale rep가 accept하면 cQty가 final로
 	 			 	//accept cancel 시 final은 0으로..
 	 			 	//승인권자에 상관 없이 메인의 status에 따라 변경
 	 			 	if (sts == "Q"){
 	 			 		fQty = pQty;
 	 			 	}else if (sts == "R"){	 			 		
 	 			 		fQty = cQty;
 	 			 	}
 	 			 	sheetObj.CellValue(sheetObj.RowCount,"fnl_mqc_qty") = fQty;
 	 			 	
  			 	 }else{
  			 		formObj.f_cmd.value = MODIFY11;
  			 	 } 		
 				var rVal = sheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0020GS.do");
		
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;		  			 
  			 case MODIFY02:        //accept cancel
  			 	ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            } 		
  			    var rVal = "";
 			 	 if (sheetObj.id == "sheet1"){
   			 		formObj.f_cmd.value = MODIFY02;
   			 		sheetObj.CellValue(sheetObj.RowCount,"fnl_mqc_qty") = 0;
   			 		rVal = sheetAcceptCancelReturnCheckedRows(sheetObj,formObj,"ESM_PRI_0020GS.do");
   			 	 }else{
   			 		formObj.f_cmd.value = MODIFY12;
   			 		rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0020GS.do", false)
   			 	 }
	
 			 	ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	  			 
  			 case MODIFY03:        //amend			
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var colName = "";
  			 	if (sheetObj.id == "sheet1"){
  			 		if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  			 			colName = "cntr_lod_ut_cd|prop_scp_mqc_qty";
  			 		}else{
  			 			colName = "prop_scp_mqc_qty";
  			 		} 
  			 	}else{
  			 		colName = "sub_mqc_ctnt";
  			 	}  			 	
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						sheetAmendRow(sheetObj,formObj,chkArr[0],"M", colName);						
 					}
 				}else{ 					
 					sheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", colName);					
 				}
 				if (sheetObj.id == "sheet1"){
 					sheetObj.SelectCell(2,"prop_scp_mqc_qty");
 				}else{
 					sheetObj.SelectCell(2,"sub_mqc_ctnt");
 				} 			
 				formObj.amendcancel_gbn.value = "";
 				break;  			 	
  			 case MODIFY04:        //amend cancel
 				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var colName = "";
 			 	if (sheetObj.id == "sheet1"){
  					if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  						colName = "cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
  					}else{
  						colName = "prop_scp_mqc_qty|coffr_mqc_qty";
  					} 		
 			 	}else{
 			 		colName = "sub_mqc_ctnt";
 			 	}				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{
 						sheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", colName);		
 					}
 				}else{ 
 					sheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", colName);
 					
 				}	
 				setScMqc(sheetObj);//S/C MQC 값 변경   
 				//checkallsave에서 사용 amend cancel일 경우 Y로 setting
 				formObj.amendcancel_gbn.value = "Y";
 				
 				break; 			 
  			case MODIFY05: // Accept All
  				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}

 				formObj.f_cmd.value = MODIFY05;
 				formObj.sts_cd.value = 'A';
 				var sParam = FormQueryString(formObj);

 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0020GS.do", sParam);
 				sheetObj.LoadSaveXml(sXml);			
 			
 				if(ComGetEtcData(sXml,"rValue") > 0){
 					changeAcceptStatus(sheetObj,"A");
 				}
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}			
 				formObj.f_cmd.value = MODIFY06;
 				formObj.sts_cd.value = 'I';
 				var sParam = FormQueryString(formObj); 				
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0020GS.do", sParam);
 				sheetObj.LoadSaveXml(sXml);			
 			
 				if(ComGetEtcData(sXml,"rValue") > 0){
 					if (sheetObj.CellValue(sheetObj.RowCount, "coffr_mqc_qty") == 0 ){
 						changeAcceptStatus(sheetObj,"I");
 					}else{
 						changeAcceptStatus(sheetObj,"R");
 					} 					
 				}			
 				ComOpenWait(false); //->waiting->End
 				buttonControl();
 				break;	 			 
  			case IBINSERT: // Row Add		
  				var formObj = document.form;
 				var amdt_seq = formObj.amdt_seq.value;

 				if (getValidRowCount(sheetObj) > 0){
 					ComShowCodeMessage("PRI01002");
 					return;
 				}  
  				if (sheetObj.SelectRow > 0){
  					if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=""){
  						ComShowCodeMessage("PRI01002");
  						return;
  					}
  				}
 				var idx = sheetObj.DataInsert();					
 				sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
 				sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
 				sheetObj.CellValue2(idx, "eff_dt") = formObj.main_eff_dt.value;
 				sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
 				sheetObj.CellValue2(idx, "exp_dt") = formObj.main_exp_dt.value;
 				sheetObj.CellValue2(idx, "mn_eff_dt") = formObj.main_eff_dt.value;
 				sheetObj.CellValue2(idx, "mn_exp_dt") = formObj.main_exp_dt.value;
 				sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
 				sheetObj.CellValue2(idx, "src_info_cd") = "NW";
 			
 				if(amdt_seq!=0){
 					sheetObj.CellFont("FontColor", idx, "sub_mqc_ctnt", idx, "prc_prog_sts_dtl")= sheetObj.RgbColor(255,0,0);
 			         //backcolor change
 			         changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
 				}
 				sheetObj.SelectCell(1,"sub_mqc_ctnt");
 				break;	 
 			case IBDELETE: // Delete					
 				var amdt_seq = formObj.amdt_seq.value;
 				var colName = "";
 			 	if (sheetObj.id == "sheet1"){
  					if (ComTrim(formObj.svc_scp_nm.value) == ""){		
  						colName = "cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
  					}else{
  						colName = "prop_scp_mqc_qty|coffr_mqc_qty";
  					} 		
 			 	}else{
 			 		colName = "sub_mqc_ctnt";
 			 	}							
 			
 				if(amdt_seq=="0"){	
 					if (validateForm(sheetObj,document.form,sAction)) {
 						sheetObj.CellValue(sheetObj.SelectRow,"chk")=1;
 						deleteRowCheck(sheetObj, "chk");
 					}
 				}else{					
 					var eff_dt = formObj.eff_dt.value;
 					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
 					
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
 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D",colName);
 								sRow++;
 							}
 						}
 						deleteRowCheck(sheetObj, "chk");
 					}else{ 
 						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!=amdt_seq || ( sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")==amdt_seq && sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd")!="NW")){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
 							comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"D",colName);
 						}else{
 							sheetObj.CellValue(sheetObj.SelectRow,"chk")=1;
 							deleteRowCheck(sheetObj, "chk");
 						}	
 					}					
 				}
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
      * OnChange 이벤트 발생시 호출되는 function <br>
      * 콤보의 SVC Scope명칭을 INPUT BOX에 채운다. <br>
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
  		try{
  	    	var formObj = document.form;  		
  	  		var arrText = text.split("|");
  	  		if (arrText != null && arrText.length > 1) {
  	  			formObj.svc_scp_nm.value = arrText[1];
  	  			ComOpenWait(true);
  	  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  	  			ComOpenWait(false);
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
      
  /**
   * OnBlur 이벤트 발생시 호출되는 function <br>
   * 콤보의 SVC Scope명칭을 INPUT BOX에 채운 후 조회한다. <br>
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
 	function svc_scp_cd_OnBlur(comboObj) {
	   try{
		   var formObj = document.form;		
		   var code = comboObj.FindIndex(comboObj.Code, 0);
			
			if (code != null && code != "") {
				var text = comboObj.GetText(code, 1);
				if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
					formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
					ComOpenWait(true);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComOpenWait(false);
				}
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
      
      
      /**
       * OnChange 이벤트 발생시 호출되는 function <br>
       * SubMqc의 내용을 Display 한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.06.104
       */       
      function select_Onchange(){
  		var selectObj = document.form.selectMqc;						
  		if (selectObj[1].selected){
  	      	document.all.subDivMqc.style.display = "inline";
  	      	window.dialogHeight = "455px"
  		}else{
  	      	document.all.subDivMqc.style.display = "none";
  	      	window.dialogHeight = "330px"
  		}
      }
       	
   /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Proposal, C/Offer 내용을 Final에 채운다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  	
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	switch(colname)
    	{
	    	case "prop_scp_mqc_qty":
            	if (sheetObj.CellValue(Row,Col) < 0){
            		sheetObj.CellValue2(Row, Col) = 0;
            	}
	    		setScMqc(sheetObj);//S/C MQC 값 변경   		
	    		break;
	    	case "coffr_mqc_qty":
            	if (sheetObj.CellValue(Row,Col) < 0){
            		sheetObj.CellValue2(Row, Col) = 0;
            	}
	    		setScMqc(sheetObj);//S/C MQC 값 변경
	    		break;
	    	case "cntr_lod_ut_cd":
	    		formObj.unit.value = sheetObj.CellText(Row,Col);	    		
	    		break;   
	    	
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
		var formObj = document.form;
		formObj.save_gbn.value = "";
		formObj.save_scp.value = "";
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
		var amdt_seq = document.form.amdt_seq.value;
		var formObj = document.form;
		
		if (sheetObj.RowCount > 0){			
			setSearchEnd(sheetObj);
		}
		
		var sCols = "";
		if (ComTrim(formObj.svc_scp_nm.value) == ""){		
			sCols = "cntr_lod_ut_cd|prop_scp_mqc_qty|coffr_mqc_qty";
		}else{
			sCols = "prop_scp_mqc_qty|coffr_mqc_qty";
		}		
		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value);
		
		formObj.amendcancel_gbn.value = "";

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
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 Font Style을 지정한다. <br>
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
			var sCols = "sub_mqc_ctnt";
			searchEndFontChange(sheetObj, sCols);
		}
	}
     
     /**
      * OnSearchEnd 이벤트 발생시 호출되는 function <br>
      * 조회 완료 후 Font Style을 지정한다.
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
 		var amdt_seq = document.form.amdt_seq.value;
		var formObj = document.form
		var maxRow = sheetObj.RowCount;
 		formObj.dur_sub_dup_flg.value =  sheetObj.CellValue(maxRow,"dur_dup_flg");
		var sCols = "sub_mqc_ctnt";
		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 		
 		 		
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
    * 조회가 끝난 후 호출하는 function <br>
    * 조회한 sheet의 값을 INPUT BOX에 Update한다.
    * <br><b>Example :</b>
    * <pre>
    *      setSearchEnd (sheetObj)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @return 없음
    * @author 공백진
    * @version 2009.05.20
    */ 			
	function setSearchEnd (sheetObj){
		var formObj = document.form
		var maxRow = sheetObj.RowCount;

		//duration setting scope table의 값을 setting
		formObj.dur_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(maxRow,"du_eff_dt"),"ymd","-");//(main,scope)duration
		formObj.dur_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(maxRow,"du_exp_dt"),"ymd","-");//duration
		
		//sub mqc mn_eff_dt ,mn_exp_dt value 를 넣기 위하여.
		formObj.main_eff_dt.value = sheetObj.CellValue(maxRow,"mn_eff_dt"); //(main,scope) eff_dt
		formObj.main_exp_dt.value = sheetObj.CellValue(maxRow,"mn_exp_dt");	//(main,scope) exp_dt
		
		//sub mqc eff_dt ,exp_dt value 를 넣기 위하여.
		formObj.eff_dt.value = sheetObj.CellValue(maxRow,"mn_eff_dt");
		formObj.exp_dt.value = sheetObj.CellValue(maxRow,"mn_exp_dt");	
		formObj.pre_exp_dt.value = ComGetDateAdd(sheetObj.CellValue(maxRow,"mn_eff_dt"), "D", -1);
		//unit 값 setting
		formObj.unit.value = sheetObj.CellText(maxRow,"cntr_lod_ut_cd"); 			
		formObj.dur_dup_flg.value =  sheetObj.CellValue(maxRow,"dur_dup_flg");

		// S/C MQC값 setting 
		setScMqc(sheetObj);		

	}
	
	
    /**
    * Sheet에서 변경된 MQC의 값을 S/C MQC의 값으로 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     setScMqc (sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @author 공백진
    * @version 2009.04.17
    */	
	function setScMqc (sheetObj){
		var formObj = document.form
		var maxRow = getValidRowCount(sheetObj);
		if (ComTrim(formObj.svc_scp_nm.value) !=""){
			return;
		}
		//final이 입력되어 있다면 final 값으로 S/C MQC 값을 채우고 비어 있다면 Proposal값으로
		if (sheetObj.CellValue(maxRow,"coffr_mqc_qty") == "" 
			|| sheetObj.CellValue(maxRow,"coffr_mqc_qty") == "0"
			|| formObj.prop_sts_cd.value == "I"	){
			formObj.sc_mqc.value = ComAddComma(sheetObj.CellValue(maxRow,"prop_scp_mqc_qty"));
			
		}else{
			formObj.sc_mqc.value = ComAddComma(sheetObj.CellValue(maxRow,"coffr_mqc_qty"));
			
		}
	}
    
    /**
    *  버튼을 제어하는  function <br>
    *  <br>
    * <br><b>Example :</b>
    * <pre>
    *		buttonControl()
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
		var sts = getMainStatus();	
		
		try{
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
			
			switch(sts) { 				
				case 'I':   // Initial
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");		
					ComBtnDisable("btn_AcceptAll");					
					ComBtnDisable("btn_CancelAll");
					if (amdt_seq == "0"){
						ComBtnDisable("btn_Save");
				
						
//						sheetObjects[0].CellEditable(Row, "dir_call_flg") = true;
					}
					if (reqUsrFlg != "true" && aproUsrFlg != "true"){
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Save2");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_Delete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");	
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll"); 
						ComBtnDisable("btn_New2");
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
							sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
						}
						for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
							sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
						}
					}					
					
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
					}
					
					break;
				case 'A': // Approved
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");				
				
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
						sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
						sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
					}
					for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
						sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
					}	
					break;
					
				case 'Q':// Requested    save 관련 수정금지 - countoffer가 있는 경우 승인권자는 수정할 수 있다.

					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");
					
					if (aproUsrFlg == "true"){
						if (amdt_seq != "0"){
							ComBtnEnable("btn_Save");
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_CancelAll");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");							
						}else{
							ComBtnDisable("btn_Save");
							
							
						}
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
							sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
							if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd") == "A"){
								sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
							}else{
								sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = true;
							}
						}
					}else{
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_CancelAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");		
						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
							sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
							sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
							sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
						}
					}											
							
					for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
						sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
					}						
					break;
			
				case 'R':  // Returned
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");					
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");	
					
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");			
					
					if(reqUsrFlg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_Accept2");
					}
					
					if (aproUsrFlg == "true"){
						ComBtnEnable("btn_AcceptAll");
						ComBtnEnable("btn_CancelAll");
						ComBtnEnable("btn_Accept");
						ComBtnEnable("btn_AcceptCancel");
						ComBtnEnable("btn_Accept2");
						ComBtnEnable("btn_AcceptCancel2");	
					}
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
						sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
						sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
					}

					for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
						sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
					}

					break;
				case 'F': // Filed
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");
					ComBtnDisable("btn_New2");
					ComBtnDisable("btn_Delete2");
					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					
		
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
						sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
						sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
					}
					for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
						sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
					}	
		
					break;
				case 'C': //  // Cancled
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Save2");

					ComBtnDisable("btn_Amend");
					ComBtnDisable("btn_AmendCancel");
					
					ComBtnDisable("btn_Amend2");
					ComBtnDisable("btn_AmendCancel2");						
					
					ComBtnDisable("btn_AcceptAll");
					ComBtnDisable("btn_CancelAll");
					ComBtnDisable("btn_Accept");
					ComBtnDisable("btn_AcceptCancel");
					ComBtnDisable("btn_Accept2");
					ComBtnDisable("btn_AcceptCancel2");							
					for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
						sheetObjects[0].CellEditable(i,"cntr_lod_ut_cd") = false;
						sheetObjects[0].CellEditable(i,"prop_scp_mqc_qty") = false;
						sheetObjects[0].CellEditable(i,"coffr_mqc_qty") = false;
					}
					for (var i = 1; i <= sheetObjects[1].RowCount ;i++){
						sheetObjects[1].CellEditable(i,"sub_mqc_ctnt") = false;
					}		
					break;
				default:
    				showButton("btn_Amend");
    				showButton("btn_AmendCancel");
    				showButton("btn_Amend2");
    				showButton("btn_AmendCancel2");
    				ComBtnEnable("btn_AcceptAll");
    				ComBtnEnable("btn_CancelAll");
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
   	

		
    /**
    * Scope MQC의 값을 가져와서 Main MQC와 비교한다. <br>
    * Scope MQC의 값이 크다면 저장할 수 없다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     mqcCheck (sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} isAll   Y: Scope Mqc전체 합
    *                         N: 선택된 Scope Mqc를 제외한 Scope Mqc의 합
    * @author 공백진
    * @version 2009.04.17
    */	
	function mqcCheck (sheetObj, isAll){
		var formObj = document.form;
		
		if (formObj.save_gbn.value == "Y"){//Main,Scope저장 시 Scoe,Main을 같이 저장할 경우 체크안함			
			return true;
		}
		
		if (isAll !="Y"){
			formObj.f_cmd.value = SEARCH03;			
		}else{
			formObj.f_cmd.value = SEARCH04;
		}
		
		var sXml = sheetObj.GetSearchXml("ESM_PRI_0020GS.do", FormQueryString(formObj));		
		var arrData = ComPriXml2Array(sXml, "prop_scp_mqc_qty");

		if (arrData != null && arrData.length > 0) {
			if (isAll != "Y"){
				var scpMqc = 0;
				if (sheetObj.CellValue(sheetObj.RowCount,"coffr_mqc_qty") != 0){
					scpMqc = sheetObj.CellValue(sheetObj.RowCount,"coffr_mqc_qty");
				}else{
					scpMqc = sheetObj.CellValue(sheetObj.RowCount,"prop_scp_mqc_qty");	
				}
		
				if (arrData[0][0] != ""){
					scpMqc = parseInt(scpMqc) + parseInt(arrData[0][0]);	
				}				
				if (ComParseInt(scpMqc) > ComParseInt(ComGetUnMaskedValue(formObj.sc_mqc.value,",",","))){//크다면 저장금지

					return false;
				}

			}else{
				var scpMqc = sheetObj.CellValue(sheetObj.RowCount,"prop_scp_mqc_qty");		
				if (parseInt(arrData[0][0]) > parseInt(scpMqc)){					
					return false;
				}

			}
			
		}
		return true;	
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
	  		case IBDELETE: // Delete
		 	 	if (sheetObj.SelectRow <= 0){
					ComShowCodeMessage('PRI01002');
					return false;
			 	 }else{
			 		 return true;
			 	 }
	
				break;
	  		case IBSAVE://save
				var sParam = FormQueryString(formObj);
				var sParamSheet = sheetObj.GetSaveString();  
				
				if (sParamSheet == ""){
					return false;
				}
				
				if (!sheetObj.IsDataModified ) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
				
	  		
	  			return true;
	  			break;
	  		case MODIFY03: // amend
		 	 	if (sheetObj.SelectRow <= 0){
					ComShowCodeMessage('PRI01002');
					return false;
			 	 }else{
			 		 return true;
			 	 }

				break;  			
  			
  		}//end switch
  	}

     
     /**
      * sheet 에 대하여 check 된 Row 를 Accept 처리한다.
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object
      * sUrl        : 처리 대상 Row
      * isAll       : 대상 Row 전체에 적용할 것인지 여부
      *           ex) sheetAcceptCheckedRows(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
      * @return {string}
      * @author 변영주
      * @version 2009.05.29
      */
     function sheetAcceptCheckedRows(sheetObj,formObj,sUrl, isAll){
         var amdt_seq    = formObj.amdt_seq.value;
         var prop_sts_cd = getMainStatus();
         var eff_dt      = formObj.eff_dt.value;

         if(isAll == undefined || isAll ==""){
             isAll = false;
         }

         if(prop_sts_cd == "R") {
             if(isAll){
                 comChangeValue(sheetObj, "chk", "0");
                 comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|R");
                 if(sheetObj.CheckedRows("chk") == 0) {
                     ComShowCodeMessage("PRI00301");
                     return false;
                 }
             }

             var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

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

             comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");

             var sParam = FormQueryString(formObj);
             var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
             sParam = sParam + "&" + sParamSheet;
             var sXml = sheetObj.GetSaveXml(sUrl, sParam);
             sheetObj.LoadSaveXml(sXml, false, "chk");

             comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
         } else {
             if(isAll){
                 comChangeValue(sheetObj, "chk", "0");
                 comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|I");
                 if(sheetObj.CheckedRows("chk")==0){
                     //ComShowCodeMessage("PRI00301");
                     ComShowCodeMessage("PRI00329");
                     return false;
                 }
             }
             
             var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
             
             if(chkArr.length == 0){
                 sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
                 chkArr[0] = sheetObj.SelectRow;
             }
             for(i=0;i<chkArr.length;i++){
                 /*
                 if((sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I" && sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R") || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                     sheetObj.CellValue2(chkArr[i],"chk") = "0";
                     ComShowCodeMessage("PRI00313");
                     return false;
                 }
                 */
                 if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I" && sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R"){
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
             
             comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
             
             var sParam = FormQueryString(formObj);
             var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
             sParam = sParam + "&" + sParamSheet;
             var sXml = sheetObj.GetSaveXml(sUrl, sParam);
             sheetObj.LoadSaveXml(sXml, false, "chk");
             
             comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
         }
         return true;

     }     
     
     /**
      * sheet 에 대하여 check 된 Row 를 Accept Cancel 처리한다.  
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object  
      * sUrl        : 처리 대상 Row
      * isAll       : 대상 Row 전체에 적용할 것인지 여부
      * 			ex) sheetAcceptCancelReturnCheckedRows(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
      * @return {string} 
      * @author 변영주
      * @version 2009.05.29
      */		
  	function sheetAcceptCancelReturnCheckedRows(sheetObj,formObj,sUrl,isAll){
  		var eff_dt  = formObj.eff_dt.value;
  		var amdtSeq = formObj.amdt_seq.value;
  		if(isAll == undefined || isAll ==""){
  			isAll = false;
  		}

  		if(isAll){
  			comChangeValue(sheetObj, "chk", "0");
  			comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|A");
  			if(sheetObj.CheckedRows("chk")==0){
  				ComShowCodeMessage("PRI00301");
  				return false;				
  			}			
  		}
  		
  		var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

  		if(chkArr.length == 0){
  			sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
  			chkArr[0] = sheetObj.SelectRow;
  		}

  		for(i=0;i<chkArr.length;i++){

  			if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="A" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdtSeq){
  				sheetObj.CellValue2(chkArr[i],"chk") = "0";				
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  		}
  		
  		for(i=0;i<chkArr.length;i++){
  			sheetObj.CellValue2(chkArr[i], "chk" ) = "1";
  			if (sheetObj.CellValue(chkArr[i], "coffr_mqc_qty") !="0"){
  				sheetObj.CellValue2(chkArr[i], "prc_prog_sts_cd" ) = "R";
  				
  			}else{
  				sheetObj.CellValue2(chkArr[i], "prc_prog_sts_cd" ) = "I";
  			}
  		}  		
		
  		var sParam = FormQueryString(formObj);
  		var sParamSheet = sheetObj.GetSaveString(false, false, "chk");
  		sParam = sParam + "&" + sParamSheet;
  		var sXml = sheetObj.GetSaveXml(sUrl, sParam);
  		sheetObj.LoadSaveXml(sXml, false, "chk"); 
  		
  		comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");					
  		
  		return true;
  	}    
      
      

      /**
      * 대상 ROW 를 Amend 처리한다. <br>
      * sheetObj    : 처리 대상 sheet object
      * formObj     : 처리 대상 form object
      * sRow        : 처리 대상 Row
      * sAction     : M : Update Amend, D : Delete Amend
      * sCols       : eff_dt, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
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
         var dur_dup_flg  = "";
         
         var sheetID = sheetObj.id;
         if (sheetID == "sheet1"){
        	 dur_dup_flg  = formObj.dur_dup_flg.value;
         }else{
        	 dur_dup_flg  = formObj.dur_sub_dup_flg.value;
         }
         
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
		 sheetObj.CellValue2(idx, "prop_scp_mqc_qty") = "";
		 sheetObj.CellValue2(idx, "coffr_mqc_qty") = "";
		 sheetObj.CellValue2(idx, "fnl_mqc_qty") = "";
         
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
     *           ex) comSheetAmendCancelRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
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
         var dur_dup_flg  = "";
         
         var sheetID = sheetObj.id;
         if (sheetID == "sheet1"){
        	 dur_dup_flg  = formObj.dur_dup_flg.value;
         }else{
        	 dur_dup_flg  = formObj.dur_sub_dup_flg.value;
         }
         
         sheetObj.CellValue(sRow,"chk")=0;

         //  A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
         if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
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
             if(dur_dup_flg=="Y"){            
             	sheetObj.CellValue2(idx,"exp_dt")=exp_dt;
             }
                          
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
     * 대상 ROW 를 Accept or Initial 처리한다.
     * sheetObj    : 처리 대상 sheet object
     * type   		: A : Accept , I : Initial R :Returned
     *           ex) changeAcceptStatus(sheetObjects[1],"A");
     * @author 공백진
     * @version 2009.05.29
     */         
     function changeAcceptStatus(sheetObj,type){
	   	 var formObj = document.form;
	   	 var amdtSeq = formObj.amdt_seq.value;
	   	 var sheetObj2 = sheetObjects[1];
	   	 var stsCd = "";
	   	 var stsDtl = "";
	   	 if (type == "A"){
	   		 stsCd = "A";
	   		 stsDtl = "Accepted";
	   	 }else if (type =="I"){
	   		 stsCd = "I";
	   		 stsDtl = "Initial";
	   	 }else{
	   		 stsCd = "R";
	   		 stsDtl = "Returned";
	   	 }
	   	 for (var i = 1; i <=2; i++){
	   		 if (sheetObj.CellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.CellValue(i, "prc_prog_sts_cd") != stsCd ){
	   			 sheetObj.CellValue(i, "prc_prog_sts_cd") = stsCd;
	   			 sheetObj.CellValue(i, "prc_prog_sts_dtl") = stsDtl;
	   			 if (stsCd=="R" || stsCd=="I"){
	   				sheetObj.CellValue(i, "fnl_mqc_qty") = 0;
	   			 }else{
	   				 if (getMainStatus() =="Q"){
	   					sheetObj.CellValue(i, "fnl_mqc_qty") = sheetObj.CellValue(i, "prop_scp_mqc_qty");
	   				 }else if (getMainStatus() =="R"){
	   					sheetObj.CellValue(i, "fnl_mqc_qty") = sheetObj.CellValue(i, "coffr_mqc_qty");
	   				 }	   				 
	   			 }
	   		 }
	   		 if (sheetObj2.CellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj2.CellValue(i, "prc_prog_sts_cd") != stsCd ){
	   			 sheetObj2.CellValue(i, "prc_prog_sts_cd") = stsCd;
	   			 sheetObj2.CellValue(i, "prc_prog_sts_dtl") = stsDtl;
	   		 }   		 
	   	 }
     }     

     /**
     * Main의 Status를 조회한다. <br>
     * @return {string}
     * @author 공백진
     * @version 2009.05.29
     */    
     function getMainStatus(){
    	 return dialogArguments.sheetObjects[0].CellValue(1, "prop_sts_cd");
     }
     
     /**
      * 저장시 Scope 의 갯 수를 조회한다.<br>
      * Scope이 한 개 일 경우 Scope,Main 저장 시 사용자에게 Main,Scope을 같이 저장할 지 확인한다.<br> 
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
         
         if (formObj.amendcancel_gbn.value == "Y"){//AMEND CANCEL 시 체크 안함
        	 return;
         }
         formObj.f_cmd.value = SEARCH05;
         
         try{
             var sParam = FormQueryString(formObj);            
             var sXml = sheetObj.GetSearchXml("ESM_PRI_0020GS.do" , sParam);            
          
             var arrData = ComPriXml2Array(sXml, "etc1|etc2");
             if (arrData != null && arrData.length > 0) {
                 var cnt = 0;
                 cnt = ComParseInt(arrData[0][1]);               
                 var scpCd = "";              
                 scpCd = arrData[0][0];
                 
                 var msgCd = "";                 
                 if (ComTrim(formObj.svc_scp_nm.value) != ""){//scope
                	 msgCd = "PRI01133";//scope
                 }else{//main
                	 msgCd = "PRI01134";//main
                 }
            	 if (cnt == 1 ){                 		
            		 if (ComShowCodeConfirm(msgCd)){
						formObj.save_gbn.value = "Y";
						formObj.save_scp.value = scpCd;
						if (sheetObj.CellValue(sheetObj.RowCount, "coffr_mqc_qty") =="0" 
							|| sheetObj.CellValue(sheetObj.RowCount, "coffr_mqc_qty") ==""){
							formObj.sc_mqc.value = sheetObj.CellValue(sheetObj.RowCount, "prop_scp_mqc_qty");

						}else{
							formObj.sc_mqc.value = sheetObj.CellValue(sheetObj.RowCount, "coffr_mqc_qty");
						
						}						
					}else{
						formObj.save_gbn.value = "N"; 
						formObj.save_scp.value = "";
					}             		 
                 } else if(cnt > 1) {
                	 formObj.save_gbn.value = "N";
                	 formObj.save_scp.value = "";
                 }
            	 //amend cancel시 Y로 setting
            	 formObj.amendcancel_gbn.value = "N";
             }        	
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }

         }finally{
         	
         }       
                 
     }        
     
     
	/* 개발자 작업  끝 */