/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0903.js
*@FileTitle  : Customer Performance Group Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
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
 * @class ESM_SAM_0903 : ESM_SAM_0903 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
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
    		case "btn_Retrieve":
    			sheetObjects[0].RemoveAll();
    			
    			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    			break;
    		case "btn_Select":
    			
//    			2014.08.12 김용습
    			var opener=window.dialogArguments;   	
    			if (!opener) opener=parent;
    			
    			comPopupOK();
    			break;
    		case "btn_Group":
    			sheetObjects[0].RemoveAll();
    			formObj.reset();
    			break;
    		case "btn_Close":
    			ComClosePopup(); 
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
     * ESM_SAM_0005 : Coverage Tab의 Srep_cd 정보를 가져오는 Function
     * @author 박찬민
     * @version 2011.06.02
     * 현재 팝업 미완성으로 Function 미완성 
     */
    function getsrepflg(rowArray, row, col) {
   	    var sheetObj=sheetObjects[3];
   		var colArray=rowArray[0];
   		document.form.srep_cd.value=colArray[2];
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
		// 자동조회.
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);//필수 조회조건이 없으므로 자동조회 의미없음
	}
	function initControl(){
	var formObj=document.form;
//	axon_event.addListenerFormat("keypress","obj_Keypress", document.form);     // uppereng
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
     * User Auth 확인<br>
     * <br><b>Example :</b>
     * <pre>
     *     촏차
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이관샨
     * @version 2012.02.13
     */
    function checkUserCodeName() {   
   	 var formObject=document.form;
   	 var sheetObject1=sheetObjects[0];
   	 if(formObject.usr_id.value.length>0){
   	 		var userAuth=checkUserAuth(formObject,sheetObject1);
		        if(userAuth == ''){
		        	//formObject.sales_office.readOnly =  false;						// 3.Sales Office 값을 정함.
		        	formObject.ofc_cd.setAttribute("className","input2");
		        	formObject.srep_cd.readOnly=true;
		        	formObject.srep_cd.setAttribute("className","input2");
		        }else{
		        	//formObject.sales_office.readOnly =  false;
		        	formObject.ofc_cd.setAttribute("className","input2");
		        }
   	 	}
    }
    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj 필수 Html Object
     * @param  {bool} gb  필수 true : 활성화 false : 비활성화
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 
     function btnImgEnable(obj, gb) {
         if(obj.constructor == String){
             obj=document.getElementsByName(obj)[0];        
         }
         var btnStyle=obj.style;
         if (gb){
             obj.SetEnable(1);
             btnStyle.cursor="hand";
             btnStyle.filter="";
             obj.disabled=false;
         } else {
             obj.SetEnable(0);
             btnStyle.cursor="auto";
             btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
             obj.disabled=true;
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
	 * @author 이창원
	 * @version 2011.05.21
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="|SEL|Office Code|Group Code|Customer Group Name|Abbreviation|Member|Last Update " ;
		        var headCount=ComCountHeadTitle(HeadTitle);
		        (headCount, 0, 0, true);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_grp_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"member",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
//		        InitDataValid(0, "cust_grp_id", vtEngUpOther, "0123456789- ");
		        SetColProperty(0 ,"cust_grp_id" , {AcceptKeys:"N|[-]"});
		        SetSheetHeight(252);
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
					var sXml=sheetObj.GetSearchData("ESM_SAM_0903GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
//			case SEARCH01: //조회
//				formObj.f_cmd.value = SEARCH01;
//				var sXml = sheetObj.GetSearchXml("ESM_SAM_0004GS.do", FormQueryString(formObj));
//				var cust_grp_nm = (ComGetEtcData(sXml, "cust_grp_nm") == undefined) ? "" : ComGetEtcData(sXml, "cust_grp_nm");
//				sheetObj.WaitImageVisible = false;
//				document.form.cust_grp_nm.value =cust_grp_nm;
//				if(cust_grp_nm == "") {
//					ComShowCodeMessage("COM130402", "CUST GRP NM");	//'{?msg1} doesn\'t exist'
//					formObj.cust_grp_id.value="";
//					formObj.cust_grp_nm.value="";
//	 				sheetObjects[0].RemoveAll();
//	 				formObj.cust_grp_id.focus();
//
//				}else{
//					document.form.cust_grp_nm.value =cust_grp_nm;
//				}	
//				
//				
//				break;
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
    * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
	function obj_Keypress(){
		/*
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName=ComGetEvent("name");
		var srcValue=event.srcElement.getAttribute("value");
		switch(event.srcElement.dataformat) {
		case "engupnum"://숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum', "45"); 
			break;
		case "engupspecial": // 영문대문자 + Space + &-,.
        	ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95");
			break;
		default:     //영문 + 숫자
//			ComKeyOnlyAlphabet('uppernum'); break;
		}
		*/
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
		 case IBSEARCH:
			var cust_grp_nm=formObj.cust_grp_nm.value.length; 
			if(cust_grp_nm < 3) {
				ComShowCodeMessage("SAM00002", "Group Name", "3"); 	//Group Name 최소 문자 3자리이상.
	 			return false;
	 		}
			var cust_grp_abbr_nm=formObj.cust_grp_abbr_nm.value.length; 
			if(	cust_grp_abbr_nm > 0 && cust_grp_abbr_nm < 3) {
				ComShowCodeMessage("SAM00002", "Abbreviation", "3"); 	//Abbreviation 최소 문자 3자리이상.
 				return false;
 			}
  		break;
  	}
  	return true;
  }
	/**
     * 필드 데이타가 CHANGE될 경우 이벤트
     */
    function obj_change(){
//    	var srcName = window.event.srcElement.getAttribute("name");
//
//    	if (srcName == "cust_grp_id")  {
//    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
//    	}
    }
    /**
     * COM_ENS_071 : 팝업에서 선택한 값 한개 받기 
     * @author SHKIM 
	 * @version 2012.02.15
     */
    function getCOM_ENS_071_ofc_cd(rowArray) {    
    	document.form.ofc_cd.value=rowArray[0][1];		//OFC_CD -- Sales Office 
    }
    /**
     * opener로 값을 리턴하는 기능 구현<br>
     * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,<br>
     * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.<br>
     * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.<br>
     * 둘중 하나만 사용한다 .<br>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 김성훈
     * @version 2012.02.16
     */
   function sheet1_OnDblClick(sheetObj, row, col) {
	   doReturnValue(sheetObj, row, col);
   }
   /**
	 * 입력받은 ROW의 정보를 부모창에 리턴한다.
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function doReturnValue(sheetObj, row, col){
		var locCustGrpId=sheetObj.GetCellValue(row, "ofc_cd");
		var reqOfcCd=document.form.reqOfcCd.value;
		if(reqOfcCd!="" && reqOfcCd != locCustGrpId){
			if(!confirm("Office Code doesn't match. Do you want to continue?")){ return; }
		}
		comPopupOK();
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
