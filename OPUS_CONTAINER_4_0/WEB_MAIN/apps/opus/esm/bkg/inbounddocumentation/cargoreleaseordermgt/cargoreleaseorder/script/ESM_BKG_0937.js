/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0937.js
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
    /* Global Variables */
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet1=0;
	var sheet2=1;
	var sheet3=2;
	var IBSENDFAX="IBSENDFAX";
	var IBSENDEMAIL="IBSENDEMAIL";
	var IBRELEASE="IBRELEASE";
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
    function processButtonClick(){
    	/***** Assignment sheet in case of over 2 by tab****/
        var sheetObject1=sheetObjects[sheet2];
        var sheetObject2=sheetObjects[sheet3];
        /*******************************************************/
     		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":					
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				break;
				case "btn_Save":
					if (beforetab == 0) {
						doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					} else {
						doActionIBSheet(sheetObjects[2],document.form,IBINSERT);
					}
				break;
				case "btn_Mail_Send":					
					doActionIBSheet(sheetObjects[1],document.form,IBSENDEMAIL);                    
				break;
				case "btn_Fax_Send":					
					doActionIBSheet(sheetObjects[1],document.form,IBSENDFAX);                    
				break;
				case "btn_Close":
					var isChange=fnIsChange();
					if (isChange == true) {
						if(!ComShowCodeConfirm('BKG40068')){
			                return false;
			            }
					}
					ComClosePopup(); 
					break;
            } // end switch
    }
    /**
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing sheet
     * To implement onLoad event of body tag
     * Add functionality to after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
        if (document.form.do_no.value != '') {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        ComSetFocus(document.form.do_no);
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * setting Tab
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
                     InsertItem( "D/O Receiver" , "");
                     InsertItem( "Trucker" , "");
                 }
              break;
          }
          tabObj.SetSelectedIndex(0);
     }
     /**
      * Tab click event
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
         objs[nItem].style.display="Inline";
         objs[beforetab].style.display="none";
         //--------------- notice --------------------------//
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab=nItem;
         if (beforetab == 0) {
        	 document.getElementById("div_multi_cntr").style.visibility="hidden";
        	 document.getElementById("multi_cntr_no").style.visibility="hidden";
        	 if (sheetObjects[1].RowCount()> 0) {
	        	 ComBtnEnable("btn_Mail_Send");
	        	 ComBtnEnable("btn_Fax_Send");
        	 }
         } else {
        	 document.getElementById("div_multi_cntr").style.visibility="visible";
        	 document.getElementById("multi_cntr_no").style.visibility="visible";
        	 ComBtnDisable("btn_Mail_Send");
        	 ComBtnDisable("btn_Fax_Send");
         }
     }     
	/**
	 * setting control initial value and event of screen
	 */
    function initControl() {
    	var formObject=document.form;
    	axon_event.addListenerForm  ('blur',     'obj_deactivate',  form); //-  OnBeforeDeactivate event
//    	axon_event.addListenerFormat('keypress', 'obj_keypress',    form); //-  inputting keyboard
//        axon_event.addListener  ('change'  , 'office_change', 'office');
        ComBtnDisable("btn_Save");
    	ComBtnDisable("btn_Mail_Send");
    	ComBtnDisable("btn_Fax_Send");
    }
    /**
     * Initializing sheet. Defining header
     * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
     * Composition a initial module in case of multi sheet
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetID=sheetObj.id;
        switch(sheetID) {
	        case "sheet1":      //sheet1 init
		        with (sheetObj) {
	            var HeadTitle1="ibflag|cntr_no";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            var prefix="sheet1_";
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                      {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetVisible(false);
		        }
	        	break;
        case "sheet2":      //sheet2 init
                with (sheetObj) {
            var HeadTitle1="ibflag|rcvr_cnee_nm|rcvr_eml|rcvr_fax_no|rcvr_phn_no|do_no|do_no_split|bkg_no";
            var headCount=ComCountHeadTitle(HeadTitle1);
            var prefix="sheet2_";
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                   {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rcvr_cnee_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rcvr_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcvr_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rcvr_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_no_split",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            InitColumns(cols);
            SetEditable(1);
            SetVisible(false);
                }
                break;
            case "sheet3":      //sheet3 init
            with (sheetObj) {
                var HeadTitle1="ibflag|trkr_nm|trkr_phn_no|trkr_mvmt_ref_no|trkr_mty_rtn_yd_cd|cntr_no|bkg_no|rlse_seq";
                var headCount=ComCountHeadTitle(HeadTitle1);
                var prefix="sheet3_";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                          {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trkr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"trkr_phn_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trkr_mvmt_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trkr_mty_rtn_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rlse_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                InitColumns(cols);
                SetEditable(1);
                SetVisible(false);
            }
            break;
        }
    }      
    /* Processing Sheet */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
	            ComOpenWait(true);
	            sheetObjects[0].SetWaitImageVisible(0);
	            formObj.f_cmd.value=SEARCH;
	            
	            setTimeout( function () { //@ setTimeout ###########################################################
		            var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_"); //prefix string array
		            var sXml=sheetObj.GetSearchData("ESM_BKG_0937GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		            var arrXml=sXml.split("|$$|");
		            for(var idx=0; idx < arrXml.length; idx++){
		                if(idx > 0) {
		                    sheetObjects[idx].SetWaitImageVisible(0);
		                }
		                sheetObjects[idx].LoadSearchData(arrXml[idx],{Sync:1} );
		            }
		            sheetObjects[0].SetWaitImageVisible(1);
		            
		            ComOpenWait(false);
		
		        } , 100);//@ setTimeout end ###########################################################

				break;
			case IBINSERT:      // insert
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				var sParam1="";
				var arrPre="";
				if (beforetab == 0) {
					formObj.f_cmd.value=MULTI;
					copyFormTosheet2();
	                sParam1=sheetObjects[1].GetSaveString();
	                //checking grid changing
	                if(! sheetObjects[1].IsDataModified()){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }
	                arrPre="sheet2_";
				} else {
					formObj.f_cmd.value=MULTI03;
					copyFormTosheet3();
	                sParam1=sheetObjects[2].GetSaveString();
	                //checking grid changing
	                if(! sheetObjects[2].IsDataModified()){
	                    ComShowCodeMessage('BKG00743');
	                    return false;
	                }
	                arrPre="sheet3_";
				}
                if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                    return false;
                }
                var aryPrefix=new Array(arrPre);    //prefix string array
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml=sheetObj.GetSaveData("ESM_BKG_0937GS.do", sparam);
                sheetObj.LoadSaveData(sXml);
               	sXml=ComDeleteMsg(sXml);   /// showing once message
                break;
			case IBSENDEMAIL:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=MULTI01;
            	copyFormTosheet2();
                var sParam1=sheetObjects[1].GetSaveString();
                if( !ComShowCodeConfirm('BKG40098', document.form.rcvr_cnee_nm.value) ){
                    return false;
                }
                ComOpenWait(true);
                setTimeout( function () { //@ setTimeout ###########################################################
		                var aryPrefix=new Array("sheet2_");    //prefix string array
		                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
		                var sXml=sheetObj.GetSaveData("ESM_BKG_0937GS.do", sparam);
		                sheetObjects[1].LoadSaveData(sXml);
		                sXml=ComDeleteMsg(sXml);   /// showing once message
                } , 100);//@ setTimeout end ###########################################################
                break;
			case IBSENDFAX:
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=MULTI02;
            	copyFormTosheet2();
                var sParam1=sheetObjects[1].GetSaveString();
                if( !ComShowCodeConfirm('BKG40099', document.form.rcvr_cnee_nm.value) ){
                    return false;
                }
                ComOpenWait(true);
                setTimeout( function () { //@ setTimeout ###########################################################
		                var aryPrefix=new Array("sheet2_");    //prefix string array
		                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
		                var sXml=sheetObj.GetSaveData("ESM_BKG_0937GS.do", sparam);
		                sheetObjects[1].LoadSaveData(sXml);
		                sXml=ComDeleteMsg(sXml);   /// showing once message
		        } , 100);//@ setTimeout end ###########################################################
                break;
        }
    }     
    /**
     * Checking validation of input value
     * @param sheetObj Sheet
     * @param formObj form object
     * @param sAction action code
     */
    function validateForm(sheetObj,formObj,sAction){
   		switch(sAction) {       	 
		case IBSEARCH:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }
    		break;
		case IBINSERT:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }
            // processing error in case of DO No < 10 
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }
            if (beforetab == 1) {            
	            // checking in case of exist Multi Container No
	            if (document.form.multi_cntr_no.value == '') {
	            	alert("Multi Container No가 존재하지 않습니다.");
	                formObj.multi_cntr_no.focus();
	                return false;
	            }
            } else {
                if(ComIsEmpty(formObj.rcvr_eml.value) == false){
                    if(ComIsEmailAddr(formObj.rcvr_eml.value) != true){
                    	ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                        formObj.rcvr_eml.focus();
                        return false;
                    }
                }
            }
            break;
		case IBSENDEMAIL:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }
            // processing error in case of DO No < 10 
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }
            if(ComIsEmpty(formObj.rcvr_eml.value)){
                ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                formObj.rcvr_eml.focus();
                return false;
            }
            if(ComIsEmailAddr(formObj.rcvr_eml.value) != true){
            	ComShowCodeMessage('BKG40021', formObj.rcvr_eml.value);
                formObj.rcvr_eml.focus();
                return false;
            }
            break;
		case IBSENDFAX:
            if(ComIsEmpty(formObj.do_no.value)){
                ComShowCodeMessage('BKG00554');
                formObj.do_no.focus();
                return false;
            }
            // processing error in case of DO No < 10 
            if (ComChkLen(document.form.do_no.value, 10) == 1) {
            	ComShowCodeMessage('BKG01058', document.form.do_no.value);
                formObj.do_no.focus();
                return false;
            }
            if(ComIsEmpty(formObj.rcvr_fax_no.value)){
                ComShowCodeMessage('BKG40020', formObj.rcvr_fax_no.value);
                formObj.rcvr_fax_no.focus();
                return false;
            }
			break;
   		}
    	return true;
   	}
    /**
     * Blur event
     */
    function obj_deactivate(){
    	//inputting Validation
    	ComChkObjValid(ComGetEvent());
    }
    /**
     * onkeypress event
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//            case "float":
//            	//numbers+"."
//                ComKeyOnlyNumber(event.srcElement, ".");
//                break;
//            case "eng":
//                ComKeyOnlyAlphabet('uppernum');
//                break;
//            case "engdn":
//                //only lower case
//                ComKeyOnlyAlphabet('lower');
//                break;
//            case "engup":
//                //only upper case
//                ComKeyOnlyAlphabet('upper');
//                break;
//            case "num":
//            	ComKeyOnlyAlphabet('num', "45");
//            default:	
//                //only numbers(integer,date,time)
//                ComKeyOnlyNumber(event.srcElement);
//            }
//    }
    /**
    * initializing screen
    */
    function initsheet2() {
		var formObject=document.form;
		formObject.rcvr_cnee_nm.value='';
		formObject.rcvr_eml.value='';
		formObject.rcvr_fax_no.value='';
		formObject.rcvr_phn_no.value='';
    }
    /**
    * initializing screen
    */
    function initsheet3() {
		var formObject=document.form;
		formObject.trkr_nm.value='';
		formObject.trkr_phn_no.value='';
		formObject.trkr_mvmt_ref_no.value='';
		formObject.trkr_mty_rtn_yd_cd.value='';
    }
   /**
    * setting value in case of after sheet1 retrieving
    */
   function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	   ComOpenWait(false);
       var prefix="sheet1_";
       var formObject=document.form;
       if (ErrMsg == "") {
           if(sheetObj.RowCount()> 0){
        	   addSel(sheetObj);
           } else {
        	   ClearSel(sheetObj);
           }
       }
    }
   function addSel(sheetObj) {
       var sel=document.form.multi_cntr_no;
       var prefix="sheet1_";
       for (i=sel.length-1; i>=0; i--){
           sel.options[i]=null
       }
       var unit="";
       var amount="";
       for (j=1; j<=sheetObj.RowCount(); j++){
    	   cntrNo=sheetObj.GetCellValue(j, prefix+"cntr_no");
           if(! ComIsEmpty(cntrNo)){
        	   document.form['multi_cntr_no'][j-1]=new Option(cntrNo, cntrNo);
           }
       }
   }
   //tot_ots_amt 0 setting
   function ClearSel() {
       var sel=document.form.multi_cntr_no;
       for (i=sel.length-1; i>=0; i--){
           sel.options[i]=null
       }
   }    
    /**
     * setting value in case of after sheet2 retrieving
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
        var prefix="sheet2_";
        var formObject=document.form;
        if (ErrMsg == "") {
        	ComOpenWait(false);
        	if(sheetObj.RowCount()> 0){
				formObject.rcvr_cnee_nm.value=sheetObj.GetCellValue(1, prefix + "rcvr_cnee_nm");
				formObject.rcvr_eml.value=sheetObj.GetCellValue(1, prefix + "rcvr_eml");
				formObject.rcvr_fax_no.value=sheetObj.GetCellValue(1, prefix + "rcvr_fax_no");
				formObject.rcvr_phn_no.value=sheetObj.GetCellValue(1, prefix + "rcvr_phn_no");
        		ComBtnEnable("btn_Save");
        		if (beforetab == 0) { 
	            	ComBtnEnable("btn_Mail_Send");
	            	ComBtnEnable("btn_Fax_Send");
        		} else {
                	ComBtnDisable("btn_Mail_Send");
                	ComBtnDisable("btn_Fax_Send");        			
        		}
            } else {
            	ComBtnDisable("btn_Save");
            	ComBtnDisable("btn_Mail_Send");
            	ComBtnDisable("btn_Fax_Send");
            }
        } else {
        	initsheet2();
        }
     }
    /**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
     function sheet2_OnSaveEnd(sheetObj, ErrMsg){
    	 ComOpenWait(false);
         if (ErrMsg == "") {
    	    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
         }
         
     }              
     /**
   	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
   	 */
      function sheet3_OnSaveEnd(sheetObj, ErrMsg){
    	  ComOpenWait(false);
          if (ErrMsg == "") {
     	    doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
          }
      }
     /**
      * to sheet2 Copy한다.
      */
     function copyFormTosheet2() {
 	     var rowCnt=sheetObjects[1].RowCount();
 	     var prefix="sheet2_";
 	     if (rowCnt > 0) {
 	     	 sheetObjects[1].SetRowStatus(rowCnt,"U");
 	     } else {				//enter new case
 		     rowCnt=sheetObjects[1].DataInsert(-1);
 	  	     sheetObjects[1].SetRowStatus(rowCnt,"I");
 	     }
 	     // Do length 12
 	     if (ComChkLen(document.form.do_no.value, 12) == 2) {
 	    	 sheetObjects[1].SetCellValue(rowCnt,prefix + "do_no",document.form.do_no.value.substring(0, 10),0);
 	    	 sheetObjects[1].SetCellValue(rowCnt,prefix + "do_no_split",document.form.do_no.value.substring(10),0);
 	     } else {
 	    	 sheetObjects[1].SetCellValue(rowCnt,prefix + "do_no",document.form.do_no.value,0);
 	    	 sheetObjects[1].SetCellValue(rowCnt,prefix + "do_no_split",'00',0);
 	     }
 	     sheetObjects[1].SetCellValue(rowCnt,prefix + "rcvr_cnee_nm",document.form.rcvr_cnee_nm.value,0);
 	     sheetObjects[1].SetCellValue(rowCnt,prefix + "rcvr_eml",document.form.rcvr_eml.value,0);
 	     sheetObjects[1].SetCellValue(rowCnt,prefix + "rcvr_fax_no",document.form.rcvr_fax_no.value,0);
 	     sheetObjects[1].SetCellValue(rowCnt,prefix + "rcvr_phn_no",document.form.rcvr_phn_no.value,0);
     }
      /**
       * Trucker to sheet3 Copy
       */
    function copyFormTosheet3() {
  	    var rowCnt=sheetObjects[2].RowCount();
      	var prefix="sheet3_";
    	var formObject=document.form;
    	var sheetObj=sheetObjects[2];
  	    var cntr_no=document.form.multi_cntr_no.value;
     	for (j=1; j<=sheetObj.RowCount(); j++){
     		if (sheetObj.GetCellValue(j, prefix+"cntr_no") == cntr_no) {
     			sheetObjects[2].SetRowStatus(j,"U");
     			sheetObjects[2].SetCellValue(j,prefix + "trkr_nm",document.form.trkr_nm.value,0);
     			sheetObjects[2].SetCellValue(j,prefix + "trkr_phn_no",document.form.trkr_phn_no.value,0);
     			sheetObjects[2].SetCellValue(j,prefix + "trkr_mvmt_ref_no",document.form.trkr_mvmt_ref_no.value,0);
     			sheetObjects[2].SetCellValue(j,prefix + "trkr_mty_rtn_yd_cd",document.form.trkr_mty_rtn_yd_cd.value,0);
            }
        }
      }
    /**
     * setting value in case of after sheet3 retrieving
     */
      function sheet3_OnSearchEnd(sheetObj, ErrMsg){
    	  ComOpenWait(false);
          var prefix="sheet3_";
          var formObject=document.form;
          var cntr_no=null;
          if (ErrMsg == "") {
              if(sheetObj.RowCount()> 0){
            	  cntr_no=formObject.multi_cntr_no.value;
            	  fnMoveTrucker(cntr_no);
              }
          } else {
          	initsheet3();
          }
       }
    function fnMoveTrucker(cntr_no) {
    	var prefix="sheet3_";
    	var formObject=document.form;
    	var sheetObj=sheetObjects[2];
    	for (j=1; j<=sheetObj.RowCount(); j++){
			if (sheetObj.GetCellValue(j, prefix+"cntr_no") == cntr_no) {
			formObject.trkr_nm.value=sheetObj.GetCellValue(j, prefix+"trkr_nm");
			formObject.trkr_phn_no.value=sheetObj.GetCellValue(j, prefix+"trkr_phn_no");
			formObject.trkr_mvmt_ref_no.value=sheetObj.GetCellValue(j, prefix+"trkr_mvmt_ref_no");
			formObject.trkr_mty_rtn_yd_cd.value=sheetObj.GetCellValue(j, prefix+"trkr_mty_rtn_yd_cd");
            }
        }    	  
    }
    function fnIsChange() {
    	var prefix2="sheet2_";
    	var prefix3="sheet3_";
    	if (beforetab == 0) {
        	if (sheetObjects[1].RowCount()== 0) {
        		return false;
        	}
        	if (fncDiff(sheetObjects[1].GetCellValue(1,prefix2 + "rcvr_cnee_nm"), document.form.rcvr_cnee_nm.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[1].GetCellValue(1,prefix2 + "rcvr_eml"), document.form.rcvr_eml.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[1].GetCellValue(1,prefix2 + "rcvr_fax_no"), document.form.rcvr_fax_no.value) == true) {
        		return true;
        	}
        	if (fncDiff(sheetObjects[1].GetCellValue(1,prefix2 + "rcvr_phn_no"), document.form.rcvr_phn_no.value) == true) {
        		return true;
        	}
    	} else {
        	if (sheetObjects[2].RowCount()== 0) {
        		return false;
        	}
        	var cntr_no=document.form.multi_cntr_no.value;
        	for (j=1; j<=sheetObjects[2].RowCount(); j++){
        		if (sheetObjects[2].GetCellValue(j, prefix3+"cntr_no") == cntr_no) {
        			if (fncDiff(sheetObjects[2].GetCellValue(j,prefix3 + "trkr_nm"), document.form.trkr_nm.value) == true) {
    		    		return true;
    		    	}
        			if (fncDiff(sheetObjects[2].GetCellValue(j,prefix3 + "trkr_phn_no"), document.form.trkr_phn_no.value) == true) {
    		    		return true;
    		    	}
        			if (fncDiff(sheetObjects[2].GetCellValue(j,prefix3 + "trkr_mvmt_ref_no"), document.form.trkr_mvmt_ref_no.value) == true) {
    		    		return true;
    		    	}
        			if (fncDiff(sheetObjects[2].GetCellValue(j,prefix3 + "trkr_mty_rtn_yd_cd"), document.form.trkr_mty_rtn_yd_cd.value) == true) {
    		    		return true;
    		    	}
        		}
        	}    		
    	}
    	return false;
    }
    /**
     * string compare
     * @param orgStr
     * @param newStr
     * @return
     */    
    function fncDiff(orgStr,newStr){
    	orgStr=orgStr.replace(eval("/\\r\\n/gi"), "").trim();
    	newStr=newStr.replace(eval("/\\r\\n/gi"), "").trim();
    	if(orgStr != newStr){
    		return true;
    	}else{
    		return false;
    	}
    }    
