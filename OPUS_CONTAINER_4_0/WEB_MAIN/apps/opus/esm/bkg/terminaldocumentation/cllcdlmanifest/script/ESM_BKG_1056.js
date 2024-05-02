/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_1056.js
*@FileTitle : Container Loading List_Summary_SPP List
 *@author : CLT
 *@version : 1.0
 *@since : 2014.04.24
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
  MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
  Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
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
     /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
     var sheetObject1=sheetObjects[0];
     /*******************************************************/
     var formObj=document.form;
     try 
     {
    	 var srcName=ComGetEvent("name");
    	 switch(srcName) 
    	 {
    	 	case "btn_Add":
    	 		addRows(sheetObject1);
				break;
    	 	case "btn_Delete":
    	 		deleteRows(sheetObject1);
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
    	 	case "btn_Select":
    	 		selectItem(sheetObject1, formObj);
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
    		 ComShowMessage(e);
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
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    funcSetDefault();
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * setting sheet initial values and header
 * 
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) 
{
	var cnt=0;
	switch(sheetObj.id) 
	{
		case "sheet1":      //sheet1 init
		    with(sheetObj)
	        {	      
		      
		      var HeadTitle1="|Sel.|Type|Name||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
              {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"attr_ctnt1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
              {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cstms_div_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cstms_div_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
              {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetColProperty("attr_ctnt1", {ComboText:"TO|FM", ComboCode:"TO|FM"} );
		      SetSheetHeight(162);
	            }
		break;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
function doActionIBSheet(sheetObj,formObj,sAction) 
{
    sheetObj.ShowDebugMsg(false);
    switch(sAction) 
    {
    	case IBSEARCH:      //retrieve
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		formObj.f_cmd.value=SEARCH;
    		sheetObj.SetWaitImageVisible(0);
    		ComOpenWait(true);
    		sheetObj.DoSearch("ESM_BKG_1056GS.do", FormQueryString(formObj) );
			break;
		case MULTI:        //save
			formObj.f_cmd.value=MULTI;
    		sheetObj.SetWaitImageVisible(0);
    		ComOpenWait(true);
			var sParam=ComGetSaveString(sheetObj);
			sParam += "&" + FormQueryString(formObj);
			sheetObj.DoSave("ESM_BKG_1056GS.do", FormQueryString(formObj));
			break;
    }
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	ComOpenWait(false);
}
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
	ComOpenWait(false);
	if(state == 'S')
	{
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
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
			break;
	}
    return true;
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Row Delete : deleteflag = Y -> Update
 */
function deleteRows(sheetObj)
{
	var idx=1;
	var col=sheetObj.SaveNameCol("sel");
	var flg=sheetObj.SaveNameCol("delt_flg");
	var selectok=false;

	while(idx <= sheetObj.LastRow())
	{
		if(sheetObj.GetCellText(idx, col) == '1')
		{
			selectok=true;
			if(sheetObj.GetRowStatus(idx) == 'I')
			{
				sheetObj.RowDelete(idx, false);
				continue;
			}
			else
			{
				sheetObj.SetRowStatus(idx,'D');
				sheetObj.SetCellText(idx, flg ,'Y');
				sheetObj.SetRowHidden(idx,1);
			}
		}
		idx ++;
	}
	if(!selectok)
	{
		ComShowCodeMessage("BKG00546");
		return;
	}
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * Sheet addRow: Default setting
 */
function addRows(sheetObj)
{
	sheetObj.DataInsert(-1);

	sheetObj.SetCellText(sheetObj.LastRow(), "cstms_div_id",'CLL_SPP_CD');
	sheetObj.SetCellText(sheetObj.LastRow(), "cnt_cd",'KR');
	sheetObj.SetCellText(sheetObj.LastRow(), "delt_flg",'N');
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * item check and Select, show value
 */
function selectItem(sheetObj, formObj)
{
	var idx=1;
	var settingTO="";
	var settingFM="";
	var col=sheetObj.SaveNameCol("sel");
	var typ=sheetObj.SaveNameCol("attr_ctnt1");
	var set=sheetObj.SaveNameCol("attr_ctnt2");
	var selectok=false;
	
	while(idx <= sheetObj.LastRow())
	{
		if(sheetObj.GetCellText(idx, col) == '1')
		{
			selectok=true;
			if(sheetObj.GetCellText(idx, typ) == 'TO')
			{
				settingTO=settingTO + ", " + sheetObj.GetCellText(idx, set);
			}
			else
			{
				settingFM=settingFM + ", " + sheetObj.GetCellText(idx, set);
			}
		}
		idx++;
	}
	if(!selectok)
	{
		ComShowCodeMessage("BKG00624");
		return;
	}
	settingTO=settingTO.substring(2);
	settingFM=settingFM.substring(2);
	if(opener != null)
	{
		if(settingTO.length > 0)
		{
			opener.form.setText1.value=settingTO;
		}
		if(settingFM.length > 0)
		{
			opener.form.setText2.value=settingFM;
		}
	}
  ComClosePopup(); 
}
//*********************************************************************************************
//*********************************************************************************************
//*********************************************************************************************
/**
 * In case of adding row according to EntryType value, set Default value
 */
function funcSetDefault()
{
	var form=document.form;
	if(form.entryTp.value == 'FM')
	{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].SetColProperty("attr_ctnt1", {ComboText:"TO|FM", ComboCode:"TO|FM"} );
	}
	else
	{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		sheetObjects[0].SetColProperty("attr_ctnt1", {ComboText:"TO|FM", ComboCode:"TO|FM"} );
	}
}
