/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0130.js
*@FileTitle  : CndManifestListDownload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var dataRetrieved=false;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/** 
 * Event handler processing by button name
 */
function processButtonClick()
{
    /*******************************************************/
    var formObj=document.form;
    try 
    {
        var srcName=ComGetEvent("name");
        switch(srcName) 
        {
            case "btn_Retrieve":
                doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);
                break;
            case "btn_Save":
                doActionIBSheet(sheetObjects[0],formObj, MODIFY);
                break;
            case "btn_Close":
                if(isDataChanged())
                {
                	// Data was changed. Do you want to save it?
                	if(ComShowCodeConfirm("BKG95002")){  ComClosePopup(); }
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
        if(e == "[object Error]") 
        {
            ComShowMessage(OBJECT_ERROR);
        } 
        else 
        {
            ComShowMessage(e.message);
        }
    }
}
/**
 * handling process for input validation 
 * @param {Object} sheetObj
 * @param {Object} formObj 
 * @param {int} sAction
 */
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
        switch(sAction)
        {
        case IBSEARCH:
               if (!ComChkObjValid(do_no)) return false;
            break;
        case MODIFY:
            if(!dataRetrieved)
            {
            	// D/O was not Assign yet !!
                ComShowCodeMessage("BKG00170");
                return false;
            }
            if(old_do_no.value != do_no.value)
            {
            	// Searching option was changed. Please retrive first.
                ComShowCodeMessage("BKG03053");
                return false;
            }
            if(old_rcvr_co_nm.value  != rcvr_co_nm.value)     return true;
            if(old_cntc_phn_no.value != cntc_phn_no.value)     return true;
            if(old_pic.value         != pic.value)             return true;
            if(old_act_cnee_nm.value != act_cnee_nm.value)     return true;
            if(old_cust_ref_nm.value != cust_ref_nm.value)     return true;
            // Nothing has been changed after data is retrieved
            ComShowCodeMessage("BKG00797");
            return false;
            break;
        }
    }
    return true;
}
/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return {void}
 * @author
 * @version 2009.10.01
 */
function setSheetObject(sheet_obj)
{
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen<br>
 */
function loadPage() 
{
    for(i=0;i<sheetObjects.length;i++)
    {
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    axon_event.addListenerFormat("keypress","obj_KeyPress", document.form);
    axon_event.addListener("keydown","ComKeyEnter", "do_no");
    if(document.getElementById("do_no").value !='' ){
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
}
/**
 * setting sheet initial values and header<br>
 * param : sheetObj, sheetNo<br>
 * adding case as numbers of counting sheets<br>
 * @param {Object} sheetObj
 * @param {int} sheetNo
 */
function initSheet(sheetObj,sheetNo) 
{
    var cnt=0;
    switch(sheetNo) 
    {
        case 1:      //sheet1 init
            with (sheetObj) 
            {
            var HeadTitle="|Seq|MRN|VVD|POL|POD|Office|User ID|B/L Count|AC|Date|Date";
            var prefix="";
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
                {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mrn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"office",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"userid",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"blcount", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            InitColumns(cols);
            SetEditable(1);
            SetVisible(false);
            }
        break;
    }
}
/**
 * handling sheet process
 * @param {Object} sheetObj
 * @param {Object} formObj
 * @param {String} sAction
 * @param {String} CondParam
 * @param {int} pageNo
 */
function doActionIBSheet(sheetObj,formObj,sAction) 
{
    var status='';
    switch(sAction) 
    {
    case IBSEARCH:     
        if(!validateForm(sheetObj,formObj,sAction)) return;
        formObj.f_cmd.value=SEARCH;
        sheetObj.DoSearch("ESM_BKG_0130GS.do", FormQueryString(formObj), {Sync:2});
        status=sheetObj.GetEtcData('status');
        if(status == 'no_data')
        {
            // No data found.
            ComShowCodeMessage("BKG00095");
            return;
        }
        else
        {
        	formObj.bkg_no.value=sheetObj.GetEtcData('bkg_no');
        	formObj.rcvr_co_nm.value=sheetObj.GetEtcData('rcvr_co_nm');
        	formObj.cntc_phn_no.value=sheetObj.GetEtcData('cntc_phn_no');
        	formObj.pic.value=sheetObj.GetEtcData('pic');
        	formObj.act_cnee_nm.value=sheetObj.GetEtcData('act_cnee_nm');
        	formObj.cust_ref_nm.value=sheetObj.GetEtcData('cust_ref_nm');
        	formObj.order_flg.value=sheetObj.GetEtcData('order_flg');
        	formObj.old_do_no.value=formObj.do_no.value;
        	formObj.old_rcvr_co_nm.value=formObj.rcvr_co_nm.value;
        	formObj.old_cntc_phn_no.value=formObj.cntc_phn_no.value;
        	formObj.old_pic.value=formObj.pic.value;
        	formObj.old_act_cnee_nm.value=formObj.act_cnee_nm.value;
        	formObj.old_cust_ref_nm.value=formObj.cust_ref_nm.value;
            dataRetrieved=true;
        }
        break;
    case MODIFY:
        if(!validateForm(sheetObj,formObj,MODIFY)) return;
        formObj.f_cmd.value=MULTI;
        var sXml=sheetObj.GetSaveData("ESM_BKG_0130GS.do", FormQueryString(formObj));
        status=ComGetEtcData(sXml, 'status');
        if(status == 'ok')
        {
        	// Data Saved Successfully!!
            ComShowCodeMessage("BKG00166");
            formObj.old_rcvr_co_nm.value=formObj.rcvr_co_nm.value     
            formObj.old_cntc_phn_no.value=formObj.cntc_phn_no.value
            formObj.old_pic.value=formObj.pic.value
            formObj.old_act_cnee_nm.value=formObj.act_cnee_nm.value
            formObj.old_cust_ref_nm.value=formObj.cust_ref_nm.value
            ComClosePopup(); 
            return true;
        }
        else
        {
        	// Data Save Action Failed!!
            ComShowCodeMessage("BKG00167");
            return false;
        }
        break;
    }
}
/**
 * handling data changed
 */
function isDataChanged()
{
    var formObj=document.form;
    try
    {
        if(formObj.old_rcvr_co_nm.value  != formObj.rcvr_co_nm.value) return true;     
        if(formObj.old_cntc_phn_no.value != formObj.cntc_phn_no.value)return true;
        if(formObj.old_pic.value         != formObj.pic.value)          return true;
        if(formObj.old_act_cnee_nm.value != formObj.act_cnee_nm.value)return true;
        if(formObj.old_cust_ref_nm.value != formObj.cust_ref_nm.value)return true;
        return false;
    }
    catch(e)
    {
        return false;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
	sheetObj.SetCellBackColor(1, 4, "#FFFF6F");
}


//function sheet1_OnSearchEnd(sheetObj,Code, ErrMsg) {
//	with (sheetObj) {
//		sheetObj.SetCellBackColor(1, 2, "#FFFF6F");
//		
//		ColBackColor(5) = WebColor("#FFFF6F");
//		ColBackColor(6) = WebColor("#FFFF6F");
//		ColBackColor(7) = WebColor("#FFFF6F");
//		ColBackColor(9) = WebColor("#FFFF6F");
//	}
//}

