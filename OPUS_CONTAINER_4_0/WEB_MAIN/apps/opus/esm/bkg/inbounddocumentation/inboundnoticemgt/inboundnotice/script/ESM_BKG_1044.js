/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1044.jsp
*@FileTitle  : Add Concerned Party
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function processButtonClick()
{
     /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
     var sheetObject1=sheetObjects[0];
     /*******************************************************/
     var formObj=document.form;
     try
     {
    	 var srcName=ComGetEvent("name");
    	 switch(srcName)
    	 {
    	 	case "btn_Add":
    	 		funcAddRow(sheetObject1);
				break;
    	 	case "btn_Delete":
    	 		funcDeleteRow(sheetObject1);
				break;
    	 	case "btn_Retrieve":
    	 		doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
    	 	case "btn_Save":
    	 		doActionIBSheet(sheetObject1, formObj, MULTI);
				break;
    	 	case "btn_Close":
    	 		var sParam=ComGetSaveString(sheetObject1);
				if(sParam != "")
				{
					if(ComShowCodeConfirm("BKG00168"))
					{
						ComClosePopup(); 
					}
				}
				else
				{
					ComClosePopup(); 
				}
				break;
    	 } // end switch
     }
     catch(e)
     {
    	 if( e == "[object Error]")
    	 {
    		 ComShowMessage(OBJECT_ERROR);
    	 }
    	 else
    	 {
    		 ComShowMessage(e.message);
    	 }
     }
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage()
{
    for(i=0;i<sheetObjects.length;i++){
    //khlee- Preferences change the name of the function to start
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
    //khlee- The final configuration functions added
        ComEndConfigSheet(sheetObjects[i]);
    }
    //sheetObjects[0].RowEditable(1) = false;
    var form=document.form;
    var cust_seq=form.origin_cust_seq.value;
    if(cust_seq.length != 6){ form.cust_seq.value=funcLPad(cust_seq, '0', 6);}
    else{ form.cust_seq.value=form.origin_cust_seq.value;}
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
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
		case "sheet1":      //sheet1 init
			with (sheetObj)
			{
	        
		        var HeadTitle1="|Sel.|Seq|Reference|Fax|E-mail|OFC|User ID|Updated||||";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        (headCount, 0, 0, true);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cntc_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:700 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fax_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		               {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"cntc_eml",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:150 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cmdt_cntc_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		        SetCountPosition(0);
		        SetSheetHeight(142);

			}
		break;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function doActionIBSheet(sheetObj,formObj,sAction)
{
    //sheetObj.ShowDebugMsg = false;
    switch(sAction)
    {
    	case IBSEARCH:      //Retrieve
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.DoSearch("ESM_BKG_1044GS.do", FormQueryString(formObj) );
			{
				//alert(sheetObj.CellValue(i, "usr_nm"));
				sheetObj.SetToolTipText(i, "upd_usr_id",sheetObj.GetCellValue(i, "usr_nm"));
			}
			break;
		case MULTI:        //Save
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=MULTI;
			var sParam=ComGetSaveString(sheetObj);
			if (sParam == "")
			{
				ComShowCodeMessage("BKG00233");
				return;
			}
			sParam += "&" + FormQueryString(formObj);
			sheetObj.DoSave("ESM_BKG_1044GS.do", FormQueryString(formObj));			
			break;
    }
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction)
{
	switch(sAction)
	{
		case IBSEARCH:
		break;
		case MULTI:
			//Email address validation
			var idx=1;
			var focusRow=1;
			var validate=true;
			for(idx=2;idx<sheetObj.RowCount();idx++)
			{
				if(sheetObj.GetRowStatus(idx) == 'D') 
					continue;
				var email_text=sheetObj.GetCellValue(idx, sheetObj.SaveNameCol("cntc_eml"));
				if(!emailAddrValidate(email_text) && email_text != '')
				{
					ComShowCodeMessage("BKG00366");
					focusRow=idx;
					sheetObj.SetCellValue(focusRow, sheetObj.SaveNameCol("cntc_eml"),"");
					validate=false;
					break;
				}
				if(email_text.length > 150)
				{
					ComShowCodeMessage("BKG00107");
					validate=false;
					focusRow=idx;
					break;
				}
				var remrk_text=sheetObj.GetCellValue(idx, sheetObj.SaveNameCol("cntc_rmk"));
				if(remrk_text.length > 700)
				{
					ComShowCodeMessage("BKG00107");
					validate=false;
					focusRow=idx;
					break;
				}
			}
			if(!validate)
			{
				sheetObj.SetSelectRow(focusRow);
				return false;
			}
		break;
	}
    return true;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcDeleteRow(sheetObj)
{
	var idx=1;
	var col=sheetObj.SaveNameCol("sel");
	while(idx <= sheetObj.RowCount())
	{
		if(sheetObj.GetCellText(idx, col) == '1')
		{
			if(sheetObj.GetRowStatus(idx) == 'I')
			{
				//sheetObj.RowStatus(idx) = 'D';
				sheetObj.RowDelete(idx,false);
				continue;
			}
			else
			{
				sheetObj.SetRowStatus(idx,'D');
				sheetObj.SetRowHidden(idx,1);
			}
		}
		idx ++;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcAddRow(sheetObj)
{
	var row = sheetObj.DataInsert(-1);
	var ofc_cd=sheetObj.SaveNameCol("ofc_cd");
	var upd_dt=sheetObj.SaveNameCol("upd_dt");
	var usr_id=sheetObj.SaveNameCol("upd_usr_id");
//	var sel=sheetObj.SaveNameCol("sel");
//	var cust_cnt_cd=sheetObj.SaveNameCol("cust_cnt_cd");
//	var cust_seq=sheetObj.SaveNameCol("cust_seq");
//	var cmdt_cntc_seq=sheetObj.SaveNameCol("cmdt_cntc_seq");
	//var row = sheetObj.RowCount() - 1;
	sheetObj.SetCellValue(row, "ofc_cd",document.form.office.value);
	sheetObj.SetCellValue(row, "cust_cnt_cd",document.form.cust_cnt_cd.value);
	sheetObj.SetCellValue(row, "cust_seq",document.form.cust_seq.value);
	sheetObj.SetCellEditable(row, ofc_cd,0);
	sheetObj.SetCellEditable(row, upd_dt,0);
	sheetObj.SetCellEditable(row, usr_id,0);
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function emailAddrValidate(sVal)
{
    try
    {
        var format=/^\s*[\w\~\-\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
        return (sVal.search(format) != -1);
    }
    catch(err)
    {
    	ComFuncErrMsg(err.message);
    }
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcSearch()
{
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcLPad(src, fit, fixLength)
{
	if(src.length >= fixLength) return src.substring(0, fixLength);
	var gap=fixLength - src.length;
	var temp=src;
	for(var i=0;i<gap;i++)
	{
		src=fit + src;
	}
	return src;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function funcRPad(src, fit, fixLength)
{
	if(src.length >= fixLength) return src.substring(0, fixLength);
	var gap=fixLength - src.length;
	var temp=src;
	for(var i=0;i<gap;i++)
	{
		src=src + fit;
	}
	return src;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function sheet1_OnSaveEnd(sheetObj, errMsg){
    if(errMsg != ""){
	}
}
