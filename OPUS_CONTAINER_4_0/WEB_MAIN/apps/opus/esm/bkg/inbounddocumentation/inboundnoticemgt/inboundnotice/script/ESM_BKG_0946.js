/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0946.js
*@FileTitle  : Group A/N Merge Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/01
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class esm_bkg_0946 : Defining logic script for esm_bkg_0946 screen
 */
function esm_bkg_0946() {
    this.processButtonClick=tprocessButtonClick;
    this.setSheetObject=setSheetObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;
    this.initControl=initControl;
    this.doActionIBSheet=doActionIBSheet;
    this.setTabObject=setTabObject;
    this.validateForm=validateForm;
    this.obj_keypress=obj_keypress;
}
/* Global Variables */
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var t1beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var opener=window.dialogArguments;
if (!opener)  opener=window.opener;  //이 코드 추가할것
if (!opener) opener=parent; //이 코드 추가할것
/* Event handler defined process to button click event */
document.onclick=processButtonClick;
/* Event handler is branch processing by name of button */
function processButtonClick(){
	/***** Assignment sheet in case of over 2 by tab****/
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    switch(srcName) {
        case "btn_row_delete":
            alert(srcName);
            break;
        case "btn_form_setup":
            fncFormSetup(sheetObject1,formObject);
            break;
        case "btn_fax":
            fncFax(sheetObject1,formObject);
            break;
        case "btn_email":
            fncEmail(sheetObject1,formObject);
            break;
        case "btn_down_excel":
             sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0])});
            break;
        case "btn_close":
        	ComClosePopup(); 
            break;
        case "btn_preview":
            for(var i=0;i<=sheetObjects[0].RowCount();i++){
                sheetObjects[0].SetRowStatus(i,"U");
            }
            formObject.f_cmd.value=MULTI03;
            var saveStr=sheetObjects[0].GetSaveString(false);
            saveStr += "&" + FormQueryString(formObject);
            if(formObject.div_cd[0].checked){//Combine
                fncCallCombineRD(sheetObjects[0],formObject);
            }else if(formObject.div_cd[1].checked){//Separate
                fncCallSeparateRD(sheetObjects[0],formObject);
            }else{
                return;
            }
            break;
    } // end switch
}
/**
 * Register as an IBSheet Object array
 * This is called from comSheetObject(id)
 * Process can add in case of future necessity to process other items
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Initializing sheet
 * To implement onLoad event of body tag
 * Add functionality to after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    if(strGubun == "C"){
        formObj.gubun[0].checked=true;
    }else if(strGubun == "S"){
        formObj.gubun[1].checked=true;
    }
    

    if (!opener)  opener=window.opener;  //이 코드 추가할것
    if (!opener) opener=parent; //이 코드 추가할것
//    
//    alert(opener.form.sch_tp[0].value);
    if(opener.form.sch_tp[0].checked){
        formObj.sch_tp.value=opener.form.sch_tp[0].value;
    }
    if(opener.form.sch_tp[1].checked){
        formObj.sch_tp.value=opener.form.sch_tp[1].value;
    }else if(opener.form.sch_tp[2].checked){
        formObj.sch_tp.value=opener.form.sch_tp[2].value;
    }
    formObj.vvd.value=opener.form.vvd.value;
    formObj.vps_eta_dt_start.value=opener.form.vps_eta_dt_start.value;
    formObj.vps_eta_dt_end.value=opener.form.vps_eta_dt_end.value;
    formObj.pod_cd.value=opener.form.pod_cd.value;
    formObj.del_cd.value=opener.form.del_cd.value;
    formObj.pol_cd.value=opener.form.pol_cd.value
    formObj.bl_no.value=opener.form.bl_no.value;
    formObj.cust_cnt_cd.value=opener.form.cust_cnt_cd.value;
    formObj.cust_seq.value=opener.form.cust_seq.value;
    formObj.cust_ref_no.value=opener.form.cust_ref_no.value;  // po_no
    
    formObj.sc_no.value=opener.form.sc_no.value;
strCustNm  =opener.sheetObjects[0].GetCellValue(opener.sheetObjects[0].GetSelectRow(),"t1sheet1_"+"cust_nm");
formObj.diff_rmk.value=opener.sheetObjects[0].GetCellValue(opener.sheetObjects[0].GetSelectRow(),"t1sheet1_"+"diff_rmk");
formObj.rvis_flg.value=opener.sheetObjects[0].GetCellValue(opener.sheetObjects[0].GetSelectRow(),"t1sheet1_"+"rvis_flg");
	if(opener.form.ts_flg.checked){
		formObj.ts_flg.value="Y";
	}else{
		formObj.ts_flg.value="N";
	}
    formObj.fax_no.value=strFaxNo;
    formObj.email.value=strEmail;
    // Select Line Prarmeter
    formObj.cust_cnt_cd.value=strCustCntCd;
    if (strCustSeq != null && strCustSeq != "" && strCustSeq != "0") {
        formObj.cust_seq.value=fncSeqTo6(strCustSeq);
        formObj.cust_nm_view.value=strCustNm;
    } else {
        formObj.cust_seq.value="";
    }
    formObj.sc_no.value=strScNo;
    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	fncFaxEmlInsert();
}
/**
	 * Initializing sheet. Defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
	 * Composition a initial module in case of multi sheet
	 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
    case "sheet1":
    with(sheetObj){

   var HeadTitle1="|Seq.|B/L No.|CNTR QTY|Customs Descirption|VVD|POL|POD|ETA|Del.|bkg_cust_tp_cd|bkg_no|cust_cnt_cd|cust_seq|bkg_cust_tp_cd_odr|cust_nm|diff_rmk|rvis_flg|ts_flg";
   var headCount=ComCountHeadTitle(HeadTitle1);
   var prefix="sheet1_";

   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
   InitHeaders(headers, info);

   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
             {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"knt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cust_tp_cd_odr", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"rvis_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
    
   InitColumns(cols);

   SetEditable(1);
   SetColProperty(prefix+"eta_dt", {Format:"####-##-####:##"} );
   SetWaitImageVisible(0);
      SetCountFormat("[SELECTDATAROW / SEARCHROWS]");
      SetSheetHeight(122);
   }
   break;
    case "t1sheet1":      //t1sheet1 init
   with(sheetObj){


var HeadTitle1="";
HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||One Time Only";
HeadTitle1 += "";//FAX
HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||One Time Only";
var prefix="t1sheet1_";

SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
var headers = [ { Text:HeadTitle1, Align:"Center"} ];
InitHeaders(headers, info);

var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntc_eml5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

InitColumns(cols);

SetEditable(1);
SetCountPosition(0);
SetEllipsis(1);
SetWaitImageVisible(0);
SetEditable(0);
//                 InitDataValid(0, prefix + "fax_no1", vtNumericOther, "-,");
//                 InitDataValid(0, prefix + "fax_no2", vtNumericOther, "-,");
//                 InitDataValid(0, prefix + "fax_no3", vtNumericOther, "-,");
//                 InitDataValid(0, prefix + "fax_no4", vtNumericOther, "-,");
//                 InitDataValid(0, prefix + "fax_no5", vtNumericOther, "-,");
                 SetColProperty(0 ,prefix + "fax_no1" , {AcceptKeys:"N|[-,]"});
                 SetColProperty(0 ,prefix + "fax_no2" , {AcceptKeys:"N|[-,]"});
                 SetColProperty(0 ,prefix + "fax_no3" , {AcceptKeys:"N|[-,]"});
                 SetColProperty(0 ,prefix + "fax_no4" , {AcceptKeys:"N|[-,]"});
                 SetColProperty(0 ,prefix + "fax_no5" , {AcceptKeys:"N|[-,]"});
SetShowButtonImage(2);
SetAutoRowHeight(0);
SetSheetHeight(122);
}
break;




    }
}
/* Processing Sheet */
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {
        case IBSEARCH:      //retrieve
            ComOpenWait(true);
            if(sheetObj.id == "sheet1"){
                formObj.f_cmd.value=SEARCH01;
                var param="";
                if(formObj.gubun[0].checked){
                    param += "gubun=C";
                }else if(formObj.gubun[1].checked){
                    param += "gubun=S";
                }
                param += "&cust_cnt_cd="+formObj.cust_cnt_cd.value;
                param += "&cust_seq="+formObj.cust_seq.value;
                param += "&cust_nm="+formObj.cust_nm.value;
                param += "&sc_no="+formObj.sc_no.value;
                 sheetObj.DoSearch("ESM_BKG_0946GS.do"
                    ,FormQueryString(formObj)
                    + "&"
                    + param
                    + "&"
                    + ComGetPrefixParam("sheet1_")
                    );
            }
            break;
        case IBSAVE:        //save
            break;
        case IBINSERT:      //insert
            break;
    }
}
/**
 * Checking validation of input value
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        }
    return true;
}
function initControl() {
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
function sheet1_OnSaveEnd(sheetObj, errMsg){
//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
/**
 * moving focus
 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){
    if(srcObj.value.length == maxLength){
        nextObj.focus();
    }
}
/**
 * focusing out in seq
 * @param obj
 * @return
 */
