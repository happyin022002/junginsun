/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_00401.js
*@FileTitle  : Manual Slip – Brokerage / Window
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
     * @class esm_fms_00401 : esm_fms_00401 definition of biz script for creation screen
     */
    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
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
    				comPopupOK();
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
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	//sheet1_OnLoadFinish(sheetObjects[0]);
    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	//sheetObjects[0].DataInsert(-1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * adding first-served functions after loading screen. 
     */
/*    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }*/
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
    		case 1:      //sheet1 init
    		    with(sheetObj){
    	      
    			var HeadTitle1="Apply|||Seq|Contract No|Description|From Date|To Date|Item Name|Account Code|Cur|Amount|VVD|flet_iss_tp_cd|inv_seq|inv_dtl_seq|acct_itm_seq|flet_ctrt_tp_cd";
    			var headCount=ComCountHeadTitle(HeadTitle1);

    			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

    			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    			InitHeaders(headers, info);

    			var cols = [ {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"radio",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	                   {Type:"CheckBox",  Hidden:0, Width:30,    Align:"Center",  ColMerge:0,   SaveName:"checkbox",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	                   {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
    	             {Type:"Text",      Hidden:0, Width:120,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Combo",     Hidden:0, Width:85,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"flet_iss_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"inv_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"acct_itm_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"flet_ctrt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd_txt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
    	       
	    	      InitColumns(cols);
	    	      SetEditable(1);
	    	      //SetSheetHeight(260);
	    	      resizeSheet();
    	            }


    			break;
    	}
    }
    /**
     * Handling IBSheet's process<br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction, row) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      
    			formObj.f_cmd.value=SEARCH;
    			var sXml=sheetObj.GetSearchData("ESM_FMS_00401GS.do", FormQueryString(formObj));
    			sheetObj.LoadSearchData(sXml,{Sync:2} );
 	   			//sheetObj.DoSearch("ESM_FMS_00401GS.do", FormQueryString(formObj) );
				break;
    		case IBROWSEARCH:   
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("ESM_FMS_00401GS.do", FormQueryString(formObj));
				var vvdCd=ComGetEtcData(sXml, "vvdCd");
	   			if(typeof vvdCd != "undefined" && vvdCd != "") {
	   				setVvdCdMakeCombo(sheetObj, vvdCd, row);
    			}else{
    				var curRow = sheetObj.GetSelectRow();
    				ComShowCodeMessage('FMS01232');
    				sheetObj.SetCellValue(curRow, "checkbox", "0", 0);
    			}
				break;
    	 	case IBSAVE:        
    	 		break;
    	 	case IBINSERT:      
    	 		break;
    	}
    }
    /**
     * Handling process for input validation<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
    		var tmpVvdCdTxt = sheetObj.GetCellValue(i, "vvd_cd_txt");
    		if(tmpVvdCdTxt  != ""){
    			setVvdCdMakeCombo(sheetObj, tmpVvdCdTxt+"|", i);
    		}
    	}
    }
    /**
     * Retrieving VVD information relevant to Voyage when OnChange Event of sheet1 is occurred<br>
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
    	if(Value == OldValue) return;
    	var sName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	switch(sName){
    	case "radio":
    	case "checkbox":
    		//if(sheetObj.GetComboInfo(row, "vvd_cd", "Text") != "") {
    		//	return;
    		//}
			form.flet_ctrt_no.value=sheetObj.GetCellValue(Row, "flet_ctrt_no");
			form.fm_dt.value=sheetObj.GetCellValue(Row, "eff_dt");
			form.to_dt.value=sheetObj.GetCellValue(Row, "exp_dt");
	    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Row);
    		break;
    	}    	
    }    
    /**
     * Making Vvd Combo box<br>
     **/
    function setVvdCdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
      		var vvdCode=comboText.substring(0, comboText.length-1);
      		var vvdText=vvdCode;
           	sheetObj.InitCellProperty(row, "vvd_cd",{ Type:"Combo"} );
          	sheetObj.CellComboItem(row,"vvd_cd", {ComboText:vvdText, ComboCode:vvdCode} );
           	
          	sheetObj.GetComboOpenMode(1);
          	
          	
          	var arrVvdCd = vvdCode.split("|"); 
          	if(arrVvdCd.length > 0){
          		sheetObj.SetCellValue(row, "vvd_cd", arrVvdCd[0], 0);
          	}
      	}
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
