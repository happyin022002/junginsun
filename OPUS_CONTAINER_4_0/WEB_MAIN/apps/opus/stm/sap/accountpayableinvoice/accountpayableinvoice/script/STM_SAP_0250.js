/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0250.js
*@FileTitle  : Open Interface Invoices
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @extends 
 * @class Bank Branches : business script for STM_SAP_0080
 */
/* 공통전역변수 */
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
					ComResetAll(); 
	                break;
		        case "btns_calInvFr":
					var cal=new ComCalendar();
					cal.select(form.value3, 'yyyy-MM-dd');
					break;					
				case "btns_calInvTo":
					var cal=new ComCalendar();
					cal.select(form.value4, 'yyyy-MM-dd');
					break;
	        	case "btn_save":  	    	    	
	    	    	doActionIBSheet(sheetObject, form, IBSAVE);
					break;	
	    	    case "btn_payIF":  	    	    	
	    	    	doActionIBSheet(sheetObject, form, COMMAND01);
					break;				
	    	    case "btn_if_sakura":  	    	    	
	    	    	doActionIBSheet(sheetObject, form, COMMAND02);
					break;
	    	    case "btn_all_if_sakura":  	    	    	
	    	    	doActionIBSheet(sheetObject, form, COMMAND03);
					break;
	    	    case "btn_asaIF":  	    	    	
	    	    	doActionIBSheet(sheetObject, form, COMMAND04);
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
 	}
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array
 	 **/
 	function initControl() {
 		//axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- when key down
 		axon_event.addListenerForm('blur', 'obj_deactivate', form);   //beforedeactivate   deactivate
		axon_event.addListenerFormat('focus', 'obj_activate', form);
 	}
 	/** 
     * handling work javascript OnFocus event  <br>
     */    
	function obj_activate() {
       	//delete mask separator
        ComClearSeparator(ComGetEvent());  
        
    }
	/**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		//ComChkObjValid(event.srcElement);	
		var obj=ComGetEvent();
		switch(ComGetEvent("name")){ 	    	
	   		case "value3":
	   			ComAddSeparator(form.value3, "ymd");
	   			ComChkObjValid(ComGetEvent());
	   			break;
	   		case "value4":
	   			ComAddSeparator(form.value4, "ymd");
	   			ComChkObjValid(ComGetEvent());		
	   			break;
		}
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
	    switch(comboNo) {
			   case 1:
		           with (comboObj) {
				   	   //SetTitle("Code|Desc");
				       //SetColAlign("left|left");
				       //SetColWidth("70|100");
					   SetDropHeight(160);
			       }
	               break;
			   default :
	           break;
	     }
	}	 	
	/**
	 * initSheet.<br>
	 * @author sangyoung cha
	 * @param sheetObj
	 * @param sheetNo
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
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"attr_cate_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
    /**
     * doActionIBSheet.<br>
     * @author sangyoung cha
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {        
        switch(sAction) {
        	case IBSAVE: //조회
        		if(formObj.value1.value == "") {
        			ComShowCodeMessage("SAP00010", "CSR No");
        			return;
        		}
                formObj.f_cmd.value=MULTI;                                    
				ComOpenWait(true);
				setTimeout( function () {   
					var sXml=sheetObj.GetSaveData("STM_SAP_0250GS.do", FormQueryString(formObj));
					SapOpenWait(false,true); 
			        if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			        	sheetObj.LoadSearchData(sXml,{Sync:1} );
			        }
					else {					
						ComShowMessage(SapShowXmlMessage(sXml));					
					}
				} , 100);

 				
	            break;
	            
        	case COMMAND01: //SAKURA PAYMENT I/F
        		
        		
                formObj.f_cmd.value = COMMAND01;                                    
				
				ComOpenWait(true);
				setTimeout( function () {    
					var sXml = sheetObj.GetSaveData("STM_SAP_0250GS.do", FormQueryString(formObj));				
					SapOpenWait(false,true); 
					
			        if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			        	sheetObj.LoadSearchData(sXml,{Sync:1} );	
			        }
					else {					
						ComShowMessage(SapShowXmlMessage(sXml));					
					}
				} , 100);

	            break;    
	        
        	case COMMAND02: //SAKURA INTERFACE CSR 단위
        		if(formObj.value2.value == "") {
        			ComShowCodeMessage("SAP00010", "CSR No");
        			return;
        		}
                formObj.f_cmd.value=COMMAND02;                                    
				ComOpenWait(true);
				setTimeout( function () {     
					var sXml=sheetObj.GetSaveData("STM_SAP_0250GS.do", FormQueryString(formObj));
					SapOpenWait(false,true); 
			        if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			        	sheetObj.LoadSearchData(sXml,{Sync:1} );
			        }
					else {					
						ComShowMessage(SapShowXmlMessage(sXml));					
					}
				} , 100);

 				
	            break;
	            
        	case COMMAND03: //SAKURA INTERFACE ALL - INVOICE DATE 기준
        		if(formObj.value3.value == ""){
					ComShowCodeMessage("COM12113", "From Inv Date");
					ComSetFocus(document.all.item("value3"));
					return false;
				}
        		if(formObj.value4.value == ""){
					ComShowCodeMessage("COM12113", "To Inv Date");
					ComSetFocus(document.all.item("value4"));
					return false;
				}
        		
                formObj.f_cmd.value=COMMAND03;                                    
				ComOpenWait(true);
				setTimeout( function () {    
					var sXml=sheetObj.GetSaveData("STM_SAP_0250GS.do", FormQueryString(formObj));
					SapOpenWait(false,true); 
			        if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			        	sheetObj.LoadSearchData(sXml,{Sync:1} );
			        }
					else {					
						ComShowMessage(SapShowXmlMessage(sXml));					
					}
				} , 100);

 				
	            break;
	            
        	case COMMAND04: //ASA INVOICE INTERFACE TO AR
        		
        		if(formObj.value5.value == "") {
        			ComShowCodeMessage("SAP00010", "CSR No");
        			return;
        		}
                formObj.f_cmd.value = COMMAND04;                                    
				
				ComOpenWait(true);
				setTimeout( function () {    
					var sXml = sheetObj.GetSaveData("STM_SAP_0250GS.do", FormQueryString(formObj));				
					SapOpenWait(false,true); 
					
			        if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") {
			        	sheetObj.LoadSearchData(sXml,{Sync:1} );	
			        }
					else {					
						ComShowMessage(SapShowXmlMessage(sXml));					
					}
				} , 100);
				
	            break;
        }
    }
    /**
     * validateForm.<br>
     * @author sangyoung cha
     * @param type
     */
    function validateForm(formObj){    
        if (!ComChkValid(formObj)){
            return false;        
        }
    	return true;
    }	
    /**
     * obj_keypress.<br>
     * @author sangyoung cha
     */
    function obj_keypress(){        
    }    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
   
