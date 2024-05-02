/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0107.js
*@FileTitle  : Rate Guideline Inquiry - Commodity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
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
   	/* 개발자 작업	*/
 // 공통전역변수
 var sheetObjects=new Array();
 var sheetCnt=0;
 var enableFlag=true;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 
//다음의 화면들에서 호출됨
//ESM_PRI_0002_06
 
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1=sheetObjects[0];
//          var sheetObject2 = sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
            switch(srcName) {
	            case "btn_Close":  
	            	ComClosePopup(); 
	                break;                
	        } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
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
     * @author 박성수
     * @version 2009.05.07
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
     * @author 박성수
     * @version 2009.05.07
     */
     function loadPage() {
    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
         for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
         }
         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
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
     * @author 박성수
     * @version 2009.05.07
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
              case "sheet1":
                 with (sheetObj) {
	                  var HeadTitle="|Seq.|1|2|3|4|5|CMDT Type|CMDT Code|Commodity Description";
	                  var headCount=ComCountHeadTitle(HeadTitle);
	
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                         {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                         {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                   
	                  InitColumns(cols);
	
	                  SetEditable(0);
//	                  InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
	                  SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetShowButtonImage(0);
	                  SetSheetHeight(120);
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
     * @author 박성수
     * @version 2009.05.07
     */
      function doActionIBSheet(sheetObj,formObj,sAction) {
         try {
             if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
                 ComOpenWait(true);
             }
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 			case IBCLEAR: // 화면 로딩시 
	 				var sXml="";
					//공통 cmdt type
//	 				sheetObj.SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE1[1] ,COMODITY_TYPE1[0], ComboCode:"",""} );
	 				sheetObj.InitDataCombo(0,"prc_cmdt_tp_cd", COMODITY_TYPE1[1], COMODITY_TYPE1[0], " ", " ", 0); 	
	//				formObj.f_cmd.value = SEARCH19;
	//				formObj.cd.value="CD01703";
	//				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	//				setIBCombo(sheetObj,sXml,"prc_cmdt_tp_cd",false,0);
	 				break;
				case IBSEARCH:      //조회
					var sXml=opener.getSheetXml(3);
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					sheetGetRowHidden(sheetObjects[0]);
		         	break;			
	          }
         } catch (e) {
             if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally {
         	ComOpenWait(false);
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
       * @author 박성수
       * @version 2009.05.07
       */
     function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH: // 조회			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
				break;
    	  }
         return true;
     }
  	 /**
	    * 삭제된 row가 sheet 간 이동하면 Hidden이 되었던게 보이므로 다시 hidden 시켜주는 function <br>
	    * sheet 간 데이터 이동시 실행한다.
	    * <br><b>Example :</b>
	    * <pre>
	    * 		sheetRowHidden (sheetObj)
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 IBSheet Object
	    * @return 없음
	    * @author 박성수
	    * @version 2009.05.07
	    */     
  	function sheetGetRowHidden( sheetObj){
 		for (i=sheetObj.RowCount(); i > 0; i-- ){
 			if (sheetObj.GetCellValue( i, "ibflag") == "D" ){
 				sheetObj.SetRowHidden(i,1);
 			}
    	}	
  	} 
	/* 개발자 작업  끝 */
