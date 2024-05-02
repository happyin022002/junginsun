/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1021.do
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	function ESM_BKG_1021()
	{
		
	}
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var isSaveable=false;
	var isDeleteable=false;
	document.onclick=processButtonClick;
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * Event handler processing by button name
	 */
	function processButtonClick()
	{
		var sheetObject1=sheetObjects[0];
	    var formObj=document.form;
		try
		{
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName)
			{
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObj,MULTI);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObj,REMOVE);
					break;
			}
		}
		catch(e)
		{
			if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
			else ComShowMessage(e.message);
		}
	}
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj)
	{
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage()
	{
		ComBtnSetInquiry();
	    for(i=0;i<sheetObjects.length;i++)
	    {
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	    // axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	    if (document.form.ofc_cd.value != "") {
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    }
	    axon_event.addListener('keydown', 'ComKeyEnter', "ofc_cd");
	}
	function sheet1_OnSearchEnd(sheetObj, Code, errXml) {
		var formObj=document.form;
		var status=sheetObj.GetEtcData('status');				
		if(status == 'no_data') {			
			initForm();
			ComShowCodeMessage("BKG00095");
			isDeleteable=false;
		} else {
			formObj.bank_in_acct_ctnt.value=sheetObj.GetCellValue(1, 'bank_in_acct_ctnt');
			upd_usr_id.innerHTML=sheetObj.GetCellValue(1, "upd_usr_id");
		}
		
		isDeleteable=true;		
//		if (sheetObj.GetCellValue(1, 'drft_bl_bank_acct_dp_flg') == "Y")
//			formObj.dp_flg.checked=true;
//		else formObj.dp_flg.checked=false;
		
	}
	
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction)
	{
		var len=formObj.ofc_cd.value.length;
	    switch(sAction)
	    {
	    case MULTI:
	    	if(!isSaveable)
	    	{
	    		ComShowCodeMessage("BKG00448");
	    		return false;
	    	}
	    	if (!ComChkValid(formObj)) return false;
	    	if(formObj.old_ofc_cd.value != formObj.ofc_cd.value)
	    	{
	    		ComShowCodeMessage("BKG00448");
	    		return false;
	    	}
	    	break;
	    case REMOVE:
	    	if(!isDeleteable)
	    	{
	    		ComShowCodeMessage("BKG03054");
	    		return false;
	    	}
	    	if (!ComChkValid(formObj)) return false;
	    	if(formObj.old_ofc_cd.value != formObj.ofc_cd.value)
	    	{
	    		ComShowCodeMessage("BKG00448");
	    		return false;
	    	}
	    	isSaveable=false;
	    	break;
	    case IBSEARCH:
	    	isSaveable=true;
	    	if (!ComChkValid(formObj)) return false;
	    	break;
	    }
	    return true;
	}
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo)
	{
		var cnt=0;
		switch(sheetNo)
		{
			case 1:      //sheet1 init
			  with(sheetObj){
				   var HeadTitle="|||||||";
				   var headCount=ComCountHeadTitle(HeadTitle);
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle, Align:"Center"} ];
				   InitHeaders(headers, info);
				   var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"an_tp_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chn_agn_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bank_in_acct_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"drft_bl_bank_acct_dp_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				   InitColumns(cols);
				   SetEditable(1);
				   SetSheetHeight(200);
		      }
			break;
		}
	}
	function initForm() {
		var formObj=document.form;
		formObj.bank_in_acct_ctnt.value="";
//		formObj.dp_flg.checked=false;
		formObj.drft_bl_bank_acct_dp_flg.value="";
		upd_usr_id.innerHTML="";
	}
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
	/**
	 * handling sheet process
	 */
	function doActionIBSheet(sheetObj,formObj,sAction)
	{
	    var status='';
	    switch(sAction)
	    {
			case IBSEARCH:				
				formObj.f_cmd.value=SEARCH;
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.old_ofc_cd.value=formObj.ofc_cd.value;
				sheetObj.DoSearch("ESM_BKG_1021GS.do", FormQueryString(formObj) );				
				break;
			case REMOVE:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if(ComShowCodeConfirm("BKG00535") == false) break;
				formObj.f_cmd.value=REMOVE;
				var sXml=sheetObj.GetSaveData("ESM_BKG_1021GS.do", FormQueryString(formObj));
				status=ComGetEtcData(sXml, 'status');
				if(status == 'ok')
				{
					initForm();
					ComShowCodeMessage("BKG00593");
					isSaveable=false;
					isDeleteable=false;
				}
				else
				{
					alert("Data Delete Action Failed!!");
				}
				break;
			case MULTI:
				if(!validateForm(sheetObj,formObj,sAction)) return;
//				if (formObj.dp_flg.checked == true) formObj.drft_bl_bank_acct_dp_flg.value="Y";
//				else formObj.drft_bl_bank_acct_dp_flg.value="N"
				
				formObj.drft_bl_bank_acct_dp_flg.value="N"
				
				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.GetSaveData("ESM_BKG_1021GS.do", FormQueryString(formObj));
				status=ComGetEtcData(sXml, 'status');
				if(status == 'ok')
				{
					ComShowCodeMessage("BKG00166");
					isDeleteable=true;
				}
				else
				{
					ComShowCodeMessage("BKG00167");
				}				
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
				break;
	    }
	}
	function fncTextareaMaxLine(obj, maxLine)
	{
		var str_len=obj.value;
		line=str_len.split("\r\n");
		ln=line.length;
		if(ln == maxLine && event.keyCode == 13)
		{
		    event.returnValue=false;
		}
	}
	//*************************************************************************************************
	//*************************************************************************************************
	//*************************************************************************************************
