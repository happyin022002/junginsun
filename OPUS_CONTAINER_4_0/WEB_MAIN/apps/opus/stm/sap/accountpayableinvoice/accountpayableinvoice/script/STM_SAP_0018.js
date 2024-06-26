/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0018.js
*@FileTitle  : Evidence Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
	     var form=document.form;
	    try {
	        var srcName=ComGetEvent("name");
	        switch(srcName) {
	        	case "btn_new":
		            funcNew("FULL");
	    	        break;
	            case "btn_close":
	            	ComClosePopup(); 
	    	        break;
	    	    case "btn_ok":
	        		funcOK();
            		break;
	    	    // 세금계산서 -------------------------------------------------------------------------
	    	    case "btns_calTa1":  
	        		//세금계산서 달력
            		var cal=new ComCalendar();
					cal.select(form.ta_attr_ctnt3, 'yyyy-MM-dd');
					break;
            	case "btns_ta_srh1":
	        		//세금계산서 신고사업장
            		var param="?lu_cd=" + form.ta_attr_ctnt5.value;
            		ComOpenPopup("STM_SAP_0034.do" + param, 500, 400, "setPopupData", "0,0", true, false);
            		break;	
            	case "btns_ta_srh2":
	        		//세금계산서 발행거래처
            		var param="?lu_cd=" + form.ta_attr_ctnt2.value;
            		ComOpenPopup("STM_SAP_0012.do" + param, 500, 400, "setPopupData", "0,0", true, false);
            		break;	
            	// 계산서 -------------------------------------------------------------------------	
            	case "btns_calVa1":  
            		//계산서 달력
            		var cal=new ComCalendar();
					cal.select(form.va_attr_ctnt3, 'yyyy-MM-dd');
					break;
            	case "btns_va_srh1":
	        		//계산서 신고사업장
            		var param="?lu_cd=" + form.va_attr_ctnt5.value;
            		ComOpenPopup("STM_SAP_0034.do" + param, 500, 400, "setPopupData", "0,0", true, false);
            		break;	
            	case "btns_va_srh2":
	        		//계산서 발행거래처
            		var param="?lu_cd=" + form.va_attr_ctnt2.value;
            		ComOpenPopup("STM_SAP_0012.do" + param, 500, 400, "setPopupData", "0,0", true, false);
            		break;	
            	// 법인영수증 -------------------------------------------------------------------------	
            	case "btns_calCr1":  
            		//계산서 달력
            		var cal=new ComCalendar();
					cal.select(form.cr_attr_ctnt8, 'yyyy-MM-dd');
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
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
     function loadPage() {
    	 var formObject=document.form;
    	 for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
 		}
 		for(var k=0;k<comboObjects.length;k++){
 			initCombo(comboObjects[k],k+1);
 		}
 		initControl();
 		//Condition - EVIDENCE TYPE 
 		var eviComboItems=SapGetComboItems(sheetObjects[0], "EVIDENCE TYPE");
 		SapAddComboItem(comboObjects[0], eviComboItems, "2", " ", " "); 
 		//TAX - 신고구분 combo  
 		var strComboItems1=SapGetComboItems(sheetObjects[0], "TAX TYPE");
 		SapAddComboItem(comboObjects[1], strComboItems1, "2", " ", " ");
 		//TAX - Digital Tax Status
 		var strComboItems2=SapGetComboItems(sheetObjects[0], "DIGITAL TAX STATUS");
 		SapAddComboItem(comboObjects[2], strComboItems2, "2", " ", " ");
 		//VAT - 신고구분 combo
 		SapAddComboItem(comboObjects[3], strComboItems1, "2", " ", " ");
 		//VAT - Digital Tax Status
 		SapAddComboItem(comboObjects[4], strComboItems2, "2", " ", " ");
 		var req_evi=ComTrim(formObject.req_evi_type.value);
 		if (req_evi == "") { 
 			ComSetObjValue(evi_type, "INVOICES");   
 		} else {
 			ComSetObjValue(evi_type, req_evi);   
 		}
 		//doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
 	}
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array
 	 **/
 	function initControl() {
// 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
// 		axon_event.addListenerForm('keyup',    'obj_keyup',   	form);
 		//axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
 		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
 		axon_event.addListenerFormat('focus', 'obj_activate', form);
 		axon_event.addListenerForm ('blur', 'obj_blur', form);
 	}
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engnum":
				ComKeyOnlyAlphabet('uppernum');
				break;	
			case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
				ComKeyOnlyNumber(event.srcElement, "-.");
				break;
			case "han":
				break;
			case "saupja":
				ComKeyOnlyNumber(event.srcElement, "-");
				break;
			default:
				//common standard: recognization only number, english
				ComKeyOnlyAlphabet("num");
				break;     
		}
		if(event.KeyCode == 13){
			ComSetNextFocus(event.srcElement);
		}
	}    
    /** 
     * handling Keypress event of Object  <br>
     * checking validation of input value by dataformat of object  <br>
     */ 
	function obj_keyup(){
	}  
    /** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
        ComClearSeparator(event.srcElement);
       	/*switch(event.srcElement.name){ 	    	
       		case "ta_attr_ctnt3":
       			ComClearSeparator(event.srcElement);
       			break;
       		case "va_attr_ctnt3":
       			ComClearSeparator(event.srcElement);
       			break;
       		case "cr_attr_ctnt8":
       			ComClearSeparator(event.srcElement);
       			break;	
       	}*/
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    	 //ComChkObjValid(event.srcElement);
    }    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}
 	/**
 	 * registering IBCombo Object as list
 	 * @param combo_obj
 	 * @return
 	 */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	} 
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	    SetTitle("Code|Desc");
						SetColAlign(0, "0");
						SetColAlign(0, "1");
						SetColWidth(0, "0");
						SetColWidth(0, "120");
					    SetDropHeight(160);
			       }
	               break;
			   default :
	           break;
	     }
	}	 	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        //sheetObj.UseUtf8 = true;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){             
	              var HeadTitle="type|attr_1|attr_2|attr_3|attr_4|attr_5|attr_6|attr_7|attr_8|attr_9|attr_10|attr_11|attr_12|attr_13|attr_14|attr_15|attr_16|attr_17|attr_18|attr_19|attr_20";
	              HeadTitle=HeadTitle + "|glo_1|glo_2|glo_3|glo_4|glo_5|glo_6|glo_7|glo_8|glo_9|glo_10|glo_11|glo_12|glo_13|glo_14|glo_15|glo_16|glo_17|glo_18|glo_19|glo_20";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataGetRowMerge:0 } );
	              var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers=[ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols=[ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_cate_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt7",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt8",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt9",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt10",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt11",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt12",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt13",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt14",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt15",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt16",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt17",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt18",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt19",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt7",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt8",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt9",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt10",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt11",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt12",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt13",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt14",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt15",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt16",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt17",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt18",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt19",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"glo_attr_ctnt20",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              //SetSheetHeight(220);
	              resizeSheet();
                    }
                break;
        }
    }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction, a, PageNo) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case COMMAND01:
                //formObj.f_cmd.value = SEARCHLIST;  
                //sheetObj.DoSearch4Post("COM_ENS_0M1GS.do", selectVal, "iPage=" + PageNo, true);
           break;
        }
    }
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(type){
    	var formObj=document.form;
    	switch(type) {
        	case "ARAPOFFSET":                
        		break;
        	case "CREDITCARD":
                break;	
        	case "ETC":
                break;	
        	case "INVOICES":
                break;	
        	case "REFUND":
                break;	
        	case "TAX":
				if(formObj.ta_attr_ctnt5.value == ""){
					ComShowCodeMessage("COM12113", "신고사업장코드");
					ComSetFocus(document.all.item("ta_attr_ctnt5"));
					return false;
				}
				if(formObj.ta_attr_ctnt2.value == ""){
					ComShowCodeMessage("COM12113", "발행거래처");
					ComSetFocus(document.all.item("ta_attr_ctnt2"));
					return false;
				}
				if(formObj.ta_attr_ctnt3.value == ""){
					ComShowCodeMessage("COM12113", "세금계산서일자");
					ComSetFocus(document.all.item("ta_attr_ctnt3"));
					return false;
				}
				if(formObj.ta_attr_ctnt8.value == ""){
					ComShowCodeMessage("COM12113", "신고구분");
					ComSetFocus(document.all.item("ta_attr_ctnt8"));
					return false;
				}	
				if(formObj.ta_attr_ctnt4.value == ""){
					ComShowCodeMessage("COM12113", "총공급가액");
					ComSetFocus(document.all.item("ta_attr_ctnt4"));
					return false;
				}
				if(formObj.ta_attr_ctnt6.value == ""){
					ComShowCodeMessage("COM12113", "총세액");
					ComSetFocus(document.all.item("ta_attr_ctnt6"));
					return false;
				}
				if(formObj.ta_glo_attr_ctnt1.value == ""){
					ComShowCodeMessage("COM12113", "품명1");
					ComSetFocus(document.all.item("ta_glo_attr_ctnt1"));
					return false;
				}					
                break;	        		
        	case "VAT":
				if(formObj.va_attr_ctnt5.value == ""){
					ComShowCodeMessage("COM12113", "신고사업장코드");
					ComSetFocus(document.all.item("va_attr_ctnt5"));
					return false;
				}
				if(formObj.va_attr_ctnt2.value == ""){
					ComShowCodeMessage("COM12113", "발행거래처");
					ComSetFocus(document.all.item("va_attr_ctnt2"));
					return false;
				}
				if(formObj.va_attr_ctnt3.value == ""){
					ComShowCodeMessage("COM12113", "계산서일자");
					ComSetFocus(document.all.item("va_attr_ctnt3"));
					return false;
				}
				if(formObj.va_attr_ctnt8.value == ""){
					ComShowCodeMessage("COM12113", "신고구분");
					ComSetFocus(document.all.item("va_attr_ctnt8"));
					return false;
				}	
				if(formObj.va_attr_ctnt4.value == ""){
					ComShowCodeMessage("COM12113", "총공급가액");
					ComSetFocus(document.all.item("va_attr_ctnt4"));
					return false;
				}
				if(formObj.va_attr_ctnt6.value == ""){
					ComShowCodeMessage("COM12113", "총세액");
					ComSetFocus(document.all.item("va_attr_ctnt6"));
					return false;
				}
				if(formObj.va_glo_attr_ctnt1.value == ""){
					ComShowCodeMessage("COM12113", "품명1");
					ComSetFocus(document.all.item("va_glo_attr_ctnt1"));
					return false;
				}	        		
                break;	       		
        }
    	return true;
    }	
 /*   
    ARAPOFFSET	AR AP Offset
    CREDITCARD	법인영수증
    ETC	기타
    INVOICES	Invoices
    REFUND	Refund
    TAX	세금계산서
    VAT	계산서*/
    function evi_type_OnChange(comboObj,Index_Code, Text){
    	var type=ComGetObjValue(comboObj);
    	switch(type) {
        	case "ARAPOFFSET":
                tARAPOFFSET.style.display="";
                tCREDITCARD.style.display="none";
                tETC.style.display="none";
                tINVOICES.style.display="none";
                tREFUND.style.display="none";
                tTAX.style.display="none";
                tVAT.style.display="none";
                setStyle("S");
        		break;
        	case "CREDITCARD":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="";
                tETC.style.display="none";
                tINVOICES.style.display="none";
                tREFUND.style.display="none";
                tTAX.style.display="none";
                tVAT.style.display="none";
                setStyle("L");
        		break;	
        	case "ETC":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="none";
                tETC.style.display="";
                tINVOICES.style.display="none";
                tREFUND.style.display="none";
                tTAX.style.display="none";
                tVAT.style.display="none";
                setStyle("S");
        		break;	
        	case "INVOICES":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="none";
                tETC.style.display="none";
                tINVOICES.style.display="";
                tREFUND.style.display="none";
                tTAX.style.display="none";
                tVAT.style.display="none";
                setStyle("S");
        		break;	
        	case "REFUND":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="none";
                tETC.style.display="none";
                tINVOICES.style.display="none";
                tREFUND.style.display="";
                tTAX.style.display="none";
                tVAT.style.display="none";
                setStyle("S");
        		break;	
        	case "TAX":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="none";
                tETC.style.display="none";
                tINVOICES.style.display="none";
                tREFUND.style.display="none";
                tTAX.style.display="";
                tVAT.style.display="none";
                setStyle("L");
        		break;	        		
        	case "VAT":
                tARAPOFFSET.style.display="none";
                tCREDITCARD.style.display="none";
                tETC.style.display="none";
                tINVOICES.style.display="none";
                tREFUND.style.display="none";
                tTAX.style.display="none";
                tVAT.style.display="";
                setStyle("L");
        		break;	       		
        }
	}
    function setStyle(flag) {
    	var formObj=document.form;
    	var shortNmWid=formObj.s_wid.value;
    	var longNmWid=formObj.l_wid.value;
    	if ( flag == "S" ) {
            document.getElementById("titTd").style.width=shortNmWid;
            document.getElementById("nmTd").style.textAlign="left";            
    	} else {
            document.getElementById("titTd").style.width=longNmWid;
            document.getElementById("nmTd").style.textAlign="right";            
    	}
    }
    function funcNew(flag) {
    	var sheetObject=sheetObjects[0];
	    var formObject=document.form;
    	if (flag == "FULL") {
    		sheetObject.RemoveAll();
            formObject.reset();
    	} else if (flag == "OK") {
    		sheetObject.RemoveAll();
    		sheetObject.DataInsert(-1);
    	}
    }
    function funcOK() {
    	var sheetObj=sheetObjects[0];
	    var formObj=document.form;
    	funcNew("OK");
    	var type=ComGetObjValue(evi_type);
    	if ( !validateForm(type) ) {
    		return false;
    	}
    	sheetObj.SetGetCellValue(1, "attr_cate_nm",type,0);
    	switch(type) {
        	case "ARAPOFFSET":      
        		sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.ar_attr_ctnt2.value),0);
        		break;
        	case "CREDITCARD":
				sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.cr_attr_ctnt2.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt3",ComTrim(formObj.cr_attr_ctnt3.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt4",ComTrim(formObj.cr_attr_ctnt4.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt5",ComTrim(formObj.cr_attr_ctnt5.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt6",ComTrim(formObj.cr_attr_ctnt6.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt7",ComTrim(formObj.cr_attr_ctnt7.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt8",ComTrim(formObj.cr_attr_ctnt8.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt9",ComTrim(formObj.cr_attr_ctnt9.value),0);
                break;	
        	case "ETC":
        		sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.et_attr_ctnt2.value),0);
                break;	
        	case "INVOICES":
        		sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.in_attr_ctnt2.value),0);
                break;	
        	case "REFUND":
        		sheetObj.SetGetCellValue(1, "attr_ctnt4",ComTrim(formObj.re_attr_ctnt4.value),0);
                break;	
        	case "TAX":
				sheetObj.SetGetCellValue(1, "attr_ctnt5",ComTrim(formObj.ta_attr_ctnt5.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.ta_attr_ctnt2.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt3",ComTrim(formObj.ta_attr_ctnt3.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt8",ComTrim(ComGetObjValue(formObj.ta_attr_ctnt8)),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt4",ComTrim(formObj.ta_attr_ctnt4.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt6",ComTrim(formObj.ta_attr_ctnt6.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt11",ComTrim(ComGetObjValue(formObj.ta_attr_ctnt11)),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt1",ComTrim(formObj.ta_glo_attr_ctnt1.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt13",ComTrim(formObj.ta_glo_attr_ctnt13.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt14",ComTrim(formObj.ta_glo_attr_ctnt14.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt15",ComTrim(formObj.ta_glo_attr_ctnt15.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt16",ComTrim(formObj.ta_glo_attr_ctnt16.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt17",ComTrim(formObj.ta_glo_attr_ctnt17.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt18",ComTrim(ComGetObjValue(formObj.ta_glo_attr_ctnt18)),0);
                break;	        		
        	case "VAT":
				sheetObj.SetGetCellValue(1, "attr_ctnt5",ComTrim(formObj.va_attr_ctnt5.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt2",ComTrim(formObj.va_attr_ctnt2.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt3",ComTrim(formObj.va_attr_ctnt3.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt8",ComTrim(ComGetObjValue(formObj.va_attr_ctnt8)),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt4",ComTrim(formObj.va_attr_ctnt4.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt6",ComTrim(formObj.va_attr_ctnt6.value),0);
				sheetObj.SetGetCellValue(1, "attr_ctnt11",ComTrim(ComGetObjValue(formObj.va_attr_ctnt11)),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt1",ComTrim(formObj.va_glo_attr_ctnt1.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt13",ComTrim(formObj.va_glo_attr_ctnt13.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt14",ComTrim(formObj.va_glo_attr_ctnt14.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt15",ComTrim(formObj.va_glo_attr_ctnt15.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt16",ComTrim(formObj.va_glo_attr_ctnt16.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt17",ComTrim(formObj.va_glo_attr_ctnt17.value),0);
				sheetObj.SetGetCellValue(1, "glo_attr_ctnt18",ComTrim(ComGetObjValue(formObj.va_glo_attr_ctnt18)),0);
                break;	       		
        }
    	comPopupOK();
    	//settingParentSheet();
    }
    function setPopupData(aryData) {
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
   
