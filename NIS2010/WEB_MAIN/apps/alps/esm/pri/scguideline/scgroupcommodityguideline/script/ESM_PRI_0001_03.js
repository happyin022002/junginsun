/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0001_03.js
*@FileTitle : Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================
* History
* 2011.04.04 서미진 [CHM-201109785-01] BCO S/C 일 경우, 특정 CMDTY 에 대해서 system 으로 차단
* 2013.04.22 전윤주 [CHM-201324292] SC Commodity validation 대상 추가
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0001_03() {
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
	var enableFlag = true;
	var isFiredNested = false;
	var supressConfirm = false;	
	
	// 2011-04-04 서미진 [CHM-201109785] TPE Scope, BCO S/C 일 경우 특정 CMDTY 에 대해서 system 으로 차단 목록
	var block_cmdt_list = "000000/000002/000004/000005/000010/000017/961900/989200/989201";
	var block_cmdt = block_cmdt_list.split("/");
	
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
     * @version 2009.04.16
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
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						fontChange();
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
							
				case "btn_Save":				
					if (validateForm(sheetObject1,formObject,IBSAVE)) {
						if (ComPriConfirmSave()) {
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
							fontChange();
						}
					}
					break;					
				case "btn_DownExcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;
				
				case "btn_Add":		
				
					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;					

				case "btn_Add2":
					if (enableFlag && validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;					

				case "btn_Del":			
					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;					

				case "btn_Del2":			
					if (enableFlag && validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;					
			
				case "btn_Copy":
					if ( formObject.yn_data.value == "Y"){
						ComShowCodeMessage('PRI08004');
						return;
					}
					var sParam = "svc_scp_cd=" + formObject.svc_scp_cd.value + "&gline_seq=" + formObject.gline_seq.value
								+"&prc_cust_tp_cd="+formObject.prc_cust_tp_cd.value;
					var str = ComOpenWindowCenter("/hanjin/ESM_PRI_0064.do?"+sParam, "ESM_PRI_0064","400","325", true);
					if (str != null){											
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						parent.setTabStyle();
						fontChange();
					}
					break;		
				case "prc_cust_cd":
			    	if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
			    		obj_click();
			    	}
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
         
         parent.loadTabPage();
     }

      
//      /**
//       * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
//       * <br><b>Example :</b>
//       * <pre>
//       *    
//       * </pre>
//       * @param {ibsheet} sheetObj 필수 IBSheet Object
//       * @return 없음
//       * @author 공백진
//       * @version 2009.04.17
//       */      
//      function sheet2_OnLoadFinish(sheetObj) {   
//
//          parent.loadTabPage();
//
//      }         

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

         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 280;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grp_cmdtseq|Group Code|Description";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


     //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
     //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
     //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
     //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false, "ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck,    40,    daCenter,  false, "chk"); 	                
                     InitDataProperty(0, cnt++ , dtDataSeq,    	  50,    daCenter,  false, "seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "gline_seq"); 
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "prc_cust_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	  40,    daCenter,  true,  "grp_cmdt_seq");
                     InitDataProperty(0, cnt++ , dtData,     	 100,    daCenter,  false, "prc_grp_cmdt_cd",   true, "", dfNone, 0, false, false,5,5);
 					 InitDataProperty(0, cnt++ , dtData,     	 100,    daLeft,	false, "prc_grp_cmdt_desc", true, "", dfNone, 0, true, true);
 					
 					 ShowButtonImage = 2;
 					 InitDataValid(0, "prc_grp_cmdt_desc", vtEngOther,PRI_VALID_CHAR);	// 영대문자,숫자만 입력
	                 InitDataValid(0, "prc_grp_cmdt_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
	                 WaitImageVisible = false;
                }
                 break;

             case "sheet2":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 280;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);
                     
                     var HeadTitle = "|Sel.|Seq.|svcscpcd|glineseq|prccusttpcd|grpcmdtseq|grpcmdtdtlseq|Code|Description";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


 //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
 //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
 //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
 //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  false,	"ibflag");
 	                 InitDataProperty(0, cnt++,  dtDummyCheck,   40,  daCenter,  false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,  	 40,  daCenter,  true, 	"seq");
 	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "svc_scp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "gline_seq"); 
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "prc_cust_tp_cd");
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_seq");      
	                 InitDataProperty(0, cnt++ , dtHidden,    	 40,  daCenter,  true,  "grp_cmdt_dtl_seq");
                     InitDataProperty(0, cnt++ , dtPopupEdit, 	 110, daCenter,  false, "prc_cmdt_def_cd",  true,  "",  dfNone, 0, true,  true ,6);
 					 InitDataProperty(0, cnt++ , dtData,     	 280, daLeft, 	 false, "loc_des",          false, "",  dfNone, 0, false,  false,100);
    				 ShowButtonImage = 2;
	                 InitDataValid(0,  "prc_cmdt_def_cd",		vtNumericOnly);		// 숫자만 입력
	                 WaitImageVisible = false;
                }
                 break;
             case "sheet3":

                 with (sheetObj) {
                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     var HeadTitle = "|Seq.|Group Code|Group Description|Code|Description";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


 //             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
 //							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
 //				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
 //							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  daCenter,  false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,  	 40,  daCenter,  true, 	"seq");
	                 InitDataProperty(0, cnt++ , dtData,     	 150, daCenter,  false, "prc_grp_cmdt_cd");
 					 InitDataProperty(0, cnt++ , dtData,     	 150, daLeft,	 false, "prc_grp_cmdt_desc");
                     InitDataProperty(0, cnt++ , dtPopupEdit, 	 110, daCenter,  false, "prc_cmdt_def_cd");
 					 InitDataProperty(0, cnt++ , dtData,     	 280, daLeft, 	 false, "cmdt_nm");
 					 
 					 WaitImageVisible = false;
    				 //ShowButtonImage = 2;
    				 
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
		  		case IBSEARCH_ASYNC01: // 화면조회시 Customer Type 조회	  		
					formObj.f_cmd.value = SEARCH10;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_03GS.do" , FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "cd|nm|rcnt");
					var eleName = "cust_tp";
					var j = 1;
					var optCheck = 0;
					for (var i = 0; i < arrData.length; i++) {
						switch (arrData[i][0]){
						case "A":
							j = "1";
							break;
						case "I":
							j = "2";
							break;
						case "N":
							j = "3";
							break;
						case "O":
							j = "4";
							break;								
						}
						
						if (parseInt(arrData[i][2],10) > 0) {
							document.getElementById(eleName + j).style.fontWeight = "bold";
							if (optCheck == 0){
								optCheck = j;
							}
						} else {
							document.getElementById(eleName + j).style.fontWeight = "";
						}
					}
					if (optCheck <= 0){
						document.form.prc_cust_cd[0].checked = true;
					}else{
						document.form.prc_cust_cd[optCheck - 1].checked = true;	
					}					
					
					var obj = document.form;
					if (obj.prc_cust_cd[0].checked == true){
						obj.prc_cust_tp_cd.value = "A";
					}else if (obj.prc_cust_cd[1].checked == true){
						obj.prc_cust_tp_cd.value = "I";
					}else if (obj.prc_cust_cd[2].checked == true){
						obj.prc_cust_tp_cd.value = "N";
					}else if (obj.prc_cust_cd[3].checked == true){
						obj.prc_cust_tp_cd.value = "O";
					}	

					break;		  		
				case IBSEARCH:      //조회
					ComOpenWait(true); //->waiting->start 
					if (validateForm(sheetObj,document.form,sAction)) {
						for (var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}						
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0001_03GS.do", FormQueryString(formObj));
					} else {
						ComShowCodeMessage('PRI08001');
					}	 
					ComOpenWait(false); //->waiting->End
					break;
              
				case IBSEARCHAPPEND: // 조회
					ComOpenWait(true); //->waiting->start 
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0001_03GS.do" , FormQueryString(formObj));
					}
					ComOpenWait(false); //->waiting->End
					break;
				case IBSAVE:        //저장 		
					ComOpenWait(true); //->waiting->start 
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheetObjects[0].GetSaveString();					
					if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
						return false;
					}
					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");		
					var sParamSheet2 = sheetObjects[1].GetSaveString();					
					if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
						return false;
					}
					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
				
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_03GS.do", sParam);
					sheetObjects[1].LoadSaveXml(sXml);
					sXml = ComDeleteMsg(sXml);
					sheetObjects[0].LoadSaveXml(sXml);
					ComOpenWait(false); //->waiting->End
					if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
						return false;
					} else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {							
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
						}						
						parent.setTabStyle();
						fontChange();
						return true;
					}
					break;

				case IBINSERT:      // 입력
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (sheetObj.id == "sheet1") {						
						var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);
						var maxCode = 0;
						if (idx < 0) {
							return false;
						}
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						sheetObj.CellValue(idx, "prc_cust_tp_cd") = formObj.prc_cust_tp_cd.value;
						sheetObjects[1].RemoveAll();
						sheetObj.CellValue(idx, "grp_cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq"),10) + 1;
								
						maxCode = parseInt(groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd"),10) + 1 + "";
						sheetObj.CellValue2(idx,"prc_grp_cmdt_desc")= "Group " + maxCode;						
						maxCode = ComLpad(maxCode,   4, "0");
						sheetObj.CellValue2(idx,"prc_grp_cmdt_cd")= "G"+ maxCode;						
						sheetObj.SelectCell(idx, "prc_grp_cmdt_desc");
						
					}
					if (sheetObj.id == "sheet2") {
						var idx = sheetObj.DataInsert();
						sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
						sheetObj.CellValue(idx, "prc_cust_tp_cd") = formObj.prc_cust_tp_cd.value;
						var grp_cmdt_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_cmdt_seq");
						sheetObj.CellValue(idx, "grp_cmdt_seq") = grp_cmdt_seq;
						sheetObj.CellValue(idx, "grp_cmdt_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq"),10) + 1;
						sheetObj.SelectCell(idx, "prc_cmdt_def_cd");
					}
					break;				
				case IBDOWNEXCEL:      //excel		
					ComOpenWait(true); //->waiting->start 
					formObj.f_cmd.value = SEARCH03;
					sheetObjects[2].DoSearch("ESM_PRI_0001_03GS.do", FormQueryString(formObj));                					
					sheetObjects[2].Down2Excel(-1);
					ComOpenWait(false); //->waiting->End
					break;
				case IBDELETE: // Delete		
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}	
				
					//rate에서 사용하는 데이터는 삭제 금지
					if (sheetObj.id == "sheet1") {
						var arrChecked = sheetObj.FindCheckedRow("chk").split("|");
						for (var i = 0; i < arrChecked.length; i++) {
							if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
								continue;
							}
							
							formObj.f_cmd.value = SEARCH11;
							var sParam = FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObj.CellValue(arrChecked[i], "prc_grp_cmdt_cd");
							
							var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_03GS.do", sParam);
							var arrTemp = ComPriXml2Array(sXml, "etc1");
							
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntInUse = parseInt(arrTemp[0][0],10);
								
								if (cntInUse > 0) {
									ComShowCodeMessage("PRI08017");
									return false;
								}
							} else {
								return false;
							}
						}
					}		
				
					if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
					    sheetObjects[1].RemoveAll();
					}
					var delCnt = deleteRowCheck(sheetObj, "chk");
					if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
					    sheetObjects[1].RemoveAll();
					}						

					//DETAIL의 모든 ROW를 삭제할경우 체크
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00021')){							
							sheetObjects[0].CheckAll2("chk") = 0;
							
							formObj.f_cmd.value = SEARCH11;
							var sParam = FormQueryString(formObj) + "&prc_grp_cmdt_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "prc_grp_cmdt_cd");
							
							var sXml = sheetObj.GetSearchXml("ESM_PRI_0001_03GS.do", sParam);
							var arrTemp = ComPriXml2Array(sXml, "etc1");							
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntInUse = parseInt(arrTemp[0][0],10);
								if (cntInUse > 0) {
									ComShowCodeMessage("PRI08017");
									return false;
								}else{
									sheetObjects[1].RemoveAll();
									sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") = "1"
									deleteRowCheck(sheetObjects[0], "chk");		
								}
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
	          	if (sAction == IBDELETE || sAction == IBINSERT
	          			|| sAction == IBSEARCH_ASYNC01) {
	          		return;
	          	}
	          	ComOpenWait(false); //->waiting->End
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
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * row 선택시 발생하는 로직을 처리하는 doRowChange function을 호출한다. <br>
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
	    doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}	

    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
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
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	switch(colname)
    	{
	    	case "prc_cmdt_def_cd":	    
	    		if (Value.length==6){
	    			formObj.f_cmd.value = SEARCH08;
	    			formObj.cd.value = Value;

	    			// 2011-04-04 서미진 [CHM-201109785] TPE Scope, BCO S/C 일 경우 특정 CMDTY 에 대해서 system 으로 차단
	    			// 2013-04-22 [CHM-201324292] Scope 추가 TPW TAE ASE TAW ASW MME MMW SAN SAS 
	    			if( (sheetObj.CellValue(Row,"svc_scp_cd")=="TPE" ||sheetObj.CellValue(Row,"svc_scp_cd")=="TPW" 
	    			   ||sheetObj.CellValue(Row,"svc_scp_cd")=="TAE" ||sheetObj.CellValue(Row,"svc_scp_cd")=="ASE"
	    			   ||sheetObj.CellValue(Row,"svc_scp_cd")=="TAW" ||sheetObj.CellValue(Row,"svc_scp_cd")=="ASW"
	    			   ||sheetObj.CellValue(Row,"svc_scp_cd")=="MME" ||sheetObj.CellValue(Row,"svc_scp_cd")=="MMW"
	    			   ||sheetObj.CellValue(Row,"svc_scp_cd")=="SAN" ||sheetObj.CellValue(Row,"svc_scp_cd")=="SAS")    				
	    			  
	    			    && sheetObj.CellValue(Row,"prc_cust_tp_cd")=="I"){
	    				for( var i = 0; i <block_cmdt.length ; i++ ){
	    					if(sheetObj.CellValue(Row,"prc_cmdt_def_cd") == block_cmdt[i]){
		    					ComShowCodeMessage("PRI00357");
		    					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") ="";  
		    					sheetObj.CellValue(Row,"loc_des") ="";  
		    					sheetObj.SelectCell(Row, "prc_cmdt_def_cd");
		    					return false;
	    					}
	    				}
	    			}

	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
  					if (arrData[1] != ""){
  						sheetObj.CellValue2(Row,"loc_des") = arrData[1];
  					}else{
  						sheetObj.CellValue2(Row,"loc_des") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") = "";
	  					ComShowCodeMessage("PRI00315");
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
  					}
	    		}else{	   
	    			sheetObj.CellValue2(Row,"loc_des") = "";	    		
  					sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";	
  					ComShowCodeMessage("PRI00315");
  					sheetObj.SelectCell(Row, "prc_cmdt_def_cd");  		
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
    * @author 공백진
    * @version 2009.05.07
    */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "prc_cmdt_def_cd"){
			var sUrl = "/hanjin/ESM_PRI_4027.do?grp_cd="+ PRI_SG+"&commodity_cmd=C";
			var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 330, true);
			if (rtnVal != null){

				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;		
				sheetObj.CellValue(Row, Col) = rtnVal.cd;
			}
		}
	}
    
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
				formObj.grp_cmdt_seq.value = sheetM.CellValue(adjNewRow, "grp_cmdt_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
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
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;
			case IBSEARCHAPPEND: // 조회
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				}
	        	if (sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true){
	        		ComShowCodeMessage('PRI00309','Commodity Group');
	        		return false;
	        	}			
				break;		
			case IBSAVE: // 저장

				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {					
			       if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ibflag") !="D" && getValidRowCount(sheetObjects[1]) <= 0) {
			              ComShowCodeMessage("PRI00007");
			              return false;
			       }

			       if (parent.document.form.cfm_flg.value =="Yes"){
			    	   ComShowCodeMessage("PRI00105");
			    	   return false;
			       }
			       
					var rowM = sheetObjects[0].ColValueDup("prc_cust_tp_cd|prc_grp_cmdt_cd",false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Group Code Sheet", rowM);
						sheetObjects[0].SelectCell(rowM, "prc_grp_cmdt_cd")
						return false;
					}					
					var rowD = sheetObjects[1].ColValueDup("prc_cust_tp_cd|grp_cmdt_seq|prc_cmdt_def_cd",false);
					if (rowD >= 0) {
						ComShowCodeMessage("PRI00303", "Commodity Sheet", rowD);
						sheetObjects[1].SelectCell(rowD, "prc_cmdt_def_cd")
						return false;
					}					
				} else {
					ComShowCodeMessage("PRI00301");
					return false;
				}				

				break;
				
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;

				}
		       if (!getMainStatus()){
		    	   return false;
		       }	
				var rowCnt = getValidRowCount(sheetObjects[0]);

				if (sheetObj.id == "sheet2") {
					if (rowCnt <= 0){
						return false;
					}
				}					
				
				break;
				
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
		       if (!getMainStatus()){
		    	   return false;
		       }	
				break;
		}
  		return true;
     }

     /**
     * radio버튼 Axon 이벤트  처리 <br>
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
	    axon_event.addListener('click', 'obj_click', 'prc_cust_cd');
	}
	
    /**
    * radio버튼 click 이벤트 발생시 호출되는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *     
    * </pre>
    * @param 없음
    * @returns 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function obj_click()
	{
		var obj = document.form;		
		if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
			if (ComPriConfirmSave()) {				
				if (validateForm(sheetObjects[0],obj,IBSAVE)) {					
					if (doActionIBSheet(sheetObjects[0],obj,IBSAVE)){
						fontChange();	
					}else{
						obj.prc_cust_cd[getCustTpCd()].checked = true;
						return;
					}
									
				}else{
					obj.prc_cust_cd[getCustTpCd()].checked = true;
					return;
				}
			}
		}
		
		if (obj.prc_cust_cd[0].checked == true){
			obj.prc_cust_tp_cd.value = "A";
		}else if (obj.prc_cust_cd[1].checked == true){
			obj.prc_cust_tp_cd.value = "I";
		}else if (obj.prc_cust_cd[2].checked == true){
			obj.prc_cust_tp_cd.value = "N";
		}else if (obj.prc_cust_cd[3].checked == true){
			obj.prc_cust_tp_cd.value = "O";
		}		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}  
    
    /**
    * Radio 버튼클릭시 선택한 Radio 버튼의 인덱스를 반환한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * 	getCustTpCd()
    * </pre>
    * @param 없음
    * @return {int} 선택한 Radio 버튼의 인덱스값
    * @author 공백진
    * @version 2009.04.17
    */     
    function getCustTpCd(){
    	var formObj = document.form;
    	var tpCd = formObj.prc_cust_tp_cd.value;
    	var optIdx = 0;
    	switch (tpCd){
    	case "A":
    		optIdx = 0;
    		break;
    	case "I":
    		optIdx = 1;
    		break;
    	case "N":
    		optIdx = 2;
    		break;
    	case "O":
    		optIdx = 3;
    		break;
    	}
    	return optIdx;
    }
    
    
    /**
     * Radio 버튼의  font를 변경하는 function <br>
     * 데이터가 있다면 BOLD로 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 	fontChange()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	     
    function fontChange(){
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetObjects[0]);
    	var formObj = document.form;
		var fontBold ="";
    	var eleName ="";
    	
    	var tpCd = formObj.prc_cust_tp_cd.value;
    	var j = 1;
    	switch (tpCd) {
	    	case "A":
	    		j = 1;
	    		break;
	    	case "I":
	    		j = 2;
	    		break;
	    	case "N":
	    		j = 3;
	    		break;
	    	case "O":
	    		j = 4;
	    		break;    		
    	}
    	eleName = "cust_tp" + (j);
    	
 		if (row_count > 0) {
 			fontBold = "bold";
 		}    	
    	document.getElementById(eleName).style.fontWeight = fontBold;
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
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
		
		if( sheetObj.SearchRows > 0){
			document.form.yn_data.value = "Y"
		}else{
			document.form.yn_data.value = "N"
		}
		
		setCmdtGroupCopyBtn(sheetObj, formObj);
		
//		if (formObj.svc_scp_cd.value == "TPW" || formObj.svc_scp_cd.value == "ACE" || formObj.svc_scp_cd.value =="MXW"){
//			if (sheetObj.RowCount <= 0){
//				ComBtnEnable("btn_Copy");
//			}else{
//				ComBtnDisable("btn_Copy");
//			}			
//		}else{
//			ComBtnDisable("btn_Copy");
//		}
	}    
      
  /**
   * Cmdt Group Copy버튼을 활성/비활성 시키는 function <br>
   * Scope이 TPW,ACE,MXW일 경우에 데이터가 있다면 비활성,없다면 활성 시킨다. <br>
   * <br><b>Example :</b>
   * <pre>
   * 
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */ 	      
    function setCmdtGroupCopyBtn(sheetObj, formObj){
		if (formObj.svc_scp_cd.value == "TPW" || formObj.svc_scp_cd.value == "ACE" || formObj.svc_scp_cd.value =="MXW"){
			if (sheetObj.RowCount <= 0){
				ComBtnEnable("btn_Copy");
			}else{
				ComBtnDisable("btn_Copy");
			}			
		}else{
			ComBtnDisable("btn_Copy");
		}	
    }
      
    
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
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
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;
    	if( sheetObj.RowCount > 0){
			document.form.yn_data.value = "Y"
		}else{
			document.form.yn_data.value = "N"
		}
		parent.setTabStyle();
		setCmdtGroupCopyBtn(sheetObj, formObj);
	}    
	
    /**
    * 주어진 컬럼의 Max값 구하기 <br>
    *
    * @param {object} sheetObj 필수, IBSheet Object.
    * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
    * @return int Max값
     * @author 박성수
     * @version 2009.04.22
    */
   function groupCodeGetMax(sheetObj, sCol) {
       var max = 0;
       for (var i = 0; i <= sheetObj.LastRow; i++) {
           if (parseInt(sheetObj.CellValue(i, sCol).substr(3,2),10) > max) {
               max = sheetObj.CellValue(i, sCol).substr(3,2);
           }
       }
       return max;
   }	
	
    /**
     * parent 화면의 상태로 edit여부를 판단한다. function <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param 없음
     * @return {Boolean} true(수정가능,메인의 상태는 No) false(수정불가능,메인의상태는 Yes)
     * @author 공백진
     * @version 2009.04.17
     */    
    function getMainStatus(){
    	var mainStatus = parent.document.form.cfm_flg.value;
    	var editStatus = true;
    	if (mainStatus == "Yes"){
    		editStatus = false;
    	}
    	return editStatus;
    }      
	
     
     /**
      * 화면의 상태에 따라 버튼을 활성,비활성화 한다. function <br>
      * <br><b>Example :</b>
      * <pre>
      *  toggleButtons(mode)
      * </pre>
      * @param {String} 화면의 상태 값 필수 
      * @author 공백진
      * @version 2009.04.17
      */       
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Del");
			ComBtnDisable("btn_Add2");
			ComBtnDisable("btn_Del2");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_Add");
			ComBtnEnable("btn_Del");
			ComBtnEnable("btn_Add2");
			ComBtnEnable("btn_Del2");
			
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");			
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Del");
			ComBtnDisable("btn_Add2");
			ComBtnDisable("btn_Del2");
			break;
		}
	}     	
	
    /**
    * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
    * 화면이 보여지며 조회를 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd 필수 svc_scp_cd 값
    * @param {string} sGlineSeq 필수 gline_seq 값
    * @param {string} isAproUsr 필수 권한 값
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
						
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag = true;
            } else {
            	enableFlag = false;
            }
            tabEnableSheet(enableFlag);			
		}
	}
    /**
    * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	 	 
	function tabClearSheet() {
		var formObject = document.form;		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
		
		for (var i = 1; i <5; i++){
			document.getElementById("cust_tp"+i).style.fontWeight = "";	
		}
		formObject.prc_cust_cd[0].checked = true
	}     	 
	 
    /**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 			
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}   
   
	
	
	/* 개발자 작업  끝 */