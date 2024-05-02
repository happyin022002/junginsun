/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0272.js
*@FileTitle  : E-mail / Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class E-mail / Print : E-mail / Print 
     */
//    function ESM_BKG_0272_1() {
//    	this.processButtonClick=processButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    	this.sheet1_OnChangeSum=sheet1_OnChangeSum;
//    }
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var pageCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_new":
                	formObject.recipient.value="";
                    break;
                case "btn_E-mail":
                	fnMailSendSet();
                	doActionIBSheet(sheetObject,formObject,MULTI02);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
                case "btn_Prev":
                	//validation of email address 
					fnSendMailDataSet();
                	if (pageCnt < 2) {
                		pageCnt=1;
                	} else {
                    	pageCnt=pageCnt - 1;                		
                	}
                	fnPageSet();
                	break;
                case "btn_Next":
                	//validation of email address
					fnSendMailDataSet();
                	if (pageCnt == sheetObjects[0].RowCount()) {
                		pageCnt=sheetObjects[0].RowCount();
                	} else {
                    	pageCnt=pageCnt + 1;                		
                	}
                	fnPageSet();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() 
    {
        for(i=0;i<sheetObjects.length;i++)
        {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		 ComBtnDisable("btn_Prev");
		 ComBtnDisable("btn_Next");
		 SheetGetData();
        doActionIBSheet(sheetObjects[0],document.form,COMMAND03);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) 
    {
    	var cnt=0;
    	switch(sheetObj.id) 
        {
            case "sheet1":      //t1sheet1 init
                with(sheetObj) {
                
	                var HeadTitle1="|B/L No.|BKG No.|Container|POD|Yard|P/Up DT|Yard Name|Email|Phone No|Fax No.|Remark|VslNm|VVD|LOC_NM|CUST_NM|TRSP_MOD|SEND_DATE|do_no|do_iss_dt|PIN|Send|RlseSeq|ATB#|Contents|pod_nm|rlse_exp_dt";
	                prefix="sheet1_";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cgo_pkup_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"phn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_trsp_mod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"send_date",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_iss_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	 		                  {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pin_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:7 },
			                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlse_ord_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:0,  Width:155,  Align:"Center",  ColMerge:1,   SaveName:prefix+"msg_acpt_ref_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, // ATB# 추가
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"content",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rlse_exp_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
	                          ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
//	                SetSheetHeight(0);
	                SetVisible(false);

            	}
            	break;
            case "sheet2":      //t1sheet1 init
	            with(sheetObj) {
	                var HeadTitle1="|B/L No.|BKG No.|Container|yd_cd|yd_eml|from|recipient|file_key|subject|carbon_copy|blind_carbon_copy|content|argument|template";
	                prefix="sheet2_";
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_eml",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"from",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"recipient",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"file_key",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"subject",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"carbon_copy",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"blind_carbon_copy", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"content",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"argument",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"template",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
//	                SetSheetHeight(0);
	                SetVisible(false);
		        }
		        break;
        }
    }
    /**
     * handling IBSheet  <br>
     * using this function in case of calling the function of IBSheet from {@link #processButtonClick} <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     handling Action code(example:IBSEARCH,MULTI02,IBDELETE,IBDOWNEXCEL , CoObject.js)
     * @param {String}  gubun     	handling gubun value
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) 
    {
        switch(sAction) 
        {
			case MULTI02:        //transmitting EMAIL 
				if(validateForm(sheetObj,formObj,sAction)) {
				    if(!ComShowCodeConfirm("BKG01069")) return;
                	//validation of email address
				    fnSendMailDataSet();
					formObj.f_cmd.value=MULTI02;
	                var sParam1=sheetObjects[0].GetSaveString();
	                var sParam2=sheetObjects[1].GetSaveString();
	                
 					var sXml=sheetObj.GetSaveData("ESM_BKG_0272GS.do", sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj));
        	        var rMsg=ComResultMessage(sXml);
        	        if(sXml != ''){
                    	var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
        				if(State == "S"){
        				   alert(rMsg.split('<||>').join('\n'));
        				   
        				   ComPopUpReturnValue("Y"); 
        				} else {
        				   alert(rMsg.split('<||>').join('\n'));
        				}
        			 }
         		}
				break;
			case COMMAND03:      
	            formObj.f_cmd.value=COMMAND03;
                var aryPrefix=new Array("sheet1_", "sheet2_"); //prefix list of string 
                var sParam1=sheetObjects[0].GetSaveString();
                 var sXml=sheetObj.GetSearchData("ESM_BKG_0272GS.do", sParam1 + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml=sXml.split("|$$|");
                for(var idx=0; idx < arrXml.length; idx++){
                    sheetObjects[idx].RenderSheet(0);
                    if(idx > 0) {
                        sheetObjects[idx].SetWaitImageVisible(0);
                    }
                    sheetObjects[idx].LoadSearchData(arrXml[idx],{Sync:1} );
                    sheetObjects[idx].RenderSheet(1);
                }
	            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	if(form.recipient.value == "") {
    		ComAlertFocus(form.recipient, ComGetMsg('FMS01146'));
    		return false;
    	}
    	if(!ComIsEmailAddr(form.recipient.value)) {
    		ComShowCodeMessage("BKG40021" , form.recipient.value);
    		return false;
    	}
    	return true;
    }
     /**
      *  getting Data from sheet of Opener
      * @param {void}
      * @return void
      * @author
      * @version 2009.10.01
      */      
     function SheetGetData() {
         //
         var sXml=opener.form.mailXml.value;
         
         sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
         for(i=0;i<sheetObjects[0].RowCount();i++){
        	 sheetObjects[0].SetRowStatus(i+1,"U");
         }
     }     
      /**
       * getting Data from Sheet of Opener
       * @param {void}
       * @return void
       * @author
       * @version 2009.10.01
       */      
      function fnMailSendSet() {
    	   for(i=0;i<sheetObjects[0].RowCount();i++){
           	 sheetObjects[0].SetRowStatus(i+1,"U");
            } 
          for(i=0;i<sheetObjects[1].RowCount();i++){
         	 sheetObjects[1].SetRowStatus(i+1,"U");
          }          
      }           
      /**
       * setting the value when sheet2 is retrieved
       * @param Object sheetObj IBSheet Object
       * @param Object ErrMsg   error message
       * @return void
       * @author
       * @version 2009.11.01
       **/
     function sheet2_OnSearchEnd(sheetObj, ErrMsg){
     	var prefix="sheet2_";
         if (ErrMsg == "") {
             if(sheetObj.RowCount()> 0){
            	 for(i=0;i<sheetObjects[1].RowCount();i++){
            		 sheetObjects[1].SetCellValue(pageCnt, "sheet2_recipient",sheetObjects[1].GetCellValue(pageCnt, "sheet2_yd_eml"),0);
           	     	sheetObjects[1].SetCellValue(pageCnt, "sheet2_subject",document.form.subject.value,0);
                  }
            	 pageCnt=1;
            	 fnPageSet();
             }
         } else {
        	 fnClear();
         }
     }      
     function fnPageSet() {
    	 var prefix="sheet2_";
    	 if (pageCnt == 0) {
    		 fnClear();
    	 }
    	 document.form.pageCount.value=pageCnt + " of " + sheetObjects[1].RowCount();
    	 if (pageCnt == sheetObjects[1].RowCount()) {
    		 ComBtnEnable("btn_Prev");
    		 ComBtnDisable("btn_Next")
    	 } else if (pageCnt == 1) {
    		 ComBtnDisable("btn_Prev")
    		 ComBtnEnable("btn_Next");    		 
    	 } else {
    		 ComBtnEnable("btn_Prev");
    		 ComBtnEnable("btn_Next");    		 
    	 }
    	 document.form.recipient.value=sheetObjects[1].GetCellValue(pageCnt, prefix + "yd_eml");
    	 document.form.content.value=sheetObjects[1].GetCellValue(pageCnt, prefix + "content");
     }
     function fnClear() {
    	 document.form.pageCount.value="";
    	 document.form.recipient.value="";
    	 document.form.content.value="";
     }
     function fnSendMailDataSet() {
     	sheetObjects[1].SetCellValue(pageCnt, "sheet2_yd_eml",document.form.recipient.value,0);
     	sheetObjects[1].SetCellValue(pageCnt, "sheet2_recipient",document.form.recipient.value,0);
     	sheetObjects[1].SetCellValue(pageCnt, "sheet2_subject",document.form.subject.value,0);
     } 