function fncCustSeqBlur(obj){
    var orgV=obj.value;
    if(orgV.length < 1){
        obj.value="";
    }else{
        obj.value=fncSeqTo6(orgV);
    }
}
/**
 * @param str
 * @return
 */
function fncSeqTo6(str){
    var currentObjLen=str.length;
    var retStr="";
    for(var i=0;i<6-currentObjLen;i++){
        retStr += "0";
    }
    return retStr + str;
}
/**
*
**/
function fncFormSetup(sheetObj,formObj){
    //alert(sheetObj.CheckedRows("chk"));
    if(sheetObj.RowCount()== 0){
        //showing message in case of not selecting
        ComShowCodeMessage("BKG00149");
        return;
    }
    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_1020_POP.do?";
    param += "1=1";
    param += "";
    param += "&pgmNo=ESM_BKG_1020";
    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1020",860,400,true);
//    ComOpenPopup(goUrl + param, 540, 430, "callBack01020", '0,1,1,1,1,1,1', true);
    
}

/**
* Fax transmit
**/
function fncFax(sheetObj,formObj){
    //alert(sheetObj.CheckedRows("chk"));
    for(var i=0;i<=sheetObj.RowCount();i++){
        sheetObj.SetRowStatus(i,"U");
    }
    formObj.f_cmd.value=MULTI01;
    var sParam=FormQueryString(formObj);
    sparam=sParam + "&" + ComGetPrefixParam("sheet1_");
    //alert(sparam);
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(true);//progress
    sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
}
/**
* EMail transmit
**/
function fncEmail(sheetObj,formObj){
    for(var i=0;i<=sheetObj.RowCount();i++){
        sheetObj.SetRowStatus(i,"U");
    }
    formObj.f_cmd.value=MULTI02;
    var sParam=FormQueryString(formObj);
    sparam=sParam + "&" + ComGetPrefixParam("sheet1_");
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(true);//progress
    sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
}
/**
 * Processing function in case of error to result of retrieve
 * Defined by DataSheetObject.prototype.event_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj, errStr) {
    var maxRow=sheetObj.LastRow();
    //alert(document.form.rvis_flg.value);
    for (var i=maxRow; i >= 0; i --) {
        sheetObj.SetCellValue(i, "sheet1_" + "rvis_flg",document.form.rvis_flg.value);
        //    	alert(i + ":" + sheetObj.CellValue(i, "sheet1_" + "bkg_cust_tp_cd_odr"));
if (sheetObj.GetCellValue(i, "sheet1_" + "bkg_cust_tp_cd_odr") == "2") {
            sheetObj.SetRowHidden(i,1);
        } else {
    }
    }
    ComOpenWait(false);
}
/**********************************************************
* Combine select RD calling
**********************************************************/
function fncCallCombineRD(sheetObj,formObject){
    //variables
    var bkgNoStr="";
    var parentSheetObj=opener.sheetObjects[0];
    //booking no
    bkgNoStr=fncGetBkgNo(sheetObj);
    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
    + "ESM_BKG_0918"
    + ".mrd";
    var strArg="/rv ";
    //strArg += " form_grpNtcSeq['" + grpNtcSeq + "']";
    strArg += " form_bkgNo[(" + bkgNoStr + ")]";
    strArg += " form_usrId['" + strUsr_id + "']";
    strArg += " form_loclFlg['N']";
    strArg += " form_mainOnly['N']";
    strArg += " form_remarkCtnt['']";
    strArg += " form_rvisFlg['" + formObject.rvis_flg.value+ "']";
strArg += " form_usrTo['" + parentSheetObj.GetCellValue(parentSheetObj.GetSelectRow(),"t1sheet1_"+"cust_nm") + "']";
    strArg += " form_tsFlg['" + formObject.ts_flg.value + "']";
	strArg += " form_ofcCd['" + strOfc_cd + "']";
    formObject.com_mrdArguments.value=strArg;
    formObject.com_mrdTitle.value="Group Arrival Notice";
    formObject.com_mrdDisableToolbar.value="";
    formObject.com_mrdSaveDialogFileName.value="Group_Arrival_Notice";
    formObject.com_mrdSaveDialogFileExt.value="pdf";
    formObject.com_mrdBodyTitle.value="Group Arrival Notice";
    //ComOpenRDPopup();
    ComOpenRDPopup("dialogWidth:950px;dialogHeight:700px");
}
/**********************************************************
* Separate select RD calling
**********************************************************/
function fncCallSeparateRD(sheetObj,formObject){
	if (!opener) opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent;               // 기존 가이드 부분

    //variables
    var bkgNoStr="";
    var parentSheetObj=opener.sheetObjects[0];
    //booking no
    bkgNoStr=fncGetBkgNo(sheetObj);
    //getting RD info.
    formObject.f_cmd.value=SEARCH02;
    var sParam=FormQueryString(formObject);
    sParam += "&bkg_no=" + formObject.bkg_no.value;
    //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");
    //alert(sparam);
    //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
     var arrXml=parentSheetObj.GetSearchData("ESM_BKG_0381GS.do",sParam);
    //alert(arrXml);
    var mrdId=ComGetEtcData(arrXml, "MRD_ID");
    var loclLangFlg=ComGetEtcData(arrXml, "LOCL_LANG_FLG");
    var comParam=ComGetEtcData(arrXml, "COM_PARAM");
    //return;
    if(mrdId == ""){
        ComShowCodeMessage("BKG40050");
        return;
    }
    if(formObject.bkg_no.value == ""){
        ComShowCodeMessage("BKG00149");
        return;
    }
    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
    + mrdId
    + ".mrd";
    var strArg="/rv ";
    strArg += " form_bkgNo[(" + bkgNoStr + ")]";
    strArg += " form_usrId['" + strUsr_id + "']";
    strArg += " form_loclFlg['" + loclLangFlg + "']";
strArg += " form_chgDpFlg['" + parentSheetObj.GetCellValue(parentSheetObj.GetSelectRow(),"t1sheet1_"+"chg_dp_flg") + "']";
strArg += " form_rvisFlg['" + parentSheetObj.GetCellValue(parentSheetObj.GetSelectRow(),"t1sheet1_"+"rvis_flg")+ "']";
strArg += " form_usrTo['" + parentSheetObj.GetCellValue(parentSheetObj.GetSelectRow(),"t1sheet1_"+"cust_nm") + "']";
    strArg += " form_tsFlg['" + formObject.ts_flg.value + "']";
	strArg += " form_ofcCd['" + strOfc_cd + "']";
    strArg += " form_remarkCtnt['']";
    strArg += " " + comParam;
    formObject.com_mrdArguments.value=strArg;
    formObject.com_mrdTitle.value="Group Arrival Notice";
    formObject.com_mrdDisableToolbar.value="";
    formObject.com_mrdBodyTitle.value="Group Arrival Notice";
    ComOpenRDPopupModal();
}
/**********************************************************
* combining bkg_no
**********************************************************/
function fncGetBkgNo(sheetObj){
    var bkgNoStr="";
    for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow(); i++){
        bkgNoStr += "'" + sheetObj.GetCellText(i,"sheet1_"+"bkg_no") + "'";
        if(i == (sheetObj.rows -1)     ){
            break;
        }
        bkgNoStr += ",";
    }
    return bkgNoStr.substring(0,bkgNoStr.length -1);
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * Setting IBTab Object Initial.
 * Tab ID is tab1,tab2,...
 * InitTab() function is called before the loadPage() function call from setupPage() function.
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt=0 ;
InsertItem( "Fax" , "");
InsertItem( "E-Mail" , "");
                }
            break;
    }
}
/**
 * onChange event of tab1
 * Implementing defined function from IBSheetConfig.js
 */ 
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
    //alert(nItem);
    var sheetObj=sheetObjects[1];
    var prefix="t1sheet1_";
    sheetObj.RenderSheet(0);
    if(nItem == 0){//Fax
        sheetObj.SetColHidden(prefix + "fax_evnt_flg1",0);
        sheetObj.SetColHidden(prefix + "fax_no1",0);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg2",0);
        sheetObj.SetColHidden(prefix + "fax_no2",0);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg3",0);
        sheetObj.SetColHidden(prefix + "fax_no3",0);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg4",0);
        sheetObj.SetColHidden(prefix + "fax_no4",0);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg5",0);
        sheetObj.SetColHidden(prefix + "fax_no5",0);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg1",1);
        sheetObj.SetColHidden(prefix + "ntc_eml1",1);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg2",1);
        sheetObj.SetColHidden(prefix + "ntc_eml2",1);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg3",1);
        sheetObj.SetColHidden(prefix + "ntc_eml3",1);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg4",1);
        sheetObj.SetColHidden(prefix + "ntc_eml4",1);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg5",1);
        sheetObj.SetColHidden(prefix + "ntc_eml5",1);
		ComBtnEnable("btn_fax");
		ComBtnDisable("btn_email");
    }else if(nItem == 1){//E-Mail
        sheetObj.SetColHidden(prefix + "fax_evnt_flg1",1);
        sheetObj.SetColHidden(prefix + "fax_no1",1);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg2",1);
        sheetObj.SetColHidden(prefix + "fax_no2",1);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg3",1);
        sheetObj.SetColHidden(prefix + "fax_no3",1);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg4",1);
        sheetObj.SetColHidden(prefix + "fax_no4",1);
        sheetObj.SetColHidden(prefix + "fax_evnt_flg5",1);
        sheetObj.SetColHidden(prefix + "fax_no5",1);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg1",0);
        sheetObj.SetColHidden(prefix + "ntc_eml1",0);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg2",0);
        sheetObj.SetColHidden(prefix + "ntc_eml2",0);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg3",0);
        sheetObj.SetColHidden(prefix + "ntc_eml3",0);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg4",0);
        sheetObj.SetColHidden(prefix + "ntc_eml4",0);
        sheetObj.SetColHidden(prefix + "eml_evnt_flg5",0);
        sheetObj.SetColHidden(prefix + "ntc_eml5",0);
		ComBtnEnable("btn_email");
		ComBtnDisable("btn_fax");
    }
    beforetab=nItem;
    //alert('beforetab' + beforetab);
    sheetObj.RenderSheet(1);
    /*
     * 1개의 쉬트라서 이하 코드 의미없음
    objs[nItem].style.display="Inline";
    objs[beforetab].style.display="none";
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    */
}
function fncFaxEmlInsert(){
	var form=document.form;
	var sheetObj=sheetObjects[1];
	var prefix="t1sheet1_";
	sheetObj.DataInsert();
	var faxNos=form.fax_no.value.split(",");
	for(var x=0;x<faxNos.length;x++){
		var faxInfo=faxNos[x].split("|");
		var faxFlg=faxInfo[0];
		var faxNo=faxInfo[1];
		//alert(faxFlg);
		//alert(faxNo);
		sheetObj.SetCellValue(1,prefix + "fax_evnt_flg"+(x+1),faxFlg);
		sheetObj.SetCellValue(1,prefix + "fax_no"+(x+1),faxNo);
	}
	var emailInfos=form.email.value.split(",");
	for(var x=0;x<emailInfos.length;x++){
		var emailInfo=emailInfos[x].split("|");
		//alert(emailInfo.length);
		var emailFlg=emailInfo[0];
		var email=emailInfo[1];
		sheetObj.SetCellValue(1,prefix + "eml_evnt_flg"+(x+1),emailFlg);
		sheetObj.SetCellValue(1,prefix + "ntc_eml"+(x+1),email);
	}
}
function sheet1_OnSaveEnd(sheetObj, errMsg){
    ComOpenWait(false);
    //sheetObj.WaitImageVisible = true;
    if(errMsg != ""){
	}
}
