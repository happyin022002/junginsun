/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0080.js
*@FileTitle  : Bank Branches 
*@author     : CLT
*@version    : 1.0
*@since      : 08/05/2014
=========================================================
*/
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
			if(ComGetBtnDisable(srcName)) return false;
	        switch(srcName) {
	    	    case "btn_cal":  
	        		var cal=new ComCalendar();
					cal.select(form.bank_end_dt, 'yyyy-MM-dd');
					break;
	    	    case "btn_retrieve":  
	    	    	doActionIBSheet(sheetObject, form, IBSEARCH);
					break;					
	    	    case "btn_save":  
	    	    	doActionIBSheet(sheetObject, form, IBSAVE);
					break;
	    	    case "btn_cnt":  				
            	    var v_cnt_cd=form.brnc_cnt_cd.value;
            	    var classId="COM_ENS_0M1";
        		    var param='?cnt_cd='+v_cnt_cd+'&classId='+classId;
        		    var v_display="1,0,1,1,1,0,0";
        		    var chkStr=v_display.substring(0,3)
        		    if(chkStr == "1,0") {
        		    	ComOpenPopup('/opuscntr/COM_ENS_0M1.do' + param, 700, 500, 'getCOM_ENS_0M1', v_display, true);
        		    } else {
        			    return;
        		    }	
        		    break;
	    	    case "btn_bank_brnc_nm" :
	    	    	form.bank_nm.value="";
	    	    	form.bank_altn_nm.value="";
	    	    	form.bank_no.value="";
	    	    	form.bank_brnc_nm.value="";
	    	    	form.bank_brnc_altn_nm.value="";
	    	    	form.brnc_no.value="";
	    	    	form.bank_nm.value="";
	    	    	form.bank_end_dt.value="";
	    			ComSetObjValue(bank_brnc_tp_nm, "");  
	    			form.bank_brnc_desc.value="";    					
	    			form.brnc_cnt_cd.value="";
	    			form.brnc_cnt_nm.value="";
	    			form.cntc_nm.value="";
	    			form.cntc_tit_nm.value="";
	    			form.cntc_pfx_cd.value="";
	    			form.cntc_phn_no.value="";
	    			form.cntc_eml.value="";
	    			form.bank_addr1.value="";
	    	    	ComOpenPopup('/opuscntr/STM_SAP_0081.do?bank_brnc_nm=' + encodeURIComponent(form.sch_bank_brnc_nm.value), 950, 590,"getSTM_SAP_0081", "0,0", true);
	    	    	break;
	    	    case "btn_new" :
	    	    	form.reset();
	    	    	form.f_cmd.value="";
	    	    	form.pagerows.value="";
	    	    	form.bank_brnc_seq.value="";
	    	    	
	    	    	ComSetObjValue(form.bank_brnc_tp_nm, "");  	    	    	
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
 		var strComboItems1=SapGetComboItems(sheetObjects[0], "BRANCH TYPE");
 		SapAddComboItem(comboObjects[0], strComboItems1, "1", " ", " ");
 	}
 	/**
 	 * loading HTML Control event <br>
 	 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 	 * @param {ibsheet} sheetObj    IBSheet Object
 	 * @param {int}     sheetNo     sequence number in sheetObjects array
 	 **/
 	function initControl() {
 		var formObject=document.form;
 		axon_event.addListenerFormat('focus' , 'obj_activate',   formObject);	
 	    axon_event.addListenerFormat('blur'  , 'obj_deactivate', formObject);
 	}
 	/** 
	 * handling work javascript OnFocus event  <br>
	 */    
	function obj_activate() {
	   	//delete mask separator
	    ComClearSeparator(event.srcElement);        
	}
	/**
	 * HTML Control onfocus validate event <br>
	 **/
	function obj_deactivate(){
		switch(ComGetEvent("name")){ 	    	
			case "bank_end_dt":
				ComAddSeparator(form.bank_end_dt, "ymd");
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
        	case IBSEARCH: //조회
        		if(formObj.bank_brnc_seq.value == "") {
        			ComShowCodeMessage("SAP00010", "Bank Branch Name");
        			return;
        		}
                formObj.f_cmd.value=SEARCH;    
                ComOpenWait(true);
                var sXml=sheetObj.GetSearchData("STM_SAP_0080GS.do", FormQueryString(formObj));
                ComOpenWait(false);
    			var arrXml=sXml.split("|$$|");
    			if (sXml.length > 0) {	
    				var list=SapXmlToListMap(arrXml[0]);
    				if (list.length > 0) {    	
    					formObj.bank_brnc_seq.value=list[0]["bank_brnc_seq"];
    					formObj.sch_bank_brnc_nm.value=list[0]["bank_brnc_nm"];
    					formObj.bank_nm.value=list[0]["bank_nm"];
    					formObj.bank_altn_nm.value=list[0]["bank_altn_nm"];
    					formObj.bank_no.value=list[0]["bank_no"];
    					formObj.bank_brnc_nm.value=list[0]["bank_brnc_nm"];
    					formObj.bank_brnc_altn_nm.value=list[0]["bank_brnc_altn_nm"];
    					formObj.brnc_no.value=list[0]["brnc_no"];
    					formObj.bank_nm.value=list[0]["bank_nm"];
    					formObj.bank_end_dt.value=list[0]["bank_end_dt"];
    					ComSetObjValue(bank_brnc_tp_nm, list[0]["bank_brnc_tp_nm"]);  
    					formObj.bank_brnc_desc.value=list[0]["bank_brnc_desc"];    					
    					formObj.brnc_cnt_cd.value=list[0]["brnc_cnt_cd"];
    					formObj.brnc_cnt_nm.value=list[0]["brnc_cnt_nm"];
    					formObj.cntc_nm.value=list[0]["cntc_nm"];
    					formObj.cntc_tit_nm.value=list[0]["cntc_tit_nm"];
    					formObj.cntc_pfx_cd.value=list[0]["cntc_pfx_cd"];
    					formObj.cntc_phn_no.value=list[0]["cntc_phn_no"];
    					formObj.cntc_eml.value=list[0]["cntc_eml"];
    					formObj.bank_addr1.value=list[0]["bank_addr1"];
    					ComAddSeparator(formObj.bank_end_dt, "ymd");
    				}
    				else {
    					ComShowCodeMessage("COM130401");
    				}
    			}
	            break;
           case IBSAVE:
        	   if (!validateForm(formObj)) return;
               formObj.f_cmd.value=MULTI;    
                             
               ComOpenWait(true);
               setTimeout( function () {
            	   var sXml=sheetObj.GetSaveData("STM_SAP_0080GS.do", FormQueryString(formObj));
            	   SapOpenWait(false,true);  
                   var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                   if(result != "F"){
         				ComShowCodeMessage("COM130102", "Data");    
         				var bankBrncSeq=ComGetEtcData(sXml, "BANK_BRNC_SEQ");	
         				formObj.bank_brnc_seq.value=bankBrncSeq;     				
         				doActionIBSheet(sheetObj, formObj, IBSEARCH);     
                   }else{
         				ComShowCodeMessage("COM130103", "data");
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
        if(ComTrimAll(ComGetObjValue(formObj.bank_brnc_tp_nm)).length == 0) {
        	ComShowCodeMessage("SAP00010", "Branch Type");
        	return false;
        }
    	return true;
    }	
    /**
     * obj_keypress.<br>
     * @author sangyoung cha
     */
//    function obj_keypress(){
//        obj=event.srcElement;
//        if(obj.dataformat == null) return;
//        window.defaultStatus=obj.dataformat;
//        var vKeyCode=event.keyCode;
//        switch(obj.dataformat) {
//            case "engup" :
//                if(obj.name=="brnc_cnt_cd") ComKeyOnlyAlphabet('upper');                
//            	if(obj.name=="bank_no") ComKeyOnlyNumber('int'); 
//            	if(obj.name=="brnc_no") ComKeyOnlyNumber('int');              
//                break;
//            case "ymd" :  
//    	    	if(obj.name=="bank_end_dt") ComKeyOnlyNumber('int', "-");
//    	    	break;   
//        }
//    }    
    /**
     * getCOM_ENS_0M1<br>
     * @author sangyoung cha
     * @param rowArray
     */
    function getCOM_ENS_0M1(rowArray) {    	
    	var colArray=rowArray[0];	
    	document.all.brnc_cnt_cd.value=colArray[3];
    	document.all.brnc_cnt_nm.value=colArray[4];    	
    }
    /**
     * getSTM_SAP_0081<br>
     * @author sangyoung cha
     * @param rowArray
     */    
    function getSTM_SAP_0081(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];	    
    	formObj.sch_bank_brnc_nm.value=colArray[4];
    	formObj.bank_brnc_seq.value=colArray[1];      	
    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    }
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
   