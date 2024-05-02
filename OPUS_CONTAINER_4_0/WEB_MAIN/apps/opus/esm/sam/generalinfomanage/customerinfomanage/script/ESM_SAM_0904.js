/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0904.jsp
*@FileTitle  : Sales Activity List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/

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
                case "btn_close":   
                	ComClosePopup(); 
                    break;
                case "btn_apply": //달력버튼
                	if (srep_cd.GetSelectCode()=="")
                	{
                		ComShowCodeMessage("COM130403", "sales rep code");
                		return;
                	}
                	var srepCdCode = srep_cd.GetSelectCode();
                	var opener=window.dialogArguments;
                	if (!opener) opener=parent; //이 코드 추가할것
                	
                	opener.callBackPopup(srepCdCode);
                	comPopupOK();
//                	doReturnValue(formObject.srep_cd.Code);
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
        //IBMultiCombo초기화
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }   
        doActionIBSheet(sheetObjects[0],formObject,IBCREATE);
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
	               
	               var HeadTitle1="";
	               var headCount=ComCountHeadTitle(HeadTitle1);
	               (headCount, 0, 0, true);

	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	               InitHeaders(headers, info);

	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
	                
	               InitColumns(cols);

	               SetEditable(1);
	               SetVisible(false);
	           }
	        break;
        }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
    	try {
    		sheetObj.ShowDebugMsg(false);
    		switch (sAction) {
    		case IBCREATE:
//    			 alert(frmObj.sls_ofc_cd.value);
//            	if (!validateForm(sheetObj,document.form,sAction)) {
//	        		return false;
//	        	}
            	setCustSaleRep();
            	break;
    	     }   // end switch
			}catch(e) {
          		if( e == "[object Error]") {
          			ComShowMessage(OBJECT_ERROR);
          		} else {
          			ComShowMessage(e.message);
          		}
          	}  		
    }
        /**
     	 * 입력받은 ROW의 정보를 부모창에 리턴한다.
     	 * @param srepCd
     	 * @return
     	 */
      function doReturnValue(srepCd){
    	  alert(srepCd);
    		opener.callBackEsmSam0904(srepCd);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
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
    		case IBCREATE: // 조회
    			if(frmObj.srep_cd.value.length != 5) {
    				ComShowCodeMessage('COM130403', "Sales Rep Code"); // Sales Rep Code is null
    				ComSetFocus(frmObj.srep_cd);					
    				return false;
    			}
    		break;
   	 	} 
   	 return true;
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
        if (formObj.sls_ofc_cd.value != "") {
            formObj.f_cmd.value=SEARCHLIST;
            var sParam=FormQueryString(formObj) + "&sls_ofc_cd=" + formObj.sls_ofc_cd.value
            sXml=sheetObj.GetSearchData("ESM_SAM_0001GS.do", sParam);
            ComXml2ComboItem(sXml, srep_cd, "srep_cd", "srep_cd|srep_nm");
            //첫줄 빈칸 추가
            comboObjects[0].InsertItem(0, " | | "," ");
        }
    }    
    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <b`r>
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
                     SetDropHeight(240);
                     SetMultiSelect(0);
                     SetMaxSelect(1);
                     //no support[check again]CLT IMEMode=0;
                     SetUseAutoComplete(1);
                     //no support[check again]CLT ValidChar(2, 1);
                     SetMaxLength(5);
                     
                     SetColWidth(0, "60");
     				 SetColWidth(1, "160");
                 }
                 break;     
         }
     }    
	/* 개발자 작업  끝 */
