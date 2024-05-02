/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0006.js
*@FileTitle  : Customer List by Sales Rep
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
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
            case "btn_assign":
            	var currIdx=sheetObjects[0].GetSelectRow();
            	var param="srepCd=" + formObj.srep_cd.value			
				+ "&ofcCd="	+ formObj.ofc_cd.value	
				+ "&srepNm=" + formObj.srep_nm.value
				+ "&srepPrmryFlg=" + sheetObjects[0].GetCellValue(currIdx, "flg")
				+ "&custCntCd=" + sheetObjects[0].GetCellValue(currIdx, "cust_cnt_cd")
				+ "&cust_seq=" + sheetObjects[0].GetCellValue(currIdx, "cust_seq");
            	var sUrl="/opuscntr/ESM_SAM_0900.do?";
            	if(sheetObjects[0].CheckedRows("sel_check") != 1){
            		ComShowCodeMessage("COM12113", "DATA");
            		break;
            	}	
            	else{
            		var rtnVal=ComOpenWindowCenter(sUrl + param, "ESM_SAM_0900", 550, 150, true);
            		if(rtnVal != undefined) {
            			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            		}
            	}
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
   	 	var formObj=document.form;
   	 	doActionIBCombo(sheetObjects[0], document.form, SEARCH);
   	 	doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
    	checkUserCodeName();
	}
    function initControl(){
   	 	var formObj=document.form;
        axon_event.addListenerFormat("keypress","obj_Keypress", formObj);     // uppereng
    	axon_event.addListenerForm('change', 'obj_change', formObj); // change
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
	                var HeadTitle="|SEL|SEQ|Primary S.Rep Code|Customer Code|Customer Name|Location|Phone#|G/I|||||" ;
	                var headCount=ComCountHeadTitle(HeadTitle);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                    {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel_check" },
	                    {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"primary_srep_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"customer_code",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                    {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"phn_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
	                    {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"indiv_corp_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"flg" },
	                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd" },
	                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd" },
	                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq" },
	                    {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd" } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(452);
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
		 		sheetObj.ShowDebugMsg(false);
		 		sheetObj.SetWaitImageVisible(0);
		 		switch (sAction) {	
		 			case IBSEARCH:	  //조회
		 				if (validateForm(sheetObj, formObj, sAction)){
			 				formObj.f_cmd.value=SEARCH;
		 					var sXml=sheetObj.GetSearchData("ESM_SAM_0006GS.do", FormQueryString(formObj));
			              	sheetObj.LoadSearchData(sXml,{Sync:1} );
		 				}
			 			break;
			 		case SEARCH01:	  //S.Rep 입력시 ofc_cd, srep_nm 조회
		 				formObj.f_cmd.value=SEARCH01;
			 			sheetObjects[0].SetWaitImageVisible(0);
			 			var sXml=sheetObj.GetSearchData("ESM_SAM_0006GS.do", FormQueryString(formObj));
		 			    var ofc_cd=(ComGetEtcData(sXml, "ofc_cd") == undefined) ? "" : ComGetEtcData(sXml, "ofc_cd");
			    		var srep_nm=(ComGetEtcData(sXml, "srep_nm") == undefined) ? "" : ComGetEtcData(sXml, "srep_nm");
			    		sheetObj.RemoveAll();
			    		document.form.ofc_cd.value=ofc_cd;
			    		document.form.srep_nm.value=srep_nm;
			    		if(ofc_cd == "") {
			    			ComShowCodeMessage("COM130402", "S.Rep Code");
			    			formObj.srep_cd.value="";
			    			formObj.srep_cd.focus();
			    		}else{
			    			document.form.ofc_cd.value=ofc_cd;
				    		document.form.srep_nm.value=srep_nm;
				    	}
						break;
			 		case SEARCH02:	  //open시 로그인 유저의 srep 정보 조회
		 				formObj.f_cmd.value=SEARCH02;
			 			sheetObjects[0].SetWaitImageVisible(0);
			 			var sXml=sheetObj.GetSearchData("ESM_SAM_0006GS.do", FormQueryString(formObj));
		 			    var srep_cd=(ComGetEtcData(sXml, "srep_cd") == undefined) ? "" : ComGetEtcData(sXml, "srep_cd");
		 			    var ofc_cd=(ComGetEtcData(sXml, "ofc_cd") == undefined) ? "" : ComGetEtcData(sXml, "ofc_cd");
			    		var srep_nm=(ComGetEtcData(sXml, "srep_nm") == undefined) ? "" : ComGetEtcData(sXml, "srep_nm");
			    		document.form.srep_cd.value=srep_cd;
			    		document.form.ofc_cd.value=ofc_cd;
			    		document.form.srep_nm.value=srep_nm;
			    		if(ofc_cd != ""){
			    			document.form.srep_cd.value=srep_cd;
			    			document.form.ofc_cd.value=ofc_cd;
				    		document.form.srep_nm.value=srep_nm;
				            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
				    	}
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
	    * 모든 콤보 박스 조회
	    * 공통 부분 완성되면 추가 작업 요
	    */
	   function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
		   switch (sAction) {
		   case SEARCH: // load page 시
		   var param="f_cmd="+SEARCH+"&scr_no="+"0006";
		   var sXml=sheetObjects[0].GetSearchData("ESM_SAM_COMGS.do",param);
		   var arrXml=sXml.split("|$$|");
		   var comboXml=ComXml2ComboString(arrXml[0], "cd_desc", "cd");
		   var cdName=comboXml[0].split("|");
		   var cdValue=comboXml[1].split("|");
		   sheetObjects[0].SetColProperty("indiv_corp_div_cd", {ComboText:"|"+comboXml[0], ComboCode:"|"+comboXml[1]} );
		   break;
		   }
	   }
 /**
    * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
    function obj_Keypress(){
        var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName=ComGetEvent("name");
        var srcValue=event.srcElement.getAttribute("value");
        switch(event.srcElement.dataformat) {
            case "engupnum"://숫자+"영문대분자"입력하기
            	  ComKeyOnlyAlphabet('uppernum'); break;
            default:     //영문 + 숫자
                ComKeyOnlyAlphabet('uppernum'); break;
          }
    }
    /**
     * 필드 데이타가 CHANGE될 경우 이벤트
     */
    function obj_change(){
  	  var formObj=document.form;
  	  /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
  	  var sheetObj=sheetObjects[0];
  	  /*******************************************************/
  	  try {
  		  var srcName=ComGetEvent("name");
  		  switch(srcName) {
  		  case "srep_cd":
  			  if(formObj.srep_cd.value.length>0){
  				  doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
  			  }
  			  // end switch
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
     * User Auth 확인<br>
     * @return 없음
     * @author 이창원
     * @version 2011.08.11
     */
     function checkUserCodeName() {  
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 if(formObj.usr_id.value.length>0){
    		 var userAuth=checkUserAuth(formObj, sheetObj);
    		 if(userAuth != ''){
    			 formObj.srep_cd.readOnly=false;  
    			 formObj.srep_cd.setAttribute("className","input1");
    		 } else{
    			 formObj.srep_cd.readOnly=true;
    			 formObj.srep_cd.setAttribute("className","input2");
    		 }
    	 }
     }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
     		case IBSEARCH:
     			if(	formObj.srep_cd.value == "") {
    				ComShowCodeMessage("COM130403", "S.Rep Code");
    				return false;
    			}
     		break;
     	}
     	return true;
     }
	/* 개발자 작업  끝 */
