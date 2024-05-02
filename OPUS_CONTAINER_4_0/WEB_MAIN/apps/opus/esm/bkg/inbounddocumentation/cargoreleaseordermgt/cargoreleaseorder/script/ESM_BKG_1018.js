/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   esm_bkg_1018.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
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
document.onclick=processButtonClick;
/**
 * Event handler processing by button name<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function processButtonClick()
{
    var sheetObject1=sheetObjects[0];
    var formObj=document.form;
    try
    {
        var srcName=ComGetEvent("name");
        switch(srcName)
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1,formObj,IBSEARCH);
            break;
            case "btn_Close":
                if(formObj.old_rmk.value != formObj.do_prn_rmk.value)
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
            case "btn_Save":
                if(doActionIBSheet(sheetObject1,formObj,MODIFY))
                {
                	ComClosePopup(); 
                }
            break;
        }
    }
    catch(e)
    {
        if( e == "[object Error]") ComShowMessage(OBJECT_ERROR);
        else                        ComShowMessage(e.message);
    }
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheet_obj 
 * @return void
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function loadPage()
{
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
//    axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    axon_event.addListenerForm("KeyDown","obj_KeyDown", document.form);
    if (document.getElementById("do_no").value != "") {
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}
/**
 * handling process for input validation<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 
 * @param {Object} formObj 
 * @param {int} sAction 
 * @return boolean 
 * @author
 * @version 
 */
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
    }
    return true;
}
/**
 * setting sheet initial values and header<br>
 * <br>
 * adding case as numbers of counting sheets<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj
 * @param {int} sheetNo 
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function initSheet(sheetObj,sheetNo)
{
    var cnt=0;
    switch(sheetNo)
    {
        case 1:      //sheet1 init
            with (sheetObj)
            {
	            var HeadTitle="|Seq|do_no|do_no_split|ofc_cd|bkg_no|usr_id|do_prn_rmk";
	            var prefix="sheet1_";
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                      {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no_split", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_prn_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
	            SetSheetHeight(100);
            }
        break;
    }
}
/**
 * handling sheet process<br><br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} sheetObj 
 * @param {Object} formObj 
 * @param {int} sAction 
 * @return void
 * @author
 * @version 
 */
function doActionIBSheet(sheetObj,formObj,sAction)
{
    //sheetObj.ShowDebugMsg = false;
    var status='';
    switch(sAction)
    {
        case IBSEARCH:      //retrieve
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("ESM_BKG_1018GS.do", FormQueryString(formObj )+ "&"+ ComGetPrefixParam("sheet1_"));
			return;
            status=sheetObj.GetEtcData('status');
			alert(status);
            if(status == 'no_data')
            {
                ComShowCodeMessage("BKG00095");
                ComOpenWait(false);
                formObj.do_prn_rmk.value='';
                return;
            }
            //DO_PRN_RMK
            formObj.do_prn_rmk.value=sheetObj.GetEtcData('do_prn_rmk');
            formObj.old_rmk.value=formObj.do_prn_rmk.value;
            break;
        case MODIFY:
            formObj.f_cmd.value=MULTI;
            var sXml=sheetObj.GetSaveData("ESM_BKG_1018GS.do", FormQueryString(formObj));
            status=ComGetEtcData(sXml, 'status');
            if(status == 'ok')
            {
                ComShowCodeMessage("BKG00166");
                formObj.old_rmk.value=formObj.do_prn_rmk.value;
                return true;
            }
            else
            {
                ComShowCodeMessage("BKG00167");
                return false;
            }
            break;
    }
}
/**
 * 폼 객체에다 키보드 이벤트를 수행할 경우 발생한다. occured when keyboard event proceed in form object<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author
 * @version 
 */
function obj_KeyDown()
{
    var srcName=ComGetEvent("name").substring(10);
    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    var srcValue=window.event.srcElement.getAttribute("value");
    fncTextareaMaxLine(window.event.srcElement, 5);
}
/**
 *  not to over text Area' MAX length.
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {Object} obj 
 * @param {int} maxLine 
 * @return void
 * @author
 * @version 
 */
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
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	var formObj=document.form;
	if(sheetObj.RowCount()> 0){
		formObj.do_prn_rmk.value=sheetObj.GetCellValue( 1,"sheet1_" + "do_prn_rmk");
		formObj.old_rmk.value=formObj.do_prn_rmk.value;
	}else{
		formObj.do_prn_rmk.value="";
		formObj.old_rmk.value="";
	}
}
