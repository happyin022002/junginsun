/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0024.js
*@FileTitle  : Prepayments - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_FMS_0024 : ESM_FMS_0024 definition of biz script for creation screen
     */
	// common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var localopener=window.dialogArguments;
	if (!localopener) localopener=window.opener;  //이 코드 추가할것
	if (!localopener) localopener=parent; //이 코드 추가할것
	
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
			        case "btn_confirm":
			        	//var sRow=sheetObj.FindCheckedRow("apply");
			        	var sRow=sheetObj.FindCheckedRow("radio");
			    		if (sRow == "") {
			    			ComShowCodeMessage('COM12189');
			    			return;
			    		}
			        	var aryData=new Array();
	    	        	var idx=0;
	    	        	var row=formObject.chk_row.value;
	    	        	var prePaymentData={ppay_hir_no:"", ctr_cd:"", slp_loc_cd:"", inv_amt_sum:"", acct_desc:"", flet_iss_tp_cd:"", inv_seq:"", inv_dtl_seq:"", flet_src_tp_cd:"", eff_dt:"", exp_dt:"", flet_ctrt_no:""};
	    	        	prePaymentData.ppay_hir_no=sheetObject.GetCellValue(row,"ppay_hir_no");
	    	        	prePaymentData.ctr_cd=sheetObject.GetCellValue(row,"ctr_cd");
	    	        	prePaymentData.slp_loc_cd=sheetObject.GetCellValue(row,"slp_loc_cd");
	    	        	prePaymentData.inv_amt_sum=sheetObject.GetCellValue(row,"inv_amt_sum");
	    	        	for (var ir=1; ir<=sheetObject.LastRow(); ir++){
	    	        		if(sheetObject.GetCellValue(ir, "ppay_hir_no") == sheetObject.GetCellValue(row,"ppay_hir_no")) {
	    	        			if(sheetObject.GetCellValue(ir,"acct_cd") == gAcctCdByHire) {
	    	        				prePaymentData.acct_desc=sheetObject.GetCellValue(row,"ori_inv_desc");
	    		     				break;
	    		     			}
	    		     		}
	    	        	}
	    	        	//prePaymentData.acct_desc = sheetObject.CellValue(row,"acct_desc");
	    	        	prePaymentData.flet_iss_tp_cd=sheetObject.GetCellValue(row,"flet_iss_tp_cd");
						prePaymentData.inv_seq=sheetObject.GetCellValue(row,"inv_seq");
						prePaymentData.inv_dtl_seq=sheetObject.GetCellValue(row,"inv_dtl_seq");
						prePaymentData.flet_src_tp_cd=sheetObject.GetCellValue(row,"flet_src_tp_cd");
						prePaymentData.eff_dt=sheetObject.GetCellValue(row,"eff_dt");
						prePaymentData.exp_dt=sheetObject.GetCellValue(row,"exp_dt");
						prePaymentData.flet_ctrt_no=sheetObject.GetCellValue(row,"flet_ctrt_no");
	    	        	aryData[idx++]=prePaymentData;
	    	        	localopener.setPrepayments(aryData);
	    	        	ComClosePopup(); 
						break;
			        case "btn_close":
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        sheet1_OnLoadFinish(sheet1);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen.
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
                with(sheetObj){
              
              var HeadTitle=" |Apply|Apply|Hire No|Item Name|Account\nCode|From|To|Cur|Amount|Description|Center Code|City Code|Amount Sum|Acct Desc|FletIssTpCd|Inv Seq|Inv Dtl Seq|Flet Src TpCd|Flet Ctrt No|ori_inv_desc";
              var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ims_ppay_hir_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"radio",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"apply",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ppay_hir_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acct_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ctr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"slp_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt_sum",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"acct_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_iss_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"inv_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_src_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"flet_ctrt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ori_inv_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetSheetHeight(330);
            }
            break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/ 
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_FMS_0024GS.do", FormQueryString(formObj) );
                break;
        }
    }
    /**
     * Event occurring when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
 	function sheet1_OnChange(sheetObj,Row,Col,Value){
 		//ComDebug("Row=>"+Row+"Col=>"+Col+"Value=>"+Value);
 		
 		//UI개선(201408 민정호)
//    	if (sheetObj.ColSaveName(Col)==("apply")) {
        if (sheetObj.ColSaveName(Col)==("radio")) {    		
    		var allchk=ComFindAll(sheetObj, "ppay_hir_no", sheetObj.GetCellValue(Row,"ppay_hir_no"));
 			//ComDebug("allchk"+allchk);
    		var arrchk=0;
    		//if(allchk != 1) {
    		if(typeof(allchk.length) != "undefined") {
    			arrchk=allchk.split("|");
    			sheetObj.CheckAll(Col,0);
        		for(var i=0 in arrchk){
        			//ComDebug("i"+i);
        			sheetObj.SetCellValue(arrchk[i],"apply",Value,0);
        		}
    		} else {
    			sheetObj.CheckAll(Col,0);
    			sheetObj.SetCellValue(Row,"apply",Value,0);
    		}
    		//var arrchk = allchk.split("|");
    		/*
    		sheetObj.CheckAll(Col,0);
    		for(var i=0 in arrchk){
    			//ComDebug("i"+i);
    			sheetObj.SetCellValue(arrchk[i],"apply",Value,0);
    		}
    		*/
    		var invAmtSum=parseFloat(sheetObj.GetCellValue(Row,"inv_amt"));
    		var chkVal=sheetObj.GetCellValue(Row,"ppay_hir_no");
	 		if(Value == 1) {
		 		for (var ir=1; ir<=sheetObj.LastRow(); ir++){
		 			if(sheetObj.GetCellValue(ir, "ppay_hir_no")== chkVal && Row != ir) {
		     			//sheetObj.CellValue2(ir,"apply") = 1;
		     			//sheetObj.CellValue2(ir,"apply") = 0;
		 				invAmtSum=invAmtSum + parseFloat(sheetObj.GetCellValue(ir,"inv_amt"));
		 				if(sheetObj.GetCellValue(ir,"acct_cd") == "510911") {
		 					sheetObj.SetCellValue(Row,"acct_desc",sheetObj.GetCellValue(ir,"inv_desc"),0);
		     			}
		     		} else {
		     			if(sheetObj.GetCellValue(ir,"acct_cd") == "510911") {
		     				sheetObj.SetCellValue(Row,"acct_desc",sheetObj.GetCellValue(ir,"inv_desc"),0);
		     			}
		     			//sheetObj.CellValue2(Row,"acct_desc") = sheetObj.CellValue(Row,"inv_desc");
		     			//ComDebug("Row=2>");
		     			//sheetObj.CellValue2(ir,"apply") = 0;
		     			//sheetObj.CellValue2(ir,"apply") = 1;
		     		}
		     		if(ir == sheetObj.LastRow()) {
	     				sheetObj.SetCellValue(Row, "inv_amt_sum",invAmtSum,0);
	     			}
		     	}
	 		} else {
	 			//ComDebug("Row=3>");
	 			//sheetObj.CellValue2(Row,"apply") = 0;
	 			//sheetObj.CellValue2(Row,"apply") = 1;
	 		}
	 		form.chk_row.value=Row;
    	}
 	}
