/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0101.js
*@FileTitle  : TPB Code Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================
*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0101 : business script for ESD_TPB_0101
 */
//    function ESD_TPB_0101() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
    /* Global Variables */
    var curTab=1;
    var beforetab=0;
    var sheetObjects=new Array();
    var sheetCnt=0;
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
		   //Setting startup environment. Change the name of the function
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Setting final environment.
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8=true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
			    with(sheetObj){
	        		  var cnt=0;
				      var HeadTitle="Del.|STS|I/F Type|Expense Type|Code|Name|Account Code|Description|SCEM Exception Case|Interfaced To|Active\nFlag";
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
				             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Combo",     Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"n3pty_if_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Combo",     Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"n3pty_expn_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"ar_acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"n3pty_bil_tp_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
				             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"expt_cs_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cml_sys_if_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"act_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				      InitColumns(cols);
				      SetEditable(1);
	                  SetColProperty("act_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
	                  getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode','F','','1');
	                  SetColProperty("n3pty_expn_tp_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
	                  SetColProperty("cml_sys_if_cd", {ComboText:combo02Text, ComboCode:combo02Code} );
//	                  SetColProperty("n3pty_if_tp_cd", {ComboText:combo03Text, ComboCode:combo03Code} );
	                  SetColProperty("n3pty_if_tp_cd", {ComboText:'Source', ComboCode:'S'} );
	                  
	                  SetColProperty(0 ,"n3pty_bil_tp_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	                  //SetColProperty(0 ,"n3pty_bil_tp_nm" , {AcceptKeys:"E|[0123456789 ]" , InputCaseSensitive:1});
	                  //SetColProperty(0 ,"n3pty_bil_tp_desc" , {AcceptKeys:"E|[-0123456789 ]" , InputCaseSensitive:1});
                      SetColProperty(0 ,"ar_acct_cd" , {AcceptKeys:"N" , InputCaseSensitive:1});
	                  
	                  SetSheetHeight(500);
				      }
				break;
		}
	}
    /* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
	function processButtonClick(){
		 /***** Assignment sheet in case of over 2 by tab ****/
		 var sheetObject=sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject=document.form;
		 if(curTab == 2)
			formObject=document.form2;
		 var sheetObject=sheetObjects[0];
	     var formObject=document.form;
		 try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			} // end switch
		} catch(e) {			
			if( e == "[object Error]") {
				ComShowMessage(getMsg('COM12111'));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	/* Processing Sheet */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
		   case IBSEARCH:	  //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_TPB_0101GS.do", tpbFrmQryStr(formObj));
				break;
			case IBSAVE:		//Save
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESD_TPB_0101GS.do", tpbFrmQryStr(formObj));
				
				break;
			case IBINSERT:	  //입력
				var Row=sheetObj.DataInsert(-1);
				break;
			case IBDOWNEXCEL:  //Excel download
				if(sheetObj.RowCount() < 1){//no data
	        	     ComShowCodeMessage("COM132501");
        	    } else{
        	    	sheetObj.Down2Excel(TPBDown2ExcelOptions);
        	    }
				break;
		}
	}
	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 */
  	function sheet1_OnChange(sheetObj, Row, Col, Value){
  		var colNm=sheetObj.ColSaveName(Col);
  		var temp;
  		var cnt=0;
  		// n3pty_bil_tp_cd Duplication Check
  		if( colNm == 'n3pty_bil_tp_cd' && Value != '' ){
  			for(i=1;i<=sheetObj.RowCount();i++)
  			{
  				temp=sheetObj.GetCellValue(i,'n3pty_bil_tp_cd');
  				if( Value == temp ) cnt=cnt + 1;
  			}
  			if( cnt > 1 )	// Checking duplication
  			{
  				ComShowCodeMessage('TPB90069');
  				sheetObj.SetCellValue(Row,'n3pty_bil_tp_cd','',0);
  			} else	// Checking DB duplication
  			{
  				document.form.s_n3pty_bil_tp_cd.value=Value;
  	  			getTPBGenCombo('CheckTPBCode','checkBillingCaseCode','V','','',new Array('s_n3pty_bil_tp_cd'),Value, Row);
  			}
  		}
  	}
  	
//  	function sheet1_OnSaveEnd(sheetObj){
//  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
//  		
//  	}    	
  	
//    function sheet1_OnSearchEnd(sheetObj){
//        for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
//			if(sheetObj.GetCellValue(i,'n3pty_if_tp_cd') == ''){
//				sheetObj.SetCellValue(i,'n3pty_if_tp_cd','S',0);
//			}
//        }
//    }  	
	/**
	 * Checking validation of input value
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		   if(!ComChkValid(formObj)) return false;
		}
		return true;
	}
    /* Finishing work */