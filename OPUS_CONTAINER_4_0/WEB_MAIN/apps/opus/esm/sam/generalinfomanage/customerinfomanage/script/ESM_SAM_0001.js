/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAM_0001.js
*@FileTitle  : Sales Rep. Adjustment by Office in a Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
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
     * @class ESM_SAM_0001 : ESM_SAM_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SAM_0001() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.searchOfficeCodeName=searchOfficeCodeName;
    }
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var mainPage;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            var formObject=document.form;
            switch (srcName) {
        		case "btn_save":       
        			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);    // 저장
        			break; 
        		case "btn_office_code":       
        			if(!document.getElementById(srcName).disabled){
        				ComOpenPopup("/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071", 1000, 520, "callBackComEns071", '1,0,1,1,1,1,1', true);
        			}
        			break;   
            	case "btn_srep_change": 
            		var selected_rows=sheetObjects[0].CheckedRows("sel");
            		if (selected_rows< 1){
            			ComShowCodeMessage('COM12113', "customer.");
            			return;
            		} 
            		ComOpenPopup("/opuscntr/ESM_SAM_0904.do?sls_ofc_cd="+formObject.cust_office.value, 360, 400, '', '1,0,1,1,1,1,1', true);
          	   		break; 
            	case "btn_cust_info":
            		//var row=0;
            		 if (sheetObjects[0].GetSelectRow() < 1){
                         ComShowCodeMessage('COM130402', "Selected Customer");
                         return;
                     }	
            		
            		var row=sheetObjects[0].GetSelectRow();
            		 
            		var pgmNo="ESM_SAM_0002";
    	 			var pgmUrl="/opuscntr/ESM_SAM_0002.do"
    	 			var pCust_cd="";
    	 			pCust_cd=sheetObjects[0].GetCellValue(row, "cust_cd");
    	    		var params="&cust_cd=" + pCust_cd;
    				var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
    	 			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
    				var sFeatures="status=no, width=1024, height=750, resizable=yes, scrollbars=yes";   
//    				var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
    				var winObj=window.open(pgmUrl+"?parentPgmNo=" + parentPgmNo + src);
          	 		break; 
            	case "btn_retrieve":   
            		sheetObjects[0].RemoveAll();
            		
               	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		//조회
                    break;                  
                case "btn_new":   
                	doActionIBSheet(sheetObjects[0], document.form,IBCLEAR);
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
     * IBMulti Combo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_obj);
     * </pre>
     * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
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
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        	}
        //IBMultiCombo초기화
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initControl();	
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        checkUserCodeName();
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
 		        	formObject.cust_office.readOnly=true;
 		        	formObject.cust_office.setAttribute("className","input2");
 		        	srep_cd.SetEnable(1);
