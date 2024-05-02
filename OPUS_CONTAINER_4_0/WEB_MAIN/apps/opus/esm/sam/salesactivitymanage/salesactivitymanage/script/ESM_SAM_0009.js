/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0009.js
*@FileTitle  : Performance by Customer
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
            			ComOpenPopup("/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071", 770, 440, "callBackComEns071", '1,0,1,1,1,1,1', true);
            		}
            			break   
            	case "btn_cust_cd":   
            		var custCntCdSeq=formObject.cust_cd.value;
    	    		ComOpenPopup("/opuscntr/COM_ENS_041.do?pgmNo=COM_ENS_041&cust_cd="+custCntCdSeq, 770, 440, "callBackComEns041", '1,0,1,1,1,1,1', true);       	
          	 		break
                case "btn_retrieve":   
               	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		//조회
                    break          
                case "btn_new":   
                	doActionIBSheet(sheetObjects[0], document.form,IBCLEAR);
                    break;
                case "btns_calendar1": //달력버튼
                	cal=new ComCalendar();
                    cal.select(formObject.from_date, 'yyyy-MM-dd');
                break;
                case "btns_calendar2": //달력버튼                  
                	cal=new ComCalendar();
                	cal.select(formObject.to_date, 'yyyy-MM-dd');
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
	      axon_event.addListenerForm('click', 'obj_click', document.form);	 
		  axon_event.addListenerForm('change', 'obj_change', document.form); // change
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 initControl();	
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
        }
        checkUserCodeName();
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
	                 var HeadTitle="|Seq|Booking No.|Booking\nDate|Customer\nCode|Commodity|VVD|POR|POL|POD|DEL|Status|Sales\nRep|Cntr\nTP/SZ|Qty";
	                 var headCount=ComCountHeadTitle(HeadTitle);

	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);

	                 var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cre_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                     {Type:"AutoSum",   Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:false,UpdateEdit:0 } ];
	                  
	                 InitColumns(cols);

	                 SetEditable(1);
	                 SetWaitImageVisible(0);
                     sheetObj.SetColHidden("bkg_no",1);
	                 sheetObj.SetColHidden("bkg_cre_dt",1);
	                 SetAutoRowHeight(0);
	                 SetSheetHeight(420);
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
	    	}
        	sheetObj.SetWaitImageVisible(1);
 			frmObj.f_cmd.value=SEARCH;
 			var sParam=FormQueryString(frmObj);
 			var sXml=sheetObj.GetSearchData("ESM_SAM_0009GS.do", sParam );
 			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 			if (ComGetEtcData(sXml,"total_bkg")  != undefined){ 
		 			frmObj.total_bkg.value=ComGetEtcData(sXml,"total_bkg");
		 		}
			if (sheetObj.RowCount()>= 0) {
				lstRow=sheetObj.LastRow();
		        sheetObj.SetRowHidden(lstRow,1);
		        if (sheetObj.GetCellValue(lstRow, "op_cntr_qty") == '') {
	            	frmObj.total_qty.value="0";
	            	frmObj.total_bkg.value="0";
	            }else{
	            	frmObj.total_qty.value=sheetObj.GetCellText(lstRow, "op_cntr_qty");
	            }
			}
	 			sheetObj.SetWaitImageVisible(0);
 			break;
        case SEARCH01:
        	 var formObject=document.form;
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
             var sheetObject1=sheetObjects[0];
             /*******************************************************/
         		try {
         		var srcName=ComGetEvent("name");
                 switch(srcName) {  
    	             case "sales_office":
    	           		if(formObject.sales_office.value.length>0){	
    	           			formObject.f_cmd.value=SEARCH02;
    	 		 			var sParam="f_cmd="       +formObject.f_cmd.value
    	 		 						+ "&hidden_ofc_cd=" +formObject.sales_office.value;
    	 		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0009GS.do", sParam);
    	 		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    	     		        if(hidden_ofc_cd == ""){
    	     		        	formObject.sales_office.value="";
    	     		        	ComShowCodeMessage("COM130402", "Sales Office Code"); 		
    	     		        	ComSetFocus(document.form.sales_office);		
    	     		        } 
    	           		}
    	           		break;
    	              	case "sales_rep":
    	              		if(formObject.sales_rep.value.length>0){	
    	              			formObject.f_cmd.value=SEARCH03;
    	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    	    		 						+ "&hidden_ofc_cd=" +formObject.sales_rep.value;
    	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0009GS.do", sParam);
    	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    	        		        if(hidden_ofc_cd == ""){
    	        		        	formObject.sales_rep.value="";
    	        		        	ComShowCodeMessage("COM130402", "Sales Rep Code"); 		
    	        		        	ComSetFocus(document.form.sales_rep);		
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
    	              			formObject.f_cmd.value=SEARCH04;
    	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    	    		 						+ "&hidden_ofc_cd=" +formObject.cust_cd.value;
    	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0009GS.do", sParam);
    	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    	        		        if(hidden_ofc_cd == undefined){
    	        		        	formObject.cust_cd.value="";
    	        		        	ComShowCodeMessage("COM130402", "Customer Code"); 		
    	        		        	ComSetFocus(document.form.cust_cd);		
    	        		        } else{
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
        case IBCLEAR:    // sheet1 New
	    	ComOpenWait(true);		 		
			frmObj.reset();
			sheetObj.RemoveAll();
			sheetObj.SetColHidden("bkg_no",1);
            sheetObj.SetColHidden("bkg_cre_dt",1);
			ComOpenWait(false);
        break;
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
      	if(obj.value.length == 5) {  
  				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
         }else if(obj.value.length == 8){
        	 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
         }
     }
      /**
  	 * DATE 값이 변경 되었을 때 값의 유효성을 체크
  	 */
  	function checkDateForm() {
  		ComKeyOnlyNumber(obj);
  		var srcValue=obj.value;
  	 	if (srcValue.length == 4) {
  	 		obj.value=srcValue.substring(0,4) + "-"
  	 	}
  	 	if (srcValue.length == 7) {
  	 		obj.value=srcValue.substring(0,7) + "-"
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
//              obj.SetEnable(1);
              btnStyle.cursor="hand";
              btnStyle.filter="";
              obj.disabled=false;
          } else {
//              obj.SetEnable(0);
              btnStyle.cursor="auto";
              btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
              obj.disabled=true;
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
 		        	formObject.sales_office.readOnly=true;
 		        	formObject.sales_office.setAttribute("className","input2");
 		        	formObject.sales_rep.readOnly=true;
 		        	formObject.sales_rep.setAttribute("className","input2");
 		        	btnImgEnable(formObject.btn_office_code, false);
 		        }else{
 		        	formObject.sales_office.readOnly=true;
 		        	formObject.sales_office.setAttribute("className","input2");
 		        	btnImgEnable(formObject.btn_office_code, false);
 		        }
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
      			ComSetObjValue(formObj.sales_office, ComLpad(rArray[0][3],6,""));  				    			   			
      		}
      }
     /**
     * Object 의 Onclick 이벤트핸들러 <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  없음  
     * @return 없음
     * @see #
     * @author 이관샨
     * @version 2011.07.19
     */
    function obj_click(){
        var form=document.form;
        var obj=event.srcElement;
        var sheet1=sheetObjects[0];
        switch(ComGetEvent("name")){
            case "bkg_info":
                var chgCdObj=form.chg_cd;
                if(obj.checked) {   
                    sheet1.SetColHidden("bkg_no",0);
                    sheet1.SetColHidden("bkg_cre_dt",0);
                }else{
                    sheet1.SetColHidden("bkg_no",1);
                    sheet1.SetColHidden("bkg_cre_dt",1);
                }
                break;
        }
    }
    /**
     * 필드 데이타가 CHANGE될 경우 이벤트
     */
    function obj_change(){
    	 obj=event.srcElement;	
    	 if(obj.value.length < 5) {  
    		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    	 }else if(obj.value.length != 8){
    		 doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    	 }
    }
    /**
     * OnKeyPress event를 처리한다. <br>
     * @author 이관샨
     * @version 2011.06.16
     */     
   function obj_keypress() {
    	var formObj=document.form;
    	var srcName=ComGetEvent("name");
	 	obj=event.srcElement;	 	
	 	keyValidation(obj);
	 	switch(srcName) {
	        case "from_date":						//날짜형식에 맞게 입력 되도록
	        		checkDateForm(formObj.from_date);
	        break;
	        case "to_date":					//날짜형식에 맞게 입력 되도록
	        		checkDateForm(formObj.to_date);
	        break;
	    }
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
		    //영문+숫자+공통특수문자(./()@&-', _)
		    case "engnum": 
		   	  	ComKeyOnlyAlphabet('num', "32|38|39|40|41|44|45|46|47|64|95");
		    break;
		    //숫자+"-" 입력가능
		    case "fax":
	     	case "tel":
	     		ComKeyOnlyNumber(event.srcElement, "-");
	     	break;
	     	//숫자+"-._@" 입력가능
	     	case "email":
	     		ComKeyOnlyAlphabet('num', "45|46|64|95");
	     	break;
	     	 case "engupspecial": // 영문대문자 + Space + &-,.
	         ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95");
	         break;
	     	case "engupbracket": // 영문대문자 + Space + &-,.[]
	        ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95|91|93");
	        break;
	     	//영문+숫자+공통특수문자+한글 등등
	     	default:
	     		if ((keyValue >= 33 && keyValue <= 37) ||(keyValue >= 42 && keyValue <= 43) || (keyValue >= 58 && keyValue <= 63) || (keyValue >= 91 && keyValue <= 94))
	     		{
	     			event.keyCode=false;
	     		}
		    break;
		}
	}
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
   	 switch (sAction) {
		   	case IBSEARCH: // 조회
					if(frmObj.sales_office.value.length != 5) {
	    				ComShowCodeMessage("COM130403", "Sales Office Code"); // Sales Office Code is null
	    				ComSetFocus(document.form.sales_office);					
	    				return false;
					}else if(frmObj.sales_rep.value.length != 5) {
	    				ComShowCodeMessage("COM130403", "Sales Rep Code"); // Sales Rep Code is null
	    				ComSetFocus(document.form.sales_rep);					
	    				return false;
					}else if(frmObj.from_date.value.length == '') {
						ComShowCodeMessage("COM130403", "Booking Date"); // Booking Date is null
						ComSetFocus(document.form.from_date);					
						return false;
					}else if(frmObj.to_date.length == '') {
						ComShowCodeMessage('COM130403', "Booking Date"); // Booking Date is null
						ComSetFocus(document.form.to_date);					
						return false;
					}
				break;
				} 
        return true;
     }    
	/* 개발자 작업  끝 */
