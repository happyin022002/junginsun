/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0901.js
*@FileTitle  : Sales Activity List
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
            		if(!document.getElementById(srcName).disabled){
            			ComOpenPopup("/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071", 770, 520, "callBackComEns071", '1,0,1,1,1,1,1', true);
            		}
          	 		break   
                case "btn_retrieve":   
                	sheetObjects[0].RemoveAll();
                	
               	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		//조회
                    break          
                case "btn_close":   
                	ComClosePopup(); 
                    break;
//                    2014.08.01 김용습 - 달력 스타일 변경
//                case "btns_calendar1": //달력버튼
//                	cal=new ComCalendar();
//                    cal.select(formObject.from_date, 'yyyy-MM-dd');
//                break;
//                case "btns_calendar2": //달력버튼                  
//                	cal=new ComCalendar();
//                	cal.select(formObject.to_date, 'yyyy-MM-dd');
//                break;
                case "btn_Calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
                    break;  
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
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();	 
        doActionIBCombo(sheetObjects[0], formObject, SEARCH);
        doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
//        checkUserCodeName();
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
	                 var HeadTitle1="|Activity\nNo.|Sales Rep.|Sales Rep.|Customer|Customer|MGR\nComment|Purpose|Call\nReport";
	                 var HeadTitle2="|Activity\nNo.|Code|Name|Code|Name|MGR\nComment|Purpose|Call\nReport";
	                 var headCount=ComCountHeadTitle(HeadTitle2);

	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"},
	                             { Text:HeadTitle2, Align:"Center"} ];
	                 InitHeaders(headers, info);

	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"activity_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:85,  Align:"Left",    ColMerge:1,   SaveName:"sls_name",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cus_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:435,  Align:"Left",    ColMerge:1,   SaveName:"cus_name",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mgr_comment",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"purpose",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"call_report",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
	                  
	                 InitColumns(cols);

	                 SetEditable(1);
	                 SetWaitImageVisible(0);
	                 SetAutoRowHeight(0);
	                 SetSheetHeight(450);
	             }
                 break;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
    	try {
    		sheetObj.ShowDebugMsg(false);
    		switch (sAction) {
    		case IBSEARCH:    // sheet1 조회	
	        	if (!validateForm(sheetObj,document.form,sAction)) {
	        		return false;
	        	}
	        	ComOpenWait(true);
	 			frmObj.f_cmd.value=SEARCH;
	 			var sParam=FormQueryString(frmObj);
	 			var sXml=sheetObj.GetSearchData("ESM_SAM_0901GS.do", sParam );
	 			sheetObj.LoadSearchData(sXml,{Sync:1} );
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
    		              	case "office_cd":
    		              		if(formObject.office_cd.value.length>0){	
    		              			formObject.f_cmd.value=SEARCH02;
    		    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    		    		 						+ "&hidden_ofc_cd=" +formObject.office_cd.value;
    		    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0901GS.do", sParam);
    		    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    		        		        if(hidden_ofc_cd == ""){
    		        		        	formObject.office_cd.value="";
    		        		        	ComShowCodeMessage("COM130402", "Office Code"); 		
    		        		        	ComSetFocus(document.form.office_cd);		
    		        		        } 
    		              		}
    		              		break;
    		              	case "sales_rep_cd":
    		              		if(formObject.sales_rep_cd.value.length>0){	
    		              			formObject.f_cmd.value=SEARCH03;
    		    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    		    		 						+ "&hidden_ofc_cd=" +formObject.sales_rep_cd.value;
    		    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0901GS.do", sParam);
    		    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    		        		        if(hidden_ofc_cd == ""){
    		        		        	formObject.sales_rep_cd.value="";
    		        		        	ComShowCodeMessage("COM130402", "Sales Rep Code"); 		
    		        		        	ComSetFocus(document.form.sales_rep_cd);		
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
	   	              	case "customer_cd":
	   	              		if(formObject.customer_cd.value.length>0){	
		   	              		if(!ComIsNumber(formObject.customer_cd.value.substring(3,6))){
			   	     	        	formObject.customer_cd.value="";
			   	     	        	ComShowCodeMessage("COM130402", "Customer Code"); 	
			   	     	        	ComSetFocus(document.form.customer_cd);	
		   	     	        	return false;
		   	              		}
	   	              			formObject.f_cmd.value=SEARCH04;
	   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	   	    		 						+ "&hidden_ofc_cd=" +formObject.customer_cd.value;
	   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0901GS.do", sParam);
	   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	   	        		        if(hidden_ofc_cd == ""){
	   	        		        	formObject.customer_cd.value="";
	   	        		        	ComShowCodeMessage("COM130402", "Customer Code"); 		
	   	        		        	ComSetFocus(document.form.customer_cd);		
	   	        		        } 
	   	              		}
	   	              		break    
	        		}   // end switch
	   				}catch(e) {
	   	          		if( e == "[object Error]") {
	   	          			ComShowMessage(OBJECT_ERROR);
	   	          		} else {
	   	          			ComShowMessage(e.message);
	   	          		}
	   	          	}  	
	   				break
    		case SEARCH03:
    			var formObject=document.form;
	            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	            var sheetObject1=sheetObjects[0];
	            /*******************************************************/
	        		try {
	        		var srcName=ComGetEvent("name");
	                switch(srcName) {  
	   	              	case "team_cd":
	   	              		if(formObject.team_cd.value.length>0){	
	   	              			formObject.f_cmd.value=SEARCH05;
	   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	   	    		 						+ "&hidden_ofc_cd=" +formObject.team_cd.value;
	   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0901GS.do", sParam);
	   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	   	        		        if(hidden_ofc_cd == ""){
	   	        		        	formObject.team_cd.value="";
	   	        		        	ComShowCodeMessage("COM130402", "Team Code"); 		
	   	        		        	ComSetFocus(document.form.team_cd);		
	   	        		        } 
	   	              		}
	   	              		break    
	        		}   // end switch
	   				}catch(e) {
	   	          		if( e == "[object Error]") {
	   	          			ComShowMessage(OBJECT_ERROR);
	   	          		} else {
	   	          			ComShowMessage(e.message);
	   	          		}
	   	          	}  	
	   				break
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
   				var formObj=document.form;
   			    var param="f_cmd="+SEARCH+"&scr_no="+"0901";
   			    var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do",param);
   	     		var rtnValue=sXml.split("|$$|");
   	     		for(var i=0; i<rtnValue.length; i++){
					var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
					var cdName=comboXml[0].split("|");
					var cdValue=comboXml[1].split("|");
					for (var j=0; j < cdName.length; j++) {
						comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);			
 					}
   	     		}
     		break;		
   		}
   		search_type.SetSelectCode("P");
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
	      axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);   
		  axon_event.addListenerForm('change', 'obj_change', form);
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
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 김민아
 	* @version 2010.10.13
    */  
    function com_change_sheet( sheetObj, colNm ){
    	var nowRow=sheetObj.GetSelectRow();
    	var formObj=document.form;
        var eleValue="";
        if(nowRow != -1){
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                default:
                    eleValue=document.getElementById(colNm).value; 
                    break;                  
            }           
            sheetObj.SetCellValue(nowRow,colNm,eleValue);
        }else{
            sheetObj.SetCellValue(nowRow,colNm,document.getElementById(colNm).GetSelectCode());
        	}
        }
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
     * @version 2011.06.16
     */
    function checkUserCodeName() {   
   	 var formObject=document.form;
   	 var sheetObject1=sheetObjects[0];
   	 if(formObject.usr_id.value.length>0){
   	 		var userAuth=checkUserAuth(formObject,sheetObject1);
		        if(userAuth == ''){
		        	formObject.office_cd.readOnly=true;
		        	formObject.office_cd.setAttribute("className","input2");
		        	formObject.sales_rep_cd.readOnly=true;
		        	formObject.sales_rep_cd.setAttribute("className","input2");
		        	btnImgEnable(formObject.btn_office_code, false);
		        }else{
		        	formObject.office_cd.readOnly=true;
		        	formObject.office_cd.setAttribute("className","input2");
		        	btnImgEnable(formObject.btn_office_code, false);
		        }
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
     			ComSetObjValue(formObj.office_cd, ComLpad(rArray[0][3],6,""));  				    			   			
     		}
     }
     /**
      * 필드 데이타가 CHANGE될 경우 이벤트
      */
     function obj_change(){
    		 obj=event.srcElement;	
	     	 if(obj.value.length < 3) {  
	     		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	     		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	     		doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
	     	 }else if(obj.value.length < 6){
	     		 doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	     		 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	     	 }else if(obj.value.length != 8){     		
	     		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	     	 }
           }
       /**
        * Office Code. OnKeyPress 시 호출된다.<br>
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
             }else if(obj.value.length == 3){
            	 doActionIBSheet(sheetObjects[0], document.form, SEARCH03);
             }
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
        * @version 2011.06.20
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
			var actNo=sheetObj.GetCellValue(row, "activity_no");
			var custCd=sheetObj.GetCellValue(row, "cus_code");
			var custNm=sheetObj.GetCellValue(row, "cus_name");			
     		var opener=window.dialogArguments;     
     		
//     		2014.08.12 김용습 - parent 창에 데이터 전달 안되는 버그 해결하기 위해 추가
     		if (!opener) opener=parent;
     		
     		var opnformObj=opener.document.form;
     		opnformObj.sls_act_seq.value=actNo;	
     		opnformObj.cust_cd.value=custCd;	
     		opnformObj.cust_lgl_eng_nm.value=custNm;	     		
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
    			if(frmObj.office_cd.value.length < 5) {
    				ComShowCodeMessage("COM130403", "Office Code"); // Office Code is null
    				ComSetFocus(document.form.office_cd);					
    				return false;
    			}else if(frmObj.sales_rep_cd.value.length != 5) {
    				ComShowCodeMessage('COM130403', "Sales Rep Code"); // Sales Rep Code is null
    				ComSetFocus(document.form.sales_rep_cd);					
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