// 		         	ComBtnDisable("btn_save");
// 		        	ComBtnDisable("btn_srep_change");
// 		        	ComBtnEnable("btn_save");
// 		        	ComBtnEnable("btn_srep_change");		        	
 		        }else if (userAuth == 'SAM01' ){ // Manager
 		        	formObject.cust_office.readOnly=true;
 		        	formObject.cust_office.setAttribute("className","input2");
 		        	srep_cd.SetEnable(1);
// 		        	ComBtnEnable("btn_save");
// 		        	ComBtnEnable("btn_srep_change");
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
     
     function callBackPopup(srepCdCode){
        var formObject=document.form;
     	callBackEsmSam0904(sheetObjects[0],formObject,srepCdCode);
     }
     /**
      * Sales REp Change Pop(904)로부터 setting된 sales rep code를 할당 받아서 선택된 sheet의 row의 current sales rep을 변경한다. <br>
      * callBackEsmSam0904(arrBal);
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      */    	
      function callBackEsmSam0904(sheetObj,formObj,rtn_srep_cd){
    	  var iCheckRow=sheetObj.FindCheckedRow("sel");
    	  var arrRow=iCheckRow.split("|");
    	  for (var idx=0;idx<arrRow.length; idx++){
    		  if (sheetObj.GetCellValue(arrRow[idx],"srep_cd") != rtn_srep_cd) {
    			  sheetObj.SetCellValue(arrRow[idx],"srep_cd",rtn_srep_cd);
//    			  sheetObj.CellBackColor(arrRow[idx],"srep_cd") = "#FF0000"
    			  sheetObj.SetCellBackColor(arrRow[idx],"srep_cd","#FFFF80");
    			  
//    			  sheetObj.SetCellFont("FontBold", arrRow[idx],"srep_cd",1);
//    			  sheetObj.SetCellFont("FontSize", arrRow[idx],"srep_cd",9);
//    			  sheetObj.SetCellFont("FontItalic", arrRow[idx],"srep_cd",1);
    			  sheetObj.SetCellFontBold(arrRow[idx],"srep_cd",1);
    			  sheetObj.SetCellFontSize(arrRow[idx],"srep_cd",15);
    			  sheetObj.SetCellFontItalic(arrRow[idx],"srep_cd",1);
    		  }
    	  }
      }
     /**
      * 필드 데이타가 CHANGE될 경우 이벤트
      */
     function obj_change(){
    	 obj=event.srcElement;	
     	 if(obj.value.length != 5) {  
     		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
     	 }
     }
     /**
      * OnDblClick 이벤트 발생시 호출되는 function <br>
      * Sheet에서 Row 를 더블 클릭 시 해당 Row 의 TAA Number 를 return 함<br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
      * @param {int} Row 필수, Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수, Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
      * @returns 없음
      * @author 이관샨
      * @version 2011.05.31
      */
     function sheet1_OnDblClick (sheetObj, Row, Col, Value) {
    	  	var row=sheetObjects[0].GetSelectRow();
  			var pgmNo="ESM_SAM_0002";
			var pgmUrl="/opuscntr/ESM_SAM_0002.do"
			var pCust_cd="";
			pCust_cd=sheetObjects[0].GetCellValue(row, "cust_cd");
	    	var params="&cust_cd=" + pCust_cd;
			var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sFeatures="status=no, width=1024, height=750, resizable=yes, scrollbars=yes";   
//			var winObj=window.open("opusMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
			var winObj=window.open(pgmUrl+"?parentPgmNo=" + parentPgmNo + src);
     }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {
        case 1:    //sheet[1] init
	             var cnt=0;
	             with(sheetObj){
	              var HeadTitle="|SEL|||Customer Code|Customer Name|Location|Office||Current Sales Rep.|Primary|Active|Last Update";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
	                  {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:360,  Align:"Left",  ColMerge:1,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"pre_srep_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"srep_prmry_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lst_upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
//	              SetSheetHeight(520);
	              resizeSheet();
	              SetWaitImageVisible(0);
	              SetAutoRowHeight(0);
	              }


	                 break;
        }
    }
  
    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch (sAction) {
        case IBCREATE:
        	setCustSaleRep();
        	break;
        case IBSEARCH:    // sheet1 조회	
	        if (!validateForm(sheetObj,document.form,sAction)) {
	    		return false;
	    	}
        	ComOpenWait(true);
 			frmObj.f_cmd.value=SEARCH;
 			var sParam=FormQueryString(frmObj);
 			var sXml=sheetObj.GetSearchData("ESM_SAM_0001GS.do", sParam );
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
   	              			formObject.f_cmd.value=SEARCH01;
   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
   	    		 						+ "&hidden_ofc_cd=" +formObject.cust_office.value;
   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0001GS.do", sParam);
   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
   	        		        if(hidden_ofc_cd == ""){
   	        		        	formObject.cust_office.value="";
   	        		        	ComShowCodeMessage("COM130402", "Sales Office"); 		
   	        		        	ComSetFocus(document.form.cust_office);		
   	        		        } 
   	              		}
   	              		break;
   	              	case "sales_rep":
   	              		if(v.sales_rep.value.length>0){	
   	              			formObject.f_cmd.value=SEARCH02;
   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
   	    		 						+ "&hidden_ofc_cd=" +formObject.sales_rep.value;
   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0001GS.do", sParam);
   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
   	        		        if(hidden_ofc_cd == ""){
   	        		        	formObject.sales_rep.value="";
   	        		        	ComShowCodeMessage("COM130402", "Sales Rep"); 		
   	        		        	ComSetFocus(document.form.sales_rep);		
   	        		        } 
   	              		}
   	              		break;
                		}
        			}catch(e) {
        	      		if( e == "[object Error]") {
        	      			ComShowMessage(OBJECT_ERROR);
        	      		} else {
        	      			ComShowMessage(e.message);
        	      		}
        	      	}
        			break;
        case IBCLEAR:    // sheet2 New
	    	ComOpenWait(true);		 		
