/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1068.js
*@FileTitle  : TPB Issue Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_1068 : business script for ESM_BKG_1068
     */
    function ESM_BKG_1068() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_GotoTPB":
            	doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01);
                break;
            case "btn_Close":
            	ComClosePopup(); 
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
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param sheet_obj
     * @return 
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     * 
     * @return 
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    /**
    * event handling when Sheet1 instance complete<br>
    * 
    * @return 
    */

    function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header<br>
     * @param sheetObj
     * @param sheetNo
     * @return 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){

              var HeadTitle1="|Sel.|Seq.|Bkg No.|Ntc Seq|CNTR No.|TP|S/O|MVMT|Incurred Charges (USD)|TPB|TPB No.";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ntc_seq" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"is_so",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"incur_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_yn",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetSheetHeight(82,1);
                    }


            break;
        }
    }
    /**
     * handling sheet process <br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction) == false) break;
            ComOpenWait(true);
	        formObj.f_cmd.value=SEARCH;	        
	        sheetObj.DoSearch("ESM_BKG_1068GS.do", FormQueryString(formObj) );
	        ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC01:        
        	if(validateForm(sheetObj,formObj,sAction) == false) break;
     	    if (sheetObj.RowCount()== 0) {
    		    ComShowCodeMessage("BKG00109"); 
    	        break;
    	    }
     	    var iCheckRow=sheetObj.CheckedRows("chk");
       	    if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00249");
        		break;
        	}
        	var param="";
        	var p_cnt=0;
        	var p_bkg_no=formObj.bkg_no.value;
        	var p_bl_no=formObj.bl_no.value;
        	var p_trd_party_val=formObj.cust_cd.value;
        	var p_curr_cd="USD";
        	var p_eq_no="";
        	var p_if_amt="";
        	var p_eq_tpsz_cd="";
        	for(var i=0; i<sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i+1, "chk") == "1") {
					            		p_cnt++;
					            		if (p_cnt > 1) p_eq_no += "|$|"; 
					p_eq_no += sheetObj.GetCellValue(i+1, "cntr_no");
					            		if (p_cnt > 1) p_eq_tpsz_cd += "|$|"; 
					p_eq_tpsz_cd += sheetObj.GetCellValue(i+1, "cntr_tpsz_cd");
					            		if (p_cnt > 1) p_if_amt += "|$|"; 
					p_if_amt += sheetObj.GetCellValue(i+1, "incur_chg_amt");
            	}
        	}
        	param="p_bkg_no="        + p_bkg_no        + "&" +
        	        "p_eq_no="         + p_eq_no         + "&" +
        	        "p_if_amt="        + p_if_amt        + "&" +
        	        "p_eq_tpsz_cd="    + p_eq_tpsz_cd    + "&" +
        	        "p_bl_no="         + p_bl_no         + "&" +
        	        "p_trd_party_val=" + p_trd_party_val + "&" +
        	        "p_curr_cd=USD";
//        	var rtnValue=ComOpenPopupWithTarget('/opuscntr/ESD_TPB_0103.do?pgmNo=ESD_TPB_0103&' + param, 1300, 633, "", "none", true);

			var width	=1300;
			var height	=633;        	
        	var pgmNo="ESD_TPB_0103";
			var pgmUrl="/opuscntr/ESD_TPB_0103.do?";
			var src="&pgmNo=" + pgmNo +"&" + param;
			var sFeatures="status=no, width=1024, height=768, resizable=yes, scrollbars=yes";   
			
//			var callback = "callBackReturn";
			
			ComOpenWindowCenter(pgmUrl + src, pgmNo, width,height, false);        
			
			
//        	if (rtnValue != null) {
//        		var arrList=rtnValue.split("|$|");
//            	if (arrList != null && arrList.length > 0) {
//            		var idx=0;
//                	for(var i=0; i<sheetObj.RowCount(); i++) {
//                    	if (idx == arrList.length) break;
//                    		if(sheetObj.GetCellValue(i+1, "chk") == "1") {
//                    		sheetObj.SetCellValue(i+1, "n3pty_bil_no",arrList[idx++]);
//                    	}
//                	}
//                	ComOpenWait(true);
//                    formObj.f_cmd.value=MULTI;
//                    var sParam=FormQueryString(formObj);
//                    var sParamSheet=sheetObj.GetSaveString(false, true, "chk");
//                    if (sParamSheet != "") {
//                        sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
//                    }
//                    sheetObj.DoSave("ESM_BKG_1068GS.do", sParam, -1, false);
//                    ComOpenWait(false);
//            	}
//        	}
        	break;
        }
    }

    
    function callBackReturn(rtnValue){
    	if (rtnValue != null) {
    		var arrList=rtnValue.split("|$|");
        	if (arrList != null && arrList.length > 0) {
        		var idx=0;
            	for(var i=0; i<sheetObjects[0].RowCount(); i++) {
                	if (idx == arrList.length) break;
                		if(sheetObjects[0].GetCellValue(i+1, "chk") == "1") {
                			sheetObjects[0].SetCellValue(i+1, "n3pty_bil_no",arrList[idx++]);
                	}
            	}
            	ComOpenWait(true);
                document.form.f_cmd.value=MULTI;
                var sParam=FormQueryString(document.form);
                var sParamSheet=sheetObjects[0].GetSaveString(false, true, "chk");
                if (sParamSheet != "") {
                    sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
                }
                sheetObjects[0].DoSave("ESM_BKG_1068GS.do", sParam, -1, false);
                ComOpenWait(false);
        	}
    	}
     }    
    /**
     * event handling when Sheet1 retrieve complete<br>
     * 
     * @param sheetObj
     * @param ErrMsg
     * @return 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with (sheetObj) {
        	for (var i=0; i<RowCount(); i++) {
if (GetCellValue(i+1, "n3pty_bil_yn") == "Y") {
        			SetRowEditable(i+1,0);
        		}
        	}
    	}
    }    
    /**
     * event handling when Sheet1 saved<br>
     * 
     * @param sheetObj
     * @param ErrMsg
     * @return 
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }
    /**
     * handling process for input validation <br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
          	case IBSEARCH:
       	    	if (!ComChkValid(formObj)) return false;
       	    	break;
            case IBSEARCH_ASYNC01:
            	for(var i=0; i<RowCount(); i++) {
if(GetCellValue(i+1, "chk") == "1") {
if (GetCellValue(i+1, "incur_chg_amt") == "") {
                			ComShowCodeMessage("BKG40088");
                			return false;
                		}
                	}
            	}
            	break;
            }
        }
        return true;
    }    
