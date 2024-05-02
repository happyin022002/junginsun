/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1021.js
*@FileTitle  : Lease Agreement List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
    // common global variables
    var sheetObjects=new Array();
    var comboObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    var IBSEARCH02=30;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function processButtonClick(){
    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
        	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
        	setEffFlag(formObject, srcName);	
        	switch(srcName) {
    			case "btn_Retrieve":		// retrieve Action
    				if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
    					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				}
    				break;
    			case "btn_New":
    				initControl();
    				break;
   				case "btn_VersionDetails":	// VersionDetail
   					if(formObject.agmt_no.value != ''){
   						var param="?agmt_no=" + formObject.agmt_no.value;
   						ComOpenPopup('/opuscntr/EES_CGM_1022.do' + param, 900, 650, "", "1,0", true);
   					}
   					break;
   				case "btn_DownExcel":		// Excel Download
   					if(sheetObject1.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
	        	    }
   					break;
   				case "btn_Print":			// Print (RD Open)
   					if( sheetObjects[0].RowCount()==0 ) {
 						errMsg='No data found.';
 						ComShowMessage(msgs["CGM10012"]);
 						return;
 					}
 					formObject.f_cmd.value=IBSEARCH02;
 					ComOpenPopupWithTarget('/opuscntr/EES_CGM_1023.do', 775, 600, "", "0,1,1,1,1,1,1", true);
   					break;
   				case "ComOpenPopupWithTarget1":	// Office Code getting popup
   					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 500, "ofc_cd:agmt_iss_ofc_cd", "1,0,1,1,1,1,1,1", true);
   					break;
   				case "ComOpenPopupWithTarget2":	// Lessor Code, Name getting popup
   					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 560, "setProgramNo", "0,1,1,1,1,1", true, false);
   					break;
    			case "btns_Calendar" :		// Agreement Date (From Date)
    				var cal=new ComCalendarFromTo();
    				cal.select(formObject.agmt_dt_fr,  formObject.agmt_dt_to,  'yyyy-MM-dd');
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
     * registering IBSheet Object as list <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function setSheetObject(sheetObj){
    	sheetObjects[sheetCnt++]=sheetObj;
    }
    /**
     * initializing sheet <br>
     * implementing onLoad event handler in body tag <br>
     * @param  
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function loadPage() {
    	// axon event regist
//    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
//    	axon_event.addListenerFormat('keydown', 'obj_keydown', form);
 //       axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'agmt_iss_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'vndr_seq');  
    	// IBSheet reset
    	for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //
            ComEndConfigSheet(sheetObjects[i]); 
    	}
    	// IBMultiCombo reset
    	comboObjects[comboCnt++]=agmt_lstm_cd;
    	for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	// Form Object reset ,  Control Value Reset handling
        initControl();   
    }
    /**
     * init control of form <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function initControl(){
    	// Form object
    	formObj=document.form;
    	sheetObj=sheetObjects[0];
    	formObj.agmt_iss_ofc_cd.value="";
    	formObj.agmt_dt_fr.value="";
    	formObj.agmt_dt_to.value="";
    	formObj.vndr_seq.value="";
    	formObj.vndr_lgl_eng_nm.value="";
    	formObj.eff_flag_all.checked=true;
    	formObj.eff_flag_yes.checked=false;
    	formObj.eff_flag_no.checked=false;
    	// Multi Combo reset
    	agmt_lstm_cd.SetSelectText("",false);
    	// Sheet Object reset
    	sheetObj.RemoveAll();
        //  focus
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);   
    }
    
    function obj_deactivate(){		
		switch(ComGetEvent("name")){ 	    	
	   		case "agmt_dt_fr":
	   			ComChkObjValid(ComGetEvent());		   			
	   			break;
	   		case "agmt_dt_to":
	   			ComChkObjValid(ComGetEvent());	
	   			break;
		}
	}
    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {int} sheetNo
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
         switch(sheetNo) {
         	case 1:      // sheet1 init
                with(sheetObj){
                with(sheetObj){
                      var HeadTitle="|Seq.|AGMT No.|Reference No.|Office|Date|Term|Pool Code|AGMT Effective|Lessor|Lessor Name|Created By|Created Date|Updated By|Updated Date";
                      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:8, DataRowMerge:1 } );
                      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                      var headers = [ { Text:HeadTitle, Align:"Center"} ];
                      InitHeaders(headers, info);
                      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_iss_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chss_pool_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"effective_date",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                      InitColumns(cols);
                      SetEditable(1);
//                      SetSheetHeight(420);
                      resizeSheet();
                     }
         		break;
         } // End Switch
    }
}
	function resizeSheet() {
		ComResizeSheet( sheetObjects[0] );
	}
    /**
     * handling process for Sheet <br>
     * @param  {object} sheetObj		 Sheet Object
     * @param  {object} formObj	 Form Object
     * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return 
     * @author 
     * @version 2009.05.20
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
    	 switch(sAction) {
    	 	case IBSEARCH:      	// Retrive
    	 		formObj.f_cmd.value=SEARCH;
    	 		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;	// EQ TYPE -> CHASSIS  setting
        	    sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
                	sheetObj.DoSearch("EES_CGM_1021GS.do",FormQueryString(formObj) );
                ComOpenWait(false);
               	break;
            case IBSEARCH_ASYNC01:	// Term Code Combo retrieve
            	formObj.f_cmd.value=SEARCH;
            	formObj.intg_cd_id.value=COM_CD_TYPE_CD01948;		// code type setting ( AGREEMENT LEASE TERM CODE )
         		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
        		var sStr=ComGetEtcData(sXml,"comboList");    			
        		var arrStr=sStr.split("@");
        		// combo control, result string, Text Index, Code Index
       			MakeComboObject(agmt_lstm_cd, arrStr, 0, 0);
            	break;
            case IBSEARCH_ASYNC02:	// Office Code  Validation check 
            	formObj.f_cmd.value=COMMAND01;
            	formObj.ofc_cd.value=formObj.agmt_iss_ofc_cd.value;
             	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj), '', true);
            	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
            	if(sCheckResult == COM_VALIDATION_FALSE){            		
            		return false;
            	} else {
            		return true;
            	}
            	break;
            case IBSEARCH_ASYNC03:	// Vendor Code,Name retrieve
            	formObj.f_cmd.value=SEARCH07;
             	var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
            	var text=ComGetEtcData(sXml,"text");
            	formObj.vndr_lgl_eng_nm.value=text;
            	break;
            case RDPRINT:      		// Print
            	break;
            case IBDOWNEXCEL:     	// down excel
            	if(sheetObj.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		sheetObj.Down2Excel({ HiddenColumn:1,TreeLevel:false});
            	}
                break;
            case IBRESET:
    	 		var idx=0
    	 		var sXml2=document.form2.sXml.value;
    	 		var arrXml=sXml2.split("|$$|");
    	 		//agmt_lstm_cd
    	 		if ( arrXml[idx] == null ) {return;}
    	 		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
    	 	    var arrStr1=new Array();
    	 		for ( var i=0; i < vArrayListData.length; i++) {
    	 		    vListData=vArrayListData[i];
    	 		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc1"];
    	 		}
    	 		// combo control, result string, Text Index, Code Index
    		  	MakeComboObject(agmt_lstm_cd, arrStr1, 0, 0);     
    	 		idx++;       
    	 		break;
    	 }
    }
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
//    		 		if(agmt_iss_ofc_cd.value == ''){
//           				ComShowCodeMessage('CGM10004','Office');
//           				ComSetFocus(agmt_iss_ofc_cd);
//           				return false;
//           			}	
           			break;
    		 }      
    	 }
         return true;
    }
    function setProgramNo(aryPopupData, row, col, sheetIdx){
    	 var formObj=document.form;
    	 var vndrSeq="";
    	 var vndrNm="";
    	 var i=0;
    	 for(i=0; i < aryPopupData.length; i++){
    		 vndrSeq=vndrSeq + aryPopupData[i][2];
    		 if(aryPopupData.length == 1){
    			 vndrNm=vndrNm + aryPopupData[i][4];
    		 }
    		 if(i < aryPopupData.length - 1){
    			 vndrSeq=vndrSeq + ",";
    		 }
    	 }
    	 formObj.vndr_seq.value=vndrSeq;
    	 formObj.vndr_lgl_eng_nm.value=vndrNm;
    }
    /** 
     * Effective Option button handling  <br>
     * @param  {object} formObj	 Form Object
     * @param  {String} srcName	 document obj name
     * @return 
     * @author 
     * @version 
     */ 
    function setEffFlag(FormObj, srcName){
    	 switch(srcName) {
	     	case "eff_flag_yes" :      
	     		FormObj.eff_flag_yes.checked=true;
    			FormObj.eff_flag_no.checked=false;
    			FormObj.eff_flag_all.checked=false;
    			FormObj.eff_flag.value="Y";
	            break;
	     	case "eff_flag_no" :        
	     		FormObj.eff_flag_yes.checked=false;
	     		FormObj.eff_flag_no.checked=true;
	     		FormObj.eff_flag_all.checked=false;
	     		FormObj.eff_flag.value="N";
	     		break;
	 		case "eff_flag_all" :      
	 			FormObj.eff_flag_yes.checked=false;
	    		FormObj.eff_flag_no.checked=false;
	    		FormObj.eff_flag_all.checked=true;
	    		FormObj.eff_flag.value="";
	    		break;
	    }	
    }
    function obj_keypress(){
    	 obj=ComGetEvent();
    	 if(obj.dataformat == null) return;
    	 window.defaultStatus=obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "ym": case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	 		break;
    	 	case "num":
    	 		if(obj.name=="vndr_seq"){
    	    		ComKeyOnlyNumber(obj,",");
    	    	} else {
    	    		ComKeyOnlyNumber(obj);
    	    	}
    	        break;
    	    case "eng":
    	        ComKeyOnlyAlphabet(); 
    	        break;
    	    case "engup":
    	        if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engdn":
    	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	        else ComKeyOnlyAlphabet('lower');
    	        break;
    	 }
    }
    function obj_keydown(){
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
    	var keyValue=null;
    	if(event == undefined || event == null) {
    		keyValue=13;
    	} else {
    		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		}
		if(keyValue != 13) return;
		obj=ComGetEvent();
		switch(ComGetEvent("name")){
			case "agmt_iss_ofc_cd":
				if(formObj.agmt_iss_ofc_cd.value != ''){
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
                		formObj.agmt_iss_ofc_cd.value="";
                		ComSetFocus(formObj.agmt_iss_ofc_cd);
                		return;
    	 			} else {	
    	 				ComKeyEnter();
    	 				return;
    	 			}
    	 		}
				break;
			default:
				ComKeyEnter();
				return;
		}
    }
    /** 
     * Object activate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_activate(){
    	ComClearSeparator(ComGetEvent());
    }
    /** 
     * Object deactivate event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */
    function obj_deactivate(){
    	 var formObj=document.form;
    	 obj=ComGetEvent();      	
    	 with(formObj){
    		 if(obj.name=="agmt_dt_fr" || obj.name=="agmt_dt_to"){
    			 var creDtFr=ComReplaceStr(agmt_dt_fr.value,"-","");
    			 var creDtTo=ComReplaceStr(agmt_dt_to.value,"-","");
    			 switch(ComGetEvent("name")) {
	    	    	case "agmt_dt_fr":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				agmt_dt_fr.value='';
//	    	    				agmt_dt_fr.focus();
	    	    			}
	    	    		}
	    	            break;
	    	    	case "agmt_dt_to":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				agmt_dt_to.value='';
//	    	    				agmt_dt_to.focus();
	    	    			}
	    	    		}
	    	           	break;	
	        	}
    			ComChkObjValid(ComGetEvent());
    		 }
        }
    }
    /** 
     * Object change event handling  <br>
     * @param  
     * @return 
     * @author 
     * @version 
     */  
    function obj_change(){ 	 
    	 var formObj=document.form;
    	 var sheetObj=sheetObjects[0];
    	 obj=ComGetEvent();
    	 switch(ComGetEvent("name")){
    	 	case "agmt_iss_ofc_cd":
    	 		if(formObj.agmt_iss_ofc_cd.value != ''){
    	 			if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02)){
    	 				ComShowCodeMessage('CGM10009','Office');
                		formObj.agmt_iss_ofc_cd.value="";
                		ComSetFocus(formObj.agmt_iss_ofc_cd);
    	 			}
    	 		}
    	 		break;
    	 	case "vndr_seq":
    	 		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
    	 		if(vndrSeq != ''){
	    	 		var arrVndrSeq=vndrSeq.split(",");
	    	 		if(arrVndrSeq.length == 1){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    	 		} else {	
		    	 		for(var i=0; i < arrVndrSeq.length; i++){
		    	 			// 
		    	 			if(arrVndrSeq[i] == ''){
		    	 				ComShowCodeMessage('CGM10009','Lessor');
		    	 				formObj.vndr_seq.value="";
		    	 				formObj.vndr_lgl_eng_nm.value="";
		    	 				ComSetFocus(formObj.vndr_seq);
		    	 				break;
		    	 			} else {
		    	 				formObj.vndr_lgl_eng_nm.value="";
		    	 			}
		    	 		}
	    	 		}
    	 		} else {
    	 			formObj.vndr_lgl_eng_nm.value="";
    	 		}
    	 		break;
    	 }
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
    	if(sheetObj.RowCount()> 0){
    		document.form.agmt_no.value=sheetObj.GetCellValue(1,"agmt_no");
    	}
    }
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
    	document.form.agmt_no.value=sheetObj.GetCellValue(Row,"agmt_no");
    }
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
    	var colSaveName=sheetObj.ColSaveName(Col);
   // 	if(colSaveName == 'agmt_no') {
    		var param="?agmt_no=" + sheetObj.GetCellValue(Row,"agmt_no");
    		ComOpenPopup('/opuscntr/EES_CGM_1022.do' + param, 900, 600, "", "1,0", true, false);
   // 	}
    }
    /** 
     * Combo Object reset  <br>
     * @param  {object} comboObj	Combo Object
     * @return 
     * @author 
     * @version 
     */ 
    function initCombo(comboObj) {
     	switch(comboObj.options.id) {
  	       case "agmt_lstm_cd":
  	           var cnt=0;
  	           with(comboObj) {
  	            	Code="";
  	            	Text="";
  	            	SetDropHeight(100);
  	            	SetMultiSelect(0);
  	            	SetMaxSelect(1);
  	            	SetEnable(1);
  	            	comboObj.SetUseAutoComplete(1);
  	            }
  	            break;
  	    }
  	} 
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
    	cmbObj.InsertItem(0,"","");
    	for (var i=0; i < arrStr.length;i++ ) {
    		var arrCode=arrStr[i].split("|");
    		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
    	}
    	cmbObj.SetSelectIndex("" ,false);
    }
	/* developer job end */