//			frmObj.reset();
			sheetObj.RemoveAll();
			ComOpenWait(false);
        break;
        case IBSAVE:
        	frmObj.f_cmd.value=MULTI;
			var sParam=ComGetSaveString(sheetObj);
		    if (sParam == "") return;
		    sParam += "&f_cmd=" +frmObj.f_cmd.value + "&usr_id=" +frmObj.usr_id.value;
		    var sXml=sheetObjects[0].GetSaveData("ESM_SAM_0001GS.do", sParam);
		    var result=ComGetEtcData(sXml, "result");
		    var custCd = ComGetEtcData(sXml, "custCd");
		    var srepCd = ComGetEtcData(sXml, "salesRep");
            if(result == "F"){
                ComShowCodeMessage("SAM00019", custCd, srepCd);
                var selRow = sheetObjects[0].FindCheckedRow("sel");
                if(selRow!="" && selRow!=undefined){
                	var selArr = selRow.split("|");
                	for(var i=0; i<selArr.length; i++){
                		if(sheetObjects[0].GetCellValue(selArr[i], "cust_cd")==custCd){
                			sheetObjects[0].SetSelectRow(selArr[i]);
                    		return false;
                		}
                	}
                }
            }else{
                ComShowCodeMessage("COM130102", "Data");
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        break;
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
	      axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);   
//		  axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		  axon_event.addListenerForm('change', 'obj_change', form);
		  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
       } 
     /**
      * OnKeyPress event를 처리한다. <br>
      * @author 이관샨
      * @version 2011.06.16
      */     
//    function obj_keypress() {	   
// 	 	obj=event.srcElement;	 	
// 	 	keyValidation(obj);
//    } 	
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
					if(frmObj.cust_office.value == "") {
	    				ComShowCodeMessage("COM130403", "Sales Office Code"); // Sales Office Code is null
	    				ComSetFocus(document.form.cust_office);					
	    				return false;
					}else if(srep_cd.GetSelectCode()== "") {
	    				ComShowCodeMessage("COM130403", "Sales Rep Code"); // Sales Rep Code is null
	    				ComSetFocus(document.form.sales_rep);					
	    				return false;
					}
				break;
				} 
        return true;
     }    
    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */         
     function initCombo(comboObj, comboNo) {
         switch(comboObj.options.id) {
             case "srep_cd":
                 var i=0;
                 with(comboObj) {
                     SetDropHeight(200);
                     SetMultiSelect(0);
                     SetMaxSelect(1);
                     //no support[check again]CLT IMEMode=0;
                     SetUseAutoComplete(1);
                     //no support[check again]CLT ValidChar(2, 1);
                     SetMaxLength(5);
                     
                     SetColWidth(0, "70");
     				 SetColWidth(1, "200");
                 }
                 break;     
         }
     }
     /**
      * 입력한 Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *		setCustSaleRep();
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.05.07 
      */   
     function setCustSaleRep(){
         var formObj=document.form;
         var sheetObj=sheetObjects[0];
         if (formObj.cust_office.value != "") {
             formObj.f_cmd.value=SEARCHLIST;
             var sParam=FormQueryString(formObj) + "&sls_ofc_cd=" + formObj.cust_office.value
             sXml=sheetObj.GetSearchData("ESM_SAM_0001GS.do", sParam);
             ComXml2ComboItem(sXml, srep_cd, "srep_cd", "srep_cd|srep_nm");
             //첫줄 빈칸 추가
/*             comboObjects[0].InsertItem(0, " | | "," ");*/
             comboObjects[0].SetSelectCode(formObj.strUsrSrepCd.value);
         }
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
