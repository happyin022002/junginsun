/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0011.js
*@FileTitle  : Customer Performance Group Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업	*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//  버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 서미진
	 * @version 2012.02.24
	 */
	function loadPage() {
     //페이지 로드시 선처리 기능을 호출한다.
		initControl()	        
		for (i=0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
		}
	}	
	   /**
	* Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
	* <br><b>Example :</b>
	* <pre>
	*     initControl()
	* </pre>
	* @param 없음
	* @return 없음
	* @author 서미진
	* @version 2011.02.24
	*/    
	 function initControl() {
		 var formObj=document.form;
		 //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);   
		 //axon_event.addListenerForm('change', 'obj_change', document.form);
		 axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	 } 
	 /**
	  * OnKeyDown event를 처리한다. <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *
	  * </pre>
	  * @param 없음
	  * @return 없음
	  * @author 서미진
	  * @version 2010.11.03
	  */
	 function obj_keydown(){
	     //enter key조회
	     var eleName=ComGetEvent("name");
	     if (eleName == "cust_grp_nm" || eleName == "cust_grp_id"){
	         if (event.keyCode == 13){
	        	 doActionIBSheet(sheetObjects[0],document.form,	IBSEARCH);
	         }
	     }
	 }	 
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2012.02.24
     */
    function processButtonClick(){
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_Retrieve":
    			sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
    			doActionIBSheet(sheetObjects[0],document.form,	IBSEARCH);
    			break;
    		case "btn_New":  
    			doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);		
    			break;
    		case "btn_DownExcel_up":
    			doActionIBSheet(sheetObjects[0],document.form, IBDOWNEXCEL);
    			break;
    		case "btn_DownExcel":
    			if(sheetObjects[2].RowCount() > 0 ){
    				sheetObjects[2].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1,Merge:1});
    			} else {
    				ComShowCodeMessage("COM132501");
    			}
    			break;	
    		case "btn_DownExcel_down":
    			if(sheetObjects[1].RowCount() > 0 ){
    				doActionIBSheet(sheetObjects[1],document.form, IBDOWNEXCEL);
    			} else {
     				ComShowCodeMessage("COM132501");
     			}
    			break;	  
