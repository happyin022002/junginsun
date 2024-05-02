/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0132.jsp
*@FileTitle  : TPB Office Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESD_TPB_0132 : business script for ESD_TPB_0132
     */
    /* Global Variables */
	var currSheetObj=null;
	var currLayer=5;
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
		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','1', new Array("s_ofc_cd_for_rhq","s_office_level") );
//		document.form.s_if_rhq_cd.onchange=if_rhq_cd_OnChange;
		$('#s_if_rhq_cd').on('change', if_rhq_cd_OnChange);
	}
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8=true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init "H"
	            with(sheetObj){
                var cnt=0;
                var HeadTitle="STS|Office|TPB Office|RHQ Office|Control Office|A/R Office|Update User|Update Date";
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ctrl_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_ar_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          //SetSheetHeight(460);
		          ComResizeSheet(sheetObjects[0]);    
            }
		break;
		}
	}
	/* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
	function processButtonClick(){
		var sheetObject=sheetObjects[0]; //  [currLayer-1 + curTab-1];
		var formObject=document.form;
		if(curTab == 2)
			formObject=document.form2;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			} // end switch
		}catch(e) {			
			if( e == "[object Error]") {
				ComShowMessage(getMsg('COM12111'));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/* Processing Sheet */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		currSheetObj=sheetObj;
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		   case IBSEARCH:	  //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=SEARCH;
 				sheetObj.DoSearch("ESD_TPB_0132GS.do", tpbFrmQryStr(formObj) );
				break;
			case IBDOWNEXCEL:  //Excel download
 				if(sheetObj.RowCount() < 1){//no data
 					ComShowCodeMessage("COM132501");
 				}else{
 					sheetObj.Down2Excel(TPBDown2ExcelOptions);
 				}
				break;
		}
	}
	/**
	 * Checking validation of input value
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		   if(!ComChkValid(formObj)) return false;
		}
		return true;
	}
	/**
     * handling process after ending sheet1 retrieve
     */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	}
	function if_rhq_cd_OnChange(){
		var f=document.form;
		getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','1', new Array("s_if_rhq_cd","s_office_level"));
	}
	/* Finishing work */
