/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1117.js
*@FileTitle  : Agreement No. Selection(Popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1117 : ees_cgm_1117 business script for
     */
   	/* developer job	*/
    // common global variables
    var sheetObjects=new Array();
    var comboObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * @param
     * @return 
     * @author 
     * @version
     */
    function processButtonClick(){
    	/***** use additional sheet var in case of more than 2 tap each sheet *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;
        	switch(srcName) {
    			case "btn_Retrieve":		// retrieve Action
    				if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
    					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				}
    				break;
   				case "btn_New":		// New 
   					initControl();
   					break;
   				case "btn_OK":		// OK 
   					comPopupOK();
					break;
   				case "btn_Close":	// Close
   					ComClosePopup(); 
					break;
   				case "ComOpenPopupWithTarget1":	// Office Code getting popup
   					ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 480, "ofc_cd:agmt_iss_ofc_cd", "1,0,1,1,1,1,1,1", true);
   					break;
   				case "ComOpenPopupWithTarget2":	// Lessor Code, Name getting popup
   					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 480, "setProgramNo", "0,1,1,1,1,1", true, false);
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
     * @version
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
     * @version
     */
    function loadPage() {
    	var formObj=document.form;
    	// axon event regist
//    	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
//    	axon_event.addListenerForm('keydown', 'obj_keydown', formObj);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListener('change', 'obj_change', 'agmt_iss_ofc_cd', 'vndr_seq'); 
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
//	        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
	        doActionIBSheet(sheetObjects[0], formObj, IBRESET);
	    }
        initControl();
    }
    /**
     * init control of form <br>
     * @param  {object} sheetObj	
     * @return 
     * @author 
     * @version
     */
    function initControl(){
    	// Form object
    	var formObj=document.form;
        // sheet object reset
        sheetObjects[0].RemoveAll();
        // Combo object init value setting
        comboObjects[0].SetSelectText("");
        // Form Object reset
        with(formObj){
	        agmt_ofc_cty_cd.value="";
	        agmt_seq.value="";
	        agmt_iss_ofc_cd.value="";
	        agmt_ref_no.value="";
	        vndr_seq.value="";
	        vndr_lgl_eng_nm.value="";
	        // Hidden Form Object reset
	        intg_cd_id.value="";
	        ofc_cd.value="";
	        agmt_ofc_cty_cd.focus();
        }
    }
     /**
      * setting sheet initial values and header <br>
      * adding case as numbers of counting sheets <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {int} sheetNo
      * @return 
      * @author 
      * @version
      */
      function initSheet(sheetObj,sheetNo) {
          var cnt=0;
  		  var sheetID=sheetObj.id;
          switch(sheetID) {
              case "sheet1":
            	    with(sheetObj){
                  
                var HeadTitle1="||AGMT No.|Reference No.|Term|Lessor|Lessor Name|Effective Date|Effective Date||||||";
                var HeadTitle2="||AGMT No.|Reference No.|Term|Lessor|Lessor Name|From|To||||||";
                var headCount=15;

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                            { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"agmt_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_lstm_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_iss_ofc_cd" },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no" },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cty_cd" },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq" },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lst_ver_no" } ];
                 
                InitColumns(cols);

                SetEditable(1);
                sheetObj.SetColProperty(0,"eff_dt", {Format:"####-##-##"} );
                sheetObj.SetColProperty(0,"exp_dt", {Format:"####-##-##"} );
                sheetObj.SetColProperty(0,"cre_dt", {Format:"####-##-##"} );
                SetSheetHeight(202);
                SetRangeBackColor(1,7,1,8,"#555555");
                }


  				break;
          }
      }
     /**
      * handling process for Sheet <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {object} formObj	 Form Object
      * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
      * @return 
      * @author 
      * @version
      */
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg(false);
    	 switch(sAction) {
    	 	case IBSEARCH:      	// Retrive
    	 		formObj.f_cmd.value=SEARCH;
    	 		formObj.eq_knd_cd.value=EQ_KND_CD_CHASSIS;	
        	    sheetObj.SetWaitImageVisible(0);
		 	    ComOpenWait(true);
               	sheetObj.DoSearch("EES_CGM_1117GS.do",FormQueryString(formObj) );
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
     /**
      * handling process for input validation <br>
      * @param  {object} sheetObj		 Sheet Object
      * @param  {object} formObj	 Form Object
      * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
      * @return {boolean}			false => validation check error, true => validation check succes
      * @author 
      * @version
      */      
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
    		 		if(agmt_ofc_cty_cd.value == '' && 
    		 			agmt_seq.value == '' &&
    		 			agmt_iss_ofc_cd.value == '' &&
    		 			agmt_ref_no.value == '' &&
    		 			vndr_seq.value == '' &&
    		 			comboObjects[0].GetSelectText()== '')
    		 		{	
           				ComShowCodeMessage('CGM10004','Search condition');
           				agmt_ofc_cty_cd.focus();
           				return false;
           			}	
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
      * Object Keypress event handling  <br>
      * 
      * @param  
      * @return 
      * @author 
      * @version
      */ 
     function obj_keypress(){
     	obj=ComGetEvent();
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     		case "ym": case "ymd":
     			ComKeyOnlyNumber(obj);
     			break;
     		case "int":
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
     	        if(obj.name=="agmt_ofc_cty_cd"){
     	        	ComKeyOnlyAlphabet('uppernum');
     	        } else if(obj.name=="agmt_iss_ofc_cd") {
     	        	ComKeyOnlyAlphabet('uppernum');
     	       } else if(obj.name=="agmt_ref_no") {
    	        	ComKeyOnlyAlphabet('uppernum');
     	        } else {
     	        	ComKeyOnlyAlphabet('upper');
     	        }
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
    	 				//sheetObj.RemoveAll();
                		formObj.agmt_iss_ofc_cd.value="";
                		ComSetFocus(formObj.agmt_iss_ofc_cd);
                		return;
    	 			} else {	
    	 				ComKeyEnter();
    	 			}
    	 		} else {
    	 			ComKeyEnter();
    	 		}
				break;
			case "vndr_seq":
				var result=true;
				var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
    	 		if(vndrSeq != ''){
					var arrVndrSeq=vndrSeq.split(",");
					if(arrVndrSeq.length > 1){
						for(var i=0; i < arrVndrSeq.length; i++){
		    	 			// 
		    	 			if(arrVndrSeq[i] == ''){
		    	 				ComShowCodeMessage('CGM10009','Lessor');
		    	 				formObj.vndr_seq.value="";
		    	 				formObj.vndr_lgl_eng_nm.value="";
		    	 				//sheetObj.RemoveAll();
		    	 				ComSetFocus(formObj.vndr_seq);
		    	 				result=false;
		    	 				break;
		    	 			}
		    	 		}
					}
    	 		}
    	 		if(result) ComKeyEnter();
				break;
			default:
				ComKeyEnter();
				break;
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
     /** 
      * Combo Object reset  <br>
      * @param  {object} comboObj	Combo Object
      * @return 
      * @author 
      * @version
      */ 
    function initCombo(comboObj) {
     	switch(comboObj.id) {
 	        case "agmt_lstm_cd":
 	            var cnt=0;
 	            with(comboObj) {
 	            	Code="";
 	            	Text="";
 	            	SetDropHeight(100);
 	            	SetMultiSelect(0);
 	            	SetMaxSelect(1);
 //no support[check again]CLT 	            	UseCode=true;
 	            	SetEnable(1);
      //no support[check again]CLT 	  	        ValidChar(2,3);     
 //no support[check again]CLT 		            IMEMode=0;            
 		            SetMaxLength(20);
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
