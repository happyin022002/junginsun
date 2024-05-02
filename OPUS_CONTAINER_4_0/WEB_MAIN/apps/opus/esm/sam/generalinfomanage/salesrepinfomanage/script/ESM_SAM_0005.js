/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0005.js
*@FileTitle  : Sales Rep List
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
    function processButtonClick() {
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            var formObject=document.form;
            switch (srcName) {
            	case "btn_office_code":  
            		ComOpenPopup("/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071", 770, 520, "callBackComEns071", '1,0,1,1,1,1,1', true);
          	 		break   
            	case "btn_cust_cd":    
            		var custCntCdSeq=formObject.cust_cd.value;
    	    		ComOpenPopup("/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+custCntCdSeq, 770, 490, "callBackComEns041", '1,0,1,1,1,1,1', true);
          	 		break
                case "btn_retrieve":   
                	sheetObjects[0].RemoveAll();
               	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		//조회
                    break     
                case "btn_new":   
               	 	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);		//New
                    break 
                case "btn_Close":   
                	ComClosePopup(); 
                    break 
             } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++]=sheetObj;
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
      * @author 이관샨
      * @version 2011.05.23
  	*/
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObject=document.form;
    	initControl();	
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBCombo(sheetObjects[0], formObject, SEARCH);
     }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {
        case 1:    //sheet[1] init
	             with (sheetObj) {
	                 var HeadTitle="|SEQ|Sales Rep\nCode|Sales Rep Name|User ID|Office Code|Team Code|E-mail|Primary S.Rep\nCode|I/B|O/B|Status";
	                 var headCount=ComCountHeadTitle(HeadTitle);

	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);

	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                        {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:304,  Align:"Left",    ColMerge:1,   SaveName:"srep_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"empe_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_team_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"srep_eml",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"srep_prmry_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ib",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ob",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
	                  
	                 InitColumns(cols);

	                 SetEditable(1);
	                 SetWaitImageVisible(0);
	                 sheetObj.SetColHidden("srep_prmry_flg",1);
	                 SetAutoRowHeight(0);
	                 SetSheetHeight(525);
	                 resizeSheet();
	             }
                 break;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
        case IBSEARCH:    // sheet1 조회		
	        if (!validateForm(sheetObj,document.form,sAction)) {
	    		return false;
	    	}else if (frmObj.cust_cd.value != '' || cust_status.GetSelectCode()!= ''){
	    		sheetObj.SetColHidden("srep_prmry_flg",0);
	    	}else if (frmObj.cust_cd.value == '' && cust_status.GetSelectCode()== ''){
	    		sheetObj.SetColHidden("srep_prmry_flg",1);
	    	}
        	ComOpenWait(true);
 			frmObj.f_cmd.value=SEARCH;
 			var sParam=FormQueryString(frmObj);
 			var sXml=sheetObj.GetSearchData("ESM_SAM_0005GS.do", sParam );
 			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 			ComOpenWait(false);
 			break;
        case SEARCH01:
       	 var formObject=document.form;
            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
            var sheetObject1=sheetObjects[0];
            /*******************************************************/
        		try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {  
   	             case "cust_office":
   	           		if(formObject.cust_office.value.length>0){	
   	           			formObject.f_cmd.value=SEARCH02;
   	 		 			var sParam="f_cmd="       +formObject.f_cmd.value
   	 		 						+ "&hidden_ofc_cd=" +formObject.cust_office.value;
   	 		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0005GS.do", sParam);
   	 		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
   	     		        if(hidden_ofc_cd == ""){
   	     		        	formObject.cust_office.value="";
   	     		        	ComShowCodeMessage("COM130402", "Office Code"); 		
   	     		        	ComSetFocus(document.form.cust_office);		
   	     		        } 
   	           		}
   	           		break;
                			}   // end switch
   				}catch(e) {
   	          		if( e == "[object Error]") {
   	          			ComShowMessage(OBJECT_ERROR);
   	          		} else {
   	          			ComShowMessage(e.message);
   	          		}
   	          	}  		
   				break;
       case SEARCH02:
       	 var formObject=document.form;
            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
            var sheetObject1=sheetObjects[0];
            /*******************************************************/
        		try {
        		var srcName=ComGetEvent("name");
                switch(srcName) {  
   	              	case "cust_cd":
   	              		if(formObject.cust_cd.value.length>0){	
   	              			formObject.f_cmd.value=SEARCH03;
   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
   	    		 						+ "&hidden_ofc_cd=" +formObject.cust_cd.value;
   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0005GS.do", sParam);
   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
   	        		        if(hidden_ofc_cd == undefined){
   	        		        	formObject.cust_cd.value="";
   	        		        	ComShowCodeMessage("COM130402", "Customer Code"); 		
   	        		        	ComSetFocus(document.form.cust_cd);		
   	        		        } else {
	   	        		        	formObject.cust_cd.value=hidden_ofc_cd;	
	   	        		        }
   	              		}
   	              		break;
                			}   // end switch
   				}catch(e) {
   	          		if( e == "[object Error]") {
   	          			ComShowMessage(OBJECT_ERROR);
   	          		} else {
   	          			ComShowMessage(e.message);
   	          		}
   	          	}  		
   				break;
        case IBCLEAR:    //New	 
        	cust_status.SetSelectCode('');
			frmObj.reset();
			sheetObj.RemoveAll();
			sheetObj.SetColHidden("srep_prmry_flg",1);
	        break;
        }
    }
    /**
     * 모든 콤보 박스 조회
     * 공통 부분 완성되면 추가 작업 요
     */
   	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
   		switch (sAction) {
   			case SEARCH: // load page 시
   			    var param="f_cmd="+SEARCH+"&scr_no="+"0005";
   			    var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do",param);
   			var arrXml=sXml.split("|$$|");
   						if (arrXml.length > 0) 
   							ComXml2ComboItem(arrXml[0], cust_status, "cd", "cd_desc");
     		break;
     	}
   	}
    /**
     * Office No. OnKeyPress 시 호출된다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchOfficeName
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이관샨
     * @version 2011.06.16
     */
    function searchOfficeCodeName(obj) {   
     	if(obj.value.length == 6) {  
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
     	}else if(obj.value.length == 8){
    	 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
     	}
    }
     /**
      * 필드 데이타가 CHANGE될 경우 이벤트
      */
     function obj_change(){
    	 obj=event.srcElement;	
     	 if(obj.value.length < 6) {  
     		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
     		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
     	 }else if(obj.value.length != 8){
     		 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
     	 }
     }
      /**
      * Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
      * callBackComEns041(arrBal);
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      */    	
      function callBackComEns041(rArray){
      		var formObj=document.form;
      		if(rArray != null){
      			ComSetObjValue(formObj.cust_cd, ComLpad(rArray[0][3],6,"0"));  				    			   			
      		}
      }
      /**
      * Office Inquiry(공통Popup) 호출후 Return받는 함수. <br>
      * callBackComEns071(arrBal);
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      */    	
      function callBackComEns071(rArray){
      		var formObj=document.form;
      		if(rArray != null){
      			ComSetObjValue(formObj.cust_office, ComLpad(rArray[0][3],6,""));  				    			   			
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
      * @author 이관샨
      * @version 2011.06.03
      */    
       function initControl() {
	       //Axon 이벤트 처리1. 이벤트catch(개발자변경)            	  
		  axon_event.addListenerForm('change', 'obj_change', form);
		  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
     * @author 이관샨
     * @version 2011.06.16
     */
   function sheet1_OnDblClick(sheetObj, row, col) {
	   if(document.form.open_page.value!="null"){
		   doReturnValue(sheetObj, row, col);     
	   }
   }
   
   /**
    * This method counts numbers again.
    * @param Col
    * @param SortArrow
    */
   function sheet1_OnSort(Col, SortArrow){
	   sheet1.ReNumberSeq();
   }
   
	/**
 	 * 입력받은 ROW의 정보를 부모창에 리턴한다.
 	 * @param sheetObj
 	 * @param row
 	 * @param col
 	 * @return
 	 */
 	function doReturnValue(sheetObj, row, col){
 		var srepCd=sheetObj.GetCellValue(row, "srep_cd");
 		var ofcCd=sheetObj.GetCellValue(row, "ofc_cd");
 		var opener=window.dialogArguments;  
 		
// 		2014.08.12 김용습 - Customer Information(ESM_SAM_0002)으로 부터 팝업창으로 떴을 때 더블클릭으로 선택된 값이 ESM_SAM_0002에 전달안되는 버그를 해결하기 위해 추가 
 		if (!opener) opener=parent;
 		
 		var opnsheetObj=opener.sheetObjects[3];
 		var opnformObj=opener.document.form;
 		var mrow=opnsheetObj.LastRow();
 		var opn=document.form.open_page.value;
 		if(opn == 2){
 			opnsheetObj.SetCellValue(mrow, "srep_cd",srepCd,0);
 			opnsheetObj.SetCellValue(mrow, "ofc_cd",ofcCd,0);
 			opnformObj.chk_srep_cd.value = srepCd;
 			
// 			2014.12.03 김용습 - IE에서 오류가 발생하여 소스 수정 (SEARCH10을 찾지 못함)
// 			opener.doActionIBSheet(opnsheetObj, opnformObj, SEARCH10); // 기존소스 
 			opener.callDoActionIBSheet(opnsheetObj, opnformObj); // 변경소스
 		}	
 		ComClosePopup(); 		
 	}
    /**
	 * 키보드로 입력되는 값 제어
	 * @param obj
	 */
	function keyValidation(obj){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(obj.dataformat){
			// 정수형 숫자
		    case "num": 
		    case "ymd":
		    case "yyyy":
		    case "hm":
		        ComKeyOnlyNumber();
		    break;
		    // 실수형 숫자
		    case "float":
		        ComKeyOnlyNumber(event.srcElement, ".");
		    break;
		    // 영문자
		    case "eng":
		        ComKeyOnlyAlphabet();
		    break;
		    // 영소문자
		    case "engdn":
		        ComKeyOnlyAlphabet('lower');
		    break;
		    // 영대문자
		    case "engup": 
		        ComKeyOnlyAlphabet('upper');
		    break;
		    //영대문자+숫자
		    case "uppernum": 
		    	ComKeyOnlyAlphabet('uppernum');
		    break;
		}
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
   	 switch (sAction) {
		   	case IBSEARCH: // 조회
				if(frmObj.cust_office.value.length < 5) {
					ComShowCodeMessage("COM130403", "Office Code"); // Office Code is null
					ComSetFocus(document.form.cust_office);					
					return false;
			}
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
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