//            case "btn_hidden":            	
//            	setControlHidden();
//            	break;	
    		}
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
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
	 * @author 서미진
	 * @version 2012.02.24
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="|Seq|Group Code|Customer Group Name|Abbrevation|Member|Last Update" ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"member",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(0);
		        SetColProperty("upd_dt", {Format:"####-##-##"} );
		        SetSheetHeight(230);
			}
			break;
		case 2:
			with (sheetObj) {
		        var HeadTitle="|Seq|Customer Code|Customer Name|Location|Primary S.Rep|Sales Office" ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
		         
		        InitColumns(cols);
	
				SetEditable(0);
				SetSheetHeight(240);
		        resizeSheet();
			}
			break;
		case 3:
			with (sheetObj) {
		        var HeadTitle="Seq|Customer Group ID|Customer Group Name|Office Code|Sales Representative Code|Value Base Segmentation Class Code|" +
		        "Needs Base Segmentation Class Code1|Needs Base Segmentation Class Code2|Needs Base Segmentation Class Code3|" +
		        "Create User ID|Create Date|Update User ID|Update Date|Delete Flag|EAI Event Date|EAI Interface ID|Customer Group Abbreviation Name" ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"srep_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vbs_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"eai_evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"eai_if_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
	
				SetEditable(0);
		        SetColProperty("cre_dt", {Format:"####-##-##"} );
		        SetColProperty("upd_dt", {Format:"####-##-##"} );
		        SetColProperty("eai_evnt_dt", {Format:"####-##-##"} );
		        SetSheetHeight(250);
			}
			break;	
		}
	}
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, SEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 서미진
	 * @version 2012.02.24
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {	
			case IBSEARCH:	  //조회
	        	if (!validateForm(sheetObj,document.form,sAction)) {
	        		return false;
	        	}
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_SAM_0011GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount()> 0 ){
					sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1});
				} else {
					ComShowCodeMessage("COM132501");
				}
				break;
			case IBCLEAR : 
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.reset();
				break;
			}				
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    /**
     * OnKeyPress event를 처리한다. <br>
     * @author 서미진
     * @version 2012.02.24
     */     
   function obj_keypress() {
	 	obj=event.srcElement;	 	
       var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       var srcName=ComGetEvent("name");
       var srcValue=event.srcElement.getAttribute("value");
       switch (event.srcElement.dataformat) {
//       	case "eng":
//       		//영문만 입력가능
//       		ComKeyOnlyAlphabet();
//       		break;
//       	case "engup":
//       		//영문 대문자만 입력가능
//       		ComKeyOnlyAlphabet("upper");
//       		break;
       	case "engupnum":
       		//영문 대문자+숫자 입력가능
       		ComKeyOnlyAlphabet("uppernum","");
       		break;	
//  		case "int":
//  	        //숫자 만입력하기 (자동 콤마)
//  	        ComKeyOnlyNumber(event.srcElement);
//  			break;  
//  		case "num":
//  	        //숫자 만입력하기
//  	        ComKeyOnlyNumber(event.srcElement);
//  			break;  
  		case "engname":
  	        //영문자 & 숫자 & 공통특수문자
  			ComKeyOnlyAlphabet('num',"32|38|39|40|41|44|45|46|47|64");
  			break; 
  		case "engupspecial": // 영문대문자 + Space + &-,.
  			ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95");
  			break;
//     	case "tel":
//     		//숫자+"-" 입력가능
//     		ComKeyOnlyNumber(event.srcElement, "-");
//     		break;
//     	case "float":
//     		//숫자+"." 입력가능
//     		ComKeyOnlyNumber(event.srcElement, ".");
//     		break;
//     	case "fax":
//     		//숫자+"." 입력가능
//     		ComKeyOnlyNumber(event.srcElement, ".");
//     		break;
//     	case "ymd":
//     		//YYYY-MM-DD
//         	  ComKeyOnlyNumber(event.srcElement);
//           	  if (srcValue.length == 6) {
//           		document.form.elements[srcName].value = srcValue.substring(0,4) + "-" + srcValue.substring(4,6) + "-"
//           	  }
//           	  break;
       }     
   } 	  
   /**
    * OnSelectCell 이벤트 발생시 호출되는 function <br>
    * 클릭시 하단 조회 <br>
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
	 * @author 서미진
	 * @version 2012.02.24
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		if(OldRow != NewRow){
	 		sheetObjects[1].RemoveAll();
			var formObj=document.form;
			formObj.f_cmd.value=SEARCH01;
			var param="f_cmd="           + formObj.f_cmd.value
				+ "&cust_grp_id="     + sheetObj.GetCellValue(NewRow, "cust_grp_id");
			var sXml=sheetObjects[1].GetSearchData("ESM_SAM_0011GS.do", param);
			sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
		}
	}	
	  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2012.02.24
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	} 	
	/**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
    * @author 서미진
    * @version 2012.02.24
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @author 서미진
     * @version 2012.02.24
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var formObj=document.form;
		 switch (sAction) {
		 case IBSEARCH:
 			if(ComTrim(formObj.cust_grp_nm.value) == "" && ComTrim(formObj.cust_grp_id.value) == "" ) {
				ComShowCodeMessage("COM12138", "Group Name", "Group Code"); 				
				return false;
 			}
 			break;
 			if(formObj.cust_abbr_nm.value.length < 3) {
				ComShowCodeMessage("COM12143", "Abbreviation", "3"); 
				ComSetFocus(formObj.cust_abbr_nm);					
				return false;
	 		}
 			break;
		 }
		 return true;
	}
    /* 개발자 작업  끝 */
	
	
	/**
     * This method counts numbers again.
     * @param Col
     * @param SortArrow
     */
    function sheet1_OnSort(Col, SortArrow){
 	   sheet1.ReNumberSeq();
    }  
    
    
    /**
     * This method counts numbers again.
     * @param Col
     * @param SortArrow
     */
    function sheet2_OnSort(Col, SortArrow){
 	   sheet2.ReNumberSeq();
    }
    
    
    /**
     * This method counts numbers again.
     * @param Col
     * @param SortArrow
     */
    function sheet3_OnSort(Col, SortArrow){
 	   sheet3.ReNumberSeq();
    }
	
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    }

