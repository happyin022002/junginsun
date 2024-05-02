/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0004.js
*@FileTitle  : Customer PFMC Group Detail
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
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_retrieve":
    			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    			break;
    		case "btn_New":
    			sheetObjects[0].RemoveAll();
    			formObj.reset();
    			break;
    			break;
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
 * IBSheet Object를 배열로 등록, IBMulti Combo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이창원
 * @version 2011.05.21
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
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
    * @author 이창원
	* @version 2011.05.21
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
		for(var k=0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		initControl();
	}
	function initControl(){
		var formObj=document.form;
		axon_event.addListenerForm('change', 'obj_change', document.form); // change
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	 * @author 이창원
	 * @version 2011.05.21
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="|SEQ|Group Code|Customer Code|Customer Name|Office|Location" ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"customer_code",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(452);
		        SetColProperty(0 ,"cust_grp_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
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
	 * @author 이창원
	 * @version 2011.05.21
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.SetWaitImageVisible(0);
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {	
			case IBSEARCH:	  //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("ESM_SAM_0004GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
			case SEARCH01: //조회
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_SAM_0004GS.do", FormQueryString(formObj));
				var cust_grp_nm=(ComGetEtcData(sXml, "cust_grp_nm") == undefined) ? "" : ComGetEtcData(sXml, "cust_grp_nm");
				sheetObj.SetWaitImageVisible(0);
				document.form.cust_grp_nm.value=cust_grp_nm;
				if(cust_grp_nm == "") {
					ComShowCodeMessage("COM130402", "PFMC Group Code");
					formObj.cust_grp_id.value="";
					formObj.cust_grp_nm.value="";
	 				sheetObjects[0].RemoveAll();
	 				formObj.cust_grp_id.focus();
				}else{
					document.form.cust_grp_nm.value=cust_grp_nm;
				}			
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
     * 필드 데이타가 CHANGE될 경우 이벤트
     */
    function obj_change(){
    	var srcName=ComGetEvent("name");
    	if (srcName == "cust_grp_id")  {
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	}
    }
    /* 개발자 작업  끝 */
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
		 case IBSEARCH:
 			if(	formObj.cust_grp_nm.value == "") {
				ComShowCodeMessage("COM130403", "PFMC Group Code");
				return false;
			}
 			break;
		 }
		 return true;
	}
