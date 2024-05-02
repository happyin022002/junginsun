/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0022.js
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.21 공백진
* 1.0 Creation
=========================================================
* History
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 기능 개발요청
* 2011.04.22 이행지 [선조치] TPE가 들어있는 SC일 경우만 Attach File 첨부기능 활성화 및 저장 Validation 체크
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
     * @class ESM_PRI_0022 : ESM_PRI_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0022() {
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
 
 var uploadObjects = new Array();
 var uploadCnt = 0;
 //main으로 값을 return 하기위한 변수 (현재 사용안함)
// var returnData ="";
 //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 Y 인 경우 메인을 재조회한다.
 var rData = "N";
 
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
	 				if (!validateForm(sheetObjects[0],document.form,IBSAVE)) {
	 					return false;
	 				}
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
				case "prc_ctrt_pty_tp_cd":
					if (sheetObjects[0].IsDataModified){
						if (formObject.tp_cd.value =="H"){
							formObject.prc_ctrt_pty_tp_cd[0].checked = true;
						}else{
							formObject.prc_ctrt_pty_tp_cd[1].checked = true;
						}
		 				if (validateForm(sheetObjects[0],document.form,IBSAVE)) {
		 					if (!doActionIBSheet(sheetObjects[0],document.form,IBSAVE)){
		 						return;
		 					}
		 				}
					}
					if (formObject.tp_cd.value =="H"){
						formObject.prc_ctrt_pty_tp_cd[1].checked = true;
						formObject.tp_cd.value = "C";
					}else{
						formObject.prc_ctrt_pty_tp_cd[0].checked = true;
						formObject.tp_cd.value = "H";
					}

					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
         
         //UPLOAD 환경 설정
         for(var i=0;i<uploadObjects.length;i++){
 		    //1. 기본 환경 설정
 		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_0022GS.do");
 	        uploadObjects[i].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
 		 }
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
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
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 150;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);
                     var HeadTitle = "|sel|prop_no|amdt_seq|prc_ctrt_pty_tp_cd|cust_cnt_cd|cust_seq|ctrt_cust_val_sgm_cd|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|"
                    	 HeadTitle += "Contract Party|Address|MOC License No|OTI Bond No.|OTI Bond|OTI Bond|OTI Bond|OTI Bond|Tariff Title page|Tariff Title page|Tariff Title page|Tariff Title page|OTI License No.|OTI License|OTI License|OTI License|OTI License|Signing POA|Signing POA|Signing POA|Signing POA|Signature|Title|EFF Date|EXP Date|Source|Source|Status|Status||||";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,	false);


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  			 COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  				  			 POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  			 SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 				     InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 					 InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "prop_no",  	        true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "amdt_seq", 	        true,  "", dfNone,    0, false, false);  
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "prc_ctrt_pty_tp_cd",  true,  "", dfNone,    0, false, false);					 
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "cust_cnt_cd", 		true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "cust_seq", 			false,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_val_sgm_cd",true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_srep_cd", 	true,  "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_sls_ofc_cd",true,  "", dfNone,    0, false, false);	
					 if (amdt_seq == "0"){
						 InitDataProperty(0, cnt++, dtData,      180,	 daCenter,    false, "ctrt_pty_nm",		         true,  "", dfNone,	  0, true,  true, 200);
						 InitDataProperty(0, cnt++, dtData,      220,    daLeft,	  false, "ctrt_pty_addr",	         true,  "", dfNone,	  0, true,  true, 200);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "moc_lic_no",             false, "", dfNone,   0, true, true,15);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "nvocc_bd_no",              false, "", dfNone,   0, true,  true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "oti_bd_atch_file_id",      false, "", dfNone,   0, false, true, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      true,  "oti_bd_atch_file_nm",      false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "oti_bd_atch_file_nm_org",  false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      true,  "oti_bd_atch_file_del",     false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "trf_tit_atch_file_id",     false, "", dfNone,   0, false, true, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      true,  "trf_tit_atch_file_nm",     false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "trf_tit_atch_file_nm_org", false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      true,  "trf_tit_atch_file_del",    false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "nvocc_lic_no",             false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "oti_lic_atch_file_id",     false, "", dfNone,   0, false, true, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      true,  "oti_lic_atch_file_nm",     false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "oti_lic_atch_file_nm_org", false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      true,  "oti_lic_atch_file_del",    false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "poa_atch_file_id",         false, "", dfNone,   0, false, true, 32);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      true,  "poa_atch_file_nm_org",     false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      true,  "poa_atch_file_nm",         false, "", dfNone,   0, false, true);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      true,  "poa_atch_file_del",        false, "", dfNone,   0, false, true);
						 InitDataProperty(0, cnt++, dtData,      100,    daLeft,	  false, "ctrt_pty_sgn_nm",	         true,  "", dfNone,	  0, true,  true, 100);
						 InitDataProperty(0, cnt++, dtData,      100,    daLeft,	  false, "ctrt_pty_sgn_tit_nm",      true,  "", dfNone,	  0, true,  true, 100);
					 }else{
						 InitDataProperty(0, cnt++, dtData,      180,	 daCenter,    false, "ctrt_pty_nm",		         true,  "", dfNone,	  0, false, false, 200);
						 InitDataProperty(0, cnt++, dtData,      220,    daLeft,	  false, "ctrt_pty_addr",	         true,  "", dfNone,	  0, false, false, 200);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "moc_lic_no",               false, "", dfNone,   0, false, false,15);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "nvocc_bd_no",              false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      false, "oti_bd_atch_file_id",      false, "", dfNone,   0, false, false, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      false, "oti_bd_atch_file_nm",      false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      false, "oti_bd_atch_file_nm_org",  false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      false, "oti_bd_atch_file_del",     false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    95,     daLeft,      false, "trf_tit_atch_file_id",     false, "", dfNone,   0, false, false, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      false, "trf_tit_atch_file_nm",     false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    95,     daLeft,      false, "trf_tit_atch_file_nm_org", false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      false, "trf_tit_atch_file_del",    false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false, "nvocc_lic_no",             false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      false, "oti_lic_atch_file_id",     false, "", dfNone,   0, false, false, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      false, "oti_lic_atch_file_nm",     false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    95,     daLeft,      false, "oti_lic_atch_file_nm_org", false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      false, "oti_lic_atch_file_del",    false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      false, "poa_atch_file_id",         false, "", dfNone,   0, false, false, 32);
	                     InitDataProperty(0, cnt++, dtPopupEdit, 100,    daLeft,      false, "poa_atch_file_nm",         false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtHidden,    100,    daLeft,      false, "poa_atch_file_nm_org",     false, "", dfNone,   0, false, false);
	                     InitDataProperty(0, cnt++, dtImage,     20,     daLeft,      false, "poa_atch_file_del",        false, "", dfNone,   0, false, false);
						 InitDataProperty(0, cnt++, dtData,      100,    daLeft,	  false, "ctrt_pty_sgn_nm",	         true,  "", dfNone,	  0, false, false, 100);
						 InitDataProperty(0, cnt++, dtData,      100,    daLeft,	  false, "ctrt_pty_sgn_tit_nm",      true,  "", dfNone,	  0, false, false, 100);
					 }
                     
					 InitDataProperty(0, cnt++, dtData,    90,  daCenter, false, "eff_dt",        false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtData,    90,  daCenter, false, "exp_dt",   		    false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtCombo,   90,  daCenter, false, "src_info_cd", 	    false, "", dfNone, 	  0, false, false);	
				     InitDataProperty(0, cnt++, dtHidden,  90,  daCenter, false, "src_info_dtl",        false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtCombo,   50,  daCenter, false, "prc_prog_sts_cd",     false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  90,  daCenter, false, "prc_prog_sts_dtl",    false, "", dfNone, 	  0, false, false);				    
				     InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "acpt_usr_id", 	    false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "acpt_ofc_cd", 	    false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "acpt_dt", 		    false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtHidden, 100,  daCenter, false, "n1st_cmnc_amdt_seq",      false, "", dfNone, 	0, false, false);
 					 WordWrap = true;
 					 ColHidden("chk") = true;
 					 WaitImageVisible = false;
 					 ShowButtonImage = 2;
		 			 ToolTipOption="balloon:true;width:500;icon:1;";

		 			 ImageList(0)= "/hanjin/img/nolines_minus.gif";
		 			 ImageList(1)= "/hanjin/img/ico_attach.gif";
		 			 PopupButtonImage(0, "oti_bd_atch_file_nm")  = 1;
		 			 PopupButtonImage(0, "trf_tit_atch_file_nm") = 1;
		 			 PopupButtonImage(0, "oti_lic_atch_file_nm") = 1;
		 			 PopupButtonImage(0, "poa_atch_file_nm")	 = 1;
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
	 	 		case IBSEARCH_ASYNC10:
					document.form.prc_ctrt_pty_tp_cd[0].checked = true; 	 		
			        //srcInfocd		        
		 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
			        //status
		 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);				
	 				break;

	 	 		case IBSEARCH_ASYNC20: // option  처리
					formObj.f_cmd.value = SEARCH11;
	 	 			var eleName = "";
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0022GS.do" , FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "cd|etc1");
					var lgcyIfFlg = document.form.lgcy_if_flg.value;
					
					for (var i = 0; arrData !=null && i < arrData.length; i++) {
						if (arrData[i][0] == "H" ){
							eleName = "tp2";
						}else{
							eleName = "tp1";
						}
						document.getElementById(eleName).style.fontWeight = "bold";
						switch (arrData[i][1]){
							case "0":
				 				document.getElementById(eleName).style.fontWeight = "";
				 				document.getElementById(eleName).style.color = "black";
								break;
							case "1":
				 				document.getElementById(eleName).style.color = "black";
								break;
							case "2":
								if (lgcyIfFlg == "Y"){
									document.getElementById(eleName).style.color = "black";
								}else{
									document.getElementById(eleName).style.color = "red";
								}
								
								break;
							case "3":
								if (lgcyIfFlg == "Y"){
									document.getElementById(eleName).style.color = "black";
								}else{
									document.getElementById(eleName).style.color = "blue";
								}							
								break;
						}
					}	 	 		
					break;	
	 	 		case IBSEARCH:      //조회			
	 				formObj.f_cmd.value = SEARCH;
	 	 			ComOpenWait(true); //->waiting->start
	 				sheetObj.DoSearch("ESM_PRI_0022GS.do", FormQueryString(formObj));
	 				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
	 				ComOpenWait(false); //->waiting->End
	 				break;

	 			case IBSAVE:        //저장
	 				ComOpenWait(true); //->waiting->start 
	 				formObj.f_cmd.value = MULTI;
	 			 	
	 				var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();

	 				if (!sheetObj.IsDataModified && sParamSheet == "") {
	 					ComShowCodeMessage("PRI00301");
	 					return false;
	 				}	 			 	
	 				if (sheetObj.IsDataModified && sParamSheet == "") {
	 					return false;
	 				}	 	
	 				var sXml = sheetObj.GetSaveXml("ESM_PRI_0022GS.do", sParam+"&"+sParamSheet);
	 				sheetObj.LoadSaveXml(sXml); 	
	 				ComOpenWait(false); //->waiting->End
	 				break;
	 			 case MODIFY01:        //accept
	 			 	ComOpenWait(true); //->waiting->start 
		            if (!ComShowCodeConfirm("PRI00008")) {
		            	return false;
		            } 			 
					formObj.f_cmd.value = MODIFY01;
					var rVal = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0022GS.do");
	 				ComOpenWait(false); //->waiting->End
					break;			

	 			 case MODIFY02:        //accept cancel
	 			 	ComOpenWait(true); //->waiting->start 
		            if (!ComShowCodeConfirm("PRI00009")) {
		            	return false;
		            } 			 
					formObj.f_cmd.value = MODIFY02;
					var rVal = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0022GS.do");
	 				ComOpenWait(false); //->waiting->End
					break;

	 			 case MODIFY03:        //amend
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");

					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");						
						}
					}else{
						comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|oti_bd_atch_file_nm|oti_bd_atch_file_del|oti_lic_atch_file_nm|oti_lic_atch_file_del|trf_tit_atch_file_nm|trf_tit_atch_file_del|poa_atch_file_nm|poa_atch_file_del");
					}
	 			 	sheetObj.SelectCell(2, "ctrt_pty_nm");
	 			 	fileColumnControl(sheetObj);
					break;	 			 
		
	 			 case MODIFY04:        //amend cancel
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
					
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");		
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm");
						
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
    	 
  		var sCols = "ctrt_pty_nm|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm";
  		searchEndFontChange(sheetObj, sCols,document.form.lgcy_if_flg.value); 	   
    	 
		buttonControl();
		columnControl(sheetObj);

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
    	  var formObj = document.form;
    	  if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {

// 			if (formObj.prc_ctrt_pty_tp_cd[1].checked){
// 				returnData = sheetObjects[0].CellValue(sheetObjects[0].RowCount,"ctrt_pty_nm");
// 			}
 			rData = "Y";
 			dialogArguments.comUpdateProposalStatusSummary("04", "");
 			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
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
 				hiddenButton("btn_Amend");
 				hiddenButton("btn_AmendCancel");
 				ComBtnDisable("btn_Accept");
 				ComBtnDisable("btn_AcceptCancel");
				for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
					sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = false;
					sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = false;
					sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = false;
					sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = false;
				}	
 				return;
 			}
 			
 			try{
 				switch(sts) { 				
 					case 'I':   // Initial	
							
 						ComBtnDisable("btn_Accept");
 						ComBtnDisable("btn_AcceptCancel");
 						
 						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
 							if (sheetObjects[0].CellValue(i, "prc_prog_sts_cd") == "I"){
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = true;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"oti_lic_atch_file_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"oti_bd_atch_file_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"trf_tit_atch_file_nm") = true;
 	 							sheetObjects[0].CellEditable(i,"poa_atch_file_nm") = true;
 							}else{
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = false;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"oti_lic_atch_file_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"oti_bd_atch_file_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"trf_tit_atch_file_nm") = false;
 	 							sheetObjects[0].CellEditable(i,"poa_atch_file_nm") = false;
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
 							sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = false;
 						}						
 			
 						break;
 				
 					case 'R':  // Returned accept만 가능,
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
 							sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = false;
 						}

 						break;
 					case 'F': // Filed
 						ComBtnDisable("btn_Save");
 						ComBtnDisable("btn_Amend");
 						ComBtnDisable("btn_AmendCancel"); 						
 						ComBtnDisable("btn_Accept");
 						ComBtnDisable("btn_AcceptCancel");
 						for (var i = 1; i <= sheetObjects[0].RowCount ;i++){
 							sheetObjects[0].CellEditable(i,"ctrt_pty_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_addr") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_nm") = false;
 							sheetObjects[0].CellEditable(i,"ctrt_pty_sgn_tit_nm") = false;
 						}
 						break;
 					case 'C': //  // Cancled

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
	   var tpCd = document.form.tp_cd.value;
	   var ctrtCustTpCd = document.form.ctrt_cust_tp_cd.value;
	   var sts = document.form.prop_sts_cd.value;
	   var ctrtEffDt = document.form.ctrt_eff_dt.value;
	   var isTpe = document.form.isTpe.value;
  	 
 		switch (sAction) {	
   			case IBSAVE: // 저장
   				// EFF Date 체크는 추후 삭제가능함 -- 임시적으로 사용
	   			if( tpCd != "H" && ctrtCustTpCd == "N" && isTpe == "Y"){
		        	for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		        		if((sheetObj.CellValue(i, "ibflag") == "I" || sheetObj.CellValue(i, "ibflag") == "U") 
		        		 && sheetObj.CellValue(i, "prc_prog_sts_cd") == "I" && sheetObj.CellEditable(i, "ctrt_pty_nm") && sheetObj.CellValue(i, "eff_dt") >= "20110501")
		        		{
			  				if (sheetObj.CellValue(i, "oti_bd_atch_file_id") == ""){
			  					ComShowCodeMessage("PRI00316", "OTI Bond");
			  					sheetObj.SelectCell(i, "oti_bd_atch_file_nm");
			  					return false;
			  				}
			
			  				if (sheetObj.CellValue(i, "trf_tit_atch_file_id") == ""){
			  					ComShowCodeMessage("PRI00316", "Tariff Title Page");
			  					sheetObj.SelectCell(i, "trf_tit_atch_file_nm");
			  					return false;
			  				}
		        		}
		        	}
	   			}
			 	if (!ComPriConfirmSave()) {
	                 return false;
	            } 
	   			break;
     	}
 		return true;
    }

	/**
  	 * IBUpload Object를 배열로 등록 <br>
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
  	 * 배열은 소스 상단에 정의 <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     setUploadObject(uploadObj);
  	 * </pre>
  	 * @param {ibupload} uploadObj 필수 IBUpload Object
  	 * @return 없음
	 * @author 최성민
	 * @version 2010.10.13
  	 */
  	function setUploadObject(uploadObj) {
  		uploadObjects[uploadCnt++] = uploadObj;
  	}
	/**
	 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function setFileUpload(sheetObj, filePathUrl) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.SelectRow;
		var upObj = uploadObjects[0];
		
		//IBUpload에 파일 추가하기
		var ret = upObj.AddFile(filePathUrl);
		
		return ret;
	}
    
    /**
     * Sheet 컬럼의 edit 여부를 지정하는  function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *		columnControl
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       	
     function columnControl(sheetObj){
    	 var tpCd = document.form.tp_cd.value;
    	 var ctrtCustTpCd = document.form.ctrt_cust_tp_cd.value;
  	     var sts = document.form.prop_sts_cd.value;
  	     var isTpe = document.form.isTpe.value;
  	     
    	 if( tpCd == "H" || ctrtCustTpCd != "N" || isTpe == "N"  ){
    		 
    		 sheetObj.ColHidden("nvocc_bd_no")			= true;
    		 sheetObj.ColHidden("oti_bd_atch_file_nm")	= true;
    		 sheetObj.ColHidden("oti_bd_atch_file_hnm")	= true;
    		 sheetObj.ColHidden("oti_bd_atch_file_del")	= true;
    		 sheetObj.ColHidden("trf_tit_atch_file_nm")	= true;
    		 sheetObj.ColHidden("trf_tit_atch_file_hnm")= true;
    		 sheetObj.ColHidden("trf_tit_atch_file_del")= true;
    		 sheetObj.ColHidden("nvocc_lic_no")			= true;
    		 sheetObj.ColHidden("oti_lic_atch_file_nm")	= true;
    		 sheetObj.ColHidden("oti_lic_atch_file_hnm")= true;
    		 sheetObj.ColHidden("oti_lic_atch_file_del")= true;
    		 sheetObj.ColHidden("poa_atch_file_nm")		= true;
    		 sheetObj.ColHidden("poa_atch_file_hnm")	= true;
    		 sheetObj.ColHidden("poa_atch_file_del")	= true;
    	 } else {
    		 sheetObj.ColHidden("nvocc_bd_no")			= false;
    		 sheetObj.ColHidden("oti_bd_atch_file_nm")	= false;
    		 sheetObj.ColHidden("oti_bd_atch_file_hnm")	= false;
    		 sheetObj.ColHidden("oti_bd_atch_file_del")	= false;
    		 sheetObj.ColHidden("trf_tit_atch_file_nm")	= false;
    		 sheetObj.ColHidden("trf_tit_atch_file_hnm")	= false;
    		 sheetObj.ColHidden("trf_tit_atch_file_del")= false;
    		 sheetObj.ColHidden("nvocc_lic_no")			= false;
    		 sheetObj.ColHidden("oti_lic_atch_file_nm")	= false;
    		 sheetObj.ColHidden("oti_lic_atch_file_hnm")	= false;
    		 sheetObj.ColHidden("oti_lic_atch_file_del")= false;
    		 sheetObj.ColHidden("poa_atch_file_nm")		= false;
    		 sheetObj.ColHidden("poa_atch_file_hnm")		= false;
    		 sheetObj.ColHidden("poa_atch_file_del")	= false;
    	 }
    	 
    	 if( tpCd == "H" || ctrtCustTpCd != "N" ){
    		 sheetObj.ColHidden("moc_lic_no")			= true;
    	 }else{
    		 sheetObj.ColHidden("moc_lic_no")			= false;
    	 }
    	 
    	 fileColumnControl(sheetObj);
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
      * @author 공백진
      * @version 2009.06.03
      */  	      	 
  	function sheet1_OnPopupClick(sheetObj, Row, Col) {
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName){
	    	case "oti_bd_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "oti_bd_atch_file_");
	    		break;

	    	case "oti_lic_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "oti_lic_atch_file_");
	    		break;

	    	case "trf_tit_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "trf_tit_atch_file_");
	    		break;

	    	case "poa_atch_file_nm":
	    		doFileUpload(sheetObj, Row, Col, "poa_atch_file_");
	    		break;
 		}
  	}
      
	/**
	 * OnDblClick 이벤트 발생시 호출되는 function <br>
	 * Sheet의 해당 Sel을 더블클릭 시 메모장을 화면에 표시한다. <br>
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
	function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
		//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
  
		var colname = sheetObj.ColSaveName(Col);
		var sts = document.form.prop_sts_cd.value;

		switch(colname){
 			case "oti_bd_atch_file_nm":
				fileColumnEvent(sheetObj, Row, "OnDblClick", "oti_bd_atch_file_");
 				break;
 			case "oti_lic_atch_file_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "oti_lic_atch_file_");
 				break;
 			case "trf_tit_atch_file_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "trf_tit_atch_file_");
 				break;
			case "poa_atch_file_nm":
 				fileColumnEvent(sheetObj, Row, "OnDblClick", "poa_atch_file_");
 				break;
		}
	}
    /**
 	 * OnDblClick 이벤트 발생시 호출되는 function <br>
 	 * Sheet의 해당 Sel을 더블클릭 시 메모장을 화면에 표시한다. <br>
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
		var colname = sheetObj.ColSaveName(Col);
		var sts = document.form.prop_sts_cd.value;
		
		if ( sts == "I" && sheetObj.CellValue(Row,"prc_prog_sts_cd") == "I"){
			switch(colname){
	      		case "oti_bd_atch_file_del":
					fileColumnEvent(sheetObj, Row, "OnClick", "oti_bd_atch_file_");
					break;
				case "oti_lic_atch_file_del":
					fileColumnEvent(sheetObj, Row, "OnClick", "oti_lic_atch_file_");
					break;
				case "trf_tit_atch_file_del":
					fileColumnEvent(sheetObj, Row, "OnClick", "trf_tit_atch_file_");
					break;
				case "poa_atch_file_del":
					fileColumnEvent(sheetObj, Row, "OnClick", "poa_atch_file_");
					break;
			}
		}
 	}
     
    function doFileUpload(sheetObj, Row, Col, colName){
   		if(sheetObj.CellValue(Row, colName+"id") == ""){
    		//파일선택 다이얼로그 표시하기
 	   		var filePathUrl = sheetObj.OpenFileDialog("Open File");
 	   		
 	   		//선택된 파일명이 있는 경우 처리하기
 	   		if(filePathUrl.indexOf("\\") !=-1 ) {	 	   			
 	   			//IBUpload에 파일 추가하기
				var uploadObj = uploadObjects[0];
				uploadObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
				
				var comFileMaxCount = 1;    // 업로드 가능한 파일의 최대 개수, 기본 256개
				var maxFileSize = 1024;  // 업로드 가능한 파일의 최대 용량, 기본 100MB, 단위 KB
				uploadObj.SetLimit(comFileMaxCount, maxFileSize, maxFileSize);

				ComOpenWait(true); //->waiting->start 
				var ret = setFileUpload(sheetObj, filePathUrl);
				if(ret != ""){
					ComShowCodeMessage("PRI01138");
					ComOpenWait(false); //->waiting->start 
					return;
				}

	  	   		sheetObj.CellEditable(Row, colName+"nm") = false;
	  	   		
 	   			var formObj = document.form;
 	   			
 	   			formObj.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(formObj);
				
				//서버에 request전달하고, reponse 받기	
	            if (uploadObj.LocalFiles != "") {
		            //*******파일이 있는 경우 IBUpload 이용하기*******
					uploadObj.ExtendParam = sParam;
					uploadObj.ParamDecoding = true;
		            sXml = uploadObj.DoUpload(true);
		                
		            var keyId = ComGetEtcData(sXml,"keyId");
		            sheetObj.CellValue2(Row, colName+"id") = keyId;
	            }
	            
	            if (sheetObj.CellValue(Row, colName+"id") != ""){
					sheetObj.CellImage(Row, colName+"del") = 0;
					
					//선택된 파일의 이름만 팝업 셀에 설정하기
	 	   			var fileName = filePathUrl.substr(filePathUrl.lastIndexOf("\\")+1);
	 	   			sheetObj.CellValue2(Row, colName+"nm_org")= fileName;

	 	   			if (fileName.length > 10)
	 	   				fileName = fileName.substring(0,10)+"...";
	 	   				
	 	   			sheetObj.CellValue2(Row, Col)= fileName;
	            }
	            ComOpenWait(false); //->waiting->start 
 	   		}
   		}
    }
    
    function fileColumnControl(sheetObj){
    	var sts = document.form.prop_sts_cd.value;
    	var fileColArray = new Array("oti_bd_atch_file_",
    								 "trf_tit_atch_file_",
    								 "oti_lic_atch_file_",
    								 "poa_atch_file_");

    	for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
	        if( sts == "I" && sheetObj.CellValue(i,"prc_prog_sts_cd") == "I" && sheetObj.CellEditable(i, "ctrt_pty_nm")){
	    		for( var j=0; j < fileColArray.length; j++ ){
        	    	if(sheetObj.CellValue(i,fileColArray[j]+"id") != "")
        	    		sheetObj.CellImage(i,fileColArray[j]+"del") = 0;
        	    	else
        	    		sheetObj.CellEditable(i, fileColArray[j]+"nm") = true;
        	    }
    		}
    	}
    }

    function fileColumnEvent(sheetObj, Row, event, colName){
    	var sts = document.form.prop_sts_cd.value;
    	
    	if ( event == "OnClick" ){
		    if( sts == "I" && sheetObj.CellValue(Row, "prc_prog_sts_cd") == "I" && sheetObj.CellEditable(Row, "ctrt_pty_nm")){
		    	if( sheetObj.CellValue(Row, colName+"id") != "" ){
		    		sheetObj.CellValue(Row, colName+"id") = "";
		    		sheetObj.CellValue(Row, colName+"nm") = "";
		    		sheetObj.CellEditable(Row,colName+"nm") = true;
		    		sheetObj.CellImage(Row, colName+"del") = "";
				}
		    }
	    } else if ( event == "OnDblClick" ){
	    	if(sheetObj.CellValue(Row, colName+"id") != "")
				location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, colName+"id");
	    }
    }
    
    /** 
     * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {int} x 필수, X 좌표
     * @param {int} y 필수, Y 좌표
     * @return 없음
     */   
	function sheet1_OnMouseMove(sheetObj, shift, x, y){
	      var row = sheetObj.MouseRow;
	      var col = sheetObj.MouseCol;
	      var colName = sheetObj.ColSaveName(col);
	      if( colName == "oti_bd_atch_file_nm" 
	    	  || colName == "oti_lic_atch_file_nm" 
	    	  || colName == "trf_tit_atch_file_nm" 
	    	  || colName == "poa_atch_file_nm")
	      {
	    	  var sText = sheetObj.CellText(row,colName+"_org");
	    	  sheetObj.ToolTipText(row,colName) = sText;
	      }

	}
	/* 개발자 작업  끝 */